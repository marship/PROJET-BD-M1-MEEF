package modele;

import java.util.HashSet;
import java.util.Set;

/***********************************/
/*************** FILM **************/
/***********************************/
public class Film {

    private String nomFilm;
    private String resumeFilm;
    private String dateSortieFilm;
    private String dureeFilm;
    private int nombreExemplaireFilm;
    private int limiteAgeFilm;
    private String dateAjoutFilm;
    private int nombreTotalLocationFilm;
    private String NomPrenomRealisateur;

    private Set listeGenre = new HashSet();
    private Set listeActeur = new HashSet();

    // Nom Film
    public String getnomFilm() {
        return nomFilm;
    }

    public void setnomFilm(String n) {
        nomFilm = n;
    }

    // Resumé Film
    public String getresumeFilm() {
        return resumeFilm;
    }

    public void setresumeFilm(String n) {
        resumeFilm = n;
    }

    // Date Sortie du Film
    public String getdateSortieFilm() {
        return dateSortieFilm;
    }

    public void setdateSortieFilm(String d) {
        dateSortieFilm = d;
    }

    // Durée du Film
    public String getdureeFilm() {
        return dureeFilm;
    }

    public void setdureeFilm(String d) {
        dureeFilm = d;
    }

    // Mombre d'Exemplaire du Film
    public int getnombreExemplaireFilm() {
        return nombreExemplaireFilm;
    }

    public void setnombreExemplaireFilm(int n) {
        nombreExemplaireFilm = n;
    }

    // Limite d'Age du Film
    public int getlimiteAgeFilm() {
        return limiteAgeFilm;
    }

    public void setlimiteAgeFilm(int l) {
        limiteAgeFilm = l;
    }

    // Date d'Ajout du Film
    public String getdateAjoutFilm() {
        return dateAjoutFilm;
    }

    public void setdateAjoutFilm(String d) {
        dateAjoutFilm = d;
    }

    // Nombre Total de Location du Film
    public int getnombreTotalLocationFilm() {
        return nombreTotalLocationFilm;
    }

    public void setnombreTotalLocationFilm(int d) {
        nombreTotalLocationFilm = d;
    }

    // Nom Du réalisateur
    public String getNomPrenomRealisateur() {
        return NomPrenomRealisateur;
    }

    public void setNomPrenomRealisateur(String n) {
        NomPrenomRealisateur = n;
    }

    // Genre
    public void addGenre(Genre g) {
        listeGenre.add(g);
    }

    public Set getGenre() {
        return listeGenre;
    }

    // Acteur
    public void addActeur(Personne p) {
        listeActeur.add(p);
    }

    public Set getActeur() {
        return listeActeur;
    }

}
