package com.fluffyiacit.api.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.springframework.data.repository.query.Param;


public class PdfTemperatura {

    public static ByteArrayInputStream exportarPdfTemperatura (List<ViewTemperaturaModal> viewTemperaturaModals) throws IOException {

        //Criando o documento PDF
        Document document = new Document(PageSize.A4.rotate(), 25, 25, 25, 25);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            //Criando a tabela para o relatório
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setWidths(new int[] { 4, 4, 4, 4, 4, 4, 4});

            //Criando o cabeçalho da tabela
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.WHITE);

            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("Data/Hora", headFont));
            hcell.setPaddingTop(9f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temperatura Ar", headFont));
            hcell.setPaddingTop(9f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temperatura Mínima", headFont));
            hcell.setPaddingTop(3.5f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temperatura Máxima", headFont));
            hcell.setPaddingTop(3.5f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temp Ponto Orvalho", headFont));
            hcell.setPaddingTop(3.5f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temp Orvalho Mínima", headFont));
            hcell.setPaddingTop(3.5f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Temp Orvalho Máxima", headFont));
            hcell.setPaddingTop(3.5f);
            hcell.setFixedHeight(40f);
            hcell.setVerticalAlignment(Element.ALIGN_CENTER);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (ViewTemperaturaModal viewTemperaturaModal : viewTemperaturaModals) {

                //Povoando as células da tabela
                Font font = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
                Font fontDataHora = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(viewTemperaturaModal.getDatahoraCaptacao()), fontDataHora));
                cell.setPaddingTop(4f);
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

            //Alternando a cor do background e do grid das células entre branco e cinza
            boolean b = true;
            for(PdfPRow r: table.getRows()) {
                for(PdfPCell c: r.getCells()) {
                    c.setBackgroundColor(b ? BaseColor.LIGHT_GRAY : BaseColor.WHITE);
                    c.setBorderColor(b ? BaseColor.LIGHT_GRAY : BaseColor.WHITE);
                }
                b = !b;
            }

            //Definindo a cor do background e do grid do cabeçalho
            for(PdfPCell c: table.getRow(0).getCells()) {
                c.setBackgroundColor(new BaseColor(13, 74, 153));
                c.setBorderColor(new BaseColor(13, 74, 153));
            }

            //Determinando a repetição do cabeçalho em todas as páginas geradas
            table.setHeaderRows(1);

            //Abrindo o documento PDF para ser editado
            PdfWriter.getInstance(document, out);
            document.open();

            //Adicionando imagem
            Image img = Image.getInstance("images\\iacit.png");
            img.setAbsolutePosition(635f, PageSize.A4.getHeight() - img.getScaledHeight() - 90);
            img.scaleAbsolute(175f, 115f);

            //Definindo parágrafos para o título do documento PDF
            Paragraph textoEstacao = new Paragraph(new Phrase("Estação " + viewTemperaturaModals.get(0).getEstacaoNome()
                    + ", " + "Estado de " + viewTemperaturaModals.get(0).getEstacaoEstado(), FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK)));
            textoEstacao.setAlignment(Element.ALIGN_LEFT);

            Paragraph textoDataHora = new Paragraph(new Phrase("Dados de " + new SimpleDateFormat("dd/MM/yyyy HH:mm")
                    .format(viewTemperaturaModals.get(0).getDatahoraCaptacao()) + " até " +
                    new SimpleDateFormat("dd/MM/yyyy HH:mm").format(viewTemperaturaModals
                            .get(viewTemperaturaModals.size() - 1).getDatahoraCaptacao()),
                    FontFactory.getFont(FontFactory.HELVETICA, 21, BaseColor.BLACK)));
            textoDataHora.setAlignment(Element.ALIGN_LEFT);

            Paragraph textoDados = new Paragraph(new Phrase("Temperatura", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK)));
            textoDados.setAlignment(Element.ALIGN_CENTER);

            Paragraph pulaLinha = new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.HELVETICA, 18, BaseColor.BLACK)));

            //Adicionando os parágrafos, imagem e tabela ao documento PDF
            document.add(img);
            document.add(textoEstacao);
            document.add(textoDataHora);
            document.add(pulaLinha);
            document.add(textoDados);
            document.add(pulaLinha);
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

        }

        return new ByteArrayInputStream(out.toByteArray());
    }


}
