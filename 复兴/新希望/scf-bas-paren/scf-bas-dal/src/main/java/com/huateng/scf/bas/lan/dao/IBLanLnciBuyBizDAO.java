package com.huateng.scf.bas.lan.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntBuyInfo;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBiz;
import com.huateng.scf.bas.lan.dao.model.BLanLnciBuyBizExample;
import java.util.List;
import java.util.Map;

public interface IBLanLnciBuyBizDAO {
    int countByExample(BLanLnciBuyBizExample example);

    int deleteByExample(BLanLnciBuyBizExample example);

    int deleteByPrimaryKey(String id);

    void insert(BLanLnciBuyBiz record);

    void insertSelective(BLanLnciBuyBiz record);

    List<BLanLnciBuyBiz> selectByExample(BLanLnciBuyBizExample example);

    List<BLanLnciBuyBiz> selectByAppno(String appno);
    
    BLanLnciBuyBiz selectByPrimaryKey(String id);

    int updateByExampleSelective(BLanLnciBuyBiz record, BLanLnciBuyBizExample example);

    int updateByExample(BLanLnciBuyBiz record, BLanLnciBuyBizExample example);

    int updateByPrimaryKeySelective(BLanLnciBuyBiz record);

    int updateByPrimaryKey(BLanLnciBuyBiz record);

    List<BLanLnciBuyBiz> selectByPage(BLanLnciBuyBizExample example, Page page);
    
    List<BLanLnciBuyBiz> selectByAppnoAndTrade(Map map);
    
    //ext
    //根据条件查询放款申请购销合同流水信息
    List<BLanLnciBuyBiz> queryByCondition(BLanLnciBuyBiz bLanLnciBuyBiz);
}