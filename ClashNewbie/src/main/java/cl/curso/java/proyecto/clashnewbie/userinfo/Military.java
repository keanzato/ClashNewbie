package cl.curso.java.proyecto.clashnewbie.userinfo;

import cl.curso.java.proyecto.clashnewbie.userinfo.military.Guerrilla;
import cl.curso.java.proyecto.clashnewbie.userinfo.military.MassDestruction;
import cl.curso.java.proyecto.clashnewbie.userinfo.military.Rank;
import cl.curso.java.proyecto.clashnewbie.userinfo.military.Unit;
import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class Military {

    private double strength;
    private double baseHit;
    private Rank rank;
    private Guerrilla guerrilla;
    private MassDestruction massDestruction;
    private Unit unit;

    public static Military make(JSONObject joMilitary){
        return new Military(joMilitary.getDouble("strength"), joMilitary.getDouble("base_hit"), Rank.make(joMilitary.getJSONObject("rank")), Guerrilla.make(joMilitary.getJSONObject("guerrilla")), 
                MassDestruction.make(joMilitary.getJSONObject("mass_destruction")), Unit.make(joMilitary.getJSONObject("unit")));
    }
    
    private Military(double strength, double baseHit, Rank rank, Guerrilla guerrilla, MassDestruction massDestruction, Unit unit) {
        this.strength = strength;
        this.baseHit = baseHit;
        this.rank = rank;
        this.guerrilla = guerrilla;
        this.massDestruction = massDestruction;
        this.unit = unit;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getBaseHit() {
        return baseHit;
    }

    public void setBaseHit(double baseHit) {
        this.baseHit = baseHit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Guerrilla getGuerrilla() {
        return guerrilla;
    }

    public void setGuerrilla(Guerrilla guerrilla) {
        this.guerrilla = guerrilla;
    }

    public MassDestruction getMassDestruction() {
        return massDestruction;
    }

    public void setMassDestruction(MassDestruction massDestruction) {
        this.massDestruction = massDestruction;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

}
