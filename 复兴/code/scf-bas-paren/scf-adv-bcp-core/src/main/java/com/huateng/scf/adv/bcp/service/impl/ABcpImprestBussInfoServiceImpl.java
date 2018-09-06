/**
 * 
 */
package com.huateng.scf.adv.bcp.service.impl;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.scf.adv.bcp.model.ABcpAppliImprestBuss;
import com.huateng.scf.adv.bcp.model.ABcpImprestBussInfo;
import com.huateng.scf.adv.bcp.service.IABcpAppliImprestBussService;
import com.huateng.scf.adv.bcp.service.IABcpImprestBussInfoService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.sys.constant.BSysConstant;
import com.huateng.scf.adv.bcp.constant.ABcpErrorConstant;
import com.huateng.scf.adv.bcp.dao.IABcpImprestBussInfoDAO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年5月03日下午3:18:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月29日下午3:18:31              新增
 *
 * </pre>
 */
@ScubeService
@Service(IABcpImprestBussInfoService.BEAN_ID)
public class ABcpImprestBussInfoServiceImpl implements IABcpImprestBussInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "ABcpImprestBussInfoDAO")
	IABcpImprestBussInfoDAO aBcpImprestBussInfoDAO;

	@Resource(name = "ABcpAppliImprestBussServiceImpl")
	IABcpAppliImprestBussService aBcpAppliImprestBussService;
	@Transactional
	@Override
	public void addABcpImprestBussInfo(ABcpImprestBussInfo aBcpImprestBussInfo) throws ScubeBizException {
		//ScfCommonUtil.setCommonField(ABcpImprestBussInfo);//设置公共字段 add by huangshuidan 2016-11-11
		 // 获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
	    aBcpImprestBussInfo.setBrcode(brCode);
	    aBcpImprestBussInfo.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo aBcpImprestBussInfodal = new com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo();
		try {
			BeanUtils.copyProperties(aBcpImprestBussInfo,aBcpImprestBussInfodal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预付款业务流水转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10005),ABcpErrorConstant.SCF_ADV_BCP_10005);
		} 
	    try {
			//TODO
	    	aBcpImprestBussInfoDAO.insertSelective(aBcpImprestBussInfodal);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("预付款业务流水插入异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10006),ABcpErrorConstant.SCF_ADV_BCP_10006);
		}
	}

	@Transactional
	@Override
	public int updateABcpImprestBussInfo(ABcpImprestBussInfo aBcpImprestBussInfo) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo aBcpImprestBussInfodal = 
				new com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo();
			try {
				BeanUtils.copyProperties(aBcpImprestBussInfo, aBcpImprestBussInfodal);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("预付款业务流水转换异常！");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10005),ABcpErrorConstant.SCF_ADV_BCP_10005);
			}
		int i = 0;
		 try {
			i = aBcpImprestBussInfoDAO.updateByPrimaryKeySelective(aBcpImprestBussInfodal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预付款业务流水更新异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10007),ABcpErrorConstant.SCF_ADV_BCP_10007);
		}
		 return i;
	}
	@Transactional
	@Override
	public int deleteABcpImprestBussInfo(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = aBcpImprestBussInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预付款业务流水删除异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10008),ABcpErrorConstant.SCF_ADV_BCP_10008);
		}
		return i;
	}

	@Transactional
	@Override
	public ABcpImprestBussInfo findABcpImprestBussInfoByKey(String key) throws ScubeBizException {
		ABcpImprestBussInfo aBcpImprestBussInfo = null;
		com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo aBcpImprestBussInfodal = 
				new com.huateng.scf.adv.bcp.dao.model.ABcpImprestBussInfo();
		aBcpImprestBussInfodal=aBcpImprestBussInfoDAO.selectByPrimaryKey(key);
		try {
			if(aBcpImprestBussInfodal!=null){
				aBcpImprestBussInfo = new ABcpImprestBussInfo();
				BeanUtils.copyProperties(aBcpImprestBussInfodal, aBcpImprestBussInfo);
			}
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预付款业务流水转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10005),ABcpErrorConstant.SCF_ADV_BCP_10005);
		}
		return aBcpImprestBussInfo;
	}
	/**
	 * 提货流水信息写入(线下)
	 * @param abcpAppliImprestBuss
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void saveDeliveryTblBussInfo(ABcpAppliImprestBuss abcpAppliImprestBuss) throws ScubeBizException{
    	log.info("------流水信息写入");
    	ABcpImprestBussInfo abcpImprestBussInfo  = new ABcpImprestBussInfo();
    	BeanUtils.copyProperties(abcpAppliImprestBuss, abcpImprestBussInfo);
    	//abcpImprestBussInfo.setId(UUIDGeneratorUtil.generate());
    	abcpImprestBussInfo.setInsertDate(BSysConstant.WORKDATE);
    	this.addABcpImprestBussInfo(abcpImprestBussInfo);
	 }
	/**
	 * 先票/款后货差额退款保存流水表
	 * @param appno
	 * @throws ScubeBizException
	 */
	@Transactional
	@Override
	public void saveImprestBussInfo(String appno) throws ScubeBizException{
    	log.info("------流水信息写入");
    	ABcpImprestBussInfo info = new ABcpImprestBussInfo();
    	ABcpAppliImprestBuss applyInfo = aBcpAppliImprestBussService.findABcpAppliImprestBussByAppno(appno);
    	if(applyInfo!=null){
    		BeanUtils.copyProperties(applyInfo,info);	
    	}	
    	this.addABcpImprestBussInfo(info);
	 }
}
