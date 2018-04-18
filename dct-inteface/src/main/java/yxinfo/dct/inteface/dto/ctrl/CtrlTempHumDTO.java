package yxinfo.dct.inteface.dto.ctrl;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lovetcat
 * @date 2016/8/13 19:37
 */
public class CtrlTempHumDTO extends BaseDTO {

    private String equNo;

    //温度
    private BigDecimal temp;

    //湿度
    private BigDecimal hum;

    private Date updateAt;


    public String getEquNo() {
        return equNo;
    }

    public void setEquNo(String equNo) {
        this.equNo = equNo;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getHum() {
        return hum;
    }

    public void setHum(BigDecimal hum) {
        this.hum = hum;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "CtrlTempHumDTO{" +
                "equNo='" + equNo + '\'' +
                ", temp='" + temp + '\'' +
                ", hum='" + hum + '\'' +
                ", updateAt=" + updateAt +
                '}';
    }
}
