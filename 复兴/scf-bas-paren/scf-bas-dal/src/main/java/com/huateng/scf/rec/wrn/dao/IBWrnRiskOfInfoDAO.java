package com.huateng.scf.rec.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.wrn.dao.model.BWrnRiskOfInfo;
import com.huateng.scf.rec.wrn.dao.model.BWrnRiskOfInfoDetail;
import com.huateng.scf.rec.wrn.dao.model.BWrnRiskOfInfoExample;

import java.nio.MappedByteBuffer;
import java.util.List;
import java.util.Map;

public interface IBWrnRiskOfInfoDAO {
    int countByExample(BWrnRiskOfInfoExample example);

    int deleteByExample(BWrnRiskOfInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BWrnRiskOfInfo record);

    void insertSelective(BWrnRiskOfInfo record);

    List<BWrnRiskOfInfo> selectByExample(BWrnRiskOfInfoExample example);

    BWrnRiskOfInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BWrnRiskOfInfo record, BWrnRiskOfInfoExample example);

    int updateByExample(BWrnRiskOfInfo record, BWrnRiskOfInfoExample example);

    int updateByPrimaryKeySelective(BWrnRiskOfInfo record);

    int updateByPrimaryKey(BWrnRiskOfInfo record);

    List<BWrnRiskOfInfo> selectByPage(BWrnRiskOfInfoExample example, Page page);
    
    List<BWrnRiskOfInfoDetail> getUnableCoverOpenAmtWarnInfo(Map map,Page page);
}