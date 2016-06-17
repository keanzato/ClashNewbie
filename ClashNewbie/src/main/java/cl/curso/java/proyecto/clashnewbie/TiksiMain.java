package cl.curso.java.proyecto.clashnewbie;

import org.pircbotx.*;

public class TiksiMain {

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {

        Configuration<PircBotX> config = new Configuration.Builder()
                .setName("ClashNewbie") //Nick of the bot. CHANGE IN YOUR CODE
                .setLogin("Tiksi") //Login part of hostmask, eg name:login@host
                .setNickservPassword("2252639")
                
                .setAutoNickChange(true) //Automatically change nick when the current one is in use
                .setServer("irc.rizon.net", 6667) //The server were connecting to
                .addAutoJoinChannel("#SoporteCoC") //Join #pircbotx channel on connect
                .addListener(new Tiksi())
                .buildConfiguration(); //Create an immutable configuration from this builder
                

        //Create our bot with the configuration
        PircBotX bot = new PircBotX(config);
        //Connect to the server
        bot.startBot();
        

        //PircBotX myBot = new PircBotX(config);
        // Now start our bot up.
        //Tiksi bot = new Tiksi(config);

        //myBot.startBot();
        

        try {
            bot.startBot();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/*
 //looking for Ident
 String url = "jdbc:mysql://localhost:3306/";
 String dbName = "eRepublik";
 String driver = "com.mysql.jdbc.Driver";
 String userName = "tiksi";
 String password = "Peluka2411";
 try {
 Class.forName(driver).newInstance();
 Connection conn = DriverManager.getConnection(url + dbName, userName, password);
 Statement st = conn.createStatement();
 ResultSet res = st.executeQuery("SELECT * FROM  event");
 while (res.next()) {
 int id = res.getInt("id");
 String msg = res.getString("msg");
 System.out.println(id + "\t" + msg);
 }
 int val = st.executeUpdate("INSERT into event VALUES(" + 1 + "," + "'Easy'" + ")");
 if (val == 1) {
 System.out.print("Successfully inserted value");
 }
 conn.close();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 }
 */
/*
 private static String readUrl(String urlString) throws Exception {
 BufferedReader reader = null;
 try {
 URL url = new URL(urlString);
 reader = new BufferedReader(new InputStreamReader(url.openStream()));
 StringBuffer buffer = new StringBuffer();
 int read;
 char[] chars = new char[1024];
 while ((read = reader.read(chars)) != -1) {
 buffer.append(chars, 0, read);
 }

 return buffer.toString();
 } finally {
 if (reader != null) {
 reader.close();
 }
 }
 }

 }
 */