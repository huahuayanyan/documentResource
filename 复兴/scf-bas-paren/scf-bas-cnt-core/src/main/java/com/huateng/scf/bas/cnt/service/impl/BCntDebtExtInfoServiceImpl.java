/**
 * 
 */
package com.huateng.scf.bas.cnt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntErrorConstant;
import com.huateng.scf.bas.cnt.dao.IBCntDebtExtInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample.Criteria;
import com.huateng.scf.bas.cnt.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.service.IBCntDebtExtInfoService;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月8日下午7:54:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月8日下午7:54:07	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCntDebtExtInfoServiceImpl")
public class BCntDebtExtInfoServiceImpl implements IBCntDebtExtInfoService {

	@Resource(name = "BCntDebtExtInfoDAO")
	IBCntDebtExtInfoDAO iBCntDebtExtInfoDAO;
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bCrmBaseInfoService;

	// 查找具体应收账款融资交易对手信息（根据业务合同号）
	@Override
	public BCntDebtExtInfo findBCntDebtExtInfoByKey(BCntDebtExtInfo bCntDebtExtInfo) {
		if (bCntDebtExtInfo == null || "".equals(bCntDebtExtInfo)) {
			return null;
		}
		if (bCntDebtExtInfo.getBusinessNo() == null || "".equals(bCntDebtExtInfo.getBusinessNo())) {
			return null;
		}
		BCntDebtExtInfoExample example = new BCntDebtExtInfoExample();
		example.createCriteria().andBusinessNoEqualTo(bCntDebtExtInfo.getBusinessNo());
		try {
			List<com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo> list = iBCntDebtExtInfoDAO.selectByExample(example);
			if (list != null && list.size() == 1) {
				com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo bCntDebtExtInfo2 = list.get(0);
				BCntDebtExtInfo bCntDebtExtInfo3 = new BCntDebtExtInfo();
				try {
					BeanUtils.copyProperties(bCntDebtExtInfo2, bCntDebtExtInfo3);
					return bCntDebtExtInfo3;
				} catch (BeansException e) {
					throw new ScubeBizException("转换异常", e);
				}
			} else {// 查不到，就返回空数据。
				return null;
			}
		} catch (Exception e) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30002), BCntErrorConstant.SCF_BAS_CNT_30002);
		}

	}

	// 分页条件查询应收账款融资交易对手信息
	@Override
	public Page selectBCntDebtExtInfoByPage(int pageNo, int pageSize, BCntDebtExtInfo bCntDebtExtInfo) {
		BCntDebtExtInfoExample example = new BCntDebtExtInfoExample();
		Page p = new Page(pageSize, pageNo, 0);
		if (bCntDebtExtInfo != null) {
			Criteria criteria = example.createCriteria();
			// businessNo 业务合同号
			if (bCntDebtExtInfo.getBusinessNo() != null && bCntDebtExtInfo.getBusinessNo().length() > 0) {
				criteria.andBusinessNoEqualTo(bCntDebtExtInfo.getBusinessNo());
				// id
				if (bCntDebtExtInfo.getId() != null && bCntDebtExtInfo.getId().length() > 0) {
					criteria.andIdEqualTo(bCntDebtExtInfo.getId());
				}
				// 买方客户名称 buyerName
				if (bCntDebtExtInfo.getBuyerName() != null && bCntDebtExtInfo.getBuyerName().length() > 0) {
					criteria.andBuyerNameLike("%" + bCntDebtExtInfo.getBuyerName() + "%");
				}
				try {
					List<com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo> selectByPage = iBCntDebtExtInfoDAO.selectByPage(example, p);
					for (com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo bCntDebtExtInfo1 : selectByPage) {
						BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
						bCrmBaseInfo.setCustcd(bCntDebtExtInfo1.getBuyerCustcd());
						BCrmBaseInfo bCrmBaseInfo2 = bCrmBaseInfoService.findBCrmBaseInfoByKey(bCrmBaseInfo);
						bCntDebtExtInfo1.setBuyerName(bCrmBaseInfo2.getCname());
					}
					p.setRecords(selectByPage);
					return p;
				} catch (Exception e) {
					throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BCntErrorConstant.SCF_BAS_CNT_30001),
							BCntErrorConstant.SCF_BAS_CNT_30001);
				}

			} else {
				throw new ScubeBizException("请选择业务合同号");
			}
		} else {// 传空值给后台
			throw new ScubeBizException("请选择业务合同号");
		}
	}

	@Override
	public String selectBCntDebtExtInfoByBuyerNameBusinessNo(String businessNo, String buyerName) {
		BCntDebtExtInfoExample example = new BCntDebtExtInfoExample();
		Criteria criteria = example.createCriteria();
		// businessNo 业务合同号
		criteria.andBusinessNoEqualTo(businessNo);
		// 买方客户名称 buyerName
		criteria.andBuyerNameLike("%" + buyerName + "%");
		List<com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo> extinfo = iBCntDebtExtInfoDAO.selectByExample(example);
		if (extinfo.size() > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * DESCRIPTION:根据合同号、买方客户号查询保理扩展表
	 * 
	 * @author zhoujun.hou
	 * @date 2013-6-20 queryContDebtExInfoByMastContno 方法
	 * @param mastContno
	 * @param custcd
	 * @return
	 * @throws CommonException
	 * @param commonQueryVO
	 * @return
	 */
	@Override
	public BCntDebtExtInfo queryContDebtExInfoByMastContno(String mastContno, String custcd) throws ScubeBizException {
		BCntDebtExtInfoExample example = new BCntDebtExtInfoExample();
		BCntDebtExtInfoExample.Criteria cri = example.createCriteria();
		cri.andBusinessNoEqualTo(mastContno);
		cri.andBuyerCustcdEqualTo(custcd);
		List<com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo> list = iBCntDebtExtInfoDAO.selectByExample(example);
		BCntDebtExtInfo bCntDebtExtInfo = new BCntDebtExtInfo();
		if (list.size() > 0) {
			BeanUtils.copyProperties(list.get(0), bCntDebtExtInfo);

		}
		return bCntDebtExtInfo;
	}
}
