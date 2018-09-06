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

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.prd.dao.IBPrdBizSurDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurExample;
import com.huateng.scf.bas.prd.dao.model.BPrdBizSurExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdBizSur;
import com.huateng.scf.bas.prd.service.IBPrdBizSurService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 业务调查服务实现类
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
@Service("BPrdBizSurServiceImpl")
public class BPrdBizSurServiceImpl implements IBPrdBizSurService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource(name = "BPrdBizSurDAO")
	private IBPrdBizSurDAO bprdBizSurDAO;

	@Override
	@Transactional
	public String add(BPrdBizSur bPrdBizSur) throws ScubeBizException {
		// 验证数据库中是否有重复数据
		if (bPrdBizSur != null) {
			if (bPrdBizSur.getMatlName() != null
					&& bPrdBizSur.getMatlType() != null
					&& bPrdBizSur.getMatlName().length() > 0
					&& bPrdBizSur.getMatlType().length() > 0) {
                BPrdBizSurExample example =new BPrdBizSurExample();
                Criteria criteria = example.createCriteria();
                criteria.andMatlNameEqualTo(bPrdBizSur.getMatlName());
               // criteria.andMatlTypeEqualTo(bPrdBizSur.getMatlType()+"   ");//在数据库中matlType为char类型，占4位。
                criteria.andMatlTypeLike(bPrdBizSur.getMatlType()+"%");
                List<com.huateng.scf.bas.prd.dao.model.BPrdBizSur> list = bprdBizSurDAO.selectByExample(example);
                if(list!=null&&list.size()>0){
                	throw new ScubeBizException("对应的业务调查信息已经存在，不可新增！");
                }
			}
		}
		ScfCommonUtil.setCommonField(bPrdBizSur);// 设置公共字段创建人，最后更新人，创建时间，最后更新时间，最后更新机构
		com.huateng.scf.bas.prd.dao.model.BPrdBizSur bPrdBizSur2 = new com.huateng.scf.bas.prd.dao.model.BPrdBizSur();
		try {
			BeanUtils.copyProperties(bPrdBizSur, bPrdBizSur2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bPrdBizSur2.setBrcode(brcode);// 设置经办机构信息
		bPrdBizSur2.setId(UUIDGeneratorUtil.generate());// 设置主键
		try {
			bprdBizSurDAO.insert(bPrdBizSur2);
			return null;
		} catch (Exception e) {
			log.error("新增业务调查信息失败！");
			throw new ScubeBizException("新增业务调查信息失败！", e);
		}
	}

	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException {
		try {
			return bprdBizSurDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除业务调查信息失败！");
			throw new ScubeBizException("删除业务调查信息失败！", e);
		}
	}

	@Override
	@Transactional
	public int update(BPrdBizSur bPrdBizSur) throws ScubeBizException {
		// 验证数据库中是否有重复数据
		if (bPrdBizSur != null) {
			if (bPrdBizSur.getMatlName() != null
					&& bPrdBizSur.getMatlType() != null
					&& bPrdBizSur.getMatlName().length() > 0
					&& bPrdBizSur.getMatlType().length() > 0) {
                BPrdBizSurExample example =new BPrdBizSurExample();
                Criteria criteria = example.createCriteria();
                criteria.andMatlNameEqualTo(bPrdBizSur.getMatlName());
               // criteria.andMatlTypeEqualTo(bPrdBizSur.getMatlType()+"   ");//在数据库中matlType为char类型，占4位。
                criteria.andMatlTypeLike(bPrdBizSur.getMatlType()+"%");
                List<com.huateng.scf.bas.prd.dao.model.BPrdBizSur> list = bprdBizSurDAO.selectByExample(example);
                if(list!=null&&list.size()>0){
                	throw new ScubeBizException("对应的业务调查信息已经存在，请重新修改！");
                }
			}
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdBizSur bPrdBizSur2 = new com.huateng.scf.bas.prd.dao.model.BPrdBizSur();
			try {
				BeanUtils.copyProperties(bPrdBizSur, bPrdBizSur2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bprdBizSurDAO.updateByPrimaryKeySelective(bPrdBizSur2);

		} catch (Exception e) {
			log.error("修改业务调查信息失败！");
			throw new ScubeBizException("修改业务调查信息失败！", e);
		}
	}

	@Override
	public BPrdBizSur findBPrdBizSurByKey(BPrdBizSur bPrdBizSur)
			throws ScubeBizException {
		if (bPrdBizSur == null) {
			return null;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdBizSur prdBizSur = bprdBizSurDAO
					.selectByPrimaryKey(bPrdBizSur.getId());
			try {
				BeanUtils.copyProperties(prdBizSur, bPrdBizSur);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdBizSur;

		} catch (Exception e) {
			log.error("查询业务调查信息失败！！");
			throw new ScubeBizException("查询业务调查信息失败！！", e);
		}

	}

	@Override
	public List<BPrdBizSur> findBPrdBizSurByBPrd(BPrdBizSur bPrdBizSur)
			throws ScubeBizException {
		List<BPrdBizSur> list = new ArrayList<BPrdBizSur>();
		BPrdBizSurExample example = new BPrdBizSurExample();
		Criteria criteria = example.createCriteria();
		if (bPrdBizSur != null) {
			// 主键id
			if (bPrdBizSur.getId() != null && bPrdBizSur.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdBizSur.getId());
			}
			// 材料名称
			if (bPrdBizSur.getMatlName() != null
					&& bPrdBizSur.getMatlName().length() > 0) {
				criteria.andMatlNameLike("%" + bPrdBizSur.getMatlName() + "%");
			}
			// 材料类型
			if (bPrdBizSur.getMatlType() != null
					&& bPrdBizSur.getMatlType().length() > 0) {
				criteria.andMatlTypeLike(bPrdBizSur.getMatlType()+"%");
			}
			// 文件名称
			if (bPrdBizSur.getFileName() != null
					&& bPrdBizSur.getFileName().length() > 0) {
				criteria.andFileNameLike("%" + bPrdBizSur.getFileName() + "%");
			}
			// 产品大类名称
			if (bPrdBizSur.getProductName() != null
					&& bPrdBizSur.getProductName().length() > 0) {
				criteria.andProductNameEqualTo(bPrdBizSur.getProductName());
			}
			// 产品大类Id
			if (bPrdBizSur.getProductId() != null
					&& bPrdBizSur.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdBizSur.getProductId());
			}
			// 备注
			if (bPrdBizSur.getRemark() != null
					&& bPrdBizSur.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdBizSur.getProductId());
			}
		}

		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdBizSur> bPrdBizSurs = bprdBizSurDAO
					.selectByExample(example);
			for (com.huateng.scf.bas.prd.dao.model.BPrdBizSur bizSur : bPrdBizSurs) {
				BPrdBizSur bizSur2 = new BPrdBizSur();
				try {
					BeanUtils.copyProperties(bizSur, bizSur2);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				list.add(bizSur2);
			}
			return list;
		} catch (Exception e) {
			log.error("条件查询业务调查信息失败！！");
			throw new ScubeBizException("条件查询业务调查信息失败！", e);
		}
	}

	@Override
	public Page findBPrdBizSurByPage(int pageNo, int pageSize,
			BPrdBizSur bPrdBizSur) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdBizSurExample example = new BPrdBizSurExample();
		Criteria criteria = example.createCriteria();
		if (bPrdBizSur != null) {
			// 主键id
			if (bPrdBizSur.getId() != null && bPrdBizSur.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdBizSur.getId());
			}
			// 材料名称
			if (bPrdBizSur.getMatlName() != null
					&& bPrdBizSur.getMatlName().length() > 0) {
				criteria.andMatlNameLike("%" + bPrdBizSur.getMatlName() + "%");
			}
			// 材料类型
			if (bPrdBizSur.getMatlType() != null
					&& bPrdBizSur.getMatlType().length() > 0) {
				criteria.andMatlTypeLike(bPrdBizSur.getMatlType()+ "%");
			}
			// 文件名称
			if (bPrdBizSur.getFileName() != null
					&& bPrdBizSur.getFileName().length() > 0) {
				criteria.andFileNameLike("%" + bPrdBizSur.getFileName() + "%");
			}
			// 产品大类名称
			if (bPrdBizSur.getProductName() != null
					&& bPrdBizSur.getProductName().length() > 0) {
				criteria.andProductNameEqualTo(bPrdBizSur.getProductName());
			}
			// 产品大类Id
			if (bPrdBizSur.getProductId() != null
					&& bPrdBizSur.getProductId().length() > 0) {
				criteria.andProductIdEqualTo(bPrdBizSur.getProductId());
			}
		}

		try {
			page.setRecords(bprdBizSurDAO.selectByPage(example, page));
			return page;
		} catch (Exception e) {
			log.error("分页查询业务调查信息失败！！");
			throw new ScubeBizException("分页查询业务调查信息失败！", e);
		}
	}

}
