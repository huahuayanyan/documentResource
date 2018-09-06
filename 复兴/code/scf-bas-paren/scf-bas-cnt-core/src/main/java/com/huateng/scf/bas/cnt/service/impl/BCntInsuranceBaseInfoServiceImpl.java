package com.huateng.scf.bas.cnt.service.impl;

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
import com.huateng.scf.bas.cnt.dao.IBCntInsuranceBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfoExample.Criteria;
import com.huateng.scf.bas.cnt.model.BCntInsuranceBaseInfo;
import com.huateng.scf.bas.cnt.service.IBCntInsuranceBaseInfoService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>
 * BCntInsuranceBaseInfo接口实现类
 * </p>
 *
 * @author mengjiajia
 * @date 2016年12月24日下午1:44:58
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月24日下午1:44:58	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCntInsuranceBaseInfoServiceImpl")
public class BCntInsuranceBaseInfoServiceImpl implements IBCntInsuranceBaseInfoService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private final static List<com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo> listinfo = new ArrayList<com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo>();

	@Resource(name = "IBCntInsuranceBaseInfoDAO")
	IBCntInsuranceBaseInfoDAO bcntinsurancebaseinfodao;

	@Override
	public void cacheAdd(BCntInsuranceBaseInfo bCntInsBaseInfo) {
		log.debug("开始缓存=============");
		String insuranceNo = UUIDGeneratorUtil.generate();
		bCntInsBaseInfo.setInsuranceNo(insuranceNo);
		com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo bCntInsBaseInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo();
		try {
			BeanUtils.copyProperties(bCntInsBaseInfo, bCntInsBaseInfodal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		listinfo.add(bCntInsBaseInfodal);
	}

	@Override
	@Transactional
	public void add(BCntInsuranceBaseInfo bCntInsBaseInfo) {
		log.debug("开始新增============");
		if (listinfo.size() > 0) {
			for (com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo baseinfo : listinfo) {
				try {
					bcntinsurancebaseinfodao.insertSelective(baseinfo);
				} catch (BeansException e) {
					throw new ScubeBizException("保存异常");
				}
			}
		}
		listinfo.clear();
	}

	@Override
	@Transactional
	public int update(BCntInsuranceBaseInfo bCntInsBaseInfo) {
		com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo bcntinsbaseinfodal = new com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo();
		try {
			BeanUtils.copyProperties(bCntInsBaseInfo, bcntinsbaseinfodal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		int i;
		try {
			i = bcntinsurancebaseinfodao.updateByPrimaryKeySelective(bcntinsbaseinfodal);
		} catch (BeansException e) {
			throw new ScubeBizException("保存异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(List<BCntInsuranceBaseInfo> list) {
		int rows = 0;
		if (list.size() > 0) {
			for (BCntInsuranceBaseInfo baseinfo : list) {
				String infoid = baseinfo.getInsuranceNo();
				com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo flaginfo = bcntinsurancebaseinfodao.selectByPrimaryKey(infoid);
				if (flaginfo != null) {
					rows += bcntinsurancebaseinfodao.deleteByPrimaryKey(baseinfo.getInsuranceNo());
				} else {
					if (listinfo.size() > 0)
						for (com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo cacheinfo : listinfo) {
							String cacheid = cacheinfo.getInsuranceNo();
							if (infoid.equals(cacheid)) {
								listinfo.remove(cacheinfo);
								rows++;
								break;
							}
						}
				}
			}
		}
		return rows;
	}

	@Override
	public Page findBCntInsuranceBaseInfoByPage(int pageNo, int pageSize, BCntInsuranceBaseInfo bCntInsBaseInfo, String cache) {
		if (cache.equals("0") || cache == "0") {
			listinfo.clear();
		}

		BCntInsuranceBaseInfoExample example = new BCntInsuranceBaseInfoExample();
		Criteria cri = example.createCriteria();
		if (bCntInsBaseInfo != null) {
			if (StringUtil.isStrNotEmpty(bCntInsBaseInfo.getSlaveContno())) {
				cri.andSlaveContnoEqualTo(bCntInsBaseInfo.getSlaveContno());
			}
		}

		int total = bcntinsurancebaseinfodao.countByExample(example) + listinfo.size();
		Page p = new Page(pageSize, pageNo, 0);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		List<com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo> listall = bcntinsurancebaseinfodao.selectByExample(example);
		List<com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo> list = bcntinsurancebaseinfodao.selectByPage(example, p);
		List<com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo> listdal = list;
		int allSize;
		if (pageNo == 1) {
			allSize = pageNo * pageSize;
		} else {
			allSize = (pageNo - 1) * pageSize;
		}
		if (list.size() == 0 && listall.size() == 0) {
			if (listinfo.size() <= pageSize) {
				if (listinfo.size() > 0) {
					listdal.addAll(listinfo);
				}
			} else {
				for (int i = 0; i < pageSize; i++) {
					listdal.add(listinfo.get(i));
				}
			}
		} else if (listall.size() > 0 && list.size() == 0) {
			if (listall.size() <= allSize) {
				int index = allSize - listall.size();
				for (int i = index; i < listinfo.size(); i++) {
					listdal.add(listinfo.get(i));
				}
			}
		} else if (list.size() > 0) {
			if (list.size() <= pageSize) {
				int index = pageSize - list.size();
				if (listinfo.size() <= index) {
					if (listinfo.size() > 0) {
						listdal.addAll(listinfo);
					}
				} else {
					for (int i = 0; i < index; i++) {
						listdal.add(listinfo.get(i));
					}
				}
			}
		}

		p.setRecords(listdal);
		p.setTotalRecord(total);
		log.info("p.toString()=" + p.toString());

		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 */
	@Override
	public Page findBCntInsuranceBaseInfoByContNo(int pageNo, int pageSize, BCntInsuranceBaseInfo bCntInsBaseInfo) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		if (bCntInsBaseInfo == null) {
			return page;
		}
		BCntInsuranceBaseInfoExample bCntInsuranceBaseInfoExample = new BCntInsuranceBaseInfoExample();
		Criteria InsuranceCriteria = bCntInsuranceBaseInfoExample.createCriteria();
		if (bCntInsBaseInfo.getSlaveContno() != null && !"".equals(bCntInsBaseInfo.getSlaveContno())) {
			InsuranceCriteria.andSlaveContnoEqualTo(bCntInsBaseInfo.getSlaveContno());
		} else {
			return page;
		}
		bcntinsurancebaseinfodao.selectByPage(bCntInsuranceBaseInfoExample, page);
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 */
	@Override
	@Transactional
	public void batchAddBCntInsurance(List<BCntInsuranceBaseInfo> bCntInsBaseInfoList, String slaveContno) throws ScubeBizException {

		if (bCntInsBaseInfoList == null || bCntInsBaseInfoList.size() == 0 || slaveContno == null || "".equals(slaveContno)) {
			throw new ScubeBizException("保险信息新增失败！");
		}
		for (com.huateng.scf.bas.cnt.model.BCntInsuranceBaseInfo bCntInsBaseInfo : bCntInsBaseInfoList) {
			com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo bCntInsBaseInfo2 = new com.huateng.scf.bas.cnt.dao.model.BCntInsuranceBaseInfo();
			BeanUtils.copyProperties(bCntInsBaseInfo, bCntInsBaseInfo2);
			bCntInsBaseInfo2.setInsuranceNo(UUIDGeneratorUtil.generate());
			bCntInsBaseInfo2.setSlaveContno(slaveContno);
			try {
				bcntinsurancebaseinfodao.insert(bCntInsBaseInfo2);
			} catch (BeansException e) {
				log.debug(e.getMessage());
				throw new ScubeBizException("保险信息新增失败！");
			}
		}
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.cnt.service.IBCntInsuranceBaseInfoService#
	 * deleteInsuranceBySlaveContno(java.lang.String)
	 */
	@Override
	@Transactional
	public int deleteInsuranceBySlaveContno(String slaveContno) {
		if (slaveContno == null || "".equals(slaveContno)) {
			throw new ScubeBizException("保险信息删除失败！");
		}
		BCntInsuranceBaseInfoExample bCntInsuranceBaseInfoExample = new BCntInsuranceBaseInfoExample();
		bCntInsuranceBaseInfoExample.createCriteria().andSlaveContnoEqualTo(slaveContno);
		int x = 0;
		try {
			x = bcntinsurancebaseinfodao.deleteByExample(bCntInsuranceBaseInfoExample);
		} catch (Exception e) {
			throw new ScubeBizException("保险信息删除失败！");
		}
		return x;
	}

}
