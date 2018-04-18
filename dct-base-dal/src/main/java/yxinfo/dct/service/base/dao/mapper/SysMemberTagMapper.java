package yxinfo.dct.service.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yxinfo.dct.service.base.dao.model.SysMemberTag;
import yxinfo.dct.service.base.dao.model.SysMemberTagExample;

public interface SysMemberTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    int countByExample(SysMemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    int deleteByExample(SysMemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    int insert(SysMemberTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    int insertSelective(SysMemberTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    List<SysMemberTag> selectByExample(SysMemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    SysMemberTag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysMemberTag record, @Param("example") SysMemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysMemberTag record, @Param("example") SysMemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysMemberTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member_tag
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysMemberTag record);
}