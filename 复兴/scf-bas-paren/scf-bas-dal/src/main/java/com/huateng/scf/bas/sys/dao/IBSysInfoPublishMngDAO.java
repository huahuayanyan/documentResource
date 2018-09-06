package com.huateng.scf.bas.sys.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMng;
import com.huateng.scf.bas.sys.dao.model.BSysInfoPublishMngExample;
import java.util.List;

public interface IBSysInfoPublishMngDAO {
    int countByExample(BSysInfoPublishMngExample example);

    int deleteByExample(BSysInfoPublishMngExample example);

    int deleteByPrimaryKey(String id);

    void insert(BSysInfoPublishMng record);

    void insertSelective(BSysInfoPublishMng record);

    List<BSysInfoPublishMng> selectByExample(BSysInfoPublishMngExample example);

    BSysInfoPublishMng selectByPrimaryKey(String id);

    int updateByExampleSelective(BSysInfoPublishMng record, BSysInfoPublishMngExample example);

    int updateByExample(BSysInfoPublishMng record, BSysInfoPublishMngExample example);

    int updateByPrimaryKeySelective(BSysInfoPublishMng record);

    int updateByPrimaryKey(BSysInfoPublishMng record);

    List<BSysInfoPublishMng> selectByPage(BSysInfoPublishMngExample example, Page page);
}