package yxinfo.dct.inteface.dto.equipment;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Delete;
import yxinfo.dct.inteface.validation.groups.Select;
import yxinfo.dct.inteface.validation.groups.Update;
import yxinfo.dct.inteface.validation.groups.equipment.UpdateEquipment;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by zh on 2016/6/23.
 */
public class EquRfidDTO extends BaseDTO {

    //@Digits( integer = 10, fraction = 0, groups = Update.class, message = ErrorCode.EQU_RFIDID_LENGTH)
    @NotNull( groups =  Delete.class, message = ErrorCode.EQU_RFIDID_NOTNULL )
    private Integer id;

    //RFID码
    @Length(max = 255, groups = {Add.class, Select.class},message = ErrorCode.EQU_RFIDFCODE_LENGTH)
    @NotEmpty(groups = {UpdateEquipment.class,Add.class}, message = ErrorCode.EQU_RFIDFCODE_NOTNULL)
    private String fcode;

    //状态（1未使用, 2已使用）
    @Length(max = 2, groups = {UpdateEquipment.class, Add.class}, message = ErrorCode.EQU_RFIDSTATUS_LENGTH)
    @NotEmpty(groups = {UpdateEquipment.class, Add.class}, message = ErrorCode.EQU_RFIDSTATUS_NOTNULL)
    private String status;

    //创建时间
    private Date createAt;

    //使用时间
    @NotNull( groups = UpdateEquipment.class, message = ErrorCode.EQU_RFIDIDUSEAT_NOTNULL_ )
    private Date useAt;


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

    public Date getUseAt() {
        return useAt;
    }

    public void setUseAt(Date useAt) {
        this.useAt = useAt;
    }
}
