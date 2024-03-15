package no.hvl.dat102.uke9;

class LenketMengdeTest extends AbstractMengdeADTTest {

  @Override
  MengdeADT<Integer> opprettMengde() {
    return new LenketMengde<Integer>();
  }
}
