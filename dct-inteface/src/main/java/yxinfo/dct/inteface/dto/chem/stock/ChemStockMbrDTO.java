package yxinfo.dct.inteface.dto.chem.stock;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;

import java.util.List;

/**
 * Created by dy on 2016/10/19.
 */
public class ChemStockMbrDTO extends BaseDTO {

    private static final long serialVersionUID = -5022658285830005777L;

    // 成员工号
    private String mbrCode;

    // 真实姓名
    private String mbrRealName;

    // 成员信息
    private MemberDTO member;

    // 库存信息
    private List<ChemStockDTO> stocks;

    // 数量
    private Integer count;

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode( String mbrCode ) {
        this.mbrCode = mbrCode;
    }

    public String getMbrRealName() {
        return mbrRealName;
    }

    public void setMbrRealName( String mbrRealName ) {
        this.mbrRealName = mbrRealName;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember( MemberDTO member ) {
        this.member = member;
    }

    public List<ChemStockDTO> getStocks() {
        return stocks;
    }

    public void setStocks( List<ChemStockDTO> stocks ) {
        this.stocks = stocks;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount( Integer count ) {
        this.count = count;
    }
}
