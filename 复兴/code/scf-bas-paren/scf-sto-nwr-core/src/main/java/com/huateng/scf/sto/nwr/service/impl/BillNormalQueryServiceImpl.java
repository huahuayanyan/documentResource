package com.huateng.scf.sto.nwr.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO;
import com.huateng.scf.sto.nwr.service.IBillManagerService;
import com.huateng.scf.sto.nwr.service.IBillNormalQueryService;
import com.huateng.scf.sto.nwr.service.IBillStandardPledgeAppService;
import com.huateng.scf.sto.nwr.vo.BillNormalInOutQryVO;
import com.huateng.scf.sto.nwr.vo.BillstandardQryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>非标仓单查询	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月11日上午10:15:13
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月11日上午10:15:13	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillNormalQueryServiceImpl")
public class BillNormalQueryServiceImpl implements IBillNormalQueryService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BillManagerServiceImpl")
	IBillManagerService billmanagerservice;

	@Resource(name = "BillStandardPledgeAppServiceImpl")
	IBillStandardPledgeAppService billstandardpledgeappservice;
	
	/**
	 * 普通非标准仓单信息列表查询
	 * @param pageNo
	 * @param pageSize
	 * @param billNormalInOutQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月11日上午10:19:24
	 */
	@Override
	public Page NormalBillGetter(int pageNo, int pageSize, BillNormalInOutQryVO billNormalInOutQryVO) throws ScubeBizException
	{
		log.debug("普通非标准仓单信息列表查询===============================start");
		billNormalInOutQryVO.setPageIndex(pageNo);
		billNormalInOutQryVO.setPageSize(pageSize);
		//开始日期
		String startDate = billNormalInOutQryVO.getStartDate();
		//结束日期
		String endDate = billNormalInOutQryVO.getEndDate();
		if(!StringUtil.isEmpty(startDate) && !StringUtil.isEmpty(endDate))
		{
			int index = ScfDateUtil.compareDateSequence(startDate,endDate);
			if(index>0)
			{
				throw new ScubeBizException(" 开始日期应该在结束日期前");
			}
		}
		// 查询 [普通仓单流水表、客户基本信息表]
		Page page = billmanagerservice.getNormalBill(billNormalInOutQryVO);
		log.debug("普通非标准仓单信息列表查询===============================end");
		return page;
	}
	
	/**
	 * 普通非标准仓单信息
	 * @param pageNo
	 * @param pageSize
	 * @param billno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月11日上午11:17:15
	 */
	@Override
	public Page FindMortgageListMngGetter(int pageNo, int pageSize, String billno) throws ScubeBizException
	{
		BillstandardQryVO billstandardQryVO = new BillstandardQryVO();
		billstandardQryVO.setBillno(billno);	// 仓单号
		
		Page pageQueryResult = new Page();

		if (!StringUtil.isEmpty(billstandardQryVO.getBillno()))  // 仓单号
		{
			pageQueryResult = billstandardpledgeappservice.getMortgageBaseInfo(billstandardQryVO);
		}
		else
		{
			pageQueryResult.setRecords(new ArrayList<BPbcMtgBaseInfoVO>());;
		}
		return pageQueryResult;
	}
}
