package com.huateng.scf.bas.icr.dao;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.icr.dao.model.BIcrBusiRel;
import com.huateng.scf.bas.icr.dao.model.BIcrBusiRelExample;

import java.util.List;

import org.springframework.scheduling.SchedulingException;

public interface IBIcrBusiRelDAO {
    int countByExample(BIcrBusiRelExample example);

    int deleteByExample(BIcrBusiRelExample example);

    int deleteByPrimaryKey(String id);

    void insert(BIcrBusiRel record);

    void insertSelective(BIcrBusiRel record);

    List<BIcrBusiRel> selectByExample(BIcrBusiRelExample example);

    BIcrBusiRel selectByPrimaryKey(String id);

    int updateByExampleSelective(BIcrBusiRel record, BIcrBusiRelExample example);

    int updateByExample(BIcrBusiRel record, BIcrBusiRelExample example);

    int updateByPrimaryKeySelective(BIcrBusiRel record);

    int updateByPrimaryKey(BIcrBusiRel record);

    List<BIcrBusiRel> selectByPage(BIcrBusiRelExample example, Page page);

	void addTblCreditBusiRel(String relaType, String creditNo, String businessNo) throws SchedulingException;
}