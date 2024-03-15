package no.hvl.dat102.uke9;

public class TabellMengde<T> implements MengdeADT<T> {

  private final static int DEFAULT_CAPACITY = 3;
  private int antall;
  private T[] tab;

  public TabellMengde() { this(DEFAULT_CAPACITY); }

  @SuppressWarnings("unchecked")
  public TabellMengde(int start) {
    antall = 0;
    tab = (T[])(new Object[start]);
  }

  @Override
  public int antall() {
    return antall;
  }

  @Override
  public void leggTil(T element) {
    if (inneholder(element)) {
      return;
    }

    sjekkKapasitet();
    tab[antall] = element;
    antall++;
  }

  @Override
  public T fjern(T element) {
    T temp = null;
    int i = 0;
    while (i < antall && temp == null) {
      if (tab[i].equals(element)) {
        temp = tab[i];
      } else {
        i++;
      }
    }

    if (temp != null) {
      antall--;
      tab[i] = tab[antall];
      tab[antall] = null;
    }

    return temp;
  }

  @Override
  public boolean erTom() {
    return antall == 0;
  }

  @Override
  public boolean inneholder(T element) {
    for (int i = 0; i < antall; i++) {
      if (tab[i].equals(element)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
    for (int i = 0; i < antall; i++) {
      if (!annenMengde.inneholder(tab[i])) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean erLik(MengdeADT<T> annenMengde) {
    return erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
  }

  @Override
  public boolean erDisjunkte(MengdeADT<T> annenMengde) {
    for (int i = 0; i < antall; i++) {
      if (annenMengde.inneholder(tab[i])) {
        return false;
      }
    }
    return true;
  }

  @Override
  public MengdeADT<T> snittet(MengdeADT<T> annenMengde) {
    MengdeADT<T> snitt = new TabellMengde<T>();
    for (int i = 0; i < antall; i++) {
      if (annenMengde.inneholder(tab[i])) {
        snitt.leggTil(tab[i]);
      }
    }

    return snitt;
  }

  @Override
  public MengdeADT<T> union(MengdeADT<T> annenMengde) {
    MengdeADT<T> union = new TabellMengde<T>();
    for (int i = 0; i < antall; i++) {
      union.leggTil(tab[i]);
    }

    T[] tab2 = annenMengde.toArray();

    for (T element : tab2) {
      union.leggTil(element);
    }

    return union;
  }

  @Override
  public MengdeADT<T> differens(MengdeADT<T> annenMengde) {
    MengdeADT<T> differens = new TabellMengde<T>();
    for (int i = 0; i < antall; i++) {
      if (!annenMengde.inneholder(tab[i])) {
        differens.leggTil(tab[i]);
      }
    }

    return differens;
  }

  @Override
  public T[] toArray() {
    return tab;
  }

  @SuppressWarnings("unchecked")
  private void sjekkKapasitet() {
    if (antall == tab.length) {
      T[] tempTab = (T[])(new Object[2 * tab.length]);
      for (int i = 0; i < antall; i++) {
        tempTab[i] = tab[i];
      }
      tab = tempTab;
    }
  }
}
