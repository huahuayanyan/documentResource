package com.huateng.scf.nrec.bcp.service.impl;

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

import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.mrn.dao.IBMrnAppliAcctInfoDAO;
import com.huateng.scf.bas.mrn.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.sys.model.BSysAcctBctl;
import com.huateng.scf.bas.sys.service.IBSysAcctBctlService;
import com.huateng.scf.nrec.bcp.service.INBMrnAppliAcctInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service(INBMrnAppliAcctInfoService.BEAN_ID)
public class NBMrnAppliAcctInfoServiceImpl implements INBMrnAppliAcctInfoService {
	
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBMrnAppliAcctInfoDAO")
	IBMrnAppliAcctInfoDAO bmrnappliacctinfodao;
	
	//银行网点
	@Resource(name = "BSysAcctBctlServiceImpl")
	IBSysAcctBctlService ibsysacctbctlservice;

	@SuppressWarnings("rawtypes")
	@Override
	public void clearTblAppliCustAccountInfo(String appno) throws ScubeBizException {
		List list = this.findBMrnAppliAcctInfoByAppno(appno);
		if(list!=null && list.size()>0){
			Iterator iter = list.iterator();
			while(iter.hasNext()){
				BMrnAppliAcctInfo applyVO = (BMrnAppliAcctInfo)iter.next();
				bmrnappliacctinfodao.deleteByPrimaryKey(applyVO.getId());
			}
		}
	}

	@Override
	@Transactional
	public void add(BMrnAppliAcctInfo bMrnAppliAcctInfo) {
		log.debug("保证金申请添加");
		BCrrModelCommonUtil.setAddField(bMrnAppliAcctInfo);
		if(StringUtil.isEmpty(bMrnAppliAcctInfo.getId()))
		{
			String id = UUIDGeneratorUtil.generate();
			bMrnAppliAcctInfo.setId(id);
		}
		com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo bmrappdal = 
				new com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo();
		try
		{
			BeanUtils.copyProperties(bMrnAppliAcctInfo, bmrappdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bmrnappliacctinfodao.insertSelective(bmrappdal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
	}
	
	/***
	 * 根据申请编号查询冻结保证金申请信息
	 */
	public List<BMrnAppliAcctInfo> findBMrnAppliAcctInfoByAppno(String appno) {
		List<com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo> listdal = bmrnappliacctinfodao.selectByAppno(appno);
		List<BMrnAppliAcctInfo> list = new ArrayList<BMrnAppliAcctInfo>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo bmrnappdal : listdal)
			{
				BMrnAppliAcctInfo bmrnapp = new BMrnAppliAcctInfo();
				try
				{
					BeanUtils.copyProperties(bmrnappdal, bmrnapp);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				if(StringUtil.isStrNotEmpty(bmrnapp.getActBrCd()))
				{
					BSysAcctBctl bctl = ibsysacctbctlservice.findBSysAcctBctlByBrcode(bmrnapp.getActBrCd());
					if(bctl!=null)
					{
						bmrnapp.setActBrNm(bctl.getBrname());
					}
				}
				list.add(bmrnapp);
			}
		}
		return list;
	}

}
