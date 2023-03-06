package com.example.demo;

import oracle.sql.CLOB;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestPdf {

    public static void main(String args[]){
        InputStream in = null;
        OutputStream out = null;
        //通过JDBC获得数据库连接
        try {
            File localFile = new File("C:\\Users\\127\\Desktop\\PowerBuilder.pdf");
            in = new BufferedInputStream(new FileInputStream(localFile));
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:dragon", "system", "admin");
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            //锁定数据行进行更新，注意“for update”语句,这里不用for update锁定不可以插入clob
            ResultSet rs = st.executeQuery("select CLOBATTR from LAP_TEST where uuid=3 for update");
            if (rs.next())
            {
                //得到java.sql.Clob对象后强制转换为oracle.sql.CLOB
                CLOB clob = (CLOB) rs.getClob("CLOBATTR");
                out = clob.getAsciiOutputStream();
                byte[] buffer = new byte[4096];
                int len = 0; //读取长度
                while ((len = in.read(buffer, 0, buffer.length)) != -1) {
                    out.write(buffer, 0, len);
                }
            }
            out.flush();
            out.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
