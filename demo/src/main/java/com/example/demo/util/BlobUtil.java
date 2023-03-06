package com.example.demo.util;

import oracle.jdbc.rowset.OracleSerialBlob;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * @description TODO
 * 
 * @author  hwq
 * @date 2022-3-31
 */
public class BlobUtil {

	@SuppressWarnings("unused")
	public static String blobToString(Blob blob) {
		if (blob == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();

		try {
			InputStream in = blob.getBinaryStream();
			byte[] buff = new byte[(int) blob.length()];
			int i = 0;
			while ((i = in.read(buff)) != -1) {
				sb.append(new String(buff, "gbk"));
			}
			in.close();
		} catch (Exception e) {
			System.out.println("转换BLOB出错！");
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	@SuppressWarnings("unused")
	public static String blobToUTFString(Blob blob) {
		StringBuffer sb = new StringBuffer();
		
		try {
			InputStream in = blob.getBinaryStream();
			byte[] buff = new byte[(int) blob.length()];
			int i = 0;
			while ((i = in.read(buff)) != -1) {
				sb.append(new String(buff, "UTF-8"));
			}
			in.close();
		} catch (Exception e) {
			System.out.println("转换BLOB出错！");
			e.printStackTrace();
		}
		
		return sb.toString();
	}

	public static Blob byteToBlob(byte[] by) {
		Blob  blob = null;
		try {
			blob = new OracleSerialBlob(by);
		} catch (SQLException e) {
			System.out.println("byte 转换BLOB出错！");
			e.printStackTrace();
		}
		return  blob;
	}
}
