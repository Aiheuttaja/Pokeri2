/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

/**
 *
 * @author Janne
 */
public class kortti {

    private int arvo;
    private int maa;
    public final String[] maat = {"♥","♦","♠","♣"};
    public final String[] arvot = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public kortti(int maa, int arvo) {
        this.arvo=arvo;
        this.maa=maa;
    }
    
    /**palauttaa kortin arvon
     *@return kortin arvo numerona (J=10, Q=11, K=12, A=13)
     */ 
    public int haeArvo() {
        return this.arvo;
    }
    
    /**palauttaa kortin maan
     *@return maan numero (1=♥, 2=♦, 3=♠, 4=♣)
     */
    public int haeMaa() {
        return this.maa;
    }
    
    /**tulostaa kortin visuaalisen esityksen = kortin maan ja arvon
     *@return kortin maa ja arvo tekstinä
     */
    @Override
    public String toString() {
        return this.maat[this.maa] + this.arvot[this.arvo];
    }
}
