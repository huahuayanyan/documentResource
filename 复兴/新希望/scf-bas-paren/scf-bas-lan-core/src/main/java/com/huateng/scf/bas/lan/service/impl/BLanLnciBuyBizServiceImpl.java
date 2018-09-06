package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.service.IBCntBuyInfoService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanAppliLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBuyBizDAO;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBizExample.Criteria;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBizExample;
import com.huateng.scf.bas.lan.model.BLanLnciBuyBiz;
import com.huateng.scf.bas.lan.service.IBLanLnciBuyBizService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BLanLnciBuyBizServiceImpl")
public class BLanLnciBuyBizServiceImpl implements IBLanLnciBuyBizService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BLnaLnciBuyBizDAO")
	IBLanLnciBuyBizDAO ibLanLnciBuyBizDAO;
	@Resource(name = "BLanAppliLnciBaseDAO")
	IBLanAppliLnciBaseDAO ibLanAppliLnciBaseDAO;
	@Resource(name = "BCntBuyInfoServiceImpl")
	IBCntBuyInfoService bCntBuyInfoService;
	
	/**
	 * 普通分页查询--购销合同申请表
	 * @param pageNo
	 * @param pageSize
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	@Override
	public Page findBLanLnciBuyBizByPage(int pageNo, int pageSize,BLanLnciBuyBiz bLanLnciBuyBiz) {
		
		BLanLnciBuyBizExample example = new BLanLnciBuyBizExample();
		Criteria cri = example.createCriteria();
		
		if(bLanLnciBuyBiz!=null)
		{
			if(bLanLnciBuyBiz.getAppno()!=null&&bLanLnciBuyBiz.getAppno().length()>0)
			{
				cri.andAppnoEqualTo(bLanLnciBuyBiz.getAppno());
			}
		}
		example.setOrderByClause("INSERT_DATE DESC");
		
		int total = ibLanLnciBuyBizDAO.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		
		p.setRecords(ibLanLnciBuyBizDAO.selectByPage(example, p));
		log.info("p.toString()="+p.toString());
		return p;
	}
	
	/**
	 * @author liph
	 * @deprecated 插入操作，查看是否有数值
	 */
	public BLanLnciBuyBiz findBLanLnciBuyBizByKey(BLanLnciBuyBiz bLanLnciBuyBiz){
		bLanLnciBuyBiz.getAppno();
		bLanLnciBuyBiz.getTradeContno();
		
		BLanLnciBuyBizExample example = new BLanLnciBuyBizExample();
		Criteria cri = example.createCriteria();
		if(bLanLnciBuyBiz!=null){
			if(bLanLnciBuyBiz.getAppno()!=null&&bLanLnciBuyBiz.getAppno().length()>0){
				cri.andAppnoEqualTo(bLanLnciBuyBiz.getAppno());
			}
			if(bLanLnciBuyBiz.getTradeContno()!=null&&bLanLnciBuyBiz.getTradeContno().length()>0){
				cri.andTradeContnoEqualTo(bLanLnciBuyBiz.getTradeContno());
			}
			
		}
		example.setOrderByClause("INSERT_DATE DESC");
		List<com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz> list = ibLanLnciBuyBizDAO.selectByExample(example);
		BLanLnciBuyBiz bLanLnciBuyBiz2 = new BLanLnciBuyBiz();
		if(list.size()==0){
			bLanLnciBuyBiz2 = new BLanLnciBuyBiz();
		}else{
			com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz bLanLnciBuyBiz3 = list.get(0);
			BeanUtils.copyProperties(bLanLnciBuyBiz3, bLanLnciBuyBiz2);
		}
		return bLanLnciBuyBiz2;
	}
	
	/**
	 * @author liph
	 * 购销合同添加
	 */
	@Override
	@Transactional
	public String add(List<BLanLnciBuyBiz> list,String appno,String drawbackTerm) {
		
		List<BLanAppliLnciBase> lnciList = ibLanAppliLnciBaseDAO.selectByAppNo(appno);
		if(lnciList.size() == 0){
			log.info("根据appno获取申请借据信息失败");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20002),
					BLanErrorConstant.SCF_BAS_LAN_20002);
		}
		BLanAppliLnciBase bLanAppliLnciBase = lnciList.get(0);
		BigDecimal bigDecimal = new BigDecimal(drawbackTerm);
		bLanAppliLnciBase.setDrawbackTerm(bigDecimal);
		//更新申请借据表
		try {
			ibLanAppliLnciBaseDAO.updateByPrimaryKey(bLanAppliLnciBase);
		} catch (Exception e) {
			log.info("申请借据表更新失败");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
					BLanErrorConstant.SCF_BAS_LAN_20000);
		}
		
		for(int i=0;i<list.size();i++){
			BLanLnciBuyBiz biz = list.get(i);
			String tradeContno = biz.getTradeContno();
			Map map = new HashMap();
			map.put("appno", appno);
			map.put("tradeContno", tradeContno);
			List<com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz>buylist = ibLanLnciBuyBizDAO.selectByAppnoAndTrade(map);
			if(buylist.size() == 0){
				com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz biz2 = new com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz();
				biz.setId(UUIDGeneratorUtil.generate());
				biz.setAppno(appno);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String date = sdf.format(new Date());
				biz.setInsertDate(date);
				BeanUtils.copyProperties(biz, biz2);
				try {
					ibLanLnciBuyBizDAO.insert(biz2);
				} catch (Exception e) {
					log.info("插入购销合同流水表失败");
					e.printStackTrace();
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
							BLanErrorConstant.SCF_BAS_LAN_20000);
				}
			}
		}
		return null;
	}
	
	/**
	 * @author liph
	 * @deprecated 购销合同删除
	 */
	@Override
	public String delete(String id) {
		
		try {
			ibLanLnciBuyBizDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.info("购销合同流水表删除失败");
			e.printStackTrace();
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_20000),
					BLanErrorConstant.SCF_BAS_LAN_20000);
		}
		return null;
	}
	/**
	 * 更新
	 */
	@Override
	public int updateBLanLnciBuyBiz(BLanLnciBuyBiz bLanLnciBuyBiz) throws ScubeBizException {
		com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz bLanLnciBuyBizdal = 
				new com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz();
			try {
				BeanUtils.copyProperties(bLanLnciBuyBiz, bLanLnciBuyBizdal);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("购销合同流水表转换异常！");
				throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10008),BLanErrorConstant.SCF_BAS_LAN_10008);
			}
		int i=0;
		try {
			i = ibLanLnciBuyBizDAO.updateByPrimaryKeySelective(bLanLnciBuyBizdal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("购销合同流水信息更新异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10009),BLanErrorConstant.SCF_BAS_LAN_10009);
		}
		return i;
	}

	/**
	 *  bLanLnciBuyBiz
	 */
	@Override
	public List<BLanLnciBuyBiz> findBLanLnciBuyBizByCondition(BLanLnciBuyBiz bLanLnciBuyBiz) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz bLanLnciBuyBizDal = new com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz();
		BeanUtils.copyProperties(bLanLnciBuyBiz,bLanLnciBuyBizDal);
		 List<com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz> listdal=ibLanLnciBuyBizDAO.queryByCondition(bLanLnciBuyBizDal);
		List<BLanLnciBuyBiz> list = new ArrayList<BLanLnciBuyBiz>();
		 BLanLnciBuyBiz lnciBuyBiz = null;
		 if (listdal != null && listdal.size() > 0) {
			for (com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz info : listdal) {
				lnciBuyBiz = new BLanLnciBuyBiz();
				BeanUtils.copyProperties(info, lnciBuyBiz);
				list.add(lnciBuyBiz);
			}
		}
		return list;
	}
	/**
	 * 新增
	 */
	@Override
	public void addBLanLnciBuyBiz(BLanLnciBuyBiz bLanLnciBuyBiz) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz bLanLnciBuyBizdal = 
				new com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz();
		try {
			BeanUtils.copyProperties(bLanLnciBuyBiz, bLanLnciBuyBizdal);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("购销合同流水表转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10008),BLanErrorConstant.SCF_BAS_LAN_10008);
		}
		
		try {
			ibLanLnciBuyBizDAO.insertSelective(bLanLnciBuyBizdal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("购销合同流水信息插入异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10011),BLanErrorConstant.SCF_BAS_LAN_10011);
		}
	}


	
	
	
}
