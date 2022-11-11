package modele;

public class Personne {
    String nomPersonne;
    String dateNaissance;
    String nationalite;

    // Nom Personne
    public String getnomPersonne() {
        return nomPersonne;
    }

    public void setnomPersonne(String n) {
        nomPersonne = n;
    }

    // Date de naissance
    public String getdateNaissance() {
        return dateNaissance;
    }

    public void setdateNaissance(String n) {
        dateNaissance = n;
    }

    // Nationalité
    public String getnationalite() {
        return nationalite;
    }

    public void setnationalite(String n) {
        nationalite = n;
    }
}
