/**
 * 
 */
package com.huateng.scf.bas.nte.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBillDAO;
import com.huateng.scf.bas.nte.model.BNteNoticeBill;
import com.huateng.scf.bas.nte.service.IBNteNoticeBillService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 	2016年12月15日上午9:32:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月15日上午9:32:21	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BNteNoticeBillServiceImpl")
public class BNteNoticeBillServiceImpl implements IBNteNoticeBillService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BNteNoticeBillDAO")
	IBNteNoticeBillDAO bNteNoticeBillDAO;
	@Transactional
	@Override
	public void addBNteNoticeBill(BNteNoticeBill bNteNoticeBill) throws ScubeBizException{
		//ScfCommonUtil.setCommonField(bNteNoticeBill);//设置公共字段 add by huangshuidan 2016-11-11
		bNteNoticeBill.setId(UUIDGeneratorUtil.generate());
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBill bNteNoticeBilldal = new com.huateng.scf.bas.nte.dao.model.BNteNoticeBill();
		BeanUtils.copyProperties(bNteNoticeBill, bNteNoticeBilldal); 
	    //TODO
		bNteNoticeBillDAO.insertSelective(bNteNoticeBilldal);
	}
	@Transactional
	@Override
	public int updateBNteNoticeBill(BNteNoticeBill bNteNoticeBill) throws ScubeBizException {
		// TODO Auto-generated method stub
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBill bNteNoticeBilldal = 
				new com.huateng.scf.bas.nte.dao.model.BNteNoticeBill();
			BeanUtils.copyProperties(bNteNoticeBill, bNteNoticeBilldal);
		return bNteNoticeBillDAO.updateByPrimaryKeySelective(bNteNoticeBilldal);
	}
	@Transactional
	@Override
	public int deleteBNteNoticeBill(String key) throws ScubeBizException {
		// TODO Auto-generated method stub
		return bNteNoticeBillDAO.deleteByPrimaryKey(key);
	}

	@Override
	public BNteNoticeBill findBNteNoticeBillByKey(String key) throws ScubeBizException {
		BNteNoticeBill bNteNoticeBill = new BNteNoticeBill();
		com.huateng.scf.bas.nte.dao.model.BNteNoticeBill bNteNoticeBilldal = 
				new com.huateng.scf.bas.nte.dao.model.BNteNoticeBill();
		bNteNoticeBilldal=bNteNoticeBillDAO.selectByPrimaryKey(key);
		BeanUtils.copyProperties(bNteNoticeBilldal, bNteNoticeBill);
		return bNteNoticeBill;
	}
	 /**
     * 通过APPNO查找通知书票据信息
     * @param appno
     * @return
     */
	@Override
	public List<BNteNoticeBill> findBNteNoticeBillByAppno(String appno) throws ScubeBizException{
		List<BNteNoticeBill> list =  new ArrayList<BNteNoticeBill>(); 
		BNteNoticeBill bNteNoticeBill = null;
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBill> listdal=  bNteNoticeBillDAO.findBNteNoticeBillByAppno(appno);
		for(com.huateng.scf.bas.nte.dao.model.BNteNoticeBill info:listdal){
			bNteNoticeBill = new BNteNoticeBill();
			BeanUtils.copyProperties(info, bNteNoticeBill);
			list.add(bNteNoticeBill);
		}
		return list;
	}
}
