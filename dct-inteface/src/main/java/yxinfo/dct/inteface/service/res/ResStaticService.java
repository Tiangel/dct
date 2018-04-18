package yxinfo.dct.inteface.service.res;

import yxinfo.dct.inteface.dto.res.ResStaticDTO;
import yxinfo.dct.inteface.dto.res.ResUploadBoundDTO;

/**
 * Created by dy on 2016/7/1.
 */
public interface ResStaticService {

    /**
     * 添加静态资源
     * @param resStaticDTO
     * @return 静态资源id
     */
    Integer addStatic( ResStaticDTO resStaticDTO );

    /**
     * 获取静态资源
     * @param key
     * @return
     */
    ResStaticDTO getStaticBykey( Integer key );

    /**
     * 获取资源上传约束
     * @param code 约束编号
     * @return
     */
    ResUploadBoundDTO getUploadBound( String code );


}
