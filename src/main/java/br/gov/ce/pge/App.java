package br.gov.ce.pge;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class App {

    /**
     * Imprime duas estampas verticais na lateral direita do documento
     *
     * @param args
     * args[0] - nome do arquivo de entrada
     * args[1] - nome do arquivo de saida
     * args[2] - primeira linha da estampa
     * args[3] - segunda linha da estampa
     */
    public static void main(String[] args) {
        try {
            PdfReader pdfReader = new PdfReader(args[0]);
            Rectangle pageSize = pdfReader.getPageSizeWithRotation(1);
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(args[1]));

            for (int i = 1, ii = pdfReader.getNumberOfPages(); i <= ii; i++) {
                PdfContentByte content = pdfStamper.getOverContent(i);
                content.setFontAndSize(BaseFont.createFont("Helvetica", "Cp1252", false), 9.0F);

                content.beginText();
                content.showTextAligned(0, args[2], pageSize.getWidth() - 14.0F, 50.0F, 90.0F);
                content.showTextAligned(0, args[3], pageSize.getWidth() - 5.0F, 50.0F, 90.0F);
                content.endText();
            }
            pdfStamper.close();
        }
        catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

}
