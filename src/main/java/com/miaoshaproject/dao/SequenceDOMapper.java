package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.SequenceDO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SequenceDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Nov 18 22:19:38 CST 2018
     */
    int deleteByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Nov 18 22:19:38 CST 2018
     */
    int insert(SequenceDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Nov 18 22:19:38 CST 2018
     */
    int insertSelective(SequenceDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Nov 18 22:19:38 CST 2018
     */
    SequenceDO selectByPrimaryKey(String name);

    SequenceDO getSequenceByName(String name);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Nov 18 22:19:38 CST 2018
     */
    int updateByPrimaryKeySelective(SequenceDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Nov 18 22:19:38 CST 2018
     */
    int updateByPrimaryKey(SequenceDO record);
}