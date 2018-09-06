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
import com.huateng.scf.bas.prd.dao.IBPrdBizSurBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurBindExample;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurBindExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdBizSur;
import com.huateng.scf.bas.prd.model.BPrdBizSurBind;
import com.huateng.scf.bas.prd.service.IBPrdBizSurBindService;
import com.huateng.scf.bas.prd.service.IBPrdBizSurService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 产品业务调查关联服务实现类
 * </p>
 * 
 * @author huangshuidan
 * @date 2016年11月22日上午10:06:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月2日上午10:06:04              新增
 * 
 * </pre>
 */
@ScubeService
@Service("BPrdBizSurBindServiceImpl")
public class BPrdBizSurBindServiceImpl implements IBPrdBizSurBindService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdBizSurBindDAO")
	IBPrdBizSurBindDAO bPrdBizSurBindDAO;
	@Resource(name = "BPrdBizSurServiceImpl")
	IBPrdBizSurService bprdBizSurService;

	// 新增业务调查关联信息
	@Override
	@Transactional
	public String add(BPrdBizSurBind bPrdBizSurBind) throws ScubeBizException {
		// 验证数据库中是否有重复数据
		List<com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind> list = this
				.criteriaQuery(bPrdBizSurBind);
		if (list != null && list.size() > 0) {
			throw new ScubeBizException("对应的业务调查关联信息已经存在，不可新增！");
		}

		com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind bPrdBizSurBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind();
		try {
			BeanUtils.copyProperties(bPrdBizSurBind, bPrdBizSurBind2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		bPrdBizSurBind2.setId(UUIDGeneratorUtil.generate());// 设置主键
		try {
			bPrdBizSurBindDAO.insert(bPrdBizSurBind2);
			return null;
		} catch (Exception e) {
			log.error("新增业务调查关联信息失败！");
			throw new ScubeBizException("新增业务调查关联信息失败！", e);
		}
	}

	/**
	 * 条件查询数据库，用于避免存入重复数据
	 * 
	 * @param bPrdBizSurBind
	 * @return list
	 */
	private List<com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind> criteriaQuery(
			BPrdBizSurBind bPrdBizSurBind) {
		List<com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind> list = null;
		if (bPrdBizSurBind != null && bPrdBizSurBind.getProductId() != null
				&& bPrdBizSurBind.getBProdBizSurId() != null
				&& bPrdBizSurBind.getBProdBizSurId().length() > 0
				&& bPrdBizSurBind.getProductId().length() > 0) {
			BPrdBizSurBindExample example = new BPrdBizSurBindExample();
			Criteria criteria = example.createCriteria();
			criteria.andProductIdEqualTo(bPrdBizSurBind.getProductId());
			criteria.andBProdBizSurIdEqualTo(bPrdBizSurBind.getBProdBizSurId());
			list = bPrdBizSurBindDAO.selectByExample(example);
		}
		return list;
	}

	// 根据主键删除业务调查关联信息
	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException {
		try {
			return bPrdBizSurBindDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除业务调查关联信息失败！");
			throw new ScubeBizException("删除业务调查关联信息失败！", e);
		}
	}

	// 根据主键修改业务调查关联信息
	@Override
	@Transactional
	public int update(BPrdBizSurBind bPrdBizSurBind) throws ScubeBizException {
		// 验证数据库中是否有重复数据
		List<com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind> list = this
				.criteriaQuery(bPrdBizSurBind);
		if (list != null && list.size() > 0) {
			throw new ScubeBizException("对应的业务调查关联信息已经存在，请重新修改！");
		}
        //修改
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind bPrdBizSurBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind();
			try {
				BeanUtils.copyProperties(bPrdBizSurBind, bPrdBizSurBind2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdBizSurBindDAO
					.updateByPrimaryKeySelective(bPrdBizSurBind2);

		} catch (Exception e) {
			log.error("修改业务调查关联信息失败！");
			throw new ScubeBizException("修改业务调查关联信息失败！", e);
		}
	}

	// 主键查询
	@Override
	public BPrdBizSurBind findBPrdBizSurBindByKey(BPrdBizSurBind bPrdBizSurBind)
			throws ScubeBizException {
		if (bPrdBizSurBind == null) {
			return null;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind bPrdBizSurBind2 = bPrdBizSurBindDAO
					.selectByPrimaryKey(bPrdBizSurBind.getId());
			try {
				BeanUtils.copyProperties(bPrdBizSurBind2, bPrdBizSurBind);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdBizSurBind;

		} catch (Exception e) {
			log.error("查询业务调查关联信息失败！！");
			throw new ScubeBizException("查询业务调查关联信息失败！！", e);
		}
	}

	// 条件查询
	@Override
	public List<BPrdBizSurBind> findBPrdBizSurBindByBPrd(
			BPrdBizSurBind bPrdBizSurBind) throws ScubeBizException {
		List<BPrdBizSurBind> list = new ArrayList<BPrdBizSurBind>();
		BPrdBizSurBindExample example = new BPrdBizSurBindExample();
		Criteria criteria = example.createCriteria();
		if (bPrdBizSurBind != null) {
			// 主键id
			if (bPrdBizSurBind.getId() != null
					&& bPrdBizSurBind.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdBizSurBind.getId());
			}
			// 产品id
			if (bPrdBizSurBind.getProductId() != null
					&& bPrdBizSurBind.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdBizSurBind.getProductId());
			}
			// 业务调查资料ID
			if (bPrdBizSurBind.getBProdBizSurId() != null
					&& bPrdBizSurBind.getBProdBizSurId().length() > 0) {
				criteria.andBProdBizSurIdEqualTo(bPrdBizSurBind
						.getBProdBizSurId());
			}
			// 材料类型：1-业务调查资料，2-制度相关资料
			if (bPrdBizSurBind.getMatlType() != null
					&& bPrdBizSurBind.getMatlType().length() > 0) {
				criteria.andMatlTypeEqualTo(bPrdBizSurBind.getMatlType());
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind> surBinds = bPrdBizSurBindDAO
					.selectByExample(example);
			for (com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind bizSurBind : surBinds) {
				BPrdBizSurBind bizSurBind2 = new BPrdBizSurBind();
				try {
					BeanUtils.copyProperties(bizSurBind, bizSurBind2);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				list.add(bizSurBind2);
			}
			return list;
		} catch (Exception e) {
			log.error("条件查询业务调查关联信息失败！！");
			throw new ScubeBizException("条件查询业务调查关联信息失败！", e);
		}
	}

	// 分页查询(可以展示材料名称bProdBizSurName)
	@Override
	public Page findBPrdBizSurBindByPage(int pageNo, int pageSize,
			BPrdBizSurBind bPrdBizSurBind) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);

		BPrdBizSurBindExample example = new BPrdBizSurBindExample();
		Criteria criteria = example.createCriteria();
		if (bPrdBizSurBind != null) {
			// 主键id
			if (bPrdBizSurBind.getId() != null
					&& bPrdBizSurBind.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdBizSurBind.getId());
			}
			// 产品id
			if (bPrdBizSurBind.getProductId() != null
					&& bPrdBizSurBind.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdBizSurBind.getProductId());
			}
			// 业务调查资料ID
			if (bPrdBizSurBind.getBProdBizSurId() != null
					&& bPrdBizSurBind.getBProdBizSurId().length() > 0) {
				criteria.andBProdBizSurIdEqualTo(bPrdBizSurBind
						.getBProdBizSurId());
			}
			// 材料类型：1-业务调查资料，2-制度相关资料
			if (bPrdBizSurBind.getMatlType() != null
					&& bPrdBizSurBind.getMatlType().length() > 0) {
				criteria.andMatlTypeEqualTo(bPrdBizSurBind.getMatlType());
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind> list01 = new ArrayList<com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind>();
			List<com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind> list = bPrdBizSurBindDAO
					.selectByExample(example);
			for (com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind bPrdBizSurBind2 : list) {
				// 查询出业务调查资料，以得到材料名称：matlName
				BPrdBizSur bizSur = new BPrdBizSur();
				bizSur.setId(bPrdBizSurBind2.getBProdBizSurId());
				BPrdBizSur prdBizSur = bprdBizSurService
						.findBPrdBizSurByKey(bizSur);
				if (prdBizSur != null) {
					bPrdBizSurBind2.setBProdBizSurName(prdBizSur.getMatlName());
				}
				list01.add(bPrdBizSurBind2);
			}
			page.setRecords(list01);
			page.setTotalRecord(list01.size());
			return page;
		} catch (Exception e) {
			log.error("分页查询业务调查关联信息失败！！");
			throw new ScubeBizException("分页查询业务调查关联信息失败！", e);
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
		BPrdBizSurBindExample example = new BPrdBizSurBindExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		try {
			return bPrdBizSurBindDAO.deleteByExample(example);
		} catch (Exception e) {
			throw new ScubeBizException("根据productId删除业务调查关联信息失败", e);
		}
	}

	@Override
	@Transactional
	public String batchAdd(List<BPrdBizSurBind> bPrdBizSurBindList)
			throws ScubeBizException {
		if (bPrdBizSurBindList != null) {
			for (BPrdBizSurBind bPrdBizSurBind : bPrdBizSurBindList) {
				List<com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind> list = this
						.criteriaQuery(bPrdBizSurBind);
				if (list != null && list.size() > 0) continue;
				// 添加记录
				com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind bPrdBizSurBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdBizSurBind();
				try {
					BeanUtils.copyProperties(bPrdBizSurBind, bPrdBizSurBind2);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				bPrdBizSurBind2.setId(UUIDGeneratorUtil.generate());// 设置主键
				try {
					bPrdBizSurBindDAO.insert(bPrdBizSurBind2);
					return null;
				} catch (Exception e) {
					log.error("新增业务调查关联信息失败！");
					throw new ScubeBizException("新增业务调查关联信息失败！", e);
				}
			}
		}
		return null;
	}
}
