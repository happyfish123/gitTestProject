package com.example.demo;

import oracle.sql.CLOB;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestClobIn {

        public static void main(String args[]){
            String data="this is a long passage！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！";
            Writer outStream = null;
            //通过JDBC获得数据库连接
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:dragon", "system", "admin");
                con.setAutoCommit(false);
                Statement st = con.createStatement();
                //插入一个空对象empty_clob()，这个是必须的
               // st.executeUpdate("insert into LAP_TEST(uuid, NAME, CLOBATTR)values(2,'thename', empty_clob())");
                //锁定数据行进行更新，注意“for update”语句,这里不用for update锁定不可以插入clob
                ResultSet rs = st.executeQuery("select CLOBATTR from LAP_TEST where uuid=2 for update");
                if (rs.next())
                {
                    //得到java.sql.Clob对象后强制转换为oracle.sql.CLOB
                    CLOB clob = (CLOB) rs.getClob("CLOBATTR");
                    outStream = clob.getCharacterOutputStream();
                    //data是传入的字符串，定义：String data
                    char[] c = data.toCharArray();
                    outStream.write(c, 0, c.length);
                }
                outStream.flush();
                outStream.close();
                con.commit();
                con.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

}
