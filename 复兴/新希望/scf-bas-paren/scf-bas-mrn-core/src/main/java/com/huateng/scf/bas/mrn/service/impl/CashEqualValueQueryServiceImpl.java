package com.huateng.scf.bas.mrn.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.service.ICashEqualValueQueryService;
import com.huateng.scf.bas.mrn.service.ICompositeMngService;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>现金等价物流水实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月16日下午7:34:45
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月16日下午7:34:45	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("CashEqualValueQueryServiceImpl")
public class CashEqualValueQueryServiceImpl implements ICashEqualValueQueryService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 保证金及现金等价物信息
	 */
	@Resource(name = "CompositeMngServiceImpl")
	ICompositeMngService compositemngservice;

	@Override
	public Page CashEqualValueQueryGetter(int pageNo, int pageSize, HashMap<String, String> value) throws ScubeBizException 
	{
		log.debug("现金等价物流水查询开始===============");
		Page pageQueryResult = new Page();
		if(null==value||value.size()==0)
		{
			pageQueryResult = new Page(pageSize, pageNo, 0);
			return pageQueryResult;
		}
		String custcd_Q = value.get("custcd");
		String subContno_Q = value.get("subContno");
		String applyType_Q = value.get("applyType");
		OldCommonQueryVO commonQueryVO = new OldCommonQueryVO();
		//BailTransferQryVO commonQueryVO = new BailTransferQryVO(getResult());

		commonQueryVO.setCustcd_Q(custcd_Q);
		commonQueryVO.setMastContno_Q(subContno_Q);
		commonQueryVO.setApplyType_Q(applyType_Q);
		commonQueryVO.setPageIndex(pageNo);
		commonQueryVO.setPageSize(pageSize);
//		commonQueryVO.setBrcode_Q(ContextHolder.getOrgInfo().getBrNo());
		pageQueryResult = compositemngservice.getBailTransferQuery(commonQueryVO);
		return pageQueryResult;
	}
}
