package com.example.demo;


import sun.misc.BASE64Encoder;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;


public class TestBlobOut {

    public static void main(String args[]) {
        InputStream inStream = null;
        String data ="";
        //获得数据库连接
        Connection con = null;//ConnectionFactory类是另外定义的，不必纠结
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:dragon", "system", "admin");
            con.setAutoCommit(false);
            String sql =" select BLOBATTR from LAP_TEST where uuid =4 ";
            PreparedStatement pstm = con.prepareStatement(sql);
            //pstm.setObject(1,"4");
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                Blob blob = rs.getBlob("BLOBATTR");
              //  inStream =blob.getBinaryStream();
                byte []b = blobToBytes(blob);
                data =getImageString(b);
                System.out.println("data:application/pdf;base64,"+data);
            }

            //inStream.close();
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