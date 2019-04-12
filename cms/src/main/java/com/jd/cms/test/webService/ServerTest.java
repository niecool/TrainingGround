package com.jd.cms.test.webService;

import javax.xml.ws.Endpoint;

/**
 * @author zhaochengye
 * @date 2019-04-11 10:19
 */
public class ServerTest {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8989/zcy/hello",new HelloWSImpl());
        System.out.println("发布webService成功！");
    }
}
