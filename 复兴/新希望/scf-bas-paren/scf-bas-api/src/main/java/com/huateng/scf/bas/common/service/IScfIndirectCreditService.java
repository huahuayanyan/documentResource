/**
 * 
 */
package com.huateng.scf.bas.common.service;

import java.math.BigDecimal;
import java.util.Map;

import com.huateng.scf.bas.common.model.CreditInterParamVO;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>
 * 间接额度处理公共接口<br>
 * 1.间接额度通用处理（占用、释放、冻结、解冻等）<br>
 * </p>
 *
 * @author huangshuidan
 * @date 2017年1月17日 上午10:57:09
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年1月17日上午10:57:09             新增
 *
 *            </pre>
 */
public interface IScfIndirectCreditService {
	public static final String BEAN_ID = "scfIndirectCreditService";
	/**
	 * 间接额度通用处理
	 * @param indirectMap
	 * 		Map-[
	 * 		appNo-业务申请号,
	 * 		debitNo-供应链借据号
	 * 		operType-处理类型:
	 * 			00-生效(录入)<br>
	 * 			01-预占用<br>
	 * 			02-占用(预占用转占用)<br>
	 * 			03-恢复释放（占用恢复）<br>
	 * 			04-冻结<br>
	 * 			05-解冻<br>
	 * 			06-变更<br>
	 * 			07-终止<br>
	 * 			08-预占用恢复（释放）<br>
	 * 			09-直接占用<br>
	 * 		]
	 * @param openAmt
	 * 		BigDecimal-敞口金额
	 * @throws ScubeBizException
	 */
	public void indCreditAppliCommonProcess(@ScubeParam("indirectMap") Map indirectMap,@ScubeParam("openAmt") BigDecimal openAmt) throws ScubeBizException;
//	public void indirectCreditDealWith(CreditInterParamBean creditInterParam,String custcd,String otherCustcd,String creditType,String operType,BigDecimal amt,String releaseFlag) throws CommonException{
	public void indirectCreditDealWith(CreditInterParamVO creditInterParam,String custcd,String otherCustcd,String creditType,String operType,BigDecimal amt,String releaseFlag) throws ScubeBizException;
	
	/**
	 * 应收账款放款时调用
	 * @param operType
	 * @param creditNo
	 * @param amt
	 * @param appno
	 * @author 	mengjiajia
	 * @date 	2017年6月20日下午4:43:12
	 */
	public void indirectCreditDealWithByCreditNo(@ScubeParam("creditInterParam") CreditInterParamVO creditInterParam,@ScubeParam("operType") String operType);
}
