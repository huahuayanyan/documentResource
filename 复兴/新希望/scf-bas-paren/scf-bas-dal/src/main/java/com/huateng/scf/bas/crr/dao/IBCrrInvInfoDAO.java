package com.huateng.scf.bas.crr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.model.BCrrInvInfo;
import com.huateng.scf.bas.crr.dao.model.BCrrInvInfoExample;
import java.util.List;
/**
 * 
 * <p>BCrrInvInfo数据库访问层通用实现类（ibatis自动生成）</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:35:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:35:42	     新增
 *
 * </pre>
 */
public interface IBCrrInvInfoDAO {
    int countByExample(BCrrInvInfoExample example);

    int deleteByExample(BCrrInvInfoExample example);

    int deleteByPrimaryKey(String invId);

    void insert(BCrrInvInfo record);

    void insertSelective(BCrrInvInfo record);

    List<BCrrInvInfo> selectByExample(BCrrInvInfoExample example);

    BCrrInvInfo selectByPrimaryKey(String invId);

    int updateByExampleSelective(BCrrInvInfo record, BCrrInvInfoExample example);

    int updateByExample(BCrrInvInfo record, BCrrInvInfoExample example);

    int updateByPrimaryKeySelective(BCrrInvInfo record);

    int updateByPrimaryKey(BCrrInvInfo record);

    List<BCrrInvInfo> selectByPage(BCrrInvInfoExample example, Page page);

	List<BCrrInvInfo> selectByExtId(String extId);

	int deleteByExtId(String extId);
}