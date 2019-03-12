package cn.edu.cqut.gmw.typehandler;

import cn.edu.cqut.gmw.enums.UserStatusEnum;
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
@MappedTypes(UserStatusEnum.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class UserStatusTypeHandler extends BaseTypeHandler<UserStatusEnum> {

  @Override
  public void setNonNullParameter(PreparedStatement p, int i, UserStatusEnum userStatusEnum, JdbcType jdbcType) throws SQLException {
    p.setInt(i, userStatusEnum.getIndex());
  }

  @Override
  public UserStatusEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
    return UserStatusEnum.valueOf(resultSet.getInt(s));
  }

  @Override
  public UserStatusEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
    return UserStatusEnum.valueOf(resultSet.getInt(i));
  }

  @Override
  public UserStatusEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
    return UserStatusEnum.valueOf(callableStatement.getInt(i));
  }
}
