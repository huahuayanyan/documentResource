/**
 * 
 */
package com.huateng.scf.bas.cnt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntMprotPartInfoDAO;
import com.huateng.scf.bas.cnt.dao.ext.ExtIBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample.Criteria;
import com.huateng.scf.bas.cnt.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.service.IBCntMprotPartInfoService;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.model.DeliveryApplyQryVO;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.rec.bcp.constant.RBcpErrorConstant;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年12月15日上午10:47:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年12月15日上午10:47:42	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("BCntMprotPartInfoServiceImpl")
public class BCntMprotPartInfoServiceImpl implements IBCntMprotPartInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BCntMprotPartInfoDAO")
	IBCntMprotPartInfoDAO bCntMprotPartInfoDAO;

	@Resource(name = "BCntMprotBaseInfoDAO")
	IBCntMprotBaseInfoDAO bCntMprotBaseInfoDAO;

	@Resource(name = "ExtBCntMprotBaseInfoDAO")
	ExtIBCntMprotBaseInfoDAO extcntdao;

	/**
	 * 通过protocolNo获得参与者的信息
	 */
	public List<BCntMprotPartInfo> findBCntMpartInfoByProtocolNo(String protocolNo) throws ScubeBizException {
		List<BCntMprotPartInfo> list = new ArrayList<BCntMprotPartInfo>();
		BCntMprotPartInfo bCntMprotPartInfo = null;
		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo> listdal = bCntMprotPartInfoDAO.findBCntMpartInfoByProtocolNo(protocolNo);
		for (com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo info : listdal) {
			bCntMprotPartInfo = new BCntMprotPartInfo();
			BeanUtils.copyProperties(info, bCntMprotPartInfo);
			list.add(bCntMprotPartInfo);
		}
		return list;
	}

	/**
	 * @Description: 根据协议号和角色类型返回对应的客户名称
	 * @author xu_hong
	 * @Created 2012-10-19上午09:52:04
	 * @param protocolNo
	 *            协议号
	 * @param role
	 *            角色类型
	 * @param returnFlag
	 *            返回类型
	 * @return
	 */
	@Override
	public String findCnameByProAndRole(String protocolNo, String role, String returnFlag) {
		String cname = new String();
		HashMap<String, String> omap = new HashMap<String, String>();
		omap.put("protocolNo", protocolNo);
		omap.put("role", role);
		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo> list = extcntdao.queryMprotPart(omap);
		if (list != null && list.size() > 0) {
			if (ScfBasConstant.RETURN_FLAG_CNAME.equals(returnFlag)) {// 查客户名称
				cname = list.get(0).getCname();
			} else {
				cname = list.get(0).getCustcd();
			}
		}
		return cname;
	}

	/**
	 * @Description: 通过protocolNo查找核心厂商
	 * @author mengjiajia
	 * @Created 2012-10-18下午08:14:17
	 * @param protocolNo
	 * @return
	 */
	@Override
	public BCntMprotPartInfo findCoreorCustByProtocolNo(String protocolNo, String role) throws ScubeBizException {
		log.debug("protocolNo:" + protocolNo + ",role:" + role);

		BCntMprotPartInfoExample example = new BCntMprotPartInfoExample();
		BCntMprotPartInfoExample.Criteria cri = example.createCriteria();
		cri.andProtocolNoEqualTo(protocolNo);
		cri.andRoleEqualTo(role);
		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo> list = bCntMprotPartInfoDAO.selectByExample(example);

		BCntMprotPartInfo tblMutiProtPartInfo = new BCntMprotPartInfo();

		if (list.size() == 0) {
			if (ScfBasConstant.PROTOCOL_PART_ROLE_CREDIT.equals(role)) {
				throw new ScubeBizException("经销商不存在，协议号为：" + protocolNo, RBcpErrorConstant.RECORD_NOT_EXIST);
			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_CORE.equals(role)) {
				throw new ScubeBizException("核心厂商不存在，协议号为：" + protocolNo, RBcpErrorConstant.RECORD_NOT_EXIST);

			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_MONI.equals(role)) {
				throw new ScubeBizException("监管公司不存在，协议号为：" + protocolNo, RBcpErrorConstant.RECORD_NOT_EXIST);

			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_BANK.equals(role)) {
				throw new ScubeBizException("银行不存在，协议号为：" + protocolNo, RBcpErrorConstant.RECORD_NOT_EXIST);

			} else if (ScfBasConstant.PROTOCOL_PART_ROLE_BACKCORE.equals(role)) {
				throw new ScubeBizException("回购厂商不存在，协议号为：" + protocolNo, RBcpErrorConstant.RECORD_NOT_EXIST);

			} else {

				throw new ScubeBizException("对应的角色不存在", RBcpErrorConstant.RECORD_NOT_EXIST);
			}

		} else {
			com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo cntMprotPartInfo = list.get(0);
			BeanUtils.copyProperties(cntMprotPartInfo, tblMutiProtPartInfo);
		}

		return tblMutiProtPartInfo;
	}

	/**
	 *
	 * @Description: 根据条件查询协议角色信息
	 * @author mengjiajia
	 * @Created 2012-7-25下午5:05:42
	 * @param commonQueryVO
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public Page getMutiProtPartInfoByPara(DeliveryApplyQryVO commonQueryVO) throws ScubeBizException {
		BCntMprotPartInfoExample example = new BCntMprotPartInfoExample();
		BCntMprotPartInfoExample.Criteria cri = example.createCriteria();
		if (!StringUtil.isEmpty(commonQueryVO.getProtocolNo())) {
			cri.andProtocolNoEqualTo(commonQueryVO.getProtocolNo());
		}
		if (!StringUtil.isEmpty(commonQueryVO.getRole_Q())) {
			cri.andRoleEqualTo(commonQueryVO.getRole_Q());
		}
		// added by xu_hong 2012-11-29 增加查询参数：客户号 start
		if (!StringUtil.isEmpty(commonQueryVO.getCustcd())) {
			cri.andCustcdEqualTo(commonQueryVO.getCustcd());
		}
		// added by xu_hong 2012-11-29 增加查询参数：客户号 end
		int total = bCntMprotPartInfoDAO.countByExample(example);
		Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), total);
		page.setRecords(bCntMprotPartInfoDAO.selectByPage(example, page));
		page.setTotalRecord(total);
		return page;
	}

	/*
	 * 
	 * 
	 * 
	 */
	@Override
	public BCntMprotPartInfo getMoniMutiProtPartInfoByProAndRole(DeliveryApplyQryVO commonQueryVO) throws ScubeBizException {
		if (commonQueryVO == null) {
			return null;
		}
		BCntMprotBaseInfoExample bCntMprotBaseInfoExample = new BCntMprotBaseInfoExample();
		com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfoExample.Criteria createCriteria2 = bCntMprotBaseInfoExample.createCriteria();
		createCriteria2.andOtherprotocolNoEqualTo(commonQueryVO.getProtocolNo());
		createCriteria2.andStateEqualTo("1");// 查询有效的合同
		createCriteria2.andProtocolTypeEqualTo("01");// 监管协议
		List<BCntMprotBaseInfo> bCntMprotBaseInfoList = bCntMprotBaseInfoDAO.selectByExample(bCntMprotBaseInfoExample);
		if (bCntMprotBaseInfoList == null || bCntMprotBaseInfoList.size() != 1) {
			return null;
		} else {

			BCntMprotPartInfoExample bCntMprotPartInfoExample = new BCntMprotPartInfoExample();
			Criteria createCriteria = bCntMprotPartInfoExample.createCriteria();
			createCriteria.andProtocolNoEqualTo(bCntMprotBaseInfoList.get(0).getProtocolNo());
			createCriteria.andRoleEqualTo(commonQueryVO.getRole_Q());
			List<com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo> bCntMprotPartInfoList = bCntMprotPartInfoDAO
					.selectByExample(bCntMprotPartInfoExample);
			BCntMprotPartInfo bCntMprotPartInfo = new BCntMprotPartInfo();
			if (bCntMprotPartInfoList != null && bCntMprotPartInfoList.size() == 1) {
				BeanUtils.copyProperties(bCntMprotPartInfoList.get(0), bCntMprotPartInfo);
				return bCntMprotPartInfo;
			} else {
				return null;
			}
		}

	}
	

	/**
	 * 根据抵/质押合同号，查询监管公司信息
	 * @param slaveContno
	 * @return
	 * @throws ScubeBizException
	 * @author 	mengjiajia
	 * @date 	2017年4月18日上午10:33:59
	 */
	@Override
	public Page getMutiProtPartInfo(String slaveContno) throws ScubeBizException
	{
		HashMap<String, Object> omap = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(slaveContno))
		{
			omap.put("slaveContno", slaveContno);
			omap.put("role", ScfBasConstant.PROTOCOL_PART_ROLE_MONI);
		}
		else 
		{
			throw new ScubeBizException("抵/质押合同缺失，无法查询监管公司信息",RBcpErrorConstant.ERROR_CODE_UNKNOWN);
		}
		Page page = new Page(1, 1, 1);
		page.setRecords(extcntdao.getMutiProtPartInfo(omap));
		return page;
	}
	
	/**
	 * description：根据协议编号及角色查询参与者信息
	 * @param protocolNo
	 * @param role
	 * @return
	 * @throws CommonException
	 * @date 2013-2-19
	 * @author zhaoyang.lv
	 */
	@Override
	public BCntMprotPartInfo findCustByProtocolNoAndRole(String protocolNo,String role) throws ScubeBizException
	{
		BCntMprotPartInfoExample example = new BCntMprotPartInfoExample();
		BCntMprotPartInfoExample.Criteria cri = example.createCriteria();
		cri.andProtocolNoEqualTo(protocolNo);
		cri.andRoleEqualTo(role);
		List<com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo> list = bCntMprotPartInfoDAO.selectByExample(example);
		if (list!=null&&list.size()>0){
			BCntMprotPartInfo bCntMprotPartInfo = new BCntMprotPartInfo();
			BeanUtils.copyProperties(list.get(0), bCntMprotPartInfo);
			return bCntMprotPartInfo;
		}
		return null;
	}
}
