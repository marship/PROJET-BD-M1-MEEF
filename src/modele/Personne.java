package modele;

/***********************************/
/************* PERSONNE ************/
/***********************************/
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

    // Nationalit√©
    public String getnationalite() {
        return nationalite;
    }

    public void setnationalite(String n) {
        nationalite = n;
    }
}
