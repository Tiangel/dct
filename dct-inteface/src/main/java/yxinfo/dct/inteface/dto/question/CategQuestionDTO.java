package yxinfo.dct.inteface.dto.question;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import java.util.List;

/**
 * 添加的试题类目及试题bean
 * <p>
 * Created by cy on 2016/6/20.
 */
public class CategQuestionDTO extends BaseDTO {
    /**
     * 类目id  sql_column:id
     */
    private Integer categId;

    /**
     * 试题类目名称 sql_column:fname
     */
    @Length(max = 255, message = ErrorCode.QUESTION_FCATEGNAME_LENGTH )
    @NotEmpty(groups = Add.class, message = ErrorCode.QUESTION_FCATEGNAME_NOTNULL)
    private String fcategName;

    /**
     * 类目描述
     */
    @Length(max = 255, message = ErrorCode.QUESTION_CATEGDESCRIBE_LENGTH)
    private String categDescribe;

    private List<QuestionDTO> questDtoList;

    public CategQuestionDTO() {
    }

    public CategQuestionDTO(Integer categId, String fcategName, String categDescribe, List<QuestionDTO> questDtoList) {
        this.categId = categId;
        this.fcategName = fcategName;
        this.categDescribe = categDescribe;
        this.questDtoList = questDtoList;
    }

    public Integer getCategId() {
        return categId;
    }

    public void setCategId(Integer categId) {
        this.categId = categId;
    }

    public String getFcategName() {
        return fcategName;
    }

    public void setFcategName(String fcategName) {
        this.fcategName = fcategName;
    }

    public String getCategDescribe() {
        return categDescribe;
    }

    public void setCategDescribe(String categDescribe) {
        this.categDescribe = categDescribe;
    }

    public List<QuestionDTO> getQuestDtoList() {
        return questDtoList;
    }

    public void setQuestDtoList(List<QuestionDTO> questDtoList) {
        this.questDtoList = questDtoList;
    }


}
