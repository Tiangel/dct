package yxinfo.dct.inteface.context.chem;

/**
 * Created by dy on 2016/7/28.
 */
public interface ChemTrajReasonNo {

    /**
     * 入库
     */
    Short INTO_WH = 1;

    /**
     * 出入仓库
     */
    Short IN_OUT_WH = 2;

    /**
     * 出入实验室
     */
    Short IN_OUT_LAB = 3;

    /**
     * 回库
     */
    Short BACK_WH = 4;

    /**
     * 回收
     */
    Short RECYCLY = 5;

}
