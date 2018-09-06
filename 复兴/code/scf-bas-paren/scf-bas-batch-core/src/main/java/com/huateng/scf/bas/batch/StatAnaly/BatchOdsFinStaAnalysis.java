package com.huateng.scf.bas.batch.StatAnaly;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.huateng.scf.bas.batch.common.BatchUtil;
import com.huateng.scf.bas.batch.common.CommonService;
import com.huateng.scf.bas.batch.common.DataFormat;
import com.huateng.scf.bas.batch.common.DateUtil;
import com.huateng.scf.bas.batch.common.SystemConstant;
import com.huateng.scf.bas.batch.frame.BatchTemplet;
import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.qry.model.OFinaStaAnalysis;
import com.huateng.scf.bas.batch.control.scf.vo.WarnVO;

/**
 * 
 * <p>
 * 统计分析：融资统计分析
 * </p>
 *
 * @author shangxiujuan
 * @date 2017年7月5日上午10:37:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年7月5日上午10:37:04              新增
 *
 *            </pre>
 */
@SuppressWarnings("unused")
public class BatchOdsFinStaAnalysis extends BatchTemplet {

	private Connection conn;

	public BatchOdsFinStaAnalysis(Integer _id, String threadName, String _brcode) {
		super(_id, threadName, _brcode);
	}

	public BatchOdsFinStaAnalysis(Integer _id, String threadName) {
		super(_id, threadName);
	}

	@Override
	protected void doProcess() throws Exception {

		conn = this.getConn();
		List<OFinaStaAnalysis> list = CommonService.getFinaStaAnalysis(conn); // 查询客户信息
		String strBhdate = this.getBhdate().replace("-", "");// yyyy-MM-dd 批量日期

		PreparedStatement pstmtdelete = null; 
		PreparedStatement pstmtinsert = null;

		StringBuffer deleteFin = new StringBuffer();// 删除融资统计分析信息
		deleteFin.append("delete from ODS_FINA_STA_ANALYSIS t ");

		StringBuffer insertFin = new StringBuffer();// 新增融资统计分析信息
		insertFin.append("insert into ODS_FINA_STA_ANALYSIS(ID,PROJECT_ID,PROJECT,FINA_TYPE,AMOUNT,FINA_DATE,LAST_UPD_TIME) ")

				.append("  values(?, ?, ?, ?, ? ,?, ?)  ");

		this.writeFileLog("###########融资统计分析 start ");

		try {
			pstmtdelete = conn.prepareStatement(deleteFin.toString());
			int i = pstmtdelete.executeUpdate();
			if (i < 0) {
				throw new Exception("#############delete rows : " + i + " ,delete sql:" + deleteFin);
			}
			if (null != list && list.size() > 0) {
				for (OFinaStaAnalysis info : list) {
					if (StringUtil.isStrNotEmpty(info.getFinaDate())) {
						strBhdate = info.getFinaDate();
					}
					// 不存在记录，新增记录
					String id = BatchUtil.getUUID();
					pstmtinsert = conn.prepareStatement(insertFin.toString());
					pstmtinsert.setString(1, id);
					pstmtinsert.setString(2, info.getProjectId());
					pstmtinsert.setString(3, info.getProject());
					pstmtinsert.setString(4, info.getFinaType());
					pstmtinsert.setBigDecimal(5, info.getAmount());
					pstmtinsert.setString(6, strBhdate);
					pstmtinsert.setTime(7, DateUtil.getCurrentTime());
					int j = pstmtinsert.executeUpdate();
					if (j <= 0) {
						throw new Exception("#############insert rows : " + i + ", insert sql:" + insertFin);
					}
				}
			}
			this.writeFileLog("############融资统计分析end,新增 " + list.size() + "条记录");
			conn.commit();
		} finally {
			if (pstmtdelete != null)
				pstmtdelete.close();
			if (pstmtinsert != null)
				pstmtinsert.close();
		}
	}
}
