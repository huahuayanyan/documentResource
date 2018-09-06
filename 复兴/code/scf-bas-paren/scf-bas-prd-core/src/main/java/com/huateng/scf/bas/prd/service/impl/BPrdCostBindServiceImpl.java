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
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.prd.dao.IBPrdCostBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCostBindExample;
import com.huateng.scf.bas.prd.dao.model.BPrdCostBindExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdCostBind;
import com.huateng.scf.bas.prd.service.IBPrdCostBindService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 产品费用绑定服务实现类
 * </p>
 *
 * @author lihao
 * @date 2016年12月1日下午4:50:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月1日下午4:50:48	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BPrdCostBindServiceImpl")
public class BPrdCostBindServiceImpl implements IBPrdCostBindService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdCostBindDAO")
	IBPrdCostBindDAO bPrdCostBindDAO;

	// 产品费用关联信息新增
	@Override
	@Transactional
	public String add(BPrdCostBind bPrdCostBind) throws ScubeBizException{
		if (bPrdCostBind != null && !"".equals(bPrdCostBind)) {
			if (bPrdCostBind.getProductId() != null && bPrdCostBind.getProductId().length() > 0) {
				// 需要查重，防止页面会新增相同费用代码的数据。
				if (bPrdCostBind.getCostCode() != null && bPrdCostBind.getCostCode().length() > 0) {
					BPrdCostBindExample bbie = new BPrdCostBindExample();
				    Criteria cri = bbie.createCriteria();
					// 当三者都一样的时候才报错。
					cri.andCostCodeEqualTo(bPrdCostBind.getCostCode());
					cri.andProductIdEqualTo(bPrdCostBind.getProductId());
					cri.andCostPhaseEqualTo(bPrdCostBind.getCostPhase());
					List<com.huateng.scf.bas.prd.dao.model.BPrdCostBind> bPrdCostBindList = bPrdCostBindDAO
							.selectByExample(bbie);
					if (bPrdCostBindList != null && bPrdCostBindList.size() > 0) {
						throw new ScubeBizException("对应的费用信息已经存在，不可新增！");
					} else {
						com.huateng.scf.bas.prd.dao.model.BPrdCostBind bPrdCostBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdCostBind();
						try {
							BeanUtils.copyProperties(bPrdCostBind, bPrdCostBind2);
						} catch (BeansException e) {
							throw new ScubeBizException("转换异常");
						}
						bPrdCostBind2.setId(UUIDGeneratorUtil.generate());
						try {
							bPrdCostBindDAO.insert(bPrdCostBind2);
							return null;
						} catch (Exception e) {
							log.error("产品费用关联信息新增失败！");
							throw new ScubeBizException("产品费用关联信息新增失败！", e);
						}
					}
				} else {
					throw new ScubeBizException("产品费用关联信息新增失败,所传数据无费用代码！");
				}
			} else {
				throw new ScubeBizException("产品费用关联信息新增失败,所传数据无产品号！");
			}
		} else {
			throw new ScubeBizException("产品费用关联信息新增失败！");
		}
	}

	// 产品费用关联信息删除
	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException{
		if (id != null && !"".equals(id)) {
			try {
				return bPrdCostBindDAO.deleteByPrimaryKey(id);
			} catch (Exception e) {
				log.error("产品费用关联信息删除失败！");
				throw new ScubeBizException("产品费用关联信息删除失败！", e);
			}
		} else {
			throw new ScubeBizException("产品费用关联信息id无效，删除失败！");
		}
	}

	// 产品费用关联信息修改 （根据id）
	@Override
	@Transactional
	public int update(BPrdCostBind bPrdCostBind)throws ScubeBizException {

		com.huateng.scf.bas.prd.dao.model.BPrdCostBind bPrdCostBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdCostBind();
		try {
			BeanUtils.copyProperties(bPrdCostBind, bPrdCostBind2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		if (bPrdCostBind.getId() != null && bPrdCostBind.getId().length() > 0) {
			try {
				return bPrdCostBindDAO.updateByPrimaryKeySelective(bPrdCostBind2);
			} catch (Exception e) {
				log.error("产品费用关联信息修改失败！");
				throw new ScubeBizException("产品费用关联信息修改失败！", e);
			}
		} else {
			throw new ScubeBizException("产品费用关联信息修改！");
		}

	}

	// 查找具体产品费用关联信息 （根据id,产品号，费用代码，无条件查询，返回空值。）
	@Override
	public BPrdCostBind findBPrdCostBindByKey(BPrdCostBind bPrdCostBind)throws ScubeBizException {
		BPrdCostBindExample bbie = new BPrdCostBindExample();
		Criteria cri = bbie.createCriteria();
		if (bPrdCostBind != null) {

			if (bPrdCostBind.getId() != null && bPrdCostBind.getId().length() > 0) {
				cri.andIdEqualTo(bPrdCostBind.getId());
			}

			if (bPrdCostBind.getProductId() != null && bPrdCostBind.getProductId().length() > 0) {
				cri.andProductIdEqualTo(bPrdCostBind.getProductId());
			}

			if (bPrdCostBind.getCostCode() != null && bPrdCostBind.getCostCode().length() > 0) {
				cri.andCostCodeEqualTo(bPrdCostBind.getCostCode());
			}

			try {
				BPrdCostBind bPrdCostBind2 = new BPrdCostBind();
				List<com.huateng.scf.bas.prd.dao.model.BPrdCostBind> bPrdCostBinds = bPrdCostBindDAO
						.selectByExample(bbie);
				if (bPrdCostBinds != null && bPrdCostBinds.size() > 0) {
					com.huateng.scf.bas.prd.dao.model.BPrdCostBind bPrdCostBind1 = bPrdCostBinds.get(0);
					try {
						BeanUtils.copyProperties(bPrdCostBind1, bPrdCostBind2);
					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					return bPrdCostBind2;
				} else {
					// 没有查询到对象
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("查找具体产品费用关联信息失败！");
			}
		} else {
			// 无条件查询，返回空值。
			return null;
		}
	}

	// 分页查询产品费用关联信息（根据id,产品号，费用代码，无条件查询，返回所有。）
	@Override
	public Page selectBPrdCostBindByPage(int pageNo, int pageSize, BPrdCostBind bPrdCostBind) throws ScubeBizException{
		Page p = new Page(pageSize, pageNo, 0);
		BPrdCostBindExample example = new BPrdCostBindExample();
		Criteria criteria = example.createCriteria();
		if (bPrdCostBind != null && !"".equals(bPrdCostBind)) {
			if (bPrdCostBind.getId() != null && bPrdCostBind.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdCostBind.getId());
			}

			if (bPrdCostBind.getProductId() != null && bPrdCostBind.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdCostBind.getProductId());
			}

			if (bPrdCostBind.getCostCode() != null && bPrdCostBind.getCostCode().length() > 0) {
				criteria.andCostCodeEqualTo(bPrdCostBind.getCostCode());
			}
		}
		try {
			p.setRecords(bPrdCostBindDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("产品费用关联信息条件分页查询失败！");
			throw new ScubeBizException("产品费用关联信息条件分页查询失败！", e);
		}
	}
	

	/**
	 * 通过产品productId删除
	 * @param productId : 产品Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
	@Override
	@Transactional
	public int deleteByProductId(String productId) throws ScubeBizException {
		BPrdCostBindExample example = new BPrdCostBindExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		try {
			return bPrdCostBindDAO.deleteByExample(example);
		} catch (Exception e) {
			throw new ScubeBizException("根据productId删除产品费用关联信息失败",e);
		}
	}

}
