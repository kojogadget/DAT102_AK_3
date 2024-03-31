package no.hvl.dat102.uke10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SokingMain {
    public static void main(String[] args) {
        int antElement = 100_000;
        int antSokTall = 10_000;
        int tall = 376;

        Integer[] tab = new Integer[antElement];
        Set<Integer> sett = new HashSet<>(antElement);

        Integer[] sokTall = new Integer[antSokTall];
        Random random = new Random();
        for (int i = 0; i < antSokTall; i++) {
            sokTall[i] = random.nextInt(1_000_000);
        }

        for (int i = 0; i < antElement; i++) {
            // legg tall til i HashSet og i tabell
            tall = (tall + 45713) % 1_000_000;
            tab[i] = tall;
            sett.add(tall);
        }

        Arrays.sort(tab);

        long startTid = System.currentTimeMillis();
        int antFunnetHash = 0;
        for (Integer sok : sokTall) {
            if (sett.contains(sok)) {
                antFunnetHash++;
            }
        }
        long sluttTid = System.currentTimeMillis();
        long tidHash = sluttTid - startTid;

        startTid = System.currentTimeMillis();
        int antFunnetBin = 0;
        for (Integer sok : sokTall) {
            if (Arrays.binarySearch(tab, sok) >= 0) {
                antFunnetBin++;
            }
        }
        sluttTid = System.currentTimeMillis();
        long tidBin = sluttTid - startTid;

        System.out.println("Antall funnet med HashSet: " + antFunnetHash + " tid: " + tidHash);
        System.out.println("Antall funnet med binærsøk: " + antFunnetBin + " tid: " + tidBin);
    }
}
