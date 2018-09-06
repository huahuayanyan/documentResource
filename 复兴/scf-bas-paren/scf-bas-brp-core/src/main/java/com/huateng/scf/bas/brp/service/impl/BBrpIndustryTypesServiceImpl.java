/**
 * 
 */
package com.huateng.scf.bas.brp.service.impl;

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
import com.huateng.authority.entity.UserInfo;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpIndustryTypesDAO;
import com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypesExample;
import com.huateng.scf.bas.brp.model.BBrpIndustryTypes;
import com.huateng.scf.bas.brp.model.TreeModel;
import com.huateng.scf.bas.brp.service.IBBrpIndustryTypesService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月21日下午5:23:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年11月21日下午5:23:43	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BBrpIndustryTypesServiceImpl")
public class BBrpIndustryTypesServiceImpl implements IBBrpIndustryTypesService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BBrpIndustryTypesDAO")
	IBBrpIndustryTypesDAO iBBrpIndustryTypesDAO;

	// 新增国标行业类型信息
	@Override
	@Transactional
	public String add(BBrpIndustryTypes bBrpIndustryTypes) {
		com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes bBrpIndustryTypes2 = new com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes();
		try {
			BeanUtils.copyProperties(bBrpIndustryTypes, bBrpIndustryTypes2);
		} catch (Exception e) {
			throw new ScubeBizException("转换异常！");
		}
		// 获取当前用户
		UserInfo user = ContextHolder.getUserInfo();
		String userId = user.getTlrNo();
		bBrpIndustryTypes2.setLastUpdTlr(userId);// 最后更新人
		bBrpIndustryTypes2.setLastUpdDate(new Date());// 最后更新时间
		BctlVO BctlVO = ContextHolder.getOrgInfo();
		String brcode = BctlVO.getBrNo();
		bBrpIndustryTypes2.setLastUpdBrcode(brcode);// 最后更新机构
		bBrpIndustryTypes2.setTimestamps(new Date());
		try {
			iBBrpIndustryTypesDAO.insert(bBrpIndustryTypes2);
			return null;
		} catch (Exception e) {
			log.error("国标行业类型信息新增失败！");
			throw new ScubeBizException("国标行业类型信息新增失败！", e);
		}
	}

	// 删除国标行业类型信息（根据行业代码）
	@Override
	@Transactional
	public int delete(String industryCode) {
		BBrpIndustryTypesExample bbie = new BBrpIndustryTypesExample();
		com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypesExample.Criteria cri = bbie.createCriteria();
		if (industryCode != null && industryCode.length() > 0) {
			cri.andIndustryCodeEqualTo(industryCode);
		}
		try {
			return iBBrpIndustryTypesDAO.deleteByExample(bbie);
		} catch (Exception e) {
			log.error("国标行业类型信息删除失败！");
			throw new ScubeBizException("国标行业类型信息删除失败！", e);
		}
	}

	// 修改国标行业类型信息（根据行业代码）
	@Override
	@Transactional
	public int update(BBrpIndustryTypes bBrpIndustryTypes) {
		com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes bBrpIndustryTypes2 = new com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes();
		try {
			BeanUtils.copyProperties(bBrpIndustryTypes, bBrpIndustryTypes2);
		} catch (Exception e) {
			throw new ScubeBizException("转换异常！");
		}
		BBrpIndustryTypesExample bbie = new BBrpIndustryTypesExample();
		com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypesExample.Criteria cri = bbie.createCriteria();
		if (bBrpIndustryTypes2 != null && !"".equals(bBrpIndustryTypes2)) {
			if (bBrpIndustryTypes.getIndustryCode() != null && bBrpIndustryTypes.getIndustryCode().length() > 0) {
				cri.andIndustryCodeEqualTo(bBrpIndustryTypes.getIndustryCode());
			}
			UserInfo user = ContextHolder.getUserInfo();// 获取当前用户
			String userId = user.getTlrNo();
			bBrpIndustryTypes2.setLastUpdTlr(userId);// 最后更新人
			bBrpIndustryTypes2.setLastUpdDate(new Date());// 最后更新时间
			BctlVO BctlVO = ContextHolder.getOrgInfo();
			String brcode = BctlVO.getBrNo();
			bBrpIndustryTypes2.setLastUpdBrcode(brcode);// 最后更新机构
			try {
				return iBBrpIndustryTypesDAO.updateByExampleSelective(bBrpIndustryTypes2, bbie);
			} catch (Exception e) {
				log.error("国标行业类型信息修改失败！");
				throw new ScubeBizException("国标行业类型信息修改失败！", e);
			}
		} else {// 传过来数据是空值
			throw new ScubeBizException("国标行业类型信息为空！");
		}

	}

	// 查询国标行业类型信息(根据行业号)
	@Override
	public BBrpIndustryTypes findBBrpIndustryTypesByKey(BBrpIndustryTypes bBrpIndustryTypes) {

		BBrpIndustryTypesExample bbie = new BBrpIndustryTypesExample();
		if (bBrpIndustryTypes != null && !"".equals(bBrpIndustryTypes)) {
			if (bBrpIndustryTypes.getIndustryCode() != null && !"".equals(bBrpIndustryTypes.getIndustryCode())) {
				bbie.createCriteria().andIndustryCodeEqualTo(bBrpIndustryTypes.getIndustryCode());
			}
			try {
				List<com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes> bBrpIndustryTypeslists = iBBrpIndustryTypesDAO
						.selectByExample(bbie);
				if (bBrpIndustryTypeslists != null && bBrpIndustryTypeslists.size() == 1) {
					com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes industryTypes1 = bBrpIndustryTypeslists.get(0);
					BBrpIndustryTypes bBrpIndustryTypes2 = new BBrpIndustryTypes();
					try {
						BeanUtils.copyProperties(industryTypes1, bBrpIndustryTypes2);
					} catch (Exception e) {
						throw new ScubeBizException("转换异常！");
					}
					return bBrpIndustryTypes2;
				} else {// 未查询到正确对象。
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("条件查询监管公司详细信息失败！");
			}
		} else {// 没有对象，返回空值。
			return null;
		}
	}

	// 查询国标行业类型信息（根据行业代码，行业名称，行业类别级别）
	// 这里的适用于给页面返回树形结构。
	@Override
	public Page findBBrpIndustryTypesTree(int pageNo, int pageSize, BBrpIndustryTypes bBrpIndustryTypes) {
		Page p = new Page(pageSize, pageNo, 0);
		int n = 0;
		BBrpIndustryTypesExample example = new BBrpIndustryTypesExample();
		com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypesExample.Criteria cri = example.createCriteria();
		if (bBrpIndustryTypes != null) {// 根据行业代码
			if (bBrpIndustryTypes.getIndustryCode() != null && !"".equals(bBrpIndustryTypes.getIndustryCode())) {
				cri.andIndustryCodeEqualTo(bBrpIndustryTypes.getIndustryCode());
			}
			// 行业名称
			if (bBrpIndustryTypes.getIndustryName() != null && !"".equals(bBrpIndustryTypes.getIndustryName())) {
				cri.andIndustryNameLike("%" + bBrpIndustryTypes.getIndustryName() + "%");
			}
			// 行业级别industryLevel
			if (bBrpIndustryTypes.getIndustryLevel() != null && !"".equals(bBrpIndustryTypes.getIndustryLevel())) {
				cri.andIndustryLevelEqualTo(bBrpIndustryTypes.getIndustryLevel());
			}
		}
		try {
			List<com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes> moniEntList = iBBrpIndustryTypesDAO
					.selectByExample(example);
			List<TreeModel> treeList = new ArrayList<TreeModel>();
			if (StringUtil.isEmpty(bBrpIndustryTypes.getIndustryName())) {
				for (com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes bBrpIndustryTypes1 : moniEntList) {
					TreeModel treeModel1 = new TreeModel();
					treeModel1.setTreeId(bBrpIndustryTypes1.getIndustryCode());
					treeModel1.setTreeLevel(bBrpIndustryTypes1.getIndustryLevel());
					treeModel1.setTreeName(bBrpIndustryTypes1.getIndustryName());
					treeModel1.setTreeParentId(bBrpIndustryTypes1.getIndustryUplevel());
					treeList.add(treeModel1);
					n = n + 1;
				}
			} else {
				List<String> industrycodes = new ArrayList<String>();
				for (com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes industrytype : moniEntList) {
					if (!industrycodes.contains(industrytype.getIndustryCode())) {
						industrycodes.add(industrytype.getIndustryCode());
					}
					String level = industrytype.getIndustryLevel();
					if (!level.equals("1") || level != "1") {
						List<String> newcodes = getIndeustrCodeList(industrytype, industrycodes);
						for (String code : newcodes) {
							if (!industrycodes.contains(code))
								industrycodes.add(code);
						}
					}
				}
				BBrpIndustryTypesExample example2 = new BBrpIndustryTypesExample();
				BBrpIndustryTypesExample.Criteria ccri = example2.createCriteria();
				// 如果查不到对应数据，就返回为空
				if (industrycodes.size() > 0) {
					ccri.andIndustryCodeIn(industrycodes);
					List<com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes> moniEntList2 = iBBrpIndustryTypesDAO
							.selectByExample(example2);
					for (com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes bBrpIndustryTypes1 : moniEntList2) {
						TreeModel treeModel1 = new TreeModel();
						treeModel1.setTreeId(bBrpIndustryTypes1.getIndustryCode());
						treeModel1.setTreeLevel(bBrpIndustryTypes1.getIndustryLevel());
						treeModel1.setTreeName(bBrpIndustryTypes1.getIndustryName());
						treeModel1.setTreeParentId(bBrpIndustryTypes1.getIndustryUplevel());
						treeList.add(treeModel1);
						n = n + 1;
					}
				}

			}
			p.setPageNo(pageNo);
			p.setPageSize(pageSize);
			p.setRecords(treeList);
			p.setTotalRecord(n);
			return p;
		} catch (Exception e) {
			throw new ScubeBizException("条件查询国标行业类型信息集合失败！");
		}
	}

	public List<String> getIndeustrCodeList(com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes industrytype,
			List<String> industrycodes) {
		String typelevel = industrytype.getIndustryLevel();
		if (typelevel.equals("1") || typelevel == "1") {
			return industrycodes;
		}
		BBrpIndustryTypesExample example = new BBrpIndustryTypesExample();
		BBrpIndustryTypesExample.Criteria ccri = example.createCriteria();
		ccri.andIndustryCodeEqualTo(industrytype.getIndustryUplevel());
		List<com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes> moniEntList = iBBrpIndustryTypesDAO
				.selectByExample(example);
		for (com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypes industry : moniEntList) {
			String level = industrytype.getIndustryLevel();
			if (!industrycodes.contains(industrytype.getIndustryUplevel())) {
				industrycodes.add(industrytype.getIndustryUplevel());
			}
			if (!"1".equals(level) || level != "1") {
				getIndeustrCodeList(industry, industrycodes);
			}
		}
		return industrycodes;
	}

	// 分页条件查询国标行业类型信息（根据行业代码，行业名称，行业类别级别，无条件查询,返回所有对象。）
	@Override
	public Page findBBrpIndustryTypesByPage(int pageNo, int pageSize, BBrpIndustryTypes bBrpIndustryTypes) {
		Page p = new Page(pageSize, pageNo, 0);
		BBrpIndustryTypesExample example = new BBrpIndustryTypesExample();
		com.huateng.scf.bas.brp.dao.model.BBrpIndustryTypesExample.Criteria cri = example.createCriteria();
		if (bBrpIndustryTypes != null && !"".equals(bBrpIndustryTypes)) {// 根据行业代码
			if (bBrpIndustryTypes.getIndustryCode() != null && !"".equals(bBrpIndustryTypes.getIndustryCode())) {
				cri.andIndustryCodeEqualTo(bBrpIndustryTypes.getIndustryCode());
			}
			// 行业名称
			if (bBrpIndustryTypes.getIndustryName() != null && !"".equals(bBrpIndustryTypes.getIndustryName())) {
				cri.andIndustryNameLike("%" + bBrpIndustryTypes.getIndustryName() + "%");
			}
			// 行业级别industryLevel
			if (bBrpIndustryTypes.getIndustryLevel() != null && !"".equals(bBrpIndustryTypes.getIndustryLevel())) {
				cri.andIndustryLevelEqualTo(bBrpIndustryTypes.getIndustryLevel());
			}
		}
		try {
			p.setRecords(iBBrpIndustryTypesDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("国标行业类型信息条件分页查询失败！");
			throw new ScubeBizException("国标行业类型信息条件分页查询失败！", e);
		}
	}

}
