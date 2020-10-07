package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DealerEntity;

public interface DealerRepo extends JpaRepository<DealerEntity, String>{

	//List<DealerEntity> findByaddressentity(Integer integer);

	List<DealerEntity> findByaddressentity_pincode(String pincode);
	
}
