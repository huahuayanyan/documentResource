package com.huateng.scf.bas.cnt.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotInfoVO;
import com.huateng.scf.bas.cnt.model.BCntBuyInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotInfoExample.Criteria;
import com.huateng.scf.bas.cnt.service.IBCntBuyInfoService;
import com.huateng.scf.bas.cnt.service.IBCntMprotInfoService;
import com.huateng.scf.bas.cnt.service.IThreeProtocolService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.pbc.dao.IBPbcMtgClassDAO;
import com.huateng.scf.bas.pbc.dao.impl.BPbcMtgClassDAOImpl;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.model.BPbcMtgClassVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
import com.huateng.scf.bas.cnt.dao.IBCntMprotInfoDAO;

@ScubeService
@Service("BCntMprotInfoServiceImpl")
public class BCntMprotInfoServiceImpl implements IBCntMprotInfoService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BCntMprotInfoDAO")
	IBCntMprotInfoDAO bCntMprotInfoDAO;
	
	@Resource(name="ThreeProtocolServiceImpl")
	IThreeProtocolService iThreeProtocolService;
	
	@Resource(name="BCntBuyInfoServiceImpl")
	IBCntBuyInfoService iBCntBuyInfoService;

	/* 
	 * 新增一条BCntMprotInfo记录
	 */
	@Override
	public BCntMprotInfo addBCntMprotInfo(BCntMprotInfo bCntMprotInfo) throws ScubeBizException {
		
		com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo bCntBuyInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo();
		if(StringUtil.isEmpty(bCntMprotInfo.getMortgageNo())){
			String id = UUIDGeneratorUtil.generate(bCntMprotInfo);
			bCntMprotInfo.setMortgageNo(id);
		}
		try {
			BeanUtils.copyProperties(bCntMprotInfo, bCntBuyInfoDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}

		try {
			bCntMprotInfoDAO.insert(bCntBuyInfoDal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("保存新增信息失败！");
			throw new ScubeBizException("保存新增信息失败！", e);
		}

		return bCntMprotInfo;
	}

	@Transactional
	@Override
	public int updateBCntMprotInfo(BCntMprotInfo bCntMprotInfo) throws ScubeBizException {
		
		com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo bCntBuyInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo();

		try {
			BeanUtils.copyProperties(bCntMprotInfo, bCntBuyInfoDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		
		int i=0;
		try {
			i = bCntMprotInfoDAO.updateByPrimaryKey(bCntBuyInfoDal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("更新购销合同信息失败！");
			throw new ScubeBizException("更新购销合同信息失败！", e);
		}

		
		return i;
	}

	@Transactional
	@Override
	public int deleteByPrimaryKey(String key) throws ScubeBizException {
		int i =0;
		
		try {
			i = bCntMprotInfoDAO.deleteByPrimaryKey(key);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("更新购销合同信息失败！");
			throw new ScubeBizException("更新购销合同信息失败！", e);
		}
		
		return i;
	}

	@Override
	public BCntMprotInfo findBCntMprotInfoByKey(String key) throws ScubeBizException {
		BCntMprotInfo bCntMprotInfo = null;
		com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo bCntMprotInfodal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo();
		bCntMprotInfodal = bCntMprotInfoDAO.selectByPrimaryKey(key);
		if(bCntMprotInfodal!=null){
			bCntMprotInfo = new BCntMprotInfo();
			BeanUtils.copyProperties(bCntMprotInfodal, bCntMprotInfo);
		}
		return bCntMprotInfo;
	}
	
	@Override
	public Page findBCntMprotInfoByPage(int pageNo, int pageSize, BCntBuyInfo bCntBuyInfo)
			throws ScubeBizException {

		Page mprotPage = new Page();
		mprotPage.setPageNo(pageNo);
		mprotPage.setPageSize(pageSize);
		
		BCntMprotInfoExample example = new BCntMprotInfoExample();
		Criteria cri = example.createCriteria();
		if(bCntBuyInfo!=null){
			if(StringUtil.isStrNotEmpty(bCntBuyInfo.getTradeContno())){
				cri.andTradeContnoEqualTo(bCntBuyInfo.getTradeContno());
			}

		}

		bCntMprotInfoDAO.selectByPage(example, mprotPage);
		return mprotPage;
	}

/*	@Override
	public List<BCntMprotInfo> selectBCntMprotInfoByExample(BCntMprotInfoExample example) throws ScubeBizException {
		BCntMprotInfoExample exampleDal = new BCntMprotInfoExample();
		try {
			BeanUtils.copyProperties(example, exampleDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		List<BCntMprotInfo> listDal = new ArrayList<BCntMprotInfo>(); 
		List<BCntMprotInfo> list =bCntMprotInfoDAO.selectByExample(exampleDal);
		try {
			BeanUtils.copyProperties(listDal, list);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		return listDal;
	}*/

	@Transactional
	@Override
	public int deleteBCntMprotInfo(BCntMprotInfo bCntMprotInfo) throws ScubeBizException {
		
		int i =0;
		com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo bCntMprotInfoDal = new com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo();
		try {
			BeanUtils.copyProperties(bCntMprotInfo,bCntMprotInfoDal);
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("转换异常！");
			throw new ScubeBizException("转换异常", e);
		}
		
		try {
			i = bCntMprotInfoDAO.deleteByObject(bCntMprotInfoDal);
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("删除购销合同信息失败！");
			throw new ScubeBizException("删除购销合同信息失败！", e);
		}
		
		return i;
	}

	@Resource(name="BPbcMtgClassDAO")
	IBPbcMtgClassDAO bPbcMtgClassDAO;


	@Override
	public Page findBCntMprotInfoVOByPage(int pageNo, int pageSize, BCntBuyInfo bCntBuyInfo) throws ScubeBizException {
		
		
		Page mprotVOPage = new Page();
		mprotVOPage.setPageNo(pageNo);
		mprotVOPage.setPageSize(pageSize);
		
		BCntMprotInfoExample example = new BCntMprotInfoExample();
		Criteria cri = example.createCriteria();
		if(bCntBuyInfo!=null){
			if(StringUtil.isStrNotEmpty(bCntBuyInfo.getTradeContno())){
				cri.andTradeContnoEqualTo(bCntBuyInfo.getTradeContno());
			}

		}

		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo> result =bCntMprotInfoDAO.selectByPage(example, mprotVOPage);
		
		Iterator<com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo>  it =result.iterator();
		
		List<BCntMprotInfoVO> vOList = new ArrayList<BCntMprotInfoVO>();
		
		while(it.hasNext()){
			com.huateng.scf.bas.cnt.dao.model.BCntMprotInfo bCntMprotInfo = it.next();
			BCntMprotInfoVO bCntMprotInfoVO = new BCntMprotInfoVO();
			BeanUtils.copyProperties(bCntMprotInfo, bCntMprotInfoVO);
			if(StringUtils.isNotBlank(bCntMprotInfo.getMortgageLevelOne())){
				long levelOneCode = Long.valueOf(bCntMprotInfo.getMortgageLevelOne());
				BPbcMtgClass levelOneClass= bPbcMtgClassDAO.selectByPrimaryKey(BigDecimal.valueOf(levelOneCode));
				bCntMprotInfoVO.setMortgageLevelOneName(levelOneClass.getMortgageName());
			}
			if(StringUtils.isNotBlank(bCntMprotInfo.getMortgageLevelTwo())){
				long levelTwoCode = Long.valueOf(bCntMprotInfo.getMortgageLevelTwo());
				BPbcMtgClass levelTwoClass= bPbcMtgClassDAO.selectByPrimaryKey(BigDecimal.valueOf(levelTwoCode));
				bCntMprotInfoVO.setMortgageLevelTwoName(levelTwoClass.getMortgageName());
			}
			vOList.add(bCntMprotInfoVO);
		}
		
		mprotVOPage.setRecords(vOList);

		return mprotVOPage;
		
	}

}
