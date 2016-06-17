package cl.curso.java.proyecto.clashnewbie.userinfo.military;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class Guerrilla {

    private int won;
    private int lost;

    public static Guerrilla make(JSONObject joGuerrilla) {
        return new Guerrilla(joGuerrilla.getInt("won"), joGuerrilla.getInt("lost"));
    }


    private Guerrilla(int won, int lost) {
        this.won = won;
        this.lost = lost;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

}
