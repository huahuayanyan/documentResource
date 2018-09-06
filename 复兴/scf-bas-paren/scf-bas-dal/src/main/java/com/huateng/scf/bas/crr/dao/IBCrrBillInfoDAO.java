package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrBillInfoExample;
import java.util.List;
/**
 * 
 * <p>BCrrBillInfo数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:36:18
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:36:18	     新增
 *
 * </pre>
 */
public interface IBCrrBillInfoDAO {
    int countByExample(BCrrBillInfoExample example);

    int deleteByExample(BCrrBillInfoExample example);

    int deleteByPrimaryKey(String billId);

    void insert(BCrrBillInfo record);

    void insertSelective(BCrrBillInfo record);

    List<BCrrBillInfo> selectByExample(BCrrBillInfoExample example);

    BCrrBillInfo selectByPrimaryKey(String billId);

    int updateByExampleSelective(BCrrBillInfo record, BCrrBillInfoExample example);

    int updateByExample(BCrrBillInfo record, BCrrBillInfoExample example);

    int updateByPrimaryKeySelective(BCrrBillInfo record);

    int updateByPrimaryKey(BCrrBillInfo record);

    List<BCrrBillInfo> selectByPage(BCrrBillInfoExample example, Page page);

	List<BCrrBillInfo> selectByExtId(String extId);

	int deleteByExtId(String extId);
}