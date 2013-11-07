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
    public String[] arvot = new String[13];

    {
        arvot[0] = "ässä";
        arvot[1] = "kaksi";
        arvot[2] = "kolme";
        arvot[3] = "neljä";
        arvot[4] = "viisi";
        arvot[5] = "kuusi";
        arvot[6] = "seitsemän";
        arvot[7] = "kahdeksan";
        arvot[8] = "yhdeksän";
        arvot[9] = "kymmenen";
        arvot[10] = "jätkä";
        arvot[11] = "kuningatar";
        arvot[12] = "kuningas";
    }
    public String[] maat = new String[4];

    {
        maat[0] = "hertta";
        maat[1] = "pata";
        maat[2] = "risti";
        maat[3] = "ruutu";
    }

    public kortti(int arvo, int maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    public int haeArvo() {
        return this.arvo;
    }
    
    public int haeMaa() {
        return this.maa;
    }

    @Override
    public String toString() {
        return maat[this.maa] + arvot[this.arvo];
    }
}
