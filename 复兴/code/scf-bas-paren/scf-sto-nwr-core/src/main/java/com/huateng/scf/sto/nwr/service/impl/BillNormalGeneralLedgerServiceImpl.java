package com.huateng.scf.sto.nwr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.lan.model.vo.ContSlaveQryVO;
import com.huateng.scf.bas.mrn.service.IContractService;
import com.huateng.scf.bas.pbc.dao.vo.BPbcMtgBaseInfoVO;
import com.huateng.scf.bas.pbc.model.MortgageQryVO;
import com.huateng.scf.bas.pbc.service.IBPbcMtgBaseInfoService;
import com.huateng.scf.sto.nwr.service.IBillNormalGeneralLedgerService;
import com.huateng.scf.sto.nwr.service.IBillStandardPledgeAppService;
import com.huateng.scf.sto.nwr.vo.BillNormalVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>综合台帐查询	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月10日上午10:38:59
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月10日上午10:38:59	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillNormalGeneralLedgerServiceImpl")
public class BillNormalGeneralLedgerServiceImpl implements IBillNormalGeneralLedgerService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ProductServiceImpl")
	IProductService productservice;
	
	@Resource(name = "ContractServiceImpl")
	IContractService contractservice;

	@Resource(name = "BillStandardPledgeAppServiceImpl")
	IBillStandardPledgeAppService billstandardpledgeappservice;
	
	@Resource(name ="BPbcMtgBaseInfoServiceImpl")
	IBPbcMtgBaseInfoService bpbcmtgbaseinfoservice;
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param contSlaveQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午3:10:17
	 */
	@Override
	public Page MortgageContSlaveQryGetter(int pageNo, int pageSize, ContSlaveQryVO contSlaveQryVO) throws ScubeBizException
	{
		log.debug("综合台帐查询开始===========================================start");
		String flag = contSlaveQryVO.getFlag();//flag ：1动产,2-先票后货，3汽车货押...等

		String supplyChainPdId="";
		if(ScfBasConstant.PRODUCT_TYPE_CHATTLE_DYNAMIC.equals(flag)){//动产动态
			supplyChainPdId = productservice.getProductDynamic();
		}else if(ScfBasConstant.PRODUCT_TYPE_FOURWARE.equals(flag)){//先票后货
			supplyChainPdId = productservice.getAdvanceProductId(ScfBasConstant.MUTI_PROTOCOL_FOURWH);
		}else if(ScfBasConstant.PRODUCT_TYPE_CARPLEDGE.equals(flag)){//汽车货押
			supplyChainPdId = productservice.getProductInfoByMidParentID(ScfBasConstant.PRODUCT_TYPE_CAR_PLEDGE);
		}else if(ScfBasConstant.PRODUCT_TYPE_CHATTLE_STATIC.equals(flag)){//动产静态
			supplyChainPdId = productservice.getProductStatic();
		}else if(ScfBasConstant.PRODUCT_TYPE_STANDARD_BILL.equals(flag)){// 标准仓单
			supplyChainPdId = productservice.getBillByMidProductId(ScfBasConstant.BILL_TYPE_STANDARD);
		}else if(ScfBasConstant.PRODUCT_TYPE_NORMAL_BILL.equals(flag)){// 普通非标准仓单
			supplyChainPdId = productservice.getBillByMidProductId(ScfBasConstant.BILL_TYPE_NORMAL);
		}else if(ScfBasConstant.PRODUCT_TYPE_CAR_FIRST.equals(flag)){// 汽车金融
			supplyChainPdId = productservice.getProductInfoByMidParentID(ScfBasConstant.PRODUCT_TYPE_CAR_FIRST_PAY);
		}

		//查询条件业务品种设为不可编辑 modify by changhao.huang 2013-9-10 19:02:48
		contSlaveQryVO.setSupplyChainPdId_Q(supplyChainPdId);
		//满足该条件的B_SYS_BCTL_AFFILIATION[机构辖内关系表]为空表，故此处使用客户经理权限
//		contSlaveQryVO.setFlag(ScfBasConstant.QUERY_TYPE_ALL);
		contSlaveQryVO.setFlag(ScfBasConstant.QUERY_TYPE_MAG_ALL);

		contSlaveQryVO.setPageIndex(pageNo);
		contSlaveQryVO.setPageSize(pageSize);
		
		Page pageQueryResult = contractservice.getSlaveContList(contSlaveQryVO);

		log.debug("综合台帐查询结束===========================================end");
		return pageQueryResult;
	}
	
	/**
	 * 信贷合同列表
	 * @param pageNo
	 * @param pageSize
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午4:53:14
	 */
	@Override
	public Page ContBaseInfoGetter(int pageNo, int pageSize, String slaveContno) throws ScubeBizException
	{
		ContSlaveQryVO commonQueryVo = new ContSlaveQryVO();
		commonQueryVo.setSlaveContno(slaveContno);
		commonQueryVo.setPageIndex(pageNo);
		commonQueryVo.setPageSize(pageSize);
		Page pageQueryResult = contractservice.getContBaseInfoListBySlaveContno(commonQueryVo);
		return pageQueryResult;
	}
	
	/**
	 * 查询质押合同下所有借据
	 * @param pageNo
	 * @param pageSize
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午5:12:40
	 */
	@Override
	public Page LnciBaseInfoListGetter(int pageNo, int pageSize, String slaveContno) throws ScubeBizException
	{
		ContSlaveQryVO commonQueryVo = new ContSlaveQryVO();
		commonQueryVo.setSlaveContno(slaveContno);
		commonQueryVo.setPageIndex(pageNo);
		commonQueryVo.setPageSize(pageSize);
		Page pageQueryResult = contractservice.getLnciBaseInfoListBySlaveContno(commonQueryVo);
		return pageQueryResult;
	}
	
	/**
	 * 查询已质押可以提货的仓单
	 * @param pageNo
	 * @param pageSize
	 * @param billNormalVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午5:38:31
	 */
	@Override
	public Page BillNormalDeliverableListGetter(int pageNo, int pageSize, BillNormalVO billNormalVO) throws ScubeBizException
	{
		billNormalVO.setPageIndex(pageNo);
		billNormalVO.setPageSize(pageSize);
		Page pageQueryResult = billstandardpledgeappservice.getBillNormalDeliverableList(billNormalVO);
		return pageQueryResult;
	}
	
	/**
	 * 查询协议下押品信息
	 * @param pageNo
	 * @param pageSize
	 * @param mortgageQryVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月10日下午5:45:41
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page MutiMortInfoGetter(int pageNo, int pageSize, MortgageQryVO mortgageQryVO) throws ScubeBizException
	{
		Page pageQueryResult = bpbcmtgbaseinfoservice.getMortgageBaseInfoPageByParam(pageNo, pageSize, mortgageQryVO);
		
		List<BPbcMtgBaseInfoVO> list = pageQueryResult.getRecords();
		if(list!=null&&list.size()>0)
		{
			for(BPbcMtgBaseInfoVO baseInfo:list)
			{
				if(ScfBasConstant.JOIN_BATCH_YES.equalsIgnoreCase(baseInfo.getJoinBatch()))
				{
					baseInfo.setJoinBatch("true");
				}
				else
				{
					baseInfo.setJoinBatch("false");
				}
			}
		}
		return pageQueryResult;
	}
}
