package com.huateng.scf.sto.nwr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.dao.model.SBcpProductBill;
import com.huateng.scf.sto.nwr.dao.model.SBcpProductBillExample;
import java.util.List;
/**
 * 
 * <p>SBcpProductBill仓单产品参数扩展表 数据库访问层通用接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月12日下午3:58:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月12日下午3:58:38	     新增
 *
 * </pre>
 */
public interface ISBcpProductBillDAO {
    int countByExample(SBcpProductBillExample example);

    int deleteByExample(SBcpProductBillExample example);

    int deleteByPrimaryKey(String productId);

    void insert(SBcpProductBill record);

    void insertSelective(SBcpProductBill record);

    List<SBcpProductBill> selectByExample(SBcpProductBillExample example);

    SBcpProductBill selectByPrimaryKey(String productId);

    int updateByExampleSelective(SBcpProductBill record, SBcpProductBillExample example);

    int updateByExample(SBcpProductBill record, SBcpProductBillExample example);

    int updateByPrimaryKeySelective(SBcpProductBill record);

    int updateByPrimaryKey(SBcpProductBill record);

    List<SBcpProductBill> selectByPage(SBcpProductBillExample example, Page page);
}