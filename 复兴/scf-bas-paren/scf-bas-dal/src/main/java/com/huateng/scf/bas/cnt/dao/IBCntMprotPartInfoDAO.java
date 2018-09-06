package com.huateng.scf.bas.cnt.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotBaseInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfo;
import com.huateng.scf.bas.cnt.dao.model.BCntMprotPartInfoExample;
import java.util.List;
import java.util.Map;

public interface IBCntMprotPartInfoDAO {
    int countByExample(BCntMprotPartInfoExample example);

    int deleteByExample(BCntMprotPartInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BCntMprotPartInfo record);

    void insertSelective(BCntMprotPartInfo record);

    List<BCntMprotPartInfo> selectByExample(BCntMprotPartInfoExample example);

    BCntMprotPartInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BCntMprotPartInfo record, BCntMprotPartInfoExample example);

    int updateByExample(BCntMprotPartInfo record, BCntMprotPartInfoExample example);

    int updateByPrimaryKeySelective(BCntMprotPartInfo record);

    int updateByPrimaryKey(BCntMprotPartInfo record);

    List<BCntMprotPartInfo> selectByPage(BCntMprotPartInfoExample example, Page page);
    
    //EXT
    /**
     * 通过protocolNo获得参与者的信息
     * @param protocolNo
     * @return
     */
    public List<BCntMprotPartInfo> findBCntMpartInfoByProtocolNo(String protocolNo) ;
	List<BCntMprotPartInfo> selectByRole(Map map);

}