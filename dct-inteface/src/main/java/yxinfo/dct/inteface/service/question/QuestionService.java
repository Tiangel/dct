package yxinfo.dct.inteface.service.question;

import yxinfo.dct.inteface.dto.question.CategQuestionDTO;
import yxinfo.dct.inteface.dto.question.QuCategDTO;
import yxinfo.dct.inteface.dto.question.QuestionDTO;

import java.util.List;

/**
 * Created by cy on 2016/6/20.
 */
public interface QuestionService {

    /**
     * 插入类目记录
     *
     * @param record
     * @return 主键id
     */
    Integer addCateg(CategQuestionDTO record);

    /**
     * 插入试题记录
     *
     * @param record
     * @return 添加成功返回试题信息，否则返回null
     */
    Integer addCategQuestion(QuestionDTO record);

    /**
     * 查询类目试题记录
     *
     * @param categId
     * @return
     */
    List<QuestionDTO> getQuestionsByCategId(Integer categId);

    /**
     * 查询类目信息
     *
     * @return
     */
    List<QuCategDTO> getQuCategs();

}
