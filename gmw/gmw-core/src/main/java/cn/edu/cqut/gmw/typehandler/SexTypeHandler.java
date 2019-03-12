package cn.edu.cqut.gmw.typehandler;

import cn.edu.cqut.gmw.enums.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 90949
 */
@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

  @Override
  public void setNonNullParameter(PreparedStatement p, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
    p.setInt(i, sexEnum.getIndex());
  }

  @Override
  public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
    return SexEnum.valueOf(resultSet.getInt(s));
  }

  @Override
  public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
    return SexEnum.valueOf(resultSet.getInt(i));
  }

  @Override
  public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
    return SexEnum.valueOf(callableStatement.getInt(i));
  }
}
