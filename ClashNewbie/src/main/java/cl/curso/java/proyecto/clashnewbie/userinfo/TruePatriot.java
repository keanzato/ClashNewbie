package cl.curso.java.proyecto.clashnewbie.userinfo;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class TruePatriot {

    private int damage;
    private String since;

    public static TruePatriot make(JSONObject joTP) {
        return new TruePatriot(joTP.getInt("damage"), joTP.getString("since"));
    }

    private TruePatriot(int damage, String since) {
        this.damage = damage;
        this.since = since;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

}
