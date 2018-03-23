package com.jd.cms.test;

import org.junit.Test;

import java.io.IOException;

public class TestLucene {

    @Test
    public void testIndex() {
        HelloLucene h1 = new HelloLucene();
        h1.index();
    }

    @Test
    public void testSearch() {
        HelloLucene h1 = new HelloLucene();
        h1.search();
    }
}
