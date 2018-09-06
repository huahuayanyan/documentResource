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
import com.huateng.scf.bas.prd.dao.IBPrdWkflowCopDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdWkflowCopExample;
import com.huateng.scf.bas.prd.dao.model.BPrdWkflowCopExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdCopLib;
import com.huateng.scf.bas.prd.model.BPrdWkflowCop;
import com.huateng.scf.bas.prd.service.IBPrdCopLibService;
import com.huateng.scf.bas.prd.service.IBPrdWkflowCopService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 流程组件信息服务实现类
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
@Service("BPrdWkflowCopServiceImpl")
public class BPrdWkflowCopServiceImpl implements IBPrdWkflowCopService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "BPrdWkflowCopDAO")
	private IBPrdWkflowCopDAO bPrdWkflowCopDAO;
	@Resource(name="BPrdCopLibServiceImpl")
	private IBPrdCopLibService bPrdCopLibService;
	
	
	@Override
	@Transactional
	public String add(BPrdWkflowCop bPrdWkflowCop) throws ScubeBizException{
		ScfCommonUtil.setCommonField(bPrdWkflowCop);// 设置公共字段创建人，最后更新人，创建时间，最后更新时间，最后更新机构
		com.huateng.scf.bas.prd.dao.model.BPrdWkflowCop bPrdWkflowCop2 = new com.huateng.scf.bas.prd.dao.model.BPrdWkflowCop();
		try {
			BeanUtils.copyProperties(bPrdWkflowCop, bPrdWkflowCop2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bPrdWkflowCop2.setBrcode(brcode);// 设置经办机构信息
		bPrdWkflowCop2.setId(UUIDGeneratorUtil.generate());// 设置唯一标识Id
		try {
			bPrdWkflowCopDAO.insert(bPrdWkflowCop2);
			//新增产品组件库信息
			BPrdCopLib bPrdCopLib =new BPrdCopLib();
			bPrdCopLib.setCopName(bPrdWkflowCop2.getFlowName());
			bPrdCopLib.setCopType(BPrdConstant.COP_TYPE_FLOW);
			bPrdCopLib.setRelId(bPrdWkflowCop2.getId());
			bPrdCopLib.setStatus(bPrdWkflowCop2.getStatus());
			bPrdCopLibService.add(bPrdCopLib);
			return null;
		} catch (Exception e) {
			log.error("新增流程组件信息失败！");
			throw new ScubeBizException("新增流程组件信息失败！", e);
		}
	}

	// 根据id删除流程组件
	@Override
	@Transactional
	public int delete(String id)throws ScubeBizException {
		try {
			//删除产品组件库中对应的组件信息
			bPrdCopLibService.deleteByRelId(id);
			return bPrdWkflowCopDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("流程组件信息删除失败！");
			throw new ScubeBizException("流程组件信息删除失败！", e);
		}
	}

	@Override
	@Transactional
	public int update(BPrdWkflowCop bPrdWkflowCop) throws ScubeBizException{
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdWkflowCop bPrdWkflowCop2 = new com.huateng.scf.bas.prd.dao.model.BPrdWkflowCop();
			try {
				BeanUtils.copyProperties(bPrdWkflowCop, bPrdWkflowCop2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			
			//修改产品组件库对应的组件信息
			if (bPrdWkflowCop2.getId() != null && bPrdWkflowCop2.getId().length() > 0) {
				BPrdCopLib bPrdCopLib = new BPrdCopLib();
				bPrdCopLib.setRelId(bPrdWkflowCop2.getId());
				
				List<BPrdCopLib> bPrdCopLibList = bPrdCopLibService
						.findBPrdCopLibByBPrd(bPrdCopLib);
				if (bPrdCopLibList != null && bPrdCopLibList.size() > 0) {
					BPrdCopLib bPrdCopLib2 = bPrdCopLibList.get(0);
					bPrdCopLib2.setCopName(bPrdWkflowCop2.getFlowName());
					bPrdCopLib2.setStatus(bPrdWkflowCop2.getStatus());
					bPrdCopLibService.update(bPrdCopLib2);
				}
			}
			return bPrdWkflowCopDAO.updateByPrimaryKeySelective(bPrdWkflowCop2);
		} catch (Exception e) {
			log.error("流程组件信息修改失败！");
			throw new ScubeBizException("流程组件信息修改失败！", e);
		}

	}

	@Override
	public BPrdWkflowCop findBPrdWkflowCopByKey(BPrdWkflowCop bPrdWkflowCop)throws ScubeBizException {
		if (bPrdWkflowCop == null) {
			return null;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdWkflowCop bPrdWkflowCop2 = bPrdWkflowCopDAO
					.selectByPrimaryKey(bPrdWkflowCop.getId());
			try {
				BeanUtils.copyProperties(bPrdWkflowCop2, bPrdWkflowCop);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			
			return bPrdWkflowCop;
		} catch (Exception e) {
			log.error("查询流程组件信息失败！！");
			throw new ScubeBizException("查询流程组件信息失败！", e);
		}
	}

	@Override
	public List<BPrdWkflowCop> findBPrdWkflowCopByBPrd(
			BPrdWkflowCop bPrdWkflowCop) throws ScubeBizException{
		List<BPrdWkflowCop> bPrdWkflowCopList = new ArrayList<BPrdWkflowCop>();
		BPrdWkflowCopExample bPrdWkflowCopExample = new BPrdWkflowCopExample();
		Criteria criteria = bPrdWkflowCopExample.createCriteria();
		if (bPrdWkflowCop != null) {
			// 根据id查询
			if (bPrdWkflowCop.getId() != null
					&& bPrdWkflowCop.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdWkflowCop.getId());
			}
			// 根据流程流程组件id查询
			if (bPrdWkflowCop.getFlowCopId() != null
					&& bPrdWkflowCop.getFlowCopId().length() > 0) {
				criteria.andFlowCopIdEqualTo(bPrdWkflowCop.getFlowCopId());
			}
			// 根据流程组件名称模糊查询
			if (bPrdWkflowCop.getFlowName() != null
					&& bPrdWkflowCop.getFlowName().length() > 0) {
				criteria.andFlowNameLike("%" + bPrdWkflowCop.getFlowName()
						+ "%");
			}
			// 根据流程组件中文名称模糊查询
			if (bPrdWkflowCop.getFlownamecn() != null
					&& bPrdWkflowCop.getFlownamecn().length() > 0) {
				criteria.andFlownamecnLike(bPrdWkflowCop.getFlownamecn());
			}
			// 根据流程组件状态查询
			if (bPrdWkflowCop.getStatus() != null
					&& bPrdWkflowCop.getStatus().length() > 0) {
				criteria.andStatusEqualTo(bPrdWkflowCop.getStatus());
			}
			// 根据所属包id查询
			if (bPrdWkflowCop.getPackageId() != null
					&& bPrdWkflowCop.getPackageId().length() > 0) {
				criteria.andPackageIdEqualTo(bPrdWkflowCop.getPackageId());
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdWkflowCop> flowcopList = bPrdWkflowCopDAO
					.selectByExample(bPrdWkflowCopExample);
			for (com.huateng.scf.bas.prd.dao.model.BPrdWkflowCop wkflowCop : flowcopList) {
				BPrdWkflowCop flowcop = new BPrdWkflowCop();
				try {
					BeanUtils.copyProperties(wkflowCop, flowcop);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				
				bPrdWkflowCopList.add(flowcop);
			}
			return bPrdWkflowCopList;
		} catch (Exception e) {
			log.error("条件查询组件信息失败！！");
			throw new ScubeBizException("条件查询组件信息失败！", e);
		}
	}

	@Override
	public Page findBPrdWkflowCopByPage(int pageNo, int pageSize,
			BPrdWkflowCop bPrdWkflowCop) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdWkflowCopExample bPrdWkflowCopExample = new BPrdWkflowCopExample();
		Criteria criteria = bPrdWkflowCopExample.createCriteria();
		if (bPrdWkflowCop != null) {
			// 根据id查询
			if (bPrdWkflowCop.getId() != null
					&& bPrdWkflowCop.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdWkflowCop.getId());
			}
			// 根据流程流程组件id查询
			if (bPrdWkflowCop.getFlowCopId() != null
					&& bPrdWkflowCop.getFlowCopId().length() > 0) {
				criteria.andFlowCopIdEqualTo(bPrdWkflowCop.getFlowCopId());
			}
			// 根据流程组件名称模糊查询
			if (bPrdWkflowCop.getFlowName() != null
					&& bPrdWkflowCop.getFlowName().length() > 0) {
				criteria.andFlowNameLike("%" + bPrdWkflowCop.getFlowName()
						+ "%");
			}
			// 根据流程组件中文名称模糊查询
			if (bPrdWkflowCop.getFlownamecn() != null
					&& bPrdWkflowCop.getFlownamecn().length() > 0) {
				criteria.andFlownamecnLike(bPrdWkflowCop.getFlownamecn());
			}
			// 根据流程组件状态查询
			if (bPrdWkflowCop.getStatus() != null
					&& bPrdWkflowCop.getStatus().length() > 0) {
				criteria.andStatusEqualTo(bPrdWkflowCop.getStatus());
			}
			// 根据所属包id查询
			if (bPrdWkflowCop.getPackageId() != null
					&& bPrdWkflowCop.getPackageId().length() > 0) {
				criteria.andPackageIdEqualTo(bPrdWkflowCop.getPackageId());
			}
		}
		try {
			page.setRecords(bPrdWkflowCopDAO.selectByPage(bPrdWkflowCopExample,
					page));
			return page;
		} catch (Exception e) {
			log.error("分页查询流程组件失败！！");
			throw new ScubeBizException("分页查询流程组件失败！", e);
		}

	}

	@Override
	public BPrdWkflowCop queryBPrdWkflowCopByBPrd(BPrdWkflowCop bPrdWkflowCop) throws ScubeBizException {
		List<BPrdWkflowCop> wkflowList=this.findBPrdWkflowCopByBPrd(bPrdWkflowCop);
		BPrdWkflowCop bPrdWkflow=null;
		if(null!=wkflowList && wkflowList.size()>0){
			bPrdWkflow=wkflowList.get(0);
		}
		return bPrdWkflow;
	}
	

}
