/**
 * 
 */
package com.huateng.scf.bas.mrn.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.mrn.constant.BMrnErrorConstant;
import com.huateng.scf.bas.mrn.dao.IBMrnAcctBussInfoDAO;
import com.huateng.scf.bas.mrn.dao.ext.ExtBMrnDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfoExample;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfoExample.Criteria;
import com.huateng.scf.bas.mrn.model.BMrnAcctBussInfo;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.service.IBMrnAcctBussInfoService;
import com.huateng.scf.bas.mrn.service.IBMrnAppliAcctInfoService;
import com.huateng.scf.bas.mrn.vo.BailBussInfoVO;
import com.huateng.scf.bas.mrn.vo.BailLnciQryVO;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月29日上午11:29:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月29日上午11:29:55              新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("BMrnAcctBussInfoServiceImpl")
public class BMrnAcctBussInfoServiceImpl implements IBMrnAcctBussInfoService {
	static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BMrnAcctBussInfoDAO")
	IBMrnAcctBussInfoDAO bMrnAcctBussInfoDAO;
	
	//保证金及现金等价物业务申请信息表
	@Resource(name = "BMrnAppliAcctInfoServiceImpl")
	IBMrnAppliAcctInfoService bmrnappliacctinfoservice;
	
	@Resource(name = "ExtBMrnDAO")
	ExtBMrnDAO extbmrndao;

