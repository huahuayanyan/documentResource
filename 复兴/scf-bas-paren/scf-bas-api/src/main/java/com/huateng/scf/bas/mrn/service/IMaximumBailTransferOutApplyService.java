package com.huateng.scf.bas.mrn.service;

import java.util.HashMap;

import com.huateng.scf.bas.mrn.vo.BCrrGntyConVO;
import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * 
 * <p>最高额保证金转出申请接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年2月28日上午9:37:23
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年2月28日上午9:37:23	     新增
 *
 * </pre>
 */
public interface IMaximumBailTransferOutApplyService {

	public BPbcAppliBaseInfo findBPbcAppliBaseInfoByAppno(@ScubeParam("appno") String appno);

	public String BailTransferOutWriteUpdate(@ScubeParam("bCrrGntyConVO") BCrrGntyConVO bCrrGntyConVO,@ScubeParam("value") HashMap<String, Object> value);

	public void BailTransferOutWriteSubmit(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess);

	public void BailTransferOutSubmit(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess);

	public void BailTransferOutBackToModUpdate(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess);

	public BCrrGntyConVO findBCrrGntyConByConId(@ScubeParam("conId") String conId);

	public void BailTransferOutApproveSubmit(@ScubeParam("appno") String appno,@ScubeParam("isProcess") boolean isProcess);

}
