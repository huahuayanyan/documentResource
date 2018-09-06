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
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.dao.IBCrmMoniEntInfoDAO;
import com.huateng.scf.bas.crm.dao.IBCrmMoniEvaInfoDAO;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfoExample;
import com.huateng.scf.bas.crm.dao.model.BCrmMoniEvaInfoExample;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.model.BCrmMoniEntInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.crm.service.IBCrmMoniEntInfoService;
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
@Service("IBCrmMoniEntInfoServiceImpl")
public class BCrmMoniEntInfoServiceImpl implements IBCrmMoniEntInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "IBCrmMoniEntInfoDAO")
	IBCrmMoniEntInfoDAO iBCrmMoniEntInfoDAO;
	@Resource(name = "IBCrmMoniEvaInfoDAO")
	IBCrmMoniEvaInfoDAO iBCrmMoniEvaInfoDAO;

	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService iBCrmBaseInfoService;
	// 缓存@Autowired private CacheService cacheService;

	@Autowired
	BDDataUtil bDDataUtil;

	// 监管公司信息新增(将页面的复选框加的[]去掉)
	@Override
	@Transactional
	public String add(BCrmMoniEntInfo bCrmMoniEntInfo) {
		if (bCrmMoniEntInfo != null && !"".equals(bCrmMoniEntInfo)) {
			if (bCrmMoniEntInfo.getMonitortype() != null && !"".equals(bCrmMoniEntInfo.getMonitortype())) {
				String monitortype = StringUtil.formatCheckBoxValue(bCrmMoniEntInfo.getMonitortype());// 去掉复选框
				bCrmMoniEntInfo.setMonitortype(monitortype);
				// 设置公共字段,创建人tlrcd,crtTime创建时间,lastUpdTlrcd最后更新操作员,lastUpdTime最后更新时间，lastUpdBrcode最后更新机构
				ScfCommonUtil.setCommonField(bCrmMoniEntInfo);
				com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo bCrmMoniEntInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo();
				BeanUtils.copyProperties(bCrmMoniEntInfo, bCrmMoniEntInfo2);
				BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
				String brcode = bctlVO.getBrNo();
				bCrmMoniEntInfo2.setBrcode(brcode);// 设置经办机构信息
				// createDate建档日期
				bCrmMoniEntInfo2.setCreateDate(ScfDateUtil.formatDate(new Date()));
				try {
					iBCrmMoniEntInfoDAO.insert(bCrmMoniEntInfo2);
					return null;
				} catch (Exception e) {
					log.error("监管公司信息新增失败！");
					throw new ScubeBizException("监管公司信息新增失败！", e);
				}
			} else {
				throw new ScubeBizException("监管公司信息新增时，前台所传数据无监管模式字段！");
			}
		} else {
			throw new ScubeBizException("监管公司信息新增时，前台所传数据无效！");
		}

	}

	// 监管公司信息删除（根据客户号）
	@Override
	@Transactional
	public int delete(String key) {
		BCrmMoniEntInfoExample bbie = new BCrmMoniEntInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfoExample.Criteria cri = bbie.createCriteria();
		if (key != null && key.length() > 0) {
			cri.andCustcdEqualTo(key);
		}
		try {
			return iBCrmMoniEntInfoDAO.deleteByExample(bbie);
		} catch (Exception e) {
			log.error("监管公司信息删除失败！");
			throw new ScubeBizException("监管公司信息删除失败！", e);
		}
	}

	// 根据客户号删除对应监管公司和监管公司年审记录信息
	@Override
	@Transactional
	public int deleteMoniRelatedByCustcd(String custcd) {
		BCrmMoniEntInfoExample bbie = new BCrmMoniEntInfoExample();
		bbie.createCriteria().andCustcdEqualTo(custcd);
		BCrmMoniEvaInfoExample bCrmMoniEvaInfoExample = new BCrmMoniEvaInfoExample();
		bCrmMoniEvaInfoExample.createCriteria().andCustcdEqualTo(custcd);
		try {
			iBCrmMoniEvaInfoDAO.deleteByExample(bCrmMoniEvaInfoExample);
			return iBCrmMoniEntInfoDAO.deleteByExample(bbie);
		} catch (Exception e) {
			log.error("监管公司信息删除失败！" + e.getMessage());
			throw new ScubeBizException("监管公司相关信息删除失败！", e);
		}
	}

	// 监管公司信息修改（因为这里页面上一个客户号只能显示一条信息，所以这里的修改必须通过客户号.）
	@Override
	@Transactional
	public int update(BCrmMoniEntInfo bCrmMoniEntInfo) {
		com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo bCrmMoniEntInfo2 = new com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo();
		BeanUtils.copyProperties(bCrmMoniEntInfo, bCrmMoniEntInfo2);
		BCrmMoniEntInfoExample bbie = new BCrmMoniEntInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfoExample.Criteria cri = bbie.createCriteria();
		if (bCrmMoniEntInfo.getCustcd() != null && bCrmMoniEntInfo.getCustcd().length() > 0) {
			cri.andCustcdEqualTo(bCrmMoniEntInfo.getCustcd());
		}
		// lastUpdTlrcd最后更新操作员,lastUpdTime最后更新时间，lastUpdBrcode最后更新机构
		UserInfo user = ContextHolder.getUserInfo();
		String userId = user.getTlrNo();
		bCrmMoniEntInfo2.setLastUpdTlrcd(userId); // 最后更新人
		bCrmMoniEntInfo2.setLastUpdTime(new Date());// 最后更新时间
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bCrmMoniEntInfo2.setLastUpdBrcode(brcode);// 设置最后更新机构
		if (bCrmMoniEntInfo2.getMonitortype() != null && !"".equals(bCrmMoniEntInfo2.getMonitortype())) {
			String monitortype = StringUtil.formatCheckBoxValue(bCrmMoniEntInfo2.getMonitortype());// 去掉复选框
			bCrmMoniEntInfo2.setMonitortype(monitortype);
		} else {
			throw new ScubeBizException("监管公司年审记录信息修改,所传监管模式字段为空！");
		}
		try {
			return iBCrmMoniEntInfoDAO.updateByExampleSelective(bCrmMoniEntInfo2, bbie);
		} catch (Exception e) {
			log.error("监管公司信息修改失败！");
			throw new ScubeBizException("监管公司信息修改失败！", e);
		}
	}

	// 查询监管公司信息，返回单个对象。没有给对象的时候，返回空值。
	@Override
	public BCrmMoniEntInfo findBCrmMoniEntInfoByKey(BCrmMoniEntInfo bCrmMoniEntInfo) {
		BCrmMoniEntInfoExample bbie = new BCrmMoniEntInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfoExample.Criteria criteria = bbie.createCriteria();
		if (bCrmMoniEntInfo != null && !"".equals(bCrmMoniEntInfo)) {
			if (bCrmMoniEntInfo.getCustcd() != null && !"".equals(bCrmMoniEntInfo.getCustcd())) {
				criteria.andCustcdEqualTo(bCrmMoniEntInfo.getCustcd());
				try {
					BCrmMoniEntInfo bCrmMoniEntInfo2 = new BCrmMoniEntInfo();
					List<com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo> bCrmMoniEntInfos = iBCrmMoniEntInfoDAO.selectByExample(bbie);
					if (bCrmMoniEntInfos != null && bCrmMoniEntInfos.size() > 0) {
						com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo bCrmMoniEntInfo1 = bCrmMoniEntInfos.get(0);
						BeanUtils.copyProperties(bCrmMoniEntInfo1, bCrmMoniEntInfo2);
						if (bCrmMoniEntInfo2.getParentId() != null && !"".equals(bCrmMoniEntInfo2.getParentId())) {
							try {
								// 上级监管公司转译
								BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
								bCrmBaseInfo.setCustcd(bCrmMoniEntInfo2.getParentId());
								BCrmBaseInfo bCrmBaseInfo2 = iBCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
								if (bCrmBaseInfo2 != null) {// 会有对应的上级监管公司已经被删除，之前存的数据已经无效的情况。
									bCrmMoniEntInfo2.setParentName(bCrmBaseInfo2.getCname());
								}
								return bCrmMoniEntInfo2;
							} catch (Exception e) {
								throw new ScubeBizException("条件查询监管公司详细信息,转译上级监管公司失败！");
							}
						} else {
							return bCrmMoniEntInfo2;
						}
					} else {
						// 没有查询到对象
						return null;
					}
				} catch (Exception e) {
					throw new ScubeBizException("条件查询监管公司详细信息失败！");
				}
			} else {
				return null;
			}
		} else {
			// 无条件查询，返回空值。
			return null;
		}
	}

	// 查询监管公司信息，返回对象集合。
	@Override
	public List<BCrmMoniEntInfo> findBCrmMoniEntInfoByBCrm(BCrmMoniEntInfo bCrmMoniEntInfo) {
		BCrmMoniEntInfoExample example = new BCrmMoniEntInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfoExample.Criteria cri = example.createCriteria();
		if (bCrmMoniEntInfo != null) {
			// 根据客户号查询
			if (bCrmMoniEntInfo.getCustcd() != null && !"".equals(bCrmMoniEntInfo.getCustcd())) {
				cri.andCustcdEqualTo(bCrmMoniEntInfo.getCustcd());
			}
		}
		try {
			List<com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo> moniEntList = iBCrmMoniEntInfoDAO.selectByExample(example);
			List<BCrmMoniEntInfo> moniEntInfolist = new ArrayList<BCrmMoniEntInfo>();
			if (moniEntList != null && moniEntList.size() > 0) {
				for (com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfo bCrmMoniEntInfo1 : moniEntList) {
					BCrmMoniEntInfo bCrmMoniEntInfo2 = new BCrmMoniEntInfo();
					BeanUtils.copyProperties(bCrmMoniEntInfo1, bCrmMoniEntInfo2);
					moniEntInfolist.add(bCrmMoniEntInfo2);
				}
			}
			return moniEntInfolist;
		} catch (Exception e) {
			throw new ScubeBizException("条件查询监管公司详细信息集合失败！");
		}
	}

	// 查询监管公司信息，返回分页对象。
	@Override
	public Page findBCrmMoniEntInfoByPage(int pageNo, int pageSize, BCrmMoniEntInfo bCrmMoniEntInfo) {
		Page p = new Page(pageSize, pageNo, 0);
		BCrmMoniEntInfoExample example = new BCrmMoniEntInfoExample();
		com.huateng.scf.bas.crm.dao.model.BCrmMoniEntInfoExample.Criteria criteria = example.createCriteria();
		if (bCrmMoniEntInfo != null) {
			// 根据客户号
			if (bCrmMoniEntInfo.getCustcd() != null && !"".equals(bCrmMoniEntInfo.getCustcd())) {
				criteria.andCustcdEqualTo(bCrmMoniEntInfo.getCustcd());
			}
		}
		try {
			p.setRecords(iBCrmMoniEntInfoDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("监管公司信息条件分页查询失败！");
			throw new ScubeBizException("监管公司信息条件分页查询失败！", e);
		}
	}

}
