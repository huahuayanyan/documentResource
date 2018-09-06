package com.huateng.scf.bas.lan.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanAppliLnciBaseExample;
import java.util.List;
import java.util.Map;

public interface IBLanAppliLnciBaseDAO {
    int countByExample(BLanAppliLnciBaseExample example);

    int deleteByExample(BLanAppliLnciBaseExample example);

    int deleteByPrimaryKey(String id);

    void insert(BLanAppliLnciBase record);

    void insertSelective(BLanAppliLnciBase record);

    List<BLanAppliLnciBase> selectByExample(BLanAppliLnciBaseExample example);

    BLanAppliLnciBase selectByPrimaryKey(String id);

    BLanAppliLnciBase selectByAppno(String appno);
    
    List<BLanAppliLnciBase> selectByAppNo(String appno);
    
    int updateByExampleSelective(BLanAppliLnciBase record, BLanAppliLnciBaseExample example);

    int updateByExample(BLanAppliLnciBase record, BLanAppliLnciBaseExample example);

    int updateByPrimaryKeySelective(BLanAppliLnciBase record);

    int updateByPrimaryKey(BLanAppliLnciBase record);

    List<BLanAppliLnciBase> selectByPage(BLanAppliLnciBaseExample example, Page page);

    List<Map> getFlowRiskAmtByVidno(String protocolNo);
    
    List<Map> getFlowRiskAmtByMastContno(String mastContno);
    
    List<Map> getFlowKindsOfSumByMastContno(String mastContno);
    /**
     * 根据借据号查询借据申请信息
     * @param debetId
     * @return
     */
    BLanAppliLnciBase findBLanAppliLnciBaseByDebtId(String debetId);
    /**
     * 根据借据流水号查询借据申请信息
     * @param debetNo
     * 		String-借据流水号
     * @return
     */
    public BLanAppliLnciBase queryBLanAppliLnciBaseByDebtNo(String debetNo);
    
    /**
     * @Description:监管商变更，根据旧监管公司客户号，出质人，先票后货协议获取借据申请表信息
     * @param bailBussInfoVO
     * @return
     * @throws CommonException
     */
    public List<BLanAppliLnciBase> getTblAppliLnciBaseInfo(String creditCustcd,String custcd,String slaveContno);
}