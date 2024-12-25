package ma.ensa.profile_section.models;

public class User {
    private int id;
    private String nom;
    private String email;
    private String hashedPassword;
    private String numero;

    // Constructeurs
    public User() {
    }

    public User(int id, String nom, String email, String hashedPassword, String numero) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.numero = numero;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Méthode toString (optionnelle pour le débogage)
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
