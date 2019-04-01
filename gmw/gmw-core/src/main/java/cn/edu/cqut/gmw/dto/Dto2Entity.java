package cn.edu.cqut.gmw.dto;

interface Dto2Entity<E> {

  /**
   * Dto转换为Entity
   *
   * @return Entity
   */
  E toEntity();
}
