package modele;

import java.util.Set;
import java.util.HashSet;
import modele.Gardien;

public class Cage {
  private int NoCage;
  private String Fonction;
  private long NoAlle;
  private Set Gardiens = new HashSet();

  public int getNoCage() {
    return NoCage;
  }

  public void setNoCage(int c) {
    NoCage = c;
  }

  public String getFonction() {
    return Fonction;
  }

  public void setFonction(String f) {
    Fonction = f;
  }

  public long getNoAlle() {
    return NoAlle;
  }

  public void setNoAlle(long n) {
    NoAlle = n;
  }

  public Set getGardiens() {
    return Gardiens;
  }

  public void setGardiens(Set S) {
    Gardiens = S;
  }

  public void addGardien(Gardien g) {
    Gardiens.add(g);
  }

}
