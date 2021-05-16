package com.school.school.PdfExporter;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.school.school.entity.Schedule;
import com.school.school.entity.Subscription;
import com.sun.scenario.effect.ImageData;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;


public class SchedulePdfExporter {


    private List<Schedule> listSchedules;

    public SchedulePdfExporter(List<Schedule> listSchedules) {
        this.listSchedules = listSchedules;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.black);
        cell.setPadding(10);


        com.lowagie.text.Font font = com.lowagie.text.FontFactory.getFont(com.lowagie.text.FontFactory.HELVETICA);
        font.setColor(Color.white);


        cell.setPhrase(new Phrase("Exercise",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("sets", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Reps", font));
        table.addCell(cell);


    }



    private void writeTableData(PdfPTable table){

        for (Schedule schedule : listSchedules){

            table.addCell(schedule.getExerciseId().getName());
            table.addCell(String.valueOf(schedule.getSets()));
            table.addCell(String.valueOf(schedule.getReps()));



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
        document.add(new Paragraph(listSchedules.get(0).getMemberId().getFirstName() +"'s "+ listSchedules.get(0).getName()+" Schedule",fontB));






        PdfPTable table = new PdfPTable(3);
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);


        document.close();




    }













}
