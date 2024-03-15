package no.hvl.dat102.uke9;

public interface MengdeADT<T> {

  /**
   * Finn antall elementer i mengden.
   *
   * @return antall elementer i mengden
   */
  public int antall();

  /**
   * Legger til et element i mengden.
   *
   * @param element elementet som skal legges til
   */
  public void leggTil(T element);

  /**
   * Fjerner et element fra mengden.
   *
   * @param element elementet som skal fjernes
   * @return elementet som ble fjernet
   */
  public T fjern(T element);

  /**
   * Sjekker om mengden er tom.
   *
   * @return true hvis mengden er tom
   */
  public boolean erTom();

  /**
   * Sjekker om elementet finnes i mengden.
   *
   * @param element elementet som skal sjekkes
   * @return true dersom elementet finnes i mengden.
   */
  public boolean inneholder(T element);

  /**
   * Sjekker om mengden er en delmengde av en annen mengde.
   *
   * @param annenMengde mengden som skal sjekkes
   * @return true dersom mengden er en delmengde av en annen mengde
   */
  public boolean erDelmengdeAv(MengdeADT<T> annenMengde);

  /**
   * Sjekker om mengden er lik en annen mengde.
   *
   * @param annenMengde mengden som skal sjekkes
   * @return true dersom mengdene er like
   */
  public boolean erLik(MengdeADT<T> annenMengde);

  /**
   * Sjekker om to mengder er disjunkte, dvs. de har ingen felles elementer.
   *
   * @param annenMengde mengden som skal sjekkes
   * @return true dersom mengdene er disjunkte
   */
  public boolean erDisjunkte(MengdeADT<T> annenMengde);

  /**
   * Finn snittet av to mengder, dvs. de elementene som finnes i begge mengdene.
   *
   * @param annenMengde mengden som skal finnes snittet med
   * @return ny mengde som inneholder snittet av to mengder
   */
  public MengdeADT<T> snittet(MengdeADT<T> annenMengde);

  /**
   * Finn unionen av to mengder, dvs. alle elementene som finnes i en eller
   * begge mengdene. Legger til alle elementene i en annen mengde, uten
   * duplikater.
   *
   * @param annenMengde mengden som skal finnes unionen med
   * @return ny mengde som inneholder unionen av to mengder
   */
  public MengdeADT<T> union(MengdeADT<T> annenMengde);

  /**
   * Finn differensen av to mengder, dvs. de elementene som finnes i den
   * første mengden men ikke den andre
   *
   * @param annenMengde mengden som skal finnes differensen med
   * @return ny mengde som inneholder differensen av to mengder
   */
  public MengdeADT<T> differens(MengdeADT<T> annenMengde);

  /**
   * Returnerer en tabell for mengden.
   *
   * @return en tabell for mengden
   */
  public T[] toArray();
}
