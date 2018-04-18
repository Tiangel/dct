package yxinfo.dct.inteface.dto.chem.chemical;

import yxinfo.dct.inteface.dto.BaseDTO;

public class ChemDisposalDTO extends BaseDTO {

    private static final long serialVersionUID = -620185811637855717L;

    private Integer chemId;

    private String content;

    public Integer getChemId() {
        return chemId;
    }

    public void setChemId(Integer chemId) {
        this.chemId = chemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}