/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import java.util.ArrayList;


public class korttipakka {
    private ArrayList<kortti> pakka;
    
    public korttipakka (){
        //Luodaan tarvittavat kortit lisaaKortti-metodia käyttäen.
    }
    
    public void lisaaKortti(kortti kortti){
        this.pakka.add(kortti);
    }
    
    public void poistaKortti(kortti kortti){
        String arvo = kortti.haeArvo();
        for (kortti x:pakka){
            if (x.haeArvo().equals(arvo)){
                pakka.remove(x);
            }
        }
    }
}
