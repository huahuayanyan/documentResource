/**
 * 
 */
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

import com.huateng.scf.bas.prd.dao.IBPrdBaseInfoDAO;
import com.huateng.scf.bas.prd.model.BPrdBaseInfo;
import com.huateng.scf.bas.prd.service.IBPrdBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 * 
 * @author lihao
 * @date 2016年11月29日下午7:47:24
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 * 
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年11月29日下午7:47:24	      新增
 * 
 * </pre>
 */
@ScubeService
@Service("BPrdBaseInfoServiceImpl")
public class BPrdBaseInfoServiceImpl implements IBPrdBaseInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BPrdBaseInfoDAO")
	IBPrdBaseInfoDAO iBPrdBaseInfoDAO;

	// 产品基本信息新增
	@Override
	@Transactional
	public String add(BPrdBaseInfo bPrdBaseInfo) throws ScubeBizException {
		if (bPrdBaseInfo != null && bPrdBaseInfo.getProductId() != null
				&& bPrdBaseInfo.getProductId().length() > 0) {
			// 先查询库中是否已存在该条记录
			com.huateng.scf.bas.prd.dao.model.BPrdBaseInfo info = iBPrdBaseInfoDAO
					.selectByPrimaryKey(bPrdBaseInfo.getProductId());
			// 若存在，调用修改方法update();
			if (info != null) {
				this.update(bPrdBaseInfo);
				return null;
			}

			com.huateng.scf.bas.prd.dao.model.BPrdBaseInfo bPrdBaseInfo2 = new com.huateng.scf.bas.prd.dao.model.BPrdBaseInfo();
			try {
				BeanUtils.copyProperties(bPrdBaseInfo, bPrdBaseInfo2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			try {
				iBPrdBaseInfoDAO.insert(bPrdBaseInfo2);
				return null;
			} catch (Exception e) {
				log.error("新增产品基本信息失败！");
				throw new ScubeBizException("新增产品基本信息失败！", e);
			}
		} else {
			throw new ScubeBizException("新增产品基本信息失败！");
		}

	}

	// 产品基本信息删除
	@Override
	@Transactional
	public int delete(String productId) throws ScubeBizException {
		if (productId != null && productId.length() > 0) {
			try {
				return iBPrdBaseInfoDAO.deleteByPrimaryKey(productId);
			} catch (Exception e) {
				log.error("产品基本信息删除失败！");
				throw new ScubeBizException("产品基本信息删除失败！", e);
			}
		} else {
			throw new ScubeBizException("产品基本信息删除失败！");
		}

	}

	// 产品基本信息修改
	@Override
	@Transactional
	public int update(BPrdBaseInfo bPrdBaseInfo) throws ScubeBizException {
		if (bPrdBaseInfo != null && bPrdBaseInfo.getProductId().length() > 0) {
			// 重新创建一个对象，只接收loanWay、traStrue、finModel、productId、isUseAccessFlag,清除其他数据的缓存
			BPrdBaseInfo baseInfo = new BPrdBaseInfo();
			baseInfo.setLoanWay(bPrdBaseInfo.getLoanWay());
			baseInfo.setTraStrue(bPrdBaseInfo.getTraStrue());
			baseInfo.setProductId(bPrdBaseInfo.getProductId());
			baseInfo.setIsUseAccessFlag(bPrdBaseInfo.getIsUseAccessFlag());
			baseInfo.setFinModel(bPrdBaseInfo.getFinModel());
			com.huateng.scf.bas.prd.dao.model.BPrdBaseInfo bPrdBaseInfo2 = new com.huateng.scf.bas.prd.dao.model.BPrdBaseInfo();
			try {
				BeanUtils.copyProperties(baseInfo, bPrdBaseInfo2);
			} catch (BeansException e) {
				throw new ScubeBizException("转换异常");
			}
			try {
				return iBPrdBaseInfoDAO
						.updateByPrimaryKeySelective(bPrdBaseInfo2);
			} catch (Exception e) {
				log.error("产品基本信息修改失败！");
				throw new ScubeBizException("产品基本信息修改失败！", e);
			}

		} else {
			throw new ScubeBizException("产品基本信息修改失败！");
		}
	}

	// 查询具体产品基本信息（根据产品ID,若未查到，将参数本身bPrdBaseInfo返回.因此调用此方法时，尽量只传入productId）
	@Override
	public BPrdBaseInfo findBPrdBaseInfoByKey(BPrdBaseInfo bPrdBaseInfo)
			throws ScubeBizException {
		if (bPrdBaseInfo != null && !"".equals(bPrdBaseInfo)) {
			if (bPrdBaseInfo.getProductId() != null
					&& bPrdBaseInfo.getProductId().length() > 0) {
				try {
					com.huateng.scf.bas.prd.dao.model.BPrdBaseInfo prdBaseInfo = iBPrdBaseInfoDAO
							.selectByPrimaryKey(bPrdBaseInfo.getProductId());
					if (prdBaseInfo != null) {
						List<String> loanWay = new ArrayList<String>();
						if ("1".equals(prdBaseInfo.getAdvGoldPriceFlag())) {
							loanWay.add("00");
						}
						if ("1".equals(prdBaseInfo.getLoansFlag())) {
							loanWay.add("01");
						}
						if ("1".equals(prdBaseInfo.getAcceptanceFlag())) {
							loanWay.add("02");
						}
						if ("1".equals(prdBaseInfo.getGuaranteeLetterFlag())) {
							loanWay.add("03");
						}
						if ("1".equals(prdBaseInfo.getIsnfinGuaLetFlag())) {
							loanWay.add("04");
						}
						if ("1".equals(prdBaseInfo.getCommercialDiscountFlag())) {
							loanWay.add("05");
						}
						if ("1".equals(prdBaseInfo.getCreditrLetterFlag())) {
							loanWay.add("06");
						}
						prdBaseInfo.setLoanWay(loanWay);
						try {
							BeanUtils.copyProperties(prdBaseInfo, bPrdBaseInfo);
						} catch (BeansException e) {
							throw new ScubeBizException("转换异常");
						}
					}
				} catch (Exception e) {
					throw new ScubeBizException("条件查询产品基本信息失败！");
				}
			} else {
				throw new ScubeBizException("所传对象无产品号，条件查询产品基本信息失败！");
			}
		}
		return bPrdBaseInfo;

	}

}
