package no.hvl.dat102.uke9;

public class LenketMengde<T> implements MengdeADT<T> {

  private class Node {
    T data;
    Node neste;
  }

  private Node forste;
  private int antall;

  public LenketMengde() {
    forste = null;
    antall = 0;
  }

  @Override
  public int antall() {
    return antall;
  }

  @Override
  public void leggTil(T element) {
    if (!inneholder(element)) {
      Node nyNode = new Node();
      nyNode.data = element;
      nyNode.neste = forste;
      forste = nyNode;
      antall++;
    }
  }

  @Override
  public T fjern(T element) {
    Node forrige = null;
    Node denne = forste;
    T resultat = null;
    while (denne != null && resultat == null) {
      if (denne.data.equals(element)) {
        resultat = denne.data;
        if (forrige == null) {
          forste = forste.neste;
        } else {
          forrige.neste = denne.neste;
        }
        antall--;
      } else {
        forrige = denne;
        denne = denne.neste;
      }
    }
    return resultat;
  }

  @Override
  public boolean erTom() {
    return antall == 0;
  }

  @Override
  public boolean inneholder(T element) {
    Node denne = forste;
    boolean resultat = false;
    while (denne != null && !resultat) {
      if (denne.data.equals(element)) {
        resultat = true;
      } else {
        denne = denne.neste;
      }
    }
    return resultat;
  }

  @Override
  public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
    boolean resultat = true;
    Node denne = forste;
    while (denne != null && resultat) {
      if (!annenMengde.inneholder(denne.data)) {
        resultat = false;
      } else {
        denne = denne.neste;
      }
    }
    return resultat;
  }

  @Override
  public boolean erLik(MengdeADT<T> annenMengde) {
    return erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
  }

  @Override
  public boolean erDisjunkte(MengdeADT<T> annenMengde) {
    Node denne = forste;
    boolean resultat = true;
    while (denne != null && resultat) {
      if (annenMengde.inneholder(denne.data)) {
        resultat = false;
      } else {
        denne = denne.neste;
      }
    }
    return resultat;
  }

  @Override
  public MengdeADT<T> snittet(MengdeADT<T> annenMengde) {
    MengdeADT<T> snitt = new LenketMengde<T>();
    Node denne = forste;
    while (denne != null) {
      if (annenMengde.inneholder(denne.data)) {
        snitt.leggTil(denne.data);
      }
      denne = denne.neste;
    }
    return snitt;
  }

  @Override
  public MengdeADT<T> union(MengdeADT<T> annenMengde) {
    MengdeADT<T> union = new LenketMengde<T>();
    Node denne = forste;
    while (denne != null) {
      union.leggTil(denne.data);
      denne = denne.neste;
    }
    Node denne2 = ((LenketMengde<T>)annenMengde).forste;
    while (denne2 != null) {
      union.leggTil(denne2.data);
      denne2 = denne2.neste;
    }
    return union;
  }

  @Override
  public MengdeADT<T> differens(MengdeADT<T> annenMengde) {
    MengdeADT<T> differens = new LenketMengde<T>();
    Node denne = forste;
    while (denne != null) {
      if (!annenMengde.inneholder(denne.data)) {
        differens.leggTil(denne.data);
      }
      denne = denne.neste;
    }
    return differens;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T[] toArray() {
    T[] tab = (T[]) new Object[antall];
    Node denne = forste;
    int i = 0;

    while (denne != null) {
      tab[i] = denne.data;
      i++;
      denne = denne.neste;
    }

    return tab;
  }
}
