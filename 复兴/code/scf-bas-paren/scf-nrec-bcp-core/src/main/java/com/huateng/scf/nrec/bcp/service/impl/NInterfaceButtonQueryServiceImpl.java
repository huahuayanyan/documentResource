/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2012 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.nrec.bcp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.InterfaceConstants;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.InterfaceButtonVO;
import com.huateng.scf.bas.mrn.dao.IBMrnAcctBussInfoDAO;
import com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfoExample;
import com.huateng.scf.bas.mrn.model.ExtInterface;
import com.huateng.scf.nrec.bcp.service.INInterfaceButtonQueryService;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scf.rec.bcp.service.InterfaceButtonQueryService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;


/**
* <p>调用接口查询信息按钮，通过触发页面按钮，根据不同的交易码调用不同的接口查询相关信息</p>
* @date 2017年6月1日下午7:19:01
* @author Qinwei
* @version 1.0
* @Copyright Shanghai Huateng Software Systems Co., Ltd.
 */
@ScubeService
@Service("NInterfaceButtonQueryServiceImpl")
public class NInterfaceButtonQueryServiceImpl implements INInterfaceButtonQueryService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BMrnAcctBussInfoDAO")
	IBMrnAcctBussInfoDAO bmrnacctbussinfodao;
	
	/**
	* 
	* @param extInterface
	* @return
	* @throws ScubeBizException 
	* @author 	Qinwei
	* @date 	2017年6月1日 下午7:20:21
	* @returnType
	*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page InterfaceButtonQuery(ExtInterface extInterface) throws ScubeBizException {
		log.debug("保证金账户："+extInterface.getBailAccountno());
		String txnCode = extInterface.getTxnCode();
		if (StringUtils.isEmpty(txnCode)) {
			throw new ScubeBizException("接口交易码为空，不能进行接口查询",
					RBcpErrorConstant.ERROR_CODE_DATA_INPUT_ERR);
		}
		Page queryResult = new Page();
		if (txnCode.equals(InterfaceConstants.TXCODE_ACCOUNT_QUERY_RECORDS)){	// 账号信息查询
			String switchType  = ScfBasConstant.FLAG_OFF; //核心系统开关标志默认开
			if (ScfBasConstant.FLAG_ON.equals(switchType)){
				BMrnAcctBussInfoExample example = new BMrnAcctBussInfoExample();
				BMrnAcctBussInfoExample.Criteria cri = example.createCriteria();
				cri.andBailAccountnoEqualTo(extInterface.getBailAccountno());
				List<com.huateng.scf.bas.mrn.dao.model.BMrnAcctBussInfo> mrnlist = bmrnacctbussinfodao.selectByExample(example);
				queryResult.setRecords(mrnlist);
				queryResult.setTotalRecord(mrnlist.size());
			}else{
				InterfaceButtonVO interfaceButtonVO = new InterfaceButtonVO();
				interfaceButtonVO.setAccountBalance(new BigDecimal(10000000));
				interfaceButtonVO.setAvaliableRiskAmt(new BigDecimal(10000000));
				List list = new ArrayList();
				list.add(interfaceButtonVO);
				queryResult.setRecords(list);
				queryResult.setTotalRecord(list.size());
			}
		}
		return queryResult;
	}

	/**
	* 
	* @param returnAccount
	* @return
	* @throws ScubeBizException 
	* @author 	Qinwei
	* @date 	2017年6月1日 下午7:20:32
	* @returnType
	*/
	public BigDecimal getAmountFromRaccount(String returnAccount) throws ScubeBizException{
        return new BigDecimal(10000000);
}
}
