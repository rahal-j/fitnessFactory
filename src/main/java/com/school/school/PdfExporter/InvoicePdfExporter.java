package com.school.school.PdfExporter;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.school.school.entity.Invoice;
import com.school.school.entity.Schedule;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class InvoicePdfExporter {

    private List<Invoice> listInvoices;

    public InvoicePdfExporter(List<Invoice> listInvoices) {
        this.listInvoices = listInvoices;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.blue);
        cell.setPadding(10);


        cell.setPhrase(new Phrase("Product"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Unit Price"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Quantity"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Subtotal"));
        table.addCell(cell);


    }



    private void writeTableData(PdfPTable table){

        for (Invoice invoice : listInvoices){

            table.addCell(invoice.getProduct().getName());
            table.addCell(String.valueOf(invoice.getUnitPrice()));
            table.addCell(String.valueOf(invoice.getQuantity()));
            table.addCell(String.valueOf(invoice.getSubtotal()));



        }



    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document ,response.getOutputStream());

        document.open();
        document.add(new Paragraph("Schedule :"+listInvoices.get(0).getMemberId().getFirstName()));


        PdfPTable table = new PdfPTable(4);
        table.setSpacingBefore(15);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.add(new Paragraph("Total :"+listInvoices.get(0).getTotal()));

        document.close();




    }













}
