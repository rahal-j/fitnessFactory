package com.school.school.PdfExporter;

import com.lowagie.text.*;
import com.lowagie.text.Font;
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
        cell.setBackgroundColor(Color.black);
        cell.setPadding(8);


        com.lowagie.text.Font font = com.lowagie.text.FontFactory.getFont(com.lowagie.text.FontFactory.HELVETICA);
        font.setColor(Color.white);


        cell.setPhrase(new Phrase("Receipt No",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("First Name",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Membership Exp Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Amount",font));
        table.addCell(cell);


    }



    private void writeTableData(PdfPTable table){

        for (Payment payment : listPayments){

            table.addCell(String.valueOf(payment.getId()));
            table.addCell(payment.getMemberId().getFirstName());
            table.addCell(String.valueOf(payment.getPaymentToDate()));
            table.addCell(String.valueOf(payment.getAmount()));



        }



    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {



        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document ,response.getOutputStream());


        Font fontH = FontFactory.getFont(FontFactory.COURIER_BOLD);
        fontH.setColor(Color.blue);
        fontH.setSize(20);

        Font fontA = FontFactory.getFont(FontFactory.COURIER);
        fontA.setColor(Color.DARK_GRAY);
        document.open();

        Font fontB = FontFactory.getFont(FontFactory.HELVETICA_BOLD);


        document.add(new Paragraph("              FITNESS FACTORY",fontH));
        document.add(new Paragraph("                         No.25,Malwana,Biyagama",fontA));
        document.add(new Paragraph("                           Tel:011-2 537 728",fontA));
        document.add(new Paragraph("Payment receipt",fontB));






        PdfPTable table = new PdfPTable(4);
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);


        document.close();




    }










}
