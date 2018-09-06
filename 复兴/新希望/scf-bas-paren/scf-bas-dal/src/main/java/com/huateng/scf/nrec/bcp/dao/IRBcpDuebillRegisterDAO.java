package com.huateng.scf.nrec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillRegister;
import com.huateng.scf.nrec.bcp.dao.model.RBcpDuebillRegisterExample;
import java.util.List;

public interface IRBcpDuebillRegisterDAO {
    int countByExample(RBcpDuebillRegisterExample example);

    int deleteByExample(RBcpDuebillRegisterExample example);

    int deleteByPrimaryKey(String id);

    void insert(RBcpDuebillRegister record);

    void insertSelective(RBcpDuebillRegister record);

    List<RBcpDuebillRegister> selectByExample(RBcpDuebillRegisterExample example);

    RBcpDuebillRegister selectByPrimaryKey(String id);

    int updateByExampleSelective(RBcpDuebillRegister record, RBcpDuebillRegisterExample example);

    int updateByExample(RBcpDuebillRegister record, RBcpDuebillRegisterExample example);

    int updateByPrimaryKeySelective(RBcpDuebillRegister record);

    int updateByPrimaryKey(RBcpDuebillRegister record);

    List<RBcpDuebillRegister> selectByPage(RBcpDuebillRegisterExample example, Page page);
}