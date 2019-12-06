/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.zcy.cms.pathTopic;

import com.yijiupi.trd.mall.setting.model.MallJiupiRegionDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Dictinary
 *
 * @author zhaochengye
 * @date 2019/12/5
 */
public class Dictinary {
    /*
     * 主词典对象
     */
    private DictSegment _MainDict;

    /**
     * 最小个数
     */
    private static final int leastNum = 1000;

    /**
     * 加载词典
     * @param mallJiupiRegionDTOS
     */
    public void loadMainDict(List<MallJiupiRegionDTO> mallJiupiRegionDTOS) {
        _MainDict = new DictSegment(0);
        if(mallJiupiRegionDTOS == null){
            throw new IllegalArgumentException("区域词条为空");
        }
        if(mallJiupiRegionDTOS.size() < leastNum){
            throw new IllegalArgumentException("区域词条小于阈值，"+mallJiupiRegionDTOS.size()+"条");
        }
        for(MallJiupiRegionDTO dto : mallJiupiRegionDTOS){
            fillSegment(dto);
        }
    }

    private void fillSegment(MallJiupiRegionDTO dto){
        String path = dto.getParentIdPath();
        if(path!=null){
            String localStr = path.replace(" ", "");
            if(StringUtils.isNotBlank(localStr)){
                _MainDict.fillSegment(localStr);
            }
        }
    }

}