package com.huateng.scf.bas.dcr.service.impl.intercept;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.huateng.scf.bas.dcr.service.impl.BDcrLinServiceImpl;
import com.huateng.scf.bas.dcr.vo.VbDcrLin;
import com.huateng.scf.bas.sys.dao.model.ChkResult;
import com.huateng.scf.bas.sys.service.SysChkCallService;

/**
 * 检查当前客户综合授信唯一性
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
@Service("chkCusCreditLineCallServiceImpl")	
public class ChkCusCreditLineCallServiceImpl extends SysChkCallService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "BDcrLinServiceImpl")	
	BDcrLinServiceImpl    bDcrLinServiceImpl;
	
	

	@Override
	public void doWork(Map chkMap, ChkResult chkResult) {
		// TODO Auto-generated method stub
		log.info("ChkCusCreditLineCallServiceImpl--"+chkMap.toString());
		VbDcrLin vbDcrLin  =new   VbDcrLin();
		vbDcrLin.setCustId(chkMap.get("custId").toString());
		vbDcrLin.setStat("1");//有效
		vbDcrLin.setCrId("credit001");//综合授信
		List	 bDcrLinList=bDcrLinServiceImpl.findBDcrLinList(vbDcrLin);
		if(bDcrLinList!=null&&bDcrLinList.size()>0){		
			chkResult.setRem("当前客户已存在综合授信！");
			chkResult.setStat(this.ERROR);		
			
		}else {		
			//chkResult.setRem("执行成功");
			chkResult.setStat(this.SUCCESS);		
		}
		

		
	}

	
		

	

}
