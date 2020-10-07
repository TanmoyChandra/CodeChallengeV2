package com.example.demo.test;
import com.example.demo.service.MyService;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UnitTest {  

	MyService myservice = new MyService();
	@Before  
    public void setUp() throws Exception {  
        System.out.println("before");  
    }
//  
    @Test  
    public void testAllDealers(){  
    	System.out.println("Testing AllDealers()");
    	assertTrue(myservice.getAllDealers() instanceof ArrayList<?> );
    	
    }  
    
//    @Test  
//    public void testFetchDealers(){  
//    	System.out.println("Testing FetchDealers()");
//    	Dealer obj = myservice.fetchDealer("kerala");
//    	assertTrue(obj instanceof Dealer);
//    }  
    
//    @Test
//    public void testAddDealers(){  
//    	System.out.println("Testing AddDealers()");
//    	assertTrue(myservice.addDealer(null) instanceof ArrayList<?> );
//    }  
    
    
	@After  
    public void tearDown() throws Exception {  
        System.out.println("after");  
    }  
}