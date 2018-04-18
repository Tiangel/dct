package yxinfo.dct.inteface.dto.warn;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * @author lovetcat
 * @date 2016/8/4 12:08
 */
public class WarnItemNoDTO extends BaseDTO {

    private static final long serialVersionUID = -4825791529741497454L;

    private String itemNo;

    private String itemName;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public WarnItemNoDTO() {
    }

    public WarnItemNoDTO(String itemNo, String itemName) {
        this.itemNo = itemNo;
        this.itemName = itemName;
    }
}
