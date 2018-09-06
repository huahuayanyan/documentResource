package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.BWrnOverMoniInfo;
import com.huateng.scf.adv.wrn.dao.model.BWrnOverMoniInfoExample;
import java.util.List;

public interface IBWrnOverMoniInfoDAO {
    int countByExample(BWrnOverMoniInfoExample example);

    int deleteByExample(BWrnOverMoniInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BWrnOverMoniInfo record);

    void insertSelective(BWrnOverMoniInfo record);

    List<BWrnOverMoniInfo> selectByExample(BWrnOverMoniInfoExample example);

    BWrnOverMoniInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BWrnOverMoniInfo record, BWrnOverMoniInfoExample example);

    int updateByExample(BWrnOverMoniInfo record, BWrnOverMoniInfoExample example);

    int updateByPrimaryKeySelective(BWrnOverMoniInfo record);

    int updateByPrimaryKey(BWrnOverMoniInfo record);

    List<BWrnOverMoniInfo> selectByPage(BWrnOverMoniInfoExample example, Page page);
}