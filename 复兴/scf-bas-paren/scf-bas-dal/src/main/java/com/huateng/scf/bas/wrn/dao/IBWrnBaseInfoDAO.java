package com.huateng.scf.bas.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.wrn.dao.model.BWrnBaseInfo;
import com.huateng.scf.bas.wrn.dao.model.BWrnBaseInfoExample;
import java.util.List;
import java.util.Map;

public interface IBWrnBaseInfoDAO {
    int countByExample(BWrnBaseInfoExample example);

    int deleteByExample(BWrnBaseInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BWrnBaseInfo record);

    void insertSelective(BWrnBaseInfo record);

    List<BWrnBaseInfo> selectByExample(BWrnBaseInfoExample example);

    BWrnBaseInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BWrnBaseInfo record, BWrnBaseInfoExample example);

    int updateByExample(BWrnBaseInfo record, BWrnBaseInfoExample example);

    int updateByPrimaryKeySelective(BWrnBaseInfo record);

    int updateByPrimaryKey(BWrnBaseInfo record);

    List<BWrnBaseInfo> selectByPage(BWrnBaseInfoExample example, Page page);
}