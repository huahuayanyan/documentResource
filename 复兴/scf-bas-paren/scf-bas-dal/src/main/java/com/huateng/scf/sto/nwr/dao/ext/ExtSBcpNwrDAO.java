package com.huateng.scf.sto.nwr.dao.ext;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.dao.vo.SBcpBillNormalAppVO;
import com.huateng.scf.sto.nwr.dao.vo.SBcpBillNormalInOutDO;

import java.util.HashMap;
import java.util.List;
/**
 * 
 * <p>SBcpProductBill仓单产品参数扩展表 数据库访问层通用接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月12日下午3:58:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月12日下午3:58:38	     新增
 *
 * </pre>
 */
public interface ExtSBcpNwrDAO {
    int countSBcpMortBill(HashMap<String, Object> omap);

    @SuppressWarnings("rawtypes")
	List selectSBcpMortBill(HashMap<String, Object> omap, Page page);
    
    @SuppressWarnings("rawtypes")
	List getBillByMidProductId(String billType);
    
    int countAppContInfoBySupplyChainPdId(HashMap<String, Object> omap);
    
    @SuppressWarnings("rawtypes")
	List getAppContInfoBySupplyChainPdId(HashMap<String, Object> omap, Page page);
    
    int countEffectNormalList(HashMap<String, Object> omap);
    
	List<SBcpMortBillNormal> getEffectNormalList(HashMap<String, Object> omap, Page page);

	int countBillnormalListByAppno(HashMap<String, Object> omap);

	List<SBcpBillNormalAppVO> getBillnormalListByAppno(HashMap<String, Object> omap, Page page, boolean flag);
	
	List<SBcpMortBillNormal> getBillExchangeEnteringListByParam(HashMap<String, Object> omap, boolean flag, Page page);

	@SuppressWarnings("rawtypes")
	List getBillNormalAppByAppno(HashMap<String, Object> omap);

	int countBillnormalListBySlaveContno(HashMap<String, Object> omap);

	@SuppressWarnings("rawtypes")
	List getBillnormalListBySlaveContno(HashMap<String, Object> omap, Page page);

	int countBillNormalDeliverableList(HashMap<String, Object> omap);

	List<SBcpMortBillNormal> getBillNormalDeliverableList(HashMap<String, Object> omap, Page page);

	int countBillExchangeEnteringListByParam(HashMap<String, Object> omap);
	
	int countAppliBillnormalList(HashMap<String, Object> omap);

	List<SBcpBillNormalAppVO> getAppliBillnormalList(HashMap<String, Object> omap, Page page, boolean flag);

	int countNormalBillByPara(HashMap<String, Object> omap);

	List<SBcpBillNormalInOutDO> getNormalBillByPara(HashMap<String, Object> omap, Page page);
}