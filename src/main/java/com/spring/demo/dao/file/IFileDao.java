package com.spring.demo.dao.file;

import com.spring.demo.model.file.File;

public interface IFileDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_file
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_file
     *
     * @mbg.generated
     */
    int insert(File record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_file
     *
     * @mbg.generated
     */
    int insertSelective(File record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_file
     *
     * @mbg.generated
     */
    File selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(File record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(File record);
}