package com.example.demo;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.*;
import java.sql.*;


public class TestClobOut {

    public static void main(String args[]) {
        String data;
        Reader inStream = null;
        //获得数据库连接
        Connection con = null;//ConnectionFactory类是另外定义的，不必纠结
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:dragon", "system", "admin");
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            //不需要“for update”
            ResultSet rs = st.executeQuery("select CLOBATTR from LAP_TEST where uuid=3");
            if (rs.next()) {
                java.sql.Clob clob = rs.getClob("CLOBATTR");
                String mm = ClobToString(clob);
                //System.out.println(mm);
                inStream = clob.getCharacterStream();
                //char[] c = new char[(int) clob.length()];
                //inStream.read(c);
                //data是读出并需要返回的数据，类型是String
               // data = new String(c);
                byte []b = clobToBytes(clob);
                data =getImageString(b);
                 System.out.println("data:application/pdf;base64,"+data);
                inStream.close();
            }
            inStream.close();
            con.commit();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getImageString(byte[] data) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        return data != null ? encoder.encode(data) : "";
    }

    public static String ClobToString(Clob clob) throws SQLException, IOException {

        String reString = "";
        Reader is = clob.getCharacterStream();// 得到流
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s + "\n");
            s = br.readLine();
        }
        reString = sb.toString();
        return reString;
    }

    public static String base64UnEscape(String str) {
        String res = "";
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(str);
            res = new String(bytes, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


    public static byte[] clobToBytes(Clob clob) {
        BufferedInputStream is = null;
        try {
            is = new BufferedInputStream(clob.getAsciiStream());
            byte[] bytes = new byte[(int) clob.length()];
            int len = bytes.length;
            int offset = 0;
            int read = 0;
            while (offset < len && (read = is.read(bytes, offset, len - offset)) >= 0) {
                offset += read;
            }
            return bytes;
        } catch (Exception e) {
            try {
                is.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            is = null;
            return null;
        } finally {
            try {
                is.close();
                is = null;
            } catch (IOException e) {
                return null;
            }
        }
    }

    public static byte[] blobToBytes(Blob blob) {
        BufferedInputStream is = null;
        try {
            is = new BufferedInputStream(blob.getBinaryStream());
            byte[] bytes = new byte[(int) blob.length()];
            int len = bytes.length;
            int offset = 0;
            int read = 0;
            while (offset < len && (read = is.read(bytes, offset, len - offset)) >= 0) {
                offset += read;
            }
            return bytes;
        } catch (Exception e) {
            try {
                is.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            is = null;
            return null;
        } finally {
            try {
                is.close();
                is = null;
            } catch (IOException e) {
                return null;
            }
        }
    }



}