package com.jd.cms.test.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author zhaochengye
 * @date 2019-04-11 10:21
 */
@WebService
public class HelloWSImpl {

    /**
     *
     */
    @WebMethod
    public void helloWS(){
        System.out.println("doSomething!");
    }

}
