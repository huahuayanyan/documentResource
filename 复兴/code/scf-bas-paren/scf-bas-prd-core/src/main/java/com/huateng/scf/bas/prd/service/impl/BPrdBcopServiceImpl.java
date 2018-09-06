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
import com.huateng.scf.bas.prd.constant.BPrdConstant;
import com.huateng.scf.bas.prd.dao.IBPrdBcopDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBcopExample;
import com.huateng.scf.bas.prd.dao.model.BPrdBcopExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdBcop;
import com.huateng.scf.bas.prd.model.BPrdCopLib;
import com.huateng.scf.bas.prd.service.IBPrdBcopService;
import com.huateng.scf.bas.prd.service.IBPrdCopLibService;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 业务组件信息服务实现类
 * </p>
 * 
 * @author huangshuidan
 * @date Nov 30, 20164:05:13 PM
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   Nov 30, 20164:05:13 PM             新增
 * 
 * </pre>
 */
@ScubeService
@Service("BPrdBcopServiceImpl")
public class BPrdBcopServiceImpl implements IBPrdBcopService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "BPrdBcopDAO")
	private IBPrdBcopDAO bPrdBcopDAO;
	@Resource(name = "BSysSerialNoServiceImpl")
	private IBSysSerialNoService bSysSerialNoService;
	@Resource(name = "BPrdCopLibServiceImpl")
	private IBPrdCopLibService bPrdCopLibService;

	// 新增组件
	@Override
	@Transactional
	public String add(BPrdBcop bPrdBcop) throws ScubeBizException {
		ScfCommonUtil.setCommonField(bPrdBcop);// 设置公共字段创建人，最后更新人，创建时间，最后更新时间，最后更新机构
		com.huateng.scf.bas.prd.dao.model.BPrdBcop bPrdBcop2 = new com.huateng.scf.bas.prd.dao.model.BPrdBcop();
		try {
			BeanUtils.copyProperties(bPrdBcop, bPrdBcop2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bPrdBcop2.setBrcode(brcode);// 设置经办机构信息
		bPrdBcop2.setId(UUIDGeneratorUtil.generate());// 设置唯一标识Id
		bPrdBcop2.setBcopNo(bSysSerialNoService
				.genSerialNo(BPrdConstant.BCOP_NO));// 客户流水号
		try {
			bPrdBcopDAO.insert(bPrdBcop2);
			// 新增产品组件库信息
			BPrdCopLib bPrdCopLib = new BPrdCopLib();
			bPrdCopLib.setCopName(bPrdBcop2.getBcopName());
			bPrdCopLib.setCopType(BPrdConstant.COP_TYPE_BCOP);
			bPrdCopLib.setRelId(bPrdBcop2.getId());
			bPrdCopLib.setStatus(bPrdBcop2.getStatus());
			bPrdCopLibService.add(bPrdCopLib);
			return null;
		} catch (Exception e) {
			log.error("新增组件信息失败！");
			throw new ScubeBizException("新增组件信息失败！", e);
		}
	}

	// 删除业务组件（这里只根据组件ID）
	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException{
		try {
			// 删除产品组件库中对应的组件信息
			bPrdCopLibService.deleteByRelId(id);
			return bPrdBcopDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("组件信息删除失败！");
			throw new ScubeBizException("组件信息删除失败！", e);
		}
	}

	/*
	 * //批量删除组件信息（根据Id）,不建议用
	 * 
	 * @Override
	 * 
	 * @Transactional public int batchDelete(List idList) { Iterator<Map<String,
	 * Object>> it = idList.iterator(); List<String> idList2 = new
	 * ArrayList<String>(); while (it.hasNext()) { Map<String, Object> row =
	 * it.next(); String id = row.get("id") == null ? "0" :
	 * row.get("id").toString(); idList2.add(id); } try { return
	 * bPrdBcopDAO.batchDelete(idList2); } catch (Exception e) {
	 * log.error("组件信息删除失败！"); throw new ScubeBizException("组件信息删除失败！", e); }
	 * 
	 * }
	 */

	// 修改业务组件信息（这里只根据组件ID）
	@Override
	@Transactional
	public int update(BPrdBcop bPrdBcop) throws ScubeBizException{
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdBcop bPrdBcop2 = new com.huateng.scf.bas.prd.dao.model.BPrdBcop();
			try {
				BeanUtils.copyProperties(bPrdBcop, bPrdBcop2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			// 修改产品组件库对应的组件信息
			if (bPrdBcop2.getId() != null && bPrdBcop2.getId().length() > 0) {
				BPrdCopLib bPrdCopLib = new BPrdCopLib();
				bPrdCopLib.setRelId(bPrdBcop2.getId());
				List<BPrdCopLib> bPrdCopLibList = bPrdCopLibService
						.findBPrdCopLibByBPrd(bPrdCopLib);
				if (bPrdCopLibList != null && bPrdCopLibList.size() > 0) {
					BPrdCopLib bPrdCopLib2 = bPrdCopLibList.get(0);
					bPrdCopLib2.setCopName(bPrdBcop2.getBcopName());
					bPrdCopLib2.setStatus(bPrdBcop2.getStatus());
					bPrdCopLibService.update(bPrdCopLib2);
				}
			}
			return bPrdBcopDAO.updateByPrimaryKeySelective(bPrdBcop2);
		} catch (Exception e) {
			log.error("组件信息修改失败！");
			throw new ScubeBizException("组件信息修改失败！", e);
		}
	}

	// 查询业务组件具体信息(根据id查询)
	@Override
	public BPrdBcop findBPrdBcopByKey(BPrdBcop bPrdBcop)throws ScubeBizException {
		if (bPrdBcop == null) {
			return null;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdBcop prdBcop = bPrdBcopDAO
					.selectByPrimaryKey(bPrdBcop.getId());
			try {
				BeanUtils.copyProperties(prdBcop, bPrdBcop);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdBcop;
		} catch (Exception e) {
			log.error("查询组件信息失败！！");
			throw new ScubeBizException("查询组件信息失败！", e);
		}
	}

	// 条件查询业务组件具体信息
	@Override
	public List<BPrdBcop> findBPrdBcopByBPrd(BPrdBcop bPrdBcop)throws ScubeBizException {
		List<BPrdBcop> bPrdBcopList = new ArrayList<BPrdBcop>();
		BPrdBcopExample bcopExample = new BPrdBcopExample();
		Criteria criteria = bcopExample.createCriteria();
		if (bPrdBcop != null) {
			// 根据id查询
			if (bPrdBcop.getId() != null && bPrdBcop.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdBcop.getId());
			}
			// 根据组件编号查询
			if (bPrdBcop.getBcopNo() != null
					&& bPrdBcop.getBcopNo().length() > 0) {
				criteria.andBcopNoEqualTo(bPrdBcop.getBcopNo());
			}
			// 根据组件执行程序查询
			if (bPrdBcop.getBcopProg() != null
					&& bPrdBcop.getBcopProg().length() > 0) {
				criteria.andBcopProgEqualTo(bPrdBcop.getBcopProg());
			}
			// 根据组件名称查询
			if (bPrdBcop.getBcopName() != null
					&& bPrdBcop.getBcopName().length() > 0) {
				criteria.andBcopNameLike("%" + bPrdBcop.getBcopName() + "%");
			}
		}

		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdBcop> bPrdBcops = bPrdBcopDAO
					.selectByExample(bcopExample);
			for (com.huateng.scf.bas.prd.dao.model.BPrdBcop bPrdBcop2 : bPrdBcops) {
				BPrdBcop bcop = new BPrdBcop();
				try {
					BeanUtils.copyProperties(bPrdBcop2, bcop);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}

				bPrdBcopList.add(bcop);
			}

			return bPrdBcopList;
		} catch (Exception e) {
			log.error("条件查询组件信息失败！！");
			throw new ScubeBizException("条件查询组件信息失败！", e);
		}

	}

	@Override
	// 条件分页查询
	public Page findBPrdBcopByPage(int pageNo, int pageSize, BPrdBcop bPrdBcop)
			throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdBcopExample bcopExample = new BPrdBcopExample();
		Criteria criteria = bcopExample.createCriteria();
		if (bPrdBcop != null) {
			// 根据id查询
			if (bPrdBcop.getId() != null && bPrdBcop.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdBcop.getId());
			}
			// 根据组件编号查询
			if (bPrdBcop.getBcopNo() != null
					&& bPrdBcop.getBcopNo().length() > 0) {
				criteria.andBcopNoEqualTo(bPrdBcop.getBcopNo());
			}
			// 根据组件名称查询
			if (bPrdBcop.getBcopName() != null
					&& bPrdBcop.getBcopName().length() > 0) {
				criteria.andBcopNameLike("%" + bPrdBcop.getBcopName() + "%");
			}
			// 根据组件执行程序查询
			if (bPrdBcop.getBcopProg() != null
					&& bPrdBcop.getBcopProg().length() > 0) {
				criteria.andBcopProgEqualTo(bPrdBcop.getBcopProg());
			}
			// 根据组件状态查询
			if (bPrdBcop.getStatus() != null
					&& bPrdBcop.getStatus().length() > 0) {
				criteria.andStatusEqualTo(bPrdBcop.getStatus());
			}
		}
		try {
			page.setRecords(bPrdBcopDAO.selectByPage(bcopExample, page));
			return page;
		} catch (Exception e) {
			log.error("分页查询组件失败！！");
			throw new ScubeBizException("分页查询组件失败！", e);
		}

	}

}
