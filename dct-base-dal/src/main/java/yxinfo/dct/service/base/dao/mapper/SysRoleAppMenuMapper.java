package yxinfo.dct.service.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yxinfo.dct.service.base.dao.model.SysRoleAppMenu;
import yxinfo.dct.service.base.dao.model.SysRoleAppMenuExample;

public interface SysRoleAppMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    int countByExample(SysRoleAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    int deleteByExample(SysRoleAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    int insert(SysRoleAppMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    int insertSelective(SysRoleAppMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    List<SysRoleAppMenu> selectByExample(SysRoleAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    SysRoleAppMenu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysRoleAppMenu record, @Param("example") SysRoleAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysRoleAppMenu record, @Param("example") SysRoleAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRoleAppMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_app_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRoleAppMenu record);
}