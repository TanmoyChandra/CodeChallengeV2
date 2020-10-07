package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AddressEntity;

public interface AddressRepo extends JpaRepository<AddressEntity, String>{

}
