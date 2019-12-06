/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.zcy.cms.pathTopic;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * CaculateRegionIdBL
 *
 * @author zhaochengye
 * @date 2019/12/6
 */
@Service
public class CalculateRegionBL implements ApplicationListener<ApplicationStartedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(CalculateRegionBL.class);

    @Resource
    private JiupiRegionBL jiupiRegionBL;

    private Map<Integer, String> regionPathMap;

    private ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = Executors.defaultThreadFactory().newThread(r);
            thread.setName("changeDict" + "-" + thread.getName());
            return thread;
        }
    });

    /**
     * 减法:resources - targets
     *
     * @param sourceRegionIdSet 被减数 前提：必须本身不存在包含关系的两条路径。
     * @param targetRegionIdSet 减数 前提：必须本身不存在包含关系的两条路径。
     * @return
     */
    public Set<Integer> reduceRegionTree(Set<Integer> sourceRegionIdSet, Set<Integer> targetRegionIdSet) {
        if (CollectionUtils.isNotEmpty(sourceRegionIdSet) && sourceRegionIdSet != null) {
            for (Integer regionId : targetRegionIdSet) {
                reduceRegionId(sourceRegionIdSet, regionId);
            }
        }
        return sourceRegionIdSet;
    }

    /**
     * 单个减
     *
     * @param sourceRegionIdSet
     * @param regionId
     */
    private void reduceRegionId(Set<Integer> sourceRegionIdSet, Integer regionId) {
        Iterator<Integer> iterator = sourceRegionIdSet.iterator();
        Set<Integer> temp = new HashSet<>();
        while (iterator.hasNext()) {
            String resource = getPath(iterator.next());
            String target = getPath(regionId);
            int deep = reducePath(resource, target);
            if (deep < 0) {
                iterator.remove();
            } else if (deep > 0) {
                String[] resourceArr = resource.split("\\.");
                Integer node = Integer.parseInt(resourceArr[resourceArr.length-1]);
                String lastPath = target.substring(target.indexOf(node + "."),target.length()-1);
                iterator.remove();
                getChildren(node, deep, temp, lastPath);
            }
        }
        //添加临时增加的节点
        sourceRegionIdSet.addAll(temp);
    }

    private String getPath(Integer sourceId) {
        if(regionPathMap == null){
            buildPathMap();
        }
        String path = regionPathMap.get(sourceId);
        return path == null ? "" : path ;
    }



    private void buildPathMap() {
        regionPathMap = jiupiRegionBL.listAllMallJiuPiRegion();
        //添加全国path
        regionPathMap.put(0,"0");
    }

    /**
     * path比较，根据结果来拆分或者移除或者不处理
     *
     * @param resource
     * @param target
     * @return
     */
    private int reducePath(String resource, String target) {
        //resource包含或者等于target,那么resource丢弃掉
        if (resource.startsWith(target)) {
            return -1;
        }
        //target包含resource，那么就拆
        if (target.startsWith(resource)) {
            return target.replace(resource+".", "").split("\\.").length;
        }
        //resource和target互不相关,不用处理
        return 0;
    }

    /**
     * 拆分:
     * 1.获取子节点
     * 2.去掉target匹配节点
     * 3.添加到临时set
     */
    private void getChildren(int code, int deep, Set<Integer> temp, String lastPath) {
        Set<Integer> childrenPathSet = jiupiRegionBL.getChildrenRegionIdList(code);
        Integer curRegionId = Integer.parseInt(lastPath.split("\\.")[1]);
        childrenPathSet.remove(curRegionId);
        temp.addAll(childrenPathSet);
        if (deep > 0) {
            getChildren(curRegionId, deep - 1, temp, lastPath.replace(curRegionId + ".", ""));
        }
    }

    void refreshCache(){
        buildPathMap();
    }

    void init(){
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    refreshCache();
                }catch (Exception e){
                    LOG.error(e.getMessage(),e);
                }
            }
        }, 0, 2, TimeUnit.HOURS);
    }


    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        init();
    }
}