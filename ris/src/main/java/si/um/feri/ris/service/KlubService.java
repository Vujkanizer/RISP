package si.um.feri.ris.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.repository.KlubRepository;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Service
public class KlubService {

    private final KlubRepository klubRepository;

    @Autowired
    public KlubService(KlubRepository klubRepository) {
        this.klubRepository = klubRepository;
    }

    public List<Klub> dohvatiSveKlubove() {
        return klubRepository.findAll();
    }

    public Optional<Klub> dohvatiKlubPoId(Long id) {
        return klubRepository.findById(id);
    }

    public Klub spremiKlub(Klub klub) {
        return klubRepository.save(klub);
    }

    public void azurirajKlub(Long id, Klub noviKlub) {
        if (klubRepository.existsById(id)) {
            noviKlub.setIdKlub(id);
            klubRepository.save(noviKlub);
        }
    }

    public void obrisiKlub(Long id) {
        klubRepository.deleteById(id);
    }

    public List<Klub> dohvatiAktivneKluboveZaTipKluba(boolean status) {
        return klubRepository.findByStatusAndTipKlubaId(status);
    }


    public void createKlubAndGeneratePdf(Klub klub) throws DocumentException, IOException {

        Klub savedKlub = klubRepository.save(klub);

        ByteArrayOutputStream pdfStream = generatePdfForKlub(savedKlub);

         String desktopPath = System.getProperty("user.home") + "\\Desktop";
        String folderPath = desktopPath + "\\pdf";

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String filePath = folderPath + "\\query_results.pdf";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        pdfStream.writeTo(fileOutputStream);
        fileOutputStream.close();

        System.out.println("PDF sačuvan na: " + filePath);
    }

    private ByteArrayOutputStream generatePdfForKlub(Klub klub) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Paragraph paragraph = new Paragraph("Klub Details", boldFont);
        document.add(paragraph);
        document.add(new Paragraph("Name: " + klub.getNaziv()));
        document.add(new Paragraph("Location: " + klub.getAdresa()));
        document.add(new Paragraph("Phone Number: " + klub.getTelefon()));
        document.add(new Paragraph("PIB: " + klub.getPIB()));

        document.close();
        return outputStream;
    }

    public List<Klub> findByStatus(){
        return klubRepository.findByStatus();
    }

    public ResponseEntity<Klub> updateStatus(Long id){
        return klubRepository.updateKlubStatus(id);
    }
}
