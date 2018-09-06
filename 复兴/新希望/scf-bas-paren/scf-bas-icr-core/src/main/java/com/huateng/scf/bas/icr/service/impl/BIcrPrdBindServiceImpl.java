/**
 * 
 */
package com.huateng.scf.bas.icr.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.icr.dao.IBIcrPrdBindDAO;
import com.huateng.scf.bas.icr.dao.model.BIcrPrdBindExample;
import com.huateng.scf.bas.icr.dao.model.BIcrPrdBindExample.Criteria;
import com.huateng.scf.bas.icr.model.BIcrPrdBind;
import com.huateng.scf.bas.icr.service.IBIcrPrdBindService;
import com.huateng.scf.bas.prd.constant.BPrdConstant;
import com.huateng.scf.bas.prd.dao.IBPrdInfoDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdInfoExample;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月3日下午2:07:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月3日下午2:07:42	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BIcrPrdBindServiceImpl")
public class BIcrPrdBindServiceImpl implements IBIcrPrdBindService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BIcrPrdBindDAO")
	IBIcrPrdBindDAO iBIcrPrdBindDAO;
	@Resource(name = "BPrdInfoServiceImpl")
	private  IBPrdInfoService bPrdInfoService;
	@Resource(name = "BPrdInfoDAO")
	IBPrdInfoDAO bPrdInfoDAO;
	@Override
	@Transactional
	public void addBIcrPrdBind(BIcrPrdBind bIcrPrdBind) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.icr.dao.model.BIcrPrdBind bIcrPrdBinddal = new com.huateng.scf.bas.icr.dao.model.BIcrPrdBind();
		bIcrPrdBind.setId(UUIDGeneratorUtil.generate());
		try {
			BeanUtils.copyProperties(bIcrPrdBind, bIcrPrdBinddal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ScubeBizException("转换异常",e);
		} 
		try {
			iBIcrPrdBindDAO.insert(bIcrPrdBinddal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ScubeBizException("新增异常",e);
		}
	}

	@Override
	@Transactional
	public int updateBIcrPrdBind(BIcrPrdBind bIcrPrdBind) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.icr.dao.model.BIcrPrdBind bIcrPrdBinddal = new com.huateng.scf.bas.icr.dao.model.BIcrPrdBind();
		BeanUtils.copyProperties(bIcrPrdBind, bIcrPrdBinddal);
		return iBIcrPrdBindDAO.updateByPrimaryKey(bIcrPrdBinddal);
	}

	@Override
	@Transactional
	public int deleteBIcrPrdBind(String key) throws ScubeBizException{
		// TODO Auto-generated method stub
		return iBIcrPrdBindDAO.deleteByPrimaryKey(key);
	}
	/**
	 * 获取额度品种与产品的绑定关系关系
	 */
	@Override
	public Page findBIcrPrdBindByPage(int pageNo, int pageSize, BIcrPrdBind bIcrPrdBind) throws ScubeBizException{
		// TODO Auto-generated method stub
		BIcrPrdBindExample example = new BIcrPrdBindExample(); 
		Page p = new Page(pageSize, pageNo, 0);
		if(bIcrPrdBind!=null){
			  Criteria criteria =example.createCriteria();
			if(bIcrPrdBind.getCreditType()!=null){
				criteria.andCreditTypeEqualTo(bIcrPrdBind.getCreditType());
			}
		}
		p.setRecords(iBIcrPrdBindDAO.selectByPage(example, p));
		return p;
	}
	@Override
	public BIcrPrdBind findBIcrPrdBindByKey(String key) throws ScubeBizException{
		// TODO Auto-generated method stub
		return null;
	}
	//ext
	 
	/**
	 * 获取额度品种与产品的绑定关系关系 不分页
	 */
	public List<BIcrPrdBind> findBIcrPrdBindList(BIcrPrdBind bIcrPrdBind) throws ScubeBizException{
		// TODO Auto-generated method stub
		List<BIcrPrdBind>  list = new ArrayList<BIcrPrdBind>();
		BIcrPrdBindExample example = new BIcrPrdBindExample(); 

		if(bIcrPrdBind!=null){
			  Criteria criteria =example.createCriteria();
			if(bIcrPrdBind.getCreditType()!=null){
				criteria.andCreditTypeEqualTo(bIcrPrdBind.getCreditType());
			}
		}
		List<com.huateng.scf.bas.icr.dao.model.BIcrPrdBind>  listdal =iBIcrPrdBindDAO.selectByExample(example);
		Iterator it=listdal.iterator();
		while(it.hasNext()){
			com.huateng.scf.bas.icr.dao.model.BIcrPrdBind  bIcrPrdBinddal =(com.huateng.scf.bas.icr.dao.model.BIcrPrdBind) it.next();
			BIcrPrdBind bIcrPrdBindVo = new BIcrPrdBind();
			BeanUtils.copyProperties(bIcrPrdBinddal, bIcrPrdBindVo);
			list.add(bIcrPrdBindVo);
			
		}
		return list;
	}
	/**
	 * 查询所有供应链品种 不分页
	 * @param bIcrPrdBind
	 * @return
	 */
	public List<BPrdInfo> findPrdInfoList(BPrdInfo bPrdInfo) throws ScubeBizException {
		// TODO Auto-generated method stub
		List<BPrdInfo>  list = new ArrayList<BPrdInfo>();
		BPrdInfoExample example = new BPrdInfoExample(); 
		if(bPrdInfo!=null){
			com.huateng.scf.bas.prd.dao.model.BPrdInfoExample.Criteria  criteria =example.createCriteria();
			if(bPrdInfo.getProductType()!=null){
				criteria.andProductTypeEqualTo(bPrdInfo.getProductType());
			}
		}
		List<com.huateng.scf.bas.prd.dao.model.BPrdInfo>  listdal =bPrdInfoDAO.selectByExample(example);
		Iterator it=listdal.iterator();
		while(it.hasNext()){
			com.huateng.scf.bas.prd.dao.model.BPrdInfo  BPrdInfodal =(com.huateng.scf.bas.prd.dao.model.BPrdInfo) it.next();
			BPrdInfo  bPrdInfoVo = new BPrdInfo();
			BeanUtils.copyProperties(BPrdInfodal, bPrdInfoVo);
			list.add(bPrdInfoVo);
			
		}
		return list;
	}
	/**
	 * 获取额度品种与产品的绑定关系关系
	 */
	public Page findBIcrTypePrdBind(int pageNo, int pageSize, BIcrPrdBind bIcrPrdBind) throws ScubeBizException {
		// 查询所有供应链品种(小类) 页面传参数 ，调用bPrdInfoService.findPrdInfoByPage
		Page p = new Page(pageSize, pageNo, 0);
		BPrdInfo bPrdInfo = new  BPrdInfo();
		bPrdInfo.setProductType(BPrdConstant.PRODUCT_TYPE_LEAFCLASS); //小类
		//Page p=bPrdInfoService.findPrdInfoByPage(pageNo, pageSize, bPrdInfo);
		 List<BPrdInfo> productList =findPrdInfoList(bPrdInfo);
		 List<BPrdInfo> pselectList = new ArrayList<BPrdInfo>(); //已选中的记录
		//获取额度品种与产品的绑定关系关系
	/*	BIcrPrdBind bIcrPrdBind = new  BIcrPrdBind();
		bIcrPrdBind.setCreditType(bIcrType.getCreditType());*/
		//Page page=findBIcrPrdBindByPage(pageNo, pageSize, bIcrPrdBind);
		List<BIcrPrdBind> bIcrPrdList=findBIcrPrdBindList(bIcrPrdBind);
		
		if(productList!=null&&productList.size()>0){
			for(int i=0; i<productList.size(); i++){
				BPrdInfo  product = new  BPrdInfo();
				BeanUtils.copyProperties(productList.get(i),product);
				for(int j=0; j<bIcrPrdList.size(); j++){
					BIcrPrdBind  prdBind  = new BIcrPrdBind();
					BeanUtils.copyProperties(bIcrPrdList.get(j),prdBind);
					if(product.getProductId().equals(prdBind.getProductId())){
						pselectList.add(product);
						bIcrPrdList.remove(j);//移除
					}
				}
			}
			p.setRecords(pselectList);
		}
		return p;
	}
	/**
	 * 额度与产品绑定保存
	 * @param bIcrPrdBindList
	 * @param creditType
	 * @throws ScubeBizException
	 */
	@Override
	public void saveBIcrTypePrdBind(List<BIcrPrdBind> bIcrPrdBindList, String creditType) throws ScubeBizException {
		// TODO Auto-generated method stub
		//删除额度品种原来的绑定关系
		BIcrPrdBind bIcrPrdBinddel = new BIcrPrdBind();
		bIcrPrdBinddel.setCreditType(creditType);
		com.huateng.scf.bas.icr.dao.model.BIcrPrdBind bIcrPrdBinddal = new com.huateng.scf.bas.icr.dao.model.BIcrPrdBind();
		try {
			BeanUtils.copyProperties(bIcrPrdBinddel, bIcrPrdBinddal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ScubeBizException("转换异常",e);
		}
		try {
			iBIcrPrdBindDAO.deleteBIcrPrdBindByCreditType(bIcrPrdBinddal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ScubeBizException("删除异常",e);
		}
		for (Iterator it = bIcrPrdBindList.iterator(); it.hasNext();) {
			BIcrPrdBind bIcrPrdBind = (BIcrPrdBind) it.next();
			bIcrPrdBind.setCreditType(creditType);
			bIcrPrdBind.setProductId(bIcrPrdBind.getProductId());
			addBIcrPrdBind(bIcrPrdBind);
		}
	
	}
	
	

}
