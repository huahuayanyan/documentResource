package com.huateng.scf.bas.mrn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.cnt.service.IBCntMprotBaseInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.DeliveryApplyQryVO;
import com.huateng.scf.bas.common.model.MoniProtocolVO;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scf.bas.mrn.service.ICompositeMngService;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.mrn.service.IMaxmumBailTransferQueryService;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scf.bas.mrn.vo.ProtocolQryVO;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>最高额保证金流水查询接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月27日下午4:29:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月27日下午4:29:26	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("MaxmumBailTransferQueryServiceImpl")
public class MaxmumBailTransferQueryServiceImpl implements IMaxmumBailTransferQueryService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 保证金及现金等价物信息
	 */
	@Resource(name = "CompositeMngServiceImpl")
	ICompositeMngService compositemngservice;
	
	@Resource(name = "BCntMprotBaseInfoServiceImpl")
	IBCntMprotBaseInfoService bcntmprotbaseinfoservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;
	
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;
	
	@Resource(name = "ProductServiceImpl")
	IProductService productservice;
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;
	
	@Override
	public Page MaxmumBailTransferQueryGetter(int pageNo, int pageSize, HashMap<String, String> value) throws ScubeBizException
	{
		log.debug("最高额保证金流水查询开始=====================");
		Page pageQueryResult = new Page();
		if(null==value||value.size()==0)
		{
			pageQueryResult = new Page(pageSize, pageNo, 0);
			return pageQueryResult;
		}
		String applyType_Q = value.get("applyType");
		String cname_Q = value.get("cname");
		String subContno_Q = value.get("subContno");
		String slaveContno_Q = value.get("slaveContno");

		OldCommonQueryVO commonQueryVO = new OldCommonQueryVO();

		commonQueryVO.setCname_Q(cname_Q);//客户名称
		commonQueryVO.setSubContno_Q(subContno_Q);//质押监管协议编号
		commonQueryVO.setSlaveContno_Q(slaveContno_Q);//抵质押合同编号
		commonQueryVO.setApplyType_Q(applyType_Q);
		commonQueryVO.setBailType_Q(ScfBasConstant.BAIL_TYPE_NORMAL);//保证金
		commonQueryVO.setType_Q(ScfBasConstant.INIT_TYPE_MAX);//最高额
		commonQueryVO.setPageIndex(pageNo);
		commonQueryVO.setPageSize(pageSize);
		
		pageQueryResult = compositemngservice.getBailTransferSerialQuery(commonQueryVO);
		return pageQueryResult;
	}
	
	/**
	 * 质押监管协议编号下拉选择
	 * @return
	 * @throws ScubeBizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page MutiProtDropDownGetter(int pageNo,int pageSize,HashMap<String, String> value) throws ScubeBizException {
		List list = new ArrayList();
		String subContno = value.get("subContno");
		String custcd_Q = value.get("custcd");

		//增加协议类型和监管模式
		String moniProtocolType = value.get("moniProtocolType");
		String moniType = value.get("moniType");

		String flag = value.get("flag");

		if (!StringUtil.isEmpty(subContno)&&(subContno.indexOf("%")==-1)) {
			subContno="%"+subContno+"%";
		}else if(value.equals("%%")){
			subContno = "";
		}
		ProtocolQryVO protocolQryVO = new ProtocolQryVO();
		protocolQryVO.setPageIndex(pageNo);
		protocolQryVO.setPageSize(pageSize);
		if (!StringUtil.isEmpty(subContno)) {
			protocolQryVO.setProtocolCode(subContno);
		}
		if (!StringUtil.isEmpty(custcd_Q)) 
		{
			protocolQryVO.setCustcd(custcd_Q);
		}
		if(!StringUtil.isEmpty(flag)){
			String productID = bprdinfoservice.getProductIdByFlag(flag);
			protocolQryVO.setProductId_Q(productID);
		}
		if (!StringUtil.isEmpty(moniProtocolType))
		{
			//汽车货押
			if(moniProtocolType.equals(ScfBasConstant.MONI_PROTOCOL_TYPE_CAR))
			{
				protocolQryVO.setProductId_Q(productservice.getProductInfoByMidParentID(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE));
			}
		}
		if (!StringUtil.isEmpty(moniType)) {
			protocolQryVO.setMoniType_Q(ScfBasConstant.MONI_MODEL_STATIC);
		}

		Page result = bcntmprotbaseinfoservice.getMutiProtDropDownInfo(protocolQryVO);
		List mutiProtBaseinfolist = result.getRecords();
		for (int i = 0; i < mutiProtBaseinfolist.size(); i++) {
			MoniProtocolVO moniProtocolVO = new MoniProtocolVO();
			BCntMprotBaseInfo vo = (BCntMprotBaseInfo) mutiProtBaseinfolist.get(i);
			moniProtocolVO.setProtocolNo(vo.getProtocolNo());
			moniProtocolVO.setProtocolCode(vo.getProtocolCode());
			moniProtocolVO.setCurcd(vo.getCurcd());
			moniProtocolVO.setProductId(vo.getProductId());
			//汽车货押，产品ID存放一个中类
			if (!StringUtil.isEmpty(moniProtocolType))
			{
				if(moniProtocolType.equals(ScfBasConstant.MONI_PROTOCOL_TYPE_CAR))
				{
					moniProtocolVO.setProductId(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE);
				}
			}

			DeliveryApplyQryVO deliveryApplyQryVO =new DeliveryApplyQryVO();
			deliveryApplyQryVO.setProtocolNo(vo.getProtocolNo());
			deliveryApplyQryVO.setRole_Q(ScfBasConstant.PROTOCOL_PART_ROLE_BANK);
			deliveryApplyQryVO.setPageIndex(1);
			deliveryApplyQryVO.setPageSize(999999);

			protocolQryVO.setProtocolNo(vo.getProtocolNo());
			// 质权人
			protocolQryVO.setRole_Q(ScfBasConstant.PROTOCOL_PART_ROLE_BANK);
			Page pageQueryResult = contractservice.getMutiProtPartInfoByPara(deliveryApplyQryVO);
			if (!pageQueryResult.getRecords().isEmpty()) {
				BCntMprotPartInfo firMutiProtPartInfo = (BCntMprotPartInfo) pageQueryResult.getRecords().get(0);
				moniProtocolVO.setFirName(firMutiProtPartInfo.getCname());
				moniProtocolVO.setFirCd(firMutiProtPartInfo.getCustcd());
				if(moniProtocolVO.getFirCd()!=null)
				{
					BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
					bCrmBaseInfo.setCustcd(moniProtocolVO.getFirCd());
					BCrmBaseInfo custvo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
					if(custvo!=null){
						moniProtocolVO.setFirName(custvo.getCname());
					}
				}
			}
			// 出质人
			protocolQryVO.setRole_Q(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
			deliveryApplyQryVO.setRole_Q(ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT);
			pageQueryResult = contractservice.getMutiProtPartInfoByPara(deliveryApplyQryVO);
			if (!pageQueryResult.getRecords().isEmpty()) {
				BCntMprotPartInfo secMutiProtPartInfo = (BCntMprotPartInfo) pageQueryResult.getRecords().get(0);
				moniProtocolVO.setSecName(secMutiProtPartInfo.getCname());
				moniProtocolVO.setSecCd(secMutiProtPartInfo.getCustcd());
				if(moniProtocolVO.getSecName()==null)
				{
					BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
					bCrmBaseInfo.setCustcd(moniProtocolVO.getSecCd());
					BCrmBaseInfo custvo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
					if(custvo!=null){
						moniProtocolVO.setSecName(custvo.getCname());
					}
				}
			}
			deliveryApplyQryVO.setRole_Q(ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
			pageQueryResult = contractservice.getMutiProtPartInfoByPara(deliveryApplyQryVO);
			if (!pageQueryResult.getRecords().isEmpty()) {
				BCntMprotPartInfo thrMutiProtPartInfo = (BCntMprotPartInfo) pageQueryResult.getRecords().get(0);
				moniProtocolVO.setMoniOfCustcd(thrMutiProtPartInfo.getCustcd());
				moniProtocolVO.setMoniName(thrMutiProtPartInfo.getCname());
				if(moniProtocolVO.getMoniName()==null)
				{
					BCrmBaseInfo bCrmBaseInfo = new BCrmBaseInfo();
					bCrmBaseInfo.setCustcd(moniProtocolVO.getSecCd());
					BCrmBaseInfo custvo = bcrmbaseinfoservice.findBCrmBaseInfoByKey(bCrmBaseInfo);
					if(custvo!=null){
						moniProtocolVO.setMoniName(custvo.getCname());
					}
				}
			}
			// 货押模式
			BCntMprotBaseInfo tblMutiProtBaseInfo = bcntmprotbaseinfoservice.findBCntMprotBaseInfoByKey(protocolQryVO.getProtocolNo());
			moniProtocolVO.setMoniType(tblMutiProtBaseInfo.getMoniType());
			list.add(moniProtocolVO);
		}
		result.setRecords(list);
		return result;
	}
	
	@Override
	public Page SlaveContractGetter(int pageNo,int pageSize,HashMap<String, String> value) throws ScubeBizException
	{
		// 设置查询参数
		String slaveContcode_Q = value.get("slaveContno"); // 担保合同号
		String custcd = value.get("custcd");//客户号
		//modified by hong.xu 2013-1-5 动产融资出质入库从合同下拉增加供应链产品类型的条件筛选 start
		String supplyChainPdId = value.get("supplyChainPdId");//供应链产品类型
		//modified by hong.xu 2013-1-5 动产融资出质入库从合同下拉增加供应链产品类型的条件筛选 end
		String bussType = value.get("bussType");//业务类型（主要是为了区分换货，其他业务为空）
		//最高额保证金业务由原来的以抵/质押监管协议号发起改为以抵质押合同发起 add by xiaolong.xiong 2013-04-23
		String moniProtNo = value.get("subContno");//抵/质押监管协议号
		String moniModel = value.get("moniMd");

		//汽车货押页面传的是中类，需要转为小类，进行查询。 modify by fengjinfu 20130715
//		if(SCFConstants.PRODUCT_TYPE_CAR_PLEDGE.equals(supplyChainPdId))
//		{
//			ProductService productService = ProductService.getInstance();
//			supplyChainPdId = productService.getProductInfoByMidParentID(SCFConstants.PRODUCT_TYPE_CAR_PLEDGE);
//		}
		MastContQryVO mastContQryVO = new MastContQryVO();
		mastContQryVO.setSlaveContCode(slaveContcode_Q);
		mastContQryVO.setCustcd(custcd);
		mastContQryVO.setBussType(bussType);
		//modified by hong.xu 2013-1-5 动产融资出质入库从合同下拉增加供应链产品类型的条件筛选 start
		if(!StringUtil.isEmpty(supplyChainPdId))
		{
			if(ScfBasConstant.PRODUCT_TYPE_CHATTLE.equals(supplyChainPdId))
			{
				if(ScfBasConstant.MONI_MODEL_DYNAMIC.equals(moniModel))
				{
					supplyChainPdId = productservice.getProductDynamic();
				}
				else if(ScfBasConstant.MONI_MODEL_STATIC.equals(moniModel))
				{
					supplyChainPdId = productservice.getProductStatic();
				}
			}
			else if(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE.equals(supplyChainPdId))
			{
				supplyChainPdId =  productservice.getProductInfoByMidParentID(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE);  
			}
			else if(ScfBasConstant.PRODUCT_TYPE_WAREHOUSE.equals(supplyChainPdId))
			{ //预付类：四方
				supplyChainPdId =  productservice.getProductInfoByMidParentID(ScfBasConstant.PRODUCT_TYPE_WAREHOUSE);
				supplyChainPdId = supplyChainPdId.split(",")[1];
			}
		}
		mastContQryVO.setSupplyChainPdId(supplyChainPdId);
		//modified by hong.xu 2013-1-5 动产融资出质入库从合同下拉增加供应链产品类型的条件筛选 end
		mastContQryVO.setProtocolNo(moniProtNo);
		mastContQryVO.setMoniModel(moniModel);
		// 有效期内是否校验 下拉选择时开 add by xiaolong.xiong 2013-09-18
		mastContQryVO.setFlag(ScfBasConstant.FLAG_OFF);
		mastContQryVO.setPageIndex(pageNo);
		mastContQryVO.setPageSize(pageSize);
		Page pageResult = contractservice.getContSlaveBaseInfo(mastContQryVO);
		return pageResult;
	}
}
