package com.huateng.scf.bas.cnt.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntDebtExtInfoExample;
import com.huateng.scf.bas.cnt.dao.model.DebtContVO;

import java.util.List;
import java.util.Map;

public interface IBCntDebtExtInfoDAO {
    int countByExample(BCntDebtExtInfoExample example);

    int deleteByExample(BCntDebtExtInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCntDebtExtInfo record);

    void insertSelective(BCntDebtExtInfo record);

    List<BCntDebtExtInfo> selectByExample(BCntDebtExtInfoExample example);

    BCntDebtExtInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BCntDebtExtInfo record, BCntDebtExtInfoExample example);

    int updateByExample(BCntDebtExtInfo record, BCntDebtExtInfoExample example);

    int updateByPrimaryKeySelective(BCntDebtExtInfo record);

    int updateByPrimaryKey(BCntDebtExtInfo record);

    List<BCntDebtExtInfo> selectByPage(BCntDebtExtInfoExample example, Page page);
    //ext
    List<DebtContVO> findDebtExtInfoByContno(Map<String, String> map,Page page);
    //根据业务合同编号删除交易对手的信息
    void deleteDebtExtInfoByContno(Map<String, String> map);
    List<BCntDebtExtInfo> selectIfspDebtExtInfoByContno(Map<String, String> map);

}