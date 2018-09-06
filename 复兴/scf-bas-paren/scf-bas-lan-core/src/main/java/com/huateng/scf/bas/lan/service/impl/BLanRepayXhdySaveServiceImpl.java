package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.AmountVO;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.model.BCrrDueBillDetail;
import com.huateng.scf.bas.icr.dao.IBIcrInfoDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrInfo;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IBLanCommonService;
import com.huateng.scf.bas.lan.service.IBLanRepayXhdySaveService;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IAmountService;
import com.huateng.scf.bas.prd.dao.IBPrdCreditBindDAO;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	liph
 * @date 	2016年12月14日下午4:40:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月14日下午4:40:20	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BLanRepayXhdySaveServiceImpl")
public class BLanRepayXhdySaveServiceImpl implements IBLanRepayXhdySaveService{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO ibPrdInfoDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	@Resource(name = "BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO ibPbcAppliBaseInfoDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO ibCrrGntyConDAO;
	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO ibPbcMtgBaseInfoDAO;
	@Resource(name = "AmountServiceImpl")
	IAmountService amountService;
	@Resource(name = "BPrdCreditBindDAO")	
	IBPrdCreditBindDAO ibPrdCreditBindDAO;
	@Resource(name = "BIcrInfoDAO")
	IBIcrInfoDAO ibIcrInfoDAO;
	@Resource(name = "BLanCommonServiceImpl")
	IBLanCommonService ibLanCommonService;
	
	@Override
	@Transactional
	public void xhdySave(BCrrDueBillDetail bCrrDueBillDetail) {
		String mastContno = bCrrDueBillDetail.getAppId();
		String appno = bCrrDueBillDetail.getId();//流程申请号
		if(mastContno == null){
			log.info("主合同号为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20026),
					BLanErrorConstant.SCF_BAS_LAN_20026);
		}
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		if(bCrrLnCon == null){
			log.info("未关联到信贷合同");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20018),
					BLanErrorConstant.SCF_BAS_LAN_20018);
		}
		String bussType = bCrrLnCon.getVidBusiTyp();
		BPrdInfo bPrdInfo = ibPrdInfoDAO.selectByPrimaryKey(bussType);
		if(bPrdInfo == null){
			log.info("业务种类获取大类为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20024),
				BLanErrorConstant.SCF_BAS_LAN_20024);
		}
		String bigProductId = bPrdInfo.getParentId();//产品种类--产品大类
		if(ScfBasConstant.PRODUCT_TYPE_MORT.equals(bigProductId)){//动产、汽车货押、先票后货
			//金额校验
			BigDecimal appInitCashEqtAmt = bCrrDueBillDetail.getCsxjdjwbl();
			try {
				ibLanCommonService.checkLoanApplyInfo(appno,appInitCashEqtAmt);//appno--初始现金等价物金额
			} catch (Exception e) {
				log.info("金额校验异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20016),
						BLanErrorConstant.SCF_BAS_LAN_20016);
			}
			//借据申请表信息保存
			try {
				this.saveLoanApplyInfo(bCrrDueBillDetail);
			} catch (Exception e) {
				log.info("借据申请表信息保存异常");
				e.printStackTrace();
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10001),BLanErrorConstant.SCF_BAS_LAN_10001);
			}
		}
	}
	/**
	 *  保存借据申请表里面的信息
	 */
	public void saveLoanApplyInfo(BCrrDueBillDetail bCrrDueBillDetail){
		int a = 0;
		String appno = bCrrDueBillDetail.getId();
		String mastContno = bCrrDueBillDetail.getAppId();
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(mastContno);
		BLanAppliLnciBase bLanAppliLnciBase = ibLanAppliLnciBaseDAO.selectByAppno(appno);
		if(bLanAppliLnciBase == null){
			a = a + 1;
		}else{
			a = a + 2;
		}
		BPrdInfo bPrdInfo = ibPrdInfoDAO.selectByPrimaryKey(bCrrLnCon.getVidBusiTyp());
		String bigproductid = bPrdInfo.getParentId();
		if(ScfBasConstant.PRODUCT_TYPE_PREP.equals(bigproductid)){
			if(StringUtil.isEmpty(bLanAppliLnciBase.getSlaveContno())){
				BCrrGntyCon bCrrGntyCon = ibCrrGntyConDAO.selectByPrimaryKey(bCrrLnCon.getVidNo());
				bLanAppliLnciBase.setSlaveContno(bCrrGntyCon.getConId());//质押合同号
				bLanAppliLnciBase.setProtocolNo(bCrrGntyCon.getPrtclNo());//监管合同号
			}
		}
		if(StringUtil.isEmpty(bLanAppliLnciBase.getId())){
			bLanAppliLnciBase.setId(UUIDGeneratorUtil.generate());
		}
		if(StringUtil.isEmpty(bLanAppliLnciBase.getDebetNo())){
			bLanAppliLnciBase.setDebetNo(UUIDGeneratorUtil.generate());
		}
		if(a == 1){
			ibLanAppliLnciBaseDAO.insertSelective(bLanAppliLnciBase);
		}else if(a == 2){
			ibLanAppliLnciBaseDAO.updateByPrimaryKey(bLanAppliLnciBase);
		}
	}
}
