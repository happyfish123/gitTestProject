package com.example.demo;

import java.io.*;
import java.sql.*;

public class TestBlobIn {

    public static void main(String args[]){
        InputStream in = null;
        //通过JDBC获得数据库连接
        try {
            File localFile = new File("C:\\Users\\127\\Desktop\\PowerBuilder.pdf");
            in = new BufferedInputStream(new FileInputStream(localFile));
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:dragon", "system", "admin");
            con.setAutoCommit(false);
            String sql =" insert into LAP_TEST(uuid,name,BLOBATTR) values(?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setObject(1,"4");
            pstm.setObject(2,"张三");
            pstm.setBlob(3,in);
            pstm.executeUpdate();
            System.out.println("插入成功=====");
            con.commit();
            con.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
