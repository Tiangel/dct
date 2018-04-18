package yxinfo.dct.inteface.dto.ctrl;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.evt.EvtNoticeDTO;
import yxinfo.dct.inteface.dto.inst.InstRunRecord4TVShowDTO;
import yxinfo.dct.inteface.dto.pro.ProjectDTO;
import yxinfo.dct.inteface.dto.warn.WarnShow4AppDTO;

import java.util.List;

/**
 * @author sxd
 * @date 2016/8/12 9:10
 */
public class CtrlLabMsgShowDTO extends BaseDTO {
    //IN
    private Integer orgId;

    private Integer labId;

    //OUT
    //实验项目
    private List<String> projectNameList;
    //公告
    private EvtNoticeDTO noticeDTO;
    //预警
    private List<WarnShow4AppDTO> warnShowDTOList;
    //设备运行情况
    private InstRunRecord4TVShowDTO instRunRecord4TVShowDTO;
    //试剂情况
    private ChemReagent4TVShowDTO chemReagent4TVShowDTO;
    //温度和湿度
    private CtrlTempHumDTO ctrlTempHumDTO;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public List<String> getProjectNameList() {
        return projectNameList;
    }

    public void setProjectNameList(List<String> projectNameList) {
        this.projectNameList = projectNameList;
    }

    public EvtNoticeDTO getNoticeDTO() {
        return noticeDTO;
    }

    public void setNoticeDTO(EvtNoticeDTO noticeDTO) {
        this.noticeDTO = noticeDTO;
    }

    public List<WarnShow4AppDTO> getWarnShowDTOList() {
        return warnShowDTOList;
    }

    public void setWarnShowDTOList(List<WarnShow4AppDTO> warnShowDTOList) {
        this.warnShowDTOList = warnShowDTOList;
    }

    public InstRunRecord4TVShowDTO getInstRunRecord4TVShowDTO() {
        return instRunRecord4TVShowDTO;
    }

    public void setInstRunRecord4TVShowDTO(InstRunRecord4TVShowDTO instRunRecord4TVShowDTO) {
        this.instRunRecord4TVShowDTO = instRunRecord4TVShowDTO;
    }

    public ChemReagent4TVShowDTO getChemReagent4TVShowDTO() {
        return chemReagent4TVShowDTO;
    }

    public void setChemReagent4TVShowDTO(ChemReagent4TVShowDTO chemReagent4TVShowDTO) {
        this.chemReagent4TVShowDTO = chemReagent4TVShowDTO;
    }

    public CtrlTempHumDTO getCtrlTempHumDTO() {
        return ctrlTempHumDTO;
    }

    public void setCtrlTempHumDTO(CtrlTempHumDTO ctrlTempHumDTO) {
        this.ctrlTempHumDTO = ctrlTempHumDTO;
    }

    @Override
    public String toString() {
        return "CtrlLabMsgShowDTO{" +
                "orgId=" + orgId +
                ", labId=" + labId +
                ", projectNameList=" + projectNameList +
                ", noticeDTO=" + noticeDTO +
                ", warnShowDTOList=" + warnShowDTOList +
                ", instRunRecord4TVShowDTO=" + instRunRecord4TVShowDTO +
                ", chemReagent4TVShowDTO=" + chemReagent4TVShowDTO +
                ", ctrlTempHumDTO=" + ctrlTempHumDTO +
                '}';
    }
}
