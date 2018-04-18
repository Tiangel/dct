package yxinfo.dct.inteface.dto.approve.biz;


import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 审核记录搜索DTO
 * Created by dy on 2016/6/22.
 */
public class ApproveRdSearchDTO extends BaseDTO {

    private static final long serialVersionUID = -5579395683519525119L;

    /**
     * 提交人组织id
     */
    @NotNull( message = ErrorCode.APPROVE_SUBMIT_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    /**
     * 用户id
     */
    @NotNull( message = ErrorCode.APPROVE_SUBMIT_MEMBER_NOT_EMPTY )
    private Integer schMemberId;

    /**
     * 状态（o审核中, s审核通过, f审核不通过, i已作废）
     */
    private String status;

    /**
     * 项目编号
     */
    private List<String> itemNoIn;

    /**
     * 扩展字符字段1
     */
    private String extendChar1;

    private List<String> extendChar1In;

    private List<String> extendChar1NotIn;

    private String extendChar1Like;

    /**
     * 扩展字符字段2
     */
    private String extendChar2;

    private List<String> extendChar2In;

    private List<String> extendChar2NotIn;

    private String extendChar2Like;

    /**
     * 扩展数字字段1
     */
    private Long extendInt1;

    private List<Long> extendInt1In;

    private List<Long> extendInt1NotIn;

    private Long extendInt1LessThanOrEqualTo;

    private Long extendInt1LessThan;

    private Long extendInt1GreaterThanOrEqualTo;

    private Long extendInt1GreaterThan;

    /**
     * 扩展数字字段2
     */
    private Long extendInt2;

    private List<Long> extendInt2In;

    private List<Long> extendInt2NotIn;

    private Long extendInt2LessThanOrEqualTo;

    private Long extendInt2LessThan;

    private Long extendInt2GreaterThanOrEqualTo;

    private Long extendInt2GreaterThan;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId( Integer orgId ) {
        this.orgId = orgId;
    }

    public Integer getSchMemberId() {
        return schMemberId;
    }

    public void setSchMemberId( Integer schMemberId ) {
        this.schMemberId = schMemberId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public List<String> getItemNoIn() {
        return itemNoIn;
    }

    public void setItemNoIn( List<String> itemNoIn ) {
        this.itemNoIn = itemNoIn;
    }

    public String getExtendChar1() {
        return extendChar1;
    }

    public void setExtendChar1( String extendChar1 ) {
        this.extendChar1 = extendChar1;
    }

    public List<String> getExtendChar1In() {
        return extendChar1In;
    }

    public void setExtendChar1In( List<String> extendChar1In ) {
        this.extendChar1In = extendChar1In;
    }

    public List<String> getExtendChar1NotIn() {
        return extendChar1NotIn;
    }

    public void setExtendChar1NotIn( List<String> extendChar1NotIn ) {
        this.extendChar1NotIn = extendChar1NotIn;
    }

    public String getExtendChar1Like() {
        return extendChar1Like;
    }

    public void setExtendChar1Like( String extendChar1Like ) {
        this.extendChar1Like = extendChar1Like;
    }

    public String getExtendChar2() {
        return extendChar2;
    }

    public void setExtendChar2( String extendChar2 ) {
        this.extendChar2 = extendChar2;
    }

    public List<String> getExtendChar2In() {
        return extendChar2In;
    }

    public void setExtendChar2In( List<String> extendChar2In ) {
        this.extendChar2In = extendChar2In;
    }

    public List<String> getExtendChar2NotIn() {
        return extendChar2NotIn;
    }

    public void setExtendChar2NotIn( List<String> extendChar2NotIn ) {
        this.extendChar2NotIn = extendChar2NotIn;
    }

    public String getExtendChar2Like() {
        return extendChar2Like;
    }

    public void setExtendChar2Like( String extendChar2Like ) {
        this.extendChar2Like = extendChar2Like;
    }

    public Long getExtendInt1() {
        return extendInt1;
    }

    public void setExtendInt1( Long extendInt1 ) {
        this.extendInt1 = extendInt1;
    }

    public List<Long> getExtendInt1In() {
        return extendInt1In;
    }

    public void setExtendInt1In( List<Long> extendInt1In ) {
        this.extendInt1In = extendInt1In;
    }

    public List<Long> getExtendInt1NotIn() {
        return extendInt1NotIn;
    }

    public void setExtendInt1NotIn( List<Long> extendInt1NotIn ) {
        this.extendInt1NotIn = extendInt1NotIn;
    }

    public Long getExtendInt1LessThanOrEqualTo() {
        return extendInt1LessThanOrEqualTo;
    }

    public void setExtendInt1LessThanOrEqualTo( Long extendInt1LessThanOrEqualTo ) {
        this.extendInt1LessThanOrEqualTo = extendInt1LessThanOrEqualTo;
    }

    public Long getExtendInt1LessThan() {
        return extendInt1LessThan;
    }

    public void setExtendInt1LessThan( Long extendInt1LessThan ) {
        this.extendInt1LessThan = extendInt1LessThan;
    }

    public Long getExtendInt1GreaterThanOrEqualTo() {
        return extendInt1GreaterThanOrEqualTo;
    }

    public void setExtendInt1GreaterThanOrEqualTo( Long extendInt1GreaterThanOrEqualTo ) {
        this.extendInt1GreaterThanOrEqualTo = extendInt1GreaterThanOrEqualTo;
    }

    public Long getExtendInt1GreaterThan() {
        return extendInt1GreaterThan;
    }

    public void setExtendInt1GreaterThan( Long extendInt1GreaterThan ) {
        this.extendInt1GreaterThan = extendInt1GreaterThan;
    }

    public Long getExtendInt2() {
        return extendInt2;
    }

    public void setExtendInt2( Long extendInt2 ) {
        this.extendInt2 = extendInt2;
    }

    public List<Long> getExtendInt2In() {
        return extendInt2In;
    }

    public void setExtendInt2In( List<Long> extendInt2In ) {
        this.extendInt2In = extendInt2In;
    }

    public List<Long> getExtendInt2NotIn() {
        return extendInt2NotIn;
    }

    public void setExtendInt2NotIn( List<Long> extendInt2NotIn ) {
        this.extendInt2NotIn = extendInt2NotIn;
    }

    public Long getExtendInt2LessThanOrEqualTo() {
        return extendInt2LessThanOrEqualTo;
    }

    public void setExtendInt2LessThanOrEqualTo( Long extendInt2LessThanOrEqualTo ) {
        this.extendInt2LessThanOrEqualTo = extendInt2LessThanOrEqualTo;
    }

    public Long getExtendInt2LessThan() {
        return extendInt2LessThan;
    }

    public void setExtendInt2LessThan( Long extendInt2LessThan ) {
        this.extendInt2LessThan = extendInt2LessThan;
    }

    public Long getExtendInt2GreaterThanOrEqualTo() {
        return extendInt2GreaterThanOrEqualTo;
    }

    public void setExtendInt2GreaterThanOrEqualTo( Long extendInt2GreaterThanOrEqualTo ) {
        this.extendInt2GreaterThanOrEqualTo = extendInt2GreaterThanOrEqualTo;
    }

    public Long getExtendInt2GreaterThan() {
        return extendInt2GreaterThan;
    }

    public void setExtendInt2GreaterThan( Long extendInt2GreaterThan ) {
        this.extendInt2GreaterThan = extendInt2GreaterThan;
    }
}
