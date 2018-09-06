package com.huateng.scf.bas.fin.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.fin.dao.model.BFinCustDs;
import com.huateng.scf.bas.fin.dao.model.BFinCustDsExample;

import java.util.List;
/**
 * 
 * <p>BFinCustDs数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午9:53:19
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午9:53:19	     新增
 *
 * </pre>
 */
public interface IBFinCustDsDAO {
    int countByExample(BFinCustDsExample example);

    int deleteByExample(BFinCustDsExample example);

    int deleteByPrimaryKey(String serialno);

    void insert(BFinCustDs record);

    void insertSelective(BFinCustDs record);

    List<BFinCustDs> selectByExample(BFinCustDsExample example);

    List<BFinCustDs> selectByFinDirId(String finDirId);

    int updateByExampleSelective(BFinCustDs record, BFinCustDsExample example);

    int updateByExample(BFinCustDs record, BFinCustDsExample example);

    int updateByPrimaryKeySelective(BFinCustDs record);

    int updateByPrimaryKey(BFinCustDs record);

    List<BFinCustDs> selectByPage(BFinCustDsExample example, Page page);
    
    List<BFinCustDs> selectByFinId(BFinCustDs bFinCustDs);

	int deleteByFinId(String finId);

	public List<BFinCustDs> queryBfinCustDsByFdIRpSource(BFinCustDs bFinCustDs);
	/**
	 * 查询财务指标数据（含资产负债、现金流量、损益表）
	 * @param bFinCustDs
	 * @return List<BFinCustDs> 
	 */
	public List<BFinCustDs> queryAnalyData(BFinCustDs bFinCustDs);
	
	/**
	 * 财务指标 分析
	 * @param bFinCustDs
	 * @return
	 */
	public List<BFinCustDs> queryFinTargetAnalyData(BFinCustDs bFinCustDs);
	
	/**
	 * 通过客户财务记录号查询客户财务数据
	 * @param bFinCustDs
	 * @return
	 * @return List<BFinCustDs>
	 */
	public List<BFinCustDs> queryFinCustDsByFinId(String finId);
}