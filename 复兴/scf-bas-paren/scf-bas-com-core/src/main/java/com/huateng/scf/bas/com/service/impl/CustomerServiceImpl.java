package com.huateng.scf.bas.com.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.service.ICustomerService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crm.model.BCrmBaseInfo;
import com.huateng.scf.bas.crm.service.IBCrmBaseInfoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>公共类		实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月28日下午7:12:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月28日下午7:12:53	     新增
 *
 * </pre>
 */
@ScubeService
@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements ICustomerService {
	
	@Resource(name = "BCrmBaseInfoServiceImpl")
	IBCrmBaseInfoService bcrmbaseinfoservice;
	
	/**
	 * @Description: 拼接协管客户 经理
	 * @author mengjiajai
	 * @Created 2012-11-6下午4:25:06
	 * @param param 查询参数
	 * @param type 查询类型：1、查询所有协管客户；2、查询所有主管客户；3、查询所有管理客户
	 * @param custcd 客户号
	 * @return
	 * @throws ScubeBizException
	 */
	@Override
	public List<String> getCustcdsQueryCondition(String param,String type,String mgrno) throws ScubeBizException
	{
		List<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		String cuscdStr = "";
		if (type.equals(ScfBasConstant.QUERY_TYPE_MAG_ALL_AID)) { // 查询所有协管客户号
			cuscdStr = this.getAidCuscdStrByMgrno(mgrno);
			if(!StringUtil.isEmpty(cuscdStr)){
				sb.append(" and ").append(param).append(" in (").append(cuscdStr).append(") ");
			}else{
				sb.append(" and 1=2 ");
			}
			return list;
			//查询所有主管客户直接使用TblCustBaseInfo.mgrno去匹配即可
//		} else if (type.equals(ScfBasConstant.QUERY_TYPE_MAG_ALL_MAS)) {// 查询所有主管客户
//			cuscdStr = this.getMasterCuscdStrByMgrno(mgrno);
//			if(!StringUtil.isEmpty(cuscdStr)){
//				sb.append(" and ").append(param).append(" in (").append(cuscdStr).append(") ");
//			}else{
//				sb.append(" and 1=2 ");
//			}
//			return sb.toString();
		} else if (type.equals(ScfBasConstant.QUERY_TYPE_MAG_ALL)) {// 查询所有管理客户
			cuscdStr = this.getMasterCuscdStrByMgrno(mgrno);
			String aidCustds = this.getAidCuscdStrByMgrno(mgrno);
			if(!StringUtil.isEmpty(cuscdStr) && !StringUtil.isEmpty(aidCustds)){
				list.add(cuscdStr);
				list.add(aidCustds);
//				sb.append(" and ").append(param).append(" in (").append(cuscdStr).append(") ");
			}else if(!StringUtil.isEmpty(cuscdStr) && StringUtil.isEmpty(aidCustds)){
				list.add(cuscdStr);
//				sb.append(" and ").append(param).append(" in (").append(cuscdStr).append(") ");
			}else if(StringUtil.isEmpty(cuscdStr) && !StringUtil.isEmpty(aidCustds)){
				sb.append(" and ").append(param).append(" in (").append(aidCustds).append(") ");
			}else if(StringUtil.isEmpty(cuscdStr) && StringUtil.isEmpty(aidCustds)){
				sb.append(" and 1=2 ");
			}
			return list;
		} else {
			return list;
		}
	}
	
	/**
	 * @Description: 拼接协管客户号
	 * @author mengjiajia
	 * @Created 2012-11-6下午7:06:18
	 * @param mgrno
	 * @return
	 * @throws ScubeBizException
	 * 无TblCustAidMagInfo表，返回null
	 */
	private String getAidCuscdStrByMgrno(String mgrno) throws ScubeBizException{
//		List<TblCustAidMagInfo> list = getAidManagerInfoListByCustcd(mgrno);
//		if (list != null && list.size() == 0)
//			return "";
//
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < list.size(); i++) {
//			String custcd = StringUtil.trim(list.get(i).getCustcd());
//			if (i == 0) {
//				sb.append("'").append(custcd).append("'");
//			} else {
//				sb.append(", '").append(custcd).append("'");
//			}
//		}
//		return sb.toString();
		return "";
	}
	
	/**
	 * @Description: 拼接主管客户号
	 * @author mengjiajia
	 * @Created 2012-11-6下午7:07:41
	 * @param mgrno
	 * @return
	 * @throws ScubeBizException
	 */
	private String getMasterCuscdStrByMgrno(String mgrno) throws ScubeBizException{
		List<BCrmBaseInfo> list = getCustBaseInfoListByMgrno(mgrno);
		if (list != null && list.size() == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			BCrmBaseInfo baseInfo = list.get(i);
			String custcd = baseInfo.getCustcd();
			if (i == 0) {
				sb.append("'").append(custcd).append("'");
			} else {
				sb.append(", '").append(custcd).append("'");
			}
		}
		return sb.toString();
	}
	
	/**
	 * @Description: 根据客户经理号查询协管客户关系表
	 * @author xiong_xiaolong
	 * @Created 2012-11-6下午7:04:55
	 * @param mgrno
	 * @return
	 * @throws ScubeBizException
	 */
//	public List<TblCustAidMagInfo> getAidManagerInfoListByCustcd(String mgrno) throws ScubeBizException{
//		TblCustAidMagInfoDAO tblCustAidMagInfoDAO = SCFDAOUtils.getTblCustAidMagInfoDAO();
//		List<TblCustAidMagInfo> list = tblCustAidMagInfoDAO.queryByCondition("po.creditTlrno = '" + mgrno + "' and po.status = '" + SCFConstants.FLAG_VALID + "' order by po.custcd");
//		return list;
//	}
	
	/**
	 * @Description: 根据客户经理号查询主管客户列表
	 * @author mengjiajia
	 * @Created 2012-11-6下午7:05:16
	 * @param mgrno
	 * @return
	 * @throws ScubeBizException
	 */
	public List<BCrmBaseInfo> getCustBaseInfoListByMgrno(String mgrno) throws ScubeBizException{
		List<BCrmBaseInfo> list = bcrmbaseinfoservice.queryByCondition(mgrno);
		return list;
	}
}
