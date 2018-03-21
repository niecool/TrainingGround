package com.zcy.cms.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
public class javaTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
//        String URL="jdbc:mysql://10.161.138.26:3306/oms_extend?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&autoReconnectForPools=true&failOverReadOnly=false&rewriteBatchedStatements=true&allowMultiQueries=true";
        String URL="jdbc:mysql://192.168.201.22:3306/oms_extend?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&autoReconnectForPools=true&failOverReadOnly=false&rewriteBatchedStatements=true&allowMultiQueries=true";
        String USER="oms_extend";
        String PASSWORD="oms_extend!@#4";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        try {
            ResultSet rs = st.executeQuery("select * from gos_config");
            while(rs.next()){
                System.out.println(rs.getString("key")+" "
                        +rs.getString("value"));
            }

            //关闭资源
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //4.处理数据库的返回结果(使用ResultSet类)

        st.close();
        conn.close();
    }
}