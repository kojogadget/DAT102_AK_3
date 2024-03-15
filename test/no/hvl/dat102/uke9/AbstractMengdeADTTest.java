package no.hvl.dat102.uke9;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class AbstractMengdeADTTest {
  private MengdeADT<Integer> mengde1;
  private MengdeADT<Integer> mengde2;
  private MengdeADT<Integer> mengde3;
  private MengdeADT<Integer> mengde4;

  abstract MengdeADT<Integer> opprettMengde();

  @BeforeEach
  void nullstill() {
    mengde1 = opprettMengde();

    mengde2 = opprettMengde();
    mengde2.leggTil(1);
    mengde2.leggTil(2);

    mengde3 = opprettMengde();
    mengde3.leggTil(1);
    mengde3.leggTil(2);
    mengde3.leggTil(3);

    mengde4 = opprettMengde();
    mengde4.leggTil(5);
    mengde4.leggTil(6);
    mengde4.leggTil(7);
  }

  @Test
  void testErTom() {
    assertTrue(mengde1.erTom());
    assertFalse(mengde2.erTom());
    assertFalse(mengde3.erTom());
  }

  @Test
  void testInneholder() {
    assertFalse(mengde1.inneholder(1));
    assertTrue(mengde2.inneholder(1));
    assertFalse(mengde2.inneholder(3));
    assertTrue(mengde3.inneholder(2));
    assertTrue(mengde3.inneholder(3));
    assertFalse(mengde3.inneholder(4));
  }

  @Test
  void testLeggTil() {
    assertTrue(mengde1.erTom());
    assertFalse(mengde1.inneholder(1));
    mengde1.leggTil(1);
    assertFalse(mengde1.erTom());
    assertTrue(mengde1.inneholder(1));
    mengde1.leggTil(2);
    assertTrue(mengde1.inneholder(2));
    mengde3.leggTil(1);
    assertTrue(mengde3.inneholder(1));
  }

  @Test
  void testFjern() {
    assertFalse(mengde1.inneholder(1));
    mengde1.leggTil(1);
    assertTrue(mengde1.inneholder(1));
    mengde1.fjern(1);
    assertFalse(mengde1.inneholder(1));
  }

  @Test
  void testErDelmengdeAv() {
    assertTrue(mengde1.erDelmengdeAv(mengde1));
    assertTrue(mengde1.erDelmengdeAv(mengde2));
    assertTrue(mengde1.erDelmengdeAv(mengde3));
    assertFalse(mengde2.erDelmengdeAv(mengde1));
    assertTrue(mengde2.erDelmengdeAv(mengde2));
    assertTrue(mengde2.erDelmengdeAv(mengde3));
    assertFalse(mengde3.erDelmengdeAv(mengde1));
    assertFalse(mengde3.erDelmengdeAv(mengde2));
    assertTrue(mengde3.erDelmengdeAv(mengde3));
  }

  @Test
  void testErLik() {
    assertTrue(mengde1.erLik(mengde1));
    assertFalse(mengde1.erLik(mengde2));
    assertFalse(mengde1.erLik(mengde3));
    assertFalse(mengde2.erLik(mengde1));
    assertTrue(mengde2.erLik(mengde2));
    assertFalse(mengde2.erLik(mengde3));
    assertFalse(mengde3.erLik(mengde1));
    assertFalse(mengde3.erLik(mengde2));
    assertTrue(mengde3.erLik(mengde3));
  }

  @Test
  void testErDisjunkte() {
    assertTrue(mengde1.erDisjunkte(mengde1));
    assertTrue(mengde1.erDisjunkte(mengde2));
    assertTrue(mengde1.erDisjunkte(mengde3));
    assertTrue(mengde2.erDisjunkte(mengde1));
    assertFalse(mengde2.erDisjunkte(mengde2));
    assertFalse(mengde2.erDisjunkte(mengde3));
    assertTrue(mengde3.erDisjunkte(mengde1));
    assertFalse(mengde3.erDisjunkte(mengde2));
    assertFalse(mengde3.erDisjunkte(mengde3));
    assertTrue(mengde2.erDisjunkte(mengde4));
  }

  @Test
  void testSnittet() {
    MengdeADT<Integer> snitt = mengde2.snittet(mengde3);
    assertTrue(snitt.inneholder(1));
    assertTrue(snitt.inneholder(2));
    assertFalse(snitt.inneholder(3));
  }

  @Test
  void testUnion() {
    MengdeADT<Integer> union1 = mengde2.union(mengde3);
    MengdeADT<Integer> union2 = mengde2.union(mengde4);

    assertTrue(union1.inneholder(1));
    assertTrue(union1.inneholder(2));
    assertTrue(union1.inneholder(3));
    assertFalse(union1.inneholder(4));

    assertTrue(union2.inneholder(1));
    assertTrue(union2.inneholder(2));
    assertFalse(union2.inneholder(3));
    assertFalse(union2.inneholder(4));
    assertTrue(union2.inneholder(5));
    assertTrue(union2.inneholder(6));
    assertTrue(union2.inneholder(7));
  }

  @Test
  void testDifferens() {
    MengdeADT<Integer> differens1 = mengde2.differens(mengde3);
    MengdeADT<Integer> differens2 = mengde3.differens(mengde2);

    assertFalse(differens1.inneholder(1));
    assertFalse(differens1.inneholder(2));
    assertFalse(differens1.inneholder(3));
    assertFalse(differens1.inneholder(4));

    assertFalse(differens2.inneholder(1));
    assertFalse(differens2.inneholder(2));
    assertTrue(differens2.inneholder(3));
    assertFalse(differens2.inneholder(4));
  }
}
