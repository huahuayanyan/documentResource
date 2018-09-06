package com.huateng.scf.ods.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.ods.dao.model.OCooperPartner;
import com.huateng.scf.ods.dao.model.OCooperPartnerExample;
import java.util.List;

public interface IOCooperPartnerDAO {
    int countByExample(OCooperPartnerExample example);

    int deleteByExample(OCooperPartnerExample example);

    int deleteByPrimaryKey(String id);

    void insert(OCooperPartner record);

    void insertSelective(OCooperPartner record);

    List<OCooperPartner> selectByExample(OCooperPartnerExample example);

    OCooperPartner selectByPrimaryKey(String id);

    int updateByExampleSelective(OCooperPartner record, OCooperPartnerExample example);

    int updateByExample(OCooperPartner record, OCooperPartnerExample example);

    int updateByPrimaryKeySelective(OCooperPartner record);

    int updateByPrimaryKey(OCooperPartner record);

    List<OCooperPartner> selectByPage(OCooperPartnerExample example, Page page);
}