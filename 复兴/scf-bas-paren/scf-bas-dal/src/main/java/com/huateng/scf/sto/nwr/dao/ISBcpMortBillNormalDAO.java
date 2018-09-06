package com.huateng.scf.sto.nwr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormal;
import com.huateng.scf.sto.nwr.dao.model.SBcpMortBillNormalExample;
import java.util.List;
/**
 * 
 * <p>SBcpMortBillNormal非标准仓单信息表数据库访问层通用接口类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月12日下午4:00:38
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月12日下午4:00:38	     新增
 *
 * </pre>
 */
public interface ISBcpMortBillNormalDAO {
    int countByExample(SBcpMortBillNormalExample example);

    int deleteByExample(SBcpMortBillNormalExample example);

    int deleteByPrimaryKey(String billno);

    void insert(SBcpMortBillNormal record);

    void insertSelective(SBcpMortBillNormal record);

    List<SBcpMortBillNormal> selectByExample(SBcpMortBillNormalExample example);

    SBcpMortBillNormal selectByPrimaryKey(String billno);

    int updateByExampleSelective(SBcpMortBillNormal record, SBcpMortBillNormalExample example);

    int updateByExample(SBcpMortBillNormal record, SBcpMortBillNormalExample example);

    int updateByPrimaryKeySelective(SBcpMortBillNormal record);

    int updateByPrimaryKey(SBcpMortBillNormal record);

    List<SBcpMortBillNormal> selectByPage(SBcpMortBillNormalExample example, Page page);
}