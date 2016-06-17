package cl.curso.java.proyecto.clashnewbie.userinfo;

import cl.curso.java.proyecto.clashnewbie.userinfo.residence.Country;
import cl.curso.java.proyecto.clashnewbie.userinfo.residence.Region;
import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class Residence {

    private Country country;
    private Region region;

    public static Residence make(JSONObject joR) {
        return new Residence(Country.make(joR.getJSONObject("country")), Region.make(joR.getJSONObject("region")));
    }

    private Residence(Country country, Region region) {
        this.country = country;
        this.region = region;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
