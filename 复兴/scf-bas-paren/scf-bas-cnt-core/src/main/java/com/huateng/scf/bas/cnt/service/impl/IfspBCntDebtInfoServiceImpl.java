/**
 * 
 */
package com.huateng.scf.bas.cnt.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.constant.BCntBizConstant;
import com.huateng.scf.bas.cnt.dao.IBCntDebtExtInfoDAO;
import com.huateng.scf.bas.cnt.dao.IBCntDebtInfoDAO;
import com.huateng.scf.bas.cnt.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.model.BCntDebtInfoVO;
import com.huateng.scf.bas.cnt.model.MastContQryVO;
import com.huateng.scf.bas.cnt.service.IIfspBCntDebtInfoService;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>保理池合同查询
 * </p>
 *
 * @author zhangcheng
 * @date 2017年3月4日下午4:54:29
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2017年3月4日下午4:54:29	     新增
 *
 *            </pre>
 */
@ScubeService
@Service("IfspBCntDebtInfoServiceImpl")
public class IfspBCntDebtInfoServiceImpl implements IIfspBCntDebtInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BCntDebtInfoDAO")
	IBCntDebtInfoDAO iBCntDebtInfoDAO;
	@Resource(name = "BCntDebtExtInfoDAO")
	IBCntDebtExtInfoDAO iBCntDebtExtInfoDAO;
	private static final String CNAME = "cname";
	private static final String BUYERNAME = "buyerName";
	private static final String CONTSTATUS = "contStatus";
	private static final String DEBTCONTNO = "debtContno";

	private static final String CUSTCD = "custcd";
	private static final String FINANCINGTYPE = "financingType";
	private static final String FACTTYPES = "factTypes";

	
	

	

	/**
	 * 应收账款合同查询列表
	 */
	@Override
	public Page queryBCntDebtInfoListByPage(int pageNo, int pageSize, MastContQryVO mastContQryVO)
			throws ScubeBizException {
		Page p = new Page(pageSize, pageNo, 0);
		Map<String, Object> map = new HashMap<String, Object>();

		if (null != mastContQryVO) {
			String cname = mastContQryVO.getCname();// 卖方名称
			String buyerName = mastContQryVO.getBuyerName();// 买方名称
			String debtContno = mastContQryVO.getMastContCode();// 主合同号
			String contStatus = mastContQryVO.getConStatus();// 合同状态
			String factType = mastContQryVO.getFactType(); // 融资类型
			String financingType = mastContQryVO.getFinancingType(); // 融资模式
			String custcd = mastContQryVO.getCustcd();// 客户号
			List<String> factTypes = new ArrayList<String>();
			if (StringUtil.isEmpty(factType)) {
				factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);// 国内保理
				factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);// 反向保理
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);// 应收账款质押
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
				factTypes.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资
			} else {
				if (factType.equals(BCntBizConstant.T_FINANCING_TYPE_INVOICE)) {// 应收账款融资
					factTypes.add(BCntBizConstant.FACT_TYPE_INLAND);
					factTypes.add(BCntBizConstant.FACT_TYPE_REVERSE);
					factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_PLEDGE);
				} else if (factType.equals(BCntBizConstant.T_FINANCING_TYPE_POOL)) {// 应收账款池融资
					factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL_PLEDGE);// 应收账款质押池融资
					factTypes.add(BCntBizConstant.FACT_TYPE_DEBT_POOL);// 保理池融资
					factTypes.add(BCntBizConstant.FACT_TYPE_EXPORT_POOL_PLEDGE);// 出口退税池质押融资
				}
			}
			map.put(FACTTYPES, factTypes);
		
			
			if (StringUtil.isStrNotEmpty(cname)) {
				map.put(CNAME, cname);
			}
			if (StringUtil.isStrNotEmpty(financingType)) {
				map.put(FINANCINGTYPE, financingType);
			}

			if (StringUtil.isStrNotEmpty(contStatus)) {
				map.put(CONTSTATUS, contStatus);
			}
			if (StringUtil.isStrNotEmpty(debtContno)) {
				map.put(DEBTCONTNO, debtContno);
			}
			if (StringUtil.isStrNotEmpty(buyerName)) {
				map.put(BUYERNAME, buyerName);
			}
			if (StringUtil.isStrNotEmpty(custcd)) {
				map.put(CUSTCD, custcd);
			}

		}
		List<com.huateng.scf.bas.cnt.dao.model.DebtContVO> list = iBCntDebtInfoDAO.selectIfspBCntDebtInfoList(map, p);
	    List<BCntDebtInfoVO> voList=new ArrayList();
	    if(list!=null&&list.size()>0){
		for(com.huateng.scf.bas.cnt.dao.model.DebtContVO vo:list){
			 BCntDebtInfoVO debtVo=new BCntDebtInfoVO(); 
			 BeanUtils.copyProperties(vo, debtVo);
			
			 String businessNo=vo.getDebtContno();
			 Map voMap=new HashMap();
			 voMap.put("businessNo", businessNo);
			 List<com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo> extList= iBCntDebtExtInfoDAO.selectIfspDebtExtInfoByContno(voMap);
			 List<BCntDebtExtInfo> evoList=new ArrayList();
			 if(extList!=null&&extList.size()>0){
			 for(com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo extVo:extList){
			   BCntDebtExtInfo extInfo=new BCntDebtExtInfo();
			   BeanUtils.copyProperties(extVo, extInfo);
			   evoList.add(extInfo);
			 }
			 debtVo.setVoList(evoList); 
			 voList.add(debtVo);
 }
			
		 }}
		p.setRecords(voList);
		p.setTotalRecord(voList.size());
		return p;
	}

}
