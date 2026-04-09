package back.saebackend.service;
import back.saebackend.model.Sae;
import back.saebackend.repository.SaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private SaeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            Sae demo = new Sae();
            demo.setTitre("Application JPO");
            demo.setPromo("MMI3");
            demo.setDomaine("Développement");
            demo.setNote(18.0);
            demo.setUe("R6.03");
            demo.setImage("https://picsum.photos/400/200");

            repository.save(demo);
            System.out.println("Données de test chargées pour le prof !");
        }
    }
}