	@Transactional
	@Override
	public void addBMrnAcctBussInfo(BMrnAcctBussInfo bMrnAcctBussInfo) throws ScubeBizException {
		ScfCommonUtil.setCommonField(bMrnAcctBussInfo);//设置公共字段 add by huangshuidan 2016-11-11
		 // 获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
	    bMrnAcctBussInfo.setBrcode(brCode);
	    bMrnAcctBussInfo.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo bMrnAcctBussInfodal = new com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo();
		try {
			BeanUtils.copyProperties(bMrnAcctBussInfo, bMrnAcctBussInfodal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("保证金及现金等价物交易流水转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BMrnErrorConstant.SCF_BAS_MRN_10000),BMrnErrorConstant.SCF_BAS_MRN_10000);
		} 
	    try {
			//TODO
			bMrnAcctBussInfoDAO.insertSelective(bMrnAcctBussInfodal);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("保证金及现金等价物交易流水插入异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BMrnErrorConstant.SCF_BAS_MRN_10001),BMrnErrorConstant.SCF_BAS_MRN_10001);
		}
	}

	@Transactional
	@Override
	public int updateBMrnAcctBussInfo(BMrnAcctBussInfo bMrnAcctBussInfo) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo bMrnAcctBussInfodal = 
				new com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo();
			try {
				BeanUtils.copyProperties(bMrnAcctBussInfo, bMrnAcctBussInfodal);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("保证金及现金等价物交易流水转换异常！");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BMrnErrorConstant.SCF_BAS_MRN_10000),BMrnErrorConstant.SCF_BAS_MRN_10000);
			}
		int i = 0;
		 try {
			i = bMrnAcctBussInfoDAO.updateByPrimaryKeySelective(bMrnAcctBussInfodal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("保证金及现金等价物交易流水更新异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BMrnErrorConstant.SCF_BAS_MRN_10002),BMrnErrorConstant.SCF_BAS_MRN_10002);
		}
		 return i;
	}
	@Transactional
	@Override
	public int deleteBMrnAcctBussInfo(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = bMrnAcctBussInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("保证金及现金等价物交易流水删除异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BMrnErrorConstant.SCF_BAS_MRN_10003),BMrnErrorConstant.SCF_BAS_MRN_10003);
		}
		return i;
	}

	@Transactional
	@Override
	public BMrnAcctBussInfo findBMrnAcctBussInfoByKey(String key) throws ScubeBizException {
		BMrnAcctBussInfo bMrnAcctBussInfo = new BMrnAcctBussInfo();
		com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo bMrnAcctBussInfodal = 
				new com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo();
		bMrnAcctBussInfodal=bMrnAcctBussInfoDAO.selectByPrimaryKey(key);
		try {
			BeanUtils.copyProperties(bMrnAcctBussInfodal, bMrnAcctBussInfo);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("保证金及现金等价物交易流水转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BMrnErrorConstant.SCF_BAS_MRN_10000),BMrnErrorConstant.SCF_BAS_MRN_10000);
		}
		return bMrnAcctBussInfo;
	}

	@Override
	/**
	 * 最低控货价值复核提交保证金申请信息加入保证金流水
	 * @param appno
	 */
	public void saveBMrnAcctBussInfo(String appno)
	{
		List<BMrnAppliAcctInfo> list = bmrnappliacctinfoservice.findBMrnAppliAcctInfoByAppno(appno);
		if(list.size()>0)
		{
			for(BMrnAppliAcctInfo actinfo:list)
			{
				com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo businfo = 
						new com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo();
				try
				{
					BeanUtils.copyProperties(actinfo, businfo);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				String id = UUIDGeneratorUtil.generate();
				businfo.setId(id);
				bMrnAcctBussInfoDAO.insertSelective(businfo);
			}
		}
	}
	
	/**
	 * 
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getTblCustAccountBussInfoByParam(BailLnciQryVO commonQueryVO) throws ScubeBizException{
		HashMap<String, Object> omap = new HashMap<String, Object>();

	   	if(!StringUtil.isEmpty(commonQueryVO.getProtocolNo())){
	   		omap.put("protocolNo", commonQueryVO.getProtocolNo());
	   	}
	   	//客户号
	   	if(!StringUtil.isEmpty(commonQueryVO.getCustcd())){
	   		omap.put("custcd", commonQueryVO.getCustcd());
	   	}
	   	omap.put("confirmStatus", "true");
	   	omap.put("confirmStatus1", ScfBasConstant.CONFIRM_STATUS_RELEASED);
	   	omap.put("confirmStatus2", ScfBasConstant.CONFIRM_STATUS_SETTLED);
	   	omap.put("bailAmount", new BigDecimal(0));
	   	Page pageQueryResult = new Page();
	   	pageQueryResult.setPageNo(commonQueryVO.getPageIndex());
	   	pageQueryResult.setPageSize(commonQueryVO.getPageSize());
	   	List<com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo> list = extbmrndao.getTblCustAccountBussInfoByParam(omap, pageQueryResult);
	   	pageQueryResult.setRecords(list);
	   	return pageQueryResult;
	}
	
	@Override
	public void save(BMrnAcctBussInfo bMrnAcctBussInfo){
		if(StringUtil.isEmpty(bMrnAcctBussInfo.getId())){
			bMrnAcctBussInfo.setId(UUIDGeneratorUtil.generate());
		}
		com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo appliBussInfo = 
				new com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo();
		BeanUtils.copyProperties(bMrnAcctBussInfo, appliBussInfo);
		bMrnAcctBussInfoDAO.insertSelective(appliBussInfo);
	}
	
	/**
	 * DESCRIPTION:获取现金等价物
	 * @author QUANYU.SI
	 * @date 2012-5-18
	 * getBillCustAccountInfoByParam 方法
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getBillCustAccountInfoByParam(OldCommonQueryVO commonQueryVO) throws ScubeBizException{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		//如果未勾选借据，返回空
		if("------".equals(commonQueryVO.getDebetNo_Q())){
			return null;
		}
		
    	//主合同号
    	if(!StringUtil.isEmpty(commonQueryVO.getMastContno_Q())){
    		omap.put("mastContno", commonQueryVO.getMastContno_Q());
    	}

    	//客户号
    	if(!StringUtil.isEmpty(commonQueryVO.getCustcd_Q())){
    		omap.put("custcd", commonQueryVO.getCustcd_Q());
    	}
    	//借据号
    	if(commonQueryVO.getDebetNo_Q()!=null&&!commonQueryVO.getDebetNo_Q().trim().equals("")){
    		omap.put("debetNo", commonQueryVO.getDebetNo_Q().trim());
    	}

	   	omap.put("confirmStatus1", ScfBasConstant.CONFIRM_STATUS_RELEASED);//不等于
	   	omap.put("confirmStatus2", ScfBasConstant.CONFIRM_STATUS_RELEASEING);//不等于
	   	omap.put("bailType", "03");//不等于
	   	Page pageQueryResult = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), 0);
	   	
    	pageQueryResult.setRecords(extbmrndao.getBillCustAccountInfoByParam(omap, pageQueryResult));;
    	pageQueryResult.setTotalRecord(extbmrndao.countBillCustAccountInfoByParam(omap));
    	return pageQueryResult;
	}
	
	
	
	

	@Override
	public Page queryTblCustAccountBussInfoList(int pageNo, int pageSize,BMrnAcctBussInfo bMrnAcctBussInfo) {
		Page p = new Page(pageSize, pageNo,0);
		BMrnAcctBussInfoExample example = new BMrnAcctBussInfoExample();
	    Criteria cri = example.createCriteria();
		if (bMrnAcctBussInfo != null) {
			if (bMrnAcctBussInfo.getCustcd() != null && bMrnAcctBussInfo.getCustcd().length() > 0) {
				cri.andCustcdEqualTo(bMrnAcctBussInfo.getCustcd());

			}
			if (bMrnAcctBussInfo.getMastContno() != null &&bMrnAcctBussInfo.getMastContno().length() > 0) {
				  cri.andMastContnoLike("%" +bMrnAcctBussInfo.getMastContno()+ "%");
				}
			if (bMrnAcctBussInfo.getBailType() != null &&bMrnAcctBussInfo.getBailType().length() > 0) {
				  cri.andBailTypeEqualTo(bMrnAcctBussInfo.getBailType());
				}
		}

		bMrnAcctBussInfoDAO.selectByPage(example, p);
		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());
		return p;
	}
	
	/**
	 * DESCRIPTION:更新tblcustaccountbussinfo的list
	 * @author mengjiajia
	 * @date 2012-5-19
	 * updteAll 方法
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void updateAll(List list){
		for(int i = 0 ; i<list.size() ; i++){
			BMrnAcctBussInfo tblCustAccountBussInfo = new BMrnAcctBussInfo();
			tblCustAccountBussInfo = (BMrnAcctBussInfo) list.get(i);
			this.updateBMrnAcctBussInfo(tblCustAccountBussInfo);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List  queryTblCustAccountBussInfoListForBMrnAcctBussInfo(BMrnAcctBussInfo bMrnAcctBussInfo) {
		BMrnAcctBussInfoExample example = new BMrnAcctBussInfoExample();
	    Criteria cri = example.createCriteria();
		if (bMrnAcctBussInfo != null) {
			if (bMrnAcctBussInfo.getBailAccountno() != null && bMrnAcctBussInfo.getBailAccountno().length() > 0) {
				cri.andBailAccountnoEqualTo(bMrnAcctBussInfo.getBailAccountno());
			}
			if (bMrnAcctBussInfo.getInitType() != null &&bMrnAcctBussInfo.getInitType().length() > 0) {
				cri.andInitTypeEqualTo(bMrnAcctBussInfo.getInitType());
				}
			if (bMrnAcctBussInfo.getBailType() != null &&bMrnAcctBussInfo.getBailType().length() > 0) {
				  cri.andBailTypeEqualTo(bMrnAcctBussInfo.getBailType());
				}
			if(bMrnAcctBussInfo.getProtocolNo()!=null&&bMrnAcctBussInfo.getProtocolNo().length()>0){
				cri.andProtocolNoEqualTo(bMrnAcctBussInfo.getProtocolNo());
			}
			if(bMrnAcctBussInfo.getMastContno()!=null&&bMrnAcctBussInfo.getMastContno().length()>0){
				cri.andMastContnoEqualTo(bMrnAcctBussInfo.getMastContno());
			}
			
			
			
		}
	    List  bmrnAcctBussInfoList=bMrnAcctBussInfoDAO.selectByExample(example);
		return bmrnAcctBussInfoList;
	}

	/**
	 * @Description: 获取最高额保证金信息
	 * @author  mengjiajia
	 * @Created 2012-9-25下午01:49:23
	 * @param protocolNo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getAccount(String slaveContno) {
		BMrnAcctBussInfoExample example = new BMrnAcctBussInfoExample();
		BMrnAcctBussInfoExample.Criteria cri = example.createCriteria();
		cri.andBailTypeEqualTo(ScfBasConstant.BAIL_TYPE_NORMAL);
		cri.andInitTypeEqualTo(ScfBasConstant.INIT_TYPE_MAX);
		cri.andSlaveContnoEqualTo(slaveContno);
		List list = bMrnAcctBussInfoDAO.selectByExample(example);
    	return list;
	}
	
	/**
	 *
	 * @Description: 根据保证金账号，主合同号，协议号，客户号，借据号查询客户账号信息
	 * @author wenkui.xu
	 * @Created 2012-11-12下午04:32:45
	 * @param bailBussInfoVO
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getTblCustAccountBussInfoByBailAccountno(BailBussInfoVO bailBussInfoVO) throws ScubeBizException {
		BMrnAcctBussInfoExample example = new BMrnAcctBussInfoExample();
		BMrnAcctBussInfoExample.Criteria cri = example.createCriteria();
	   	//保证金账户
	   	if(!StringUtil.isEmpty(bailBussInfoVO.getBailAccountno())){
	   		cri.andBailAccountnoEqualTo(bailBussInfoVO.getBailAccountno());
	   	}
	   	//主合同号
	   	if(!StringUtil.isEmpty(bailBussInfoVO.getSubContno())){
	   		cri.andMastContnoEqualTo(bailBussInfoVO.getSubContno());
	   	}
	   	//客户号
	   	if(!StringUtil.isEmpty(bailBussInfoVO.getCustcd())){
	   		cri.andCustcdEqualTo(bailBussInfoVO.getCustcd());
	   	}
	   	//协议号
	   	if(!StringUtil.isEmpty(bailBussInfoVO.getProtocolNo())){
	   		cri.andProtocolNoEqualTo(bailBussInfoVO.getProtocolNo());
	   	}
	   	//关联借据号
	   	if(bailBussInfoVO.getDebetNo()!=null){
	   		cri.andDebetNoEqualTo(bailBussInfoVO.getDebetNo());
	   	}
	   	//初始追加
	   	if(!StringUtil.isEmpty(bailBussInfoVO.getInitType())){
	   		cri.andInitTypeEqualTo(bailBussInfoVO.getInitType());
	   	}
	   	//帐号类型
	   	if(!StringUtil.isEmpty(bailBussInfoVO.getBailType())){
	   		cri.andBailTypeEqualTo(bailBussInfoVO.getBailType());
	   	}
		//抵质押合同号
	   	if(!StringUtil.isEmpty(bailBussInfoVO.getSlaveContno())){
	   		cri.andSlaveContnoEqualTo(bailBussInfoVO.getSlaveContno());
	   	}
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo> resultList = bMrnAcctBussInfoDAO.selectByExample(example);
		return resultList;
	}
}
