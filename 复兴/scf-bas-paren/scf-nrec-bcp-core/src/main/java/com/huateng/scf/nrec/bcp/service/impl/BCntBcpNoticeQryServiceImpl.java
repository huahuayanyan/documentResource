package com.huateng.scf.nrec.bcp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.crm.dao.IBCrmBaseInfoDAO;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBase;
import com.huateng.scf.nrec.bcp.dao.IBCntBcpNoticeQryDAO;
import com.huateng.scf.nrec.bcp.service.IBCntBcpNoticeQryService;
import com.huateng.scf.rec.nte.model.BNteNoticeBaseCon;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service(IBCntBcpNoticeQryService.BeanId)
public class BCntBcpNoticeQryServiceImpl implements IBCntBcpNoticeQryService {

	@Resource(name=IBCntBcpNoticeQryDAO.BeanId)
	IBCntBcpNoticeQryDAO bCntBcpNoticeQryDAO;
	
	@Autowired
	UserService userService;
	@Autowired
	OrgService orgService;
	
	@Resource(name = "IBCrmBaseInfoDAO")
	IBCrmBaseInfoDAO bcrmbaseinfodao;
	
	/**
	 * 查询应收账款转让/出质通知书列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param bNteNoticeBaseCon
	 * @return
	 */
	@Override
	public Page queryFactoringNoticeCommon(int pageNo,int pageSize,Map<String, Object> bNteNoticeBaseCon) {
		if(bNteNoticeBaseCon==null){
			bNteNoticeBaseCon = new HashMap<String, Object>();
		}
		// 查询权限设置
		HashMap<String, List<String>> map = ScfMessageUtil.transSysParamByKey(ScfBasConstant.QUERY_LIMITS);
		bNteNoticeBaseCon.putAll(map);
		
		int total = bCntBcpNoticeQryDAO.countFactoringNoticeCommon(bNteNoticeBaseCon);
		Page page = new Page(pageSize, pageNo, total);
		List<BNteNoticeBase> list =bCntBcpNoticeQryDAO.findFactoringNoticeCommon(bNteNoticeBaseCon,page);
		List<BNteNoticeBaseCon> resultList = new ArrayList<BNteNoticeBaseCon>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				com.huateng.scf.bas.nte.dao.model.BNteNoticeBase baseInfo = list.get(i);
				BNteNoticeBaseCon bb = new BNteNoticeBaseCon();
				BeanUtils.copyProperties(baseInfo, bb);
				if (baseInfo != null)
				{
					bb.setCustName(bcrmbaseinfodao.selectById(bb.getCustcd()).getCname());
					bb.setOtherCustName(bcrmbaseinfodao.selectById(bb.getOtherCustcd()).getCname());
					UserInfo userInfo = new UserInfo();
					userInfo.setTlrNo(bb.getTlrn());// 搜索创建人对应的名称。
					List<TlrInfoVO> userList = userService.selectByExample(userInfo);
					if (userList != null && userList.size() > 0) {
						bb.setKhjl(userList.get(0).getTlrName());// 客户经理
					} else {
						bb.setKhjl(null);
					}

					BctlVO bctlVO = new BctlVO();
					bctlVO.setBrNo(bb.getBrcode());
					List<BctlVO> bctlVOList = orgService.selectByExample(bctlVO);
					if (bctlVOList != null && bctlVOList.size() > 0) {
						bb.setJbjg(bctlVOList.get(0).getBrName());// 经办机构
					} else {
						bb.setJbjg(null);
					}
				}
				resultList.add(bb);
			}
		}
		page.setRecords(resultList);
		page.setTotalRecord(total);
		return page;
	}
}
