package com.school.school.repository;

import com.school.school.entity.Invoice;
import com.school.school.entity.Member;
import com.school.school.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceDao extends JpaRepository<Invoice,Integer> {


    List<Invoice> findByMemberIdAndStatus(Member member, String status);

    List<Invoice> findByInvoiceId(String invoiceId);

    @Query(value = "SELECT * FROM fitness_factory.invoice  where status='ACTIVE' group by invoice_id", nativeQuery = true)
    List<Invoice>findGroupByInvoice();


    Invoice findAllByInvoiceId (String invoiceId);

}
