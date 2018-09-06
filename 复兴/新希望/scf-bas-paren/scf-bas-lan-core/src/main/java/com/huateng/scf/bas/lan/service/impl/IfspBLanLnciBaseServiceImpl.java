/**
 * 
 */
package com.huateng.scf.bas.lan.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.lan.constant.BLanErrorConstant;
import com.huateng.scf.bas.lan.dao.IBLanLnciBaseDAO;
import com.huateng.scf.bas.lan.dao.ext.ExtBLanDAO;
import com.huateng.scf.bas.lan.model.BLanLnciBase;
import com.huateng.scf.bas.lan.service.IIfspBLanLnciBaseService;
import com.huateng.scf.bas.mrn.vo.OldCommonQueryVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>借据查询</p>
 *
 * @author 	zhangcheng
 * @date 	2017年3月14日上午11:21:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2017年3月14日上午11:21:55	     新增
 *
 * </pre>
 */
@SuppressWarnings("deprecation")
@ScubeService
@Service("IfspBLanLnciBaseServiceImpl")
public class IfspBLanLnciBaseServiceImpl implements IIfspBLanLnciBaseService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "BLanLnciBaseDAO")
	IBLanLnciBaseDAO bLanLnciBaseDAO;
	

	/**
	 * 根据借据编号查询借据信息
	 */
	@Override
	public BLanLnciBase findBLanLnciBaseByDebtId(String debtId) throws ScubeBizException {
		BLanLnciBase bLanLnciBase = new BLanLnciBase();
		com.huateng.scf.bas.lan.dao.model.BLanLnciBase bLanLnciBasedal = 
				new com.huateng.scf.bas.lan.dao.model.BLanLnciBase();
		bLanLnciBasedal=bLanLnciBaseDAO.findBLanLnciBaseByDebtId(debtId);
		try {
			if(null!=bLanLnciBasedal){
				BeanUtils.copyProperties(bLanLnciBasedal, bLanLnciBase);
			}
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("借据基本信息转换异常！");
			throw  new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BLanErrorConstant.SCF_BAS_LAN_10004),BLanErrorConstant.SCF_BAS_LAN_10004);
		}
		return bLanLnciBase;
	}
	
	
	
	
	 /**
     * DESCRIPTION:获取有效的借据
     * @author mengjiajia
     * @date 2012-5-18
     * getLnciBaseInfoByParamGetter 方法
     * @param commonQueryVO
     * @return
     * @throws ScubeBizException
     */
	@Override
    public Page getLnciBaseInfoByParamGetter(OldCommonQueryVO commonQueryVO) throws ScubeBizException{
    	Map map = new HashMap();
        //主合同号
        if(!StringUtil.isEmpty(commonQueryVO.getMastContno_Q())){
        	map.put("mastContno",commonQueryVO.getMastContno_Q());
        }

        //子合同外部合同号
        if(!StringUtil.isEmpty(commonQueryVO.getDebetId_Q())){
        	map.put("debetId",commonQueryVO.getDebetId_Q());
        }
        if(!StringUtil.isEmpty(commonQueryVO.getIsSettle_Q())){
        	map.put("isSettle",commonQueryVO.getIsSettle_Q());
        }
        if(!StringUtil.isEmpty(commonQueryVO.getCustcdBuyer_Q())){
        	map.put("buyerCustcd",commonQueryVO.getCustcdBuyer_Q());
        }
        if(!StringUtil.isEmpty(commonQueryVO.getCustcdSaller_Q())){
        	map.put("custcd",commonQueryVO.getCustcd_Q());
        }
        if(!StringUtil.isEmpty(commonQueryVO.getLnciStatus_Q())){
        	map.put("lnciStatus",commonQueryVO.getLnciStatus_Q());
        }
        int total = bLanLnciBaseDAO.countByIfspExample(map);
        Page page = new Page(commonQueryVO.getPageSize(), commonQueryVO.getPageIndex(), total);
        page.setRecords(bLanLnciBaseDAO.selectByIfspPage(map, page));
        
        return page;
    }
	
	
	
}
