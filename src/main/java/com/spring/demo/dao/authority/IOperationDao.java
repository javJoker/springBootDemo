package com.spring.demo.dao.authority;

import com.spring.demo.model.authority.Operation;

public interface IOperationDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_operation
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_operation
     *
     * @mbg.generated
     */
    int insert(Operation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_operation
     *
     * @mbg.generated
     */
    int insertSelective(Operation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_operation
     *
     * @mbg.generated
     */
    Operation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_operation
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Operation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_operation
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Operation record);
}