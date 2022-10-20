package modele;

import java.util.Set;
import java.util.HashSet;
import modele.Cage;

public class Gardien extends Employe {

  private Set Cages = new HashSet();

  private Set Specialites = new HashSet();

  public Set getCages() {
    return Cages;
  }

  public void setCages(Set S) {
    Cages = S;
  }

  public Set getSpecialites() {
    return Specialites;
  }

  public void setSpecialites(Set S) {
    Specialites = S;
  }

  public void addCage(Cage c) {
    Cages.add(c);
    if (!c.getGardiens().contains(this)) {
      c.addGardien(this);
    }
  }

  public void addSpecialites(String s) {
    Specialites.add(s);
  }

}
