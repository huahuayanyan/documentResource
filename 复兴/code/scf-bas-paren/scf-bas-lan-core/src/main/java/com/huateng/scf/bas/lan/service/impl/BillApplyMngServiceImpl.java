package com.huateng.scf.bas.lan.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.ext.ExtBLanDAO;
import com.huateng.scf.bas.lan.service.IBillApplyMngService;
import com.huateng.scf.sto.nwr.vo.BillCommonQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p></p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月21日下午4:20:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月21日下午4:20:42	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillApplyMngServiceImpl")
public class BillApplyMngServiceImpl implements IBillApplyMngService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ExtBLanDAO")
	ExtBLanDAO extblandao;
	
	/**
	 * 
	 * @param billno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年4月21日下午4:21:41
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BigDecimal getBillNormalLoanAmt(String billno) 
	{
		log.debug("billno="+billno);
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("billno", billno);
		
		List list = extblandao.getBillNormalLoanAmt(omap);
		BigDecimal result = BigDecimal.ZERO;
		if(list.size()>0&&list!=null)
		{
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			result = (BigDecimal)map.get("lnciAmt");
		}
		return result;
	}

	/**
	 * 
	 * @param qryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月24日下午2:41:42
	 */
	@Override
	public Page getBillNormalAppChkStockInfo(BillCommonQryVO qryVO) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		omap.put("appno", qryVO.getAppno());
		omap.put("slaveContno", qryVO.getSlaveContno());
		
		int total = extblandao.countBillNormalAppChkStockInfo(omap);
		Page page = new Page(qryVO.getPageSize(), qryVO.getPageIndex(), total);
		page.setRecords(extblandao.getBillNormalAppChkStockInfo(omap,page));
		return page;
	}

}
