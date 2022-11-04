package com.fluffyiacit.api.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.fluffyiacit.api.modal.ViewTemperaturaModal;



public class PdfTemperatura {

    public static ByteArrayInputStream exportarPdfTemperatura (List<ViewTemperaturaModal> viewTemperaturaModals) {

        Document document = new Document(PageSize.A4.rotate(), 10, 10, 25, 25);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(80);
            table.setWidths(new int[] { 4, 4, 4 });

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Temperatura Ar", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temperatura Min", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temperatura Max", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temp Orv Min", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temp Orv Max", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temp Ponto Orv", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (ViewTemperaturaModal viewTemperaturaModal : viewTemperaturaModals) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaAr()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaMin()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaMax()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaOrvalhoMin()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaOrvalhoMax()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);

                cell = new PdfPCell(new Phrase(viewTemperaturaModal.getTemperaturaPontoOrvalho()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell);
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
