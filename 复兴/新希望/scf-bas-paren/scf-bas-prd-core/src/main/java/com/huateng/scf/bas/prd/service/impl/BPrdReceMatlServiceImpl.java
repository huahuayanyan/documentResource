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
import com.huateng.scf.bas.prd.dao.IBPrdReceMatlDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlExample;
import com.huateng.scf.bas.prd.dao.model.BPrdReceMatlExample.Criteria;
import com.huateng.scf.bas.prd.model.BPrdReceMatl;
import com.huateng.scf.bas.prd.service.IBPrdReceMatlService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 应收材料信息服务实现类
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
@Service("BPrdReceMatlServiceImpl")
public class BPrdReceMatlServiceImpl implements IBPrdReceMatlService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource(name = "BPrdReceMatlDAO")
	private IBPrdReceMatlDAO bPrdReceMatlDAO;

	@Override
	@Transactional
	public String add(BPrdReceMatl bPrdReceMatl) throws ScubeBizException {

		// 验证数据库中是否有重复数据
		if (bPrdReceMatl != null) {
			if (bPrdReceMatl.getReceMatlName() != null
					&& bPrdReceMatl.getReceMatlType() != null
					&& bPrdReceMatl.getReceMatlName().length() > 0
					&& bPrdReceMatl.getReceMatlType().length() > 0) {
				BPrdReceMatlExample example = new BPrdReceMatlExample();
				Criteria criteria = example.createCriteria();
				criteria.andReceMatlTypeEqualTo(bPrdReceMatl.getReceMatlType());
				criteria.andReceMatlNameEqualTo(bPrdReceMatl.getReceMatlName());
				List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatl> list = bPrdReceMatlDAO
						.selectByExample(example);
				if (list != null && list.size() > 0) {
					throw new ScubeBizException("对应的应收材料信息已经存在，不可新增！");
				}
			}
		}

		ScfCommonUtil.setCommonField(bPrdReceMatl);// 设置公共字段创建人，最后更新人，创建时间，最后更新时间，最后更新机构
		com.huateng.scf.bas.prd.dao.model.BPrdReceMatl bPrdReceMatl2 = new com.huateng.scf.bas.prd.dao.model.BPrdReceMatl();
		try {
			BeanUtils.copyProperties(bPrdReceMatl, bPrdReceMatl2);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		BctlVO bctlVO = ContextHolder.getOrgInfo();// 获取机构信息
		String brcode = bctlVO.getBrNo();
		bPrdReceMatl2.setBrcode(brcode);// 设置经办机构信息
		bPrdReceMatl2.setId(UUIDGeneratorUtil.generate());// 设置主键
		try {
			bPrdReceMatlDAO.insert(bPrdReceMatl2);
			return null;
		} catch (Exception e) {
			log.error("新增应收材料信息失败！");
			throw new ScubeBizException("新增应收材料信息失败！", e);
		}
	}

	// 根据id删除应收材料信息
	@Override
	@Transactional
	public int delete(String id) throws ScubeBizException {
		try {
			return bPrdReceMatlDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除应收材料信息失败！");
			throw new ScubeBizException("删除应收材料信息失败！", e);
		}
	}

	// 修改应收材料信息(根据id)
	@Override
	@Transactional
	public int update(BPrdReceMatl bPrdReceMatl) throws ScubeBizException {
		// 验证数据库中是否有重复数据
		if (bPrdReceMatl != null) {
			if (bPrdReceMatl.getReceMatlName() != null
					&& bPrdReceMatl.getReceMatlType() != null
					&& bPrdReceMatl.getReceMatlName().length() > 0
					&& bPrdReceMatl.getReceMatlType().length() > 0) {
				BPrdReceMatlExample example = new BPrdReceMatlExample();
				Criteria criteria = example.createCriteria();
				criteria.andReceMatlTypeEqualTo(bPrdReceMatl.getReceMatlType());
				criteria.andReceMatlNameEqualTo(bPrdReceMatl.getReceMatlName());
				List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatl> list = bPrdReceMatlDAO
						.selectByExample(example);
				if (list != null && list.size() > 0) {
					throw new ScubeBizException("对应的应收材料信息已经存在，请重新修改！");
				}
			}
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdReceMatl bPrdReceMatl2 = new com.huateng.scf.bas.prd.dao.model.BPrdReceMatl();
			try {
				BeanUtils.copyProperties(bPrdReceMatl, bPrdReceMatl2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdReceMatlDAO.updateByPrimaryKeySelective(bPrdReceMatl2);

		} catch (Exception e) {
			log.error("修改应收材料信息失败！");
			throw new ScubeBizException("修改应收材料信息失败！", e);
		}
	}

	// 根据主键id查询
	@Override
	public BPrdReceMatl findBPrdReceMatlByKey(BPrdReceMatl bPrdReceMatl)
			throws ScubeBizException {
		if (bPrdReceMatl == null) {
			return null;
		}
		try {
			com.huateng.scf.bas.prd.dao.model.BPrdReceMatl prdReceMatl = bPrdReceMatlDAO
					.selectByPrimaryKey(bPrdReceMatl.getId());
			try {
				BeanUtils.copyProperties(prdReceMatl, bPrdReceMatl);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			return bPrdReceMatl;

		} catch (Exception e) {
			log.error("查询应收材料信息失败！！");
			throw new ScubeBizException("查询应收材料信息失败！！", e);
		}

	}

	// 条件查询
	@Override
	public List<BPrdReceMatl> findBPrdReceMatlByBPrd(BPrdReceMatl bPrdReceMatl)
			throws ScubeBizException {
		List<BPrdReceMatl> bPrdReceMatlList = new ArrayList<BPrdReceMatl>();
		BPrdReceMatlExample matlExample = new BPrdReceMatlExample();
		Criteria criteria = matlExample.createCriteria();
		if (bPrdReceMatl != null) {
			// 复印件份数
			if (bPrdReceMatl.getCopyOrigNum() != null) {
				criteria.andCopyOrigNumEqualTo(bPrdReceMatl.getCopyOrigNum());
			}
			// 主键Id
			if (bPrdReceMatl.getId() != null
					&& bPrdReceMatl.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdReceMatl.getId());
			}
			// 是否必需
			if (bPrdReceMatl.getIsNeedFlag() != null
					&& bPrdReceMatl.getIsNeedFlag().length() > 0) {
				criteria.andIsNeedFlagEqualTo(bPrdReceMatl.getIsNeedFlag());
			}
			// 原件份数
			if (bPrdReceMatl.getOrigNum() != null) {
				criteria.andOrigNumEqualTo(bPrdReceMatl.getOrigNum());
			}
			// 应收材料名称
			if (bPrdReceMatl.getReceMatlName() != null
					&& bPrdReceMatl.getReceMatlName().length() > 0) {
				criteria.andReceMatlNameLike("%"
						+ bPrdReceMatl.getReceMatlName() + "%");
			}
			// 应收材料类型
			if (bPrdReceMatl.getReceMatlType() != null
					&& bPrdReceMatl.getReceMatlType().length() > 0) {
				criteria.andReceMatlTypeEqualTo(bPrdReceMatl.getReceMatlType());
			}
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatl> matls = bPrdReceMatlDAO
					.selectByExample(matlExample);
			for (com.huateng.scf.bas.prd.dao.model.BPrdReceMatl receMatl : matls) {
				BPrdReceMatl bpReceMatl = new BPrdReceMatl();
				try {
					BeanUtils.copyProperties(receMatl, bpReceMatl);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				bPrdReceMatlList.add(bpReceMatl);
			}
			return bPrdReceMatlList;
		} catch (Exception e) {
			log.error("条件查询应收材料信息失败！！");
			throw new ScubeBizException("条件查询应收材料信息失败！", e);
		}
	}

	// 分页查询
	@Override
	public Page findBPrdReceMatlByPage(int pageNo, int pageSize,
			BPrdReceMatl bPrdReceMatl) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		BPrdReceMatlExample matlExample = new BPrdReceMatlExample();
		Criteria criteria = matlExample.createCriteria();
		if (bPrdReceMatl != null) {
			// 复印件份数
			if (bPrdReceMatl.getCopyOrigNum() != null) {
				criteria.andCopyOrigNumEqualTo(bPrdReceMatl.getCopyOrigNum());
			}
			// 主键Id
			if (bPrdReceMatl.getId() != null
					&& bPrdReceMatl.getId().length() > 0) {
				criteria.andIdEqualTo(bPrdReceMatl.getId());
			}
			// 是否必需
			if (bPrdReceMatl.getIsNeedFlag() != null
					&& bPrdReceMatl.getIsNeedFlag().length() > 0) {
				criteria.andIsNeedFlagEqualTo(bPrdReceMatl.getIsNeedFlag());
			}
			// 原件份数
			if (bPrdReceMatl.getOrigNum() != null) {
				criteria.andOrigNumEqualTo(bPrdReceMatl.getOrigNum());
			}
			// 应收材料名称
			if (bPrdReceMatl.getReceMatlName() != null
					&& bPrdReceMatl.getReceMatlName().length() > 0) {
				criteria.andReceMatlNameLike("%"
						+ bPrdReceMatl.getReceMatlName() + "%");
			}
			// 应收材料类型
			if (bPrdReceMatl.getReceMatlType() != null
					&& bPrdReceMatl.getReceMatlType().length() > 0) {
				criteria.andReceMatlTypeEqualTo(bPrdReceMatl.getReceMatlType());
			}
		}
		try {
			page.setRecords(bPrdReceMatlDAO.selectByPage(matlExample, page));
			return page;
		} catch (Exception e) {
			log.error("分页查询应收材料信息失败！！");
			throw new ScubeBizException("分页查询应收材料信息失败！", e);
		}
	}

	// 根据idList批量查询
	@Override
	public List<BPrdReceMatl> selectByIdList(List<String> idList) throws ScubeBizException {
		List<BPrdReceMatl> list = new ArrayList<BPrdReceMatl>();
		if (idList == null) {
			return list;
		}
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatl> list1 = bPrdReceMatlDAO
					.selectByIdList(idList);

			for (com.huateng.scf.bas.prd.dao.model.BPrdReceMatl receMatl : list1) {
				BPrdReceMatl bpReceMatl = new BPrdReceMatl();
				try {
					BeanUtils.copyProperties(receMatl, bpReceMatl);
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常");
				}
				list.add(bpReceMatl);
			}
			return list;
		} catch (Exception e) {
			log.error("批量查询应收材料信息失败！！");
			throw new ScubeBizException("批量查询应收材料信息失败！", e);
		}
	}
	
	
	//根据集合:idList查询出对象Page
	@Override
	public Page selectByIdListToPage(int pageNo, int pageSize,
			List<String> idList) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		try {
			List<com.huateng.scf.bas.prd.dao.model.BPrdReceMatl> list = bPrdReceMatlDAO.selectByIdList(idList);
			page.setRecords(list);
			int totalRecord=0;
			if(list!=null&&list.size()>0){
				totalRecord=list.size();
			}
			page.setTotalRecord(totalRecord);
			return page;
		} catch (Exception e) {
			log.error("分页查询应收材料信息失败！！");
			throw new ScubeBizException("分页查询应收材料信息失败！", e);
		}
	}

}
