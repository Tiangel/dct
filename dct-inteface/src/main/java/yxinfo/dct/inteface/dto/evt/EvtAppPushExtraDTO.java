package yxinfo.dct.inteface.dto.evt;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;

/**
 * Created by dy on 2016/6/30.
 */
public class EvtAppPushExtraDTO extends BaseDTO {

    private static final long serialVersionUID = -3129652184457970899L;

    //事件项目编号
    private String itemNo;

    //额外信息id
    private Integer extraMsgId;

    //标题
    private String title;

    //摘要
    private String summary;

    //创建时间
    private Date createAt;

    //事件通知内容
    private String context;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getExtraMsgId() {
        return extraMsgId;
    }

    public void setExtraMsgId(Integer extraMsgId) {
        this.extraMsgId = extraMsgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
