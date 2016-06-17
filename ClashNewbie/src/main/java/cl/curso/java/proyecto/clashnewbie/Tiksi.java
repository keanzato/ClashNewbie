package cl.curso.java.proyecto.clashnewbie;

import com.google.common.collect.ImmutableSortedSet;

import cl.curso.java.proyecto.clashnewbie.database.model.ChannelDAO;
import cl.curso.java.proyecto.clashnewbie.database.model.IrcUser;
import cl.curso.java.proyecto.clashnewbie.database.model.IrcUsersDAO;
import cl.curso.java.proyecto.clashnewbie.userinfo.UserInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.pircbotx.*;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class Tiksi extends ListenerAdapter implements Auxiliador {

    private final Map<String, String> nickIRC = Collections.synchronizedMap(new ConcurrentHashMap<String, String>());
    private List<String> admins = new ArrayList<>(Arrays.asList(new String[]{"__Joseph"}));
    private final Map<Channel, List<String>> operators = Collections.synchronizedMap(new ConcurrentHashMap<Channel, List<String>>());

    @Override
    public void onMessage(MessageEvent event) throws Exception {

        String message = event.getMessage();
        String sender = event.getUser().getNick();
        Channel channel = event.getChannel();

        //When someone says ?helloworld respond with "Hello World"
        if (event.getMessage().startsWith(".lp")) {
            String[] arrayCommands = message.split(" ");

            if (nickIRC.containsKey(sender)) {
                //System.out.println("Nick"+nickIRC.get(sender));
                UserInfo userInfo = UserInfoUtils.getUserInfo(nickIRC.get(sender));
                //System.out.println("Name: "+userInfo.getName());
                String fin;
                fin = Colors.BOLD + Colors.BLUE + "Id: " + userInfo.getId() + Colors.BROWN + " Name: " + userInfo.getName() + Colors.DARK_BLUE
                        + " Level: " + userInfo.getLevel() + Colors.DARK_GRAY + " Exp Points: " + userInfo.getExperience() + Colors.DARK_GREEN
                        + " Div: " + userInfo.getDivision() + Colors.LIGHT_GRAY + " National Rank: " + userInfo.getNational_rank() + Colors.MAGENTA
                        + " Strength: " + userInfo.getMilitary().getStrength() + Colors.OLIVE + " CS: " + userInfo.getCitizenShip().getName() + Colors.PURPLE
                        + " Military Unit: " + userInfo.getMilitary().getUnit().getName() + Colors.RED + " Newspaper: " + userInfo.getNewsPaper().getName();
                event.respond(fin);
                if (userInfo.isOnline()) {
                    event.respond(Colors.TEAL + "Status Online");
                } else if (!userInfo.isOnline()) {
                    event.respond(Colors.TEAL + "Status Offline");
                }

            } else if (arrayCommands.length >= 2) {
                String nicknme = arrayCommands[1];
                if (nickIRC.get(nicknme) != null) {

                    UserInfo userInfo = UserInfoUtils.getUserInfo(nickIRC.get(arrayCommands[1]));
                    String fin;
                    fin = Colors.BOLD + Colors.BLUE + "Id: " + userInfo.getId() + Colors.BROWN + " Name: " + userInfo.getName() + Colors.DARK_BLUE
                            + " Level: " + userInfo.getLevel() + Colors.DARK_GRAY + " Exp Points: " + userInfo.getExperience() + Colors.DARK_GREEN
                            + " Div: " + userInfo.getDivision() + Colors.LIGHT_GRAY + " National Rank: " + userInfo.getNational_rank() + Colors.MAGENTA
                            + " Strength: " + userInfo.getMilitary().getStrength() + Colors.OLIVE + " CS: " + userInfo.getCitizenShip().getName() + Colors.PURPLE
                            + " Military Unit: " + userInfo.getMilitary().getUnit().getName() + Colors.RED + " Newspaper: " + userInfo.getNewsPaper().getName();
                    event.respond(fin);
                    if (userInfo.isOnline()) {
                        event.respond(Colors.TEAL + "Status Online");
                    } else if (!userInfo.isOnline()) {
                        event.respond(Colors.TEAL + "Status Offline");
                    }
                } else {
                    event.respond("USER NOT REGISTRED WITH THE BOT. TELL THE USER TO DO .regid <ID>");
                }
            } else {

                event.respond("USER NOT REGISTRED WITH THE BOT. USE .regid <ID>");
            }

        }

        if (event.getMessage().startsWith(".lm")) {
            String[] arrayCommands = message.split(" ");

            if (nickIRC.containsKey(sender)) {
                if (arrayCommands.length < 2) {
                    //System.out.println("Nick"+nickIRC.get(sender));
                    UserInfo userInfo = UserInfoUtils.getUserInfo(nickIRC.get(sender));
                    //System.out.println("Name: "+userInfo.getName());
                    String fin;
                    fin = "Id: " + userInfo.getId() + " Name: " + userInfo.getName() + " Rank: " + userInfo.getMilitary().getRank().getName() + " Military Points: " + userInfo.getMilitary().getRank().getPoints() + " Rank Up: " + userInfo.getMilitary().getRank().getToNextRank();
                    event.respond(fin);
                }
            } else if (arrayCommands.length >= 2) {
                String nicknme = arrayCommands[1];
                if (nickIRC.get(nicknme) != null) {
                    UserInfo userInfo = UserInfoUtils.getUserInfo(nickIRC.get(arrayCommands[1]));
                    String fin;
                    fin = "Id: " + userInfo.getId() + " Name: " + userInfo.getName() + " Rank: " + userInfo.getMilitary().getRank().getName() + " Military Points: " + userInfo.getMilitary().getRank().getPoints() + " Rank Up: " + userInfo.getMilitary().getRank().getToNextRank();
                    event.respond(fin);
                } else {
                    event.respond("USER NOT REGISTRED WITH THE BOT. TELL THE USER TO DO .regid <ID>");
                }
            } else {

                event.respond("USER NOT REGISTRED WITH THE BOT. USE .regid <ID>");
            }

        }

        if (event.getMessage().startsWith(".egov")) {
            String[] arrayCommands = message.split(" ");

            if (arrayCommands.length < 2) {
                if (nickIRC.containsKey(sender)) {
                    String egov, fin;
                    egov = "http://www.egov4you.info/citizen/overview/";
                    fin = egov + nickIRC.get(sender);
                    event.respond(fin);
                }
            } else if (arrayCommands.length >= 2) {
                String nicknme = arrayCommands[1];
                if (nickIRC.get(nicknme) != null) {
                    String egov, fin;
                    egov = "http://www.egov4you.info/citizen/overview/";
                    fin = egov + nickIRC.get(arrayCommands[1]);
                    event.respond(fin);
                } else {
                    event.respond("USER NOT REGISTRED WITH THE BOT. TELL THE USER TO DO .regid <ID>");
                }
            } else {
                event.respond("NiCK NOT RESGITRED IN DATABASE. PLEASE USE .regid");
            }
        }

        if (message.startsWith(".fc")) {
            String[] arrayCommands = message.split(" ");
            String fin, rankName;
            if (arrayCommands.length < 3) {
                if (nickIRC.containsKey(sender)) {
                    UserInfo userInfo = UserInfoUtils.getUserInfo(nickIRC.get(sender));
                    double fuerz;
                    int rank, ff;
                    if (arrayCommands[1] == null) {
                        ff = 1;
                    } else {
                        ff = Integer.parseInt(arrayCommands[1]);
                    }
                    fuerz = userInfo.getMilitary().getStrength();
                    rank = userInfo.getMilitary().getRank().getLevel();
                    rankName = userInfo.getMilitary().getRank().getName();
                    fin = fightCalc(fuerz, rank, rankName, ff);
                    event.respond(fin);
                    //FUERZA Y RANGO
                }
            } else if (arrayCommands.length >= 3) {
                String nicknme = arrayCommands[2];
                if (nickIRC.get(nicknme) != null) {
                    UserInfo userInfo = UserInfoUtils.getUserInfo(nickIRC.get(nicknme));
                    double fuerz;
                    int rank, ff;
                    if (arrayCommands[1] == null) {
                        ff = 1;
                    } else {
                        ff = Integer.parseInt(arrayCommands[1]);
                    }
                    fuerz = userInfo.getMilitary().getStrength();
                    rank = userInfo.getMilitary().getRank().getLevel();
                    rankName = userInfo.getMilitary().getRank().getName();
                    fin = fightCalc(fuerz, rank, rankName, ff);
                    event.respond(fin);
                } else {
                    event.respond("USER NOT REGISTRED WITH THE BOT. TELL THE USER TO DO .regid <ID>");
                }
            } else {
                event.respond("NiCK NOT RESGITRED IN DATABASE. PLEASE USE .regid");
            }

        }

        if (message.startsWith(".load")) {
            if (admins.contains(sender)) {
                String[] arrayCommands = message.split(" ");
                //AQUI HACER FOR E INSERTAR CONTENIDOS TABLA 4
//                for (int i = 0; i < TABLA; i++) {
//                    event.getBot().sendIRC().joinChannel("#"+TABLA_CONTENT);
//                }
            } else {
                event.respond("Insufficient Access to the BoT");
            }
        }

        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            event.respond(sender + ": " + time);
        }

        if (message.startsWith(".regad")) {
            if (sender.equalsIgnoreCase("__Joseph")) {
                String[] arrayCommands = message.split(" ");
                //.regAD __Joseph --> [__Joseph]
                if (arrayCommands.length == 2) {
                    regAd(arrayCommands[1]);
                    event.respond("Nick aÃ±adido como ADMIN exitosamente");
                } else {
                    event.respond("To add an Admin, write .regAD + NickName(Example: .regAD __Joseph)");
                }
            }
        } else if (message.startsWith(".delad")) {
            if (sender.equalsIgnoreCase("__Joseph")) {
                String[] arrayCommands = message.split(" ");
                //.regAD __Joseph --> [__Joseph]
                if (arrayCommands.length == 2) {
                    delAd(arrayCommands[1]);
                    event.respond("Nick eliminado como ADMIN exitosamente");
                } else {
                    event.respond("To add an Admin, write .regOP + Nickname(Example: .regAD __Joseph)");
                }
            }
        }

        if (message.startsWith(".call")) {
            if (operators.containsKey(channel) && operators.get(channel).contains(sender)) {
                ImmutableSortedSet<User> usuarios = channel.getUsers();
                List<User> users = new ArrayList<>(usuarios);
                StringBuffer usersMessage = new StringBuffer();

                for (int i = 0; i < users.size();) {
                    for (int j = 0; j < 40 && i < users.size(); j++) {
                        usersMessage.append(users.get(i++).getNick()).append(' ');
                    }
                    usersMessage.delete(usersMessage.length() - 1, usersMessage.length());
                    System.out.println(usersMessage.toString());
                    event.respond(usersMessage.toString());
                    usersMessage.delete(0, usersMessage.length());
                }
                int indexOfFirstSpace = message.indexOf(" ");
                String msg = message.substring(indexOfFirstSpace, message.length()), fin;

                fin = " " + Colors.RED + Colors.BOLD + " Says: " + Colors.DARK_GREEN + msg;
                event.respond(fin);
            } else {
                event.respond("Dont have access to the BoT. Contact __Joseph");
            }

        } else if (message.startsWith(".join")) {
            if (admins.contains(sender)) {
                String[] arrayCommands = message.split(" ");
                if (arrayCommands.length == 2) {
                    event.getBot().sendIRC().joinChannel(arrayCommands[1]);
                } else {
                    event.respond("To join use .join CHANNEL_NAME ID(Example: .join #UPA)");
                }
            } else {
                event.respond("Insufficient Access to the BoT");
            }
        } else if (message.startsWith(".part")) {
            if (admins.contains(sender)) {
                String[] arrayCommands = message.split(" ");
                if (arrayCommands.length == 2) {
                    event.getBot().sendRaw().rawLineNow("part " + arrayCommands[1] + " I want out of here");
                } else {
                    event.respond("To part use .part CHANNEL_NAME ID(Example: .part #UPA)");
                }
            } else {
                event.respond("You dont have access to this BoT");
            }
        } else if (message.startsWith(".regid")) {

            String[] arrayCommands = message.split(" ");
            //.regid 1234 --> [sender][1234]
            if (arrayCommands.length == 2) {
                regID(event, sender, arrayCommands[1]);
            } //.regid 1234 --> [sender][Nickname][1234567]
            else if (arrayCommands.length > 2) {
                regID(event, arrayCommands[1], arrayCommands[2]);
            } else {
                event.respond("To register, write .regid + ID(Example: .regid 2740853) or .regid ID Nickname (Example: .regid __Joseph 2740853");
            }
        } else if (message.startsWith(".regop")) {
            if (admins.contains(sender)) {
                String[] arrayCommands = message.split(" ");
                //.regOP __Joseph --> [#channel][__Joseph]
                if (arrayCommands.length == 2) {
                    regOP(channel, arrayCommands[1]);
                    event.respond("Nick aÃ±adido como OP exitosamente");
                } else {
                    event.respond("To add an Operator, write .regOP + Nickname (Example: .regOP __Joseph)");
                }
            }
        } else if (message.startsWith(".delop")) {
            if (admins.contains(sender)) {
                String[] arrayCommands = message.split(" ");
                //.regOP __Joseph --> [#channel][__Joseph]
                if (arrayCommands.length == 2) {
                    delOP(channel, arrayCommands[1]);
                    event.respond("Nick eliminado como OP exitosamente");
                } else {
                    event.respond("To add an Operator, write .regOP + Nickname (Example: .regOP __Joseph)");
                }
            }
        } else if (message.startsWith(".link")) {
            if (message.equals(".link")) {
                event.respond(link(sender));
            } else {
                event.respond("To link use .link || to register with BoT use .regid ID");
            }

        } else if (message.startsWith(".donate")) {
            if (message.equals(".donate")) {
                event.respond(donar(sender));
            } else {
                event.respond("To donate use .donate || to register with BoT use .regid ID");
            }
        }

    }

    @Override
    public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
        String message = event.getMessage();
        String sender = event.getUser().getNick();

        if (message.startsWith(".join")) {
            if (admins.contains(sender)) {
                String[] arrayCommands = message.split(" ");
                if (arrayCommands.length == 2) {
                    event.getBot().sendIRC().joinChannel(arrayCommands[1]);
                } else {
                    event.respond("To join use .join CHANNEL_NAME ID(Example: .join #UPA)");
                }
            } else {
                event.respond("Insufficient Access to the BoT");
            }
        } else if (message.startsWith(".part")) {
            if (admins.contains(sender)) {
                String[] arrayCommands = message.split(" ");
                if (arrayCommands.length == 2) {
                    event.getBot().sendRaw().rawLineNow("part " + arrayCommands[1] + " I want out of here");
                } else {
                    event.respond("To part use .part CHANNEL_NAME ID(Example: .part #UPA)");
                }
            } else {
                event.respond("You dont have access to this BoT");
            }
        }
    }

    /*public User[] callUsers(Channel channel, String nick, String mensaje) {
     return getUsers(channel);
        
        
     }*/
    public void regID(MessageEvent event, String nick, String ide) {
        //NICK VA PRIMERO, ID VA SEGUNDO
        //Si ya existe el nick el id se reemplazara. NO SE PERMITE BORRAR NICKS
        nickIRC.put(nick, ide);
        IrcUser ircUser = IrcUsersDAO.getIrcUserByNickname(nick);
        if (ircUser != null) {
            ircUser.setId(ide);
            IrcUsersDAO.updateIrcUser(ircUser);
            event.respond("ID de usuario actualizado exitosamente");
        } else {
            IrcUsersDAO.saveIrcUser(new IrcUser(ide, nick));
            event.respond("ID registrado exitosamente");
        }

    }

    public void regOP(Channel channel, String nick) {
        IrcUser ircUser = IrcUsersDAO.getIrcUserByNickname(nick);
        if (ircUser != null) {
            cl.curso.java.proyecto.clashnewbie.database.model.Channel channel1 = ChannelDAO.getChannel(channel.getName());
            channel1.addOperator(ircUser);
            ChannelDAO.updateChannel(channel1);
        }

        if (!operators.containsKey(channel)) {
            operators.put(channel, new ArrayList<String>());
        }
        operators.get(channel).add(nick);
    }

    public void delOP(Channel channel, String nick) {
        if (!operators.containsKey(channel)) {
            operators.put(channel, new ArrayList<String>());
        }
        operators.get(channel).remove(nick);
    }

    public void regAd(String nick) {
        /*if (!admins.contains(nick)) {
         admins.add(new ArrayList<String>());
         }*/
        admins.add(nick);
    }

    public void delAd(String nick) {

        admins.remove(nick);
    }

    public String fightCalc(double fuerza, int rango, String rankName, int ff) {
        double sinArmas, armaQ1, armaQ2, armaQ3, armaQ4, armaQ5, armaQ6, armaQ7;
        int sinArm, aQ1, aQ2, aQ3, aQ4, aQ5, aQ6, aQ7;

        //10*(1+fuerza/400.0)*(1+rango/5.0)*(1+firepower/100.0)
        sinArmas = 10 * (1 + fuerza / 400.0) * (1 + rango / 5.0) * (1 + q0 / 100.0);
        armaQ1 = 10 * (1 + fuerza / 400.0) * (1 + rango / 5.0) * (1 + q1 / 100.0);
        armaQ2 = 10 * (1 + fuerza / 400.0) * (1 + rango / 5.0) * (1 + q2 / 100.0);
        armaQ3 = 10 * (1 + fuerza / 400.0) * (1 + rango / 5.0) * (1 + q3 / 100.0);
        armaQ4 = 10 * (1 + fuerza / 400.0) * (1 + rango / 5.0) * (1 + q4 / 100.0);
        armaQ5 = 10 * (1 + fuerza / 400.0) * (1 + rango / 5.0) * (1 + q5 / 100.0);
        armaQ6 = 10 * (1 + fuerza / 400.0) * (1 + rango / 5.0) * (1 + q6 / 100.0);
        armaQ7 = 10 * (1 + fuerza / 400.0) * (1 + rango / 5.0) * (1 + q7 / 100.0);

        sinArmas = sinArmas * ff;
        armaQ1 = armaQ1 * ff;
        armaQ2 = armaQ2 * ff;
        armaQ3 = armaQ3 * ff;
        armaQ4 = armaQ4 * ff;
        armaQ5 = armaQ5 * ff;
        armaQ6 = armaQ6 * ff;
        armaQ7 = armaQ7 * ff;

        sinArm = (int) Math.round(sinArmas);
        aQ1 = (int) Math.round(armaQ1);
        aQ2 = (int) Math.round(armaQ2);
        aQ3 = (int) Math.round(armaQ3);
        aQ4 = (int) Math.round(armaQ4);
        aQ5 = (int) Math.round(armaQ5);
        aQ6 = (int) Math.round(armaQ6);
        aQ7 = (int) Math.round(armaQ7);

        return Colors.BOLD + Colors.BLUE + " STR: " + fuerza + Colors.BROWN + " Rank: " + rankName + " (" + rango + ") " + Colors.PURPLE + " Q0: " + sinArm + Colors.TEAL + " Q1: " + aQ1 + Colors.DARK_GREEN + " Q2: " + aQ2 + Colors.NORMAL + Colors.BOLD + " Q3: " + aQ3 + Colors.RED + " Q4: " + aQ4 + Colors.TEAL + " Q5: " + aQ5 + Colors.BROWN + " Q6: " + aQ6 + Colors.RED + " Q7: " + aQ7;
    }

    public String donar(String nick) {

        if (nickIRC.containsKey(nick)) {
            return donarA + nick + items + nickIRC.get(nick) + dinero + nickIRC.get(nick);
        } else {
            return "ERROR. NICK NO REGISTRADO";
        }
    }

    public String link(String nick) {

        if (nickIRC.containsKey(nick)) {
            return linkA + nick + link + nickIRC.get(nick);
        } else {
            return "ERROR. NICK NOT REGISTERED";
        }
    }
}
