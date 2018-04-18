package yxinfo.dct.inteface.dto.question;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.Digits;

/**
 * Created by cy on 2016/6/20.
 */
public class QuQuestOptDTO extends BaseDTO {

    /**
     * 选项id
     */
    private Integer id;

    /**
     * 试题id
     */
    private Integer questId;

    /**
     * 选项编号
     */
    @Length(max = 1, groups = Add.class, message = ErrorCode.QUESTION_QUESTOPTCODE_LENGTH)
    @NotEmpty(groups = Add.class, message = ErrorCode.QUESTION_QUESTOPTCODE_NOTNULL)
    private String fcode;

    /**
     * 选项内容
     */
    @Length(max = 500, groups = Add.class, message = ErrorCode.QUESTION_QUESTOPTTEXT_LENGTH)
    @NotEmpty(groups = Add.class, message = ErrorCode.QUESTION_QUESTOPTTEXT_NOTNULL)
    private String ftext;

    public QuQuestOptDTO() {
    }

    public QuQuestOptDTO(Integer id, Integer questId, String fcode, String ftext) {
        this.id = id;
        this.questId = questId;
        this.fcode = fcode;
        this.ftext = ftext;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getFtext() {
        return ftext;
    }

    public void setFtext(String ftext) {
        this.ftext = ftext;
    }

    @Override
    public String toString() {
        return "QuQuestOptDTO{" +
                "id=" + id +
                ", questId=" + questId +
                ", fcode='" + fcode + '\'' +
                ", ftext='" + ftext + '\'' +
                '}';
    }
}
