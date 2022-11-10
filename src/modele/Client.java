package modele;

import java.util.Set;
import java.util.HashSet;

public class Client extends Employe {

  private Set FilmsLoues = new HashSet();

  public void addFilm(Film f) {
    FilmsLoues.add(f);
  }

  public Set getFilmsLoues() {
    return FilmsLoues;
  }
}
