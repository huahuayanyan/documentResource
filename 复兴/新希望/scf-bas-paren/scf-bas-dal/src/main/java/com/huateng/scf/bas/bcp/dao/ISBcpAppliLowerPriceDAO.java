package com.huateng.scf.bas.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPrice;
import com.huateng.scf.bas.bcp.dao.model.SBcpAppliLowerPriceExample;
import java.util.List;

public interface ISBcpAppliLowerPriceDAO {
    int countByExample(SBcpAppliLowerPriceExample example);

    int deleteByExample(SBcpAppliLowerPriceExample example);

    int deleteByPrimaryKey(String id);

    void insert(SBcpAppliLowerPrice record);

    void insertSelective(SBcpAppliLowerPrice record);

    List<SBcpAppliLowerPrice> selectByExample(SBcpAppliLowerPriceExample example);

    SBcpAppliLowerPrice selectByPrimaryKey(String id);

    int updateByExampleSelective(SBcpAppliLowerPrice record, SBcpAppliLowerPriceExample example);

    int updateByExample(SBcpAppliLowerPrice record, SBcpAppliLowerPriceExample example);

    int updateByPrimaryKeySelective(SBcpAppliLowerPrice record);

    int updateByPrimaryKey(SBcpAppliLowerPrice record);

    List<SBcpAppliLowerPrice> selectByPage(SBcpAppliLowerPriceExample example, Page page);

	List selectByAppno(String appno);
}