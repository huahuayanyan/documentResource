/**
 * 
 */
package com.huateng.scf.bas.sys.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.common.startup.ScfMessageUtil;
import com.huateng.scf.bas.sys.constant.BSysErrorConstant;
import com.huateng.scf.bas.sys.dao.IBSysSerialNoDAO;
import com.huateng.scf.bas.sys.dao.model.BSysSerialNo;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * <p>流水号生成实现类</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月5日上午11:37:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月5日上午11:37:57	                                 新增
 *
 * </pre>
 */
@ScubeService
@Service("BSysSerialNoServiceImpl")
public class BSysSerialNoServiceImpl implements IBSysSerialNoService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static final String FORMATER_REGEX_DATE="\\[\\w*\\]";
	private static final Pattern FORMATER_REGEX_DATE_PATTERN=Pattern.compile(FORMATER_REGEX_DATE);
	private static final String FORMATER_REGEX_NUMBER="\\{#*\\}";
	private static final Pattern FORMATER_REGEX_NUMBER_PATTERN=Pattern.compile(FORMATER_REGEX_NUMBER);
	private static final String ZERO="0";
	
	@Resource(name = "BSysSerialNoDAO")
	IBSysSerialNoDAO BSysSerialNoDAO;
	
	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IBSysSerialNoService#genSerialNo(java.lang.String)
	 */
	@Override
	public String genSerialNo(String serialCode) throws ScubeBizException{
		String bizSerialNo=null;
		String reSerial=null;
		BSysSerialNo bSysSerialNo=new BSysSerialNo();
		bSysSerialNo.setSerialCode(serialCode);
		reSerial =BSysSerialNoDAO.queryBSysSerialNoBySerialCode(bSysSerialNo);
		String serialValue=null;
		String formatter=null;
		if(null==reSerial){
			log.error("序号代码不能为空或者序号代码未配置！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20000),
					BSysErrorConstant.SCF_BAS_SYS_20000);
		}
		int n=reSerial.indexOf("|");
		if(n>-1){
			serialValue=reSerial.substring(0, n);
			formatter=reSerial.substring(n+1, reSerial.length());
			log.info("-------------serialValue:"+"["+serialValue+"]");
			log.info("-------------formatter:"+formatter);
		}else{
			log.error("序号代码格式不正确！");
			throw new ScubeBizException(ScfMessageUtil.transErrMsgByKey(BSysErrorConstant.SCF_BAS_SYS_20001),
					BSysErrorConstant.SCF_BAS_SYS_20001);
		}
		String originalFormatter=formatter;
		String formatterRegEx=FORMATER_REGEX_DATE;
		Matcher matcher=FORMATER_REGEX_DATE_PATTERN.matcher(formatter);
		while(matcher.find()){
			String datePattern=matcher.group();
			datePattern=datePattern.substring(1, datePattern.length()-1);
			SimpleDateFormat dateFormat=new SimpleDateFormat(datePattern);
			String dateString =dateFormat.format(new Date());
			originalFormatter=originalFormatter.replaceFirst(FORMATER_REGEX_DATE, dateString);//替换[yyyyMMdd]日期格式
		}
		formatterRegEx=FORMATER_REGEX_NUMBER;
		matcher=FORMATER_REGEX_NUMBER_PATTERN.matcher(formatter);
		String keyValueStr=String.valueOf(serialValue);
		if(matcher.find()){
			String keyPattern=matcher.group();
			int patternLength=keyPattern.length()-2;//取出格式约定的流水号长度
			if(patternLength>keyValueStr.length()){
				StringBuffer sb=new StringBuffer();
				for(int i=0;i<patternLength-keyValueStr.length();i++){
					sb.append(ZERO);//当前序号之外的数值补0
				}
				sb.append(keyValueStr);
				keyValueStr=sb.toString();
			}else if(patternLength<keyValueStr.length()){
				throw new ScubeBizException(ScfMessageUtil.transErrMsgByKeyParams(BSysErrorConstant.SCF_BAS_SYS_20002,
						new Object[] { serialCode }), BSysErrorConstant.SCF_BAS_SYS_20002);
			}
		}
		bizSerialNo=originalFormatter.replaceFirst(formatterRegEx, keyValueStr);
		log.info("-------------生成业务流水号:"+bizSerialNo);
		return bizSerialNo;
	}

	
}
