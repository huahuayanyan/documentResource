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
import com.huateng.scf.bas.prd.dao.IBPrdCreditPlyDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditPlyExample;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditPlyExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdCreditPly;
import com.huateng.scf.bas.prd.service.IBPrdCreditPlyService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 授信政策服务实现类
 * </p>
 * 
 * @author huangshuidan
 * @date 2016年12月7日上午10:06:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月7日上午10:06:04              新增
 * 
 * </pre>
 */
@ScubeService
@Service("BPrdCreditPlyServiceImpl")
public class BPrdCreditPlyServiceImpl implements IBPrdCreditPlyService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdCreditPlyDAO")
	IBPrdCreditPlyDAO bPrdCreditPlyDAO;

	@Override
	@Transactional
	public String add(BPrdCreditPly bPrdCreditPly) throws ScubeBizException {

		// 验证数据库中是否有重复数据
		if (bPrdCreditPly != null) {
			if (bPrdCreditPly.getProductId() != null
					&& bPrdCreditPly.getProductId().length() > 0) {
				BPrdCreditPlyExample example = new BPrdCreditPlyExample();
				Criteria criteria = example.createCriteria();
				criteria.andProductIdEqualTo(bPrdCreditPly.getProductId());
				List<com.huateng.scf.bas.prd.dao.model.BPrdCreditPly> list = bPrdCreditPlyDAO
						.selectByExample(example);
				//若已存在，调用修改方法update()
				if (list != null && list.size() > 0) {
					this.update(bPrdCreditPly);
					return null;
				}
			}
		}
		
		com.huateng.scf.bas.prd.dao.model.BPrdCreditPly bPrdCreditPly2 = new com.huateng.scf.bas.prd.dao.model.BPrdCreditPly();
		try {
			BeanUtils.copyProperties(bPrdCreditPly, bPrdCreditPly2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		bPrdCreditPly2.setId(UUIDGeneratorUtil.generate());// 设置主键
		try {
			bPrdCreditPlyDAO.insert(bPrdCreditPly2);
			return null;
		} catch (Exception e) {
			log.error("新增授信政策信息失败！");
			throw new ScubeBizException("新增授信政策信息失败！", e);
		}
	}

	@Override
	@Transactional
	public int update(BPrdCreditPly bPrdCreditPly) throws ScubeBizException {
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdCreditPly bPrdCreditPly2 = new com.huateng.scf.bas.prd.dao.model.BPrdCreditPly();
			try {
				BeanUtils.copyProperties(bPrdCreditPly, bPrdCreditPly2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdCreditPlyDAO.updateByPrimaryKeySelective(bPrdCreditPly2);

		} catch (Exception e) {
			log.error("修改授信政策信息失败！");
			throw new ScubeBizException("修改授信政策信息失败！", e);
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
		BPrdCreditPlyExample example = new BPrdCreditPlyExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		try {
			return bPrdCreditPlyDAO.deleteByExample(example);
		} catch (Exception e) {
			log.error("根据productId删除授信政策信息失败！");
			throw new ScubeBizException("根据productId删除授信政策信息失败！", e);
		}
	}

	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException {
		try {
			return bPrdCreditPlyDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除授信政策信息失败！");
			throw new ScubeBizException("删除授信政策信息失败！", e);
		}
	}

	@Override
	public BPrdCreditPly findBPrdCreditPlyByKey(BPrdCreditPly bPrdCreditPly)
			throws ScubeBizException {
		if (bPrdCreditPly == null || bPrdCreditPly.getId() == null) {
			return bPrdCreditPly;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdCreditPly bPrdCreditPly2 = bPrdCreditPlyDAO
					.selectByPrimaryKey(bPrdCreditPly.getId());
			try {
				BeanUtils.copyProperties(bPrdCreditPly2, bPrdCreditPly);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdCreditPly;

		} catch (Exception e) {
			log.error("查询授信政策信息失败！！");
			throw new ScubeBizException("查询授信政策信息失败！！", e);
		}
	}

	// 通过产品id查询
	@Override
	public BPrdCreditPly findBPrdCreditPlyByProductId(
			BPrdCreditPly bPrdCreditPly) throws ScubeBizException {
		if (bPrdCreditPly == null || bPrdCreditPly.getProductId() == null) {
			return bPrdCreditPly;
		}
		try {
			BPrdCreditPlyExample example = new BPrdCreditPlyExample();
			Criteria criteria = example.createCriteria();
			criteria.andProductIdEqualTo(bPrdCreditPly.getProductId());
			List<com.huateng.scf.bas.prd.dao.model.BPrdCreditPly> list = bPrdCreditPlyDAO
					.selectByExample(example);
			if (list != null && list.size() > 0) {
				com.huateng.scf.bas.prd.dao.model.BPrdCreditPly bPrdCreditPly2 = list
						.get(0);
				try {
					BeanUtils.copyProperties(bPrdCreditPly2, bPrdCreditPly);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
			}
			return bPrdCreditPly;

		} catch (Exception e) {
			log.error("查询授信政策信息失败！！");
			throw new ScubeBizException("查询授信政策信息失败！！", e);
		}
	}

	@Override
	public List<BPrdCreditPly> findBPrdCreditPlyByBPrd(
			BPrdCreditPly bPrdCreditPly) throws ScubeBizException {
		List<BPrdCreditPly> list = new ArrayList<BPrdCreditPly>();
		BPrdCreditPlyExample example = new BPrdCreditPlyExample();
		Criteria criteria = example.createCriteria();
		if (bPrdCreditPly != null) {
			if (bPrdCreditPly.getId() != null
					&& bPrdCreditPly.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdCreditPly.getId());
			}
			if (bPrdCreditPly.getProductId() != null
					&& bPrdCreditPly.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdCreditPly.getProductId());
			}
			if (bPrdCreditPly.getEntAcs() != null
					&& bPrdCreditPly.getEntAcs().length() > 0) {
				criteria.andEntAcsLike("%" + bPrdCreditPly.getEntAcs() + "%");
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdCreditPly> bPrdCreditPlyList = bPrdCreditPlyDAO
					.selectByExample(example);
			for (com.huateng.scf.bas.prd.dao.model.BPrdCreditPly creditPly : bPrdCreditPlyList) {
				BPrdCreditPly ply = new BPrdCreditPly();
				try {
					BeanUtils.copyProperties(creditPly, ply);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				list.add(ply);
			}
			return list;
		} catch (Exception e) {
			log.error("条件查询授信政策信息失败！！");
			throw new ScubeBizException("条件查询授信政策信息失败！", e);
		}

	}

	@Override
	public Page findBPrdCreditPlyByPage(int pageNo, int pageSize,
			BPrdCreditPly bPrdCreditPly) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdCreditPlyExample example = new BPrdCreditPlyExample();
		Criteria criteria = example.createCriteria();
		if (bPrdCreditPly != null) {
			if (bPrdCreditPly.getId() != null
					&& bPrdCreditPly.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdCreditPly.getId());
			}
			if (bPrdCreditPly.getProductId() != null
					&& bPrdCreditPly.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdCreditPly.getProductId());
			}
			if (bPrdCreditPly.getEntAcs() != null
					&& bPrdCreditPly.getEntAcs().length() > 0) {
				criteria.andEntAcsLike("%" + bPrdCreditPly.getEntAcs() + "%");
			}
		}
		try {
			page.setRecords(bPrdCreditPlyDAO.selectByPage(example, page));
			return page;
		} catch (Exception e) {
			log.error("分页查询授信政策信息失败！！");
			throw new ScubeBizException("分页查询授信政策信息失败！", e);
		}
	}

}
