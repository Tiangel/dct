package yxinfo.dct.inteface.dto.chem.chemical;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * 化学品性质DTO
 * Created by dy on 2016/6/21.
 */
public class ChemNatureDTO extends BaseDTO {

    private static final long serialVersionUID = -4027711884667338227L;

    //id
    private Integer id;

    //性质编号
    private String fcode;

    //名称
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
