package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.BWanMortFlucPrice;
import com.huateng.scf.adv.wrn.dao.model.BWanMortFlucPriceExample;
import java.util.List;

public interface IBWanMortFlucPriceDAO {
    int countByExample(BWanMortFlucPriceExample example);

    int deleteByExample(BWanMortFlucPriceExample example);

    int deleteByPrimaryKey(String id);

    void insert(BWanMortFlucPrice record);

    void insertSelective(BWanMortFlucPrice record);

    List<BWanMortFlucPrice> selectByExample(BWanMortFlucPriceExample example);

    BWanMortFlucPrice selectByPrimaryKey(String id);

    int updateByExampleSelective(BWanMortFlucPrice record, BWanMortFlucPriceExample example);

    int updateByExample(BWanMortFlucPrice record, BWanMortFlucPriceExample example);

    int updateByPrimaryKeySelective(BWanMortFlucPrice record);

    int updateByPrimaryKey(BWanMortFlucPrice record);

    List<BWanMortFlucPrice> selectByPage(BWanMortFlucPriceExample example, Page page);
}