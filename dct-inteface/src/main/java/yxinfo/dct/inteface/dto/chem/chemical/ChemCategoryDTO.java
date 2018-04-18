package yxinfo.dct.inteface.dto.chem.chemical;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

/**
 * 化学试剂类别DTO
 * Created by dy on 2016/6/21.
 */
public class ChemCategoryDTO extends BaseDTO {

    private static final long serialVersionUID = -7774581579845360413L;

    // id
    private Integer id;

    //编号
    private String fcode;

    //名称
    @NotEmpty( groups = Add.class, message = ErrorCode.NAME_NOT_EMPTY )
    private String fname;

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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}