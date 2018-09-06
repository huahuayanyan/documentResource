package com.huateng.scf.bas.nte.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeLnci;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeLnciExample;
import java.util.List;

public interface IBNteNoticeLnciDAO {
    int countByExample(BNteNoticeLnciExample example);

    int deleteByExample(BNteNoticeLnciExample example);

    int deleteByPrimaryKey(String id);

    void insert(BNteNoticeLnci record);

    void insertSelective(BNteNoticeLnci record);

    List<BNteNoticeLnci> selectByExample(BNteNoticeLnciExample example);

    BNteNoticeLnci selectByPrimaryKey(String id);

    int updateByExampleSelective(BNteNoticeLnci record, BNteNoticeLnciExample example);

    int updateByExample(BNteNoticeLnci record, BNteNoticeLnciExample example);

    int updateByPrimaryKeySelective(BNteNoticeLnci record);

    int updateByPrimaryKey(BNteNoticeLnci record);

    List<BNteNoticeLnci> selectByPage(BNteNoticeLnciExample example, Page page);
    List<BNteNoticeLnci> selectByDebetNo(String debetNo);
}