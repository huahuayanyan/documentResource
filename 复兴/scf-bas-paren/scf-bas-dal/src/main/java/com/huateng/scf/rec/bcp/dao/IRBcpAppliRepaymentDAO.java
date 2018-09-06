package com.huateng.scf.rec.bcp.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepayment;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliRepaymentExample;

import java.util.List;

public interface IRBcpAppliRepaymentDAO {
    int countByExample(RBcpAppliRepaymentExample example);

    int deleteByExample(RBcpAppliRepaymentExample example);

    int deleteByPrimaryKey(String id);

    void insert(RBcpAppliRepayment record);

    void insertSelective(RBcpAppliRepayment record);

    List<RBcpAppliRepayment> selectByExample(RBcpAppliRepaymentExample example);

    RBcpAppliRepayment selectByPrimaryKey(String id);

    int updateByExampleSelective(RBcpAppliRepayment record, RBcpAppliRepaymentExample example);

    int updateByExample(RBcpAppliRepayment record, RBcpAppliRepaymentExample example);

    int updateByPrimaryKeySelective(RBcpAppliRepayment record);

    int updateByPrimaryKey(RBcpAppliRepayment record);

    List<RBcpAppliRepayment> selectByPage(RBcpAppliRepaymentExample example, Page page);

	List<RBcpAppliRepayment> selectByRBcpAppliRepaymentByAppno(String appno);
}