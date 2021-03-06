package com.springapp.mvc.mappers;

import com.springapp.mvc.entity.mybatis.IndexInfo;
import com.springapp.mvc.entity.mybatis.IndexInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    int countByExample(IndexInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    int deleteByExample(IndexInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    int insert(IndexInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    int insertSelective(IndexInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    List<IndexInfo> selectByExample(IndexInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    IndexInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    int updateByExampleSelective(@Param("record") IndexInfo record, @Param("example") IndexInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    int updateByExample(@Param("record") IndexInfo record, @Param("example") IndexInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    int updateByPrimaryKeySelective(IndexInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oasis_index
     *
     * @mbggenerated Mon Aug 10 10:34:11 CST 2015
     */
    int updateByPrimaryKey(IndexInfo record);
}