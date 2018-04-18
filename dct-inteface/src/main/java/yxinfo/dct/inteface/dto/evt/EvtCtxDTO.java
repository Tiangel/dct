package yxinfo.dct.inteface.dto.evt;

import yxinfo.dct.inteface.dto.BaseDTO;

public class EvtCtxDTO extends BaseDTO {

    private static final long serialVersionUID = -2533558932344105767L;

    private Integer ntfId;

    //内容
    private String fcontext;

    public Integer getNtfId() {
        return ntfId;
    }

    public void setNtfId(Integer ntfId) {
        this.ntfId = ntfId;
    }

    public String getFcontext() {
        return fcontext;
    }

    public void setFcontext(String fcontext) {
        this.fcontext = fcontext;
    }
}