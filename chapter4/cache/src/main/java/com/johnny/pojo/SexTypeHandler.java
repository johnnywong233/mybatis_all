package com.johnny.pojo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexTypeHandler extends BaseTypeHandler<SexEnum> implements Serializable {
    public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.ordinal());
    }

    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return SexEnum.entity(rs.getInt(columnName));
    }

    public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return SexEnum.entity(rs.getInt(columnIndex));
    }

    public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return SexEnum.entity(cs.getInt(columnIndex));
    }
}
