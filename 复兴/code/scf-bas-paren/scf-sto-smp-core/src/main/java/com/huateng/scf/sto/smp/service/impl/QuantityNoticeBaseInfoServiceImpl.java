package com.huateng.scf.sto.smp.service.impl;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.TlrInfoVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.authority.inter.service.ScubeUserService;
import com.huateng.authority.service.UserService;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.dao.ext.ICommonQueryDAO;
import com.huateng.scf.bas.common.util.ScfCommonUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.pbc.service.IBPbcMtgClassService;
import com.huateng.scf.bas.prd.service.IBPrdInfoService;
import com.huateng.scf.bas.sys.service.IBSysCommonService;
import com.huateng.scf.sto.dmp.model.SBcpAppliLowerPrice;
import com.huateng.scf.sto.dmp.service.ISBcpAppliLowerPriceService;
import com.huateng.scf.sto.smp.service.IQuantityNoticeBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("QuantityNoticeBaseInfoServiceImpl")
public class QuantityNoticeBaseInfoServiceImpl implements IQuantityNoticeBaseInfoService {
	
	@Resource(name="commonQueryDAO")
	ICommonQueryDAO commonQueryDAO;
	
	@Autowired
	ScubeUserService scubeUserService;
	
	@Resource(name="bSysCommonService")
	IBSysCommonService bSysCommonService;
	
	@Resource(name="bPbcMtgClassService")
	IBPbcMtgClassService bPbcMtgClassService;
	
	@Resource(name="userService")
	UserService userService;
	
	@Resource(name="bPrdInfoService")
	IBPrdInfoService bPrdInfoService;
	
	@Resource(name="lowerPriceService")
	ISBcpAppliLowerPriceService lowerPriceService;

	@Override
	public Page getNoticeBaseInfo(int pageNo,int pageSize,Map<String, Object> param) {
		Page page = new Page(pageSize, pageNo, 0);
		
		Object conId = param.get("slaveContno");
		Object dateFrom = param.get("dateFrom");
		Object dateTo = param.get("dateTo");
		Object noticeType = param.get("noticeType");
		if(!StringUtil.isEmpty(conId)){
			param.put("slaveContno", conId.toString().toLowerCase());
		}
		/*if(!StringUtil.isEmpty(dateFrom)) {
			try {
				param.put("dateFrom", ScfDateUtil.toDate(dateFrom.toString(), "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(!StringUtil.isEmpty(dateTo)) {
			try {
				param.put("dateTo", ScfDateUtil.toDate(dateTo.toString(), "yyyy-MM-dd"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}*/
		
		if(param.get("brCode") != null && param.get("brName") != null){
			BctlVO bctlVO = new BctlVO();
			bctlVO.setBrNo(param.get("brCode") == null ? null : param.get("brCode").toString());
			bctlVO.setBrName(param.get("brName") == null ? null : param.get("brName").toString());
			Page cooperationBrcodeInfo = bSysCommonService.selectBranchInfo(1, 10, bctlVO);
			List records = cooperationBrcodeInfo.getRecords();
			if (records == null || records.size() != 1) {
				throw new ScubeBizException("经办机构名称与经办机构号不对应,请通过查询按钮选择[经办机构]！");
			}
		}
		
		String productId = bPrdInfoService.getProductIdByFlag(param.get("flag").toString());
		param.put("productId", productId);
		
		commonQueryDAO.selectByPage("EXT_QUANTITYNOTICEBASEINFO.selectByPage",param, page);
		Iterator<Map<String, Object>> it = page.getRecords().iterator();
		while(it.hasNext()){
			Map<String, Object> map = it.next();
			
			Object brcode = map.get("BR_CD");
			if(!StringUtil.isEmpty(brcode)){
				BctlVO bctl = scubeUserService.selectBctlByBrNo(brcode.toString(),ScfCommonUtil.getBrManagerNo(scubeUserService));
				if(null!=bctl){
					map.put("BRNAME", bctl.getBrName());// 将查询结果赋值于页面创建人代码。
				}
			}
			
			//查询客户经理
			Object tlrCd = map.get("TLR_NO");
			if(!StringUtil.isEmpty(tlrCd)){
				UserInfo userInfo2 = new UserInfo();
				userInfo2.setTlrNo(tlrCd.toString());
				List<TlrInfoVO> userList2 = userService.selectByExample(userInfo2);
				if (userList2 != null && userList2.size() == 1) {
					map.put("TLR_NM", userList2.get(0).getTlrName());
				}
			}
			
			//如果是质物最低控货价值通知书书
			if("1".equals(noticeType)){
				Object appno = map.get("APPNO");
				if(!StringUtil.isEmpty(appno)){
					SBcpAppliLowerPrice sBcpAppliLowerPrice = lowerPriceService.findsaveAppliLowPriceByAppno(appno.toString());
					if(sBcpAppliLowerPrice != null){
						map.put("ext1Amount", sBcpAppliLowerPrice.getLowPrice());
						map.put("ext2Amount", sBcpAppliLowerPrice.getLowPriceNew());
					}
				}
			}
		}
		return page;
	}
	
}
