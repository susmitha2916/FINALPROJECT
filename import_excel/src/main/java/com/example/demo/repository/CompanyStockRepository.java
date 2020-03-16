package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CompanyStock;

public interface CompanyStockRepository extends JpaRepository<CompanyStock,Integer> {

}
