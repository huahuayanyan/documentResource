package com.huateng.scf.bas.com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.service.IProductService;
import com.huateng.scf.bas.prd.dao.model.BPrdInfo;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.prd.service.IBPrdMortService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>公共类 	接口实现</p>
 *
 * @author 	mengjiajia
 * @date 	2017年3月1日上午11:15:23
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年3月1日上午11:15:23	     新增
 *
 * </pre>
 */
@ScubeService
@Service("ProductServiceImpl")
public class ProductServiceImpl implements IProductService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BPrdInfoServiceImpl")
	IBPrdInfoService bprdinfoservice;
	
//	@Resource(name = "SBcpProductBillServiceImpl")
//	ISBcpProductBillService isbcpproductbillservice;
	
	@Resource(name = "BPrdMortServiceImpl")
	IBPrdMortService bprdmortservice;
	
	/**
	 * @Description: 返回产品类型为动产动态的小类的组合字符串
	 * @author mengjiajia
	 * @Created 2013-1-9下午03:55:08
	 * @return
	 * @throws ScubeBizException
	 * TblProductMort
	 */
	@Override
	public String getProductDynamic() throws ScubeBizException {
		return bprdmortservice.getProductDynamic();
	}
	
	/**
	 * DESCRIPTION:返回产品类型为动产静态的小类的产品ID
	 *
	 * @author mengjiajia
	 * @date 2013-7-8 getProductStatic 方法
	 * @return
	 * @throws ScubeBizException
	 * @param commonQueryVO
	 * @return
	 * TblProductMort
	 */
	@Override
	public String getProductStatic() throws ScubeBizException {
		return bprdmortservice.getProductStatic();
	}
	
	/**
	 * 汽车货押，根据中类查询小类
	 *
	 * @param parentId_Q
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @Created 2013-7-11
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String getProductInfoByMidParentID(String parentId) throws ScubeBizException 
	{
		log.debug("parentId:"+parentId);
		List list = bprdinfoservice.getProductInfoByParentID(parentId);
		String productInfo = "";
		for (int i = 0; i < list.size(); i++) {
			BPrdInfo info = (BPrdInfo) list.get(i);
			if (i == 0) {
				productInfo = info.getProductId();
			} else {
				productInfo = " ," + info.getProductId() + "";
			}
		}
		return productInfo;
	}
	
	/**
	 * DESCRIPTION:根据warehouseType查询预付款产品ID
	 *
	 * @author mengjiajia
	 * @date 2013-7-8 getAdvanceProductId 方法
	 * @param warehouseType
	 * @return
	 * @throws ScubeBizException
	 * @param warehouseType
	 * @return
	 * TblProductWarehouse
	 */
	@Override
	public String getAdvanceProductId(String warehouseType) throws ScubeBizException 
	{
//		return SCFDAOUtils.getTblProductWarehouseDAO().getAdvanceProductId(
//				warehouseType);
		return null;
	}

	/**
	 * @Description: 根据仓单类型获取仓单小类
	 * @author mengjiajia
	 * @Created 2013-2-20下午02:41:02
	 * @param billType
	 * @return
	 * @throws ScubeBizException
	 * TblProductBill
	 */
	@Override
	public String getBillByMidProductId(String billType) throws ScubeBizException {
//		return isbcpproductbillservice.getBillByMidProductId(billType);
		return null;
	}
	
	/**
	 * 根据产品ID返回父类ID
	 * @param productId
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月21日下午1:46:12
	 */
	@Override
	public String getParentIdById(String productId) throws ScubeBizException
	{
		return bprdinfoservice.getParentIdById(productId);
	}

}
