/**
 * 
 */
package com.huateng.scf.bas.cnt.service;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.model.DataItemsDO;
import com.huateng.scf.bas.cnt.model.DataItemsVO;
import com.huateng.scf.bas.cnt.model.MonitorProtocolDO;
import com.huateng.scf.bas.cnt.model.MonitorProtocolVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 监管合同接口
 * </p>
 *
 * @author qichengcheng
 * @date 2016年11月29日下午3:58:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日下午3:58:51              新增
 *
 *            </pre>
 */
public interface IMonitorProtocolService {
	/**
	 * 监管合同列表查询
	 * 
	 * @param pageNo
	 *            int-当前页码
	 * @param pageSize
	 *            int-每页大小
	 * @param monitorProtocolDO
	 *            monitorProtocol对象
	 * @return Page对象
	 * @throws ScubeBizException
	 */
	public Page queryMonitorProtocolListByPage(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("monitorProtocol") MonitorProtocolDO monitorProtocol, @ScubeParam("parentId") String parentId);

	/**
	 * 监管合同新增
	 * 
	 * @param MonitorProtocolVO
	 *            monitorProtocolVO对象
	 * @throws ScubeBizException
	 */
	public void monitorProtocolAdd(@ScubeParam("monitorProtocolVO") MonitorProtocolVO monitorProtocolVO) throws ScubeBizException;

	/**
	 * 监管合同查询
	 * 
	 * @param protocolCode
	 * @throws ScubeBizException
	 */
	public MonitorProtocolVO monitorProtocolQuery(@ScubeParam("protocolCode") String protocolCode);

	/**
	 * 监管合同修改
	 * 
	 * @param MonitorProtocolVO
	 * @throws ScubeBizException
	 */
	public void monitorProtocolUpdate(@ScubeParam("monitorProtocolVO") MonitorProtocolVO monitorProtocolVO) throws ScubeBizException;
	
	/**
	 * 监管商变更
	 * 
	 * @param MonitorProtocolVO
	 * @throws ScubeBizException
	 */
	public void monitorProtocolChangeUpdate(@ScubeParam("monitorProtocolVO") MonitorProtocolVO monitorProtocolVO) throws ScubeBizException;

	/**
	 * 监管合同删除
	 * 
	 * @param MonitorProtocolVO
	 * @throws ScubeBizException
	 */
	public void monitorProtocolDelete(@ScubeParam("monitorProtocolVO") List<MonitorProtocolVO> monitorProtocolVO);

	/**
	 * 初始化页面的用户及机构信息
	 * 
	 * @return ThreeProtocolVO
	 * @throws ScubeBizException
	 */
	public MonitorProtocolVO initPageUserOrg();

	/**
	 * 查询业务品种
	 * 
	 * @param dataItemsDO
	 * @return
	 */
	public List<DataItemsVO> getProductId(@ScubeParam("dataItemsDO") DataItemsDO dataItemsDO);

	/**
	 * 查询出质人名称
	 * 
	 * @param value
	 * @return
	 */
	public Page getSecNamebyProtocol(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") MonitorProtocolVO value);

	/**
	 * 查询监管公司名称
	 * 
	 * @param value
	 * @return
	 */
	public Page getThrNamebyProtocol(@ScubeParam("pageNo") int pageNo, @ScubeParam("pageSize") int pageSize,
			@ScubeParam("value") MonitorProtocolVO value);

	/**
	 * 查询监管公司信息
	 * 
	 * @param key
	 * @return
	 */
	public MonitorProtocolVO getThrNamebycustCd(@ScubeParam("key") String key);

}
