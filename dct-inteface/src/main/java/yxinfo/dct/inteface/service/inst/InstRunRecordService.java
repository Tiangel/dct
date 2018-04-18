package yxinfo.dct.inteface.service.inst;

import yxinfo.dct.inteface.dto.ctrl.CtrlInstRunRecordDTO;
import yxinfo.dct.inteface.dto.inst.InstRunRecord4TVShowDTO;

/**
 * @author sxd
 * @date 2016/8/13 10:44
 */
public interface InstRunRecordService {

    /**
     * 根据传入的instRunRecordDTO判断插入或更新数据
     * @param ctrlInstRunRecordDTO
     * @return
     */
    int edit(CtrlInstRunRecordDTO ctrlInstRunRecordDTO);

    InstRunRecord4TVShowDTO getInstRunRecord4TVShow(Integer labId);
}
