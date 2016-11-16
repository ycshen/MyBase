package com.brp.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.brp.entity.RequestType;

public class RequestTypeHandler implements TypeHandler<RequestType> {

	@Override
	public void setParameter(PreparedStatement ps, int i, RequestType parameter, JdbcType jdbcType)
			throws SQLException {

	}

	@Override
	public RequestType getResult(ResultSet rs, String columnName) throws SQLException {
		return RequestType.getRequestTypeByCode(rs.getString(columnName));
	}

	@Override
	public RequestType getResult(ResultSet rs, int columnIndex) throws SQLException {
		return RequestType.getRequestTypeByCode(rs.getString(columnIndex));
	}

	@Override
	public RequestType getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}

}
