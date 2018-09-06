/**
 * 
 */
package com.huateng.scf.bas.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmRelationInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmRelationInfoExample;
import com.huateng.scf.bas.crm.model.BCrmRelationInfo;
import com.huateng.scf.bas.crm.service.IBCrmRelationInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月14日下午7:42:10
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年11月14日下午7:42:10	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("IBCrmRelationInfoServiceImpl")
public class BCrmRelationInfoServiceImpl implements IBCrmRelationInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrmRelationInfoDAO")
	IBCrmRelationInfoDAO iBCrmRelationInfoDAO;
	// 缓存@Autowired private CacheService cacheService;
	// @Autowired BDDataUtil bDDataUtil;

	// 客户关联关系新增
	@Override
	@Transactional
	public String add(BCrmRelationInfo bCrmRelationInfo) {
		// Tlrcd,LastUpdTlrcd,CrtTime,LastUpdTime,LastUpdBrcode.设置公共字段
		ScfCommonUtil.setCommonField(bCrmRelationInfo);
		com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo bCrmRelationInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo();
		BeanUtils.copyProperties(bCrmRelationInfo, bCrmRelationInfo2);
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bCrmRelationInfo2.setBrcode(brcode);// 设置经办机构信息
		bCrmRelationInfo2.setId(UUIDGeneratorUtil.generate());
		try {
			iBCrmRelationInfoDAO.insert(bCrmRelationInfo2);
			return null;
		} catch (Exception e) {
			log.error("客户关联关系新增失败！");
			throw new ScubeBizException("客户关联关系新增失败！", e);
		}
	}

	// 客户关联关系删除(根据ID)
	@Override
	@Transactional
	public int delete(String key) {
		try {
			int del = iBCrmRelationInfoDAO.deleteByPrimaryKey(key);
			return del;
		} catch (Exception e) {
			log.error("客户关联关系删除失败！");
			throw new ScubeBizException("客户关联关系删除失败！", e);
		}
	}

	// 客户关联关系修改(根据ID来更新)
	@Override
	@Transactional
	public int update(BCrmRelationInfo bCrmRelationInfo) {
		com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo bCrmRelationInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo();
		BeanUtils.copyProperties(bCrmRelationInfo, bCrmRelationInfo2);
		if (bCrmRelationInfo.getId() != null && bCrmRelationInfo.getId().length() > 0) {
			String userId = ContextHolder.getUserId();
			bCrmRelationInfo2.setLastUpdTlrcd(userId); // 最后更新人
			bCrmRelationInfo2.setLastUpdTime(new Date());// 最后更新时间
			BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
			String brcode = bctlVO.getBrNo();
			bCrmRelationInfo2.setLastUpdBrcode(brcode);// 设置最后更新机构
			try {
				return iBCrmRelationInfoDAO.updateByPrimaryKeySelective(bCrmRelationInfo2);
			} catch (Exception e) {
				log.error("客户关联关系修改失败！");
				throw new ScubeBizException("客户关联关系修改失败！", e);
			}
		} else {// 没有ID无法修改
			throw new ScubeBizException("客户关联关系修改失败！");
		}
	}

	// 查询客户关联关系，返回单个对象。（无条件查询，返回空值。）
	// 这里要注意，当页面修改操作的时候，会将页面数据到数据库进行查询，此时，里面不能有ID，否则无法实现去重。
	// 因为当页面传过来ID，数据库里面是不可能存在相同的ID的数据的。
	@Override
	public BCrmRelationInfo findBCrmRelationInfoByKey(BCrmRelationInfo bCrmRelationInfo) {
		BCrmRelationInfoExample bbie = new BCrmRelationInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmRelationInfoExample.Criteria cri = bbie.createCriteria();
		if (bCrmRelationInfo != null && !"".equals(bCrmRelationInfo)) {
			// 根据ID查询
			if (bCrmRelationInfo.getId() != null && !"".equals(bCrmRelationInfo.getId())) {
				cri.andIdEqualTo(bCrmRelationInfo.getId());
			}
			// 核心厂商客户号
			if (bCrmRelationInfo.getCoreCustcd() != null && !"".equals(bCrmRelationInfo.getCoreCustcd())) {
				cri.andCoreCustcdEqualTo(bCrmRelationInfo.getCoreCustcd());
			}
			// 添加买方客户号
			if (bCrmRelationInfo.getBuyerCustcd() != null && !"".equals(bCrmRelationInfo.getBuyerCustcd())) {
				cri.andBuyerCustcdEqualTo(bCrmRelationInfo.getBuyerCustcd());
			}
			// 添加卖方客户号
			if (bCrmRelationInfo.getSellerCustcd() != null && !"".equals(bCrmRelationInfo.getSellerCustcd())) {
				cri.andSellerCustcdEqualTo(bCrmRelationInfo.getSellerCustcd());
			}
			// 添加监管公司客户号moniCustcd
			if (bCrmRelationInfo.getMoniCustcd() != null && !"".equals(bCrmRelationInfo.getMoniCustcd())) {
				cri.andMoniCustcdEqualTo(bCrmRelationInfo.getMoniCustcd());
			}
			// 添加客户关联类型relaType
			if (bCrmRelationInfo.getRelaType() != null && !"".equals(bCrmRelationInfo.getRelaType())) {
				cri.andRelaTypeEqualTo(bCrmRelationInfo.getRelaType());
			}
			try {
				BCrmRelationInfo bCrmRelationInfo2 = new BCrmRelationInfo();
				List<com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo> bCrmRelationInfos = iBCrmRelationInfoDAO
						.selectByExample(bbie);
				if (bCrmRelationInfos != null && bCrmRelationInfos.size() > 0) {
					com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo bCrmRelationInfo1 = bCrmRelationInfos.get(0);
					BeanUtils.copyProperties(bCrmRelationInfo1, bCrmRelationInfo2);
					return bCrmRelationInfo2;
				} else {// 没有查询到对象
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("条件查询客户关联关系对象失败！");
			}
		} else {// 无条件查询，返回空值。
			return null;
		}
	}

	// 查询客户关联关系，返回对象集合。(暂时用不到)
	@Override
	public List<BCrmRelationInfo> findBCrmRelationInfoByBCrm(BCrmRelationInfo bCrmRelationInfo) {
		BCrmRelationInfoExample example = new BCrmRelationInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmRelationInfoExample.Criteria cri = example.createCriteria();
		if (bCrmRelationInfo != null) {
			// 根据ID查询
			if (bCrmRelationInfo.getId() != null && !"".equals(bCrmRelationInfo.getId())) {
				cri.andIdEqualTo(bCrmRelationInfo.getId());
			}
			// 核心厂商客户号
			if (bCrmRelationInfo.getCoreCustcd() != null && !"".equals(bCrmRelationInfo.getCoreCustcd())) {
				cri.andCoreCustcdEqualTo(bCrmRelationInfo.getCoreCustcd());
			}
			// 添加买方客户号
			if (bCrmRelationInfo.getBuyerCustcd() != null && !"".equals(bCrmRelationInfo.getBuyerCustcd())) {
				cri.andBuyerCustcdEqualTo(bCrmRelationInfo.getBuyerCustcd());
			}
			// 添加卖方客户号
			if (bCrmRelationInfo.getSellerCustcd() != null && !"".equals(bCrmRelationInfo.getSellerCustcd())) {
				cri.andSellerCustcdEqualTo(bCrmRelationInfo.getSellerCustcd());
			}
			// 添加监管公司客户号moniCustcd
			if (bCrmRelationInfo.getMoniCustcd() != null && !"".equals(bCrmRelationInfo.getMoniCustcd())) {
				cri.andMoniCustcdEqualTo(bCrmRelationInfo.getMoniCustcd());
			}
			// 添加客户关联类型relaType
			if (bCrmRelationInfo.getRelaType() != null && !"".equals(bCrmRelationInfo.getRelaType())) {
				cri.andRelaTypeEqualTo(bCrmRelationInfo.getRelaType());
			}

		}
		try {
			List<com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo> iBCrmRelationInfoList = iBCrmRelationInfoDAO
					.selectByExample(example);
			List<BCrmRelationInfo> bCrmRelationInfolist = new ArrayList<BCrmRelationInfo>();
			if (iBCrmRelationInfoList != null && iBCrmRelationInfoList.size() > 0) {
				for (com.huateng.scf.bas.crm.dao.model.BCrmRelationInfo bCrmRelationInfo1 : iBCrmRelationInfoList) {
					BCrmRelationInfo bCrmRelationInfo2 = new BCrmRelationInfo();
					BeanUtils.copyProperties(bCrmRelationInfo1, bCrmRelationInfo2);
					bCrmRelationInfolist.add(bCrmRelationInfo2);
				}
			}
			return bCrmRelationInfolist;
		} catch (Exception e) {
			throw new ScubeBizException("查询客户关联关系对象集合失败！");
		}
	}

	// 查询客户关联关系，返回分页对象。（不按照ID来查询）
	@Override
	public Page findBCrmRelationInfoByPage(int pageNo, int pageSize, BCrmRelationInfo bCrmRelationInfo) {
		int total = iBCrmRelationInfoDAO.countByExample(new BCrmRelationInfoExample());
		Page p = new Page(pageSize, pageNo, total);
		BCrmRelationInfoExample example = new BCrmRelationInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmRelationInfoExample.Criteria cri = example.createCriteria();
		if (bCrmRelationInfo != null) {
			// 核心厂商客户号
			if (bCrmRelationInfo.getCoreCustcd() != null && !"".equals(bCrmRelationInfo.getCoreCustcd())) {
				cri.andCoreCustcdEqualTo(bCrmRelationInfo.getCoreCustcd());
			}
			// 添加买方客户号
			if (bCrmRelationInfo.getBuyerCustcd() != null && !"".equals(bCrmRelationInfo.getBuyerCustcd())) {
				cri.andBuyerCustcdEqualTo(bCrmRelationInfo.getBuyerCustcd());
			}
			// 添加卖方客户号
			if (bCrmRelationInfo.getSellerCustcd() != null && !"".equals(bCrmRelationInfo.getSellerCustcd())) {
				cri.andSellerCustcdEqualTo(bCrmRelationInfo.getSellerCustcd());
			}
			// 添加监管公司客户号moniCustcd
			if (bCrmRelationInfo.getMoniCustcd() != null && !"".equals(bCrmRelationInfo.getMoniCustcd())) {
				cri.andMoniCustcdEqualTo(bCrmRelationInfo.getMoniCustcd());
			}
		}
		try {
			p.setRecords(iBCrmRelationInfoDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("客户关联关系条件分页查询失败！");
			throw new ScubeBizException("客户关联关系条件分页查询失败！", e);
		}
	}

}
