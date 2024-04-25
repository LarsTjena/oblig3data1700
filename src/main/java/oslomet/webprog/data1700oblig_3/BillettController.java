package oslomet.webprog.data1700oblig_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BillettController {

    @Autowired
    private BillettRepo rep;

    @PostMapping("leggtil")
    public void leggTilBilletter(String film, int antall, String fornavn, String etternavn, String telefon, String epost) {
        Billett innBillett = new Billett(film, antall, fornavn, etternavn, telefon, epost);
        rep.lagreBillett(innBillett);
    }

    @DeleteMapping("slettalt")
    public void slettBilletter() {
        rep.slettAlleBilletter();
    }

    @GetMapping("hent")
    public List<Billett> hentBilletter() {
        return rep.hentAlleBilletter();
    }
}