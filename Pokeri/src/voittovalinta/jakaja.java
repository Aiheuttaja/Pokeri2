/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voittovalinta;

import java.util.*;
import kortit.kasi;
import kortit.kortti;
import kortit.korttipakka;

/**
 *
 * @author Janne
 */
public class jakaja {
    
    private ArrayList<kortti> kortit;
    
    public jakaja(){
        this.kortit = new ArrayList<kortti>();
    }
    
    public void jaaKasi(kasi k, korttipakka p){
        p.sekoitaPakka();
        for(int i=0;i<5;i++){
            jaaKortti(k,p);
        }
    }
    
    public void jaaKortti(kasi k, korttipakka p){
        k.otaKateen(p.otaPaallimmaisinKortti());
    }
    
    public void sekoitaKorttiPakkaan(kortti k, korttipakka p){
        p.lisaaKortti(k);
        p.sekoitaPakka();
    }
}
