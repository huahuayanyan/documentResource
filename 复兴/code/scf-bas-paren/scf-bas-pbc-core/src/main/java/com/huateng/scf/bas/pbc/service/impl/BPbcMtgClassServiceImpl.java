/**
 * 
 */
package com.huateng.scf.bas.pbc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgClassDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClassExample;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClassExample.Criteria;
import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.model.BPbcMtgClassVO;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2017年4月11日下午3:22:58
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2017年4月11日下午3:22:58	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BPbcMtgClassServiceImpl")
public class BPbcMtgClassServiceImpl implements IBPbcMtgClassService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BPbcMtgClassDAO")
	IBPbcMtgClassDAO bPbcMtgClassDAO;

	/*
	 * 一级二级页面双联查询
	 */
	@Override
	public Page findBPbcMtgClassForTwoLevelSelect(int pageNo, int pageSize, BPbcMtgClassVO bPbcMtgClassVO) throws ScubeBizException {
		Page page = new Page(pageSize, pageNo, 0);
		// 1.数据校验
		if (bPbcMtgClassVO == null) {
			throw new ScubeBizException("前台所传参数无效！");
		}
		if(bPbcMtgClassVO.getAssociateOne() == null) bPbcMtgClassVO.setAssociateOne(true);
		if (bPbcMtgClassVO.getLevels().equals("2") && bPbcMtgClassVO.getAssociateOne()) {
			if (bPbcMtgClassVO.getParentCode() == null || "".equals(bPbcMtgClassVO.getParentCode())) {
				throw new ScubeBizException("请先通过查询按钮选择一级押品！");
			}
		}

		// 2.数据查询
		BPbcMtgClassExample bPbcMtgClassExample = new BPbcMtgClassExample();
		Criteria bPbcMtgClassCriteria = bPbcMtgClassExample.createCriteria();

		bPbcMtgClassCriteria.andLevelsEqualTo(bPbcMtgClassVO.getLevels());
		bPbcMtgClassCriteria.andStatusEqualTo("1");// 有效

		if (bPbcMtgClassVO.getLevels().equals("2") && bPbcMtgClassVO.getAssociateOne()) {
			bPbcMtgClassCriteria.andParentCodeEqualTo(bPbcMtgClassVO.getParentCode());
		}
		if (bPbcMtgClassVO.getMortgageName() != null && !"".equals(bPbcMtgClassVO.getMortgageName())) {
			bPbcMtgClassCriteria.andMortgageNameLike("%" + bPbcMtgClassVO.getMortgageName() + "%");
		}
		try {
			bPbcMtgClassDAO.selectByPage(bPbcMtgClassExample, page);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException("押品数据查询错误！");
		}

		return page;
	}
	
	@Override
	public boolean checkMtgInfo(Object mortgageCode, Object mortgageName, String errMsg) {
		
		if(StringUtil.isEmpty(mortgageCode) || StringUtil.isEmpty(mortgageName)){
			return false;
		}
		
		BPbcMtgClassVO bPbcMtgClassVO = new BPbcMtgClassVO();
		bPbcMtgClassVO.setMortgageCode(BigDecimal.valueOf(Double.valueOf(mortgageCode.toString())));
		bPbcMtgClassVO.setMortgageName(mortgageName.toString());
		int i = checkInfoForSelect(bPbcMtgClassVO);
		if(i != 1){
			if(errMsg != null){
				throw new ScubeBizException(errMsg);
			}else{
				return false;
			}
		}
		return true;
	}

	
	// 检验押品名称和押品号是否一致
	@Override
	public int checkInfoForSelect(BPbcMtgClassVO bPbcMtgClassVO) throws ScubeBizException {
		if (bPbcMtgClassVO == null || bPbcMtgClassVO.getMortgageCode() == null || bPbcMtgClassVO.getMortgageName() == null) {
			return 0;
		}
		BPbcMtgClassExample bPbcMtgClassExample = new BPbcMtgClassExample();
		Criteria bPbcMtgClassCriteria = bPbcMtgClassExample.createCriteria();
		bPbcMtgClassCriteria.andMortgageCodeEqualTo(bPbcMtgClassVO.getMortgageCode());
		bPbcMtgClassCriteria.andMortgageNameEqualTo(bPbcMtgClassVO.getMortgageName());
		List<BPbcMtgClass> BPbcMtgClassList = bPbcMtgClassDAO.selectByExample(bPbcMtgClassExample);
		if (BPbcMtgClassList != null && BPbcMtgClassList.size() == 1) {
			return 1;
		} else {
			return 0;
		}

	}

	/*
	 * 
	 * 根据押品代码转译押品名称
	 * 
	 */
	@Override
	public com.huateng.scf.bas.pbc.model.BPbcMtgClass translateMortgageNameByCode(String code) {
		if (code == null || "".equals(code)) {
			return null;
		}
		BPbcMtgClassExample bPbcMtgClassExample = new BPbcMtgClassExample();
		bPbcMtgClassExample.createCriteria().andMortgageCodeEqualTo(new BigDecimal(code));
		try {
			List<BPbcMtgClass> bPbcMtgClassList = bPbcMtgClassDAO.selectByExample(bPbcMtgClassExample);
			if (bPbcMtgClassList != null && bPbcMtgClassList.size() == 1) {
				com.huateng.scf.bas.pbc.model.BPbcMtgClass bPbcMtgClass = new com.huateng.scf.bas.pbc.model.BPbcMtgClass();
				BeanUtils.copyProperties(bPbcMtgClassList.get(0), bPbcMtgClass);
				return bPbcMtgClass;
			} else {
				return null;
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException("押品名称翻译失败！");
		}

	}

	/*
	 * 一级二级三级下拉菜单选择
	 */
	@Override
	public Page findBPbcMtgClassForThreeLevelSelect(int pageNo, int pageSize, BPbcMtgClassVO bPbcMtgClassVO) {
		Page page = new Page(pageSize, pageNo, 0);
		// 1.页面数据校验
		if (bPbcMtgClassVO == null) {
			return page;
		}
		BPbcMtgClassExample bPbcMtgClassExample = new BPbcMtgClassExample();
		Criteria bPbcMtgClassCriteria = bPbcMtgClassExample.createCriteria();
		// 一级押品代码存储在parentCode里面
		if (bPbcMtgClassVO.getLevels().equals("2")) {
			if (bPbcMtgClassVO.getParentCode() == null || "".equals(bPbcMtgClassVO.getParentCode())) {
				throw new ScubeBizException("请先通过查询按钮选择押品一级！");
			} else {
				bPbcMtgClassCriteria.andParentCodeEqualTo(bPbcMtgClassVO.getParentCode());
			}
		}
		// 二级押品代码存储在ext1里面
		if (bPbcMtgClassVO.getLevels().equals("3")) {
			if (bPbcMtgClassVO.getExt1() == null || "".equals(bPbcMtgClassVO.getExt1())) {
				throw new ScubeBizException("请先通过查询按钮选择押品二级！");
			} else {
				bPbcMtgClassCriteria.andParentCodeEqualTo(new BigDecimal(bPbcMtgClassVO.getExt1()));
			}

		}

		// 2.数据查询
		bPbcMtgClassCriteria.andLevelsEqualTo(bPbcMtgClassVO.getLevels());
		bPbcMtgClassCriteria.andStatusEqualTo("1");// 有效

		if (bPbcMtgClassVO.getMortgageName() != null && !"".equals(bPbcMtgClassVO.getMortgageName())) {
			bPbcMtgClassCriteria.andMortgageNameLike("%" + bPbcMtgClassVO.getMortgageName() + "%");
		}
		try {
			bPbcMtgClassDAO.selectByPage(bPbcMtgClassExample, page);
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new ScubeBizException("押品数据查询错误！");
		}

		return page;
	}

	/*
	 * 一级二级三级押品名称和代码一致性校验
	 */
	@Override
	public void checkInfoForThreeLevelsSelect(BPbcMtgBaseInfoVO bPbcMtgBaseInfoVO) {
		if (bPbcMtgBaseInfoVO == null) {
			throw new ScubeBizException("押品数据错误！");
		}
		// 一级
		BPbcMtgClassVO bPbcMtgClass1 = new BPbcMtgClassVO();
		bPbcMtgClass1.setMortgageCode(new BigDecimal(bPbcMtgBaseInfoVO.getMortgageLevelOne()));
		bPbcMtgClass1.setMortgageName(bPbcMtgBaseInfoVO.getMortgageLevelOneName());
		int one = this.checkInfoForSelect(bPbcMtgClass1);
		if (one != 1) {
			throw new ScubeBizException("押品一级押品号与押品名称不一致，请通过查询按钮选择押品一级！");
		}
		// 二级
		BPbcMtgClassVO bPbcMtgClass2 = new BPbcMtgClassVO();
		bPbcMtgClass2.setMortgageCode(new BigDecimal(bPbcMtgBaseInfoVO.getMortgageLevelTwo()));
		bPbcMtgClass2.setMortgageName(bPbcMtgBaseInfoVO.getMortgageLevelTwoName());
		int two = this.checkInfoForSelect(bPbcMtgClass2);
		if (two != 1) {
			throw new ScubeBizException("押品二级押品号与押品名称不一致，请通过查询按钮选择押品二级！");
		}
		// 三级
		BPbcMtgClassVO bPbcMtgClass3 = new BPbcMtgClassVO();
		bPbcMtgClass3.setMortgageCode(new BigDecimal(bPbcMtgBaseInfoVO.getMortgageLevelThree()));
		bPbcMtgClass3.setMortgageName(bPbcMtgBaseInfoVO.getMortgageLevelThreeName());
		int three = this.checkInfoForSelect(bPbcMtgClass3);
		if (three != 1) {
			throw new ScubeBizException("押品三级押品号与押品名称不一致，请通过查询按钮选择押品三级！");
		}
		return;
	}
	
	@Override
	public void checkInfoForTwoLevelsSelect(BPbcMtgBaseInfoVO bPbcMtgBaseInfoVO) {
		if (bPbcMtgBaseInfoVO == null) {
			throw new ScubeBizException("押品数据错误！");
		}
		// 一级
		BPbcMtgClassVO bPbcMtgClass1 = new BPbcMtgClassVO();
		bPbcMtgClass1.setMortgageCode(new BigDecimal(bPbcMtgBaseInfoVO.getMortgageLevelOne()));
		bPbcMtgClass1.setMortgageName(bPbcMtgBaseInfoVO.getMortgageLevelOneName());
		int one = this.checkInfoForSelect(bPbcMtgClass1);
		if (one != 1) {
			throw new ScubeBizException("押品一级押品号与押品名称不一致，请通过查询按钮选择押品一级！");
		}
		// 二级
		BPbcMtgClassVO bPbcMtgClass2 = new BPbcMtgClassVO();
		bPbcMtgClass2.setMortgageCode(new BigDecimal(bPbcMtgBaseInfoVO.getMortgageLevelTwo()));
		bPbcMtgClass2.setMortgageName(bPbcMtgBaseInfoVO.getMortgageLevelTwoName());
		int two = this.checkInfoForSelect(bPbcMtgClass2);
		if (two != 1) {
			throw new ScubeBizException("押品二级押品号与押品名称不一致，请通过查询按钮选择押品二级！");
		}
		// 三级
		if(StringUtil.isStrEmpty(bPbcMtgBaseInfoVO.getMortgageLevelThree()) && 
				StringUtil.isStrEmpty(bPbcMtgBaseInfoVO.getMortgageLevelThreeName())) return;
		BPbcMtgClassVO bPbcMtgClass3 = new BPbcMtgClassVO();
		bPbcMtgClass3.setMortgageCode(new BigDecimal(bPbcMtgBaseInfoVO.getMortgageLevelThree()));
		bPbcMtgClass3.setMortgageName(bPbcMtgBaseInfoVO.getMortgageLevelThreeName());
		int three = this.checkInfoForSelect(bPbcMtgClass3);
		if (three != 1) {
			throw new ScubeBizException("押品三级押品号与押品名称不一致，请通过查询按钮选择押品三级！");
		}
		return;
	}


}
