package yxinfo.dct.inteface.dto.question;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * 试题类目信息
 * <p>
 * Created by cy on 2016/6/21.
 */
public class QuCategDTO extends BaseDTO {
    /**
     * 类目id
     */
    private Integer categId;

    /**
     * 类目名称
     */
    private String fcategName;

    /**
     * 类目描述
     */
    private String categDescribe;

    /**
     * 试题数量
     */
    private Integer questAmount;

    public QuCategDTO() {
    }

    public QuCategDTO(Integer categId, String fcategName, String categDescribe, Integer questAmount) {
        this.categId = categId;
        this.fcategName = fcategName;
        this.categDescribe = categDescribe;
        this.questAmount = questAmount;
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

    public Integer getQuestAmount() {
        return questAmount;
    }

    public void setQuestAmount(Integer questAmount) {
        this.questAmount = questAmount;
    }

    @Override
    public String toString() {
        return "QuCategDTO{" +
                "categId=" + categId +
                ", fcategName='" + fcategName + '\'' +
                ", questAmount=" + questAmount +
                '}';
    }
}
