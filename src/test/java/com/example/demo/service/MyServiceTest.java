//package com.example.demo.service;
//
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.example.demo.entity.AddressEntity;
//import com.example.demo.entity.DealerEntity;
//import com.example.demo.repo.DealerRepo;
//
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(MyService.class)
//public class MyServiceTest {
//	
//	@Before  
//    public void setUp() throws Exception {  
//        System.out.println("before");  
//    }
//	
//	@MockBean
//	DealerRepo myMockRepo;
//	
//	@Test
//	public void getAllDealers() {
//		
//		//DealerRepo myMockRepo = mock(DealerRepo.class);
//		AddressEntity inputAddress = new AddressEntity(700006,"manicktola");
//		DealerEntity inputDealer1 = new DealerEntity("Tanmoy1", inputAddress);
//		DealerEntity inputDealer2 = new DealerEntity("Tanmoy2", inputAddress);
//		List<DealerEntity> list_1= new ArrayList<>();
//		list_1.add(inputDealer1);
//		list_1.add(inputDealer2);
//		
//		when(myMockRepo.findAll()).thenReturn(list_1);
//		
//		//assertThat(returnedDealer).isEqualToComparingOnlyGivenFields
//		//(testController.finddealer(address), "name", "address","postalCode");
//		
//		assertTrue(myMockRepo.findAll() instanceof List<?>);
//		//assertTrue(true);
//		//System.out.println(myMockRepo.findAll());
//	}
//	
//	
//	@Test
//	public void addDealerTest() {
//		
//		//DealerRepo myMockRepo = mock(DealerRepo.class);
//	
//		AddressEntity inputAddress = new AddressEntity(700006,"manicktola");
//		DealerEntity inputDealer1 = new DealerEntity("Tanmoy1", inputAddress);
//		
//		when(myMockRepo.save(inputDealer1)).thenReturn(inputDealer1);
//	
//		assertTrue(myMockRepo.save(inputDealer1) instanceof DealerEntity);
//
//
//	}
//
//}
