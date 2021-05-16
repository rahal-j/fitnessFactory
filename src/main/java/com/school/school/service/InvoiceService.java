package com.school.school.service;

import com.school.school.dto.InvoiceDto;
import com.school.school.dto.OrderModel;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.StocksInvoiceDto;
import com.school.school.entity.Invoice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public interface InvoiceService {
    File generateInvoiceFor(OrderModel order, Locale locale) throws IOException;

    ResponseDto addInvoice(InvoiceDto invoiceDto);

    List<Invoice> fetchInvoice();



    List<Invoice> fetchInvoiceFromInvoiceId(String invoiceId);

    ResponseDto saveInvoiceArray(StocksInvoiceDto stocksInvoiceDto);

    ResponseDto getInvoiceDto(String nic);

    ResponseDto getUnitPriceAndQty(String productId);
}
