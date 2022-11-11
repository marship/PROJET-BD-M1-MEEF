package modele;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Film {
    private String nomFilm;
    private String resumeFilm;
    private Date dateSortieFilm;
    private Date dureeFilm;
    private int nombreExemplaireFilm;
    private int limiteAgeFilm;
    private Date dateAjoutFilm;
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
    public Date getdateSortieFilm() {
        return dateSortieFilm;
    }

    public void setdateSortieFilm(Date d) {
        dateSortieFilm = d;
    }

    // Durée du Film
    public Date getdureeFilm() {
        return dureeFilm;
    }

    public void setdureeFilm(Date d) {
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
    public Date getdateAjoutFilm() {
        return dateAjoutFilm;
    }

    public void setdateAjoutFilm(Date d) {
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

    public void addGenre(Genre g) {
        listeGenre.add(g);
    }

    public Set getGenre() {
        return listeGenre;
    }

    public void addActeur(Personne p) {
        listeActeur.add(p);
    }

    public Set getActeur() {
        return listeActeur;
    }

}
