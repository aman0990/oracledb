package com.example.oracledb.RepoInterface;

import com.example.oracledb.ModelClass.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository < Order, Long > {
}