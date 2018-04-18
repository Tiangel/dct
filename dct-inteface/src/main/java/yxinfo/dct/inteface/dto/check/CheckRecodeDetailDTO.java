package yxinfo.dct.inteface.dto.check;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by sxd on 2016/7/21.
 */
public class CheckRecodeDetailDTO extends BaseDTO {
    private static final long serialVersionUID = 814409494024677774L;

    private Integer id;

    //单号
    private String fcode;

    //组织id
    private Integer orgId;

    //盘点项目编号，<FK>check_item.item_no
    private String itemNo;

    //盘点成员id
    private Integer memberId;

    //仓库id
    private Integer whId;

    //状态（n正常，d差异，s解决）
    private String status;

    //盘点时间
    private Date createAt;
    //仓库
    private String whName;
    //操作员
    private String memberName;

    private List<CheckChemDTO> checkChemList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public List<CheckChemDTO> getCheckChemList() {
        return checkChemList;
    }

    public void setCheckChemList(List<CheckChemDTO> checkChemList) {
        this.checkChemList = checkChemList;
    }

    @Override
    public String toString() {
        return "CheckRecodeDetailDTO{" +
                "id=" + id +
                ", fcode='" + fcode + '\'' +
                ", orgId=" + orgId +
                ", itemNo='" + itemNo + '\'' +
                ", memberId=" + memberId +
                ", whId=" + whId +
                ", status='" + status + '\'' +
                ", createAt=" + createAt +
                ", whName='" + whName + '\'' +
                ", memberName='" + memberName + '\'' +
                ", checkChemList=" + checkChemList +
                '}';
    }
}
