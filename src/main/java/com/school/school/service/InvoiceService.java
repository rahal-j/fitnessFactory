package com.school.school.service;

import com.school.school.dto.OrderModel;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public interface InvoiceService {
    File generateInvoiceFor(OrderModel order, Locale locale) throws IOException;
}
