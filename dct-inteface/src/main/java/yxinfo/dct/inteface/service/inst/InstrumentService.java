package yxinfo.dct.inteface.service.inst;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.ctrl.CtrlEqu4InstrumentDTO;
import yxinfo.dct.inteface.dto.inst.InstrumentDTO;

import java.util.List;

/**
 * Created by sxd on 2016/7/14.
 */
public interface InstrumentService {

    /**
     * 根据条件查询仪器分页列表
     * @param pageDTO
     * @return
     */
    PageDTO<List<InstrumentDTO>> getInstrumentPageList(PageDTO<InstrumentDTO> pageDTO);

    /**
     * 获取仪器分页列表(后台调用)
     * @param pageDTO
     * @return
     */
    PageDTO<List<InstrumentDTO>> getInstBackendPageList(PageDTO<InstrumentDTO> pageDTO);

    int addInstrument(InstrumentDTO instrumentDTO);

    int updateInstrument(InstrumentDTO instrumentDTO);

    /**
     * 插入仪器插板,并且更新仪器中的实验室id
     * @param ctrlEqu4InstrumentDTO
     * @return
     */
    int insertCtrlEqu4Instrument(CtrlEqu4InstrumentDTO ctrlEqu4InstrumentDTO);

    int unbundingInstrument(CtrlEqu4InstrumentDTO ctrlEqu4InstrumentDTO);

    InstrumentDTO get(Integer id);
}
