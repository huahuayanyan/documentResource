/**
 * 
 */
package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyCon;
import com.huateng.scf.bas.pbc.constant.BPbcErrorConstant;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgStockDtlDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgBaseInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgStockDtl;
import com.huateng.scf.bas.pbc.service.IBPbcMtgStockDtlService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>押品信息变更明细</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月29日上午10:54:47
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月29日上午10:54:47              新增
 *
 * </pre>
 */
@ScubeService
@Service("BPbcMtgStockDtlServiceImpl")
public class BPbcMtgStockDtlServiceImpl implements IBPbcMtgStockDtlService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BPbcMtgStockDtlDAO")
	IBPbcMtgStockDtlDAO bPbcMtgStockDtlDAO;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bcntmprotbaseinfoservice;
	
	//押品信息
	@Resource(name = "BPbcMtgBaseInfoDAO")
	IBPbcMtgBaseInfoDAO bpbcmtgbaseinfodao;

	//质押合同表
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Resource(name = "BCntMprotPartInfoServiceImpl")
	IBCntMprotPartInfoService bcntmprotpartinfoservice;
	
	@Transactional
	@Override
	public void addBPbcMtgStockDtl(BPbcMtgStockDtl bPbcMtgStockDtl) throws ScubeBizException {
		//ScfCommonUtil.setCommonField(bPbcMtgStockDtl);//设置公共字段 add by huangshuidan 2016-11-11
		 // 获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
	    bPbcMtgStockDtl.setBrcode(brCode);
	    if(StringUtil.isEmpty(bPbcMtgStockDtl.getId()))
	    {
	    	bPbcMtgStockDtl.setId(UUIDGeneratorUtil.generate());
	    }
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl bPbcMtgStockDtldal = new com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl();
		try {
			BeanUtils.copyProperties(bPbcMtgStockDtl, bPbcMtgStockDtldal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品信息变更明细转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_40000),BPbcErrorConstant.SCF_BAS_PBC_40000);
		} 
	    try {
			//TODO
			bPbcMtgStockDtlDAO.insertSelective(bPbcMtgStockDtldal);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("押品信息变更明细插入异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_40001),BPbcErrorConstant.SCF_BAS_PBC_40001);
		}
	}

	@Transactional
	@Override
	public int updateBPbcMtgStockDtl(BPbcMtgStockDtl bPbcMtgStockDtl) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl bPbcMtgStockDtldal = 
				new com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl();
			try {
				BeanUtils.copyProperties(bPbcMtgStockDtl, bPbcMtgStockDtldal);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("押品信息变更明细转换异常！");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_40000),BPbcErrorConstant.SCF_BAS_PBC_40000);
			}
		int i = 0;
		 try {
			i = bPbcMtgStockDtlDAO.updateByPrimaryKeySelective(bPbcMtgStockDtldal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品信息变更明细更新异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_40002),BPbcErrorConstant.SCF_BAS_PBC_40002);
		}
		 return i;
	}
	@Transactional
	@Override
	public int deleteBPbcMtgStockDtl(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bPbcMtgStockDtlDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品信息变更明细删除异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_40003),BPbcErrorConstant.SCF_BAS_PBC_40003);
		}
		return i;
	}

	@Transactional
	@Override
	public BPbcMtgStockDtl findBPbcMtgStockDtlByKey(String key) throws ScubeBizException {
		BPbcMtgStockDtl bPbcMtgStockDtl = new BPbcMtgStockDtl();
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl bPbcMtgStockDtldal = 
				new com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl();
		bPbcMtgStockDtldal=bPbcMtgStockDtlDAO.selectByPrimaryKey(key);
		try {
			BeanUtils.copyProperties(bPbcMtgStockDtldal, bPbcMtgStockDtl);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("押品信息变更明细转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_40000),BPbcErrorConstant.SCF_BAS_PBC_40000);
		}
		return bPbcMtgStockDtl;
	}

	/**
	 * 根据appno查询押品信息变更明细
	 */
	@Override
	public List<BPbcMtgStockDtl> findBPbcMtgStockDtlByAppno(String appno) throws ScubeBizException {
		List<BPbcMtgStockDtl> list =  new ArrayList<BPbcMtgStockDtl>(); 
		BPbcMtgStockDtl bPbcMtgStockDtl = null;
		List<com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl> listdal=  bPbcMtgStockDtlDAO.selectByAppno(appno);
		for(com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl info:listdal){
			bPbcMtgStockDtl =new BPbcMtgStockDtl();
			try {
				BeanUtils.copyProperties(info, bPbcMtgStockDtl);
			} catch (BeansException e) {
				log.error("押品信息变更明细转换异常！");
				e.printStackTrace();
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BPbcErrorConstant.SCF_BAS_PBC_40000),BPbcErrorConstant.SCF_BAS_PBC_40000);
			}
			list.add(bPbcMtgStockDtl);
		}
		return list;
	}

	/**
	 * 根据申请信息，保存押品信息变更明细表(公共方法)
	 * @param appliMortgageBaseInfo
	 * @param pid
	 *            业务流失主表ID
	 * @param bussType
	 *            常量类中的MORT_BIZ_TYPE_PLEDGE_IN等 4位码
	 * @param type
	 *            业务流失表中的STOR_DELI_BIZ_TYPE
	 * @param supplyChainId
	 *            供应链产品ID
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月19日下午2:18:14
	 */
	@Override
	public void addTblMortgageStockInfoByAppliInfo(BPbcAppliMtgInfoVO appliMortgageBaseInfo, String pid,
			String bussType, String type, String supplyChainId)	throws ScubeBizException {
		com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl tblMortgageStockInfo = 
				new com.huateng.scf.bas.pbc.dao.model.BPbcMtgStockDtl();
		BPbcMtgBaseInfo tblMortgageBaseInfo = bpbcmtgbaseinfodao.selectByPrimaryKey(appliMortgageBaseInfo.getMortgageNo());
		BeanUtils.copyProperties(appliMortgageBaseInfo,tblMortgageStockInfo);
		if(null!=tblMortgageBaseInfo && (null!=tblMortgageBaseInfo.getQuantity())){
			tblMortgageStockInfo.setOriginalQuantity(tblMortgageBaseInfo.getQuantity());
		}else{
			tblMortgageStockInfo.setOriginalQuantity(BigDecimal.ZERO);
		}
		BCrrGntyCon tblContSlaveInfo = bcrrgntycondao.selectByPrimaryKey(appliMortgageBaseInfo.getSlaveContno());//查询质押合同信息
		BCntMprotBaseInfo baseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(tblContSlaveInfo.getPrtclNo());//查询监管合同信息
		//查询多方协议参与者信息
		BCntMprotPartInfo tblMutiProtPartInfo= bcntmprotpartinfoservice.findCoreorCustByProtocolNo(baseInfo.getProtocolNo(), ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		tblMortgageStockInfo.setMoniOfCustcd(tblMutiProtPartInfo!=null?tblMutiProtPartInfo.getCustcd():"");

		tblMortgageStockInfo.setMortgageBizType(bussType);
		tblMortgageStockInfo.setPid(pid);
		tblMortgageStockInfo.setBussType(supplyChainId);//产品ID 库存流水bussType一致
		tblMortgageStockInfo.setType(type);
		tblMortgageStockInfo.setSupplyChainPdId(supplyChainId);
		tblMortgageStockInfo.setLastUpdTime(new Date());
		tblMortgageStockInfo.setId(null);
		tblMortgageStockInfo.setId(UUIDGeneratorUtil.generate());
		//增加originalQuantity @2013-9-2,changhao.huang
		tblMortgageStockInfo.setOriginalQuantity(appliMortgageBaseInfo.getQuantity());
		bPbcMtgStockDtlDAO.insertSelective(tblMortgageStockInfo);
	}

}
