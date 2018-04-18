package yxinfo.dct.inteface.dto.chem.chemical;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 化学品DTO
 * Created by dy on 2016/6/21.
 */
public class ChemChemicalDTO extends BaseDTO {

    private static final long serialVersionUID = 3260127290853065121L;

    @NotNull( groups = Update.class, message = ErrorCode.CHEM_CHEM_ID_NOT_EMPTY )
    private Integer id;

    //名称
    @NotEmpty( groups = Add.class, message = ErrorCode.NAME_NOT_EMPTY )
    private String fname;

    //英文名称
    private String enName;

    //CAS码
    @NotEmpty( groups = Add.class, message = ErrorCode.CHEM_CAS_NOT_EMPTY )
    private String cas;

    //类别
    private List<ChemCategoryDTO> categories;

    //性质
    private List<ChemNatureDTO> natures;

    //废弃物类别
    private List<ChemCategoryDTO> wasteCategories;

    //废弃物性质
    private List<ChemNatureDTO> wasteNatures;

    //有害物
    private String harm;

    //分子式
    private String molFormula;

    //分子量
    private String molWeight;

    //废物处置方法
    private ChemDisposalDTO disposal;

    //类型（1危险化学品，2一般化学品）
    private String ftype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public List<ChemCategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<ChemCategoryDTO> categories) {
        this.categories = categories;
    }

    public List<ChemNatureDTO> getNatures() {
        return natures;
    }

    public void setNatures(List<ChemNatureDTO> natures) {
        this.natures = natures;
    }

    public List<ChemCategoryDTO> getWasteCategories() {
        return wasteCategories;
    }

    public void setWasteCategories(List<ChemCategoryDTO> wasteCategories) {
        this.wasteCategories = wasteCategories;
    }

    public List<ChemNatureDTO> getWasteNatures() {
        return wasteNatures;
    }

    public void setWasteNatures(List<ChemNatureDTO> wasteNatures) {
        this.wasteNatures = wasteNatures;
    }

    public String getHarm() {
        return harm;
    }

    public void setHarm(String harm) {
        this.harm = harm;
    }

    public String getMolFormula() {
        return molFormula;
    }

    public void setMolFormula(String molFormula) {
        this.molFormula = molFormula;
    }

    public String getMolWeight() {
        return molWeight;
    }

    public void setMolWeight(String molWeight) {
        this.molWeight = molWeight;
    }

    public ChemDisposalDTO getDisposal() {
        return disposal;
    }

    public void setDisposal(ChemDisposalDTO disposal) {
        this.disposal = disposal;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }
}
