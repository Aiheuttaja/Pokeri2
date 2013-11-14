/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import java.util.*;

public class kasi {
    private ArrayList<kortti> käsi;
    private boolean[] lukitut;
    
    public kasi(){
        this.käsi=new ArrayList<kortti>();
        this.lukitut=new boolean[5];
    }
    
    public void nollaus(){
        for(boolean b:this.lukitut){
            b=false;
        }
}
    
    public void otaKateen(kortti kortti){
        if(this.käsi.size()>4){
            return;
        }
        this.käsi.add(kortti);
    }
    
    public void poistaKadesta(int i){
        käsi.remove(käsi.get(i));
    }
    
    public void lukitseKortti(int i){
        if(i>4){
            return;
        }
        lukitut[i] = true;
    }
    
    public int montakoKorttia(){
        return this.käsi.size();
    }
    
    @Override
    public String toString(){
        
        String ilmoitus="";
        
        for(kortti k:this.käsi){
            ilmoitus = ilmoitus + (k.toString() + " ");
        }
        
        return ilmoitus;
    }
}
