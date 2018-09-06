package com.huateng.scf.bas.cnt.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.IBCntSlaveMtgRelDAO;
import com.huateng.scf.bas.cnt.dao.ext.ExtIBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRelExample;
import com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRelExample.Criteria;
import com.huateng.scf.bas.cnt.model.BCntSlaveMtgRel;
import com.huateng.scf.bas.cnt.service.IBCntSlaveMtgRelService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.crr.service.IBCrrGntyConService;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BCntSlaveMtgRelServiceImpl")
public class BCntSlaveMtgRelServiceImpl implements IBCntSlaveMtgRelService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private final static List<com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel> listrel = new ArrayList<com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel>();
	@Resource(name = "IBCntSlaveMtgRelDAO")
	IBCntSlaveMtgRelDAO bcntslavemtgreldao;

	@Resource(name = "ExtBCntMprotBaseInfoDAO")
	ExtIBCntMprotBaseInfoDAO extIBCntMprotBaseInfoDAO;

	@Resource(name = "BCrrGntyConServiceImpl")
	IBCrrGntyConService bcrrgntyconservice;

	@Override
	public void cacheAdd(BCntSlaveMtgRel bCntSlaveMtgRel) {
		log.debug("开始缓存=============");
		String id = UUIDGeneratorUtil.generate();
		bCntSlaveMtgRel.setId(id);
		com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel bcntslavemtgreldal = new com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel();
		try {
			BeanUtils.copyProperties(bCntSlaveMtgRel, bcntslavemtgreldal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		listrel.add(bcntslavemtgreldal);
	}

	@Override
	@Transactional
	public void add(BCntSlaveMtgRel bCntSlaveMtgRel) {
		log.debug("开始新增=============");
		if (listrel.size() > 0) {
			for (com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel mtgRel : listrel) {
				try {
					bcntslavemtgreldao.insertSelective(mtgRel);
				} catch (BeansException e) {
					throw new ScubeBizException("保存异常");
				}
			}
		}
		listrel.clear();
	}

	@Override
	@Transactional
	public int update(BCntSlaveMtgRel bCntSlaveMtgRel) {
		com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel bcntslavemtgreldal = new com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel();
		try {
			BeanUtils.copyProperties(bCntSlaveMtgRel, bcntslavemtgreldal);
		} catch (BeansException e) {
			throw new ScubeBizException("转换异常");
		}
		int i;
		try {
			i = bcntslavemtgreldao.updateByPrimaryKeySelective(bcntslavemtgreldal);
		} catch (BeansException e) {
			throw new ScubeBizException("保存异常");
		}
		return i;
	}

	@Override
	@Transactional
	public int batchDelete(List<BCntSlaveMtgRel> list) {
		int rows = 0;
		if (list.size() > 0) {
			for (BCntSlaveMtgRel mtgrel : list) {
				String relid = mtgrel.getId();
				com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel flagrel = bcntslavemtgreldao.selectByPrimaryKey(relid);
				if (flagrel != null) {
					rows += bcntslavemtgreldao.deleteByPrimaryKey(relid);
				} else {
					if (listrel.size() > 0) {
						for (com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel cacherel : listrel) {
							String cacheid = cacherel.getId();
							if (relid.equals(cacheid)) {
								listrel.remove(cacherel);
								rows++;
								break;
							}
						}
					}
				}
			}
		}
		return rows;
	}

	@Override
	public Page findBCntSlaveMtgRelByPage(int pageNo, int pageSize, BCntSlaveMtgRel bCntSlaveMtgRel, String cache) {
		if (cache.equals("0") || cache == "0") {
			listrel.clear();
		}

		BCntSlaveMtgRelExample example = new BCntSlaveMtgRelExample();
		Criteria cri = example.createCriteria();
		if (bCntSlaveMtgRel != null) {
			if (StringUtil.isStrNotEmpty(bCntSlaveMtgRel.getSlaveContno())) {
				cri.andSlaveContnoEqualTo(bCntSlaveMtgRel.getSlaveContno());
			}
		}

		int total = bcntslavemtgreldao.countByExample(example) + listrel.size();
		Page p = new Page(pageSize, pageNo, total);

		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		List<com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel> listall = bcntslavemtgreldao.selectByExample(example);
		List<com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel> listpage = bcntslavemtgreldao.selectByPage(example, p);
		List<com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel> listdal = listpage;
		int allSize;
		if (pageNo == 1) {
			allSize = pageNo * pageSize;
		} else {
			allSize = (pageNo - 1) * pageSize;
		}
		if (listpage.size() == 0 && listall.size() == 0) {
			if (listrel.size() <= pageSize) {
				if (listrel.size() > 0) {
					listdal.addAll(listrel);
				}
			} else {
				for (int i = 0; i < pageSize; i++) {
					listdal.add(listrel.get(i));
				}
			}
		} else if (listall.size() > 0 && listpage.size() == 0) {
			if (listall.size() <= allSize) {
				int index = allSize - listall.size();
				for (int i = index; i < listrel.size(); i++) {
					listdal.add(listrel.get(i));
				}
			}
		} else if (listpage.size() > 0) {
			if (listpage.size() <= pageSize) {
				int index = pageSize - listpage.size();
				if (listrel.size() <= index) {
					if (listrel.size() > 0) {
						listdal.addAll(listrel);
					}
				} else {
					for (int i = 0; i < index; i++) {
						listdal.add(listrel.get(i));
					}
				}
			}
		}

		List<com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel> list = new ArrayList<com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel rel : listdal) {
				String one = rel.getMortgageLevelOne();
				String two = rel.getMortgageLevelTwo();
				List<BPbcMtgClass> oneList = extIBCntMprotBaseInfoDAO.queryBPbcMtgClassName(one);
				if (oneList.size() > 0) {
					String onename = oneList.get(0).getMortgageName();
					rel.setMortgageLevelOneNm(onename);
				}
				List<BPbcMtgClass> twoList = extIBCntMprotBaseInfoDAO.queryBPbcMtgClassName(two);
				if (twoList.size() > 0) {
					String twoname = twoList.get(0).getMortgageName();
					rel.setMortgageLevelTwoNm(twoname);
				}
				list.add(rel);
			}
		}
		p.setRecords(list);
		p.setTotalRecord(total);
		log.info("p.toString()=" + p.toString());

		return p;
	}

	@Override
	public Page findBPbcMtgClassByPage(int pageNo, int pageSize, HashMap<String, String> value) {
		Page p = new Page(pageSize, pageNo, 0);
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if (value != null) {
			String levels = "";
			if (StringUtil.isStrNotEmpty(value.get("levels"))) {
				levels = value.get("levels").toString().trim();
				omap.put("levels", value.get("levels").toString().trim());
			}
			if (StringUtil.isStrNotEmpty(value.get("parentCode"))) {
				omap.put("parentCode", BigDecimal.valueOf(Double.valueOf(value.get("parentCode").toString().trim())));
			} else {
				if (levels.equals("2") || levels == "2") {
					omap.put("parentCode", BigDecimal.valueOf(999999));
				}
			}
			if (StringUtil.isStrNotEmpty(value.get("mortgageCode"))) {
				omap.put("mortgageCode", BigDecimal.valueOf(Double.valueOf(value.get("mortgageCode").toString().trim())));
			}
			if (StringUtil.isStrNotEmpty(value.get("mortgageName"))) {
				omap.put("mortgageName", value.get("mortgageName").toString().trim());
			}
		}
		extIBCntMprotBaseInfoDAO.queryBPbcMtgClassList(omap, p);
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 */
	@Override
	public Page findBPbcMtgClassForMortage(int pageNo, int pageSize, BCntSlaveMtgRel bCntSlaveMtgRel) throws ScubeBizException {
		if (bCntSlaveMtgRel == null || bCntSlaveMtgRel.getSlaveContno() == null || "".equals(bCntSlaveMtgRel.getSlaveContno())) {
			return null;
		}
		Page page = new Page(pageSize, pageNo, 0);

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("slaveContno", bCntSlaveMtgRel.getSlaveContno());
		try {
			bcntslavemtgreldao.findOneAndTwoMortage(map, page);
		} catch (Exception e) {
			throw new ScubeBizException("押品信息查询失败！");
		}

		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.cnt.service.IBCntSlaveMtgRelService#
	 * batchAddSlaveMtgRel(java.util.List)
	 */
	@Override
	@Transactional
	public void batchAddSlaveMtgRel(List<BCntSlaveMtgRel> bCntSlaveMtgRel, String slaveContno) {
		if (bCntSlaveMtgRel == null || bCntSlaveMtgRel.size() == 0 || slaveContno == null || "".equals(slaveContno)) {
			throw new ScubeBizException("押品信息新增失败！");
		}
		for (com.huateng.scf.bas.cnt.model.BCntSlaveMtgRel mtgRel : bCntSlaveMtgRel) {
			com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel bCntSlaveMtgRel2 = new com.huateng.scf.bas.cnt.dao.model.BCntSlaveMtgRel();
			BeanUtils.copyProperties(mtgRel, bCntSlaveMtgRel2);
			bCntSlaveMtgRel2.setId(UUIDGeneratorUtil.generate());
			bCntSlaveMtgRel2.setSlaveContno(slaveContno);
			try {
				bcntslavemtgreldao.insert(bCntSlaveMtgRel2);
			} catch (BeansException e) {
				log.debug(e.getMessage());
				throw new ScubeBizException("押品信息新增失败！");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huateng.scf.bas.cnt.service.IBCntSlaveMtgRelService#
	 * deleteBySlaveContno(com.huateng.scf.bas.cnt.model.BCntSlaveMtgRel)
	 */
	@Override
	@Transactional
	public int deleteMtgRelBySlaveContno(String slaveContno) {
		if (slaveContno == null || "".equals(slaveContno)) {
			throw new ScubeBizException("押品信息删除失败！");
		}
		BCntSlaveMtgRelExample bCntSlaveMtgRelExample = new BCntSlaveMtgRelExample();
		Criteria createCriteria = bCntSlaveMtgRelExample.createCriteria();
		createCriteria.andSlaveContnoEqualTo(slaveContno);
		int x = 0;
		try {
			x = bcntslavemtgreldao.deleteByExample(bCntSlaveMtgRelExample);
		} catch (Exception e) {
			throw new ScubeBizException("押品信息删除失败！");
		}
		return x;
	}
}
