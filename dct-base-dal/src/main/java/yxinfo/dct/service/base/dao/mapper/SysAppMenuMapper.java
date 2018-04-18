package yxinfo.dct.service.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yxinfo.dct.service.base.dao.model.SysAppMenu;
import yxinfo.dct.service.base.dao.model.SysAppMenuExample;

public interface SysAppMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    int countByExample(SysAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    int deleteByExample(SysAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    int insert(SysAppMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    int insertSelective(SysAppMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    List<SysAppMenu> selectByExample(SysAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    SysAppMenu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysAppMenu record, @Param("example") SysAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysAppMenu record, @Param("example") SysAppMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysAppMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysAppMenu record);
}