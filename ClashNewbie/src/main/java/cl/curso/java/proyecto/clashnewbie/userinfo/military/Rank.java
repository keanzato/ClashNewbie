package cl.curso.java.proyecto.clashnewbie.userinfo.military;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class Rank {

    private String name;
    private int level;
    private int points;
    private String image;
    private int toNextRank;

    public static Rank make(JSONObject joRank){
        return new Rank(joRank.getString("name"), joRank.getInt("level"), joRank.getInt("points"), joRank.getString("image"), joRank.getInt("toNext"));
    }
    
    private Rank(String name, int level, int points, String image, int toNextRank) {
        this.name = name;
        this.level = level;
        this.points = points;
        this.image = image;
        this.toNextRank = toNextRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getToNextRank() {
        return toNextRank;
    }

    public void setToNextRank(int toNextRank) {
        this.toNextRank = toNextRank;
    }
    
    
    
}
