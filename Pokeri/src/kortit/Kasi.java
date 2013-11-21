/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import java.util.*;

public class Kasi {

    private ArrayList<Kortti> käsi;

    /**
     * Luodaan uusi arraylist kädessä oleville korteille
     *
     */
    public Kasi() {
        this.käsi = new ArrayList<>();
    }

    /**
     * Poistaa lukitukset kädestä uuden pelin aloittamista varten
     *
     */
    public void nollaus() {
        for (Kortti k:this.käsi){
            k.avaa();
        }
    }

    /**
     * Lisää jakajan jakaman kortin käteen
     *
     * @param Kortti Kortti, jonka jakaja on antanut
     */
    public void otaKateen(Kortti kortti) {
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
        this.käsi.remove(this.käsi.get(i));
    }

    /**
     * Lukitaan Kortti, jotta sitä ei voi sekoittaa takaisin pakkaan uusia
     * korttia jaettaessa.
     *
     * @param i lukittavan kortin indeksi. varmistetaan, ettei ole yli 4
     */
    public void lukitseKortti(int i) {
        if (i > 4) {
            return;
        }
        this.käsi.get(i).lukitse();
    }
    
    /**
     * Poistetaan kortin lukitus.
     * @param i sen kortin paikka (indeksi) kädessä, jonka lukitus halutaan poistaa
     */
    public void avaaKortti(int i) {
        if (i > 4){
            return;
        }
        this.käsi.get(i).avaa();
    }

    /**
     * Antaa listan kädessä olevista korteista.
     *
     * @return kädessä olevien korttien lista
     */
    public ArrayList<Kortti> listaaKortit() {
        return this.käsi;
    }
    
    /**
     * palauttaa kädessä indeksissä i sijaitsevan kortin
     * @param i sen kortin indeksi, joka halutaan näyttää
     * @return kortti, joka sijaitsee käden indeksissä i
     */
    
    public Kortti katsoKortti(int i){
        return this.käsi.get(i);
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

        for (Kortti k : this.käsi) {
            ilmoitus = ilmoitus + (k.toString() + " ");
        }

        return ilmoitus;
    }
}
