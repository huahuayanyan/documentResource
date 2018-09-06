/**
 * 
 */
package com.huateng.scf.bas.web.startup;

import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huateng.scf.bas.common.constant.NoticeConstant;
import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.startup.ScfBaseData;
import com.huateng.scf.bas.common.startup.ScfBaseEnv;
import com.huateng.scf.bas.common.startup.ScfDbConnInfo;
import com.huateng.scf.bas.common.startup.ScfGlobalInfo;
import com.huateng.scf.bas.common.startup.ScfMcachedUtil;
import com.huateng.scf.bas.common.startup.ScfNoticeTypeData;
import com.huateng.scf.bas.common.util.ContextUtil;
import com.huateng.scf.bas.common.util.PropertyUtil;
import com.huateng.scf.bas.common.util.ScfDateUtil;
import com.huateng.scf.bas.sys.dao.model.BSysGlobalInfo;
import com.huateng.scf.bas.sys.service.IBSysGlobalInfoService;
import com.huateng.scf.bas.sys.service.impl.ScfMcachedClientServiceImpl;

/**
 * <p>平台基础初始化</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月7日下午7:27:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月7日下午7:27:55	                                 新增
 *
 * </pre>
 */
public class ScfBaseInit {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static boolean bInited = false;//是否初始化标识，默认为初始化
	
//	@Resource(name = "BSysGlobalInfoServiceImpl")
//	private  IBSysGlobalInfoService bSysGlobalInfoService;//系统全局信息
//	@Resource(name = "scfMcachedClient")
//	private  IScfSysCacheService scfMcachedClient;//缓存服务
	
	/**
	 * 平台基础、环境变量初始化，初始后设置标识为true
	 */
	public synchronized void init() {
		if (bInited) {
			return;
		}
		Properties props = PropertyUtil.init(ScfBaseEnv.SYSTEM_PROPS);//系统配置文件
		ScfBaseEnv.getInstance().setSystemProps(props);
		Properties systemErrorProps = PropertyUtil.init(ScfBaseEnv.SYSTEM_ERROR_PROPS);//系统异常或者信息提示配置
		ScfBaseEnv.getInstance().setSystemErrorProps(systemErrorProps);
		
		initBaseData(props);//初始化配置文件参数
		initScfGlobalData();//初始化全局信息
		bInited = true;
	}
	
