package back.saebackend.service;

// On change "com.example" par "back" pour correspondre à TES dossiers
import back.saebackend.model.Sae;
import back.saebackend.repository.SaeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaeService {

    @Autowired
    private SaeRepository repository;

    // Récupérer et trier par note (Exigence du sujet)
    public List<Sae> getAllSaesSorted() {
        return repository.findAll().stream()
                .sorted((s1, s2) -> s2.getNote().compareTo(s1.getNote()))
                .collect(Collectors.toList());
    }

    // Sauvegarder une nouvelle SAÉ (Historisation)
    public Sae saveSae(Sae sae) {
        return repository.save(sae);
    }
}