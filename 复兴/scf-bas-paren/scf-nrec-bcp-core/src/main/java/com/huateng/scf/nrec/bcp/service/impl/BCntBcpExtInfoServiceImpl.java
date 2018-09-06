package com.huateng.scf.nrec.bcp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpExtInfoDAO;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntBcpExtInfoExample;
import com.huateng.scf.nrec.bcp.model.BCntBcpExtInfoVO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpExtInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>合同交易对手信息</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月31日上午10:03:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月31日上午10:03:38	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCntBcpExtInfoServiceImpl")
public class BCntBcpExtInfoServiceImpl implements IBCntBcpExtInfoService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCntBcpExtInfoDAO")
	IBCntBcpExtInfoDAO bcntbcpextinfodao;
	
	/**
	 * 根据合同号、买方客户号查询保理扩展表
	 * @param mastContno
	 * @param custcd
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月31日上午10:08:05
	 */
	@Override
	public BCntBcpExtInfoVO queryContDebtExInfoByMastContno(String mastContno, String custcd) throws ScubeBizException
	{
		log.debug("查询交易对手信息====================================");
		BCntBcpExtInfoExample example = new BCntBcpExtInfoExample();
		BCntBcpExtInfoExample.Criteria cri = example.createCriteria();
		cri.andBusinessNoEqualTo(mastContno);
		if(!StringUtil.isEmpty(custcd))
		{
			cri.andBusinessCustcdEqualTo(custcd);
		}
		List<BCntBcpExtInfo> list = bcntbcpextinfodao.selectByExample(example);
		BCntBcpExtInfoVO bCntBcpExtInfoVO = new BCntBcpExtInfoVO();
		if (list.size() > 0) {
			BeanUtils.copyProperties(list.get(0), bCntBcpExtInfoVO);

		}
		return bCntBcpExtInfoVO;
	}
}
