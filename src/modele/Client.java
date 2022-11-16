package modele;

import java.util.Set;
import java.util.HashSet;

/***********************************/
/************** CLIENT *************/
/***********************************/
public class Client {

  private Set FilmsLoues = new HashSet();
  private Set CarteAbo = new HashSet();
  private Set Wish = new HashSet();
  private int nbCartes;
  private int nbWish;

  // Ajout Film
  public void addFilm(Film f) {
    FilmsLoues.add(f);
  }

  // Film Louées
  public Set getFilmsLoues() {
    return FilmsLoues;
  }

  // Carte
  public void addCarte(Carte c) {
    CarteAbo.add(c);
  }

  // Carte Abonnées
  public Set getCarteAbo() {
    return CarteAbo;
  }

  // Nombre Carte
  public int getnbCarte(){
    return nbCartes;
  }

  public void setnbCarte(int n){
    nbCartes = n;
  }

  // Liste de souhait
  public void addWish(Film f) {
    Wish.add(f);
  }

  public Set getWish() {
    return Wish;
  }

  public int getnbWish(){
    return nbWish;
  }

  public void setnbWish(int n){
    nbWish = n;
  }
}
