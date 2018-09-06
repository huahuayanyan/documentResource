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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.data.util.BDDataUtil;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crm.dao.IBCrmMoniEvaInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfoExample;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmMoniEvaInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crm.service.IBCrmMoniEvaInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月11日下午1:39:20
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年11月11日下午1:39:20	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("IBCrmMoniEvaInfoServiceImpl")
public class BCrmMoniEvaInfoServiceImpl implements IBCrmMoniEvaInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrmMoniEvaInfoDAO")
	IBCrmMoniEvaInfoDAO iBCrmMoniEvaInfoDAO;
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService iBCrmBaseInfoService;
	// 缓存@Autowired private CacheService cacheService;

	@Autowired
	BDDataUtil bDDataUtil;

	// 监管公司年审记录信息新增（将前台传过来的复选框去掉）
	@Override
	@Transactional
	public String add(BCrmMoniEvaInfo bCrmMoniEvaInfo) {
		// Tlrcd,LastUpdTlrcd,CrtTime,LastUpdTime,LastUpdBrcode.设置公共字段
		if (bCrmMoniEvaInfo != null && !"".equals(bCrmMoniEvaInfo)) {
			if (bCrmMoniEvaInfo.getMonitortype() != null && !"".equals(bCrmMoniEvaInfo.getMonitortype())) {
				String monitortype = StringUtil.formatCheckBoxValue(bCrmMoniEvaInfo.getMonitortype());// 去掉复选框
				bCrmMoniEvaInfo.setMonitortype(monitortype);
				ScfCommonUtil.setCommonField(bCrmMoniEvaInfo);
				com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo bCrmMoniEvaInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo();
				BeanUtils.copyProperties(bCrmMoniEvaInfo, bCrmMoniEvaInfo2);
				bCrmMoniEvaInfo2.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 设置经办机构信息
				bCrmMoniEvaInfo2.setId(UUIDGeneratorUtil.generate());
				try {
					iBCrmMoniEvaInfoDAO.insert(bCrmMoniEvaInfo2);
					return null;
				} catch (Exception e) {
					log.error("监管公司年审记录信息新增失败！");
					throw new ScubeBizException("监管公司年审记录信息新增失败！", e);
				}
			} else {
				throw new ScubeBizException("监管公司年审记录信息新增时，前台所传数据无监管模式字段！");
			}
		} else {
			throw new ScubeBizException("监管公司年审记录信息新增时，前台所传数据无效！");
		}
	}

	// 监管公司年审记录信息删除（根据ID）
	@Override
	@Transactional
	public int delete(String key) {
		try {
			return iBCrmMoniEvaInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			log.error("客户分析信息删除失败！");
			throw new ScubeBizException("客户分析信息删除失败！", e);
		}
	}

	// 监管公司年审记录信息修改(这里的更新操作，只能根据ID更新。因为一个客户号可以有多条记录。)
	@Override
	@Transactional
	public int update(BCrmMoniEvaInfo bCrmMoniEvaInfo) {
		com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo bCrmMoniEvaInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo();
		BeanUtils.copyProperties(bCrmMoniEvaInfo, bCrmMoniEvaInfo2);
		if (bCrmMoniEvaInfo2.getId() != null && bCrmMoniEvaInfo2.getId().length() > 0) {
			UserInfo user = ContextHolder.getUserInfo();
			String userId = user.getTlrNo();
			bCrmMoniEvaInfo2.setLastUpdTlrcd(userId); // 最后更新人
			bCrmMoniEvaInfo2.setLastUpdTime(new Date());// 最后更新时间
			BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
			String brcode = bctlVO.getBrNo();
			bCrmMoniEvaInfo2.setLastUpdBrcode(brcode);// 设置最后更新机构
			if (bCrmMoniEvaInfo.getMonitortype() != null && !"".equals(bCrmMoniEvaInfo.getMonitortype())) {
				String monitortype = StringUtil.formatCheckBoxValue(bCrmMoniEvaInfo.getMonitortype());// 去掉复选框
				bCrmMoniEvaInfo2.setMonitortype(monitortype);
			} else {
				throw new ScubeBizException("监管公司信息修改,所传监管模式字段为空！");
			}
			try {
				return iBCrmMoniEvaInfoDAO.updateByPrimaryKeySelective(bCrmMoniEvaInfo2);
			} catch (Exception e) {
				log.error("监管公司信息修改失败！");
				throw new ScubeBizException("监管公司信息修改失败！", e);
			}
		} else {// 没有ID无法修改
			throw new ScubeBizException("所传数据无ID，监管公司信息修改失败！");
		}
	}

	// 查询监管公司年审记录信息，返回单个对象。无条件查询，返回空值。(要将监管模式转成数组形式)
	@Override
	public BCrmMoniEvaInfo findBCrmMoniEvaInfoByKey(BCrmMoniEvaInfo bCrmMoniEvaInfo) {
		BCrmMoniEvaInfoExample bbie = new BCrmMoniEvaInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfoExample.Criteria criteria = bbie.createCriteria();
		if (bCrmMoniEvaInfo != null && !"".equals(bCrmMoniEvaInfo)) {
			// 根据客户号查询
			if (bCrmMoniEvaInfo.getCustcd() != null && !"".equals(bCrmMoniEvaInfo.getCustcd())) {
				criteria.andCustcdEqualTo(bCrmMoniEvaInfo.getCustcd());
			}
			// 根据等级到期日levelEndDate
			if (bCrmMoniEvaInfo.getLevelEndDate() != null && !"".equals(bCrmMoniEvaInfo.getLevelEndDate())) {
				criteria.andLevelEndDateEqualTo(bCrmMoniEvaInfo.getLevelEndDate());
			}
			try {
				BCrmMoniEvaInfo bCrmMoniEvaInfo2 = new BCrmMoniEvaInfo();
				List<com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo> bCrmMoniEvaInfos = iBCrmMoniEvaInfoDAO
						.selectByExample(bbie);
				if (bCrmMoniEvaInfos != null && bCrmMoniEvaInfos.size() == 1) {
					com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo bCrmMoniEvaInfo1 = bCrmMoniEvaInfos.get(0);
					BeanUtils.copyProperties(bCrmMoniEvaInfo1, bCrmMoniEvaInfo2);
					try {
						// 监管公司名称转译
						BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
						bCrmBaseInfo.setCustcd(bCrmMoniEvaInfo2.getCustcd());
						BCrmBaseInfo bCrmBaseInfo2 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
						bCrmMoniEvaInfo2.setCname(bCrmBaseInfo2.getCname());
						return bCrmMoniEvaInfo2;
					} catch (Exception e) {
						throw new ScubeBizException("条件查询监管公司年审记录信息,转译客户名称失败！");
					}

				} else {
					// 没有查询到对象
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("条件查询监管公司年审记录信息失败！");
			}
		} else {
			// 无条件查询，返回空值。
			return null;
		}
	}

	// 查询监管公司年审记录信息，返回对象集合。
	@Override
	public List<BCrmMoniEvaInfo> findBCrmMoniEvaInfoByBCrm(BCrmMoniEvaInfo bCrmMoniEvaInfo) {
		BCrmMoniEvaInfoExample example = new BCrmMoniEvaInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfoExample.Criteria cri = example.createCriteria();
		if (bCrmMoniEvaInfo != null) {
			// 根据客户号查询
			if (bCrmMoniEvaInfo.getCustcd() != null && !"".equals(bCrmMoniEvaInfo.getCustcd())) {
				cri.andCustcdEqualTo(bCrmMoniEvaInfo.getCustcd());
			}
		}
		try {
			List<com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo> moniEntList = iBCrmMoniEvaInfoDAO
					.selectByExample(example);
			List<BCrmMoniEvaInfo> moniEntInfolist = new ArrayList<BCrmMoniEvaInfo>();
			if (moniEntList != null && moniEntList.size() > 0) {
				for (com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo bCrmMoniEvaInfo1 : moniEntList) {
					BCrmMoniEvaInfo bCrmMoniEvaInfo2 = new BCrmMoniEvaInfo();
					BeanUtils.copyProperties(bCrmMoniEvaInfo1, bCrmMoniEvaInfo2);
					moniEntInfolist.add(bCrmMoniEvaInfo2);
				}
			}

			return moniEntInfolist;
		} catch (Exception e) {
			throw new ScubeBizException("条件查询监管公司年审记录信息集合失败！");
		}
	}

	// 查询监管公司年审记录信息，返回分页对象。（监管公司客户号，名称转译,如果前台给空值，则返回为空，客户号为空也返回空值）
	@Override
	public Page findBCrmMoniEvaInfoByPage(int pageNo, int pageSize, BCrmMoniEvaInfo bCrmMoniEvaInfo) {
		Page p = new Page(pageSize, pageNo, 0);
		if (bCrmMoniEvaInfo != null && !"".equals(bCrmMoniEvaInfo)) {
			if (bCrmMoniEvaInfo.getCustcd() != null && !"".equals(bCrmMoniEvaInfo.getCustcd())) {
				BCrmMoniEvaInfoExample example = new BCrmMoniEvaInfoExample();
				com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfoExample.Criteria criteria = example.createCriteria();
				// 根据客户号
				criteria.andCustcdEqualTo(bCrmMoniEvaInfo.getCustcd());
				try {
					List<com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo> selectByPage = iBCrmMoniEvaInfoDAO
							.selectByPage(example, p);
					if (selectByPage != null && selectByPage.size() > 0) {
						for (com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo bCrmMoniEvaInfo1 : selectByPage) {
							try {// 监管公司名称转译
								BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
								bCrmBaseInfo.setCustcd(bCrmMoniEvaInfo1.getCustcd());
								BCrmBaseInfo bCrmBaseInfo2 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
								bCrmMoniEvaInfo1.setCname(bCrmBaseInfo2.getCname());
							} catch (Exception e) {
								throw new ScubeBizException("条件查询监管公司年审记录信息,转译客户名称失败！");
							}
						}
					}
					p.setRecords(selectByPage);
					return p;
				} catch (Exception e) {
					log.error("监管公司年审记录信息条件分页查询失败！");
					throw new ScubeBizException("监管公司年审记录信息条件分页查询失败！", e);
				}
			} else {
				p.setRecords(new ArrayList<com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo>());
				return p;
			}
		} else {
			p.setRecords(new ArrayList<com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfo>());
			return p;
		}
	}
}
