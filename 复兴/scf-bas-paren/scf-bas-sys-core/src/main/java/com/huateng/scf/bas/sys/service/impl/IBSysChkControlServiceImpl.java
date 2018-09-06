package com.huateng.scf.bas.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.dao.BSysChkCnfgDAO;
import com.huateng.scf.bas.sys.dao.BSysChkPlDAO;
import com.huateng.scf.bas.sys.dao.model.BSysChkCnfg;
import com.huateng.scf.bas.sys.dao.model.BSysChkPl;
import com.huateng.scf.bas.sys.dao.model.BSysChkPlExample;
import com.huateng.scf.bas.sys.dao.model.BSysChkPlExample.Criteria;
import com.huateng.scf.bas.sys.dao.model.BSysChkRec;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.IBSysChkCnfgService;
import com.huateng.scf.bas.sys.service.IBSysChkControlService;
import com.huateng.scf.bas.sys.service.SysChkCallService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>
 * 风险检查控制器类
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月12日上午11:47:58
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * yangdong		2016年11月12日上午11:47:58	                                 新增
 *
 *            </pre>
 */

@ScubeService
@Service
public class IBSysChkControlServiceImpl implements IBSysChkControlService, ApplicationContextAware {
	private final Logger log = LoggerFactory.getLogger(getClass());
	//通过
    private  final String   PASS="2";
    //拦截
    private final  String   STOP="3";
    //提醒
    private final String   WARN="1";
	private ApplicationContext applicationContext;

	@Resource(name = "BSysChkPlDAO")
	BSysChkPlDAO bSysChkPlDAO;

	@Resource(name = "BSysChkCnfgDAO")
	BSysChkCnfgDAO bSysChkCnfgDAO;

	@Resource(name = "BSysChkCnfgServiceImpl")
	IBSysChkCnfgService ibSysChkCnfgService;

	
	
	@Override
	public BSysChkRec executeSingleSysChk(BSysChkRec bSysChkRec, Map chkMap) {
		// TODO Auto-generated method stub
		log.debug("executeSysChk传递参数,bSysChkRec=" + bSysChkRec + ",chkMap=" + chkMap);
		if (bSysChkRec == null || chkMap == null) {
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_DCR_50004),
					BSysErrorConstant.SCF_BAS_DCR_50004);
		}
			try {
				BSysChkCnfg bSysChkCnfg = ibSysChkCnfgService.findBSysChkCnfgByKey(bSysChkRec.getChkItId());
				if(bSysChkCnfg==null||StringUtils.isBlank(bSysChkCnfg.getClazz())){
					log.warn("风险拦截配置为空,bSysChkCnfg="+bSysChkCnfg);
					bSysChkRec.setStat(this.STOP);//拦截	
					bSysChkRec.setRem("运行错误!");
					return  bSysChkRec;
				}
				
				// 取出服务bean名
				String beanId = bSysChkCnfg.getClazz();
				SysChkCallService sysChkCallService = (SysChkCallService) applicationContext.getBean(beanId);
				ChkResult chkResult = new ChkResult();
				sysChkCallService.doWork(chkMap, chkResult);
				bSysChkRec.setRem(chkResult.getRem());
               //业务检查方案中处理方式
				String  deal=bSysChkRec.getDeal();
				//业务检查方案执行结果
				String  stat=chkResult.getStat();
				if(sysChkCallService.getSUCCESS().equals(stat)){
					bSysChkRec.setStat(this.PASS);//通过
					if(StringUtils.isBlank(bSysChkRec.getRem())){
						bSysChkRec.setRem("执行成功!");
					}
				}
				else if(sysChkCallService.getERROR().equals(stat)){
					         // 处理方式    0 ：失败提醒
							if("0".equals(deal)){
								bSysChkRec.setStat(this.WARN);//警告
								
							}	
							   // 处理方式    1：失败拦截
							else if("1".equals(deal)){
								bSysChkRec.setStat(this.STOP);//拦截	
							}
							if(StringUtils.isBlank(bSysChkRec.getRem())){
								bSysChkRec.setRem("失败!");
							}
							
				}

				
			} catch (Exception e) {
				// TODO: handle exception
				log.warn("执行风险检查控制器异常", e);
				bSysChkRec.setStat(this.STOP);//拦截	
				bSysChkRec.setRem("风险检查控制器异常!"+e.toString());
				return  bSysChkRec;
			//	throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20004),BSysErrorConstant.SCF_BAS_SYS_20004);
				
			}
	

		return bSysChkRec;

	}
	
	
	
	

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;

	}
	@Override
	public  List queryBSysChkPlList(String modelId) {
		BSysChkPlExample example = new BSysChkPlExample();
		example.setOrderByClause("ORD");
		Criteria criteria = example.createCriteria();
		criteria.andMdlIdEqualTo(modelId);
		//1：启用
		criteria.andStatEqualTo("1");
		List<BSysChkPl> bSysChkPlList = bSysChkPlDAO.selectByExample(example);
		List<BSysChkRec> bSysChkRecList = new ArrayList<BSysChkRec>();
		for (BSysChkPl bSysChkPl : bSysChkPlList) {			
			BSysChkRec bSysChkRec = new BSysChkRec();	
			bSysChkRec.setChkItId(bSysChkPl.getChkItId());
			bSysChkRec.setChkPlId(bSysChkPl.getChkPlId());
			bSysChkRec.setDeal(bSysChkPl.getDeal());
			bSysChkRec.setNm(bSysChkPl.getNm());
			bSysChkRec.setOrd(bSysChkPl.getOrd().toString());
			bSysChkRec.setStat("99");
			bSysChkRec.setRem("");
	    	bSysChkRecList.add(bSysChkRec);
		}
		
		return bSysChkRecList;
	}
	
	
	
	

}
