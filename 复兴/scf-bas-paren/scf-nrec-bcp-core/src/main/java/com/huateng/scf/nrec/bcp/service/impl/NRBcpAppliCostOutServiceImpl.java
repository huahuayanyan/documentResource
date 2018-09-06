/**
 * 
 */
package com.huateng.scf.nrec.bcp.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.authority.common.ContextHolder;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scf.bas.sys.dao.IBSysAcctBctlDAO;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.nrec.bcp.service.INRBcpAppliCostOutService;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliCostOutDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOutExample;
import com.huateng.scf.rec.bcp.model.RBcpAppliCostOut;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月24日下午3:38:23
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月24日下午3:38:23	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("NRBcpAppliCostOutServiceImpl")
public class NRBcpAppliCostOutServiceImpl implements INRBcpAppliCostOutService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	// 业务申请费用信息
	@Resource(name = "IRBcpAppliCostOutDAO")
	IRBcpAppliCostOutDAO rBcpAppliCostOutDAO;
	// 用于页面费用网点转译
	@Resource(name = "IBSysAcctBctlDAO")
	IBSysAcctBctlDAO bSysAcctBctlDAO;

	@Override
	public RBcpAppliCostOut findRBcpAppliCostOutByKey(RBcpAppliCostOut rBcpAppliCostOut) throws ScubeBizException {
		if (rBcpAppliCostOut == null) {
			throw new ScubeBizException("查询具体应收账款申请业务费用信息,前台所传数据无效！");
		}
		if (StringUtils.isEmpty(rBcpAppliCostOut.getAppno())) {
			throw new ScubeBizException("查询具体应收账款申请业务费用信息失败！");
		}
		RBcpAppliCostOutExample rBcpAppliCostOutExample = new RBcpAppliCostOutExample();
		RBcpAppliCostOutExample.Criteria cre = rBcpAppliCostOutExample.createCriteria();
		cre.andAppnoEqualTo(rBcpAppliCostOut.getAppno());
		List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut> rBcpAppliCostOutList = rBcpAppliCostOutDAO.selectByExample(rBcpAppliCostOutExample);
		if (rBcpAppliCostOutList != null && rBcpAppliCostOutList.size() == 1) {
			RBcpAppliCostOut rBcpAppliCostOut2 = new com.huateng.scf.rec.bcp.model.RBcpAppliCostOut();
			BeanUtils.copyProperties(rBcpAppliCostOutList.get(0), rBcpAppliCostOut2);
			if (StringUtils.isNotEmpty(rBcpAppliCostOut2.getBrcode())) {
				RSysAcctBctl rSysAcctBctl = bSysAcctBctlDAO.selectByPrimaryKey(rBcpAppliCostOut2.getBrcode());
				rBcpAppliCostOut2.setBrname(rSysAcctBctl.getBrname());
			}
			return rBcpAppliCostOut2;
		}
		return null;
	}

	@Override
	@Transactional
	public void addRBcpAppliCostOut(RBcpAppliCostOut rBcpAppliCostOut) throws ScubeBizException {
		if (rBcpAppliCostOut == null) {
			throw new ScubeBizException("所传数据无效，新增申请费用信息失败！");
		}
		String brcode = ContextHolder.getOrgInfo().getBrNo();// 经办机构
		String tlrcd = ContextHolder.getUserInfo().getTlrNo();// 操作员
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut rBcpAppliCostOut2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut();
		BeanUtils.copyProperties(rBcpAppliCostOut, rBcpAppliCostOut2);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String insertDate = simpleDateFormat.format(new Date());// 新增插入日期
		rBcpAppliCostOut2.setInsertDate(insertDate);// 登记时间
		rBcpAppliCostOut2.setId(UUIDGeneratorUtil.generate());// id
		rBcpAppliCostOut2.setTlrcd(tlrcd);
		// rBcpAppliCostOut2.setBrcode(brcode); 这里的brcode不是正常的近半机构，而是费用收取网点
		rBcpAppliCostOut2.setCommonDate(ScfBaseData.getScfGlobalInfoData().getTxnDate());// 登记时间
		rBcpAppliCostOutDAO.insert(rBcpAppliCostOut2);
	}

	@Override
	@Transactional
	public void updateRBcpAppliCostOut(RBcpAppliCostOut rBcpAppliCostOut) throws ScubeBizException {
		if (rBcpAppliCostOut == null) {
			throw new ScubeBizException("所传数据无效，修改申请费用信息失败！");
		}
		com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut rBcpAppliCostOut2 = new com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut();
		BeanUtils.copyProperties(rBcpAppliCostOut, rBcpAppliCostOut2);
		rBcpAppliCostOutDAO.updateByPrimaryKey(rBcpAppliCostOut2);
	}

}
