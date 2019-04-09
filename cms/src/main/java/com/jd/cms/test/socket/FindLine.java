package com.jd.cms.test.socket;

/**
 * @author zhaochengye
 * @date 2019/4/3 13:44
 */

import java.util.*;

public class FindLine{
    public static class Line {

        public int no;//线编号
        public String leftType;
        public String rightType;
    }

    public static class LineNode{
        private List<Line> leftNodes  =new ArrayList<Line>();
        private List<Line> middleNodes  =new ArrayList<Line>();
        private List<Line> rightNodes  =new ArrayList<Line>();
    }

    public static void main(String[] args){
        List<Line> lines = getLineList();
        Map<String,LineNode> typeMap = new HashMap<String,LineNode>();
        for(Line l :lines){ //初始处理
            if(l.leftType.equals(l.rightType)){
                if (typeMap.get(l.leftType)==null){
                    typeMap.put(l.leftType,new LineNode());
                }
                typeMap.get(l.leftType).middleNodes.add(l);
                continue;
            }
            if (typeMap.get(l.leftType)==null){
                typeMap.put(l.leftType,new LineNode());
            }
            typeMap.get(l.leftType).leftNodes.add(l);

            if (typeMap.get(l.rightType)==null){
                typeMap.put(l.rightType,new LineNode());
            }
            typeMap.get(l.rightType).rightNodes.add(l);
        }
        //排除不能配对的，或者找到起始点
        Set<String> types = typeMap.keySet();
        LineNode startNode = null;
        LineNode endNode = null;
        for(Iterator<String> itor=types.iterator();itor.hasNext();){
            String type = itor.next();
            LineNode node = typeMap.get(type);
            int leftNum = node.leftNodes.size();
            int rightNum = node.rightNodes.size();
            if(node.middleNodes.size() >0 && node.leftNodes.size()==0 &&node.rightNodes.size()==0){
                System.out.println("无法配对，"+type+"没有左右节点！");
                return;
            }
            if(leftNum-rightNum>=2 || rightNum-leftNum>=2){
                System.out.println("无法配对，"+type+"左右数量差大于2！");
                return;
            }
            if(leftNum-rightNum==1){
                if(startNode==null){
                    startNode =node;
                }else{
                    System.out.println("无法配对，至少有2个起点！");
                    return;
                }
            }
            if(rightNum-leftNum==1){
                if(endNode==null){
                    endNode = node;
                }else{
                    System.out.println("无法配对，至少有2个终点！");
                    return;
                }
            }
        }
        if(typeMap.size()==1){
            System.out.println("全是同类线，连接成功。端口："+lines.get(0).leftType);
            return;
        }
        if(startNode==null){//找一个开始节点
            for(Line l:lines){
                if(typeMap.get(l.leftType) !=endNode){//找到一个节点，不是终点的。开始跑
                    startNode= typeMap.get(l.leftType);
                    break;
                }
            }
        }
        while(startNode != null){
            String nextType = getNextType(startNode);
            startNode = typeMap.get(nextType);
        }

    }
    public static String getNextType(LineNode node){
        if(node.middleNodes.size() !=0){
            for(Line l:node.middleNodes){
                System.out.println(getOutInfo(l));
            }
            node.middleNodes.clear();
        }
        if(node.leftNodes.size()==0){
            return null; //空了
        }
        Line l =node.leftNodes.get(0);
        System.out.println(getOutInfo(l));
        node.leftNodes.remove(0); //删除
        return l.rightType;
    }
    public static String getOutInfo(Line l){
        String result = "连接线： 编号"+l.no+",左边："+l.leftType+",右边："+l.rightType;
        return result;
    }

    public static List<Line> getLineList(){
        List<Line> lines = new ArrayList<Line>();
//        lines.add(getLine(1,"a","b"));
//        lines.add(getLine(2,"b","b"));
//        lines.add(getLine(3,"c","d"));
//        lines.add(getLine(4,"d","e"));
//        lines.add(getLine(5,"e","e"));
//        lines.add(getLine(6,"b","c"));
        lines.add(getLine(1,"a","b"));
        lines.add(getLine(2,"b","c"));
        lines.add(getLine(3,"b","d"));
        lines.add(getLine(4,"d","e"));
        lines.add(getLine(5,"e","f"));
        lines.add(getLine(6,"b","c"));
//        lines.add(getLine(7,"a","f"));
//        lines.add(getLine(8,"c","f"));




        return lines;
    }
    public static Line getLine(int no,String leftType,String rightType){
        Line l = new Line();
        l.rightType= rightType;
        l.leftType = leftType;
        l.no = no;
        return  l;
    }
}


