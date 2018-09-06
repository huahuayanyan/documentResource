package com.huateng.scf.bas.mrn.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrGntyConDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyConExample.Criteria;
import com.huateng.scf.bas.mrn.service.ICompositeMngService;
import com.huateng.scf.bas.mrn.service.IMaximumBailTransferApplyService;
import com.huateng.scf.bas.mrn.vo.BCrrGntyConVO;
import com.huateng.scf.bas.mrn.vo.OldContractVO;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>最高额保证金转入接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月27日上午10:00:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月27日上午10:00:53	     新增
 *
 * </pre>
 */
@ScubeService
@Service("IMaximumBailTransferApplyService")
public class MaximumBailTransferApplyServiceImpl implements IMaximumBailTransferApplyService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrGntyConDAO")
	IBCrrGntyConDAO bcrrgntycondao;
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;
	
	/**
	 * 保证金及现金等价物信息
	 */
	@Resource(name = "CompositeMngServiceImpl")
	ICompositeMngService compositemngservice;
	
	@SuppressWarnings("unchecked")
	@Override
	public Page findBCrrGntyConByPage(int pageNo, int pageSize, BCrrGntyConVO bCrrGntyConVO) 
	{
		
		BCrrGntyConExample example = new BCrrGntyConExample();
		Criteria cri = example.createCriteria();

		if (bCrrGntyConVO != null) {
			// 业务申请主键
			if (bCrrGntyConVO.getConId() != null && bCrrGntyConVO.getConId().length() > 0) {
				cri.andConIdLike("%" + bCrrGntyConVO.getConId() + "%");
			}
			// 担保类型
			if (bCrrGntyConVO.getGutyTyp() != null && bCrrGntyConVO.getGutyTyp().length() > 0) {
				cri.andGutyTypEqualTo(bCrrGntyConVO.getGutyTyp());
			}
			// 担保客户名称
			if (bCrrGntyConVO.getGutNm() != null && bCrrGntyConVO.getGutNm().length() > 0) {
				cri.andGutNmLike("%" + bCrrGntyConVO.getGutNm() + "%");
			}
			// 担保客户ID
			if (bCrrGntyConVO.getGutId() != null && bCrrGntyConVO.getGutId().length() > 0) {
				cri.andGutIdEqualTo(bCrrGntyConVO.getGutId());
			}
			// 最低控货价值筛选 1.业务品种，2.原最低控货价值
			if (bCrrGntyConVO.getVidPrdId() != null && bCrrGntyConVO.getVidPrdId().length() > 0) {
				cri.andVidPrdIdEqualTo(bCrrGntyConVO.getVidPrdId());
			}
			if (bCrrGntyConVO.getLowPrice() != null) {
				cri.andLowPriceIsNotNull();
			}
			//合同状态
			if(bCrrGntyConVO.getConStat() != null&& bCrrGntyConVO.getConStat().length() > 0)
			{
				cri.andConStatEqualTo(bCrrGntyConVO.getConStat());
			}
			//最高额保证金转入申请时使用该字段判断担保合同是否补录成功
			if(!StringUtil.isEmpty(bCrrGntyConVO.getPrtclNo()))
			{
				cri.andConTypEqualTo("02");//最高额担保合同信息
				cri.andPrtclNoLike(bCrrGntyConVO.getPrtclNo());
			}
			else
			{
				cri.andPrtclNoIsNotNull();
			}
		}
		
		int total = bcrrgntycondao.countByExample(example);
		Page p = new Page(pageSize, pageNo, total);


		log.info("totalPage=" + p.getTotalPage());
		log.info("totalPage=" + p.getTotalPage());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("totalRecord=" + p.getTotalRecord());
		log.info("current=" + p.getCurrent());
		log.info("current=" + p.getCurrent());

		Page result = new Page();
		result.setRecords(bcrrgntycondao.selectByPage(example, p));
		List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> listdal = result.getRecords();
		List<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon> list = new ArrayList<com.huateng.scf.bas.crr.dao.model.BCrrGntyCon>();
		if (listdal.size() > 0) {
			for (com.huateng.scf.bas.crr.dao.model.BCrrGntyCon gntycon : listdal) {
				String productId = gntycon.getVidPrdId();
				String productNm = "";
				if (StringUtil.isStrNotEmpty(productId)) {
					BPrdInfo bPrdInfo = new BPrdInfo();
					bPrdInfo.setProductId(productId);
					BPrdInfo info = bprdinfoservice.findBPrdInfoByKey(bPrdInfo);
					String productType = info.getProductType();
					if(!StringUtil.isEmpty(productType)&&productType.equals("002"))
					{
						productNm = info.getProductName();
						gntycon.setVidPrdNm(productNm);
						list.add(gntycon);
					}
				}
			}
		}

		p.setRecords(list);
		log.info("p.toString()=" + p.toString());
		return p;
	}
	
	/**
	 * 获取最高额保证金金额信息
	 */
	@Override
	public Page BailAccountBaseInfoGetter(BCrrGntyConVO bCrrGntyConVO)
	{
		//抵质押合同号
		String slaveContno = bCrrGntyConVO.getConId();
		String appno = bCrrGntyConVO.getAppno();
		String supplyChainPdId = bCrrGntyConVO.getVidPrdId();
		Page page = compositemngservice.getMaxBailAccountApplyInfo(appno,slaveContno,supplyChainPdId);
		return page;
	}
	
	/**
	 * 保证金转入登记保存--池管理模式
	 */
	@Override
	public void BailTransferApplyUpdate(BCrrGntyConVO bCrrGntyConVO,HashMap<String, Object> value)
	{
		OldContractVO contractVO = new OldContractVO();
		//保证金转入信息
		contractVO.setBailAccountno(value.get("bailAccountno").toString());
		contractVO.setBailAmount(new BigDecimal(value.get("bailAmount").toString()));
		contractVO.setAmt(new BigDecimal(value.get("amt").toString()));
		contractVO.setAmount(value.get("amount").toString());
		contractVO.setNpsBailAmount(new BigDecimal(value.get("npsBailAmount").toString()));
		//担保合同信息
		contractVO.setCustcd(bCrrGntyConVO.getGutId());
		contractVO.setProtocolNo(bCrrGntyConVO.getPrtclNo());
		contractVO.setMastContno(bCrrGntyConVO.getAppId());
		contractVO.setSlaveContno(bCrrGntyConVO.getConId());
		contractVO.setCurcd(bCrrGntyConVO.getGutCurcd());
		compositemngservice.saveBailTransferApply(contractVO);
	}
}
