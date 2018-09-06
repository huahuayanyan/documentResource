package com.huateng.scf.rec.nte.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.service.OrgService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.IBNteNoticeBaseDAO;
import com.huateng.scf.rec.nte.model.BNteNoticeBaseCon;
import com.huateng.scf.rec.nte.service.IRNteNoticeBaseService;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * </p>
 *
 * @author liph
 * @date 2016年12月15日上午9:25:25
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * liph		2016年12月15日上午9:25:25	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("RNteNoticeBaseInfoImpl")
public class RNteNoticeBaseInfoImpl implements IRNteNoticeBaseService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "BNteNoticeBaseDAO")
	IBNteNoticeBaseDAO bNteNoticeBaseDAO;
	@Resource(name = "userService")
	UserService userService;
	@Resource(name = "orgService")
	OrgService orgService;

	/**
	 * @author liph
	 * @param 通知书查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Page findNoticeBaseInfoByCondition(int pageNo, int pageSize, BNteNoticeBaseCon bNteNoticeBaseCon) {
		Map map = new HashMap();
		map.put("sallerName", bNteNoticeBaseCon.getSallerName());
		map.put("mastContno", bNteNoticeBaseCon.getMastContno());
		map.put("bussType", bNteNoticeBaseCon.getBussType());
		map.put("noticeType", bNteNoticeBaseCon.getNoticeType());
		map.put("noticeTypes", bNteNoticeBaseCon.getNoticeTypes());
		map.put("status", bNteNoticeBaseCon.getStatus());
		map.put("brcode", bNteNoticeBaseCon.getBrcode());
		map.put("startQf", bNteNoticeBaseCon.getStartQf());
		map.put("endQf", bNteNoticeBaseCon.getEndQf());
		map.put("startHz", bNteNoticeBaseCon.getStartHz());
		map.put("endHz", bNteNoticeBaseCon.getEndHz());
		Page page = new Page(pageSize, pageNo, 0);
		List<com.huateng.scf.bas.nte.dao.model.BNteNoticeBase> list = bNteNoticeBaseDAO.queryNteBaseInfo(map, page);
		List resultList = new ArrayList();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				com.huateng.scf.bas.nte.dao.model.BNteNoticeBase baseInfo = list.get(i);
				BNteNoticeBaseCon bb = new BNteNoticeBaseCon();
				BeanUtils.copyProperties(baseInfo, bb);
				if (baseInfo != null) {
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
		return page;
	}
}
