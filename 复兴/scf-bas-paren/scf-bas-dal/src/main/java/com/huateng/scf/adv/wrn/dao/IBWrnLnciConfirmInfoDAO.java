package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.BWrnLnciConfirmInfo;
import com.huateng.scf.adv.wrn.dao.model.BWrnLnciConfirmInfoExample;
import java.util.List;

public interface IBWrnLnciConfirmInfoDAO {
    int countByExample(BWrnLnciConfirmInfoExample example);

    int deleteByExample(BWrnLnciConfirmInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BWrnLnciConfirmInfo record);

    void insertSelective(BWrnLnciConfirmInfo record);

    List<BWrnLnciConfirmInfo> selectByExample(BWrnLnciConfirmInfoExample example);

    BWrnLnciConfirmInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BWrnLnciConfirmInfo record, BWrnLnciConfirmInfoExample example);

    int updateByExample(BWrnLnciConfirmInfo record, BWrnLnciConfirmInfoExample example);

    int updateByPrimaryKeySelective(BWrnLnciConfirmInfo record);

    int updateByPrimaryKey(BWrnLnciConfirmInfo record);

    List<BWrnLnciConfirmInfo> selectByPage(BWrnLnciConfirmInfoExample example, Page page);
}