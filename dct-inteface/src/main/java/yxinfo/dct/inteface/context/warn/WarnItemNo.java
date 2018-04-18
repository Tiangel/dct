package yxinfo.dct.inteface.context.warn;

/**
 * @author sxd
 * @date 2016/8/23 16:13
 */
public enum WarnItemNo {

    WARN_ITEM_RECEIVE("100000", "领用预警", null, new String[]{"100001", "100002", "100008"}),
    WARN_ITEM_RECEIVE_QUANTITY("100001", "领用化学品超出设定的数量", WARN_ITEM_RECEIVE, null),
    WARN_ITEM_RECEIVE_TIME("100002", "领用化学品后未出现超出消失时间", WARN_ITEM_RECEIVE, null),
    WARN_ITEM_RECYCLE("100003", "回收预警", null, null),
    WARN_ITEM_CHECK("100004", "盘点预警", null, null),
    WARN_ITEM_REAGENT_RECYCLE("100005", "回库预警", null, null),
    WARN_ITEM_MIX_CHEM("100006", "混放预警", null, null),
    WARN_ITEM_ENVIRONMENT("100007", "环境预警", null, null),
    WARN_ITEM_RECEIVE_UNLAWFUL("100008", "非法领用", WARN_ITEM_RECEIVE, null);

    private String itemNo;
    private String name;
    private WarnItemNo pitem;
    private String[] childItemNoList;

    private WarnItemNo(String itemNo, String name, WarnItemNo pitem, String[] childItemNoList){
        this.itemNo = itemNo;
        this.name = name;
        this.pitem = pitem;
        this.childItemNoList = childItemNoList;
    }

    public static String getItemName(String itemNo){
        WarnItemNo[] values = WarnItemNo.values();
        for(WarnItemNo item : values){
            if(item.itemNo.equals(itemNo)){
                return item.name;
            }
        }
        return null;
    }

    public static WarnItemNo getPWarnItemNo(String itemNo){
        WarnItemNo[] values = WarnItemNo.values();
        for(WarnItemNo item : values){
            if(item.itemNo.equals(itemNo)){
                return item.pitem;
            }
        }
        return null;
    }

    public static WarnItemNo getWarnItemNo(String itemNo){
        WarnItemNo[] values = WarnItemNo.values();
        for(WarnItemNo item : values){
            if(item.itemNo.equals(itemNo)){
                return item;
            }
        }
        return null;
    }

    public static String[] getItemNos(){
        return new String[]{"100000","100003","100004","100005","100006","100007"};
    }

    public String getItemNo() {
        return itemNo;
    }

    public String getName() {
        return name;
    }

    public WarnItemNo getPitem() {
        return pitem;
    }

    public String[] getChildItemNoList() {
        return childItemNoList;
    }
}
