package com.huateng.scf.sto.nwr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliBaseInfoDAO;
import com.huateng.scf.bas.pbc.dao.IBPbcAppliMtgInfoDAO;
import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scf.bas.pbc.service.IBPbcAppliMtgInfoService;
import com.huateng.scf.sto.nwr.service.IBillStandardApplyService;
import com.huateng.scf.sto.nwr.vo.BillStandardMortgageVO;
import com.huateng.scf.sto.nwr.vo.BillstandardAppVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>标准仓单业务申请Service</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月18日上午9:01:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月18日上午9:01:46	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BillStandardApplyServiceImpl")
public class BillStandardApplyServiceImpl implements IBillStandardApplyService 
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name ="BPbcAppliBaseInfoDAO")
	IBPbcAppliBaseInfoDAO bpbcapplibaseinfodao;
	
	//押品业务申请表
	@Resource(name = "BPbcAppliMtgInfoServiceImpl")
	IBPbcAppliMtgInfoService bpbcapplimtginfoservice;
	
	@Resource(name = "BPbcAppliMtgInfoDAO")
	IBPbcAppliMtgInfoDAO bpbcapplimtginfodao;
		
	/**
	 * 通过appno获取业务申请基本信息
	 * @Description: 通过appno获取业务申请基本信息
	 * @author zhangwu
	 * @Created 2013-7-19上午09:48:17
	 * @param appno
	 * @return
	 * @throws CommonException
	 */
	@Override
	public BPbcAppliBaseInfo getAppliBaseInfoByAppno(String appno) throws ScubeBizException
	{
		log.debug("appno="+appno);
		BPbcAppliBaseInfo appliBaseInfo = new BPbcAppliBaseInfo();
		if(!StringUtil.isEmpty(appno)){
			com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo baseInfo = new com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo();
			baseInfo = bpbcapplibaseinfodao.selectByPrimaryKey(appno);
			BeanUtils.copyProperties(baseInfo, appliBaseInfo);
			return appliBaseInfo;
		}else{
			throw new ScubeBizException("业务申请编号丢失！");
		}
	}

	@Override
	public String addModifyDeleteAppMortgageList(String bussAppno, BillstandardAppVO contractVO, List<BillStandardMortgageVO> insertList, List<BillStandardMortgageVO> updateList,
			List<BillStandardMortgageVO> delList) throws ScubeBizException
	{
		String id = null; //
		// String monitorProtocolNo = getMonitorProtocolNoBySlaveContnoAppno("",
		// bussAppno); // 查询该申请从合同对应的监管协议号
		String custcd = contractVO.getSecCd();// 抵质押人
		String slaveContno = contractVO.getSlaveContno(); // 从合同号
		//删除
		List<com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo> list = bpbcapplimtginfoservice.findBPbcAppliMtgInfoByAppno(bussAppno);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				bpbcapplimtginfodao.deleteByPrimaryKey(list.get(i).getId());
			}
		}
		// 增加操作.
		for (int i=0;i<insertList.size();i++)
		{
			BillStandardMortgageVO applyVO = insertList.get(i); // 源对象
			applyVO.setAppno(bussAppno);// 申请编号
			applyVO.setCustcd(custcd); // 客户编号（PK）
			applyVO.setSlaveContno(slaveContno);// 担保合同号
			applyVO.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 经办行
			applyVO.setMonitorProtocolNo(contractVO.getProtocolNo());// 监管协议
			applyVO.setMastContno(contractVO.getMastContno());
			bpbcapplimtginfoservice.saveAppMorgInfoByApplyVO(applyVO); // 保存操作
		}
		// 更新操作.
		for (int i=0;i<updateList.size();i++)
		{
			BillStandardMortgageVO applyVO = updateList.get(i); // 源对象
			// 更新押品信息申请表
			BPbcAppliMtgInfo appMorgBaseInfo = bpbcapplimtginfodao.selectByPrimaryKey(applyVO.getId());
			if(appMorgBaseInfo==null)
			{
				throw new ScubeBizException("押品编号为【" + applyVO.getMortgageNo() + "】的押品信息申请不存在，不能更新");
			}
			applyVO.setCustcd(custcd); // 客户编号（PK）
			applyVO.setSlaveContno(slaveContno);// 担保合同号
			applyVO.setMonitorProtocolNo(contractVO.getProtocolNo());// 监管协议号
			applyVO.setBrcode(ContextHolder.getOrgInfo().getBrNo());// 经办行 // 更新操作
			com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo appliMtgInfo = 
					new com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo();
			BeanUtils.copyProperties(appMorgBaseInfo, appliMtgInfo);
			bpbcapplimtginfoservice.updateAppMorgInfoByApplyVO(appliMtgInfo, applyVO);
		}
		// 删除操作.
		for (int i=0;i<delList.size();i++)
		{
			BillStandardMortgageVO applyVO = delList.get(i); // 源对象
			// 查询押品信息申请表
			BPbcAppliMtgInfo appMorgBaseInfo = bpbcapplimtginfodao.selectByPrimaryKey(applyVO.getId());
			if(appMorgBaseInfo==null)
			{
				throw new ScubeBizException("押品编号为【" + applyVO.getMortgageNo() + "】的押品信息申请不存在，不能更新");
			}
			bpbcapplimtginfodao.deleteByPrimaryKey(appMorgBaseInfo.getId());
		}
		return id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String addModifyDeleteAppMortgageList(String bussAppno, BillstandardAppVO contractVO, List<BillStandardMortgageVO> insertList, List<BillStandardMortgageVO> updateList,
			List<BillStandardMortgageVO> delList,String mortBizType) throws ScubeBizException
	{
		String id = null; //
		String custcd = contractVO.getSecCd();// 抵质押人
		String slaveContno = contractVO.getSlaveContno(); // 从合同号
		//删除
		List<BPbcAppliMtgInfo> list = bpbcapplimtginfoservice.getAppliMortgageByAppliMortBizType(bussAppno, mortBizType);
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				bpbcapplimtginfodao.deleteByPrimaryKey(list.get(i).getId());
			}
		}
		String brcode = ContextHolder.getUserInfo().getBrNo();
		// 增加操作.
		for (int i=0;i<insertList.size();i++)
		{
			BillStandardMortgageVO applyVO = insertList.get(i);//源对象
			applyVO.setAppno(bussAppno);// 申请编号
			applyVO.setCustcd(custcd); // 客户编号（PK）
			applyVO.setSlaveContno(slaveContno);// 担保合同号
			applyVO.setBrcode(brcode);// 经办行
			applyVO.setMonitorProtocolNo(contractVO.getProtocolNo());// 监管协议
			applyVO.setMastContno(contractVO.getMastContno());
			id = bpbcapplimtginfoservice.saveAppMorgInfoByApplyVO(applyVO); // 保存操作
		}
		// 更新操作.
		for (int i=0;i<updateList.size();i++)
		{
			BillStandardMortgageVO applyVO = updateList.get(i); // 源对象
			// 更新押品信息申请表
			BPbcAppliMtgInfo appMorgBaseInfo = bpbcapplimtginfodao.selectByPrimaryKey(applyVO.getId());
			if(appMorgBaseInfo==null)
			{
				throw new ScubeBizException("押品编号为【" + applyVO.getMortgageNo() + "】的押品信息申请不存在，不能更新");
			}
			applyVO.setCustcd(custcd); // 客户编号（PK）
			applyVO.setSlaveContno(slaveContno);// 担保合同号
			applyVO.setMonitorProtocolNo(contractVO.getProtocolNo());// 监管协议号
			applyVO.setBrcode(brcode);// 经办行 // 更新操作
			com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo appliMtgInfo = 
					new com.huateng.scf.bas.pbc.model.BPbcAppliMtgInfo();
			BeanUtils.copyProperties(appMorgBaseInfo, appliMtgInfo);
			bpbcapplimtginfoservice.updateAppMorgInfoByApplyVO(appliMtgInfo, applyVO);
		}
		// 删除操作.
		for (int i=0;i<delList.size();i++)
		{
			BillStandardMortgageVO applyVO = delList.get(i);// 源对象
			// 查询押品信息申请表
			BPbcAppliMtgInfo appMorgBaseInfo = bpbcapplimtginfodao.selectByPrimaryKey(applyVO.getId());
			if(appMorgBaseInfo==null)
			{
				throw new ScubeBizException("押品编号为【" + applyVO.getMortgageNo() + "】的押品信息申请不存在，不能更新");
			}
			bpbcapplimtginfodao.deleteByPrimaryKey(appMorgBaseInfo.getId());
		}
		return id;
	}

}
