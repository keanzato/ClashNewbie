package cl.curso.java.proyecto.clashnewbie.userinfo.residence;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class Country {

    private int id;
    private String name;
    private String code;

    public static Country make(JSONObject joCountry) {
        return new Country(joCountry.getInt("id"), joCountry.getString("name"), joCountry.getString("code"));
    }

    private Country(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
