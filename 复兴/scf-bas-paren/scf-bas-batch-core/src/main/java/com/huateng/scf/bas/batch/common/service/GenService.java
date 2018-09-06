package com.huateng.scf.bas.batch.common.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.common.DataFormat;
import com.huateng.scf.bas.batch.common.SystemConstant;
import java.sql.Connection;

/**
 * Title: com.huateng.scf.bas.batch.common.service.GenService.java
 * Description: JDBC序列生成service
 * @author Jangsben
 * @version v1.0
 * @since 2009-08-20
 */
public class GenService {


	public GenService() {
		super();
	}


	/**
	 * 通过JDBC方式获取转应解汇款自增数
	 * @author Jangbsen
	 * @since 2009-08-20
	 */
	public String getConvertPayQryNoGen()throws Exception{
		Connection conn = BatchUtil.getConnection(); // 取得数据库连接
		return DataFormat.intToString(this.getSeqctlVo(conn,SystemConstant.VALUE_NO_CONVERT_PAY_NO, SystemConstant.VALUE_INDEX), 6);
	}

	/**
	 * 通过JDBC方式获取核心流水号
	 * @author Jangbsen
	 * @since 2009-08-20
	 */
	public String GetHostnoGen()throws Exception{
		Connection conn = BatchUtil.getConnection(); // 取得数据库连接
		return DataFormat.intToString(this.getSeqctlVo(conn,SystemConstant.VALUE_NO_CALL_HOST, SystemConstant.VALUE_INDEX), 10);
	}


	/**
	 * 通过传入SEQCTL表的VALUE_NO和VALUE_INDEX来实现自增
	 * @author Jangbsen
	 * @param conn
	 * @param VALUE_NO
	 * @param VALUE_INDEX
	 * @throws Exception
	 * @since 2009-08-20
	 */
	public static Integer getSeqctlVo(Connection conn, Integer valueNo, String valueIndex) throws Exception{

		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		ResultSet rs = null; // 查询结果集
		ResultSet rs1 = null; // 查询结果集
		Integer seqNo = null;
		try {
			stmt= conn.prepareStatement("select VALUE_NO, VALUE_INDEX , VALUE_CURR, MAX_VALUE, MIN_VALUE from SEQCTL where VALUE_NO = ? AND VALUE_INDEX = ? "); // 创建statement
			stmt.setInt(1, valueNo);
			stmt.setString(2, valueIndex);
			rs = stmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(3) > rs.getInt(4)){
					seqNo = rs.getInt(5);
				}else{
					seqNo = rs.getInt(3)+1;
				}
				stmt1= conn.prepareStatement("UPDATE SEQCTL SET VALUE_CURR=? WHERE VALUE_NO = ? and VALUE_INDEX=?");
				stmt1.setInt(1, seqNo);
				stmt1.setInt(2, valueNo);
				stmt1.setString(3, valueIndex);
				stmt1.executeUpdate();
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (stmt1 != null) {
					stmt1.close();
				}
				return seqNo;
			}else{
				stmt2= conn.prepareStatement("select VALUE_NO, VALUE_INDEX , VALUE_CURR, MAX_VALUE, MIN_VALUE from SEQCTL where VALUE_NO = ? AND VALUE_INDEX = ? "); // 创建statement
				stmt2.setInt(1, valueNo);
				stmt2.setString(2, SystemConstant.VALUE_INDEX);
				rs1 = stmt2.executeQuery();
				while(rs1.next()){
					// 取得当前序号
					seqNo = rs1.getInt(5);

					stmt3 = conn.prepareStatement("insert into SEQCTL (VALUE_NO, VALUE_INDEX, VALUE_CURR, MAX_VALUE, MIN_VALUE) values (?,?,?,?,?)");
					// 插入记录
					stmt3.setInt(1, rs1.getInt(1));
					stmt3.setString(2, rs1.getString(2));
					stmt3.setInt(3, rs1.getInt(5)+1);
					stmt3.setInt(4, rs1.getInt(4));
					stmt3.setInt(5, rs1.getInt(5));
					stmt3.executeUpdate();
					if (rs1 != null) {
						rs1.close();
					}
					if (stmt2 != null) {
						stmt2.close();
					}
					if (stmt3 != null) {
						stmt3.close();
					}
					return seqNo;
				}
			}
		}catch(Exception ex){

		}finally{
			if (rs != null) {
				rs.close();
			}
			if (rs1 != null) {
				rs1.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (stmt1 != null) {
				stmt1.close();
			}
			if (stmt2 != null) {
				stmt2.close();
			}
			if (stmt3 != null) {
				stmt3.close();
			}
		}
		return 0001;
	}

}
