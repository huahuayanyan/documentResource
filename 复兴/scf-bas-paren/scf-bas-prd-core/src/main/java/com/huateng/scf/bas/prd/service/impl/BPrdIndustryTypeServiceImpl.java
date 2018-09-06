/**
 * 
 */
package com.huateng.scf.bas.prd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.model.BBrpIndustryTypes;
import com.huateng.scf.bas.brp.service.IBBrpIndustryTypesService;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.prd.dao.IBPrdIndustryTypeDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdIndustryTypeExample;
import com.huateng.scf.bas.prd.dao.model.BPrdIndustryTypeExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdIndustryType;
import com.huateng.scf.bas.prd.service.IBPrdIndustryTypeService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 产品行业类别关联服务实现类
 * </p>
 * 
 * @author lihao
 * @date 2016年12月1日下午8:23:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月1日下午8:23:42	      新增
 * 
 * </pre>
 */
@ScubeService
@Service("BPrdIndustryTypeServiceImpl")
public class BPrdIndustryTypeServiceImpl implements IBPrdIndustryTypeService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdIndustryTypeDAO")
	IBPrdIndustryTypeDAO bPrdIndustryTypeDAO;

	@Resource(name = "BBrpIndustryTypesServiceImpl")
	IBBrpIndustryTypesService iBBrpIndustryTypesService;

	// 产品行业类别关联信息新增
	@Override
	@Transactional
	public String add(BPrdIndustryType bPrdIndustryType)
			throws ScubeBizException {
		com.huateng.scf.bas.prd.dao.model.BPrdIndustryType bPrdIndustryType2 = new com.huateng.scf.bas.prd.dao.model.BPrdIndustryType();
		try {
			BeanUtils.copyProperties(bPrdIndustryType, bPrdIndustryType2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		bPrdIndustryType2.setId(UUIDGeneratorUtil.generate());
		try {
			bPrdIndustryTypeDAO.insert(bPrdIndustryType2);
			return null;
		} catch (Exception e) {
			log.error("产品行业类别关联信息新增失败！");
			throw new ScubeBizException("产品行业类别关联信息新增失败！", e);
		}
	}

	// 产品行业类别关联信息删除
	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException {
		if (id != null && !"".equals(id)) {
			try {
				return bPrdIndustryTypeDAO.deleteByPrimaryKey(id);
			} catch (Exception e) {
				log.error("产品行业类别关联信息删除失败！");
				throw new ScubeBizException("产品行业类别关联信息删除失败！", e);
			}
		} else {
			throw new ScubeBizException("产品行业类别关联信息id无效，删除失败！");
		}
	}

	// 产品行业类别关联信息修改 （根据id）
	@Override
	@Transactional
	public int update(BPrdIndustryType bPrdIndustryType)
			throws ScubeBizException {

		com.huateng.scf.bas.prd.dao.model.BPrdIndustryType bPrdIndustryType2 = new com.huateng.scf.bas.prd.dao.model.BPrdIndustryType();
		try {
			BeanUtils.copyProperties(bPrdIndustryType, bPrdIndustryType2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		if (bPrdIndustryType.getId() != null
				&& bPrdIndustryType.getId().length() > 0) {
			try {
				return bPrdIndustryTypeDAO
						.updateByPrimaryKeySelective(bPrdIndustryType2);
			} catch (Exception e) {
				log.error("产品行业类别关联信息修改失败！");
				throw new ScubeBizException("产品行业类别关联信息修改失败！", e);
			}
		} else {
			throw new ScubeBizException("产品行业类别关联信息修改失败！");
		}

	}

	// 查找具体产品行业类别关联信息 （根据id,产品号，无条件查询，返回空值。）
	// 这里要将对应的行业类别和行业名称拼接好了之后再传给页面。
	@Override
	public BPrdIndustryType findBPrdIndustryTypeByKey(
			BPrdIndustryType bPrdIndustryType) throws ScubeBizException {
		BPrdIndustryTypeExample bbie = new BPrdIndustryTypeExample();
		Criteria cri = bbie.createCriteria();
		if (bPrdIndustryType != null) {

			if (bPrdIndustryType.getId() != null
					&& bPrdIndustryType.getId().length() > 0) {
				cri.andIdEqualTo(bPrdIndustryType.getId());
			}

			if (bPrdIndustryType.getProductId() != null
					&& bPrdIndustryType.getProductId().length() > 0) {
				cri.andProductIdEqualTo(bPrdIndustryType.getProductId());
			}

			try {
				BPrdIndustryType bPrdIndustryType2 = new BPrdIndustryType();
				List<com.huateng.scf.bas.prd.dao.model.BPrdIndustryType> bPrdIndustryTypes = bPrdIndustryTypeDAO
						.selectByExample(bbie);
				if (bPrdIndustryTypes != null && bPrdIndustryTypes.size() > 0) {
					com.huateng.scf.bas.prd.dao.model.BPrdIndustryType bPrdIndustryType1 = bPrdIndustryTypes
							.get(0);
					try {
						BeanUtils.copyProperties(bPrdIndustryType1,
								bPrdIndustryType2);
					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					String industryType = bPrdIndustryType2.getIndustryType();
					String[] split = industryType.split(",");
					String industryTypeName = new String();
					try {
						for (String aString : split) {// 取出来的是一个行业代码，要查询到对应的行业名称。
							BBrpIndustryTypes bBrpIndustryTypes = new BBrpIndustryTypes();
							bBrpIndustryTypes.setIndustryCode(aString);
							BBrpIndustryTypes bBrpIndustryType2 = iBBrpIndustryTypesService
									.findBBrpIndustryTypesByKey(bBrpIndustryTypes);
							industryTypeName = aString + "-"
									+ bBrpIndustryType2.getIndustryName() + ","
									+ industryTypeName;
						}
						industryTypeName.substring(0,
								(industryTypeName.length() - 1));
						bPrdIndustryType2.setIndustryTypeName(industryTypeName);
						return bPrdIndustryType2;
					} catch (Exception e) {
						log.error("产品行业关联信息中行业信息查询失败！");
						throw new ScubeBizException("产品行业关联信息中行业信息查询失败！", e);
					}
				} else {
					// 没有查询到对象
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("查找具体产品行业类别关联信息失败！");
			}
		} else {
			// 无条件查询，返回空值。
			return null;
		}
	}

	// 分页查询产品行业类别关联信息（根据id,产品号，费用代码，无条件查询，返回所有。）
	@Override
	public Page selectBPrdIndustryTypeByPage(int pageNo, int pageSize,
			BPrdIndustryType bPrdIndustryType) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		BPrdIndustryTypeExample example = new BPrdIndustryTypeExample();
		Criteria criteria = example.createCriteria();
		if (bPrdIndustryType != null && !"".equals(bPrdIndustryType)) {
			if (bPrdIndustryType.getId() != null
					&& bPrdIndustryType.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdIndustryType.getId());
			}

			if (bPrdIndustryType.getProductId() != null
					&& bPrdIndustryType.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdIndustryType.getProductId());
			}
		}
		try {
			p.setRecords(bPrdIndustryTypeDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("产品行业类别关联信息条件分页查询失败！");
			throw new ScubeBizException("产品行业类别关联信息条件分页查询失败！", e);
		}
	}

	/**
	 * 通过产品productId删除
	 * 
	 * @param productId
	 *            : 产品Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
	@Override
	@Transactional
	public int deleteByProductId(String productId) throws ScubeBizException {
		BPrdIndustryTypeExample example = new BPrdIndustryTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		try {
			return bPrdIndustryTypeDAO.deleteByExample(example);
		} catch (Exception e) {
			log.error("根据productId删除产品行业类别关联信息失败！");
			throw new ScubeBizException("根据productId删除产品行业类别关联信息失败！", e);
		}
	}

}
