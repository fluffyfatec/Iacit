package com.fluffyiacit.api.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.itextpdf.text.*;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.fluffyiacit.api.modal.ViewTemperaturaModal;



public class PdfTemperatura {

    public static ByteArrayInputStream exportarPdfTemperatura (List<ViewTemperaturaModal> viewTemperaturaModals) {

        Document document = new Document(PageSize.A4.rotate(), 10, 10, 25, 25);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(80);
            table.setWidths(new int[] { 4, 4, 4, 4, 4, 4, 4});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);

            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("Data/Hora", headFont));
            hcell.setPaddingTop(7f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temperatura Ar", headFont));
            hcell.setPaddingTop(7f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temperatura Min", headFont));
            hcell.setPaddingTop(7f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temperatura Max", headFont));
            hcell.setPaddingTop(7f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temp Ponto Orv", headFont));
            hcell.setPaddingTop(7f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temp Orv Min", headFont));
            hcell.setPaddingTop(7f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temp Orv Max", headFont));
            hcell.setPaddingTop(7f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (ViewTemperaturaModal viewTemperaturaModal : viewTemperaturaModals) {

                Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
                Font fontDataHora = FontFactory.getFont(FontFactory.HELVETICA, 11, BaseColor.BLACK);

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(viewTemperaturaModal.getDatahoraCaptacao()), fontDataHora));
                cell.setPaddingTop(5f);
                cell.setFixedHeight(25f);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaAr(), font));
                cell.setPaddingTop(4f);
                cell.setFixedHeight(25f);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaMin(), font));
                cell.setPaddingTop(4f);
                cell.setFixedHeight(25f);
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaMax(), font));
                cell.setPaddingTop(4f);
                cell.setFixedHeight(25f);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaPontoOrvalho(), font));
                cell.setPaddingTop(4f);
                cell.setFixedHeight(25f);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaOrvalhoMin(), font));
                cell.setPaddingTop(4f);
                cell.setFixedHeight(25f);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaOrvalhoMax(), font));
                cell.setPaddingTop(4f);
                cell.setFixedHeight(25f);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

            }

            boolean b = true;
            for(PdfPRow r: table.getRows()) {
                for(PdfPCell c: r.getCells()) {
                    c.setBackgroundColor(b ? BaseColor.LIGHT_GRAY : BaseColor.WHITE);
                    c.setBorderColor(b ? BaseColor.LIGHT_GRAY : BaseColor.WHITE);
                }
                b = !b;
            }

            BaseColor myColor = WebColors.getRGBColor("#0D4A99");
            for(PdfPCell c: table.getRow(0).getCells()) {
                c.setBackgroundColor(myColor);
                c.setBorderColor(new BaseColor(13, 74, 153));
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

        }

        return new ByteArrayInputStream(out.toByteArray());
    }


}
