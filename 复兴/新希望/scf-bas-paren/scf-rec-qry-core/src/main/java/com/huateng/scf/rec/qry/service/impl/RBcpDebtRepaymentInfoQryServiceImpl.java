package com.huateng.scf.rec.qry.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.service.DictionaryService;
import com.huateng.base.common.beans.Page;
import com.huateng.data.model.BdDataDictionary;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;
import com.huateng.scf.rec.bcp.model.DebtCommonQryVO;
import com.huateng.scf.rec.bcp.service.IRBcpDebtBussInfoService;
import com.huateng.scf.rec.qry.service.IRBcpDebtRepaymentInfoQryService;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("RBcpDebtRepaymentInfoQryServiceImpl")
public class RBcpDebtRepaymentInfoQryServiceImpl implements IRBcpDebtRepaymentInfoQryService {
	
	@Resource(name="RBcpDebtBussInfoServiceImpl") 
	IRBcpDebtBussInfoService rBcpDebtBussInfoService;
	
	@Autowired
	DictionaryService dictionaryService;

	@SuppressWarnings("unchecked")
	@Override
	public Page getDebtRepaymentInfo(int pageSize,int pageNo,DebtCommonQryVO commonQueryVO) {

		String roleFlag = "0"; //岗位标志位
		List<String>  roleList=ContextHolder.getUserInfo().getRoleList();
		if(roleList!=null&&roleList.size()>0){
			for (int i = 0; i < roleList.size(); i++) {
				Object role = roleList.get(i);
				//判断方式：当前角色当中包含有除客户经理外的其它岗位，Flag为1
				if(!ScfBasConstant.ROLE_ID_MANAGER.equals(String.valueOf(role))){
					roleFlag = "1";
					break;
				}else{
					roleFlag = "0";
				}
			}
		}
		
		if("0".equals(roleFlag)){
			commonQueryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_MANAGER);
		}else{
			commonQueryVO.setFlag(ScfBasConstant.CUST_QUERY_TYPE_BY_BCTL);
		}
		if(StringUtil.isStrEmpty(commonQueryVO.getBrcode())){
			commonQueryVO.setBrcode(ContextHolder.getOrgInfo().getBrNo());
		}
		
		@SuppressWarnings("unused")
		Page page = new Page(pageSize, pageNo, 0);
		//取得应收账款池融资支持业务类型
		BdDataDictionary bdDataDictionary = new BdDataDictionary();
		bdDataDictionary.setDictCode("vidBusTypPool");
		Page p = dictionaryService.select(1, 999, bdDataDictionary);
		List<Map<String, Object>> list = p.getRecords();
		List<String> dataNoTemp = new ArrayList<String>();
		if(list!=null && list.size() > 0){
			int count = list.size();
			for(int i=0;i<count;i++){
				Map<String, Object> map = list.get(i); 
				dataNoTemp.add(map.get("dataVal").toString());
			}
		}
		commonQueryVO.setBussTypeList_Q(dataNoTemp);
		
		Page pageQueryResult  = rBcpDebtBussInfoService.queryDebtRepaymentInfo(commonQueryVO,pageSize,pageNo);
		
		return pageQueryResult;
	}

}
