package com.jd.cms.test.tx.jdbc.mysql;

import java.sql.*;

/**
 * @author zhaochengye
 * @date 2019/4/1 19:50
 */
public class MutiConnectTx {
    public static void main(String[] args) {
        String url ="jdbc:mysql://116.196.79.167:3306/test";
        String user = "root";
        String password = "Ksis923Hhv&8g";
        String sql1 ="select * from  testUser";
        String sql2 ="insert testUser(id,name,age) values(3,'haha','26') ";
        String sql3 ="insert testUser(id,name,age) values(4,'hehe','27') ";
        Connection con1 = null;
        Connection con2 = null;
        Statement statement = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection(url,user,password);
            con2 = DriverManager.getConnection(url,user,password);
            if(con1==null){
                System.out.println("连接失败！");
                System.exit(0);
            }
            con1.setAutoCommit(false);
            con1.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            statement = con1.createStatement();

            Integer rs3 = statement.executeUpdate(sql2);
            Integer rs2 = statement.executeUpdate(sql3);

            ResultSet rs1 = statement.executeQuery(sql1);
            while (rs1.next()){
                System.out.println("id:"+rs1.getString("id")+"   "+"name:"+rs1.getString("name")+"    "+"age:"+rs1.getString("age"));
            }
//            throw new RuntimeException();

        } catch (Exception e) {
            try {
                System.out.println("rollback");
                con1.rollback();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally {
            try {

                con1.commit();
                statement.close();
                con1.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
