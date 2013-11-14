/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package kortit;

import java.util.*;

public class korttipakka {

    private ArrayList<kortti> pakka;

    public korttipakka() {
        
        this.pakka = new ArrayList<kortti>();
        
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {
                
                pakka.add(new kortti(j,i));
                
            }
        }
    }

    public void lisaaKortti(kortti kortti) {
        this.pakka.add(kortti);
    }

    public void poistaKortti(kortti kortti) {
        this.pakka.remove(kortti);
    }

    public int paljonkoKortteja() {
        return this.pakka.size();
    }
    
    public void sekoitaPakka(){
        Collections.shuffle(pakka);
    }
    
    @Override
    public String toString(){
        String kortit="";
        for(kortti k:pakka){
            kortit=(kortit + "\n" + k.toString());
            
        }
        return kortit;
    }
}
