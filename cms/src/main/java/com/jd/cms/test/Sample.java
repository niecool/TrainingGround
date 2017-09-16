package com.jd.cms.test;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.HashMap;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "10152359";
    public static final String API_KEY = "QVCUGyZ6vsPQcOulG74NsXQt";
    public static final String SECRET_KEY = "UGgRimPCiyKFI29IfClQhOIxrpCMjerS";

    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        String path1 = "D:\\github\\gitUserHand\\cms\\src\\main\\java\\com\\jd\\cms\\test\\psb.jpg";
        String path2 = "D:\\github\\gitUserHand\\cms\\src\\main\\java\\com\\jd\\cms\\test\\psb2.jpg";
        JSONObject res = client.detect(path1, new HashMap<String, String>());
        JSONObject res2 = client.detect(path2, new HashMap<String, String>());
        System.out.println(res.toString(2));
        System.out.println(res2.toString(2));

    }
}