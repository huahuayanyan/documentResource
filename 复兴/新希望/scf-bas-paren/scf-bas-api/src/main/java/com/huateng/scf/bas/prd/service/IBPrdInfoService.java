/**
 * 
 */
package com.huateng.scf.bas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 供应链产品接口
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月22日上午10:06:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日上午10:06:04              新增
 *
 *            </pre>
 */
public interface IBPrdInfoService {

	public String add(@ScubeParam("bPrdInfo") BPrdInfo bPrdInfo) throws ScubeBizException;

	public int delete(@ScubeParam("productId") String productId) throws ScubeBizException;

	public int update(@ScubeParam("bPrdInfo") BPrdInfo bPrdInfo) throws ScubeBizException;

	public BPrdInfo findBPrdInfoObjectByKey(@ScubeParam("key") String key) throws ScubeBizException;;

	public BPrdInfo findBPrdInfoByKey(@ScubeParam("bPrdInfo") BPrdInfo bPrdInfo) throws ScubeBizException;

	public List<BPrdInfo> findBPrdInfoByBPrd(@ScubeParam("bPrdInfo") BPrdInfo bPrdInfo) throws ScubeBizException;

	public List<BPrdInfo> findBPrdInfoListForSelect(@ScubeParam("value") BPrdInfo bPrdInfo) throws ScubeBizException;

	public BPrdInfo checkPrdInfoForSelect(@ScubeParam("bPrdInfo") BPrdInfo bPrdInfo) throws ScubeBizException;

	// 专门用于页面下拉搜索框的分页查询
	public Page selectBPrdInfoBySelect(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("value") BPrdInfo bPrdInfo)
			throws ScubeBizException;

	public Page findPrdInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize, @ScubeParam("bPrdInfo") BPrdInfo bPrdInfo)
			throws ScubeBizException;

	@SuppressWarnings("rawtypes")
	public List getProductInfoByParentID(@ScubeParam("parentId") String parentId) throws ScubeBizException;

	public String getProductIdByFlag(@ScubeParam("flag") String flag) throws ScubeBizException;

	/**
	 * 通过parentId查找产品记录，返回String
	 * 
	 * @param parentId
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月14日下午2:05:33
	 */
	public String getProductByParentId(@ScubeParam("parentId") String parentId) throws ScubeBizException;

	/**
	 * 获取业务产品 中类 信息
	 * 
	 * @param supplyChainPdId
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月20日下午3:50:38
	 */
	public String getSubClassProductIds(@ScubeParam("supplyChainPdId") String supplyChainPdId) throws ScubeBizException;

	/**
	 * 根据产品ID返回父类ID
	 * 
	 * @param productId
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年4月21日下午1:47:57
	 */
	public String getParentIdById(@ScubeParam("productId") String productId) throws ScubeBizException;

	/**
	 * 根据父类ID,TYPE返回产品ID(没有意义)
	 * 
	 * @param parentId
	 * @param productType
	 * @return
	 * @throws ScubeBizException
	 * @date 2017年4月21日下午1:47:57
	 */
	public String getProductIdByParIdType(@ScubeParam("parentId") String parentId, @ScubeParam("productType") String productType)
			throws ScubeBizException;
}
