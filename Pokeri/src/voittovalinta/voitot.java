/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voittovalinta;

import java.util.ArrayList;
import java.util.Collections;
import kortit.kasi;
import kortit.kortti;

/**
 *
 * @author jilli
 */
public class voitot {

    private double panos;
    private double viimeisinVoitto;
    private double voitot;

    public voitot() {
        this.panos = 0.2;
        this.viimeisinVoitto = 0.0;
        this.voitot = 0.0;
    }

    public double tulikoVoittoa(kasi k) {
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
     * @param k kasi, jota halutaan tarkastella
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoVari(kasi k) {
        kortti c = k.katsoKortti(0);
        int maa;
        maa = c.haeMaa();
        for (kortti g : k.listaaKortit()) {
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
     * @param k kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoSuora(kasi k) {
        ArrayList<Integer> arvot = new ArrayList();
        for (kortti g : k.listaaKortit()) {
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
     * @param k kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoTaysKasi(kasi k) {
        ArrayList<Integer> arvot = new ArrayList();
        if (onkoKolmoset(k) == true) {
            for (kortti g : k.listaaKortit()) {
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
     * @param k kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoKolmoset(kasi k) {
        ArrayList<Integer> arvot = new ArrayList();
        for (kortti g : k.listaaKortit()) {
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
     * @param k kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoKaksiParia(kasi k) {
        if (onkoKolmoset(k) == false) {
            ArrayList<Integer> arvot = new ArrayList();
            for (kortti g : k.listaaKortit()) {
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
     * @param k kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoNeloset(kasi k) {
        ArrayList<Integer> arvot = new ArrayList();
        for (kortti g : k.listaaKortit()) {
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
     * Testaa, onko kädessä sekä väri, että suora
     *
     * @param k kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoVariSuora(kasi k) {
        if (onkoVari(k) == true && onkoSuora(k) == true) {
            return true;
        }
        return false;
    }

    /**
     * Testaa, muodostavatko kädessä olevat kortit sekä värin, että suoran, ja
     * onko korttien arvot korkeimmat mahdolliset (esim. ♥10, ♥J, ♥Q, ♥K, ♥A)
     *
     * @param k kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoKuningasVariSuora(kasi k) {
        if (onkoVariSuora(k) == true) {
            for (kortti g : k.listaaKortit()) {
                if (g.haeArvo() != 13 | g.haeArvo() != 12 | g.haeArvo() != 11 | g.haeArvo() != 10 | g.haeArvo() != 9) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
