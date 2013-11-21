/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import java.util.*;

public class kasi {

    private ArrayList<kortti> käsi;
    private boolean[] lukitut;

    /**
     * Luodaan uusi arraylist kädessä oleville korteille, ja viisipaikkainen
     * boolean-jono kortin lukituksen merkitsemistä varten.
     *
     */
    public kasi() {
        this.käsi = new ArrayList<>();
        this.lukitut = new boolean[5];
    }

    /**
     * Poistaa lukitukset kädestä uuden pelin aloittamista varten
     *
     */
    public void nollaus() {
        for (boolean b : this.lukitut) {
            b = false;
        }
    }

    /**
     * Lisää jakajan jakaman kortin käteen
     *
     * @param kortti kortti, jonka jakaja on antanut
     */
    public void otaKateen(kortti kortti) {
        if (this.käsi.size() > 4) {
            return;
        }
        this.käsi.add(kortti);
    }

    /**
     * Poistaa kädestä pois otetun kortin käden arrayListista
     *
     * @param i sen kortin numero (indeksi listassa), joka halutaan poistaa
     */
    public void poistaKadesta(int i) {
        käsi.remove(käsi.get(i));
    }

    /**
     * Lukitaan kortti, jotta sitä ei voi sekoittaa takaisin pakkaan uusia
     * korttia jaettaessa.
     *
     * @param i lukittavan kortin indeksi. varmistetaan, ettei ole yli 4
     */
    public void lukitseKortti(int i) {
        if (i > 4) {
            return;
        }
        lukitut[i] = true;
    }

    /**
     * Antaa listan kädessä olevista korteista.
     *
     * @return kädessä olevien korttien lista
     */
    public ArrayList<kortti> listaaKortit() {
        return this.käsi;
    }
    
    public kortti katsoKortti(int i){
        return käsi.get(i);
    }

    /**
     * Hakee kädessä olevien korttien toString-metodien tekstipalautukset ja
     * koostaa niistä listan kädessä olevista korteista.
     *
     * @return lista kädessä olevista korteista
     */
    @Override
    public String toString() {

        String ilmoitus = "";

        for (kortti k : this.käsi) {
            ilmoitus = ilmoitus + (k.toString() + " ");
        }

        return ilmoitus;
    }
}
