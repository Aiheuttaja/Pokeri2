/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voittovalinta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    private double rahat;

    public Voitot(double rahat) {
        this.panos = 0.2;
        this.viimeisinVoitto = 0.0;
        this.voitot = 0.0;
        this.rahat = rahat;
    }

    /**
     * Luokan päämetodi, jossa käydään systemaattisesti läpi mahdolliset voitot
     * epätodennäköisimmästä todennäköisimpään ja katsotaan, täyttääkö kädessä
     * olevat kortit jonkin voittavan käden edellytykset.
     *
     * @param k käsi, jota halutaan tarkastella
     * @return voittosumma, johon kyseinen voitto oikeuttaa käytössä olevalla
     * panoksella.
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
        } else if (onkoTaysKasi(k)) {
            voitto = (this.panos * 10);
            this.viimeisinVoitto = voitto;
            this.voitot = +voitto;
            return voitto;
        } else if (onkoNeloset(k)) {
            voitto = (this.panos * 20);
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
            this.panos = this.panos + 0.2;
        }
    }

    public double viimeisinVoitto() {
        return this.viimeisinVoitto;
    }

    public double voitot() {
        return this.voitot;
    }

    public double panos() {
        return this.panos;
    }

    public double rahat() {
        return this.rahat;
    }
    
    public void lisaaRahaa(double rahat){
        this.rahat+=rahat;
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
     * Testaa, onko kädessä täyskäden muodostavat kortit, eli löytyykö kädestä
     * sekä kolmoset, että kahdesta jäljellä olevasta kortista pari.
     *
     * @param k Kasi, jota halutaan tarkastella.
     * @return true tai false riippuen siitä, oliko kädessä tämä voitto.
     */
    private boolean onkoTaysKasi(Kasi k) {
        HashMap<Integer, Integer> arvot = new HashMap<>();
        ArrayList<Integer> maarat = new ArrayList<>();
        int apu;
        for(Kortti g:k.listaaKortit()){
            if(!arvot.containsKey(g.haeArvo())){
                arvot.put(g.haeArvo(), 1);
            }else{
                apu=arvot.get(g.haeArvo());
                arvot.put(g.haeArvo(),(apu+1));
            }            
        }
        if (arvot.size() == 2) {
            for (int arvo : arvot.values()) {
                maarat.add(arvo);
            }
            Collections.sort(maarat);
            if (maarat.get(0) == 2) {
                if (maarat.get(1) == 3) {
                    return true;
                }
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
        HashMap<Integer, Integer> arvot = new HashMap<>();
        ArrayList<Integer> maarat = new ArrayList<>();
        int apu;
        for (Kortti g : k.listaaKortit()) {
            if (!arvot.containsKey(g.haeArvo())) {
                arvot.put(g.haeArvo(), 1);
            } else {
                apu = arvot.get(g.haeArvo());
                arvot.put(g.haeArvo(), (apu + 1));
            }
        }
        if (arvot.size() == 3) {
            for (int arvo : arvot.values()) {
                maarat.add(arvo);
            }
            Collections.sort(maarat);
            if (maarat.get(0) == 1) {
                if (maarat.get(1) == 3) {
                    return true;
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

    private boolean onkoNeloset(Kasi k) {
        HashMap<Integer, Integer> arvot = new HashMap<>();
        int apu;
        for (Kortti g : k.listaaKortit()) {
            if (!arvot.containsKey(g.haeArvo())) {
                arvot.put(g.haeArvo(), 1);
            } else {
                apu = arvot.get(g.haeArvo());
                arvot.put(g.haeArvo(), (apu + 1));
            }
        }
        for (int arvo : arvot.values()) {
            if (arvo == 4) {
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
                if (g.haeArvo() == 12 || g.haeArvo() == 11 || g.haeArvo() == 10 || g.haeArvo() == 9 || g.haeArvo() == 8) {
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