	/**
	 * 初始化签名配置文件
	 * @param props
	 * 		Properties-配置文件对象
	 */
	private void initBaseData(Properties props){
		ScfNoticeTypeData scfNoticeTypeData=new ScfNoticeTypeData();
		scfNoticeTypeData.setNoticeType_1(props.getProperty(NoticeConstant.NOTICE_TPYE_DATA_1));
		scfNoticeTypeData.setNoticeType_71(props.getProperty(NoticeConstant.NOTICE_TPYE_DATA_71));
		scfNoticeTypeData.setNoticeType_78(props.getProperty(NoticeConstant.NOTICE_TPYE_DATA_78));
		scfNoticeTypeData.setNoticeType_81(props.getProperty(NoticeConstant.NOTICE_TPYE_DATA_81));
		scfNoticeTypeData.setNoticeType_88(props.getProperty(NoticeConstant.NOTICE_TPYE_DATA_88));
		ScfBaseData.getInstance().setScfNoticeTypeData(scfNoticeTypeData);//通知书实现类配置
		log.info("...NoticeType_1 is:"+ScfBaseData.getInstance().getScfNoticeTypeData().getNoticeType_1());
		log.info("...NoticeType_88 is:"+ScfBaseData.getInstance().getScfNoticeTypeData().getNoticeType_88());
		//数据源
		ScfDbConnInfo scfDbConnInfo = new  ScfDbConnInfo();
		scfDbConnInfo.setDriverClassName(props.getProperty("driverClassName"));
		scfDbConnInfo.setUrl(props.getProperty("url"));
		scfDbConnInfo.setUsername(props.getProperty("username"));
		scfDbConnInfo.setPassword(props.getProperty("password"));
		ScfBaseData.getInstance().setScfDbConnInfo(scfDbConnInfo); //数据源连接信息设置
		log.info("...DriverClassName is:"+ScfBaseData.getInstance().getScfDbConnInfo().getDriverClassName());
		log.info("...Url is:"+ScfBaseData.getInstance().getScfDbConnInfo().getUrl());
		ScfBaseData.getInstance().setLoanWayFlag(props.getProperty("loanWayFlag"));//出账方式
		log.info("...loanWayFlag:"+ScfBaseData.getInstance().getLoanWayFlag());
	}
	/**
	 * 初始化系统全局信息
	 */
	private void initScfGlobalData(){
		log.info("...initScfGlobalData begin...");
		BSysGlobalInfo bSysGlobalInfo=new BSysGlobalInfo();
		bSysGlobalInfo.setSysCode(ScfBasConstant.SYS_CODE);

//		IScfSysCacheService scfMcachedClient=(IScfSysCacheService)ctx.getBean("scfMcachedClient");
//		IBSysGlobalInfoService bSysGlobalInfoService=(IBSysGlobalInfoService)ctx.getBean("BSysGlobalInfoServiceImpl");
		IBSysGlobalInfoService bSysGlobalInfoService=(IBSysGlobalInfoService)ContextUtil.getBean("BSysGlobalInfoServiceImpl");
		BSysGlobalInfo globalData=bSysGlobalInfoService.queryBSysGlobalInfo(bSysGlobalInfo);
		ScfGlobalInfo scfGlobalInfo=new ScfGlobalInfo();
		if(null!=globalData){
			scfGlobalInfo.setSysCode(globalData.getSysCode());
			scfGlobalInfo.setSystemName(globalData.getSystemName());//系统简称
			scfGlobalInfo.setTxnDate(globalData.getTbsdy());//交易日期/工作日
			scfGlobalInfo.setBatDate(globalData.getBhdate());//批量日期
			scfGlobalInfo.setLastBatDate(globalData.getLbhdate());//上一批量日期（换日后更新）
			scfGlobalInfo.setTimestamps(globalData.getTimestamps());//时间戳
			//这里取不到用户、机构信息
//		    scfGlobalInfo.setBrCode(ContextHolder.getOrgInfo().getBrNo());//机构号
//		    scfGlobalInfo.setBrName(ContextHolder.getOrgInfo().getBrName());//机构名称
//		    scfGlobalInfo.setTlrNo(ContextHolder.getUserInfo().getTlrNo());//操作员
//		    scfGlobalInfo.setTlrName(ContextHolder.getUserInfo().getTlrName());//操作员名称
		    scfGlobalInfo.setTxnStatus(globalData.getStatus());//交易状态
		    scfGlobalInfo.setSysDate(ScfDateUtil.getStringDate(new Date()));//系统时间yyyyMMdd
		    ScfBaseData.getInstance().setScfGlobalInfo(scfGlobalInfo);
		    //TODO ScfMcachedClientServiceImpl.EXP_TIME优化为从配置文件取
//			boolean flag = scfMcachedClient.putWithExptime(ScfBasConstant.SCF_CACHE_PUT_KEY_SCFGLOBALINFO,
//					scfGlobalInfo, ScfMcachedClientServiceImpl.EXP_TIME);
			boolean flag = ScfMcachedUtil.putObject(ScfBasConstant.SCF_CACHE_PUT_KEY_SCFGLOBALINFO, scfGlobalInfo,
					ScfMcachedClientServiceImpl.EXP_TIME);
		    log.info("...initScfGlobalData put value into memcached...flag:"+flag);
//		    ScfGlobalInfo scfGlobalInfoResult=scfMcachedClient.get(ScfBasConstant.SCF_CACHE_PUT_KEY_SCFGLOBALINFO);
		    
//		    ScfGlobalInfo scfGlobalInfoResult=ScfMcachedUtil.getObject(ScfBasConstant.SCF_CACHE_PUT_KEY_SCFGLOBALINFO);
		    ScfGlobalInfo scfGlobalInfoResult=ScfBaseData.getScfGlobalInfoData();
		    log.info("..........sys code..."+scfGlobalInfoResult.getSysCode());
		    log.info("..........txb date..."+scfGlobalInfoResult.getTxnDate());
		}
		log.info("...initScfGlobalData end...");
	}
	
	/**
	 * 销毁，重置初始化标识为false，未初始化
	 */
	public static void destroy() {
		bInited = false;
	}
}
