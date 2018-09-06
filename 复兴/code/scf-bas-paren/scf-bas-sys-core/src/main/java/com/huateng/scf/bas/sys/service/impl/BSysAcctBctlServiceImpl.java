/**
 * 
 */
package com.huateng.scf.bas.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.IBSysAcctBctlDAO;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctl;
import com.huateng.scf.bas.sys.dao.model.RSysAcctBctlExample;
import com.huateng.scf.bas.sys.model.BSysAcctBctl;
import com.huateng.scf.bas.sys.service.IBSysAcctBctlService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月21日下午2:53:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月21日下午2:53:42	      新增
 *
 *            </pre>
 */
@ScubeService
@Service("BSysAcctBctlServiceImpl")
public class BSysAcctBctlServiceImpl implements IBSysAcctBctlService {
	@Resource(name = "IBSysAcctBctlDAO")
	IBSysAcctBctlDAO iBSysAcctBctlDAO;

	// 用于页面下拉菜单费用收取网店查询
	@Override
	public Page findBSysAcctBctlByPage(int pageNo, int pageSize, BSysAcctBctl bSysAcctBctl) {
		Page p = new Page(pageSize, pageNo, 0);
		RSysAcctBctlExample bSysAcctBctlExample = new RSysAcctBctlExample();
		if (bSysAcctBctl != null && !"".equals(bSysAcctBctl)) {
			// 机构号
			if (bSysAcctBctl.getBrcode() != null && !"".equals(bSysAcctBctl.getBrcode())) {
				bSysAcctBctlExample.createCriteria().andBrcodeEqualTo(bSysAcctBctl.getBrcode());
			}
			// 外部机构号
			if (bSysAcctBctl.getBrno() != null && !"".equals(bSysAcctBctl.getBrno())) {
				bSysAcctBctlExample.createCriteria().andBrnoEqualTo(bSysAcctBctl.getBrno());
			}
			// 机构名称
			if (bSysAcctBctl.getBrname() != null && !"".equals(bSysAcctBctl.getBrname())) {
				bSysAcctBctlExample.createCriteria().andBrnameLike("%" + bSysAcctBctl.getBrname() + "%");
			}
		}
		p.setRecords(iBSysAcctBctlDAO.selectByPage(bSysAcctBctlExample, p));
		return p;

	}
	
	//用户校验
	@Override
	public BSysAcctBctl findBSysAcctBctlByBrcode(String brcode) {
		RSysAcctBctl rbctl = iBSysAcctBctlDAO.selectByPrimaryKey(brcode);
		BSysAcctBctl sbctl = new BSysAcctBctl();
		try
		{
			BeanUtils.copyProperties(rbctl, sbctl);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return sbctl;
	}

}
