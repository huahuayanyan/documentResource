package com.huateng.scf.rec.qry.core.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import com.huateng.scf.rec.bcp.model.DebtBillsInfoVO;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    @org.junit.Test
    public void testGetDebtReturnAccountImpDetail(){
    	
    	for(int i=0;i<100;i++){
    		String returnAccount="456679";
    		List<DebtBillsInfoVO> resultList =new ArrayList<DebtBillsInfoVO>();
    		DebtBillsInfoVO debtvo1=new DebtBillsInfoVO();
    		debtvo1.setRepayAccount(returnAccount);
    		debtvo1.setReturnDate("20151225");
    		debtvo1.setReceiveAmount(new BigDecimal(4313));
    		debtvo1.setPayerName("AAA");
    		debtvo1.setPayerAcctNo(" ");
    		debtvo1.setPayerBank(" ");
    		debtvo1.setMemo("D");
    		
    		DebtBillsInfoVO debtvo2=new DebtBillsInfoVO();
    		debtvo2.setRepayAccount(returnAccount);
    		debtvo2.setReturnDate("20150209");
    		debtvo2.setReceiveAmount(new BigDecimal(6124));
    		debtvo2.setPayerName("EEE");
    		debtvo2.setPayerAcctNo(" ");
    		debtvo2.setPayerBank(" ");
    		debtvo2.setMemo("D");
    		resultList.add(debtvo2);
    		
    		DebtBillsInfoVO debtvo3=new DebtBillsInfoVO();
    		debtvo3.setRepayAccount(returnAccount);
    		debtvo3.setReturnDate("20160713");
    		debtvo3.setReceiveAmount(new BigDecimal(1210));
    		debtvo3.setPayerName("DDD");
    		debtvo3.setPayerAcctNo(" ");
    		debtvo3.setPayerBank(" ");
    		debtvo3.setMemo("D");
    		resultList.add(debtvo3);
    		
    		DebtBillsInfoVO debtvo4=new DebtBillsInfoVO();
    		debtvo4.setRepayAccount(returnAccount);
    		debtvo4.setReturnDate("20160921");
    		debtvo4.setReceiveAmount(new BigDecimal(4566));
    		debtvo4.setPayerName("CCC");
    		debtvo4.setPayerAcctNo(" ");
    		debtvo4.setPayerBank(" ");
    		debtvo4.setMemo("D");
    		resultList.add(debtvo4);
    		
    		DebtBillsInfoVO debtvo5=new DebtBillsInfoVO();
    		debtvo5.setRepayAccount(returnAccount);
    		debtvo5.setReturnDate("20161031");
    		debtvo5.setReceiveAmount(new BigDecimal(9779));
    		debtvo5.setPayerName("BBB");
    		debtvo5.setPayerAcctNo(" ");
    		debtvo5.setPayerBank(" ");
    		debtvo5.setMemo("D");
    		resultList.add(debtvo5);
    		
    		int from = RandomUtils.nextInt(0, resultList.size());
    		int to = RandomUtils.nextInt(0, resultList.size());
    		if(from > to){
    			int temp = from;
    			to = from;
    			from = temp;
    		}
    		if(from == to){
    			if(from == 0){
    				to =3;
    			}else if(from ==resultList.size()){
    				from =from-3;
    			}else{
    				from = from -1;
    			}
    		}
    		
    		List<DebtBillsInfoVO> sublist = resultList.subList(from, to);
    		List<DebtBillsInfoVO> qrylist = new ArrayList<DebtBillsInfoVO>();
    		System.out.println(sublist.size());
    		
    	}
    	

    }
}
