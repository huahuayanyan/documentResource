package com.huateng.scf.bas.lan.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.lan.dao.model.BLanBillBaseInfo;
import com.huateng.scf.bas.lan.dao.model.BLanBillBaseInfoExample;
import java.util.List;

public interface IBLanBillBaseInfoDAO {
    int countByExample(BLanBillBaseInfoExample example);

    int deleteByExample(BLanBillBaseInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BLanBillBaseInfo record);

    void insertSelective(BLanBillBaseInfo record);

    List<BLanBillBaseInfo> selectByExample(BLanBillBaseInfoExample example);

    List<BLanBillBaseInfo> selectByAppno(String appno);
    
    BLanBillBaseInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BLanBillBaseInfo record, BLanBillBaseInfoExample example);

    int updateByExample(BLanBillBaseInfo record, BLanBillBaseInfoExample example);

    int updateByPrimaryKeySelective(BLanBillBaseInfo record);

    int updateByPrimaryKey(BLanBillBaseInfo record);

    List<BLanBillBaseInfo> selectByPage(BLanBillBaseInfoExample example, Page page);
    
    
    //ext
    /**
     * 根据借据号查询票据信息
     * @param debetNo
     * @return
     */
    List<BLanBillBaseInfo> findBLanBillInfoByDebetNo(String debetNo);
    
}