package com.huateng.scf.bas.batch.test;
import com.huateng.scf.bas.batch.common.BatchConstant;
import com.huateng.scf.bas.batch.control.GeneralControl;

public class SingleBatchTest {
	public static void main(String[] args) {
		try {
			//GeneralControl.startSingle(BatchConstant.GENERAL_CONTROL_THREAD_NAME,99,1,1);
			GeneralControl.startJob(BatchConstant.GENERAL_CONTROL_THREAD_NAME, 99);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
