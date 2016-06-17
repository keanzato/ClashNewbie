package cl.curso.java.proyecto.clashnewbie.userinfo;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class TopDamage {

    private int damage;
    private String date;
    private String message;

    public static TopDamage make(JSONObject joTD) {
        return new TopDamage(joTD.getInt("damage"), joTD.getString("date"), joTD.getString("message"));
    }

    private TopDamage(int damage, String date, String message) {
        this.damage = damage;
        this.date = date;
        this.message = message;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
