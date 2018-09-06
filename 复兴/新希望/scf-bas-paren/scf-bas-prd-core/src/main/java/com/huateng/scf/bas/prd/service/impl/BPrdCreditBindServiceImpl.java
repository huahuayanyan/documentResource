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
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.prd.dao.IBPrdCreditBindDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBindExample;
import com.huateng.scf.bas.prd.dao.model.BPrdCreditBindExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdCreditBind;
import com.huateng.scf.bas.prd.service.IBPrdCreditBindService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 产品额度绑定服务实现类
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
@Service("BPrdCreditBindServiceImpl")
public class BPrdCreditBindServiceImpl implements IBPrdCreditBindService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource(name = "BPrdCreditBindDAO")
	IBPrdCreditBindDAO bprdCreditBindDAO;

	// 新增产品额度绑定信息方法
	@Override
	@Transactional
	public String add(BPrdCreditBind bPrdCreditBind) throws ScubeBizException {

		// 验证数据库中是否有重复数据
		if (bPrdCreditBind != null) {
			if (bPrdCreditBind.getProductId() != null
					&& bPrdCreditBind.getProductId().length() > 0
					&& bPrdCreditBind.getCreditType() != null
					&& bPrdCreditBind.getCreditType().length() > 0) {
				BPrdCreditBindExample example = new BPrdCreditBindExample();
				Criteria criteria = example.createCriteria();
				criteria.andProductIdEqualTo(bPrdCreditBind.getProductId());
				criteria.andCreditTypeEqualTo(bPrdCreditBind.getCreditType());
				List<com.huateng.scf.bas.prd.dao.model.BPrdCreditBind> list = bprdCreditBindDAO
						.selectByExample(example);
				if (list != null && list.size() > 0) {
					throw new ScubeBizException("对应的产品额度绑定信息已经存在，不可新增！");
				}
			}
		}

		com.huateng.scf.bas.prd.dao.model.BPrdCreditBind bPrdCreditBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdCreditBind();
		try {
			BeanUtils.copyProperties(bPrdCreditBind, bPrdCreditBind2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		bPrdCreditBind2.setId(UUIDGeneratorUtil.generate());// 设置主键ID
		try {
			bprdCreditBindDAO.insert(bPrdCreditBind2);
			return null;
		} catch (Exception e) {
			log.error("新增产品额度绑定信息失败！");
			throw new ScubeBizException("新增产品额度绑定信息失败！", e);
		}
	}

	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException {
		try {
			return bprdCreditBindDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("产品额度绑定信息删除失败！");
			throw new ScubeBizException("产品额度绑定信息删除失败！", e);
		}
	}

	@Override
	@Transactional
	public int update(BPrdCreditBind bPrdCreditBind) throws ScubeBizException {
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdCreditBind bPrdCreditBind2 = new com.huateng.scf.bas.prd.dao.model.BPrdCreditBind();
			try {
				BeanUtils.copyProperties(bPrdCreditBind, bPrdCreditBind2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bprdCreditBindDAO
					.updateByPrimaryKeySelective(bPrdCreditBind2);
		} catch (Exception e) {
			log.error("产品额度绑定信息修改失败！");
			throw new ScubeBizException("产品额度绑定信息修改失败！", e);
		}
	}

	@Override
	public BPrdCreditBind findBPrdCreditBindByKey(BPrdCreditBind bPrdCreditBind)
			throws ScubeBizException {
		if (bPrdCreditBind == null) {
			return null;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdCreditBind creditBind = bprdCreditBindDAO
					.selectByPrimaryKey(bPrdCreditBind.getId());
			try {
				BeanUtils.copyProperties(creditBind, bPrdCreditBind);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdCreditBind;
		} catch (Exception e) {
			log.error("查询产品额度绑定信息失败！！");
			throw new ScubeBizException("查询产品额度绑定信息失败！", e);
		}
	}

	@Override
	public List<BPrdCreditBind> findBPrdCreditBindBPrd(
			BPrdCreditBind bPrdCreditBind) throws ScubeBizException {
		List<BPrdCreditBind> list = new ArrayList<BPrdCreditBind>();
		BPrdCreditBindExample example = new BPrdCreditBindExample();
		Criteria criteria = example.createCriteria();
		if (bPrdCreditBind != null) {
			// 额度阶段
			if (bPrdCreditBind.getCreditPhase() != null
					&& bPrdCreditBind.getCreditPhase().length() > 0) {
				criteria.andCreditPhaseEqualTo(bPrdCreditBind.getCreditPhase());
			}
			// 额度类型
			if (bPrdCreditBind.getCreditType() != null
					&& bPrdCreditBind.getCreditType().length() > 0) {
				criteria.andCreditTypeLike("%" + bPrdCreditBind.getCreditType()
						+ "%");
			}
			// 功能编号
			if (bPrdCreditBind.getFunNo() != null
					&& bPrdCreditBind.getFunNo().length() > 0) {
				criteria.andFunNoLike("%" + bPrdCreditBind.getFunNo() + "%");
			}
			// 主键
			if (bPrdCreditBind.getId() != null
					&& bPrdCreditBind.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdCreditBind.getId());
			}
			// 额度操作金额
			if (bPrdCreditBind.getOprField() != null
					&& bPrdCreditBind.getOprField().length() > 0) {
				criteria.andOprFieldEqualTo(bPrdCreditBind.getOprField());
			}
			// 操作模式
			if (bPrdCreditBind.getOprMode() != null
					&& bPrdCreditBind.getOprMode().length() > 0) {
				criteria.andOprModeEqualTo(bPrdCreditBind.getOprMode());
			}
			// 操作类型
			if (bPrdCreditBind.getOprType() != null
					&& bPrdCreditBind.getOprType().length() > 0) {
				criteria.andOprTypeEqualTo(bPrdCreditBind.getOprType());
			}
			// 产品Id
			if (bPrdCreditBind.getProductId() != null
					&& bPrdCreditBind.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdCreditBind.getProductId());
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdCreditBind> bPrdCreditBinds = bprdCreditBindDAO
					.selectByExample(example);
			for (com.huateng.scf.bas.prd.dao.model.BPrdCreditBind bPrdCreditBind2 : bPrdCreditBinds) {
				BPrdCreditBind creditBind = new BPrdCreditBind();
				try {
					BeanUtils.copyProperties(bPrdCreditBind2, creditBind);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				creditBind.setProductName(bPrdCreditBind.getProductName());
				list.add(creditBind);
			}
			return list;
		} catch (Exception e) {
			log.error("条件产品额度绑定信息失败！！");
			throw new ScubeBizException("条件产品额度绑定信息失败！", e);
		}
	}

	@Override
	public Page findBPrdCreditBindByPage(int pageNo, int pageSize,
			BPrdCreditBind bPrdCreditBind) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdCreditBindExample example = new BPrdCreditBindExample();
		Criteria criteria = example.createCriteria();
		if (bPrdCreditBind != null) {
			// 额度阶段
			if (bPrdCreditBind.getCreditPhase() != null
					&& bPrdCreditBind.getCreditPhase().length() > 0) {
				criteria.andCreditPhaseEqualTo(bPrdCreditBind.getCreditPhase());
			}
			// 额度类型
			if (bPrdCreditBind.getCreditType() != null
					&& bPrdCreditBind.getCreditType().length() > 0) {
				criteria.andCreditTypeLike("%" + bPrdCreditBind.getCreditType()
						+ "%");
			}
			// 功能编号
			if (bPrdCreditBind.getFunNo() != null
					&& bPrdCreditBind.getFunNo().length() > 0) {
				criteria.andFunNoLike("%" + bPrdCreditBind.getFunNo() + "%");
			}
			// 主键
			if (bPrdCreditBind.getId() != null
					&& bPrdCreditBind.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdCreditBind.getId());
			}
			// 额度操作金额
			if (bPrdCreditBind.getOprField() != null
					&& bPrdCreditBind.getOprField().length() > 0) {
				criteria.andOprFieldEqualTo(bPrdCreditBind.getOprField());
			}
			// 操作模式
			if (bPrdCreditBind.getOprMode() != null
					&& bPrdCreditBind.getOprMode().length() > 0) {
				criteria.andOprModeEqualTo(bPrdCreditBind.getOprMode());
			}
			// 操作类型
			if (bPrdCreditBind.getOprType() != null
					&& bPrdCreditBind.getOprType().length() > 0) {
				criteria.andOprTypeEqualTo(bPrdCreditBind.getOprType());
			}
			// 产品Id
			if (bPrdCreditBind.getProductId() != null
					&& bPrdCreditBind.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdCreditBind.getProductId());
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdCreditBind> list = new ArrayList<com.huateng.scf.bas.prd.dao.model.BPrdCreditBind>();
			List<com.huateng.scf.bas.prd.dao.model.BPrdCreditBind> bPrdCreditBinds = bprdCreditBindDAO
					.selectByExample(example);
			for (com.huateng.scf.bas.prd.dao.model.BPrdCreditBind bPrdCreditBind2 : bPrdCreditBinds) {
               if(bPrdCreditBind!=null){
            	   bPrdCreditBind2.setProductName(bPrdCreditBind.getProductName());
               }
               list.add(bPrdCreditBind2);
			}
			page.setRecords(list);
			page.setTotalRecord(list.size());
			return page;
		} catch (Exception e) {
			log.error("分页查询产品额度绑定信息失败！！");
			throw new ScubeBizException("分页查询产品额度绑定信息失败！", e);
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
		BPrdCreditBindExample example = new BPrdCreditBindExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		try {
			return bprdCreditBindDAO.deleteByExample(example);
		} catch (Exception e) {
			throw new ScubeBizException("根据productId删除产品额度绑定信息失败",e);
		}
	}

	/**
	 *
	 * @Description: 获取产品额度信息
	 * @author wenkui.xu
	 * @Created 2012-9-13下午03:11:21
	 * @param tblProductCreditBind
	 * @return
	 * @throws CommonException
	 */
	@Override
	public List<BPrdCreditBind> getTblProductCreditBind(BPrdCreditBind tblProductCreditBind) throws ScubeBizException{
		BPrdCreditBindExample example = new BPrdCreditBindExample();
		BPrdCreditBindExample.Criteria cri = example.createCriteria();
		if (!StringUtil.isEmpty(tblProductCreditBind.getProductId())){	// 产品id
			cri.andProductIdEqualTo(tblProductCreditBind.getProductId());
		}
		if (!StringUtil.isEmpty(tblProductCreditBind.getCreditType())){	// 额度品种
			cri.andCreditTypeEqualTo(tblProductCreditBind.getCreditType());
		}
		if (!StringUtil.isEmpty(tblProductCreditBind.getCreditPhase())){	// 额度阶段
			cri.andCreditPhaseEqualTo(tblProductCreditBind.getCreditPhase());
		}
		if (!StringUtil.isEmpty(tblProductCreditBind.getOprField())){	// 额度操作金额
			cri.andOprFieldEqualTo(tblProductCreditBind.getOprField());
		}
		if (!StringUtil.isEmpty(tblProductCreditBind.getOprType())){	// 额度操作类型
			cri.andOprTypeEqualTo(tblProductCreditBind.getOprType());
		}
		if (!StringUtil.isEmpty(tblProductCreditBind.getOprMode())){	// 额度操作模式
			cri.andOprModeEqualTo(tblProductCreditBind.getOprMode());
		}
		List<com.huateng.scf.bas.prd.dao.model.BPrdCreditBind> listdal = bprdCreditBindDAO.selectByExample(example);
		List<BPrdCreditBind> list = new ArrayList<BPrdCreditBind>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.prd.dao.model.BPrdCreditBind binddal : listdal)
			{
				BPrdCreditBind bPrdCreditBind = new BPrdCreditBind();
				BeanUtils.copyProperties(binddal, bPrdCreditBind);
				list.add(bPrdCreditBind);
			}
		}
		return list;
	}
}
