package com.zcy.cms.interview;

public class basis {

    /**
     * 多层for
     */
    private static void  breakFors() {
        ok:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i == 5) {
                    System.out.println("i=" + i + "j=" + j);
                    break ok;
                }
            }
            System.out.println("===============");
        }
    }


    public static void main(String[] args) {
        breakFors();
    }


}
