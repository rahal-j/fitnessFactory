package com.school.school.PdfExporter;

import com.lowagie.text.*;
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
        cell.setBackgroundColor(Color.blue);
        cell.setPadding(10);


        cell.setPhrase(new Phrase("Exercise"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("sets"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Reps"));
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

        document.open();


        document.add(new Paragraph("Member :"+listSchedules.get(0).getMemberId().getFirstName() +"'s "+ listSchedules.get(0).getName()+" Schedule"));


        PdfPTable table = new PdfPTable(3);
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);


        document.close();




    }













}
