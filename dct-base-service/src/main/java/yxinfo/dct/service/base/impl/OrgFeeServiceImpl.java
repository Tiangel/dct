package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import yxinfo.dct.inteface.service.base.OrgFeeService;
import yxinfo.dct.service.base.dal.OrgBopDal;
import yxinfo.dct.service.base.dal.OrgDal;
import yxinfo.dct.service.base.dal.OrgFeeDal;
import yxinfo.dct.service.base.dao.model.SysOrg;
import yxinfo.dct.service.base.dao.model.SysOrgBop;
import yxinfo.dct.service.base.dao.model.SysOrgFee;
import yxinfo.dct.service.base.dao.model.SysOrgFeeKey;

import javax.annotation.Resource;

/**
 * Created by dy on 2016/8/9.
 */
@Component
@Service( version = "1.0.0", owner = "dy" )
public class OrgFeeServiceImpl implements OrgFeeService {

    @Transactional( readOnly = true )
    public boolean checkBal( int orgId, String itemNo, int count ) {
        if ( orgId <= 0 || count <= 0 ) return false;
        // ~获取组织
        SysOrg org = orgDal.selectByPrimaryKey( orgId );
        if ( org == null ) return false;
        // ~获取计费设置
        SysOrgFee fee = getOrgFee( orgId, itemNo );
        if ( fee == null ) return false;
        return org.getBal() >= fee.getFee() * count;
    }

    @Transactional
    public void expend( int orgId, String itemNo, int count, int relId ) {
        if ( orgId <= 0 || count <= 0 ) return;
        SysOrgFee fee = getOrgFee( orgId, itemNo );
        if ( fee == null ) return;
        // ~减去组织余额
        int feeAmt = fee.getFee() * count;
        plusOrgBal( orgId, -feeAmt );
        log.info( "扣除组织id: [{}]余额(分): [{}], 计费项目[{}]", orgId, feeAmt, itemNo );
        // ~添加收支记录
        addBop( orgId, false, itemNo, feeAmt, relId );
        return;
    }

    /**
     * 增加商户余额
     * @param orgId
     * @param amt
     * @return
     */
    private int plusOrgBal( int orgId, int amt ) {
        return orgDal.plusOrgBal( orgId, amt );
    }

    /**
     * 获取商户计费项目
     * @param orgId
     * @param itemNo
     * @return
     */
    private SysOrgFee getOrgFee( int orgId, String itemNo ) {
        SysOrgFeeKey feeKey = new SysOrgFee();
        feeKey.setItemNo( itemNo );
        feeKey.setOrgId( orgId );
        return orgFeeDal.selectByPrimaryKey( feeKey );
    }

    /**
     * 添加组织收支明细
     * @param orgId
     * @param isIncome
     * @param itemNo
     * @param amt
     * @param relId
     * @return
     */
    private int addBop( int orgId, boolean isIncome, String itemNo, int amt, int relId ) {
        SysOrgBop bop = new SysOrgBop();
        bop.setOrgId( orgId );
        bop.setItemNo( itemNo );
        bop.setFtype( isIncome ? "1" : "2" );
        bop.setAmt( amt );
        bop.setRelId( relId );
        return orgBopDal.insertSelective( bop );
    }

    @Resource private OrgDal orgDal;
    @Resource private OrgBopDal orgBopDal;
    @Resource private OrgFeeDal orgFeeDal;

    private static final Logger log = LoggerFactory.getLogger( OrgFeeServiceImpl.class );
}
