package cl.curso.java.proyecto.clashnewbie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import cl.curso.java.proyecto.clashnewbie.userinfo.UserInfo;
import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class UserInfoUtils {

    public static UserInfo getUserInfo(String idUsuario) throws IOException {
        InputStream is = null;
        try {
            is = new URL("http://www.peluka.info/harserver/harserver/web/app.php/citizen/profile/" + idUsuario + ".json").openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = JSONObject.fromObject(jsonText);
            is.close();
            return UserInfo.make(json);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
