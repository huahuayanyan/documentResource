package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.BWrnDropCtlInfo;
import com.huateng.scf.adv.wrn.dao.model.BWrnDropCtlInfoExample;
import java.util.List;

public interface IBWrnDropCtlInfoDAO {
    int countByExample(BWrnDropCtlInfoExample example);

    int deleteByExample(BWrnDropCtlInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BWrnDropCtlInfo record);

    void insertSelective(BWrnDropCtlInfo record);

    List<BWrnDropCtlInfo> selectByExample(BWrnDropCtlInfoExample example);

    BWrnDropCtlInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BWrnDropCtlInfo record, BWrnDropCtlInfoExample example);

    int updateByExample(BWrnDropCtlInfo record, BWrnDropCtlInfoExample example);

    int updateByPrimaryKeySelective(BWrnDropCtlInfo record);

    int updateByPrimaryKey(BWrnDropCtlInfo record);

    List<BWrnDropCtlInfo> selectByPage(BWrnDropCtlInfoExample example, Page page);
}