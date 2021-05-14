package com.school.school.PdfExporter;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.school.school.entity.Payment;
import com.school.school.entity.Schedule;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PaymentPdfExporter {

    private List<Payment> listPayments;

    public PaymentPdfExporter(List<Payment> listPayments) {
        this.listPayments = listPayments;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.blue);
        cell.setPadding(10);


        cell.setPhrase(new Phrase("Member"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("memberShip Exp Date"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Amount"));
        table.addCell(cell);


    }



    private void writeTableData(PdfPTable table){

        for (Payment payment : listPayments){

            table.addCell(payment.getMemberId().getFirstName());
            table.addCell(String.valueOf(payment.getPaymentToDate()));
            table.addCell(payment.getAmount());



        }



    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {



        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document ,response.getOutputStream());

        document.open();


        document.add(new Paragraph("Member :"+listPayments.get(0).getMemberId().getFirstName() ));


        PdfPTable table = new PdfPTable(3);
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);


        document.close();




    }










}
