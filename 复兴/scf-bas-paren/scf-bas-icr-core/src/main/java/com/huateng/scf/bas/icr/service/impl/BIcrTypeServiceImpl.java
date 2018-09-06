package com.huateng.scf.bas.icr.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.icr.constant.BIcrConstant;
import com.huateng.scf.bas.icr.dao.IBIcrTypeDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrTypeExample;
import com.huateng.scf.bas.icr.dao.model.BIcrTypeExample.Criteria;
import com.huateng.scf.bas.icr.model.BIcrAppliInfo;
import com.huateng.scf.bas.icr.model.BIcrInfo;
import com.huateng.scf.bas.icr.model.BIcrType;
import com.huateng.scf.bas.icr.model.CreditTypeQryVO;
import com.huateng.scf.bas.icr.service.IBIcrAppliInfoService;
import com.huateng.scf.bas.icr.service.IBIcrInfoService;
import com.huateng.scf.bas.icr.service.IBIcrTypeService;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;


@ScubeService
@Service("BIcrTypeServiceImpl")
public class BIcrTypeServiceImpl implements IBIcrTypeService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BIcrTypeDAO")
	IBIcrTypeDAO BIcrTypeDAO;
	@Resource(name = "BSysSerialNoServiceImpl")
	private  IBSysSerialNoService bSysSerialNoService;
	@Resource(name = "orgService")
	OrgService orgService;
	@Resource(name = "userService")
	UserService userService;
	/*@Resource(name = "scubeUserService")
	ScubeUserService scubeUserService;*/
	@Resource(name = IBIcrInfoService.BEAN_ID)
	IBIcrInfoService bIcrInfoService;  //额度信息
	@Resource(name = IBIcrAppliInfoService.BEAN_ID)
	IBIcrAppliInfoService bIcrAppliInfoService;  //额度申请信息
	@Transactional
	public void add(BIcrType bIcrType) {
		ScfCommonUtil.setCommonField(bIcrType);//设置公共字段 add by huangshuidan 2016-11-11
		com.huateng.scf.bas.icr.dao.model.BIcrType bIcrTypedal = new com.huateng.scf.bas.icr.dao.model.BIcrType();
		BeanUtils.copyProperties(bIcrType, bIcrTypedal); 
		bIcrTypedal.setId(UUIDGeneratorUtil.generate());  //uuid
	     //获取机构信息
	     BctlVO BctlVO = ContextHolder.getOrgInfo();
	     String brcode = BctlVO.getBrNo();
	     bIcrTypedal.setBrcode(brcode);
	     String creditType =bSysSerialNoService.genSerialNo(ScfBasConstant.BUSSNO_TYPE_INDIRECT_CREDIT_NO);
	     bIcrTypedal.setCreditType(creditType);
	     
		BIcrTypeDAO.insert(bIcrTypedal);
	}
	@Transactional
	public int update(BIcrType bIcrType) {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.icr.dao.model.BIcrType bIcrTypedal = 
				new com.huateng.scf.bas.icr.dao.model.BIcrType();
		try {
			BeanUtils.copyProperties(bIcrType, bIcrTypedal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			throw new ScubeBizException("批量删除失败","001");
		} 
		return BIcrTypeDAO.updateByPrimaryKey(bIcrTypedal);
	}
	@Transactional
	@Override
	public int delete(String key) {
		// TODO Auto-generated method stub
		return BIcrTypeDAO.deleteByPrimaryKey(key);
	}

	public Page findBIcrTypeByPage(int pageNo, int pageSize, BIcrType bIcrType) {
		// TODO Auto-generated method stub
		BIcrTypeExample example = new BIcrTypeExample() ;
		Page p = new Page(pageSize, pageNo, 0);
		if (bIcrType != null) {
			Criteria criteria = example.createCriteria();
			if (bIcrType.getCreditClass() != null) {
				//example.createCriteria().andConNameEqualTo(scfCon.getConName()); //==
				criteria.andCreditClassEqualTo(bIcrType.getCreditClass());
			}
			if(bIcrType.getCreditType()!=null){
				criteria.andCreditTypeEqualTo(bIcrType.getCreditType());
			}
			if(bIcrType.getCreditName()!=null){
				criteria.andCreditNameEqualTo(bIcrType.getCreditName());
			}
			
		}
		//BeanUtils.copyProperties(exampledal, example);
		p.setRecords(BIcrTypeDAO.selectByPage(example, p));
		return p;
	}

	@Override
	public BIcrType findBIcrTypeByKey(String key) {
		BIcrType bIcrType = new BIcrType();
		com.huateng.scf.bas.icr.dao.model.BIcrType bIcrTypedal = 
				new com.huateng.scf.bas.icr.dao.model.BIcrType();
		bIcrTypedal=BIcrTypeDAO.selectByPrimaryKey(key);
		
		BeanUtils.copyProperties(bIcrTypedal, bIcrType);
		String userId =bIcrType.getLastUpdTlrcd();
		UserInfo userInfo = new UserInfo();
		userInfo.setTlrNo(userId);
		List<TlrInfoVO> tlrVOList= userService.selectByExample(userInfo);
		if(tlrVOList!=null&&tlrVOList.size()==1){
			userId = tlrVOList.get(0).getTlrName();
		}else{
			throw new ScubeBizException("操作员不存在或是操作员号重复", "");
		}
		//List<BctlVO> bctlVOList
		BctlVO  bctl= new BctlVO();
		String lastUpdBrcode =bIcrType.getLastUpdBrcode();
		if(StringUtil.isStrNotEmpty(lastUpdBrcode)){
			bctl.setBrNo(lastUpdBrcode);
			List<BctlVO> bctlVOList2 = orgService.selectByExample(bctl);
			if (bctlVOList2 != null && bctlVOList2.size() == 1) {
				bIcrType.setLastUpdBrcode(bctlVOList2.get(0).getBrName());
			} 
		}
		bIcrType.setLastUpdTlrcd(userId);
		//Date lastUpdTime =bIcrType.getLastUpdTime();
		return bIcrType;
	}
	@Override
	@Transactional
	public int batchDelete(List<Map<String, Object>> bIcrTypeList) {
		// TODO Auto-generated method stub
		Iterator<Map<String, Object>> it =bIcrTypeList.iterator();
		List<String> idList = new ArrayList<String>() ;
		while(it.hasNext()){
			Map<String, Object> row=it.next();
			String id=row.get("id")==null?"0":row.get("id").toString();
			
			//TODO
			//校验是否可以删除 begin
			BIcrType bIcrType =this.findBIcrTypeByKey(id);
			String creditType = bIcrType.getCreditType();
			Page page = new Page(1,Integer.MAX_VALUE);
			BIcrInfo bIcrInfo = new BIcrInfo();
			bIcrInfo.setCreditType(creditType);
			page = bIcrInfoService.findBIcrInfoByPage(page.getPageNo(), page.getPageSize(), bIcrInfo);
			List list = page.getRecords();
			if(list!=null&&list.size()>0){
				log.error("种类编号【"+creditType+"】额度种类名称【"+bIcrType.getCreditName()+"】的额度存在，不允许删除");
				//throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.RECORD_HAS_EXIST),BSysErrorConstant.RECORD_HAS_EXIST);
				throw new ScubeBizException("种类编号【"+creditType+"】额度种类名称【"+bIcrType.getCreditName()+"】的额度存在，不允许删除", BSysErrorConstant.RECORD_HAS_EXIST);
			}
			BIcrAppliInfo bIcrAppliInfo = new BIcrAppliInfo();
			bIcrAppliInfo.setCreditType(creditType);
			bIcrAppliInfo.setStatus(BIcrConstant.CREDIT_STATUS_NORMAL);
			List appliList=bIcrAppliInfoService.queryCreditAppliInfoByPage(page.getPageNo(), page.getPageSize(),bIcrAppliInfo).getRecords();
			if(appliList!=null&&appliList.size()>0){
				log.error("种类编号【"+creditType+"】额度种类名称【"+bIcrType.getCreditName()+"】的额度正在申请流程中，不允许删除");
				//throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.RECORD_HAS_EXIST),BSysErrorConstant.RECORD_HAS_EXIST);
				throw new ScubeBizException("种类编号【"+creditType+"】额度种类名称【"+bIcrType.getCreditName()+"】的额度正在申请流程中，不允许删除", BSysErrorConstant.RECORD_HAS_EXIST);
			}
			//校验是否可以删除 end
			
			idList.add(id);
			
		}
		int i=0;
		try {
			i = BIcrTypeDAO.batchDelete(idList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ScubeBizException("批量删除失败","001");
		}
		return i;
	}
	/**
	 * 额度种类筛选
	 */
	@Override
	public Page selectBIcrType(int pageNo, int pageSize, BIcrType bIcrType) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		com.huateng.scf.bas.icr.dao.model.BIcrType bIcrTypedal = new com.huateng.scf.bas.icr.dao.model.BIcrType();
		BeanUtils.copyProperties(bIcrType, bIcrTypedal);
		p.setRecords(BIcrTypeDAO.selectBIcrType(bIcrTypedal, p));
		return p;
	}

	/**
	 * 
	 * @Description: 查询额度种类信息
	 * @author wenkui.xu
	 * @Created 2013-8-5下午3:17:54
	 * @param creditTypeQryVO
	 * @return
	 * @throws CommonException
	 */
	@Override
	public List<BIcrType> getCreditTypeInfoByCreditTypeQryVO(CreditTypeQryVO creditTypeQryVO)throws ScubeBizException {
		BIcrTypeExample example = new BIcrTypeExample();
		BIcrTypeExample.Criteria cri = example.createCriteria();
		if(!StringUtil.isEmpty(creditTypeQryVO.getCreditClass_Q())){
			cri.andCreditClassEqualTo(creditTypeQryVO.getCreditClass_Q());
		}
		if(!StringUtil.isEmpty(creditTypeQryVO.getCreditType_Q())){
			cri.andCreditTypeEqualTo(creditTypeQryVO.getCreditType_Q());
		}
		List<com.huateng.scf.bas.icr.dao.model.BIcrType> listdal = BIcrTypeDAO.selectByExample(example);
		List<BIcrType> list = new ArrayList<BIcrType>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.icr.dao.model.BIcrType bIcrTypedal:listdal)
			{
				BIcrType bIcrType = new BIcrType();
				BeanUtils.copyProperties(bIcrTypedal, bIcrType);
				list.add(bIcrType);
			}
		}
		return list;
	}
	
	/**
	 * DESCRIPTION:根据creditType查询额度参数表
	 *
	 * @author zhoujun.hou
	 * @date 2013-5-27 getTblCreditTypeBycreditType 方法
	 * @param creditType
	 * @return
	 * @throws CommonException
	 * @param commonQueryVO
	 * @return
	 */
	@Override
	public BIcrType getTblCreditTypeByCreditType(String creditType) throws ScubeBizException {
		log.debug("creditType="+creditType);
		BIcrTypeExample example = new BIcrTypeExample();
		BIcrTypeExample.Criteria cri = example.createCriteria();
		cri.andCreditTypeEqualTo(creditType);
		List<com.huateng.scf.bas.icr.dao.model.BIcrType> listdal = BIcrTypeDAO.selectByExample(example);
		BIcrType bIcrType = new BIcrType();
		if(listdal.size()>0)
		{
			BeanUtils.copyProperties(listdal.get(0), bIcrType);
		}
		return bIcrType;
	}
}
