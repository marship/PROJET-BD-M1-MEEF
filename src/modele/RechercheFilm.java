package modele;

import java.util.Set;
import java.util.HashSet;

public class RechercheFilm {

  private Set listFilm = new HashSet();

  public void addFilm(Film f) {
    listFilm.add(f);
  }

  public Set getFilms() {
    return listFilm;
  }
}
