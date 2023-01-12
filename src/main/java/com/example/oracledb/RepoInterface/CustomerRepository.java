package com.example.oracledb.RepoInterface;

import com.example.oracledb.ModelClass.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository < Customer, Long> {

    Optional <Customer> findByName(String name);

    List<Customer> findByCustomerType(String customerType);

    List<Customer> findByOrderCountGreaterThan(int orderCount);

    List<Customer> findByDiscountPercentageGreaterThan(int discountPercentage);

    List<Customer> findByOrderDiscountsContaining(int orderDiscounts);

    @Override
    List < Customer > findAll ( );

    @Transactional
    @Modifying
    @Query("update Customer c set c.id = ?1")
    int updateIdBy (Long id);
}