package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyRela;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyRelaExample;
import com.huateng.scf.bas.crr.dao.model.BCrrGntyRelaKey;
import java.util.List;
/**
 * 
 * <p>BCrrGntyRela数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:45
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:45	     新增
 *
 * </pre>
 */
public interface IBCrrGntyRelaDAO {
    int countByExample(BCrrGntyRelaExample example);

    int deleteByExample(BCrrGntyRelaExample example);

    int deleteByPrimaryKey(BCrrGntyRelaKey _key);

    void insert(BCrrGntyRela record);

    void insertSelective(BCrrGntyRela record);

    List<BCrrGntyRela> selectByExample(BCrrGntyRelaExample example);

    BCrrGntyRela selectByPrimaryKey(BCrrGntyRelaKey _key);

    int updateByExampleSelective(BCrrGntyRela record, BCrrGntyRelaExample example);

    int updateByExample(BCrrGntyRela record, BCrrGntyRelaExample example);

    int updateByPrimaryKeySelective(BCrrGntyRela record);

    int updateByPrimaryKey(BCrrGntyRela record);

    List<BCrrGntyRela> selectByPage(BCrrGntyRelaExample example, Page page);

	BCrrGntyRela selectByRltNo(String rltNo);

	int deleteByRltNo(String rltNo);

	List<BCrrGntyRela> selectBySerialno(String serialno);

	int deleteBySerialno(String serialno);
}