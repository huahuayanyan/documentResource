package com.huateng.scf.sto.nwr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.dao.model.SBcpBillNormalInOut;
import com.huateng.scf.sto.nwr.dao.model.SBcpBillNormalInOutExample;
import java.util.List;

/**
 * 
 * <p>仓单信息流水	数据库访问层通用接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月19日上午11:15:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月19日上午11:15:04	     新增
 *
 * </pre>
 */
public interface ISBcpBillNormalInOutDAO {
    int countByExample(SBcpBillNormalInOutExample example);

    int deleteByExample(SBcpBillNormalInOutExample example);

    int deleteByPrimaryKey(String id);

    void insert(SBcpBillNormalInOut record);

    void insertSelective(SBcpBillNormalInOut record);

    List<SBcpBillNormalInOut> selectByExample(SBcpBillNormalInOutExample example);

    SBcpBillNormalInOut selectByPrimaryKey(String id);

    int updateByExampleSelective(SBcpBillNormalInOut record, SBcpBillNormalInOutExample example);

    int updateByExample(SBcpBillNormalInOut record, SBcpBillNormalInOutExample example);

    int updateByPrimaryKeySelective(SBcpBillNormalInOut record);

    int updateByPrimaryKey(SBcpBillNormalInOut record);

    List<SBcpBillNormalInOut> selectByPage(SBcpBillNormalInOutExample example, Page page);
}