package modele;

import java.util.Set;
import java.util.HashSet;

/***********************************/
/********** RECHERCHE FILM *********/
/***********************************/
public class RechercheFilm {

  private Set listFilm = new HashSet();
  private Set listeGenre = new HashSet();
  private Set listeActeur = new HashSet();
  private Set listeRealisateur = new HashSet();
  private int nbFilm;
  private int nbGenre;
  private int nbActeur;
  private int nbRealisateur;

  // Film
  public void addFilm(Film f) {
    listFilm.add(f);
  }

  public Set getFilms() {
    return listFilm;
  }

  public void setNbFilm(int n){
    nbFilm = n;
  }

  public int getnbFilm(){
    return nbFilm;
  }

  // Genre
  public void addGenre(Genre g) {
    listeGenre.add(g);
  }

  public Set getGenre() {
    return listeGenre;
  }

  public void setnbGenre(int n){
    nbGenre = n;
  }

  public int getnbGenre(){
    return nbGenre;
  }

  // Acteur
  public void addActeur(Personne p) {
    listeActeur.add(p);
  }

  public Set getActeur() {
    return listeActeur;
  }

  public void setnbActeur(int n){
    nbActeur = n;
  }

  public int getnbActeur(){
    return nbActeur;
  }

  // Réalisateur
  public void addRealisateur(Personne p) {
    listeRealisateur.add(p);
  }

  public Set getRealisateur() {
    return listeRealisateur;
  }

  public void setnbRealisateur(int n){
    nbRealisateur = n;
  }

  public int getnbRealisateur(){
    return nbRealisateur;
  }

}
