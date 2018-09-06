package com.huateng.scf.nrec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.dao.model.BCntInsuranceContInfo;
import com.huateng.scf.nrec.bcp.dao.model.BCntInsuranceContInfoExample;
import java.util.List;

public interface IBCntInsuranceContInfoDAO {
    int countByExample(BCntInsuranceContInfoExample example);

    int deleteByExample(BCntInsuranceContInfoExample example);

    int deleteByPrimaryKey(String insuranceNo);

    void insert(BCntInsuranceContInfo record);

    void insertSelective(BCntInsuranceContInfo record);

    List<BCntInsuranceContInfo> selectByExample(BCntInsuranceContInfoExample example);

    BCntInsuranceContInfo selectByPrimaryKey(String insuranceNo);

    int updateByExampleSelective(BCntInsuranceContInfo record, BCntInsuranceContInfoExample example);

    int updateByExample(BCntInsuranceContInfo record, BCntInsuranceContInfoExample example);

    int updateByPrimaryKeySelective(BCntInsuranceContInfo record);

    int updateByPrimaryKey(BCntInsuranceContInfo record);

    List<BCntInsuranceContInfo> selectByPage(BCntInsuranceContInfoExample example, Page page);
}