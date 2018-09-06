package com.huateng.scf.bas.nte.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtg;
import com.huateng.scf.bas.nte.dao.model.BNteNoticeMtgExample;
import java.util.List;

public interface IBNteNoticeMtgDAO {
    int countByExample(BNteNoticeMtgExample example);

    int deleteByExample(BNteNoticeMtgExample example);

    int deleteByPrimaryKey(String id);

    void insert(BNteNoticeMtg record);

    void insertSelective(BNteNoticeMtg record);

    List<BNteNoticeMtg> selectByExample(BNteNoticeMtgExample example);

    BNteNoticeMtg selectByPrimaryKey(String id);

    int updateByExampleSelective(BNteNoticeMtg record, BNteNoticeMtgExample example);

    int updateByExample(BNteNoticeMtg record, BNteNoticeMtgExample example);

    int updateByPrimaryKeySelective(BNteNoticeMtg record);

    int updateByPrimaryKey(BNteNoticeMtg record);

    List<BNteNoticeMtg> selectByPage(BNteNoticeMtgExample example, Page page);
    
    //ext
    /**
     * 通过APPNO查找通知书关联押品信息
     * @param appno
     * @return
     */
    List<BNteNoticeMtg> findBNteNoticeMtgByAppno(String appno);
    List<BNteNoticeMtg> selectByPid(String id);
}