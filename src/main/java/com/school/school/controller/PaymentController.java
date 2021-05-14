package com.school.school.controller;


import com.lowagie.text.DocumentException;
import com.school.school.PdfExporter.InvoicePdfExporter;
import com.school.school.PdfExporter.PaymentPdfExporter;
import com.school.school.dto.PaymentDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubscriptionDto;
import com.school.school.entity.Invoice;
import com.school.school.entity.Payment;
import com.school.school.service.PaymentService;
import com.school.school.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("payment")
@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping("/")
    public String addPayment(Model model){
        model.addAttribute("payment",paymentService.fetchPayment());
                return "payment_list";
    }

    @GetMapping("/insertPage")
    public String addPage(Model model) {

        List<SubscriptionDto> subscriptionDtos = subscriptionService.getActiveSubscriptionList();
        model.addAttribute("subscriptions",subscriptionDtos);
        return "payment_form";}


    @PostMapping("/save")
    @ResponseBody
    public ResponseDto savePayment(@RequestBody PaymentDto paymentDto){
        return paymentService.addPayment(paymentDto);
    }

    @GetMapping("/searchMember")
    @ResponseBody
    public ResponseDto getPaymentDto(@RequestParam String nic){

        return paymentService.getPaymentDto(nic);

    }


    @GetMapping("/export")
    public void exportToPdf(HttpServletResponse response, @RequestParam String id) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        String headerKey = "content-deposition";
        String headerValue = "attachment; filename = subscription.pdf";

        response.setHeader(headerKey, headerValue);
        List<Payment> payments = paymentService.fetchPaymentFromMember(id);

        PaymentPdfExporter exporter = new PaymentPdfExporter(payments);
        exporter.export(response);


    }

















}
