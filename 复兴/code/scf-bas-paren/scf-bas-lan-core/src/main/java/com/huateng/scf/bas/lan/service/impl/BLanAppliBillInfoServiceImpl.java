/**
 * 
 */
package com.huateng.scf.bas.lan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.IBLanAppliBillInfoDAO;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.model.BLanAppliBillInfoExample.Criteria;
import com.huateng.scf.bas.lan.dao.model.BLanAppliBillInfoExample;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.model.BLanAppliBillInfo;
import com.huateng.scf.bas.lan.service.IBLanAppliBillInfoService;

import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p></p>
 *
 * @author 	liph
 * @date 	2016年12月12日下午1:52:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月12日下午1:52:46	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BLanAppliBillInfoServiceImpl")
public class BLanAppliBillInfoServiceImpl implements IBLanAppliBillInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BLanAppliBillInfoDAO")
	IBLanAppliBillInfoDAO bLanAppliBillInfoDAO;
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO ibLanLnciBaseDAO;
	/**
	 * 普通分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param bMrnAppliAcctInfo
	 * @return
	 */
	@Override
	public Page findBLanAppliBillInfoByPage(int pageNo, int pageSize,BLanAppliBillInfo bLanAppliBillInfo) {
		
		BLanAppliBillInfoExample example = new BLanAppliBillInfoExample();
		Criteria cri = example.createCriteria();
		
		if(bLanAppliBillInfo!=null)
		{
			if(bLanAppliBillInfo.getAppno()!=null&&bLanAppliBillInfo.getAppno().length()>0)
			{
				cri.andAppnoEqualTo(bLanAppliBillInfo.getAppno());
			}
			if(bLanAppliBillInfo.getBillNo()!=null&&bLanAppliBillInfo.getBillNo().length()>0)
			{
				cri.andBillNoEqualTo(bLanAppliBillInfo.getBillNo());
			}
		}
		example.setOrderByClause("BILL_DATE DESC");
		
		int total = bLanAppliBillInfoDAO.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);
		
		log.info("totalPage="+p.getTotalPage());
		log.info("totalPage="+p.getTotalPage());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("totalRecord="+p.getTotalRecord());
		log.info("current="+p.getCurrent());
		log.info("current="+p.getCurrent());
		bLanAppliBillInfoDAO.selectByPage(example, p);
		List list = p.getRecords();
		List resultList = new ArrayList();
		if(list.size()>0||list!=null){
			for(int i=0;i<list.size();i++){
				BLanAppliBillInfo info = new BLanAppliBillInfo();
				com.huateng.scf.bas.lan.dao.model.BLanAppliBillInfo appliBillInfo = (com.huateng.scf.bas.lan.dao.model.BLanAppliBillInfo) list.get(i);
				appliBillInfo.setDebetId("");
				BeanUtils.copyProperties(appliBillInfo, info);
				//借据编号从正式表取
				String debetNo = appliBillInfo.getDebetNo();
				BLanLnciBase bLanLnciBase = ibLanLnciBaseDAO.selectByPrimaryKey(debetNo);
				if(bLanLnciBase!=null){
					info.setDebetId(bLanLnciBase.getDebetId());
				}
				resultList.add(info);
			}
		}
		p.setRecords(resultList);
		log.info("p.toString()="+p.toString());
		return p;
	}
	
}
