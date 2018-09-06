/**
 * 
 */
package com.huateng.scf.bas.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.sys.dao.IBSysRegionDAO;
import com.huateng.scf.bas.sys.dao.model.BSysRegionExample;
import com.huateng.scf.bas.sys.model.BSysRegion;
import com.huateng.scf.bas.sys.service.IBSysRegionService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年11月22日上午9:23:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年11月22日上午9:23:21	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("IBSysRegionServiceImpl")
public class BSysRegionServiceImpl implements IBSysRegionService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BSysRegionDAO")
	IBSysRegionDAO iBSysRegionDAO;

	// 新增区域信息
	@Override
	@Transactional
	public String add(BSysRegion bSysRegion) {
		com.huateng.scf.bas.sys.dao.model.BSysRegion bSysRegion2 = new com.huateng.scf.bas.sys.dao.model.BSysRegion();
		BeanUtils.copyProperties(bSysRegion, bSysRegion2);
		bSysRegion2.setId(UUIDGeneratorUtil.generate());
		try {
			iBSysRegionDAO.insert(bSysRegion2);
			return null;
		} catch (Exception e) {
			log.error("区域信息新增失败！");
			throw new ScubeBizException("区域信息新增失败！", e);
		}
	}

	// 查询区域信息集合，空值参数，返回所有。(根据regionCode,regionName。客户代码和客户名称。)
	@Override
	public List<BSysRegion> findBSysRegionByBCrm(BSysRegion bSysRegion) {
		BSysRegionExample example = new BSysRegionExample();
		com.huateng.scf.bas.sys.dao.model.BSysRegionExample.Criteria cri = example.createCriteria();
		if (bSysRegion != null && !"".equals(bSysRegion)) {// 根据客户代码和客户名称
			if (bSysRegion.getRegionCode() != null && !"".equals(bSysRegion.getRegionCode())) {
				cri.andRegionCodeEqualTo(bSysRegion.getRegionCode());
			}
			if (bSysRegion.getRegionName() != null && !"".equals(bSysRegion.getRegionName())) {
				cri.andRegionNameLike("%" + bSysRegion.getRegionName() + "%");
			}
		}
		try {
			List<com.huateng.scf.bas.sys.dao.model.BSysRegion> moniEntList = iBSysRegionDAO.selectByExample(example);
			List<BSysRegion> moniEntInfolist = new ArrayList<BSysRegion>();
			for (com.huateng.scf.bas.sys.dao.model.BSysRegion BSysRegion1 : moniEntList) {
				BSysRegion BSysRegion2 = new BSysRegion();
				BeanUtils.copyProperties(BSysRegion1, BSysRegion2);
				moniEntInfolist.add(BSysRegion2);
			}
			return moniEntInfolist;
		} catch (Exception e) {
			throw new ScubeBizException("查询区域信息集合失败！");
		}
	}

	// 条件分页查询区域信息，空值参数，返回所有。
	@Override
	public Page findBSysRegionByPage(int pageNo, int pageSize, BSysRegion bSysRegion) {
		Page p = new Page(pageSize, pageNo, 0);
		BSysRegionExample example = new BSysRegionExample();
		com.huateng.scf.bas.sys.dao.model.BSysRegionExample.Criteria cri = example.createCriteria();
		
		if (bSysRegion != null && !"".equals(bSysRegion)) {// 根据客户代码和客户名称
			String flag=bSysRegion.getFlag();
			if(StringUtils.isNotEmpty(flag)&&
					!"1".equals(flag)&&
					StringUtils.isEmpty(bSysRegion.getUpCode())){
				p.setRecords(new ArrayList<BSysRegion>());
 				return p;
			}
			if (StringUtils.isNotEmpty(bSysRegion.getRegionCode())) {
				cri.andRegionCodeEqualTo(bSysRegion.getRegionCode());
			}else{
				if("1".equals(flag)){
					cri.andRegionCodeLike("%0000");
				}else if("2".equals(flag)){
					cri.andRegionCodeLike(bSysRegion.getUpCode().substring(0, 2)+"__00");
					cri.andRegionCodeNotEqualTo(bSysRegion.getUpCode());
				}else if("3".equals(flag)){
					cri.andRegionCodeLike(bSysRegion.getUpCode().substring(0, 4)+"%");
					cri.andRegionCodeNotEqualTo(bSysRegion.getUpCode());
				}
			}
			if (StringUtils.isNotEmpty(bSysRegion.getRegionName())) {
				cri.andRegionNameLike("%" + bSysRegion.getRegionName() + "%");
			}
		}
		try {
			p.setRecords(iBSysRegionDAO.selectByPage(example, p));
			return p;
		} catch (Exception e) {
			log.error("条件分页查询区域信息失败！");
			throw new ScubeBizException("条件分页查询区域信息失败！", e);
		}
	}

}
