package com.huateng.scf.bas.pbc.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClass;
import com.huateng.scf.bas.pbc.dao.model.BPbcMtgClassExample;
import java.math.BigDecimal;
import java.util.List;

public interface IBPbcMtgClassDAO {
    int countByExample(BPbcMtgClassExample example);

    int deleteByExample(BPbcMtgClassExample example);

    int deleteByPrimaryKey(BigDecimal mortgageCode);

    void insert(BPbcMtgClass record);

    void insertSelective(BPbcMtgClass record);

    List<BPbcMtgClass> selectByExample(BPbcMtgClassExample example);

    BPbcMtgClass selectByPrimaryKey(BigDecimal mortgageCode);

    int updateByExampleSelective(BPbcMtgClass record, BPbcMtgClassExample example);

    int updateByExample(BPbcMtgClass record, BPbcMtgClassExample example);

    int updateByPrimaryKeySelective(BPbcMtgClass record);

    int updateByPrimaryKey(BPbcMtgClass record);

    List<BPbcMtgClass> selectByPage(BPbcMtgClassExample example, Page page);
}