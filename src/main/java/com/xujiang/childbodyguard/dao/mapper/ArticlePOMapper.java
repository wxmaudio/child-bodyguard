package com.xujiang.childbodyguard.dao.mapper;

import com.xujiang.childbodyguard.domain.po.ArticlePO;
import com.xujiang.childbodyguard.domain.po.ArticlePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticlePOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    int countByExample(ArticlePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    int deleteByExample(ArticlePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    int insert(ArticlePO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    int insertSelective(ArticlePO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    List<ArticlePO> selectByExample(ArticlePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    ArticlePO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    int updateByExampleSelective(@Param("record") ArticlePO record, @Param("example") ArticlePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    int updateByExample(@Param("record") ArticlePO record, @Param("example") ArticlePOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    int updateByPrimaryKeySelective(ArticlePO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_article
     *
     * @mbggenerated Sat Jun 23 19:22:02 CST 2018
     */
    int updateByPrimaryKey(ArticlePO record);
}