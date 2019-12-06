/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.zcy.cms.pathTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * dictSegment
 *
 * @author zhaochengye
 * @date 2019/12/5
 */
public class DictSegment {
    /**
     * 公用字典表
     */
    private static final Map<Integer, Integer> charMap = new HashMap<>(16, 0.95f);
    /**
     * 当前节点内容
     */
    private Integer node;

    /**
     * 当前节点存储节点数
     */
    private long size;

    /**
     * 当前是否为终节点
     */
    private boolean enable;

    /**
     * Map存储结构
     */
    private Map<Integer, DictSegment> childrenMap;


    public DictSegment(Integer node) {
        if (node == null) {
            throw new IllegalArgumentException("参数为空异常");
        }
        this.node = node;
    }

    private void fillSegment(int[] pathArr, int begin, int length, boolean enabled) {
        // 获取字典表中的汉字对象
        int curCode = pathArr[begin];
        Integer curValue = charMap.get(curCode);
        // 字典中没有该字，则将其添加入字典
        if (curValue == null) {
            charMap.put(curCode, curCode);
            curValue = curCode;
        }

        DictSegment ds = this.lookForSegment(curValue, enabled);
        if (ds != null) {
            if (length > 1) {
                ds.fillSegment(pathArr, begin + 1, length - 1, enabled);
            } else if (length == 1) {
                // 已经是词元的最后一个char,设置当前节点状态为enabled，
                ds.enable = enabled;
            }
        }
    }

    private DictSegment lookForSegment(int node, boolean create) {
        DictSegment ds = null;
        // 获取Map容器，如果Map未创建,则创建Map
        Map<Integer, DictSegment> segmentMap = this.getChildrenMap();
        ds = segmentMap.get(node);
        if (ds == null && create) {
            ds = new DictSegment(node);
            segmentMap.put(node, ds);
            this.size++;
        }
        return ds;
    }

    /**
     * 获取Map容器 线程同步方法
     */
    private Map<Integer, DictSegment> getChildrenMap() {
        if (this.childrenMap == null) {
            synchronized (this) {
                if (this.childrenMap == null) {
                    this.childrenMap = new HashMap<Integer, DictSegment>();
                }
            }
        }
        return this.childrenMap;
    }


    private void fillSegment(int[] pathArr) {
        fillSegment(pathArr,0,pathArr.length,true);
    }

     void fillSegment(String path) {
        String localStr;
        if(path!=null){
            String[] splitArr = path.split("\\.");
            fillSegment(str2Int(splitArr));
        }
    }

    private int[] str2Int(String[] splitArr){
        int[] result = new int[splitArr.length];
        if(splitArr!=null && splitArr.length>0){
            for(int i=0;i<splitArr.length;i++){
                 int temp = Integer.parseInt(splitArr[i]);
                result[i] = temp;
            }
        }
        return result;
    }


}