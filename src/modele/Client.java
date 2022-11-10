package modele;

import java.util.Set;
import java.util.HashSet;

public class Client extends Employe {

  private Set FilmsLoues = new HashSet();

  private Set CarteAbo = new HashSet();

  private int nbCartes;

  public void addFilm(Film f) {
    FilmsLoues.add(f);
  }

  public Set getFilmsLoues() {
    return FilmsLoues;
  }

  public void addCarte(Carte c) {
    CarteAbo.add(c);
  }

  public Set getCarteAbo() {
    return CarteAbo;
  }

  public int getnbCarte(){
    return nbCartes;
  }

  public void setnbCarte(int n){
    nbCartes = n;
  }
}
