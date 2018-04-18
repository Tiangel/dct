package yxinfo.dct.inteface.service.res;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by dy on 2016/7/12.
 */
public interface SearchService {

    /**
     * 创建文档
     * @param doc 文档内容
     * @param docType 文档名称, 统一使用doc的类名
     * @param key 文档唯一标识
     */
    boolean addDoc( BaseDTO doc, String docType, String key );

    /**
     * 更新文档
     * @param doc 文档内容, 全量更新
     * @param docType 文档名称, 统一使用doc的类名
     * @param key 文档唯一标识
     */
    boolean updateDoc( BaseDTO doc, String docType, String key );

    /**
     * 删除文档
     * @param docType 文档名称, 统一使用doc的类名
     * @param key 文档唯一标识
     * @return
     */
    boolean deleteDoc( String docType, String key );

    /**
     * 根据唯一标识获取文档
     * @param docType 文档名称, 统一使用doc的类名
     * @param key 文档唯一标识
     * @return
     */
    BaseDTO getDocByKey( String docType, String key );

}
