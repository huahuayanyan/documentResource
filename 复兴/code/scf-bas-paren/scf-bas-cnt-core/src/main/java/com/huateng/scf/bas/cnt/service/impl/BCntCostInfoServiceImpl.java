/**
 * 
 */
package com.huateng.scf.bas.cnt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.dao.IBCntCostInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntCostInfoExample;
import com.huateng.scf.bas.cnt.model.BCntCostInfo;
import com.huateng.scf.bas.cnt.service.IBCntCostInfoService;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.nbas.prd.model.BCntCostInfoVO;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月20日下午7:21:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月20日下午7:21:17	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCntCostInfoServiceImpl")
public class BCntCostInfoServiceImpl implements IBCntCostInfoService {
	@Resource(name = "BCntCostInfoDAO")
	IBCntCostInfoDAO iBCntCostInfoDAO;

	@Override
	public Page findBCntCostInfoByPage(int pageNo, int pageSize, BCntCostInfo bCntCostInfo) throws ScubeBizException {
		BCntCostInfoExample example = new BCntCostInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntCostInfoExample.Criteria criteria = example.createCriteria();
		Page p = new Page(pageSize, pageNo, 0);
		// 查询条件
		if (bCntCostInfo != null) {
			if (bCntCostInfo.getRelaNo() != null && !"".equals(bCntCostInfo.getRelaNo())) {
				criteria.andRelaNoEqualTo(bCntCostInfo.getRelaNo());
			}
			try {
				p.setRecords(iBCntCostInfoDAO.selectByPage(example, p));
			} catch (Exception e) {
				throw new ScubeBizException("应收账款费用信息分页条件查询失败！", e);
			}
		}
		return p;
	}

	@Override
	public BCntCostInfo findBCntCostInfoByKey(BCntCostInfo bCntCostInfo) throws ScubeBizException {
		if (bCntCostInfo != null && !"".equals(bCntCostInfo)) {
			BCntCostInfoExample example = new BCntCostInfoExample();
			BCntCostInfoExample.Criteria createCriteria = example.createCriteria();
			if (bCntCostInfo.getId() != null && !"".equals(bCntCostInfo.getId())) {
				createCriteria.andIdEqualTo(bCntCostInfo.getId());
			}
			if (bCntCostInfo.getRelaNo() != null && !"".equals(bCntCostInfo.getRelaNo())) {
				createCriteria.andRelaNoEqualTo(bCntCostInfo.getRelaNo());
			}
			try {
				List<com.huateng.scf.bas.cnt.dao.model.BCntCostInfo> bCntCostInfoList = iBCntCostInfoDAO.selectByExample(example);
				if (bCntCostInfoList != null && bCntCostInfoList.size() == 1) {
					BeanUtils.copyProperties(bCntCostInfoList.get(0), bCntCostInfo);
					return bCntCostInfo;
				} else {
					throw new ScubeBizException("应收账款费用信息条件查询具体信息失败，信息不唯一！");
				}
			} catch (Exception e) {
				throw new ScubeBizException("应收账款费用信息条件查询具体信息失败！", e);
			}
		} else {
			return null;
		}
	}

	/**
	 * @Description: 根据关联业务合同号和费用代码查询费用信息
	 * @author xiong_xiaolong
	 * @Created 2013-8-2上午10:59:00
	 * @param costQryVO
	 * @return
	 * @throws CommonException
	 */
	@Override
	public BCntCostInfo getTblCostInfoByBusniessNoAndCostCode(String realNo, String costCode) throws ScubeBizException {
		BCntCostInfoExample example = new BCntCostInfoExample();
		BCntCostInfoExample.Criteria cri = example.createCriteria();
		cri.andRelaNoEqualTo(realNo);
		cri.andCostCodeEqualTo(costCode);
		List<com.huateng.scf.bas.cnt.dao.model.BCntCostInfo> list = iBCntCostInfoDAO.selectByExample(example);
		BCntCostInfo bCntCostInfo = new BCntCostInfo();
		if (list == null || list.size() != 1) {
			throw new ScubeBizException("费用信息不存在！", RBcpErrorConstant.RECORD_NOT_EXIST);
		}
		if (list.size() > 0) {
			BeanUtils.copyProperties(list.get(0), bCntCostInfo);
		}
		return bCntCostInfo;
	}

/**================================mengjiajia费用信息操作	start====================================**/
	/**
	 * 根据关联编号查询费用信息
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月19日下午2:41:29
	 */
	@Override
	public BCntCostInfoVO findBCntCostInfoByRelaNo(String mastContno)
	{
		BCntCostInfoVO infoVO = null;
		BCntCostInfoExample example = new BCntCostInfoExample();
		BCntCostInfoExample.Criteria cri = example.createCriteria();
		cri.andRelaNoEqualTo(mastContno);
		List<com.huateng.scf.bas.cnt.dao.model.BCntCostInfo> costinfo = 
				iBCntCostInfoDAO.selectByExample(example);
		if(costinfo!=null&&costinfo.size()>0)
		{
			infoVO = new BCntCostInfoVO();
			BeanUtils.copyProperties(costinfo.get(0), infoVO);
		}
		return infoVO;
	}
	
	/**
	 * 新增费用信息
	 * @param bCntCostInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月19日下午2:50:46
	 */
	@Override
	@Transactional
	public void addBCntCostInfo(BCntCostInfoVO bCntCostInfoVO)
	{
		com.huateng.scf.bas.cnt.dao.model.BCntCostInfo cntCostInfo = 
				new com.huateng.scf.bas.cnt.dao.model.BCntCostInfo();
		try
		{
			BeanUtils.copyProperties(bCntCostInfoVO, cntCostInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		cntCostInfo.setId(UUIDGeneratorUtil.generate());
		cntCostInfo.setRelaType(BCntBizConstant.COST_INFO_RELA_TYPE_CONT);
		try
		{
			iBCntCostInfoDAO.insertSelective(cntCostInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
	
	/**
	 * 修改费用信息
	 * @param bCntCostInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年6月19日下午2:55:53
	 */
	@Override
	@Transactional
	public void updateBCntCostInfo(BCntCostInfoVO bCntCostInfoVO)
	{
		com.huateng.scf.bas.cnt.dao.model.BCntCostInfo cntCostInfo = 
				new com.huateng.scf.bas.cnt.dao.model.BCntCostInfo();
		try
		{
			BeanUtils.copyProperties(bCntCostInfoVO, cntCostInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			iBCntCostInfoDAO.updateByPrimaryKeySelective(cntCostInfo);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("保存异常");
		}
	}
	/**================================mengjiajia费用信息操作	end==================================**/
}
