package com.huateng.scf.bas.prd.service.impl;

import java.util.ArrayList;
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
import com.huateng.scf.bas.prd.dao.IBPrdCopLibBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibBindExample;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibBindExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdCopLibBind;
import com.huateng.scf.bas.prd.service.IBPrdCopLibBindService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 产品组件关联信息服务实现类
 * </p>
 * 
 * @author huangshuidan
 * @date 2016-12-8 4:05:13 PM
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016-12-8 4:05:13 PM             新增
 * 
 * </pre>
 */
@ScubeService
@Service("BPrdCopLibBindServiceImpl")
public class BPrdCopLibBindServiceImpl implements IBPrdCopLibBindService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource(name = "BPrdCopLibBindDAO")
	IBPrdCopLibBindDAO bPrdCopLibBindDAO;

	@Override
	@Transactional
	public String add(BPrdCopLibBind bPrdCopLibBind) throws ScubeBizException {

		// 验证数据库中是否有重复数据
		if (bPrdCopLibBind != null) {
			BPrdCopLibBindExample example = new BPrdCopLibBindExample();
			Criteria criteria = example.createCriteria();
			if (bPrdCopLibBind.getProductId() != null
					&& bPrdCopLibBind.getProductId().length() > 0
					&& bPrdCopLibBind.getRelId() != null
					&& bPrdCopLibBind.getRelId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdCopLibBind.getProductId());
				criteria.andRelIdEqualTo(bPrdCopLibBind.getRelId());
				List<com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind> list = bPrdCopLibBindDAO
						.selectByExample(example);
				if (list != null && list.size() > 0) {
					throw new ScubeBizException("对应的产品组件关联信息已经存在，不可新增！");
				}
			}
		}
		com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind bPrdCopLibBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind();
		try {
			BeanUtils.copyProperties(bPrdCopLibBind, bPrdCopLibBind2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		bPrdCopLibBind2.setId(UUIDGeneratorUtil.generate());// 设置主键ID
		try {
			bPrdCopLibBindDAO.insert(bPrdCopLibBind2);
			return null;
		} catch (Exception e) {
			log.error("新增产品组件关联信息失败！");
			throw new ScubeBizException("新增产品组件关联信息失败！", e);
		}
	}

	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException {
		try {
			return bPrdCopLibBindDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("产品组件关联信息删除失败！");
			throw new ScubeBizException("产品组件关联信息删除失败！", e);
		}
	}

	@Override
	@Transactional
	public int update(BPrdCopLibBind bPrdCopLibBind) throws ScubeBizException {
		// 验证数据库中是否有重复数据
		if (bPrdCopLibBind != null) {
			if (bPrdCopLibBind.getProductId() != null
					&& bPrdCopLibBind.getProductId().length() > 0
					&& bPrdCopLibBind.getRelId() != null
					&& bPrdCopLibBind.getRelId().length() > 0) {
				BPrdCopLibBindExample example = new BPrdCopLibBindExample();
				Criteria criteria = example.createCriteria();
				criteria.andProductIdEqualTo(bPrdCopLibBind.getProductId());
				criteria.andRelIdEqualTo(bPrdCopLibBind.getRelId());
				List<com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind> list = bPrdCopLibBindDAO
						.selectByExample(example);
				if (list != null && list.size() > 0) {
					throw new ScubeBizException("对应的产品组件关联信息已经存在，请重新修改！");
				}
			}
		}

		try {
			com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind bPrdCopLibBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind();
			try {
				BeanUtils.copyProperties(bPrdCopLibBind, bPrdCopLibBind2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdCopLibBindDAO
					.updateByPrimaryKeySelective(bPrdCopLibBind2);
		} catch (Exception e) {
			log.error("产品组件关联信息修改失败！");
			throw new ScubeBizException("产品组件关联信息修改失败！", e);
		}
	}

	@Override
	public BPrdCopLibBind findBPrdCopLibBindByKey(BPrdCopLibBind bPrdCopLibBind)
			throws ScubeBizException {
		if (bPrdCopLibBind == null) {
			return null;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind copLibBind = bPrdCopLibBindDAO
					.selectByPrimaryKey(bPrdCopLibBind.getId());
			try {
				BeanUtils.copyProperties(copLibBind, bPrdCopLibBind);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdCopLibBind;
		} catch (Exception e) {
			log.error("查询产品组件关联信息失败！！");
			throw new ScubeBizException("查询产品组件关联信息失败！", e);
		}
	}

	@Override
	public List<BPrdCopLibBind> findBPrdCopLibBindBPrd(
			BPrdCopLibBind bPrdCopLibBind) throws ScubeBizException {
		List<BPrdCopLibBind> list = new ArrayList<BPrdCopLibBind>();
		BPrdCopLibBindExample example = new BPrdCopLibBindExample();
		Criteria criteria = example.createCriteria();
		if (bPrdCopLibBind != null) {
			// 组件名称
			if (bPrdCopLibBind.getCopName() != null
					&& !bPrdCopLibBind.getCopName().isEmpty()) {
				criteria.andCopNameLike("%" + bPrdCopLibBind.getCopName() + "%");
			}
			// 顺序
			if (bPrdCopLibBind.getCopOrder() != null) {
				criteria.andCopOrderEqualTo(bPrdCopLibBind.getCopOrder());
			}
			// 组件类型：1-业务组件，2-流程组件
			if (bPrdCopLibBind.getCopType() != null
					&& !bPrdCopLibBind.getCopType().isEmpty()) {
				criteria.andCopTypeEqualTo(bPrdCopLibBind.getCopType());
			}
			// 主键Id
			if (bPrdCopLibBind.getId() != null
					&& !bPrdCopLibBind.getId().isEmpty()) {
				criteria.andIdEqualTo(bPrdCopLibBind.getId());
			}
			// 产品Id
			if (bPrdCopLibBind.getProductId() != null
					&& !bPrdCopLibBind.getProductId().isEmpty()) {
				criteria.andProductIdEqualTo(bPrdCopLibBind.getProductId());
			}
			// 关联组件Id
			if (bPrdCopLibBind.getRelId() != null
					&& !bPrdCopLibBind.getRelId().isEmpty()) {
				criteria.andRelIdEqualTo(bPrdCopLibBind.getRelId());
			}
			// 状态：1-启用，2-停用
			if (bPrdCopLibBind.getStatus() != null
					&& !bPrdCopLibBind.getStatus().isEmpty()) {
				criteria.andStatusEqualTo(bPrdCopLibBind.getStatus());
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind> copLibBinds = bPrdCopLibBindDAO
					.selectByExample(example);
			for (com.huateng.scf.bas.prd.dao.model.BPrdCopLibBind bPrdCopLibBind2 : copLibBinds) {
				BPrdCopLibBind copLibBind = new BPrdCopLibBind();
				try {
					BeanUtils.copyProperties(bPrdCopLibBind2, copLibBind);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				list.add(copLibBind);
			}
			return list;
		} catch (Exception e) {
			log.error("条件产品组件关联信息失败！！");
			throw new ScubeBizException("条件产品组件关联信息失败！", e);
		}

	}

	@Override
	public Page findBPrdCopLibBindByPage(int pageNo, int pageSize,
			BPrdCopLibBind bPrdCopLibBind) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdCopLibBindExample example = new BPrdCopLibBindExample();
		Criteria criteria = example.createCriteria();
		if (bPrdCopLibBind != null) {
			// 组件名称
			if (bPrdCopLibBind.getCopName() != null
					&& !bPrdCopLibBind.getCopName().isEmpty()) {
				criteria.andCopNameLike("%" + bPrdCopLibBind.getCopName() + "%");
			}
			// 顺序
			if (bPrdCopLibBind.getCopOrder() != null) {
				criteria.andCopOrderEqualTo(bPrdCopLibBind.getCopOrder());
			}
			// 组件类型：1-业务组件，2-流程组件
			if (bPrdCopLibBind.getCopType() != null
					&& !bPrdCopLibBind.getCopType().isEmpty()) {
				criteria.andCopTypeEqualTo(bPrdCopLibBind.getCopType());
			}
			// 主键Id
			if (bPrdCopLibBind.getId() != null
					&& !bPrdCopLibBind.getId().isEmpty()) {
				criteria.andIdEqualTo(bPrdCopLibBind.getId());
			}
			// 产品Id
			if (bPrdCopLibBind.getProductId() != null
					&& !bPrdCopLibBind.getProductId().isEmpty()) {
				criteria.andProductIdEqualTo(bPrdCopLibBind.getProductId());
			}
			// 关联组件Id
			if (bPrdCopLibBind.getRelId() != null
					&& !bPrdCopLibBind.getRelId().isEmpty()) {
				criteria.andRelIdEqualTo(bPrdCopLibBind.getRelId());
			}
			// 状态：1-启用，2-停用
			if (bPrdCopLibBind.getStatus() != null
					&& !bPrdCopLibBind.getStatus().isEmpty()) {
				criteria.andStatusEqualTo(bPrdCopLibBind.getStatus());
			}
		}
		try {
			page.setRecords(bPrdCopLibBindDAO.selectByPage(example, page));
			return page;
		} catch (Exception e) {
			log.error("分页查询产品组件关联信息失败！！");
			throw new ScubeBizException("分页查询产品组件关联信息失败！", e);
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
		BPrdCopLibBindExample example = new BPrdCopLibBindExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		try {
			return bPrdCopLibBindDAO.deleteByExample(example);
		} catch (Exception e) {
			throw new ScubeBizException("根据productId删除产品组件关联信息失败",e);
		}
	}

}
