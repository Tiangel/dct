package yxinfo.dct.inteface.dto.ctrl;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * @author sxd
 * @date 2016/8/13 11:06
 */
public class CtrlInstRunRecordDTO extends BaseDTO {

    //设备编号
    private String equNo;
    //仪器运行状态，1：开启，2：关闭
    private String status;

    public String getEquNo() {
        return equNo;
    }

    public void setEquNo(String equNo) {
        this.equNo = equNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CtrlInstRunRecordDTO{" +
                "equNo='" + equNo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
