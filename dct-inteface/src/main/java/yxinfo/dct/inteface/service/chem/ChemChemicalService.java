package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.chemical.*;

import java.util.List;

/**
 * Created by dy on 2016/6/22.
 */
public interface ChemChemicalService {

    /**
     * 分页查询化学品
     * @api 108003 搜索化学品
     * @param chemChemicalPage
     * @return
     * @throws Exception
     */
    PageDTO<List<ChemChemicalDTO>> getChemPage( PageDTO<ChemChemicalDTO> chemChemicalPage );

    /**
     * 根据cas查询化学品详情
     * @param cas
     * @return
     */
    List<ChemChemicalDTO> getChemDetailByCas( String cas );

    /**
     * 根据名称查询化学品基本信息
     * @param name
     * @return
     */
    List<ChemChemicalDTO> getChemByName( String name );

    /**
     * 根据id查询化学品
     * @api 108018 获取化学品详情
     * @param id
     * @return
     * @throws Exception
     */
    ChemChemicalDTO getChemKey( Integer id );

    /**
     * 获取单位列表
     * @api 108012 获取单位列表
     * @return
     */
    List<ChemUnitDTO> getUnits();

    /**
     * 获取单位
     * @param id
     * @return
     */
    ChemUnitDTO getUnit( Integer id );

    /**
     * 获取规格列表
     * @api 108013 获取规格列表
     * @return
     */
    List<ChemSpecDTO> getSpecs();

    /**
     * 获取规格
     * @param id
     * @return
     */
    ChemSpecDTO getSpec( Integer id );

    /**
     * 获取化学品类别
     * @api 108038 获取化学品类别
     * @param category
     * @return
     */
    List<ChemCategoryDTO> getCategories( ChemCategoryDTO category );

    /**
     * 添加化学品类别
     * @param category
     * @return
     */
    int addCategory( ChemCategoryDTO category );

    /**
     * 获取化学品类别
     * @param id
     * @return
     */
    ChemCategoryDTO getCategor( Integer id );

    /**
     * 根据类别获取化学品id
     * @param categorId
     * @return
     */
    List<Integer> getChemIdsByCategorId( Integer categorId );

    /**
     * 添加化学品
     * @api 108039
     * @param chemicalDTO
     * @return
     */
    int addChem( ChemChemicalDTO chemicalDTO );

    /**
     * 添加化学品
     * @param name
     * @param cas
     * @return
     */
    int addChem( String name, String cas );

    /**
     * 修改化学品
     * @api 108040
     * @param chemicalDTO
     * @return
     */
    int editChem( ChemChemicalDTO chemicalDTO );

    /**
     * 根据id查询化学品简要信息
     * @param chemicalDTO
     * @return
     */
    ChemChemicalDTO getChemSimp( Integer id );
}
