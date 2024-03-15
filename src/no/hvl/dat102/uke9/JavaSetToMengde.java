package no.hvl.dat102.uke9;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {

  private final static int DEFAULT_CAPACITY = 3;
  private Set<T> mengde;

  public JavaSetToMengde() { this(DEFAULT_CAPACITY); }

  public JavaSetToMengde(int start) { mengde = new HashSet<T>(); }

  @Override
  public int antall() {
    return mengde.size();
  }

  @Override
  public void leggTil(T element) {
    mengde.add(element);
  }

  @Override
  public T fjern(T element) {
    if (mengde.contains(element)) {
      mengde.remove(element);
      return element;
    }
    return null;
  }

  @Override
  public boolean erTom() {
    return mengde.isEmpty();
  }

  @Override
  public boolean inneholder(T element) {
    return mengde.contains(element);
  }

  @Override
  public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
    for (T element : mengde) {
      if (!annenMengde.inneholder(element)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean erLik(MengdeADT<T> annenMengde) {
    if (mengde.size() != annenMengde.antall()) {
      return false;
    }
    for (T element : mengde) {
      if (!annenMengde.inneholder(element)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean erDisjunkte(MengdeADT<T> annenMengde) {
    for (T element : mengde) {
      if (annenMengde.inneholder(element)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public MengdeADT<T> snittet(MengdeADT<T> annenMengde) {
    MengdeADT<T> snitt = new JavaSetToMengde<T>();
    for (T element : mengde) {
      if (annenMengde.inneholder(element)) {
        snitt.leggTil(element);
      }
    }
    return snitt;
  }

  @Override
  public MengdeADT<T> union(MengdeADT<T> annenMengde) {
    MengdeADT<T> union = new JavaSetToMengde<T>();
    for (T element : mengde) {
      union.leggTil(element);
    }
    for (T element : ((JavaSetToMengde<T>)annenMengde).mengde) {
      union.leggTil(element);
    }
    return union;
  }

  @Override
  public MengdeADT<T> differens(MengdeADT<T> annenMengde) {
    MengdeADT<T> differens = new JavaSetToMengde<T>();
    for (T element : mengde) {
      if (!annenMengde.inneholder(element)) {
        differens.leggTil(element);
      }
    }
    return differens;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T[] toArray() {
    if (erTom())
      return null;

    T[] tab = (T[]) new Object[mengde.size()];
    int i = 0;
    for (T element : mengde) {
      tab[i] = element;
      i++;
    }

    return tab;
  }
}
