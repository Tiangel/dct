package yxinfo.dct.inteface.dto.chem;


import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.res.biz.RetUploadFileDTO;

import java.util.List;

/**
 * Created by hanley on 2016/6/16.
 */
public class UploadRespMsg extends BaseDTO {

    private static final long serialVersionUID = 5465473734846639535L;

    private String code;

    private List<RetUploadFileDTO> data;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<RetUploadFileDTO> getData() {
        return data;
    }

    public void setData(List<RetUploadFileDTO> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
