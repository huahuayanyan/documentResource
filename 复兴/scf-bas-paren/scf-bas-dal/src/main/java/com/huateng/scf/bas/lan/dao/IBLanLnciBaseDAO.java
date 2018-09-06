package com.huateng.scf.bas.lan.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBase;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseExample;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBaseVO;
import com.huateng.scf.bas.lan.dao.vo.FinAmtDistrib;

public interface IBLanLnciBaseDAO {
    int countByExample(BLanLnciBaseExample example);

    int deleteByExample(BLanLnciBaseExample example);

    int deleteByPrimaryKey(String debetNo);

    void insert(BLanLnciBase record);

    void insertSelective(BLanLnciBase record);

    List<BLanLnciBase> selectByExample(BLanLnciBaseExample example);

    BLanLnciBase selectByPrimaryKey(String debetNo);

    int updateByExampleSelective(BLanLnciBase record, BLanLnciBaseExample example);

    int updateByExample(BLanLnciBase record, BLanLnciBaseExample example);

    int updateByPrimaryKeySelective(BLanLnciBase record);

    int updateByPrimaryKey(BLanLnciBase record);

    List<BLanLnciBase> selectByPage(BLanLnciBaseExample example, Page page);
    
    List<BLanLnciBase> selectByAppno(String appno);
    
    List<BLanLnciBase> selectByCondition(String protocolNo);
    
    BigDecimal getTotalLoanAmtInContInfo(String mastContno);
    
    List<BLanLnciBase> queryByCondition(BLanLnciBase bLanLnciBase);
    
    /**
     * 根据借据号查询借据信息
     * @param debetId
     * @return
     */
    BLanLnciBase findBLanLnciBaseByDebtId(String debetId);
    /**
     * 查询未结清且有效的借据
     * @param params
     * @return
     */
    List<BLanLnciBase>  queryValidLnciBaseInfo(Map<String, Object> map);

	@SuppressWarnings("rawtypes")
	List getThreeLnciInfoListByExample(BLanLnciBaseExample example);

	int  getThreeLnciInfoListCount(Map<String, Object> params);

	List<BLanLnciBaseVO> getThreeLnciInfoListPageByParams(Map<String, Object> params, Page pageResult);

	List<BLanLnciBase> queryLnciInfoByBusinessNo(HashMap<String, Object> omap);
	
	List<BLanLnciBase> queryLnciInfoByBusinessNo(Map map);

	BLanLnciBase get(String debetNo);
	
	List<BLanLnciBase> getFourLnciInfoListPageByParams(Map<String, Object> params, Page pageResult);
	List<BLanLnciBase> selectByIfspPage(Map map, Page page);
	int countByIfspExample(Map map);
	
	BigDecimal queryLnciAmtBySlaveContno(Map map);
	/**
	 * 按照省份、产品查询融资金额
	 * @param value
	 * @return
	 */
	public List<FinAmtDistrib> queryFinAmtDistribList(Map<String, Object> map);
	/**
	 * 查询产品列表（去重）
	 * @param map
	 * @return
	 */
	public List<FinAmtDistrib> queryFinAmtProductList(Map<String, Object> map);
	/**
	 * 融资金额-省份-TOP10
	 * @param map
	 * @return
	 */
	public List<FinAmtDistrib> queryFinAmtTopList(Map<String, Object> map);
	
	/**
     * @Description: 获取协议下并且间接授信客户名称为oldThrCd的融资金额，余额，剩余提货金额，累计提货金额(向监管)，累计提货金额(向核心)
     * @param protocolNo
     * @return
     */
    public List<Map<String, Object>> getKindsOfSum(String slaveContno,String oldThrCd);
    
    public List<BLanLnciBase> getTblLnciBaseInfo(String creditCustcd,String custcd,String slaveContno);
    
}