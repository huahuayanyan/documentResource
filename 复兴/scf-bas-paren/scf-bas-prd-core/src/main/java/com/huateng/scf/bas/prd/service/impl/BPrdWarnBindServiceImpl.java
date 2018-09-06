/**
 * 
 */
package com.huateng.scf.bas.prd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.prd.dao.IBPrdWarnBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdWarnBindExample;
import com.huateng.scf.bas.prd.dao.model.BPrdWarnBindExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdWarnBind;
import com.huateng.scf.bas.prd.service.IBPrdWarnBindService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 产品风险预警关联服务实现类
 * </p>
 * 
 * @author lihao
 * @date 2016年12月1日下午7:43:02
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月1日下午7:43:02	      新增
 * 
 * </pre>
 */
@ScubeService
@Service("BPrdWarnBindServiceImpl")
public class BPrdWarnBindServiceImpl implements IBPrdWarnBindService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdWarnBindDAO")
	IBPrdWarnBindDAO bPrdWarnBindDAO;

	// 产品风险预警关联信息新增
	@Override
	@Transactional
	public String add(BPrdWarnBind bPrdWarnBind) throws ScubeBizException {
		// 需要查重，防止页面会新增相同预警信息。 warnNo
		List<com.huateng.scf.bas.prd.dao.model.BPrdWarnBind> list = criteriaQuery(bPrdWarnBind);
		if (list != null && list.size() > 0) {
			throw new ScubeBizException("对应的预警信息已经存在，不可新增！");
		}
       //添加
		com.huateng.scf.bas.prd.dao.model.BPrdWarnBind bPrdWarnBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdWarnBind();
		try {
			BeanUtils.copyProperties(bPrdWarnBind, bPrdWarnBind2);
		} catch (Exception e) {
			throw new ScubeBizException("转换异常！");
		}
		bPrdWarnBind2.setId(UUIDGeneratorUtil.generate());
		try {
			bPrdWarnBindDAO.insert(bPrdWarnBind2);
			return null;
		} catch (Exception e) {
			log.error("产品风险预警关联信息新增失败！");
			throw new ScubeBizException("产品风险预警关联信息新增失败！", e);
		}
	}

	private List<com.huateng.scf.bas.prd.dao.model.BPrdWarnBind> criteriaQuery(
			BPrdWarnBind bPrdWarnBind) {
		List<com.huateng.scf.bas.prd.dao.model.BPrdWarnBind> list = null;
		if (bPrdWarnBind != null) {
			if (bPrdWarnBind.getProductId() != null
					&& bPrdWarnBind.getProductId().length() > 0
					&& bPrdWarnBind.getWarnNo() != null
					&& bPrdWarnBind.getWarnNo().length() > 0) {
				BPrdWarnBindExample example = new BPrdWarnBindExample();
				Criteria criteria = example.createCriteria();
				criteria.andWarnNoEqualTo(bPrdWarnBind.getWarnNo());// 添加预警编号
				criteria.andProductIdEqualTo(bPrdWarnBind.getProductId());// 添加产品号
				list = bPrdWarnBindDAO.selectByExample(example);
			}
		}
		return list;
	}

	// 产品风险预警关联信息删除
	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException {
		if (id != null && !"".equals(id)) {
			try {
				return bPrdWarnBindDAO.deleteByPrimaryKey(id);
			} catch (Exception e) {
				log.error("产品风险预警关联信息删除失败！");
				throw new ScubeBizException("产品风险预警关联信息删除失败！", e);
			}
		} else {
			throw new ScubeBizException("产品风险预警关联信息id无效，删除失败！");
		}
	}

	// 产品风险预警关联信息修改 （根据id）
	@Override
	@Transactional
	public int update(BPrdWarnBind bPrdWarnBind) throws ScubeBizException {
		com.huateng.scf.bas.prd.dao.model.BPrdWarnBind bPrdWarnBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdWarnBind();
		try {
			BeanUtils.copyProperties(bPrdWarnBind, bPrdWarnBind2);
		} catch (Exception e) {
			throw new ScubeBizException("转换异常！");
		}
		if (bPrdWarnBind.getId() != null && bPrdWarnBind.getId().length() > 0) {
			try {
				return bPrdWarnBindDAO
						.updateByPrimaryKeySelective(bPrdWarnBind2);
			} catch (Exception e) {
				log.error("产品风险预警关联信息修改失败！");
				throw new ScubeBizException("产品风险预警关联信息修改失败！", e);
			}
		} else {
			throw new ScubeBizException("产品风险预警关联信息修改失败！");
		}

	}

	// 查找具体产品风险预警关联信息 （根据id,产品号，预警编号，预警名称，无条件查询，返回空值。）
	@Override
	public BPrdWarnBind findBPrdWarnBindByKey(BPrdWarnBind bPrdWarnBind)
			throws ScubeBizException {
		BPrdWarnBindExample bbie = new BPrdWarnBindExample();
		Criteria cri = bbie.createCriteria();
		if (bPrdWarnBind != null) {
			// id
			if (bPrdWarnBind.getId() != null
					&& bPrdWarnBind.getId().length() > 0) {
				cri.andIdEqualTo(bPrdWarnBind.getId());
			}
			// 产品号 ProductId
			if (bPrdWarnBind.getProductId() != null
					&& bPrdWarnBind.getProductId().length() > 0) {
				cri.andProductIdEqualTo(bPrdWarnBind.getProductId());
			}
			// 预警编号 WarnNo
			if (bPrdWarnBind.getWarnNo() != null
					&& bPrdWarnBind.getWarnNo().length() > 0) {
				cri.andWarnNoEqualTo(bPrdWarnBind.getWarnNo());
			}
			// 预警名称 WarnName
			if (bPrdWarnBind.getWarnName() != null
					&& bPrdWarnBind.getWarnName().length() > 0) {
				cri.andWarnNameLike("%" + bPrdWarnBind.getWarnName() + "%");
			}

			try {
				BPrdWarnBind bPrdWarnBind2 = new BPrdWarnBind();
				List<com.huateng.scf.bas.prd.dao.model.BPrdWarnBind> bPrdWarnBinds = bPrdWarnBindDAO
						.selectByExample(bbie);
				if (bPrdWarnBinds != null && bPrdWarnBinds.size() > 0) {
					com.huateng.scf.bas.prd.dao.model.BPrdWarnBind bPrdWarnBind1 = bPrdWarnBinds
							.get(0);
					try {
						BeanUtils.copyProperties(bPrdWarnBind1, bPrdWarnBind2);
					} catch (Exception e) {
						throw new ScubeBizException("转换异常！");
					}
					return bPrdWarnBind2;
				} else {
					// 没有查询到对象
					return null;
				}
			} catch (Exception e) {
				throw new ScubeBizException("查找具体产品风险预警关联信息失败！");
			}
		} else {
			// 无条件查询，返回空值。
			return null;
		}
	}

	// 分页查询产品风险预警关联信息（根据id,产品号，费用代码，无条件查询，返回所有。）
	@Override
	public Page selectBPrdWarnBindByPage(int pageNo, int pageSize,
			BPrdWarnBind bPrdWarnBind) throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		BPrdWarnBindExample example = new BPrdWarnBindExample();
		Criteria cri = example.createCriteria();
		if (bPrdWarnBind != null) {
			// id
			if (bPrdWarnBind.getId() != null
					&& bPrdWarnBind.getId().length() > 0) {
				cri.andIdEqualTo(bPrdWarnBind.getId());
			}
			// 产品号 ProductId
			if (bPrdWarnBind.getProductId() != null
					&& bPrdWarnBind.getProductId().length() > 0) {
				cri.andProductIdEqualTo(bPrdWarnBind.getProductId());
			}
			// 预警编号 WarnNo
			if (bPrdWarnBind.getWarnNo() != null
					&& bPrdWarnBind.getWarnNo().length() > 0) {
				cri.andWarnNoEqualTo(bPrdWarnBind.getWarnNo());
			}
			// 预警名称 WarnName
			if (bPrdWarnBind.getWarnName() != null
					&& bPrdWarnBind.getWarnName().length() > 0) {
				cri.andWarnNameLike("%" + bPrdWarnBind.getWarnName() + "%");
			}

		}
		try {
			p.setRecords(bPrdWarnBindDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("（产品风险预警关联信息条件分页查询失败！");
			throw new ScubeBizException("产品风险预警关联信息条件分页查询失败！", e);
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
		BPrdWarnBindExample example = new BPrdWarnBindExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		try {
			return bPrdWarnBindDAO.deleteByExample(example);
		} catch (Exception e) {
			log.error("根据产品productId删除产品风险预警关联信息失败");
			throw new ScubeBizException("根据产品productId删除产品风险预警关联信息失败", e);
		}
	}

	@Override
	@Transactional
	public String batchAdd(List<BPrdWarnBind> bPrdWarnBindList)
			throws ScubeBizException {
		if (bPrdWarnBindList != null) {
			for (BPrdWarnBind bPrdWarnBind : bPrdWarnBindList) {
				List<com.huateng.scf.bas.prd.dao.model.BPrdWarnBind> list = criteriaQuery(bPrdWarnBind);
				if (list != null && list.size() > 0) continue;
			   //添加记录
				com.huateng.scf.bas.prd.dao.model.BPrdWarnBind bPrdWarnBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdWarnBind();
				try {
					BeanUtils.copyProperties(bPrdWarnBind, bPrdWarnBind2);
				} catch (Exception e) {
					throw new ScubeBizException("转换异常！");
				}
				bPrdWarnBind2.setId(UUIDGeneratorUtil.generate());
				try {
					bPrdWarnBindDAO.insert(bPrdWarnBind2);
					return null;
				} catch (Exception e) {
					log.error("产品风险预警关联信息新增失败！");
					throw new ScubeBizException("产品风险预警关联信息新增失败！", e);
				}
			}
		}
		return null;
	}

}
