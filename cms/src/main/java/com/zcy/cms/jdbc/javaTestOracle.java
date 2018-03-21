package com.zcy.cms.jdbc;

import java.sql.*;
public class javaTestOracle {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        String URL="jdbc:oracle:thin:@10.161.138.10:1521:dcwhtest";
//        String URL="jdbc:oracle:thin:@10.161.138.17:1521:dcwhtest2";
//        String USER="prod_data2";
        String USER="user_data2";
//        String PASSWORD="9ixXGbTDb7iApW5w8t-gNw..";
        String PASSWORD="dsfgfgggewe";
        //1.加载驱动程序
        Class.forName("oracle.jdbc.OracleDriver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        try {
            ResultSet rs = st.executeQuery("select * from USER_DATA2.gos_config");
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