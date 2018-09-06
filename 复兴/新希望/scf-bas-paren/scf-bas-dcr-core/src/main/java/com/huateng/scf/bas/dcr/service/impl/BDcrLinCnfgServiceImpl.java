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
import com.huateng.scf.bas.dcr.dao.BDcrLinCnfgDAO;
import com.huateng.scf.bas.dcr.model.BDcrLinCnfg;
import com.huateng.scf.bas.dcr.model.BDcrLinCnfgExample;
import com.huateng.scf.bas.dcr.model.BDcrLinCnfgExample.Criteria;
import com.huateng.scf.bas.dcr.service.BDcrLinCnfgService;
import com.huateng.scf.bas.dcr.vo.VbDcrLinCnfg;
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
public class BDcrLinCnfgServiceImpl implements BDcrLinCnfgService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BDcrLinCnfgDAO")
	BDcrLinCnfgDAO bDcrLinCnfgDAO;

	@Override
	@Transactional
	public void add(VbDcrLinCnfg vbDcrLinCnfg) {
		// bDcrLinTyp.setCrId(UUID.randomUUID().toString().replaceAll("\\-",
		// ""));
		// TODO Auto-generated method stub
		//验证检查类型ID是否重复
		BDcrLinCnfg dcnfg = bDcrLinCnfgDAO.selectByPrimaryKey(vbDcrLinCnfg.getTypId());
		if(null!=dcnfg)
		{
			throw new ScubeBizException("检查类型ID重复，请重新输入！");
		}
		// VO转PO 展现层对象转换DAO层对象
		BDcrLinCnfg bDcrLinCnfg = new BDcrLinCnfg();
		try {
			BeanUtils.copyProperties(vbDcrLinCnfg, bDcrLinCnfg);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常", e);
		}
		try {
			bDcrLinCnfgDAO.insertSelective(bDcrLinCnfg);
		} catch (Exception e) {
			throw new ScubeBizException("插入异常", e);
		}
	}

	@Override
	@Transactional
	public int update(VbDcrLinCnfg vbDcrLinCnfg) {
		// TODO Auto-generated method stub
		// VO转PO 展现层对象转换DAO层对象
		BDcrLinCnfg bDcrLinCnfg = new BDcrLinCnfg();
		try {
			BeanUtils.copyProperties(vbDcrLinCnfg, bDcrLinCnfg);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常", e);
		}
		int i;
		try {
			i = bDcrLinCnfgDAO.updateByPrimaryKeySelective(bDcrLinCnfg);
		} catch (Exception e) {
			throw new ScubeBizException("更新异常", e);
		}

		return i;
	}

	@Override
	@Transactional
	public int delete(String key) {
		// TODO Auto-generated method stub

		int i;
		try {
			i = bDcrLinCnfgDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			throw new ScubeBizException("删除异常", e);
		}

		return i;
	}

	@Override
	public Page findObjectConditionByPage(int pageNo, int pageSize, VbDcrLinCnfg vbDcrLinCnfg) {
		Page p = new Page(pageSize, pageNo, 0);
		BDcrLinCnfgExample example = new BDcrLinCnfgExample();
		Criteria cri = example.createCriteria();
		if (vbDcrLinCnfg != null) {
			if (vbDcrLinCnfg.getTypId() != null && vbDcrLinCnfg.getTypId().length() > 0) {
				cri.andTypIdEqualTo(vbDcrLinCnfg.getTypId().trim());

			}
			if (vbDcrLinCnfg.getTypNm() != null && vbDcrLinCnfg.getTypNm().length() > 0) {
				cri.andTypNmLike("%" + vbDcrLinCnfg.getTypNm().trim() + "%");

			}

		}


		bDcrLinCnfgDAO.selectByPage(example, p);
		log.debug("totalPage=" + p.getTotalPage());
		log.debug("totalRecord=" + p.getTotalRecord());
		log.debug("current=" + p.getCurrent());
		return p;
	}

	@Override
	public List queryTypId() {
		//BDcrLinCnfgExample example = new BDcrLinCnfgExample();
	    List<BDcrLinCnfg> bDcrLinCnfglist=bDcrLinCnfgDAO.selectByExample(null);		
		return bDcrLinCnfglist;
	}
	


}
