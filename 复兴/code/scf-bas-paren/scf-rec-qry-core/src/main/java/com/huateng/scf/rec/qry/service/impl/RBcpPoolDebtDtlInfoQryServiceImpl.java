package com.huateng.scf.rec.qry.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.sys.constant.DebtConstants;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.dao.model.DebtBussDtlVO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBussDtl;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBaseInfoService;
import com.huateng.scf.rec.qry.dao.IRBcpPoolDebtDetalInfoQryDao;
import com.huateng.scf.rec.qry.service.IRBcpPoolDebtDtlInfoQryService;
import com.huateng.scube.server.annotation.ScubeParam;
import com.huateng.scube.server.annotation.ScubeService;

import ch.qos.logback.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy;

@ScubeService
@Service("RBcpPoolDebtDtlInfoQryServiceImpl")
public class RBcpPoolDebtDtlInfoQryServiceImpl implements IRBcpPoolDebtDtlInfoQryService {

	@Resource(name = "RBcpDebtBaseInfoServiceImpl")
	IRBcpDebtBaseInfoService rBcpDebtBaseInfoService;
	
	@Resource(name = "IRBcpPoolDebtDetalInfoQryDao")
	IRBcpPoolDebtDetalInfoQryDao rBcpPoolDebtDetalInfoQryDao;
	
	@Autowired
	ScubeUserService scubeUserService;

	@Override
	public Page getDebtQuery(DebtCommonQryVO commonQueryVO, int pageSize, int pageNo) {
		String roleFlag = "0"; // 岗位标志位
		// List roleList = SCFCommonFunctions.getGlobalInfo().getUserRoles();
		UserInfo gd = ContextHolder.getUserInfo();
		List<String> roleList = gd.getRoleList();
		if (roleList != null && roleList.size() > 0) {
			for (int i = 0; i < roleList.size(); i++) {
				Object role = roleList.get(i);
				// 判断方式：当前角色当中包含有除客户经理外的其它岗位，Flag为1
				if (!ScfBasConstant.ROLE_ID_MANAGER.equals(String.valueOf(role))) {
					roleFlag = "1";
					break;
				} else {
					roleFlag = "0";
				}
			}
		}

		if ("0".equals(roleFlag)) {
			commonQueryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER);
		} else {
			commonQueryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_BCTL);
		}
//		Page pageQueryResult =rBcpDebtBaseInfoService.getDebtInfoByPerson(pageNo,pageSize,commonQueryVO);
		com.huateng.scf.rec.qry.dao.model.DebtCommonQryVO debtCommonQryVODal = new com.huateng.scf.rec.qry.dao.model.DebtCommonQryVO();
		BeanUtils.copyProperties(commonQueryVO, debtCommonQryVODal);
		List<DebtBillsInfoVO> list =rBcpPoolDebtDetalInfoQryDao.getDebtInfoByPerson(debtCommonQryVODal,pageSize, pageNo);
		List<DebtBillsInfoVO> responseList = new ArrayList<DebtBillsInfoVO>();
		
		for(int i=0;i<list.size();i++){
			DebtBillsInfoVO billsInfoVO =list.get(i);
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(billsInfoVO.getBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
			UserInfo userInfo = scubeUserService.selectUserByTlrNo(billsInfoVO.getTlrNo(),ScfCommonUtil.getBrManagerNo(scubeUserService));
			if(bctlVO!=null&&StringUtils.isNotEmpty(bctlVO.getBrName())){
				billsInfoVO.setBrcodeNm(bctlVO.getBrName());
			}
			if(userInfo!=null&&StringUtils.isNotEmpty(userInfo.getTlrName())){
				billsInfoVO.setTlrName(userInfo.getTlrName());
			}
			responseList.add(billsInfoVO);
		}
		
		Page pageQueryResult = new Page(pageSize, pageNo, 0);
		Integer totalRecord = rBcpPoolDebtDetalInfoQryDao.getDebtCountByPerson(debtCommonQryVODal);
		pageQueryResult.setRecords(responseList);
		pageQueryResult.setTotalRecord(totalRecord);
		return pageQueryResult;
	} 
	


	@Override
	public Page getInvoiceCourseInfoQry(DebtCommonQryVO commonQueryVO, int pageSize, int pageNo) {
		com.huateng.scf.rec.qry.dao.model.DebtCommonQryVO debtCommonQryVODal = new com.huateng.scf.rec.qry.dao.model.DebtCommonQryVO();
		BeanUtils.copyProperties(commonQueryVO, debtCommonQryVODal);

		Page pageResult = rBcpPoolDebtDetalInfoQryDao.selectInvoiceCourseInfo(debtCommonQryVODal, pageSize, pageNo);
		List listResult=pageResult.getRecords();
		
		List responseList = new ArrayList<DebtBussDtlVO>();
		
		for(int i=0;i<listResult.size();i++){
			DebtBussDtlVO dtl =(DebtBussDtlVO) listResult.get(i);
			String applyType = dtl.getApplyType();
			if(applyType.equals(DebtConstants.APPLY_TYPE_ENTRY)){
				dtl.setMoney2(dtl.getBillsAmount());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_PURCHASE)){
				dtl.setMoney2(dtl.getBillsAmount());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_IN_POOL)){
				dtl.setMoney2(dtl.getMoney());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_OUT_POOL)){
				dtl.setMoney2(dtl.getMoney());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_DISCOUNT)){
				dtl.setMoney2(dtl.getRebateAmount());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_REPURCHASE)){
				dtl.setMoney2(dtl.getBuyBackAmount());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_VERIFY)){
				dtl.setMoney2(dtl.getMoney());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_INVOICE_AGE_CHANGE)){
				dtl.setMoney2(new BigDecimal(0));
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_REPAYMENT)){
				dtl.setMoney2(dtl.getPayAmount());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_ISSUE_SET)){
				dtl.setMoney2(dtl.getMoney());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_INVOICE_FINANCING)){
				dtl.setMoney2(dtl.getMoney());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_BILL_MODIFY)){
				dtl.setMoney2(dtl.getBillsAmount());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_ISSUE_REMOVE)){
				dtl.setMoney2(dtl.getMoney());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_COLLECTION)){
				dtl.setMoney2(dtl.getLoanRemainingAmount());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_INVOICE_COST_RECORD)){
				dtl.setMoney2(dtl.getMoney());
			}
			if(applyType.equals(DebtConstants.APPLY_TYPE_AFTER_COST_CHARGE)){
				dtl.setMoney2(dtl.getMoney());
			}
			
			BctlVO bctlVO = scubeUserService.selectBctlByBrNo(dtl.getBrcode(),ScfCommonUtil.getBrManagerNo(scubeUserService));
			UserInfo userInfo = scubeUserService.selectUserByTlrNo(dtl.getTlrcd(),ScfCommonUtil.getBrManagerNo(scubeUserService));
			if(bctlVO!=null&&StringUtils.isNotEmpty(bctlVO.getBrName())){
				dtl.setBrName(bctlVO.getBrName());
			}
			if(userInfo!=null&&StringUtils.isNotEmpty(userInfo.getTlrName())){
				dtl.setTlrNm(userInfo.getTlrName());
			}
			
			responseList.add(dtl);

		}
		
		pageResult.setRecords(responseList);
		int totalRecord = rBcpPoolDebtDetalInfoQryDao.selectInvoiceCourseCount(debtCommonQryVODal);
		pageResult.setTotalRecord(totalRecord);
		
		return pageResult;
	}

}
