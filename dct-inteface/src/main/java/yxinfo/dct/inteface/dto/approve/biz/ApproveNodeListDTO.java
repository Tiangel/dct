package yxinfo.dct.inteface.dto.approve.biz;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;

public class ApproveNodeListDTO extends BaseDTO {

    private static final long serialVersionUID = -5728843620174803418L;

    private Integer id;

    // 步骤数
    private Integer step;

    // 状态（s审核通过, f审核不通过）
    private String status;

    // 私有域，用于存储业务定制信息
    private String privateField;

    // 审核意见
    private String opinion;

    // 额外信息id
    private Integer extraMsgId;

    // 创建时间
    private Date createAt;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep( Integer step ) {
        this.step = step;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField( String privateField ) {
        this.privateField = privateField;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion( String opinion ) {
        this.opinion = opinion;
    }

    public Integer getExtraMsgId() {
        return extraMsgId;
    }

    public void setExtraMsgId( Integer extraMsgId ) {
        this.extraMsgId = extraMsgId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt( Date createAt ) {
        this.createAt = createAt;
    }
}