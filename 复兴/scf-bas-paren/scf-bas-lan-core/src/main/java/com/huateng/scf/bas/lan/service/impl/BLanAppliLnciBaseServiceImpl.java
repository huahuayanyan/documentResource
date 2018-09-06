/**
 * 
 */
package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.ext.ExtBLanDAO;
import com.huateng.scf.bas.lan.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService;
import com.huateng.scf.bas.sys.constant.WorkflowConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 借据申请信息实现类
 * </p>
 *
 * @author huangshuidan
 * @date 2017年1月17日 下午3:00:16
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年1月17日下午3:00:16             新增
 *
 * </pre>
 */
@ScubeService
@Service(IBLanAppliLnciBaseService.BEAN_ID)
public class BLanAppliLnciBaseServiceImpl implements IBLanAppliLnciBaseService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;//借据申请表DAO
	
	@Resource(name = "ExtBLanDAO")
	ExtBLanDAO extblandao;
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService#queryBLanAppliLnciBaseByAppno(java.lang.String)
	 */
	@Override
	public BLanAppliLnciBase queryBLanAppliLnciBaseByAppno(String appno) throws ScubeBizException {
		log.debug("appno="+appno);
		BLanAppliLnciBase bLanAppliLnciBase=new BLanAppliLnciBase();
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase bLanAppliLnciBaseDao = ibLanAppliLnciBaseDAO.selectByAppno(appno);//放款申请对应一条借据
		if(null!=bLanAppliLnciBaseDao){
			BeanUtils.copyProperties(bLanAppliLnciBaseDao,bLanAppliLnciBase);
		}
		return bLanAppliLnciBase;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService#updateBLanAppliLnciBase(com.huateng.scf.bas.lan.model.BLanAppliLnciBase)
	 */
	@Override
	public void updateBLanAppliLnciBase(BLanAppliLnciBase bLanAppliLnciBase) throws ScubeBizException {
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase bLanAppliLnciBaseDao=new com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase();
		if(null!=bLanAppliLnciBase){
			BeanUtils.copyProperties(bLanAppliLnciBase,bLanAppliLnciBaseDao);
			ibLanAppliLnciBaseDAO.updateByPrimaryKeySelective(bLanAppliLnciBaseDao);
		}
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService#findBLanAppliLnciBaseByDebtId(java.lang.String)
	 */
	@Override
	public BLanAppliLnciBase findBLanAppliLnciBaseByDebtId(String debetId) throws ScubeBizException {
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase bLanAppliLnciBaseDao=ibLanAppliLnciBaseDAO.findBLanAppliLnciBaseByDebtId(debetId);
		BLanAppliLnciBase bLanAppliLnciBase=new BLanAppliLnciBase();
		if(null!=bLanAppliLnciBaseDao){
			BeanUtils.copyProperties(bLanAppliLnciBaseDao,bLanAppliLnciBase);
			return bLanAppliLnciBase;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.lan.service.IBLanAppliLnciBaseService#queryBLanAppliLnciBaseByDebtNo(java.lang.String)
	 */
	@Override
	public BLanAppliLnciBase queryBLanAppliLnciBaseByDebtNo(String debetNo) throws ScubeBizException {
		com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase bLanAppliLnciBaseDao=ibLanAppliLnciBaseDAO.queryBLanAppliLnciBaseByDebtNo(debetNo);
		BLanAppliLnciBase bLanAppliLnciBase=new BLanAppliLnciBase();
		if(null!=bLanAppliLnciBaseDao){
			BeanUtils.copyProperties(bLanAppliLnciBaseDao,bLanAppliLnciBase);
			return bLanAppliLnciBase;
		}
		return null;
	}
	
	
	/****************************************应收账款融资（配置版）金额校验相关方法=======start  *****************************************/
	
	/**
	 * 根据合同号查询流程中的借据敞口余额汇总
	 * @param mastcontno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月6日上午11:29:25
	 */
	@Override
	public List<HashMap<String, BigDecimal>> getFlowRiskAmtByMastContno(String mastContno)
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("mastContno", mastContno);
		//用于计算流程中的借据敞口，配置版放款除审批通过及否决，均在流程中
		List<String> appliStatusDtl = new ArrayList<String>();
		appliStatusDtl.add(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		appliStatusDtl.add(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		omap.put("appliStatusDtl", appliStatusDtl);
		List<HashMap<String, BigDecimal>> list = extblandao.getFlowRiskAmtByMastContno(omap);
		return list;
	}
	
	/**
	 * 统计流程中的借据金额
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月6日下午1:41:17
	 */
	@Override
	public List<HashMap<String, BigDecimal>> getFlowKindsOfSumByMastContno(String mastContno)
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("mastContno", mastContno);
		//用于计算流程中的借据敞口，配置版放款除审批通过及否决，均在流程中
		List<String> appliStatusDtl = new ArrayList<String>();
		appliStatusDtl.add(WorkflowConstant.APPLI_STATUS_DTL_APPROVED);
		appliStatusDtl.add(WorkflowConstant.APPLI_STATUS_DTL_REFUSED);
		omap.put("appliStatusDtl", appliStatusDtl);
		List<HashMap<String, BigDecimal>> list = extblandao.getFlowKindsOfSumByMastContno(omap);
		return list;
	}
	
	/****************************************应收账款融资（配置版）金额校验相关方法=======end  *****************************************/
}
