package cn.edu.cqut.gmw.dto.execution;

import cn.edu.cqut.gmw.dto.UserMessageDto;

public class UserExecution<E extends Enum<E>> {

  private UserMessageDto user;
  private Enum<E> status;

  public UserExecution(E status) {
    this.status = status;
  }

  public UserExecution(E status, UserMessageDto user) {
    this.status = status;
    this.user = user;
  }

  public UserMessageDto getUser() {
    return user;
  }

  public Enum<E> getStatus() {
    return status;
  }
}
