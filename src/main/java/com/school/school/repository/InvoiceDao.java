package com.school.school.repository;

import com.school.school.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceDao extends JpaRepository<Invoice,Integer> {


//   @Query(value = "SELECT * FROM stocks WHERE product = ?1 and status = 'ACTIVE'",nativeQuery = true);



}
