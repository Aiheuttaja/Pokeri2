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
    public final String[] maat = {"hertta","ruutu","pata","risti"};
    public final String[] arvot = {"ässä","kakkonen","kolmonen","nelonen","vitonen","kutonen","seiska","kasi","ysi","kymppi","jätkä","kuningatar","kuningas"};

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
