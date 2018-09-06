package com.huateng.scf.adv.wrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.adv.wrn.dao.model.BWrnMortRedeemInfo;
import com.huateng.scf.adv.wrn.dao.model.BWrnMortRedeemInfoExample;
import java.util.List;

public interface IBWrnMortRedeemInfoDAO {
    int countByExample(BWrnMortRedeemInfoExample example);

    int deleteByExample(BWrnMortRedeemInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BWrnMortRedeemInfo record);

    void insertSelective(BWrnMortRedeemInfo record);

    List<BWrnMortRedeemInfo> selectByExample(BWrnMortRedeemInfoExample example);

    BWrnMortRedeemInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BWrnMortRedeemInfo record, BWrnMortRedeemInfoExample example);

    int updateByExample(BWrnMortRedeemInfo record, BWrnMortRedeemInfoExample example);

    int updateByPrimaryKeySelective(BWrnMortRedeemInfo record);

    int updateByPrimaryKey(BWrnMortRedeemInfo record);

    List<BWrnMortRedeemInfo> selectByPage(BWrnMortRedeemInfoExample example, Page page);
}