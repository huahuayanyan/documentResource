package com.huateng.scf.bas.crm.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmContactsInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmContactsInfo;
import com.huateng.scf.bas.crm.dao.model.BCrmContactsInfoExample;
import com.huateng.scf.bas.crm.dao.model.BCrmContactsInfoExample.Criteria;
import com.huateng.scf.bas.crm.service.IBCrmContactsInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
@ScubeService
@Service("BCrmContactsInfoServiceImpl")
public class BCrmContactsInfoServiceImpl implements IBCrmContactsInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="IBCrmContactsInfoDAO")
	private IBCrmContactsInfoDAO bCrmContactsInfoDAO;
	
	@Override
	public Page findContractsInfoByPage(int pageNo, int pageSize, String custcd) {
		Page p = new Page(pageSize, pageNo, 0);
		BCrmContactsInfoExample example = new BCrmContactsInfoExample();
		Criteria cri = example.createCriteria();

		try {
			if(StringUtils.isNotEmpty(custcd)){
				cri.andCustcdEqualTo(custcd);
				List<com.huateng.scf.bas.crm.dao.model.BCrmContactsInfo> list=bCrmContactsInfoDAO.selectByPage(example,p);
				p.setRecords(list);
			}
			return p;
		} catch (Exception e) {
			log.error("查询联系人信息失败！");
			throw new ScubeBizException("查询联系人信息失败！", e);
		}
	}

	@Override
	@Transactional
	public String add(BCrmContactsInfo bCrmContactsInfo) {
		//获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
		bCrmContactsInfo.setId(UUIDGeneratorUtil.generate());

		Date now = new Date();
		bCrmContactsInfo.setTlrcd(user.getTlrNo());
		bCrmContactsInfo.setCrtTime(now);
		bCrmContactsInfo.setBrcode(brCode);
		
		bCrmContactsInfo.setLastUpdTlrcd(user.getTlrNo());
		bCrmContactsInfo.setLastUpdTime(now);
		bCrmContactsInfo.setLastUpdBrcode(brCode);
		try {
			bCrmContactsInfoDAO.insert(bCrmContactsInfo);
		} catch (Exception e) {
			log.error("新增联系人信息失败！");
			throw new ScubeBizException("新增联系人信息失败！", e);
		}
		return null;
	}

	@Override
	@Transactional
	public int delete(String[] custcds) {
		if(custcds.length==0){
			throw new ScubeBizException("请先选择一条记录！");
		}
		try {		
			for (String custcd : custcds) {
				bCrmContactsInfoDAO.deleteByPrimaryKey(custcd);
			}			
		} catch (Exception e) {
			log.error("删除联系人信息失败！");
			throw new ScubeBizException("删除联系人信息失败！", e);
		}
		return 0;
	}

	@Override
	@Transactional
	public int update(BCrmContactsInfo bCrmContactsInfo) {
		//获取当前用户 
		UserInfo user = ContextHolder.getUserInfo(); 
	    String brCode=user.getBrNo();
		bCrmContactsInfo.setLastUpdTlrcd(user.getTlrNo());
		bCrmContactsInfo.setLastUpdTime(new Date());
		bCrmContactsInfo.setLastUpdBrcode(brCode);
		try {
			bCrmContactsInfoDAO.updateByPrimaryKeySelective(bCrmContactsInfo);
		} catch (Exception e) {
			log.error("修改联系人信息失败！");
			throw new ScubeBizException("修改联系人信息失败！", e);
		}
		return 0;
	}
	
}
