package yxinfo.dct.inteface.dto.approve.biz;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by dy on 2016/6/30.
 */
public class ApproveExtraMsgDTO extends BaseDTO {

    private static final long serialVersionUID = 5930688605692782045L;

    /**
     * 列表
     */
    private String listTitle;

    /**
     * 提交人姓名
     */
    private String subMemberName;

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public String getSubMemberName() {
        return subMemberName;
    }

    public void setSubMemberName(String subMemberName) {
        this.subMemberName = subMemberName;
    }
}
