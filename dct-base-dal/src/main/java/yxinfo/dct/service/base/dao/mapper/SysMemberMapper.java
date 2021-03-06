package yxinfo.dct.service.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yxinfo.dct.service.base.dao.model.SysMember;
import yxinfo.dct.service.base.dao.model.SysMemberExample;

public interface SysMemberMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    int countByExample(SysMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    int deleteByExample(SysMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    int insert(SysMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    int insertSelective(SysMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    List<SysMember> selectByExample(SysMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    SysMember selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysMember record, @Param("example") SysMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysMember record, @Param("example") SysMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_member
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysMember record);
}