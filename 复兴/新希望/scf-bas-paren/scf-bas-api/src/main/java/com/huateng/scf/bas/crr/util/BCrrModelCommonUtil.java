/**
 * 
 */
package com.huateng.scf.bas.crr.util;

import java.util.Date;

import com.huateng.authority.common.ContextHolder;
import com.huateng.authority.entity.BctlVO;
import com.huateng.authority.entity.UserInfo;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.crr.model.BCrrModel;

/**
 * <p>供应链公共处理</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月10日下午8:32:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月10日下午8:32:01	                                 新增
 *
 * </pre>
 */
public class BCrrModelCommonUtil {
	/**
	 * 公共字段设置
	 * @param scfBaseModel
	 * 		ScfBaseModel-继承自ScfBaseModel对象
	 * @return ScfBaseModel对象
	 */
	public static BCrrModel setAddField(BCrrModel bCrrModel){
		 // 获取当前用户 
	     UserInfo user = ContextHolder.getUserInfo(); 
	     String tlrNo = user.getTlrNo();
	     String tlrNm = user.getTlrName();
	     //获取机构信息
	     BctlVO BctlVO = ContextHolder.getOrgInfo();
	     String brCd = BctlVO.getBrNo();
	     String brNm = BctlVO.getBrName();
	     bCrrModel.setTlrNo(tlrNo);// 创建人
	     bCrrModel.setTlrNm(tlrNm);
	     bCrrModel.setBrCd(brCd);
	     bCrrModel.setBrNm(brNm);
	     bCrrModel.setInpDt(ScfDateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
	     bCrrModel.setLstUpdTlr(tlrNo);//最后更新人
	     bCrrModel.setLstUpdTlrNm(tlrNm);
	     bCrrModel.setLstUpdBrCd(brCd);
	     bCrrModel.setLstUpdBrNm(brNm);
	     bCrrModel.setLstUpdDt(ScfDateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		 return bCrrModel;
	}
	
	public static BCrrModel setUpdateField(BCrrModel bCrrModel){
		 // 获取当前用户 
	     UserInfo user = ContextHolder.getUserInfo(); 
	     String tlrNo = user.getTlrNo();
	     String tlrNm = user.getTlrName();
	     //获取机构信息
	     BctlVO BctlVO = ContextHolder.getOrgInfo();
	     String brCd = BctlVO.getBrNo();
	     String brNm = BctlVO.getBrName();
	     bCrrModel.setLstUpdTlr(tlrNo);//最后更新人
	     bCrrModel.setLstUpdTlrNm(tlrNm);
	     bCrrModel.setLstUpdBrCd(brCd);
	     bCrrModel.setLstUpdBrNm(brNm);
	     bCrrModel.setLstUpdDt(ScfDateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		 return bCrrModel;
	}
}
