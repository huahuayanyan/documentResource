package com.huateng.scf.bas.dcr.service.impl.intercept;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.dcr.model.BDcrLinInf;
import com.huateng.scf.bas.dcr.service.IbDcrLinInfService;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;

/**
 * 检查分项额度
 *
 * @author huateng
 * @date 2016年7月6日
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * huateng			2016年7月6日			新增
 *  
 *            </pre>
 */
@Service("chkSubCreditLineCallServiceImpl")	
public class ChkSubCreditLineCallServiceImpl extends SysChkCallService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BDcrLinInfServiceImpl")	
	IbDcrLinInfService    bDcrLinInfServiceImpl;
	
	

	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		// TODO Auto-generated method stub
		log.info("ChkSubCreditLineCallServiceImpl--"+chkMap.toString());
		//默认值
		chkResult.setStat(this.SUCCESS);		
		
		
		String key=chkMap.get("parentId").toString();
		 List<BDcrLinInf>  bDcrLinInfList=bDcrLinInfServiceImpl.selectTreePoByRootId(key);	
		if(bDcrLinInfList!=null&&bDcrLinInfList.size()<=1){		
			chkResult.setRem("分项额度只存在根节点，没有添加分项额度");
			chkResult.setStat(this.ERROR);		
			
		}
		else {
			
			for(BDcrLinInf dcrLinInf :bDcrLinInfList){
						String linTyp=  dcrLinInf.getLinTyp();
						String  linId  =dcrLinInf.getLinId();
					
						  //组合额度检查向下存在分支节点
						  if("1".equals(linTyp)){
							  Boolean  notflag=true;  
							  for(BDcrLinInf indcrLinInf :bDcrLinInfList){
								    if(indcrLinInf.getParentId().equals(linId)){
								    	notflag=false;
								    	break;
								    }
								  
							  }
							 if(notflag){
									chkResult.setRem("组合额度下没有添加分项额度");
									chkResult.setStat(this.ERROR);		 
									break;
							 } 
						  }
			}
			
			
			

		}
		

		
	}

	
		

	

}
