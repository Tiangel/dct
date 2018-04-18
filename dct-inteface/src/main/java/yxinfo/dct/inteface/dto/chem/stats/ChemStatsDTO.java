package yxinfo.dct.inteface.dto.chem.stats;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Select;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ChemStatsDTO extends BaseDTO {

    private static final long serialVersionUID = 5763051244639523612L;

    private Integer id;

    //组织id
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    //统计项目编号
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_ITEM_NO_NOT_EMPTY )
    private String itemNo;

    //创建日期
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.DATE_NOT_EMPTY )
    private Date statsDate;

    //化学品id
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_CHEM_ID_NOT_EMPTY )
    private Integer msgId;

    //数量
    private Integer count;

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

    public Date getStatsDate() {
        return statsDate;
    }

    public void setStatsDate(Date statsDate) {
        this.statsDate = statsDate;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}