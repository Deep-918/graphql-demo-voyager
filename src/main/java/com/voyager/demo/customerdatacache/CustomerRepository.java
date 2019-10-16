package com.voyager.demo.customerdatacache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface CustomerRepository extends JpaRepository<Customer, Long> {
}