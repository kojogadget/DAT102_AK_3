package no.hvl.dat102.uke9;

class TabellMengdeTest extends AbstractMengdeADTTest {

  @Override
  MengdeADT<Integer> opprettMengde() {
    return new TabellMengde<Integer>();
  }
}
