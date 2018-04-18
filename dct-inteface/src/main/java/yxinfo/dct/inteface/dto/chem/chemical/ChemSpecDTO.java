package yxinfo.dct.inteface.dto.chem.chemical;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * 化学试剂规格DTO
 * Created by dy on 2016/6/21.
 */
public class ChemSpecDTO extends BaseDTO {

    private static final long serialVersionUID = -4976262326614687346L;

    //id
    private Integer id;

    //编号
    private String fcode;

    //名称
    private String fname;

    //别名
    private String alias;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
