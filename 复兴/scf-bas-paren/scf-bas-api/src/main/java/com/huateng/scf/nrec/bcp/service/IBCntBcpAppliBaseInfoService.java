package com.huateng.scf.nrec.bcp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DataItemsVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.prd.model.BPrdInfo;
import com.huateng.scf.nrec.bcp.model.BCntBcpAppliBaseInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>应收类业务申请	接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月19日下午3:51:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月19日下午3:51:17	     新增
 *
 * </pre>
 */
public interface IBCntBcpAppliBaseInfoService {

	/**
	 * 查询业务申请列表信息
	 * @param pageNo
	 * @param pageSize
	 * @param bCntBcpAppliBaseInfo
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月19日上午10:53:29
	 */
	public Page findBCntBcpAppliBaseInfoByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") HashMap<String, Object> value);

	/**
	 * 业务品种筛选
	 * @param dataItemsDO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年5月19日上午11:15:21
	 */
	public List<DataItemsVO> getProductId(@ScubeParam("bPrdInfo") BPrdInfo bPrdInfo) throws ScubeBizException;

	public BCntBcpAppliBaseInfoVO cachadd(@ScubeParam("bCntBcpAppliBaseInfoVO") BCntBcpAppliBaseInfoVO bCntBcpAppliBaseInfoVO);

	public String add(@ScubeParam("bCntBcpAppliBaseInfoVO") BCntBcpAppliBaseInfoVO bCntBcpAppliBaseInfoVO);

	public void update(@ScubeParam("bCntBcpAppliBaseInfoVO") BCntBcpAppliBaseInfoVO bCntBcpAppliBaseInfoVO);

	public List<String> delete(@ScubeParam("appno") String appno);

	public BPbcAppliBaseInfo findRBcpAppliBussInfoByAppno(@ScubeParam("appno") String appno);

	/**
	 * 提交并发起工作流
	 * @param bCntBcpAppliBaseInfoVO
	 * @author 	mengjiajia
	 * @date 	2017年5月19日下午2:11:03
	 */
	public void submitAndUpdate(@ScubeParam("bCntBcpAppliBaseInfoVO") BCntBcpAppliBaseInfoVO bCntBcpAppliBaseInfoVO);

	/**
	 * 根据appno获取信息
	 * @param appno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月19日下午2:36:15
	 */
	public BCntBcpAppliBaseInfoVO findBCntAppliBaseInfoByAppno(@ScubeParam("appno") String appno);

	/**
	 * 根据合同编号获取信息
	 * @param mastContno
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月22日上午10:08:08
	 */
	public BCntBcpAppliBaseInfoVO findBCntAppliBaseInfoByMastContno(@ScubeParam("mastContno") String mastContno);

	/**
	 * 获取客户信息
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年5月23日下午3:34:44
	 */
	public Page queryBCrmBaseInfoSource(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, String> value);
	
	/**
	 * 获取贸易对手信息
	 * @param pageNo
	 * @param pageSize
	 * @param value
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月22日下午4:59:06
	 */
	public Page queryBCrmBaseBusinessInfo(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("value") Map<String, String> value);
	
	/**
	 * 根据产品编号获取产品绑定文件类型信息
	 * @param productId
	 * @return
	 * @author 	mengjiajia
	 * @date 	2017年6月21日下午1:45:34
	 */
	@SuppressWarnings("rawtypes")
	public List findBPrdFileInfoByProductId(@ScubeParam("productId") String productId);

}
