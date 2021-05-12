package com.school.school.PdfExporter;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.school.school.entity.Subscription;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SubscriptionPdfExporter {
    private List<Subscription> listSubscriptions;

    public SubscriptionPdfExporter(List<Subscription> listSubscriptions) {
        this.listSubscriptions = listSubscriptions;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase("Subscription ID"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("status"));
        table.addCell(cell);



    }



    private void writeTableData(PdfPTable table){

        for (Subscription subscription : listSubscriptions){
            table.addCell(String.valueOf(subscription.getId()));
            table.addCell(subscription.getName());
            table.addCell(subscription.getStatus());


        }



    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document ,response.getOutputStream());

        document.open();

        document.add(new Paragraph("List of All Subscription"));


        PdfPTable table = new PdfPTable(3);
        table.setSpacingBefore(15);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);


        document.close();




    }










}
