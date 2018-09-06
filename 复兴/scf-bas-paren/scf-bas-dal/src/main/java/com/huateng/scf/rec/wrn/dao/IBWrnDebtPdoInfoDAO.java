package com.huateng.scf.rec.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.wrn.dao.model.BWrnDebtPdoInfo;
import com.huateng.scf.rec.wrn.dao.model.BWrnDebtPdoInfoDetail;
import com.huateng.scf.rec.wrn.dao.model.BWrnDebtPdoInfoExample;
import java.util.List;
import java.util.Map;

public interface IBWrnDebtPdoInfoDAO {
    int countByExample(BWrnDebtPdoInfoExample example);

    int deleteByExample(BWrnDebtPdoInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BWrnDebtPdoInfo record);

    void insertSelective(BWrnDebtPdoInfo record);

    List<BWrnDebtPdoInfo> selectByExample(BWrnDebtPdoInfoExample example);

    BWrnDebtPdoInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BWrnDebtPdoInfo record, BWrnDebtPdoInfoExample example);

    int updateByExample(BWrnDebtPdoInfo record, BWrnDebtPdoInfoExample example);

    int updateByPrimaryKeySelective(BWrnDebtPdoInfo record);

    int updateByPrimaryKey(BWrnDebtPdoInfo record);

    List<BWrnDebtPdoInfo> selectByPage(BWrnDebtPdoInfoExample example, Page page);
    
    List<BWrnDebtPdoInfoDetail> getAccountDebtPromptWarnInfo(Map map,Page page);
}