package com.huateng.scf.bas.common.service;

import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>公共类 	接口</p>
 *
 * @author 	mengjiajia
 * @date 	2017年3月1日上午11:14:34
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年3月1日上午11:14:34	     新增
 *
 * </pre>
 */
public interface IProductService {

	public String getProductInfoByMidParentID(@ScubeParam("parentId") String parentId) throws ScubeBizException;

	public String getProductStatic() throws ScubeBizException;

	public String getProductDynamic() throws ScubeBizException;

	public String getAdvanceProductId(@ScubeParam("warehouseType") String warehouseType) throws ScubeBizException;

	String getBillByMidProductId(@ScubeParam("billType") String billType) throws ScubeBizException;

	/**
	 * 根据产品ID返回父类ID
	 * @param productId
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月21日下午1:46:22
	 */
	public String getParentIdById(@ScubeParam("productId") String productId) throws ScubeBizException;

}
