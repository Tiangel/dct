package yxinfo.dct.inteface.dto.topicLog;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * 课题日志中使用的试剂
 * <p>
 * Created by cy on 2016/6/22.
 */
public class TopicLogReagentDTO extends BaseDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 试剂id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.TOPICLOG_REAGENTID_LENGTH)
    @NotNull(message = ErrorCode.TOPICLOG_REAGENTID_NOTNULL)
    private Integer reagentId;
    private ChemReagentDTO chemReagentDTO;

    /**
     * 日志id
     */
    private Integer logId;

    /**
     * 用量
     */
    @Length(max = 255, message = ErrorCode.TOPICLOG_USED_LENGTH)
    @NotEmpty(message = ErrorCode.TOPICLOG_USED_NOTNULL)
    private String used;

    /**
     * 试剂名称
     */
    private String reagentName;

    public TopicLogReagentDTO() {
    }

    public TopicLogReagentDTO(Integer id, Integer reagentId, ChemReagentDTO chemReagentDTO, Integer logId, String used, String reagentName) {
        this.id = id;
        this.reagentId = reagentId;
        this.chemReagentDTO = chemReagentDTO;
        this.logId = logId;
        this.used = used;
        this.reagentName = reagentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReagentId() {
        return reagentId;
    }

    public void setReagentId(Integer reagentId) {
        this.reagentId = reagentId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getReagentName() {
        return reagentName;
    }

    public void setReagentName(String reagentName) {
        this.reagentName = reagentName;
    }

    public ChemReagentDTO getChemReagentDTO() {
        return chemReagentDTO;
    }

    public void setChemReagentDTO(ChemReagentDTO chemReagentDTO) {
        this.chemReagentDTO = chemReagentDTO;
    }

    @Override
    public String toString() {
        return "TopicLogReagentDTO{" +
                "id=" + id +
                ", reagentId=" + reagentId +
                ", chemReagentDTO=" + chemReagentDTO +
                ", logId=" + logId +
                ", used='" + used + '\'' +
                ", reagentName='" + reagentName + '\'' +
                '}';
    }
}
