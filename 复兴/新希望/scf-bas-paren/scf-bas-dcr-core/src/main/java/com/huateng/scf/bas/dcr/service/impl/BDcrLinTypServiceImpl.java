package com.huateng.scf.bas.dcr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.dcr.dao.BDcrLinTypDAO;
import com.huateng.scf.bas.dcr.model.BDcrLinTyp;
import com.huateng.scf.bas.dcr.model.BDcrLinTypExample;
import com.huateng.scf.bas.dcr.model.BDcrLinTypExample.Criteria;
import com.huateng.scf.bas.dcr.service.BDcrLinTypService;
import com.huateng.scf.bas.dcr.vo.VbDcrLinTyp;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * BDcrLinTypr接口实现类
 *
 * @author huateng
 * @date 2016年7月6日
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * huateng			2016年7月6日			新增
 *
 *            </pre>
 */
@ScubeService
@Service
public class BDcrLinTypServiceImpl implements BDcrLinTypService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BDcrLinTypDAO")
	BDcrLinTypDAO bDcrLinTypDAO;

	@Override
	@Transactional
	public void add(VbDcrLinTyp vbDcrLinTyp) {
		if (vbDcrLinTyp == null || "".equals(vbDcrLinTyp)) {
			throw new ScubeBizException("前台所传数据无效！");
		}
		String errorMessage = "";
		// 验证新增额度类型编号,额度名称是否重复
		try {
			BDcrLinTyp dtyp = bDcrLinTypDAO.selectByPrimaryKey(vbDcrLinTyp.getCrId());
			if (null != dtyp) {
				errorMessage = errorMessage + "额度类型编号已存在，请重新输入！";
				throw new ScubeBizException("额度类型编号已存在，请重新输入！");
			}
			BDcrLinTypExample bDcrLinTypExample = new BDcrLinTypExample();
			bDcrLinTypExample.createCriteria().andCrNmEqualTo(vbDcrLinTyp.getCrNm());
			List<BDcrLinTyp> bDcrLinTypList = bDcrLinTypDAO.selectByExample(bDcrLinTypExample);
			if (bDcrLinTypList != null && bDcrLinTypList.size() > 0) {
				errorMessage = errorMessage + "该额度类型名称已存在，请重新输入！";
				throw new ScubeBizException("该额度类型名称已存在，请重新输入！");
			}
		} catch (Exception e) {
			if (errorMessage.equals("")) {
				throw new ScubeBizException("插入异常!", e);
			} else {
				throw new ScubeBizException(errorMessage);
			}
		}

		// VO转PO 展现层对象转换DAO层对象
		BDcrLinTyp bDcrLinTyp = new BDcrLinTyp();
		try {
			BeanUtils.copyProperties(vbDcrLinTyp, bDcrLinTyp);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常", e);
		}
		try {
			bDcrLinTypDAO.insertSelective(bDcrLinTyp);
		} catch (Exception e) {
			throw new ScubeBizException("插入异常", e);
		}
	}

	@Override
	@Transactional
	public int update(VbDcrLinTyp vbDcrLinTyp) throws ScubeBizException {
		if (vbDcrLinTyp == null || "".equals(vbDcrLinTyp)) {
			throw new ScubeBizException("前台所传数据无效！");
		}
		BDcrLinTyp bDcrLinTyp = new BDcrLinTyp();
		try {
			BeanUtils.copyProperties(vbDcrLinTyp, bDcrLinTyp);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常", e);
		}
		// 额度类型名称查重（防止额度编号不同，但是额度类型已存在，插入两个名称那个相同的信息）
		BDcrLinTypExample bDcrLinTypExample = new BDcrLinTypExample();
		Criteria bDcrLinTypCriteria = bDcrLinTypExample.createCriteria();
		bDcrLinTypCriteria.andCrIdEqualTo(vbDcrLinTyp.getCrId());
		bDcrLinTypCriteria.andCrNmEqualTo(vbDcrLinTyp.getCrNm());
		List<BDcrLinTyp> bDcrLinTypList = bDcrLinTypDAO.selectByExample(bDcrLinTypExample);
		if (bDcrLinTypList != null && bDcrLinTypList.size() == 1) {
			// 1.如果还能查到一条，说明页面没有修改额度名称，可以直接修改(页面额度编号只读无法修改)
			return bDcrLinTypDAO.updateByPrimaryKeySelective(bDcrLinTyp);
		} else {
			BDcrLinTypExample bDcrLinTypExample2 = new BDcrLinTypExample();
			Criteria bDcrLinTypCriteria2 = bDcrLinTypExample2.createCriteria();
			bDcrLinTypCriteria2.andCrNmEqualTo(vbDcrLinTyp.getCrNm());
			List<BDcrLinTyp> bDcrLinTypList2 = bDcrLinTypDAO.selectByExample(bDcrLinTypExample2);
			// 2.额度编号不同，但是额度名称已经有相同的数据，这时提醒额度名称已存在
			if (bDcrLinTypList2 != null && bDcrLinTypList2.size() > 0) {
				throw new ScubeBizException("该额度类型名称已存在，请重新输入！");
			} else {
				return bDcrLinTypDAO.updateByPrimaryKeySelective(bDcrLinTyp);
			}
		}
	}

	@Override
	@Transactional
	public int delete(String key) {
		// TODO Auto-generated method stub

		int i;
		try {
			i = bDcrLinTypDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			throw new ScubeBizException("删除异常", e);
		}
		return i;
	}

	@Override
	public Page findObjectConditionByPage(int pageNo, int pageSize, VbDcrLinTyp vbDcrLinTyp) {
		// int total = bDcrLinTypDAO.countByExample(new BDcrLinTypExample());
		Page p = new Page(pageSize, pageNo, 0);

		BDcrLinTypExample example = new BDcrLinTypExample();
		Criteria cri = example.createCriteria();
		if (vbDcrLinTyp != null) {
			if (vbDcrLinTyp.getCrId() != null && vbDcrLinTyp.getCrId().length() > 0) {
				cri.andCrIdEqualTo(vbDcrLinTyp.getCrId().trim());

			}
			if (vbDcrLinTyp.getCrNm() != null && vbDcrLinTyp.getCrNm().length() > 0) {
				cri.andCrNmLike("%" + vbDcrLinTyp.getCrNm().trim() + "%");

			}

		}

		bDcrLinTypDAO.selectByPage(example, p);
		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());
		return p;
	}

	@Override
	public VbDcrLinTyp findBDcrLinTypByKey(String key) {
		// TODO Auto-generated method stub
		// PO转VO DAO层对象转换 展现层对象
		BDcrLinTyp bDcrLinTyp = bDcrLinTypDAO.selectByPrimaryKey(key);
		VbDcrLinTyp vbDcrLinTyp = new VbDcrLinTyp();
		BeanUtils.copyProperties(bDcrLinTyp, vbDcrLinTyp);

		return vbDcrLinTyp;
	}

}
