package modele;

public class Carte {
    String nomCarteAbonnement;
    String adresseMailClient;
    int soldeCarteAbonnement;
    int agePropietaireCarteAbonnement;

    // Nom Carte
    public String getnomCarteAbonnement() {
        return nomCarteAbonnement;
    }

    public void setnomCarteAbonnement(String n) {
        nomCarteAbonnement = n;
    }

    // Mail Carte
    public String getadresseMailClient() {
        return adresseMailClient;
    }

    public void setadresseMailClient(String n) {
        adresseMailClient = n;
    }

    // Solde Carte
    public int getsoldeCarteAbonnement() {
        return soldeCarteAbonnement;
    }

    public void setsoldeCarteAbonnement(int n) {
        soldeCarteAbonnement = n;
    }

    // Age Carte
    public int getagePropietaireCarteAbonnement() {
        return agePropietaireCarteAbonnement;
    }

    public void setagePropietaireCarteAbonnement(int n) {
        agePropietaireCarteAbonnement = n;
    }
}
