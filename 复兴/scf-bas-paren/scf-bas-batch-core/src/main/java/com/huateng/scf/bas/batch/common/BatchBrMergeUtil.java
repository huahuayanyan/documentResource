/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2006 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.batch.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.huateng.scf.bas.batch.vo.BhBrMergeInfoVO;

/**
 * @Title:com.huateng.scf.bas.batch.common.BatchBrMergeUtil.java
 * @Description:根据传入日期判断该日是否有机构拆并业务
 * @Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author Qingguang.Li
 * @version v1.0,2010-05-02
 */
public class BatchBrMergeUtil {

	/**
	 * @author Qingguang.Li
	 * @Created 2010-05-03
	 * @Title: isMergeBrcode
	 * @Description: 根据传入日期判断该日是否有机构拆并业务
	 * @param conn
	 * @param dDate
	 * @return
	 * @throws Exception
	 */
	public static boolean isMergeBrcode(Connection conn, String dDate)
		throws Exception {

		Statement stmt = null;
		StringBuffer sb = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer(BatchConstant.STRING_BUFFER_LEN_MID);

			sb.delete(0, sb.length());
			sb.append("select id, branch_brcode, old_brcode, new_brcode from BCTL_MERGE_INFO ")
				.append(" where merge_date = ? and valid_flag = '" + BatchConstant.MERGEINFO_FLAG_VALID + "'");
			ps = conn.prepareStatement(sb.toString());

			ps.setString(1, dDate);
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e1) {
			throw e1;
		} finally {
			if (rs != null)	rs.close();
			if (stmt != null)	stmt.close();
			if (ps != null)	ps.close();
		}
	}


	/**
	 * @author Qingguang.Li
	 * @Created 2010-05-03
	 * @Title: getMergeInfoList
	 * @Description: 根据传入日期获取拆并机构清单
	 * @param conn
	 * @param dDate
	 * @return if no data return null else return ArrayList
	 * @throws Exception
	 */
	public static ArrayList getMergeInfoList(Connection conn, String dDate)
		throws Exception {

		Statement stmt = null;
		StringBuffer sb = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		BhBrMergeInfoVO mrgInfoVO = null;
		ArrayList mrgInfoList = new ArrayList();

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer(BatchConstant.STRING_BUFFER_LEN_MID);

			sb.delete(0, sb.length());
			sb.append(
				"select id, merge_date, branch_brcode, old_brcode, new_brcode, " +
				"tlr_mrg_flg, bsn_mrg_flg, sts_mrg_flg, wrk_flw_flg, valid_flag,  " +
				"timestamp,relation_id,reverse_flag from BCTL_MERGE_INFO ")
				.append(" where merge_date = ? and valid_flag = '" + BatchConstant.MERGEINFO_FLAG_VALID + "'");
			ps = conn.prepareStatement(sb.toString());

			ps.setString(1, dDate);
			rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				mrgInfoVO = new BhBrMergeInfoVO();
				mrgInfoVO.setId(rs.getString("id"));
				mrgInfoVO.setMergeDate(BatchUtil.trim(rs.getString("merge_date")));
				mrgInfoVO.setBranchBrcode(BatchUtil.trim(rs.getString("branch_brcode")));
				mrgInfoVO.setOldBrcode(BatchUtil.trim(rs.getString("old_brcode")));
				mrgInfoVO.setNewBrcode(BatchUtil.trim(rs.getString("new_brcode")));
				mrgInfoVO.setTlrMrgFlg(BatchUtil.trim(rs.getString("tlr_mrg_flg")));
				mrgInfoVO.setBsnMrgflg(BatchUtil.trim(rs.getString("bsn_mrg_flg")));
				mrgInfoVO.setStsMrgFlg(BatchUtil.trim(rs.getString("sts_mrg_flg")));
				mrgInfoVO.setWrkFlwFlg(BatchUtil.trim(rs.getString("wrk_flw_flg")));
				mrgInfoVO.setValidFlag(BatchUtil.trim(rs.getString("valid_flag")));
				mrgInfoVO.setTimestamp(BatchUtil.trim(rs.getString("timestamp")));
				mrgInfoVO.setRelationId(BatchUtil.trim(rs.getString("relation_id")));
				mrgInfoVO.setReverseFlag(BatchUtil.trim(rs.getString("reverse_flag")));
				i++;

				mrgInfoList.add((BhBrMergeInfoVO) mrgInfoVO);
			}

			if (i == 0) mrgInfoList = null;

		} catch (SQLException e1) {
			throw e1;
		} finally {
			if (rs != null)	rs.close();
			if (stmt != null)	stmt.close();
			if (ps != null)	ps.close();
		}
		return mrgInfoList;
	}

	/**
	 *
	 * @author Qingguang.Li
	 * @Created 2010-05-03
	 * @Title: updateMergeInfo
	 * @Description: 根据ID更新机构拆并信息表的各个标志状态
	 *  tlr_mrg_flg=?, bsn_mrg_flg=?, sts_mrg_flg=?, wrk_flw_flg=?, crd_mrg_flg=? 及时间戳timestamp
	 * @param vo
	 */
	public static void updFlgMergeInfo(Connection conn, BhBrMergeInfoVO vo) throws Exception {

		Statement stmt = null;
		StringBuffer sb = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			sb = new StringBuffer(BatchConstant.STRING_BUFFER_LEN_MID);

			sb.delete(0, sb.length());
			sb.append("update BCTL_MERGE_INFO set tlr_mrg_flg=?,bsn_mrg_flg=?,sts_mrg_flg=?,wrk_flw_flg=?,,timestamp=? where id=?");
			ps = conn.prepareStatement(sb.toString());

			ps.setString(1, vo.getTlrMrgFlg());
			ps.setString(2, vo.getBsnMrgflg());
			ps.setString(3, vo.getStsMrgFlg());
			ps.setString(4, vo.getWrkFlwFlg());
			ps.setString(5,  BatchUtil.getTimestamp());
			ps.setString(6, vo.getId());

			if (ps.executeUpdate() != 1)
				throw new Exception( "br_merge_info 更新状态错误[]" + vo.getId() + "]");;

		} catch (SQLException e1) {
			throw e1;
		} finally {
			if (rs != null)	rs.close();
			if (stmt != null)	stmt.close();
			if (ps != null)	ps.close();
		}
	}

}

