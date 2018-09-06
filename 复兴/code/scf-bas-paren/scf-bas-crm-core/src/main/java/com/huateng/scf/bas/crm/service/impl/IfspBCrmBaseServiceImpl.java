/**
 * 
 */
package com.huateng.scf.bas.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmBaseInfoAndEntInfo;
import com.huateng.scf.bas.crm.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.service.IBCrmEntInfoService;
import com.huateng.scf.bas.crm.service.IIfspBcrmBaseService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>客户同步
 * </p>
 *
 * @author zhangcheng
 * @date 2017年3月4日下午4:47:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年3月4日下午4:47:51	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("IfspBCrmBaseServiceImpl")
public class IfspBCrmBaseServiceImpl implements IIfspBcrmBaseService {

	@Resource(name = "BCrmEntInfoServiceImpl")
	IBCrmEntInfoService iBCrmEntInfoService;
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO iBCrmBaseInfoDAO;
	// 用于客户新增页面，返回同时拥有两个表字段内容
		@Override
		public List<BCrmBaseInfoAndEntInfo> findBCrmBaseInfoAndEnt(List<BCrmBaseInfoAndEntInfo> list) {
			List<BCrmBaseInfoAndEntInfo> newList=new ArrayList();
			if(list!=null&&list.size()>0){
				for(BCrmBaseInfoAndEntInfo bCrmBaseInfoAndEntInfo:list){
			// 1.前台数据
			if (bCrmBaseInfoAndEntInfo == null || "".equals(bCrmBaseInfoAndEntInfo)) {
				throw new ScubeBizException("客户信息查询，所传数据无效！");
			}
			BCrmBaseInfoAndEntInfo info = new BCrmBaseInfoAndEntInfo();
			BCrmBaseInfoExample bbie = new BCrmBaseInfoExample();
			com.huateng.scf.bas.crm.dao.model.BCrmBaseInfoExample.Criteria criteria = bbie.createCriteria();
			// 根据客户号查询 custcd
			if (bCrmBaseInfoAndEntInfo.getCustcd() != null && !"".equals(bCrmBaseInfoAndEntInfo.getCustcd())) {
				criteria.andCustcdEqualTo(bCrmBaseInfoAndEntInfo.getCustcd());
			}
			if (bCrmBaseInfoAndEntInfo.getIdtype() != null && !"".equals(bCrmBaseInfoAndEntInfo.getIdtype())) {
				criteria.andIdtypeEqualTo(bCrmBaseInfoAndEntInfo.getIdtype());
			}
			if (bCrmBaseInfoAndEntInfo.getIdno() != null && !"".equals(bCrmBaseInfoAndEntInfo.getIdno())) {
				criteria.andIdnoEqualTo(bCrmBaseInfoAndEntInfo.getIdno());
			}
			// 组织机构代码orgCode
			if (bCrmBaseInfoAndEntInfo.getOrgCode() != null && !"".equals(bCrmBaseInfoAndEntInfo.getOrgCode())) {
				criteria.andOrgCodeEqualTo(bCrmBaseInfoAndEntInfo.getOrgCode());
			}
			// 管户员(mgrno)
			if (bCrmBaseInfoAndEntInfo.getMgrno() != null && !"".equals(bCrmBaseInfoAndEntInfo.getMgrno())) {
				criteria.andMgrnoEqualTo(bCrmBaseInfoAndEntInfo.getMgrno());
			}
			BCrmBaseInfo bCrmBaseInfo2 = new BCrmBaseInfo();
			BCrmEntInfo bCrmEntInfo2 = new BCrmEntInfo();
			// 2.查询客户信息
			try {
				List<com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo> bCrmBaseInfos = iBCrmBaseInfoDAO.selectByExample(bbie);
				if (bCrmBaseInfos != null && bCrmBaseInfos.size() == 1) {
					com.huateng.scf.bas.crm.dao.model.BCrmBaseInfo bCrmBaseInfo1 = bCrmBaseInfos.get(0);
					BeanUtils.copyProperties(bCrmBaseInfo1, bCrmBaseInfo2);
					// 对应企业信息查询
					BCrmEntInfo bCrmEntInfo = new BCrmEntInfo();
					bCrmEntInfo.setCustcd(bCrmBaseInfo2.getCustcd());
					BCrmEntInfo entInfo = iBCrmEntInfoService.findBCrmEntInfoByKey(bCrmEntInfo);
					if (entInfo != null && !"".equals(entInfo)) {
						BeanUtils.copyProperties(entInfo, bCrmEntInfo2);
					}
				} else {
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("条件查询客户基本信息失败！");
			}
		
				try {
					BeanUtils.copyProperties(bCrmEntInfo2, info);
					BeanUtils.copyProperties(bCrmBaseInfo2, info);
					newList.add(info);
					
				} catch (Exception e) {
					throw new ScubeBizException("查询具体客户信息，数据拷贝错误！");
				}
			}}
			return newList;

		}	
	
}
