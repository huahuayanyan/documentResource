/**
 * 
 */
package com.huateng.scf.bas.cnt.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.bas.cnt.dao.IBCntMprotDealInfoDAO;
import com.huateng.scf.bas.cnt.model.BCntMprotDealInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotDealInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月15日上午11:02:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月15日上午11:02:53	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCntMprotDealInfoServiceImpl")
public class BCntMprotDealInfoServiceImpl implements IBCntMprotDealInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BCntMprotDealInfoDAO")
	IBCntMprotDealInfoDAO bCntMprotDealInfoDAO;
	public void addBCntMprotDealInfo(BCntMprotDealInfo bCntMprotDealInfo) throws ScubeBizException {
		//ScfCommonUtil.setCommonField(bCntMprotDealInfo);//设置公共字段 add by huangshuidan 2016-11-11
		com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo bCntMprotDealInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo();
		BeanUtils.copyProperties(bCntMprotDealInfo, bCntMprotDealInfodal); 
	    //TODO
		bCntMprotDealInfoDAO.insertSelective(bCntMprotDealInfodal);
	}
	@Transactional
	public int updateBCntMprotDealInfo(BCntMprotDealInfo bCntMprotDealInfo) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo bCntMprotDealInfodal = 
				new com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo();
			BeanUtils.copyProperties(bCntMprotDealInfo, bCntMprotDealInfodal);
		return bCntMprotDealInfoDAO.updateByPrimaryKeySelective(bCntMprotDealInfodal);
	}
	@Transactional
	@Override
	public int deleteBCntMprotDealInfo(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		return bCntMprotDealInfoDAO.deleteByPrimaryKey(key);
	}

	@Override
	public BCntMprotDealInfo findBCntMprotDealInfoByKey(String key) throws ScubeBizException {
		BCntMprotDealInfo bCntMprotDealInfo = new BCntMprotDealInfo();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo bCntMprotDealInfodal = 
				new com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo();
		bCntMprotDealInfodal=bCntMprotDealInfoDAO.selectByPrimaryKey(key);
		BeanUtils.copyProperties(bCntMprotDealInfodal, bCntMprotDealInfo);
		return bCntMprotDealInfo;
	}
	
	/**
	 * DESCRIPTION:更新借据,协议的累计提货金额
	 * @author WEIXIANG.SUN
	 * @date 2012-11-13
	 * updateDeliveryLnciBaseInfo 方法
	 * @param bLanLnciBase
	 * @return
	 * @throws CommonException
	 */
	@Transactional
	public void updateDeliveryLnciBaseInfo(ABcpAppliImprestBuss abcpAppliImprestBuss){
		BigDecimal amountOut = BigDecimal.ZERO;
		BigDecimal amountIn = BigDecimal.ZERO;
		//获取阶段性回购协议信息
		BCntMprotDealInfo bCntMprotDealInfo = new BCntMprotDealInfo();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotDealInfo bCntMprotDealInfodal = bCntMprotDealInfoDAO.selectByPrimaryKey(abcpAppliImprestBuss.getProtocolNo());
		BeanUtils.copyProperties(bCntMprotDealInfodal, bCntMprotDealInfo); 
		//更新协议下的累计提货金额
		if(bCntMprotDealInfo.getDeliveryAmount() == null){
			bCntMprotDealInfo.setDeliveryAmount(abcpAppliImprestBuss.getCommonAmt());
		}else{
			bCntMprotDealInfo.setDeliveryAmount(bCntMprotDealInfo.getDeliveryAmount().add(abcpAppliImprestBuss.getCommonAmt()));
		}
		//更新协议下的累计提货金额(向监管)
		if(bCntMprotDealInfo.getAmountOut() == null){
			amountOut=abcpAppliImprestBuss.getCommonAmt();
			bCntMprotDealInfo.setAmountOut(amountOut);
		}else{
			amountOut=bCntMprotDealInfo.getAmountOut().add(abcpAppliImprestBuss.getCommonAmt());
			bCntMprotDealInfo.setAmountOut(amountOut);
		}
		//剩余提货金额
		if(bCntMprotDealInfo.getAmountIn()!=null&&!(bCntMprotDealInfo.getAmountIn().equals(BigDecimal.ZERO))){
			amountIn =bCntMprotDealInfo.getAmountIn().subtract(abcpAppliImprestBuss.getCommonAmt());//剩余提货金额
			bCntMprotDealInfo.setAmountIn(amountIn);
		}

		this.updateBCntMprotDealInfo(bCntMprotDealInfo);
	}
}
