package yxinfo.dct.inteface.dto.warn;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;

/**
 * @author lovetcat
 * @date 2016/8/4 11:24
 */
public class WarnPersonItemDTO extends BaseDTO {

    private static final long serialVersionUID = 7907807390905369859L;

    private String itemNo;

    //组织id
    private Integer orgId;

    private Integer personId;

    private String itemName;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
