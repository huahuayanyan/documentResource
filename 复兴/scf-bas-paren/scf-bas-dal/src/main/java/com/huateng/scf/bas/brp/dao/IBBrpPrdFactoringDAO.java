package com.huateng.scf.bas.brp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.dao.model.BBrpPrdFactoringExample;
import java.util.List;

public interface IBBrpPrdFactoringDAO {
    int countByExample(BBrpPrdFactoringExample example);

    int deleteByExample(BBrpPrdFactoringExample example);

    int deleteByPrimaryKey(String productId);

    void insert(BBrpPrdFactoring record);

    void insertSelective(BBrpPrdFactoring record);

    List<BBrpPrdFactoring> selectByExample(BBrpPrdFactoringExample example);

    BBrpPrdFactoring selectByPrimaryKey(String productId);

    int updateByExampleSelective(BBrpPrdFactoring record, BBrpPrdFactoringExample example);

    int updateByExample(BBrpPrdFactoring record, BBrpPrdFactoringExample example);

    int updateByPrimaryKeySelective(BBrpPrdFactoring record);

    int updateByPrimaryKey(BBrpPrdFactoring record);

    List<BBrpPrdFactoring> selectByPage(BBrpPrdFactoringExample example, Page page);
}