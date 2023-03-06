package com.example.demo.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;


/**
 * 类处理器，用于Mybatis中Blob和String类型转换
 * 在所需要转换的字段上添加 typeHandler="com.example.demo.handler.BlobTypeHandler"
 *
* */
public class BlobTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setBytes(i, parameter.getBytes());
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new String(rs.getBytes(columnName));
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new String(rs.getBytes(columnIndex));
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new String(cs.getBytes(columnIndex));
    }
}
