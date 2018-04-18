package yxinfo.dct.inteface.dto.question;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 试题bean
 *
 * Created by cy on 2016/6/20.
 */
public class QuestionDTO extends BaseDTO {

    /**
     * 试题类目表id
     */
    @Digits( integer = 10, fraction = 0, groups = Add.class, message = ErrorCode.QUESTION_CATEGID_LENGTH)
    @NotNull( groups = Add.class, message = ErrorCode.QUESTION_CATEGID_NOTNULL )
    private Integer categId;

    /**
     * 试题id
     */
    private Integer questId;

    /**
     * 题目类型（1单项选择题, 2多项选择, 3判断题）
     */
    @Length( max = 1, groups = Add.class, message = ErrorCode.QUESTION_QUESTTYPE_LENGTH )
    @NotEmpty( groups = Add.class, message = ErrorCode.QUESTION_QUESTTYPE_NOTNULL )
    private String questType;

    /**
     * 试题分析
     */
    @Length( max = 2000, groups = Add.class, message = ErrorCode.QUESTION_QUESTANALYSE_LENGTH )
    private String questAnalyse;

    /**
     * 试题答案
     */
    @Length( max = 255, groups = Add.class, message = ErrorCode.QUESTION_QUESTANSWER_LENGTH )
    @NotEmpty( groups = Add.class, message = ErrorCode.QUESTION_QUESTANSWER_NOTNULL )
    private String questAnswer;

    /**
     * 试题内容
     */
    @Length( max = 2000, groups = Add.class, message = ErrorCode.QUESTION_QUESTCONTEXT_LENGTH )
    @NotEmpty( groups = Add.class, message = ErrorCode.QUESTION_QUESTCONTEXT_NOTNULL )
    private String questContext;

    /**
     * 试题选项list
     */
    @Valid
    private List<QuQuestOptDTO> questOptDto;

    /**
     * 答题人选择的答案
     */
    private String userChooseAnswer;

    public QuestionDTO() {
    }

    public QuestionDTO(Integer categId, Integer questId, String questType, String questAnalyse, String questAnswer, String questContext, List<QuQuestOptDTO> questOptDto, String userChooseAnswer) {
        this.categId = categId;
        this.questId = questId;
        this.questType = questType;
        this.questAnalyse = questAnalyse;
        this.questAnswer = questAnswer;
        this.questContext = questContext;
        this.questOptDto = questOptDto;
        this.userChooseAnswer = userChooseAnswer;
    }

    public Integer getCategId() {
        return categId;
    }

    public void setCategId(Integer categId) {
        this.categId = categId;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    public String getQuestType() {
        return questType;
    }

    public void setQuestType(String questType) {
        this.questType = questType;
    }

    public String getQuestAnalyse() {
        return questAnalyse;
    }

    public void setQuestAnalyse(String questAnalyse) {
        this.questAnalyse = questAnalyse;
    }

    public String getQuestAnswer() {
        return questAnswer;
    }

    public void setQuestAnswer(String questAnswer) {
        this.questAnswer = questAnswer;
    }

    public String getQuestContext() {
        return questContext;
    }

    public void setQuestContext(String questContext) {
        this.questContext = questContext;
    }

    public List<QuQuestOptDTO> getQuestOptDto() {
        return questOptDto;
    }

    public void setQuestOptDto(List<QuQuestOptDTO> questOptDto) {
        this.questOptDto = questOptDto;
    }

    public String getUserChooseAnswer() {
        return userChooseAnswer;
    }

    public void setUserChooseAnswer(String userChooseAnswer) {
        this.userChooseAnswer = userChooseAnswer;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "categId=" + categId +
                ", questId=" + questId +
                ", questType='" + questType + '\'' +
                ", questAnalyse='" + questAnalyse + '\'' +
                ", questAnswer='" + questAnswer + '\'' +
                ", questContext='" + questContext + '\'' +
                '}';
    }
}
