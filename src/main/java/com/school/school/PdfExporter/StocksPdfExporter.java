package com.school.school.PdfExporter;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.school.school.entity.Stocks;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.List;

public class StocksPdfExporter {

    private List<Stocks> listStocks;

    public StocksPdfExporter(List<Stocks> listStocks) {
        this.listStocks = listStocks;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.black);
        cell.setPadding(10);


        com.lowagie.text.Font font = com.lowagie.text.FontFactory.getFont(com.lowagie.text.FontFactory.HELVETICA);
        font.setColor(Color.white);




        cell.setPhrase(new Phrase("Stocks ID" ,font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Product", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Batch No" ,font));
        table.addCell(cell);


        cell.setPhrase(new Phrase("Quantity" ,font));
        table.addCell(cell);





    }



    private void writeTableData(PdfPTable table){

        for (Stocks stocks : listStocks){
            table.addCell(String.valueOf(stocks.getId()));
            table.addCell(stocks.getProduct().getName());
            table.addCell(String.valueOf(stocks.getBatchNo()));
            table.addCell(String.valueOf(stocks.getQuantity()));



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
        document.add(new Paragraph("List of  Stocks",fontB));


        PdfPTable table = new PdfPTable(4);
        table.setSpacingBefore(18);


        writeTableHeader(table);
        writeTableData(table);

        document.add(table);


        document.close();




    }







}
