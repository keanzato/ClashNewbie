package cl.curso.java.proyecto.clashnewbie.userinfo.residence;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class Region {

    private int id;
    private String name;
    private OriginalOwnerCountry originalOwnerCountry;
    private int zone;

    public static Region make(JSONObject joRegion) {
        return new Region(joRegion.getInt("id"), joRegion.getString("name"), OriginalOwnerCountry.make(joRegion.getJSONObject("original_owner_country")), joRegion.getInt("zone"));
    }

    private Region(int id, String name, OriginalOwnerCountry originalOwnerCountry, int zone) {
        this.id = id;
        this.name = name;
        this.originalOwnerCountry = originalOwnerCountry;
        this.zone = zone;
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

    public OriginalOwnerCountry getOriginalOwnerCountry() {
        return originalOwnerCountry;
    }

    public void setOriginalOwnerCountry(OriginalOwnerCountry originalOwnerCountry) {
        this.originalOwnerCountry = originalOwnerCountry;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }
}
