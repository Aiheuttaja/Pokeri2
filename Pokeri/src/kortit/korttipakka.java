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
        
        //Luodaan kortit sisäkkäisillä for-silmukoilla, joissa jokaista neljää maata kohden luodaan 13 korttia.
        
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {           
                
                pakka.add(new kortti(j,i));
                
            }
        }
    }

    //Lisätään kortti pakkaan (kun jaetaan uusi käsi yms.)
    public void lisaaKortti(kortti kortti) {
        this.pakka.add(kortti);
    }

    //Otetaan pakan päällimmäinen (array listin indeksissä nolla sijaitseva) kortti.
    public kortti otaPaallimmaisinKortti() {
        kortti k;
        k=this.pakka.get(0);
        this.pakka.remove(0);
        return k;
    }

    //Laskee pakassa olevien korttien määrän, lähinnä testausta varten.
    public int paljonkoKortteja() {
        return this.pakka.size();
    }
    
    //Listaa pakassa olevat kortit, lähinnä testausta varten.
    public ArrayList<kortti> mitkaKortit(){
        return this.pakka;
    }
    
    //Sekoittaa pakan.
    public void sekoitaPakka(){
        Collections.shuffle(pakka);
    }
    
    //Tulostetaan pakassa olevat kortit siinä järjestyksessä kuin ne ovat.
    @Override
    public String toString(){
        String kortit="";
        for(kortti k:pakka){
            kortit=(kortit + "\n" + k.toString());
            
        }
        return kortit;
    }
}
