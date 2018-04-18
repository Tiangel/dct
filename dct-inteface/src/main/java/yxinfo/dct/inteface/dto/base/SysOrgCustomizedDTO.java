package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.dto.BaseDTO;

public class SysOrgCustomizedDTO extends BaseDTO {

    private static final long serialVersionUID = -7699302403122674169L;

    private Integer orgId;

    private String logo1;

    private String logo2;

    private String logo3;

    private String banner1;

    private String banner2;

    private String banner3;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId( Integer orgId ) {
        this.orgId = orgId;
    }

    public String getLogo1() {
        return logo1;
    }

    public void setLogo1( String logo1 ) {
        this.logo1 = logo1;
    }

    public String getLogo2() {
        return logo2;
    }

    public void setLogo2( String logo2 ) {
        this.logo2 = logo2;
    }

    public String getLogo3() {
        return logo3;
    }

    public void setLogo3( String logo3 ) {
        this.logo3 = logo3;
    }

    public String getBanner1() {
        return banner1;
    }

    public void setBanner1( String banner1 ) {
        this.banner1 = banner1;
    }

    public String getBanner2() {
        return banner2;
    }

    public void setBanner2( String banner2 ) {
        this.banner2 = banner2;
    }

    public String getBanner3() {
        return banner3;
    }

    public void setBanner3( String banner3 ) {
        this.banner3 = banner3;
    }
}