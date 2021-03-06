package com.spring.demo.dao.authority;

import com.spring.demo.model.authority.PageElement;

public interface IPageElementDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_page_element
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_page_element
     *
     * @mbg.generated
     */
    int insert(PageElement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_page_element
     *
     * @mbg.generated
     */
    int insertSelective(PageElement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_page_element
     *
     * @mbg.generated
     */
    PageElement selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_page_element
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PageElement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_page_element
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PageElement record);
}