package com.huateng.scf.nrec.bcp.service;

import java.util.HashMap;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.model.BCntCostInfoVO;
import com.huateng.scf.nrec.bcp.model.BCntBcpInfoVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>
 * 应收类合同管理 接口类
 * </p>
 *
 * @author mengjiajia
 * @date 2017年5月19日下午3:51:34
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月19日下午3:51:34	     新增
 *
 *            </pre>
 */
public interface IBCntBcpInfoService {
	/**
	 * 查询业务申请列表信息
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bCntBcpAppliBaseInfo
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月19日上午10:53:29
	 */
	public Page queryBCntBcpInfoByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("bCntBcpInfoVO") BCntBcpInfoVO bCntBcpInfoVO);

	/**
	 * 修改合同信息与贸易对手信息
	 * 
	 * @param bcntBcpInfoVO
	 * @return
	 * @author mengjiajia
	 * @date 2017年5月22日上午10:47:46
	 */
	public void saveOrUpdateBCntBcpInfo(@ScubeParam("bcntBcpInfoVO") BCntBcpInfoVO bcntBcpInfoVO,
			@ScubeParam("bCntCostInfoVO") BCntCostInfoVO bCntCostInfoVO) throws ScubeBizException;

	/**
	 * 通过合同号查询对应费用信息
	 * 
	 * @param mastContno
	 * @throws ScubeBizException
	 * @author lihao
	 * @date 2017年6月26日上午10:42:57
	 */
	public BCntCostInfoVO queryCntCostInfoByMastContno(@ScubeParam("key") String mastContno) throws ScubeBizException;

	/**
	 * 未生效合同信息生效
	 * 
	 * @param bcntBcpInfoVO
	 * @author mengjiajia
	 * @date 2017年5月22日下午1:40:15
	 */
	public void setContStatus(@ScubeParam("bcntBcpInfoVO") BCntBcpInfoVO bcntBcpInfoVO);

	/**
	 * 通过合同号查询合同信息
	 * 
	 * @param bcntBcpInfoVO
	 * @author lihao
	 * @date 2017年5月22日下午1:40:15
	 */
	public BCntBcpInfoVO queryBCntBcpInfoByMastContno(@ScubeParam("key") String mastContno);

	/**
	 * 通过合同号查询合同信息简洁版本只查合同信息，不翻译字段和池信息
	 * 
	 * @param bcntBcpInfoVO
	 * @author lihao
	 * @date 2017年5月22日下午1:40:15
	 */
	public BCntBcpInfoVO queryOnlyBCntBcpInfoByMastContno(@ScubeParam("key") String mastContno);

	/**
	 * 业务编号筛选
	 * 
	 * @param custcd
	 * @return
	 * @throws ScubeBizException
	 * @author mengjiajia
	 * @date 2017年5月23日下午3:41:58
	 */
	public Page getMastContno(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") HashMap<String, String> value) throws ScubeBizException;

	// 页面下拉菜单查询使用（根据客户号和业务合同号查询）
	public Page queryBCntBcpInfoForSelect(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") BCntBcpInfoVO bCntBcpInfoVO) throws ScubeBizException;

	/**
	 * 查询合同详情信息，双保理业务贸易对手保理商信息，信保保理保险信息
	 * 
	 * @param mastContno
	 * @return
	 * @author mengjiajia
	 * @date 2017年6月13日下午2:44:34
	 */
	public BCntBcpInfoVO findBCntBcpInfoByMastContno(@ScubeParam("bCntBcpInfoVO") BCntBcpInfoVO bCntBcpInfoVO);
}
