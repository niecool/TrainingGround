package com.jd.cms.test.impl;

import com.jd.cms.test.ZCYTest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.WebApplicationObjectSupport;

/**
 * @author zhaochengye
 * @date 2018/12/13 09:57
 */
@Controller
@RequestMapping()
public class ZCYTestImpl extends ApplicationObjectSupport implements ZCYTest {
//    WebApplicationContextUtils
//    WebApplicationContextUtils.getWebApplicationContext()
//    ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext() );
//    System.out.println(this.getApplicationContext());

    @RequestMapping("/test")
    public void test(){
        ApplicationContext context = getApplicationContext();
    }


    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("file:/Users/zhaochengye/Documents/gitProject/gitUserHand/cms/src/main/resources/spring-context.xml");
        System.out.println("end");
        //Object o = ac.getBean("zcyTest");
        //ZCYTest z= (ZCYTest)o;
        //z.
    }


    public String getName() {
        return "zhaochengye";
    }
}
