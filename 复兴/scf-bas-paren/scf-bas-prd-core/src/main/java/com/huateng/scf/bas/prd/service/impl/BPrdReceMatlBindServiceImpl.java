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
import com.huateng.scf.bas.prd.dao.IBPrdReceMatlBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBindExample;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBindExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdReceMatlBind;
import com.huateng.scf.bas.prd.service.IBPrdReceMatlBindService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 应收材料关联表信息服务实现类
 * </p>
 * 
 * @author huangshuidan
 * @date 2016年12月1日上午10:06:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月1日上午10:06:04              新增
 * 
 * </pre>
 */
@ScubeService
@Service("BPrdReceMatlBindServiceImpl")
public class BPrdReceMatlBindServiceImpl implements IBPrdReceMatlBindService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdReceMatlBindDAO")
	IBPrdReceMatlBindDAO bPrdReceMatlBindDAO;

	@Override
	@Transactional
	public String add(BPrdReceMatlBind bPrdReceMatlBind)
			throws ScubeBizException {
		// 验证数据库中是否有重复数据
		List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind> list = criteriaQuery(bPrdReceMatlBind);
		if (list != null && list.size() > 0) {
			throw new ScubeBizException("对应的应收材料关联信息已经存在，不可新增！");
		}

		com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind bPrdReceMatlBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind();
		try {
			BeanUtils.copyProperties(bPrdReceMatlBind, bPrdReceMatlBind2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		bPrdReceMatlBind2.setId(UUIDGeneratorUtil.generate());// 设置主键
		try {
			bPrdReceMatlBindDAO.insert(bPrdReceMatlBind2);
			return null;
		} catch (Exception e) {
			log.error("新增应收材料关联信息失败！");
			throw new ScubeBizException("新增应收材料关联信息失败！", e);
		}
	}

	/**
	 * 条件查询数据库，用于避免存入重复数据
	 * 
	 * @param bPrdReceMatlBind
	 * @return list
	 */
	private List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind> criteriaQuery(
			BPrdReceMatlBind bPrdReceMatlBind) {
		List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind> list = null;
		if (bPrdReceMatlBind != null) {
			if (bPrdReceMatlBind.getProductId() != null
					&& bPrdReceMatlBind.getReceMatlId() != null
					&& bPrdReceMatlBind.getReceMatlId().length() > 0
					&& bPrdReceMatlBind.getProductId().length() > 0) {
				BPrdReceMatlBindExample example = new BPrdReceMatlBindExample();
				Criteria criteria = example.createCriteria();
				criteria.andProductIdEqualTo(bPrdReceMatlBind.getProductId());
				criteria.andReceMatlIdEqualTo(bPrdReceMatlBind.getReceMatlId());
				list = bPrdReceMatlBindDAO.selectByExample(example);
			}
		}
		return list;
	}

	// 根据主键删除
	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException {
		try {
			return bPrdReceMatlBindDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除应收材料关联信息失败！");
			throw new ScubeBizException("删除应收材料关联信息失败！", e);
		}
	}

	// 修改应收材料关联信息
	@Override
	@Transactional
	public int update(BPrdReceMatlBind bPrdReceMatlBind)
			throws ScubeBizException {
		// 验证数据库中是否有重复数据
		List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind> list = criteriaQuery(bPrdReceMatlBind);
		if (list != null && list.size() > 0) {
			throw new ScubeBizException("对应的应收材料关联信息已经存在，请重新修改！");
		}
       //修改
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind bPrdReceMatlBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind();
			try {
				BeanUtils.copyProperties(bPrdReceMatlBind, bPrdReceMatlBind2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdReceMatlBindDAO
					.updateByPrimaryKeySelective(bPrdReceMatlBind2);

		} catch (Exception e) {
			log.error("修改应收材料关联信息失败！");
			throw new ScubeBizException("修改应收材料关联信息失败！", e);
		}
	}

	// 根据主键查询
	@Override
	public BPrdReceMatlBind findBPrdReceMatlBindByKey(
			BPrdReceMatlBind bPrdReceMatlBind) throws ScubeBizException {
		if (bPrdReceMatlBind == null) {
			return null;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind bPrdReceMatlBind2 = bPrdReceMatlBindDAO
					.selectByPrimaryKey(bPrdReceMatlBind.getId());
			try {
				BeanUtils.copyProperties(bPrdReceMatlBind2, bPrdReceMatlBind);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdReceMatlBind;

		} catch (Exception e) {
			log.error("查询应收材料关联信息失败！！");
			throw new ScubeBizException("查询应收材料关联信息失败！！", e);
		}
	}

	// 条件查询
	@Override
	public List<BPrdReceMatlBind> findBPrdReceMatlBindByBPrd(
			BPrdReceMatlBind bPrdReceMatlBind) throws ScubeBizException {
		List<BPrdReceMatlBind> list = new ArrayList<BPrdReceMatlBind>();
		BPrdReceMatlBindExample example = new BPrdReceMatlBindExample();
		Criteria criteria = example.createCriteria();
		if (bPrdReceMatlBind != null) {
			if (bPrdReceMatlBind.getId() != null
					&& bPrdReceMatlBind.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdReceMatlBind.getId());
			}
			if (bPrdReceMatlBind.getProductId() != null
					&& bPrdReceMatlBind.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdReceMatlBind.getProductId());
			}
			if (bPrdReceMatlBind.getReceMatlId() != null
					&& bPrdReceMatlBind.getReceMatlId().length() > 0) {
				criteria.andReceMatlIdEqualTo(bPrdReceMatlBind.getReceMatlId());
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind> matlBinds = bPrdReceMatlBindDAO
					.selectByExample(example);
			for (com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind receMatlBind : matlBinds) {
				BPrdReceMatlBind bpReceMatlBind = new BPrdReceMatlBind();
				try {
					BeanUtils.copyProperties(receMatlBind, bpReceMatlBind);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				list.add(bpReceMatlBind);
			}
			return list;
		} catch (Exception e) {
			log.error("条件查询应收材料关联信息失败！！");
			throw new ScubeBizException("条件查询应收材料关联信息失败！", e);
		}

	}

	// 根据productId查询
	@Override
	public List<BPrdReceMatlBind> findBPrdReceMatlBindByProductId(
			String productId) throws ScubeBizException {
		List<BPrdReceMatlBind> list = new ArrayList<BPrdReceMatlBind>();
		BPrdReceMatlBindExample example = new BPrdReceMatlBindExample();
		Criteria criteria = example.createCriteria();
		if (productId != null && productId.length() > 0) {
			criteria.andProductIdEqualTo(productId);
			try {
				List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind> matlBinds = bPrdReceMatlBindDAO
						.selectByExample(example);
				for (com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind receMatlBind : matlBinds) {
					BPrdReceMatlBind bpReceMatlBind = new BPrdReceMatlBind();
					try {
						BeanUtils.copyProperties(receMatlBind, bpReceMatlBind);
					} catch (BeansException e) {
						throw new ScubeBizException("转换异常");
					}
					list.add(bpReceMatlBind);
				}
			} catch (Exception e) {
				log.error("根据productId查询应收材料关联信息失败！！");
				throw new ScubeBizException("根据productId查询应收材料关联信息失败！", e);
			}
		}
		return list;
	}

	// 分页查询
	@Override
	public Page findBPrdReceMatlBindByPage(int pageNo, int pageSize,
			BPrdReceMatlBind bPrdReceMatlBind) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdReceMatlBindExample example = new BPrdReceMatlBindExample();
		Criteria criteria = example.createCriteria();
		if (bPrdReceMatlBind != null) {
			if (bPrdReceMatlBind.getId() != null
					&& bPrdReceMatlBind.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdReceMatlBind.getId());
			}
			if (bPrdReceMatlBind.getProductId() != null
					&& bPrdReceMatlBind.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdReceMatlBind.getProductId());
			}
			if (bPrdReceMatlBind.getReceMatlId() != null
					&& bPrdReceMatlBind.getReceMatlId().length() > 0) {
				criteria.andReceMatlIdEqualTo(bPrdReceMatlBind.getReceMatlId());
			}
		}
		try {
			page.setRecords(bPrdReceMatlBindDAO.selectByPage(example, page));
			return page;
		} catch (Exception e) {
			log.error("分页查询应收材料关联信息失败！！");
			throw new ScubeBizException("分页查询应收材料关联信息失败！", e);
		}
	}

	/**
	 * 通过应收材料receMatlId删除
	 * 
	 * @param receMatlId
	 *            :应收材料Id
	 * @return 0:成功;抛出异常:失败.
	 * @throws ScubeBizException
	 */
	@Override
	@Transactional
	public int deleteByReceMatlId(String receMatlId) throws ScubeBizException {
		BPrdReceMatlBindExample example = new BPrdReceMatlBindExample();
		Criteria criteria = example.createCriteria();
		criteria.andReceMatlIdEqualTo(receMatlId);
		try {
			return bPrdReceMatlBindDAO.deleteByExample(example);
		} catch (Exception e) {
			log.error("根据应收材料ID删除应收材料关联信息失败");
			throw new ScubeBizException("根据应收材料ID删除应收材料关联信息失败", e);
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
		BPrdReceMatlBindExample example = new BPrdReceMatlBindExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		try {
			return bPrdReceMatlBindDAO.deleteByExample(example);
		} catch (Exception e) {
			log.error("根据产品productId删除应收材料关联信息失败");
			throw new ScubeBizException("根据产品productId删除应收材料关联信息失败", e);
		}
	}

	@Override
	@Transactional
	public String batchAdd(List<BPrdReceMatlBind> bPrdReceMatlBindList)
			throws ScubeBizException {
		if (bPrdReceMatlBindList != null) {
			for (BPrdReceMatlBind bPrdReceMatlBind : bPrdReceMatlBindList) {
				List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind> list = criteriaQuery(bPrdReceMatlBind);
				if (list != null && list.size() > 0) continue;
				// 添加记录
				com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind bPrdReceMatlBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdReceMatlBind();
				try {
					BeanUtils.copyProperties(bPrdReceMatlBind,
							bPrdReceMatlBind2);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				bPrdReceMatlBind2.setId(UUIDGeneratorUtil.generate());// 设置主键
				try {
					bPrdReceMatlBindDAO.insert(bPrdReceMatlBind2);
					return null;
				} catch (Exception e) {
					log.error("新增应收材料关联信息失败！");
					throw new ScubeBizException("新增应收材料关联信息失败！", e);
				}
			}
		}
		return null;
	}

}
