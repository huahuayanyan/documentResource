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
import com.huateng.scf.bas.prd.dao.IBPrdCopLibDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibExample;
import com.huateng.scf.bas.prd.dao.model.BPrdCopLibExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdCopLib;
import com.huateng.scf.bas.prd.service.IBPrdCopLibService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 产品组件库服务实现类
 * </p>
 * 
 * @author huangshuidan
 * @date 2016年11月22日上午10:19:08
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日上午10:19:08             新增
 * 
 * </pre>
 */
@ScubeService
@Service("BPrdCopLibServiceImpl")
public class BPrdCopLibServiceImpl implements IBPrdCopLibService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource(name = "BPrdCopLibDAO")
	private IBPrdCopLibDAO bPrdCopLibDAO;

	@Override
	@Transactional
	// 新增方法
	public String add(BPrdCopLib bPrdCopLib) throws ScubeBizException {
		ScfCommonUtil.setCommonField(bPrdCopLib);// 设置公共字段创建人，最后更新人，创建时间，最后更新时间，最后更新机构
		com.huateng.scf.bas.prd.dao.model.BPrdCopLib bPrdCopLib2 = new com.huateng.scf.bas.prd.dao.model.BPrdCopLib();
		try {
			BeanUtils.copyProperties(bPrdCopLib, bPrdCopLib2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		bPrdCopLib2.setId(UUIDGeneratorUtil.generate());//设置主键ID
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bPrdCopLib2.setBrcode(brcode);// 设置经办机构信息
		try {
			bPrdCopLibDAO.insert(bPrdCopLib2);
			return null;
		} catch (Exception e) {
			log.error("新增组件库信息失败！");
			throw new ScubeBizException("新增组件库信息失败！", e);
		}
	}

	@Override
	@Transactional
	// 根据id删除组件库信息
	public int delete(String id) throws ScubeBizException {
		try {
			return bPrdCopLibDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("组件库信息删除失败！");
			throw new ScubeBizException("组件库信息删除失败！", e);
		}
	}

	@Override
	@Transactional
	//修改组件库信息方法
	public int update(BPrdCopLib bPrdCopLib) throws ScubeBizException {
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdCopLib bPrdCopLib2 = new com.huateng.scf.bas.prd.dao.model.BPrdCopLib();
			try {
				BeanUtils.copyProperties(bPrdCopLib, bPrdCopLib2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdCopLibDAO.updateByPrimaryKeySelective(bPrdCopLib2);
		} catch (Exception e) {
			log.error("组件库信息修改失败！");
			throw new ScubeBizException("组件库信息修改失败！", e);
		}
	}

	@Override
	//根据主键Id查询出单条组件库信息
	public BPrdCopLib findBPrdCopLibByKey(BPrdCopLib bPrdCopLib)
			throws ScubeBizException {
		if (bPrdCopLib == null) {
			return null;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdCopLib bPrdCopLib2 = bPrdCopLibDAO
					.selectByPrimaryKey(bPrdCopLib.getId());
			try {
				BeanUtils.copyProperties(bPrdCopLib2, bPrdCopLib);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdCopLib;
		} catch (Exception e) {
			log.error("查询单条组件库信息失败！！");
			throw new ScubeBizException("查询单条组件库信息失败！", e);
		}
	}

	@Override
	// 条件查询
	public List<BPrdCopLib> findBPrdCopLibByBPrd(BPrdCopLib bPrdCopLib)
			throws ScubeBizException {
		List<BPrdCopLib> bPrdCopLibList = new ArrayList<BPrdCopLib>();
		BPrdCopLibExample bPrdCopLibExample = new BPrdCopLibExample();
		Criteria criteria = bPrdCopLibExample.createCriteria();
		if (bPrdCopLib != null) {
			// 根据主键id查询
			if (bPrdCopLib.getId() != null) {
				criteria.andIdEqualTo(bPrdCopLib.getId());
			}
			// 根据组件名称模糊查询
			if (bPrdCopLib.getCopName() != null) {
				criteria.andCopNameLike("%" + bPrdCopLib.getCopName() + "%");
			}
			// 根据组件类型查询 : 1代表业务组件;2代表流程组件
			if (bPrdCopLib.getCopType() != null) {
				criteria.andCopTypeEqualTo(bPrdCopLib.getCopType());
			}
			// 根据对应组件Id查询
			if (bPrdCopLib.getRelId() != null) {
				criteria.andRelIdEqualTo(bPrdCopLib.getRelId());
			}
			// 根据状态查询 : 1代表启用;2代表停用
			if (bPrdCopLib.getStatus() != null) {
				criteria.andStatusEqualTo(bPrdCopLib.getStatus());
			}
		}

		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdCopLib> bPrdCopLibs = bPrdCopLibDAO
					.selectByExample(bPrdCopLibExample);
			for (com.huateng.scf.bas.prd.dao.model.BPrdCopLib bPrdCopLib2 : bPrdCopLibs) {
				BPrdCopLib bCopLib = new BPrdCopLib();
				try {
					BeanUtils.copyProperties(bPrdCopLib2, bCopLib);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				bPrdCopLibList.add(bCopLib);
			}
			return bPrdCopLibList;
		} catch (Exception e) {
			log.error("条件查询组件库信息失败！！");
			throw new ScubeBizException("条件查询组件库信息失败！！", e);
		}
	}

	@Override
	// 分页查询
	public Page findBPrdCopLibByPage(int pageNo, int pageSize,
			BPrdCopLib bPrdCopLib) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdCopLibExample bPrdCopLibExample = new BPrdCopLibExample();
		Criteria criteria = bPrdCopLibExample.createCriteria();
		if (bPrdCopLib != null) {
			// 根据主键id查询
			if (bPrdCopLib.getId() != null) {
				criteria.andIdEqualTo(bPrdCopLib.getId());
			}
			// 根据组件名称模糊查询
			if (bPrdCopLib.getCopName() != null) {
				criteria.andCopNameLike("%" + bPrdCopLib.getCopName() + "%");
			}
			// 根据组件类型查询 : 1代表业务组件;2代表流程组件
			if (bPrdCopLib.getCopType() != null) {
				criteria.andCopTypeEqualTo(bPrdCopLib.getCopType());
			}
			// 根据对应组件Id查询
			if (bPrdCopLib.getRelId() != null) {
				criteria.andRelIdEqualTo(bPrdCopLib.getRelId());
			}
			// 根据状态查询 : 1代表启用;2代表停用
			if (bPrdCopLib.getStatus() != null) {
				criteria.andStatusEqualTo(bPrdCopLib.getStatus());
			}
		}
		try {
			page.setRecords(bPrdCopLibDAO.selectByPage(bPrdCopLibExample, page));
			return page;
		} catch (Exception e) {
			log.error("分页查询组件库失败！！");
			throw new ScubeBizException("分页查询组件库失败！", e);
		}
	}

	@Override
	@Transactional
	//根据关联组件Id删除组件库信息
	public int deleteByRelId(String relId) throws ScubeBizException {
		BPrdCopLibExample bPrdCopLibExample = new BPrdCopLibExample();
		Criteria criteria = bPrdCopLibExample.createCriteria();
		try {
			if(relId!=null&&relId.length()>0){
				criteria.andRelIdEqualTo(relId);
				return bPrdCopLibDAO.deleteByExample(bPrdCopLibExample);
			}
			throw new ScubeBizException("传入参数为空！！");
		} catch (Exception e) {
			log.error("根据关联组件Id删除失败！！");
			throw new ScubeBizException("根据关联组件Id删除失败！！",e);
		}
		
	}
}
