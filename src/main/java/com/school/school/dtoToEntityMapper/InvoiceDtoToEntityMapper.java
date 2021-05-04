package com.school.school.dtoToEntityMapper;

import com.school.school.dto.InvoiceDto;
import com.school.school.entity.Invoice;
import com.school.school.entity.Product;

import java.util.Date;

public class InvoiceDtoToEntityMapper {

    public static Invoice getInvoiceEntity(InvoiceDto invoiceDto, Invoice invoice,Product product){
        invoice.setId(invoice.getId() !=null? invoice.getId(): invoiceDto.getId());
        invoice.setDate(new Date());
        invoice.setDiscount(invoiceDto.getDiscount());
        invoice.setQuantity(invoiceDto.getQuantity());
        invoice.setTotal(invoiceDto.getTotal());
        invoice.setProduct(product);
        return invoice;


    }


}
