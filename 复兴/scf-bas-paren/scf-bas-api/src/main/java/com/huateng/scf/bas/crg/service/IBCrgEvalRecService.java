package com.huateng.scf.bas.crg.service;

import java.util.List;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crg.dao.model.BCrgEvalRec;
import com.huateng.scf.bas.crg.model.ExtBCrgEval;
import com.huateng.scf.bas.sys.dao.model.BSysApplyDtl;
import com.huateng.scf.rec.bcp.model.ProcessModel;
//import com.huateng.scf.bas.crg.dao.model.BCrgEvalRec;
//import com.huateng.scf.bas.crg.dao.model.BCrgEvalRec;
import com.huateng.scube.server.annotation.ScubeParam;
//import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.toprules.xom.ScfCustBaseInfo;

public interface IBCrgEvalRecService {
	
	/**
	 * @param s
	 * @return
	 */
	public String getString(@ScubeParam("s") String s);

	/**
	 * @param BCrgEvalRec
	 * @return
	 */
	
	public String add(@ScubeParam("bCrgEvalRec") BCrgEvalRec bCrgEvalRec);
	
	/**
	 * @param BCrgEvalRec
	 * @return
	 */
	
	public int update(@ScubeParam("bCrgEvalRec") BCrgEvalRec bCrgEvalRec);
	
	/**
	 * @param key
	 * @return
	 */
	public int delete(@ScubeParam("key") String key);
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @param BCrgEvalRec
	 * @return
	 */
	public Page findCrgEvalRecByPage(@ScubeParam("pageNo") int pageNo,@ScubeParam("pageSize") int pageSize,@ScubeParam("bCrgEvalRec") BCrgEvalRec bCrgEvalRec);
	
	/**
	 * @param key
	 * @return
	 */
	public BCrgEvalRec findCrgEvalRecByKey(@ScubeParam("key") String key);
	
	/**
	 * 
	 * @param example
	 * @return
	 */
	public List<BCrgEvalRec> selectByBCrgEvalRec(@ScubeParam("bCrgEvalRec") BCrgEvalRec bCrgEvalRec);	
	
	public boolean isSignalSucceed(@ScubeParam("processId") String processId,@ScubeParam("nodeId")String nextNodeId)throws Exception;
	
	public BCrgEvalRec submit(@ScubeParam("bCrgEvalRec")  BCrgEvalRec bCrgEvalRec,@ScubeParam("processModel") ProcessModel processModel)throws Exception;
	
	public String getEvalStat(@ScubeParam("processId") String processId)throws Exception;
	
//	public String getNextNodeId(@ScubeParam("processId") String processId)throws Exception;
	
	public String getPrevNodeId(@ScubeParam("processId") String processId,@ScubeParam("currNodeId") String currNodeId) throws Exception;
	
	public String getFinlNodeId()throws Exception;
	
	public BCrgEvalRec getEntityByProcessId(@ScubeParam("processId") String processId)throws Exception;
	
	public String saveBSysApplyDtl(@ScubeParam("bSysApplyDtl") BSysApplyDtl bSysApplyDtl)throws Exception;
	
	public String getTaskIdByNodeId(@ScubeParam("nodeId")String ndoeId)throws Exception;
	
	public String[] executeRules(@ScubeParam("salary") double salary)throws Exception;
	
	public ExtBCrgEval getBrNo();
	
	public ExtBCrgEval findExtBCrgEvalByKey(@ScubeParam("key") String evalId);

	public ExtBCrgEval findExtBcrgEvalInfo(@ScubeParam("extBCrgEval") ExtBCrgEval extBCrgEval);
	
	public String findBCrgEvalLevelInfo(@ScubeParam("custNo") String custNo);
	
	public String getCrgEvalLevel(@ScubeParam("totalScore") String totalScore);
	
	/**
	 * 获取评分卡信息
	 * 
	 * @return 评分卡信息
	 */
	public ScfCustBaseInfo findScfCustBaseInfo();

}
