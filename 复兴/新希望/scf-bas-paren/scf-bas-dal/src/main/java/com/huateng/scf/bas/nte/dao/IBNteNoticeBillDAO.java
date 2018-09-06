package com.huateng.scf.bas.nte.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBill;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeBillExample;
import java.util.List;

public interface IBNteNoticeBillDAO {
    int countByExample(BNteNoticeBillExample example);

    int deleteByExample(BNteNoticeBillExample example);

    int deleteByPrimaryKey(String id);

    void insert(BNteNoticeBill record);

    void insertSelective(BNteNoticeBill record);

    List<BNteNoticeBill> selectByExample(BNteNoticeBillExample example);

    BNteNoticeBill selectByPrimaryKey(String id);

    int updateByExampleSelective(BNteNoticeBill record, BNteNoticeBillExample example);

    int updateByExample(BNteNoticeBill record, BNteNoticeBillExample example);

    int updateByPrimaryKeySelective(BNteNoticeBill record);

    int updateByPrimaryKey(BNteNoticeBill record);

    List<BNteNoticeBill> selectByPage(BNteNoticeBillExample example, Page page);
    
    /**
     * 通过APPNO查找通知书票据信息
     * @param appno
     * @return
     */
    List<BNteNoticeBill> findBNteNoticeBillByAppno(String appno);
}