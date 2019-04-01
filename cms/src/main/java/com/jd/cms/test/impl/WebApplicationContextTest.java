package com.jd.cms.test.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationObjectSupport;

/**
 * @author zhaochengye
 * @date 2019/3/27 17:12
 */
@Controller
public class WebApplicationContextTest extends WebApplicationObjectSupport {

    @RequestMapping("/test/applicationContext")
    public void test(){
        WebApplicationContext webContext = getWebApplicationContext();
        ApplicationContext applicationContext = getApplicationContext();
    }
}
