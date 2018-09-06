/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.rec.bcp.constant.RBcpDebtConstant;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.dao.IRBcpDebtBaseInfoDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample;
import com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfoExample.Criteria;
import com.huateng.scf.rec.bcp.model.RBcpDebtBaseInfo;
import com.huateng.scf.rec.bcp.service.IIfspRBcpDebtBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>应收账款查询接口
 * </p>
 *
 * @author zhangcheng
 * @date 2017年3月7日上午10:12:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * zhangcheng		017年3月7日上午10:12:46	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("IfspRBcpDebtBaseInfoServiceImpl")
public class IfspRBcpDebtBaseInfoServiceImpl implements IIfspRBcpDebtBaseInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "IRBcpDebtBaseInfoDAO")
	IRBcpDebtBaseInfoDAO iRBcpDebtBaseInfoDAO;
	// 产品工厂转译业务品种名称
	@Resource(name = "bPrdInfoService")
	IBPrdInfoService iBPrdInfoService;
	/**
	 * 可融资应收账款查询
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Override
	public Page getDebtInfoForFinace(int pageNo, int pageSize, String mastContno) {
		Page p = new Page(pageSize, pageNo, 0);
		RBcpDebtBaseInfoExample example = new RBcpDebtBaseInfoExample();
		Criteria cri = example.createCriteria();
		if (StringUtil.isEmpty(mastContno)) {
			log.info("mastContno不能为空");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_30000), BLanErrorConstant.SCF_BAS_LAN_30000);
		}
			// 1.（业务合同编号）mastContno）
			cri.andMastContnoEqualTo(mastContno);
			// 2.状态
            cri.andStatusEqualTo(RBcpDebtConstant.BILLS_STATUS_PURCHASED);
        	// 3.bussType 业务品种
			cri.andBussTypeEqualTo(RBcpDebtConstant.PRODUCT_TYPE_DEBT_POOL);
			// 4.锁定状态 isLocked
			cri.andIsLockedEqualTo(RBcpDebtConstant.UNLOCKED);
			// 5.商纠状态 issueFlag
			cri.andIssueFlagEqualTo(RBcpDebtConstant.ISSUE_FLAG_FALSE);
			// 6.瑕疵 flawFlag
			cri.andFlawFlagEqualTo(RBcpDebtConstant.FLAW_FLAG_FALSE);
			// 7. poolFlag add yyl
			cri.andPoolFlagEqualTo(RBcpDebtConstant.POOL_FLAG_IN_POOL);
			// 8.factType 保理类型
			cri.andFactTypeEqualTo(RBcpDebtConstant.FACT_TYPE_DEBT_POOL);
				
		try {
			example.setOrderByClause(" INSERT_DATE desc");// 按照登记日期排序
			// 业务品种实际存储的是产品ID，到产品中查询就行了。
			List<com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo> rBcpDebtBaseInfoList = iRBcpDebtBaseInfoDAO.selectByPage(example, p);
		    List rBcpDebtBaseInfoList1=new ArrayList();
			if (rBcpDebtBaseInfoList != null && rBcpDebtBaseInfoList.size() > 0) {
				try {// 业务产品名称转译
					for (com.huateng.scf.rec.bcp.dao.model.RBcpDebtBaseInfo rBcpDebtBaseInfo1 : rBcpDebtBaseInfoList) {
						// 查询对应的业务产品名称 bussTypeName iBPrdInfoService
						BPrdInfo bPrdInfo = new BPrdInfo();
						bPrdInfo.setProductId(rBcpDebtBaseInfo1.getBussType());
						BPrdInfo bPrdInfo2 = iBPrdInfoService.findBPrdInfoByKey(bPrdInfo);
						rBcpDebtBaseInfo1.setBussTypeName(bPrdInfo2.getProductName());
						RBcpDebtBaseInfo rBcpDebtBaseInfo=new RBcpDebtBaseInfo();
						BeanUtils.copyProperties(rBcpDebtBaseInfo1, rBcpDebtBaseInfo);
						rBcpDebtBaseInfoList1.add(rBcpDebtBaseInfo);
					}
				} catch (Exception e) {
					throw new ScubeBizException(
							com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10010),
							RBcpErrorConstant.SCF_REC_BCP_10010);
				}
			}
			p.setRecords(rBcpDebtBaseInfoList1);
			return p;
		} catch (Exception e) {// 10009- 条件分页查询条件分页查询应收账款信息失败
			log.error("条件分页查询条件分页查询应收账款信息失败！");
			throw new ScubeBizException(com.huateng.scf.bas.common.startup.ScfMessageUtil.transErrMsgByKey(RBcpErrorConstant.SCF_REC_BCP_10009),
					RBcpErrorConstant.SCF_REC_BCP_10009);
		}
}
}