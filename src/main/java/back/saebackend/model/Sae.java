package back.saebackend.model;
import jakarta.persistence.*;

@Entity
public class Sae {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String promo;
    private String domaine;
    private String semestre;
    private String ue;
    private Double note;
    private Integer tauxReussite;

    @Column(length = 1000)
    private String competences;

    private String ressourcesHumaines;
    private String dateDebut;
    private String dateFin;
    private String lienSite;
    private String lienCode;
    private String image;

    // --- CONSTRUCTEURS ---
    public Sae() {} // Indispensable pour JPA

    // --- GETTERS & SETTERS ---
    // (Astuce IntelliJ : Clique-droit > Generate > Getter and Setter > Tout sélectionner)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getPromo() { return promo; }
    public void setPromo(String promo) { this.promo = promo; }

    public String getDomaine() { return domaine; }
    public void setDomaine(String domaine) { this.domaine = domaine; }

    public String getSemestre() { return semestre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }

    public String getUe() { return ue; }
    public void setUe(String ue) { this.ue = ue; }

    public Double getNote() { return note; }
    public void setNote(Double note) { this.note = note; }

    public Integer getTauxReussite() { return tauxReussite; }
    public void setTauxReussite(Integer tauxReussite) { this.tauxReussite = tauxReussite; }

    public String getCompetences() { return competences; }
    public void setCompetences(String competences) { this.competences = competences; }

    public String getRessourcesHumaines() { return ressourcesHumaines; }
    public void setRessourcesHumaines(String ressourcesHumaines) { this.ressourcesHumaines = ressourcesHumaines; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getDateDebut() { return dateDebut; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }

    public String getDateFin() { return dateFin; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }

    public String getLienSite() { return lienSite; }
    public void setLienSite(String lienSite) { this.lienSite = lienSite; }

    public String getLienCode() { return lienCode; }
    public void setLienCode(String lienCode) { this.lienCode = lienCode; }

}