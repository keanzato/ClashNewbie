package cl.curso.java.proyecto.clashnewbie.userinfo.military;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class MassDestruction {

    private int smallBombs;
    private int bigBombs;

    public static MassDestruction make(JSONObject joMassDestruction){
        return new MassDestruction(joMassDestruction.getInt("small_bombs"), joMassDestruction.getInt("big_bombs"));
        
    }
    
    private MassDestruction(int smallBombs, int bigBombs) {
        this.smallBombs = smallBombs;
        this.bigBombs = bigBombs;
    }

    public int getSmallBombs() {
        return smallBombs;
    }

    public void setSmallBombs(int smallBombs) {
        this.smallBombs = smallBombs;
    }

    public int getBigBombs() {
        return bigBombs;
    }

    public void setBigBombs(int bigBombs) {
        this.bigBombs = bigBombs;
    }
    
    
}
