package cl.curso.java.proyecto.clashnewbie;

import java.io.IOException;

import cl.curso.java.proyecto.clashnewbie.userinfo.UserInfo;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class TestJson {

    public static void main(String[] args) throws IOException {

        UserInfo userInfo = UserInfoUtils.getUserInfo("2740853");
        System.out.println("WON:" + userInfo.getMilitary().getGuerrilla().getWon());

    }

}
