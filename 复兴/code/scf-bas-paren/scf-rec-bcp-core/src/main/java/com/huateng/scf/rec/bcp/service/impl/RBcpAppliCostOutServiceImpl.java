/**
 * 
 */
package com.huateng.scf.rec.bcp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.sys.dao.IBSysAcctBctlDAO;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.rec.bcp.dao.IRBcpAppliCostOutDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOutExample;
import com.huateng.scf.rec.bcp.model.RBcpAppliCostOut;
import com.huateng.scf.rec.bcp.service.IRBcpAppliCostOutService;
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
@Service("RBcpAppliCostOutServiceImpl")
public class RBcpAppliCostOutServiceImpl implements IRBcpAppliCostOutService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	// 业务申请费用信息
	@Resource(name = "IRBcpAppliCostOutDAO")
	IRBcpAppliCostOutDAO rBcpAppliCostOutDAO;
	// 用于页面费用网点转译
	@Resource(name = "IBSysAcctBctlDAO")
	IBSysAcctBctlDAO bSysAcctBctlDAO;

	@Override
	public RBcpAppliCostOut findRBcpAppliCostOutByKey(RBcpAppliCostOut rBcpAppliCostOut) {
		if (rBcpAppliCostOut != null && !"".equals(rBcpAppliCostOut)) {
			RBcpAppliCostOutExample rBcpAppliCostOutExample = new RBcpAppliCostOutExample();
			if (rBcpAppliCostOut.getAppno() != null && !"".equals(rBcpAppliCostOut.getAppno())) {
				rBcpAppliCostOutExample.createCriteria().andAppnoEqualTo(rBcpAppliCostOut.getAppno());
				List<com.huateng.scf.rec.bcp.dao.model.RBcpAppliCostOut> rBcpAppliCostOutList = rBcpAppliCostOutDAO
						.selectByExample(rBcpAppliCostOutExample);
				if (rBcpAppliCostOutList != null && rBcpAppliCostOutList.size() == 1) {
					RBcpAppliCostOut rBcpAppliCostOut2 = new com.huateng.scf.rec.bcp.model.RBcpAppliCostOut();
					BeanUtils.copyProperties(rBcpAppliCostOutList.get(0), rBcpAppliCostOut2);
					try {
						RSysAcctBctl rSysAcctBctl = bSysAcctBctlDAO.selectByPrimaryKey(rBcpAppliCostOut2.getBrcode());
						rBcpAppliCostOut2.setBrname(rSysAcctBctl.getBrname());
						return rBcpAppliCostOut2;
					} catch (Exception e) {
						throw new ScubeBizException("查询具体应收账款申请业务费用信息，转译费用收取网点名称失败！");
					}
				}
				return null;
			} else {
				throw new ScubeBizException("查询具体应收账款申请业务费用信息失败！");
			}
		} else {
			throw new ScubeBizException("查询具体应收账款申请业务费用信息,前台所传数据无效！");
		}
	}

}
