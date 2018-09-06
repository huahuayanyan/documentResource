/**
 * 
 */
package com.huateng.scf.adv.fcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.adv.fcs.service.IPriceAdjustService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.bas.sys.service.DealEndFlowService;
import com.huateng.scf.bas.sys.service.DealInFlowService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年4月26日上午10:25:06
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年4月26日上午10:25:06	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("PriceAdjustServiceImpl")
public class PriceAdjustServiceImpl implements IPriceAdjustService, DealInFlowService, DealEndFlowService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bPbcAppliMtgInfoService;

	@Resource(name = "BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bPbcMtgBaseInfoService;

	/*
	 * 批量调价审批通过
	 */
	@Override
	@Transactional
	public void doWorkForPass(String appNo) {
		// 1.更新押品价格表
		updateAppliMortgageStatus(appNo);
		// 2.解压押品(在上面已经解锁)
		// releaseMortgageBaseInfo(appNo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForReject(java.
	 * lang.String)
	 */
	@Override
	public void doWorkForReject(String appNo) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealEndFlowService#doWorkForBack(java.
	 * lang.String)
	 */
	@Override
	public void doWorkForBack(String appNo) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.scf.bas.sys.service.DealInFlowService#doWorkForSubmit(java.
	 * lang.String)
	 */
	@Override
	public void doWorkForSubmit(String appNo) throws ScubeBizException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.adv.fcs.service.PriceAdjustService#
	 * updateAppliMortgageStatus(java.lang.String)
	 */
	@Override
	@Transactional
	public void updateAppliMortgageStatus(String appno) throws ScubeBizException {
		// 1.数据校验
		if (appno == null || "".equals(appno)) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10005), RBcpErrorConstant.SCF_REC_BCP_10005);
		}
		// 2.更新押品价格表(解锁了)
		List<BPbcAppliMtgInfo> bPbcAppliMtgInfoList = bPbcAppliMtgInfoService.findBPbcAppliMtgInfoByAppno(appno);
		for (BPbcAppliMtgInfo bPbcAppliMtgInfo : bPbcAppliMtgInfoList) {
			BPbcMtgBaseInfo bPbcMtgBaseInfo = new BPbcMtgBaseInfo();
			bPbcMtgBaseInfo.setMortgageLevelOne(bPbcAppliMtgInfo.getMortgageLevelOne());
			bPbcMtgBaseInfo.setMortgageLevelTwo(bPbcAppliMtgInfo.getMortgageLevelTwo());
			bPbcMtgBaseInfo.setMortgageLevelThree(bPbcAppliMtgInfo.getMortgageLevelThree());
			bPbcMtgBaseInfo.setJoinBatch(ScfBasConstant.JOIN_BATCH_YES);
			bPbcMtgBaseInfo.setSupplyChainPdId(bPbcAppliMtgInfo.getProductId());
			List<BPbcMtgBaseInfo> bPbcMtgBaseInfoList = bPbcMtgBaseInfoService.getMortgageInfoByMortgageLevels(bPbcMtgBaseInfo);
			for (BPbcMtgBaseInfo bPbcMtgBaseInfo1 : bPbcMtgBaseInfoList) {
				bPbcMtgBaseInfo1.setConfirmPrice(bPbcAppliMtgInfo.getConfirmPrice());
				bPbcMtgBaseInfo1.setTotPrice(bPbcAppliMtgInfo.getConfirmPrice().multiply(bPbcMtgBaseInfo1.getQuantity()));
				bPbcMtgBaseInfo1.setLockAppno(null);
				bPbcMtgBaseInfo1.setIsLocked(ScfBasConstant.UNLOCKED);
				bPbcMtgBaseInfoService.updateBPbcMtgBaseInfo(bPbcMtgBaseInfo1);
			}
			bPbcAppliMtgInfo.setStatus(ScfBasConstant.APPLI_MORT_STATUS_APPROVED);// 批量调价审批通过
			bPbcAppliMtgInfoService.updateBPbcAppliMtgInfo(bPbcAppliMtgInfo);
		}
	}

}
