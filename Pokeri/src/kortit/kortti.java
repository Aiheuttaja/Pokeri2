/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import java.util.*;
/**
 *
 * @author Janne
 */
public class kortti {

    private int arvo;
    private int maa;
    public final String[] maat = {"♥","♦","♠","♣"};
    public final String[] arvot = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    public kortti(int maa, int arvo) {
        this.arvo=arvo;
        this.maa=maa;
    }

    public int haeArvo() {
        return this.arvo;
    }
    
    public int haeMaa() {
        return this.maa;
    }

    @Override
    public String toString() {
        return this.maat[this.maa] + this.arvot[this.arvo];
    }
}
