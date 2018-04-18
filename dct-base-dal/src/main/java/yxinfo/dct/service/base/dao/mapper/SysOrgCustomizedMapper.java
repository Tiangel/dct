package yxinfo.dct.service.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yxinfo.dct.service.base.dao.model.SysOrgCustomized;
import yxinfo.dct.service.base.dao.model.SysOrgCustomizedExample;

public interface SysOrgCustomizedMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    int countByExample(SysOrgCustomizedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    int deleteByExample(SysOrgCustomizedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    int insert(SysOrgCustomized record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    int insertSelective(SysOrgCustomized record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    List<SysOrgCustomized> selectByExample(SysOrgCustomizedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    SysOrgCustomized selectByPrimaryKey(Integer orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysOrgCustomized record, @Param("example") SysOrgCustomizedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysOrgCustomized record, @Param("example") SysOrgCustomizedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysOrgCustomized record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org_customized
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysOrgCustomized record);
}