package back.saebackend.repository;

// On corrige l'import ici :
import back.saebackend.model.Sae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaeRepository extends JpaRepository<Sae, Long> {
    // La magie de Spring peut enfin opérer !
}