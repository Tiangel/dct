package yxinfo.dct.inteface.dto.warn;

import org.hibernate.validator.constraints.Length;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemChemicalDTO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by cy on 2016/7/20.
 */
public class WarnRuleDTO extends BaseDTO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 组织id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.LAB_ORGID_LENGTH)
    @NotNull(message = ErrorCode.LAB_ORGID_NOTNULL)
    private Integer orgId;

    /**
     * 预警项目编号，<FK>warn_item.item_no
     */
    @Length(max = 100, message = ErrorCode.WARN_ITEMNO_LENGTH)
    @NotNull(message = ErrorCode.WARN_ITEMNO_NOTNULL)
    private String itemNo;

    /**
     * 预警事物标识
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.WARN_WARNFOR_LENGTH)
    private Integer warnFor;
    private ChemChemicalDTO chemChemicalDTO;

    /**
     * 限制范围左值
     */
    @Length(max = 200, message = ErrorCode.WARN_LIMITLEFT_LENGTH)
    private String limitLeft;

    /**
     * 限制范围右值
     */
    @Length(max = 200, message = ErrorCode.WARN_LIMITRIGHT_LENGTH)
    private String limitRight;

    /**
     * 创建人成员id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.WARN_MEMBERID_LENGTH)
    private Integer memberId;

    /**
     * 创建时间
     */
    private Date createAt;

    //关联文本
    private String text;

    //扩展字段1
    private String extend1;
    private String extend1Name;

    //扩展字段2
    private String extend2;
    private String extend2Name;

    //扩展字段3
    private String extend3;
    private String extend3Name;

    /**
     * 添加规则（1：无添加有更新）
     */
    private String flag = "0";

    public WarnRuleDTO() {
    }

    public WarnRuleDTO(Integer id, Integer orgId, String itemNo, Integer warnFor, ChemChemicalDTO chemChemicalDTO, String limitLeft, String limitRight, Integer memberId, Date createAt, String text, String extend1, String extend1Name, String extend2, String extend2Name, String extend3, String extend3Name, String flag) {
        this.id = id;
        this.orgId = orgId;
        this.itemNo = itemNo;
        this.warnFor = warnFor;
        this.chemChemicalDTO = chemChemicalDTO;
        this.limitLeft = limitLeft;
        this.limitRight = limitRight;
        this.memberId = memberId;
        this.createAt = createAt;
        this.text = text;
        this.extend1 = extend1;
        this.extend1Name = extend1Name;
        this.extend2 = extend2;
        this.extend2Name = extend2Name;
        this.extend3 = extend3;
        this.extend3Name = extend3Name;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getWarnFor() {
        return warnFor;
    }

    public void setWarnFor(Integer warnFor) {
        this.warnFor = warnFor;
    }

    public ChemChemicalDTO getChemChemicalDTO() {
        return chemChemicalDTO;
    }

    public void setChemChemicalDTO(ChemChemicalDTO chemChemicalDTO) {
        this.chemChemicalDTO = chemChemicalDTO;
    }

    public String getLimitLeft() {
        return limitLeft;
    }

    public void setLimitLeft(String limitLeft) {
        this.limitLeft = limitLeft;
    }

    public String getLimitRight() {
        return limitRight;
    }

    public void setLimitRight(String limitRight) {
        this.limitRight = limitRight;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }

    public String getExtend1Name() {
        return extend1Name;
    }

    public void setExtend1Name(String extend1Name) {
        this.extend1Name = extend1Name;
    }

    public String getExtend2Name() {
        return extend2Name;
    }

    public void setExtend2Name(String extend2Name) {
        this.extend2Name = extend2Name;
    }

    public String getExtend3Name() {
        return extend3Name;
    }

    public void setExtend3Name(String extend3Name) {
        this.extend3Name = extend3Name;
    }

    @Override
    public String toString() {
        return "WarnRuleDTO{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", itemNo='" + itemNo + '\'' +
                ", warnFor=" + warnFor +
                ", limitLeft='" + limitLeft + '\'' +
                ", limitRight='" + limitRight + '\'' +
                ", memberId=" + memberId +
                ", createAt=" + createAt +
                '}';
    }
}
