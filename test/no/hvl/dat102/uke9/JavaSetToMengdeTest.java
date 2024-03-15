package no.hvl.dat102.uke9;

class JavaSetToMengdeTest extends AbstractMengdeADTTest {

  @Override
  MengdeADT<Integer> opprettMengde() {
    return new JavaSetToMengde<Integer>();
  }
}
