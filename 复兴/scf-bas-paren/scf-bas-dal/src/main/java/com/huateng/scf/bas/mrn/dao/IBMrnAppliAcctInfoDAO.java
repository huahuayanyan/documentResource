package com.huateng.scf.bas.mrn.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfo;
import com.huateng.scf.bas.mrn.dao.model.BMrnAppliAcctInfoExample;

import java.util.List;
/**
 * 
 * <p>BMrnAppliAcctInfo数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月13日上午9:44:36
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月13日上午9:44:36	     新增
 *
 * </pre>
 */
public interface IBMrnAppliAcctInfoDAO {
    int countByExample(BMrnAppliAcctInfoExample example);

    int deleteByExample(BMrnAppliAcctInfoExample example);

    int deleteByPrimaryKey(String id);

    void insert(BMrnAppliAcctInfo record);

    void insertSelective(BMrnAppliAcctInfo record);

    List<BMrnAppliAcctInfo> selectByExample(BMrnAppliAcctInfoExample example);

    List<BMrnAppliAcctInfo> selectByAppno(String appno);
    
    BMrnAppliAcctInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(BMrnAppliAcctInfo record, BMrnAppliAcctInfoExample example);

    int updateByExample(BMrnAppliAcctInfo record, BMrnAppliAcctInfoExample example);

    int updateByPrimaryKeySelective(BMrnAppliAcctInfo record);

    int updateByPrimaryKey(BMrnAppliAcctInfo record);

    List<BMrnAppliAcctInfo> selectByPage(BMrnAppliAcctInfoExample example, Page page);

	List<BMrnAppliAcctInfo> selectByBillId(String billId);

	int updateByBillId(BMrnAppliAcctInfo record);
}