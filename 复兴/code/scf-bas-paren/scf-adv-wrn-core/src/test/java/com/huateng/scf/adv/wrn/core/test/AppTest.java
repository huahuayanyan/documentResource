package com.huateng.scf.adv.wrn.core.test;

import java.util.Date;

import com.huateng.scf.bas.common.util.ScfDateUtil;

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
    public void testDateUtils(){
    	String dateStr = ScfDateUtil.formatDate(new Date());
    	System.out.println(dateStr);
    }
}
