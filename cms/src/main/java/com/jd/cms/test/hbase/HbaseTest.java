package com.jd.cms.test.hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HConnection;

import java.io.IOException;

/**
 * @author zhaochengye
 * @date 2018/12/14 20:03
 */
public class HbaseTest {

    public static void main(String[] args) throws Exception {
        HbaseUtils ut = new HbaseUtils();
        ut.readTableInfo("sam_product");
    }
}
