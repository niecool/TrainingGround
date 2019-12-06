package com.zcy.cms.pathTopic;

import java.util.*;

public class Util {

    public static void main(String[] args) {
        Set<Integer> orig = new HashSet<Integer>();
        orig.add(100);
        orig.add(99);
        Iterator<Integer> iterator = orig.iterator();
        while (iterator.hasNext()){
            Integer it = iterator.next();
            System.out.println(it);
            orig.add(it-1);
        }
        System.out.println(orig.size());

    }
//
//    public static void main(String[] args) {
//        Set<String> resourcePath = new HashSet<String>();
//        resourcePath.add("0.10.10100.1010010000");
//        resourcePath.add("0.12.12100.1210010000");
//        resourcePath.add("0.12.12012.1201210000");
//        resourcePath.add("0.12.12013");
//        resourcePath.add("0.11");
//        String target = "0.12.12012";
//        Iterator<String> iterator = resourcePath.iterator();
//        for (String path : resourcePath) {
//            int a = reducePath(path, target);
//            if (a < 0) {
//                iterator.remove();
//            } else if (a > 0) {
//                getChildren(0, a, resourcePath, target.replace(path + "\\.", ""));
//            }
//        }
//    }

    /**
     * path比较，根据结果来拆分或者移除或者不处理
     *
     * @param resource
     * @param target
     * @return
     */
    private static int reducePath(String resource, String target) {
        //resource包含或者等于target,那么resource丢弃掉
        if (resource.startsWith(target)) {
            return -1;
        }
        //target包含resource，那么就拆
        if (target.startsWith(resource)) {
            return target.replace(resource, "").split("\\.").length;
        }
        //resource和target互不相关,不用处理
        return 0;
    }

    /**
     * 拆分
     */
    private static void getChildren(int Code, int deep, Set<String> resourcePath, String targrt) {
        Set<String> childrenPathSet = new HashSet<String>();//todo interface
        resourcePath.addAll(childrenPathSet);//添加所有节点，除开匹配子节点
        resourcePath.remove(targrt + "\\." + Code);//去除当前节点
        if (deep > 1) {
            String curNode = targrt.split("\\.")[0];
            getChildren(Integer.parseInt(curNode), deep - 1, resourcePath, targrt.replace(curNode + "\\.", ""));
        }
    }
}
