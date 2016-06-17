package cl.curso.java.proyecto.clashnewbie.userinfo;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class NewsPaper {

    private int id;
    private String name;
    private String avatar;
    private String role;

    public static NewsPaper make(JSONObject joNP) {
        return new NewsPaper(joNP.getInt("id"), joNP.getString("name"), joNP.getString("avatar"), joNP.getString("role"));
    }

    private NewsPaper(int id, String name, String avatar, String role) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.role = role;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
