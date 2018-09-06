package com.huateng.scf.nbas.prd.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nbas.prd.model.BPrdFlowVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>业务品种配置属性	接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年6月9日下午1:44:16
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年6月9日下午1:44:16	     新增
 *
 * </pre>
 */
public interface IBPrdFlowService {

	/**
	 * 分页查询列表信息
	 * @param pageNo
	 * @param pageSize
	 * @param bPrdFlowVO
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午1:52:33
	 */
	public Page findBPrdFlowServiceByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bPrdFlowVO") BPrdFlowVO bPrdFlowVO) throws ScubeBizException;

	/**
	 * 新增
	 * @param bPrdFlowVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午2:44:22
	 */
	public void addBPrdFlow(@ScubeParam("bPrdFlowVO") BPrdFlowVO bPrdFlowVO) throws ScubeBizException;

	/**
	 * 修改
	 * @param bPrdFlowVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午2:47:18
	 */
	public void updateBPrdFlow(@ScubeParam("bPrdFlowVO") BPrdFlowVO bPrdFlowVO) throws ScubeBizException;

	/**
	 * 删除
	 * @param list
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午2:50:51
	 */
	public int deleteBPrdFlow(@ScubeParam("list") List<BPrdFlowVO> list) throws ScubeBizException;

	/**
	 * 根据条件获取配置信息
	 * @param productId
	 * @param invokPhase
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月9日下午4:36:55
	 */
	public BPrdFlowVO findBPrdFlowVOByParam(@ScubeParam("productId") String productId,@ScubeParam("invokPhase") String invokPhase) throws ScubeBizException;

	/**
	 * 复制已有信息，改变个别要素，并新增
	 * @param bPrdFlowVO
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年6月13日上午9:41:34
	 */
	void copyBprdFolw(@ScubeParam("bPrdFlowVO") BPrdFlowVO bPrdFlowVO) throws ScubeBizException;

}
