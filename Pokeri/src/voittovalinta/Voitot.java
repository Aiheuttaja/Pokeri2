/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voittovalinta;

import java.util.ArrayList;
import java.util.Collections;
import kortit.Kasi;
import kortit.Kortti;

/**
 *
 * @author jilli
 */
public class Voitot {

    private double panos;
    private double viimeisinVoitto;
    private double voitot;

    public Voitot() {
        this.panos = 0.2;
        this.viimeisinVoitto = 0.0;
        this.voitot = 0.0;
    }

    /**
     * Luokan päämetodi, jossa käydään systemaattisesti läpi mahdolliset voitot
     * epätodennäköisimmästä todennäköisimpään ja katsotaan, täyttääkö kädessä
     * olevat kortit jonkin voittavan käden edellytykset.
     *
     * @param k käsi, jota halutaan tarkastella
     * @return voittosumma, johon kyseinen voitto oikeuttaa käytössä olevalla panoksella.
     */
    public double tulikoVoittoa(Kasi k) {
        double voitto;
        if (onkoKuningasVariSuora(k)) {
            voitto = (this.panos * 50);
            this.viimeisinVoitto = voitto;
            this.voitot = +voitto;
            return voitto;
        } else if (onkoVariSuora(k)) {
            voitto = (this.panos * 40);
            this.viimeisinVoitto = voitto;
            this.voitot = +voitto;
            return voitto;
        } else if (onkoNeloset(k)) {
            voitto = (this.panos * 20);
            this.viimeisinVoitto = voitto;
            this.voitot = +voitto;
            return voitto;
        } else if (onkoTaysKasi(k)) {
            voitto = (this.panos * 10);
            this.viimeisinVoitto = voitto;
            this.voitot = +voitto;
            return voitto;
        } else if (onkoVari(k)) {
            voitto = (this.panos * 5);
            this.viimeisinVoitto = voitto;
            this.voitot = +voitto;
            return voitto;
        } else if (onkoSuora(k)) {
            voitto = (this.panos * 4);
            this.viimeisinVoitto = voitto;
            this.voitot = +voitto;
            return voitto;
        } else if (onkoKolmoset(k)) {
            voitto = (this.panos * 2);
            this.viimeisinVoitto = voitto;
            this.voitot = +voitto;
            return voitto;
        } else if (onkoKaksiParia(k)) {
            voitto = (this.panos * 2);
            this.viimeisinVoitto = voitto;
            this.voitot = +voitto;
            return voitto;
        } else {

            return 0.0;
        }
    }

    public void kasvataPanosta() {
        if (this.panos == 1.0) {
            this.panos = 0.2;
        } else {
            this.panos = +0.2;
        }
    }

    /**
     * Testaa, onko kädessä värin muodostavat kortit, eli onko kaikkien kädessä
     * olevien korttien maa sama.
     *
     * @param k Kasi, jota halutaan tarkastella
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoVari(Kasi k) {
        Kortti c = k.katsoKortti(0);
        int maa;
        maa = c.haeMaa();
        for (Kortti g : k.listaaKortit()) {
            if ((g.haeMaa()) != maa) {
                return false;
            }
        }
        return true;
    }

    /**
     * Testaa, onko kädessä suoran muodostavat kortit, eli muodostuuko korttien
     * arvoista peräkkäinen lukujen jono.
     *
     * @param k Kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoSuora(Kasi k) {
        ArrayList<Integer> arvot = new ArrayList();
        for (Kortti g : k.listaaKortit()) {
            arvot.add(g.haeArvo());
        }
        Collections.sort(arvot);
        for (int i = 0; i < 4; i++) {
            if (arvot.get(i) != arvot.get(i + 1) - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Testaa, onko kädessä värin muodostavat kortit, löytyykö kädestä sekä
     * kolmoset, että kahdesta jäljellä olevasta kortista pari.
     *
     * @param k Kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoTaysKasi(Kasi k) {
        ArrayList<Integer> arvot = new ArrayList();
        if (onkoKolmoset(k) == true) {
            for (Kortti g : k.listaaKortit()) {
                if (!arvot.contains(g.haeArvo())) {
                    arvot.add(g.haeArvo());
                }
            }
            if (arvot.size() == 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * Testaa, onko kädessä kolme samanarvoista korttia.
     *
     * @param k Kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoKolmoset(Kasi k) {
        ArrayList<Integer> arvot = new ArrayList();
        for (Kortti g : k.listaaKortit()) {
            for (int a : arvot) {
                arvot.add(g.haeArvo());
            }
        }
        if (arvot.size() == 3) {
            Collections.sort(arvot);
            for (int i = 0; i < 3; i++) {
                if (arvot.get(i) == arvot.get(i + 1)) {
                    if (arvot.get(i + 1) == arvot.get(i + 2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Testaa, onko kädessä kaksi samoista arvoista muodostuvaa paria.
     *
     * @param k Kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoKaksiParia(Kasi k) {
        if (onkoKolmoset(k) == false) {
            ArrayList<Integer> arvot = new ArrayList();
            for (Kortti g : k.listaaKortit()) {
                if (!arvot.contains(g.haeArvo())) {
                    arvot.add(g.haeArvo());
                }
            }
            if (arvot.size() == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Testaa, onko kädessä neljä samanarvoista korttia.
     *
     * @param k Kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoNeloset(Kasi k) {
        ArrayList<Integer> arvot = new ArrayList();
        for (Kortti g : k.listaaKortit()) {
            if (!arvot.contains(g.haeArvo())) {
                arvot.add(g.haeArvo());
            }
        }
        if (arvot.size() == 2) {
            return true;
        }



        return false;
    }

    /**
     * Testaa, onko kädessä värisuora, eli sekä väri, että suora
     *
     * @param k Kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoVariSuora(Kasi k) {
        if (onkoVari(k) == true && onkoSuora(k) == true) {
            return true;
        }
        return false;
    }

    /**
     * Testaa, muodostavatko kädessä olevat kortit sekä värin, että suoran, ja
     * onko korttien arvot korkeimmat mahdolliset (esim. ♥10, ♥J, ♥Q, ♥K, ♥A)
     *
     * @param k Kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoKuningasVariSuora(Kasi k) {
        if (onkoVariSuora(k) == true) {
            for (Kortti g : k.listaaKortit()) {
                if (g.haeArvo() != 13 | g.haeArvo() != 12 | g.haeArvo() != 11 | g.haeArvo() != 10 | g.haeArvo() != 9) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
