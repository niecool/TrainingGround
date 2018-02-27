package com.zcy.cms.interview;

import com.zcy.cms.test.Test;

public class AnoymousClass {
private String name;

    public static void test(Test test){
        System.out.println(test.getClass().getName());
    }

    public static void main(String[] args) {
        AnoymousClass a = new AnoymousClass();
        AnoymousClass.inner.hell();
        a.test(new Test() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
    }

    static class inner{
        public  static void hell(){
            System.out.println("static inner class!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
