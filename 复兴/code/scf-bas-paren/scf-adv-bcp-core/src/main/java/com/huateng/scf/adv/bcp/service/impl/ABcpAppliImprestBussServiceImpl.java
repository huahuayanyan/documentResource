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
import com.huateng.scf.adv.bcp.service.IABcpAppliImprestBussService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.adv.bcp.constant.ABcpErrorConstant;
import com.huateng.scf.adv.bcp.dao.IABcpAppliImprestBussDAO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月29日下午3:18:31
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
@Service("ABcpAppliImprestBussServiceImpl")
public class ABcpAppliImprestBussServiceImpl implements IABcpAppliImprestBussService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "ABcpAppliImprestBussDAO")
	IABcpAppliImprestBussDAO aBcpAppliImprestBussDAO;

	@Transactional
	@Override
	public void addABcpAppliImprestBuss(ABcpAppliImprestBuss aBcpAppliImprestBuss) throws ScubeBizException {
		//ScfCommonUtil.setCommonField(ABcpAppliImprestBuss);//设置公共字段 add by huangshuidan 2016-11-11
		 // 获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
	    aBcpAppliImprestBuss.setBrcode(brCode);
	    aBcpAppliImprestBuss.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss aBcpAppliImprestBussdal = new com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss();
		try {
			BeanUtils.copyProperties(aBcpAppliImprestBuss,aBcpAppliImprestBussdal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预付款业务申请流水转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10000),ABcpErrorConstant.SCF_ADV_BCP_10000);
		} 
	    try {
			//TODO
	    	aBcpAppliImprestBussDAO.insertSelective(aBcpAppliImprestBussdal);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("预付款业务申请流水插入异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10001),ABcpErrorConstant.SCF_ADV_BCP_10001);
		}
	}

	@Transactional
	@Override
	public int updateABcpAppliImprestBuss(ABcpAppliImprestBuss aBcpAppliImprestBuss) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss aBcpAppliImprestBussdal = 
				new com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss();
			try {
				BeanUtils.copyProperties(aBcpAppliImprestBuss, aBcpAppliImprestBussdal);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("预付款业务申请流水转换异常！");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10000),ABcpErrorConstant.SCF_ADV_BCP_10000);
			}
		int i = 0;
		 try {
			i = aBcpAppliImprestBussDAO.updateByPrimaryKeySelective(aBcpAppliImprestBussdal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预付款业务申请流水更新异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10002),ABcpErrorConstant.SCF_ADV_BCP_10002);
		}
		 return i;
	}
	@Transactional
	@Override
	public int deleteABcpAppliImprestBuss(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = aBcpAppliImprestBussDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预付款业务申请流水删除异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10003),ABcpErrorConstant.SCF_ADV_BCP_10003);
		}
		return i;
	}

	@Transactional
	@Override
	public ABcpAppliImprestBuss findABcpAppliImprestBussByKey(String key) throws ScubeBizException {
		ABcpAppliImprestBuss aBcpAppliImprestBuss = new ABcpAppliImprestBuss();
		com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss aBcpAppliImprestBussdal = 
				new com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss();
		aBcpAppliImprestBussdal=aBcpAppliImprestBussDAO.selectByPrimaryKey(key);
		try {
			BeanUtils.copyProperties(aBcpAppliImprestBussdal, aBcpAppliImprestBuss);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("预付款业务申请流水转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10000),ABcpErrorConstant.SCF_ADV_BCP_10000);
		}
		return aBcpAppliImprestBuss;
	}

	/**
	 * 根据appno查询预付款业务申请流水
	 */
	@Override
	public ABcpAppliImprestBuss findABcpAppliImprestBussByAppno(String appno) throws ScubeBizException {
		ABcpAppliImprestBuss aBcpAppliImprestBuss = null;
		com.huateng.scf.adv.bcp.dao.model.ABcpAppliImprestBuss aBcpAppliImprestBussdal=  aBcpAppliImprestBussDAO.queryAppliImprestBussByAppno(appno);
			try {
				if(aBcpAppliImprestBussdal!=null){
					aBcpAppliImprestBuss = new ABcpAppliImprestBuss();
					BeanUtils.copyProperties(aBcpAppliImprestBussdal, aBcpAppliImprestBuss);
				}
			
			} catch (BeansException e) {
				log.error("预付款业务申请流水转换异常！");
				e.printStackTrace();
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(ABcpErrorConstant.SCF_ADV_BCP_10000),ABcpErrorConstant.SCF_ADV_BCP_10000);
			}
		return aBcpAppliImprestBuss;
	}

}
