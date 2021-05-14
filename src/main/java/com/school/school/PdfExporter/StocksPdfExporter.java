package com.school.school.PdfExporter;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.school.school.entity.Stocks;
import com.sun.javafx.font.FontFactory;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.Font;
import java.io.IOException;
import java.util.List;

public class StocksPdfExporter {

    private List<Stocks> listStocks;

    public StocksPdfExporter(List<Stocks> listStocks) {
        this.listStocks = listStocks;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.blue);
        cell.setPadding(10);




        cell.setPhrase(new Phrase("Stocks ID"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Product"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Batch No"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("expire Date"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Quantity"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date Created"));
        table.addCell(cell);




    }



    private void writeTableData(PdfPTable table){

        for (Stocks stocks : listStocks){
            table.addCell(String.valueOf(stocks.getId()));
            table.addCell(String.valueOf(stocks.getProduct()));
            table.addCell(String.valueOf(stocks.getBatchNo()));
            table.addCell(String.valueOf(stocks.getExpireDate()));
            table.addCell(String.valueOf(stocks.getQuantity()));
            table.addCell(String.valueOf(stocks.getDateCreated()));



        }



    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document ,response.getOutputStream());

        document.open();

        document.add(new Paragraph("List of all Stocks"));


        PdfPTable table = new PdfPTable(6);
        table.setSpacingBefore(15);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);


        document.close();




    }







}
