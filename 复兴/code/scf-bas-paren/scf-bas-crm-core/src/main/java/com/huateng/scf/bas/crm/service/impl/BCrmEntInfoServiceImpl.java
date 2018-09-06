/**
 * 
 */
package com.huateng.scf.bas.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpIndustryTypesDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmEntInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmEntInfoExample;
import com.huateng.scf.bas.crm.model.BCrmEntInfo;
import com.huateng.scf.bas.crm.service.IBCrmEntInfoService;
import com.huateng.scf.bas.sys.dao.IBSysRegionDAO;
import com.huateng.scf.bas.sys.dao.model.BSysRegion;
import com.huateng.scf.bas.sys.dao.model.BSysRegionExample;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月21日上午11:07:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年11月21日上午11:07:04	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCrmEntInfoServiceImpl")
public class BCrmEntInfoServiceImpl implements IBCrmEntInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BSysRegionDAO")
	IBSysRegionDAO iBSysRegionDAO;
	@Resource(name = "IBCrmEntInfoDAO")
	IBCrmEntInfoDAO iBCrmEntInfoDAO;
	// 用于国际行业代码名称的转译。
	@Resource(name = "BBrpIndustryTypesDAO")
	IBBrpIndustryTypesDAO iBBrpIndustryTypesDAO;

	// 公司信息新增(无公共字段，将页面传过来的数据直接保存。前台可能有复选框，需要去掉。)
	@Override
	@Transactional
	public String add(BCrmEntInfo bCrmEntInfo) {
		com.huateng.scf.bas.crm.dao.model.BCrmEntInfo bCrmEntInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmEntInfo();
		BeanUtils.copyProperties(bCrmEntInfo, bCrmEntInfo2);
		if (bCrmEntInfo != null && !"".equals(bCrmEntInfo)) {
			if (bCrmEntInfo.getSupplyPosition() != null && !"".equals(bCrmEntInfo.getSupplyPosition())) {
				String supplyPosition = StringUtil.formatCheckBoxValue(bCrmEntInfo.getSupplyPosition());// 去掉复选框
				bCrmEntInfo2.setSupplyPosition(supplyPosition);
			}
			try {
				iBCrmEntInfoDAO.insert(bCrmEntInfo2);
				return null;
			} catch (Exception e) {
				log.error("公司信息新增失败！");
				throw new ScubeBizException("公司信息新增失败！", e);
			}
		} else {
			throw new ScubeBizException("企业信息新增，前台所传数据无效！");
		}

	}

	// 公司信息删除（只根据客户号）
	@Override
	@Transactional
	public int delete(String custcd) {
		BCrmEntInfoExample bbie = new BCrmEntInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmEntInfoExample.Criteria cri = bbie.createCriteria();
		if (custcd != null && custcd.length() > 0) {
			cri.andCustcdEqualTo(custcd);
		}
		try {
			return iBCrmEntInfoDAO.deleteByExample(bbie);
		} catch (Exception e) {
			log.error("公司信息删除失败！");
			throw new ScubeBizException("公司信息删除失败！", e);
		}
	}

	// 公司信息修改（根据客户号，无公共字段。前台可能有复选框，需要去掉。）
	@Override
	@Transactional
	public int update(BCrmEntInfo bCrmEntInfo) {
		com.huateng.scf.bas.crm.dao.model.BCrmEntInfo bCrmEntInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmEntInfo();
		BeanUtils.copyProperties(bCrmEntInfo, bCrmEntInfo2);
		if (bCrmEntInfo != null && !"".equals(bCrmEntInfo)) {
			if (bCrmEntInfo.getSupplyPosition() != null && !"".equals(bCrmEntInfo.getSupplyPosition())) {
				String supplyPosition = StringUtil.formatCheckBoxValue(bCrmEntInfo.getSupplyPosition());// 去掉复选框
				bCrmEntInfo2.setSupplyPosition(supplyPosition);
			}
			try {
				return iBCrmEntInfoDAO.updateByPrimaryKey(bCrmEntInfo2);
			} catch (Exception e) {
				log.error("公司信息修改失败！");
				throw new ScubeBizException("公司信息修改失败！", e);
			}
		} else {
			throw new ScubeBizException("公司信息修改，前台所传数据无效！");
		}
	}

	// 查询具体公司信息（根据客户号，转译国际行业代码和省份地区）
	@Override
	public BCrmEntInfo findBCrmEntInfoByKey(BCrmEntInfo bCrmEntInfo) {

		if (bCrmEntInfo == null || "".equals(bCrmEntInfo)) {
			return null;
		}

		if (bCrmEntInfo.getCustcd() == null || "".equals(bCrmEntInfo.getCustcd())) {
			return null;
		}

		try {
			com.huateng.scf.bas.crm.dao.model.BCrmEntInfo entInfo = iBCrmEntInfoDAO
					.selectByPrimaryKey(bCrmEntInfo.getCustcd());
			if (entInfo != null && !"".equals(entInfo)) {
				// 转译国际行业
				if (entInfo.getIndustryType() != null && !"".equals(entInfo.getIndustryType())) {
					BBrpIndustryTypes brpIndustryTypes = iBBrpIndustryTypesDAO
							.selectByPrimaryKey(entInfo.getIndustryType());
					entInfo.setIndustryTypeName(brpIndustryTypes.getIndustryName());

				}
				// 转译地区 iBSysRegionDAO
				if (entInfo.getProvince() != null && !"".equals(entInfo.getProvince())) {
					BSysRegionExample regionExample = new BSysRegionExample();
					regionExample.createCriteria().andRegionCodeEqualTo(entInfo.getProvince());
					List<BSysRegion> list = iBSysRegionDAO.selectByExample(regionExample);
					if (list != null && list.size() == 1) {
						entInfo.setProvinceName(list.get(0).getRegionName());
					}
				}
				if (entInfo.getCity() != null && !"".equals(entInfo.getCity())) {
					BSysRegionExample regionExample = new BSysRegionExample();
					regionExample.createCriteria().andRegionCodeEqualTo(entInfo.getCity());
					List<BSysRegion> list = iBSysRegionDAO.selectByExample(regionExample);
					if (list != null && list.size() == 1) {
						entInfo.setCityName(list.get(0).getRegionName());
					}
				}
				if (entInfo.getArea() != null && !"".equals(entInfo.getArea())) {
					BSysRegionExample regionExample = new BSysRegionExample();
					regionExample.createCriteria().andRegionCodeEqualTo(entInfo.getArea());
					List<BSysRegion> list = iBSysRegionDAO.selectByExample(regionExample);
					if (list != null && list.size() == 1) {
						entInfo.setAreaName(list.get(0).getRegionName());
					}
				}
				BCrmEntInfo bCrmEntInfo2 = new BCrmEntInfo();
				BeanUtils.copyProperties(entInfo, bCrmEntInfo2);
				return bCrmEntInfo2;
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ScubeBizException("条件查询公司信息失败!");
		}

	}

	// 条件查询公司信息表集合（根据客户号）
	@Override
	public List<BCrmEntInfo> findBCrmEntInfoByBCrm(BCrmEntInfo bCrmEntInfo) {
		BCrmEntInfoExample example = new BCrmEntInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmEntInfoExample.Criteria cri = example.createCriteria();
		if (bCrmEntInfo != null) {
			// 根据客户号查询
			if (bCrmEntInfo.getCustcd() != null && !"".equals(bCrmEntInfo.getCustcd())) {
				cri.andCustcdEqualTo(bCrmEntInfo.getCustcd());
			}
		}
		try {
			List<com.huateng.scf.bas.crm.dao.model.BCrmEntInfo> EntList = iBCrmEntInfoDAO.selectByExample(example);
			List<BCrmEntInfo> EntInfolist = new ArrayList<BCrmEntInfo>();
			if (EntList != null && EntList.size() > 0) {
				for (com.huateng.scf.bas.crm.dao.model.BCrmEntInfo bCrmEntInfo1 : EntList) {
					BCrmEntInfo bCrmEntInfo2 = new BCrmEntInfo();
					BeanUtils.copyProperties(bCrmEntInfo1, bCrmEntInfo2);
					EntInfolist.add(bCrmEntInfo2);
				}
			}
			return EntInfolist;
		} catch (Exception e) {
			throw new ScubeBizException("条件查询公司信息集合失败！");
		}
	}

	// 分页条件查询公司信息（根据客户号）
	@Override
	public Page findBCrmEntInfoByPage(int pageNo, int pageSize, BCrmEntInfo bCrmEntInfo) {
		Page p = new Page(pageSize, pageNo, 0);
		BCrmEntInfoExample example = new BCrmEntInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmEntInfoExample.Criteria criteria = example.createCriteria();
		if (bCrmEntInfo != null) {
			// 根据客户号
			if (bCrmEntInfo.getCustcd() != null && !"".equals(bCrmEntInfo.getCustcd())) {
				criteria.andCustcdEqualTo(bCrmEntInfo.getCustcd());
			}
		}
		try {
			p.setRecords(iBCrmEntInfoDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("公司信息条件分页查询失败！");
			throw new ScubeBizException("公司信息条件分页查询失败！", e);
		}
	}

}
