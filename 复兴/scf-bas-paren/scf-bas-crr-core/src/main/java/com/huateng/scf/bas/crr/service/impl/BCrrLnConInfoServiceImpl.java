package com.huateng.scf.bas.crr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrDuebillAppDAO;
import com.huateng.scf.bas.crr.dao.IBCrrLnConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrDuebillApp;
import com.huateng.scf.bas.crr.dao.model.BCrrLnCon;
import com.huateng.scf.bas.crr.service.IBCrrLnConInfoService;
import com.huateng.scf.bas.crr.service.IBCrrPrdMdService;
import com.huateng.scf.bas.dcr.dao.BDcrLinInfDAO;
import com.huateng.scf.bas.dcr.model.BDcrLinInf;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	liph
 * @date 	2016年12月12日下午1:52:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月12日下午1:52:46	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrLnConInfoServiceImpl")
public class BCrrLnConInfoServiceImpl implements IBCrrLnConInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "IBCrrLnConDAO")
	IBCrrLnConDAO ibCrrLnConDAO;
	@Resource(name = "BDcrLinInfDAO")
	BDcrLinInfDAO bDcrLinInfDAO;
	@Resource(name = "IBMrnAppliAcctInfoDAO")
	IBMrnAppliAcctInfoDAO ibMrnAppliAcctInfoDAO;
	@Resource(name = "IBCrrDuebillAppDAO")
	IBCrrDuebillAppDAO ibCrrDuebillAppDAO;
	
	@Resource(name = "BCrrPrdMdServiceImpl")
	IBCrrPrdMdService bcrrprdmdservice;

	
	/**
	 * @author liph
	 */
	@SuppressWarnings("rawtypes")
	public List findBCrrLnConInfoByPage(String appId,String appno) {
		if(StringUtil.isEmpty(appId)){
			log.info("appno未获取到");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002),
					BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		BCrrDuebillApp baseInfo = ibCrrDuebillAppDAO.selectByPrimaryKey(appno);
		BigDecimal balrate = baseInfo.getBailRat();
		BCrrLnCon bCrrLnCon = ibCrrLnConDAO.selectByPrimaryKey(appId);
		String prdId = bCrrLnCon.getPrdId();
		String loanWay = bcrrprdmdservice.findBCrrPrdMdByPrdId(prdId).getLoanWay();
		bCrrLnCon.setLoanWay(loanWay);
		String creditProtNo = bCrrLnCon.getCreditProtNo();//额度协议流水号--关联额度信息
		BDcrLinInf bDcrLinInf = bDcrLinInfDAO.selectByPrimaryKey(creditProtNo);//信贷合同关联额度表
		if(bDcrLinInf != null){
			BigDecimal balamt = bDcrLinInf.getAbleNum()==null?BigDecimal.ZERO:bDcrLinInf.getAbleNum();//可用额度
			BigDecimal useamt = bDcrLinInf.getUsedNum()==null?BigDecimal.ZERO:bDcrLinInf.getUsedNum();//已占用额度
			bCrrLnCon.setFixInt(balamt.add(useamt));//总额度--拿来使用
			bCrrLnCon.setCrAmt(balamt);//已占用
			bCrrLnCon.setRtnInvl(bDcrLinInf.getCircFlag());//是否循环
			bCrrLnCon.setDog(balrate);//最低保证金比例
		}
		List<BCrrLnCon> list = new ArrayList<BCrrLnCon>();
		list.add(bCrrLnCon);
		return list;
	}
	
	/**
	 * @author liph
	 * @deprecated 保证金比较
	 */
	
}
