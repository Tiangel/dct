package yxinfo.dct.inteface.dto.warn;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.List;

/**
 * @author lovetcat
 * @date 2016/8/4 16:55
 */
public class WarnRecordAndPersonsDTO extends BaseDTO {

    private static final long serialVersionUID = 8323881796458316792L;

    private WarnRecordDTO warnRecordDTO;

    private List<WarnPersonDTO> warnPersonDTOList;

    public WarnRecordDTO getWarnRecordDTO() {
        return warnRecordDTO;
    }

    public void setWarnRecordDTO(WarnRecordDTO warnRecordDTO) {
        this.warnRecordDTO = warnRecordDTO;
    }

    public List<WarnPersonDTO> getWarnPersonDTOList() {
        return warnPersonDTOList;
    }

    public void setWarnPersonDTOList(List<WarnPersonDTO> warnPersonDTOList) {
        this.warnPersonDTOList = warnPersonDTOList;
    }

    @Override
    public String toString() {
        return "WarnRecordAndPersonsDTO{" +
                "warnRecordDTO=" + warnRecordDTO +
                ", warnPersonDTOList=" + warnPersonDTOList +
                '}';
    }
}
