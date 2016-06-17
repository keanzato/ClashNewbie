package cl.curso.java.proyecto.clashnewbie.userinfo;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class UserInfo {
    
    private int id;
    private String name;
    private String birth;
    private String avatar;
    private boolean online;
    private String ban;
    private boolean alive;
    private int level;
    private int experience;
    private int division;
    private boolean elite_citizen;
    private int national_rank;
    private String about;
    private Military military;
    private CitizenShip citizenShip;
    private Residence residence;
    private Party party;
    private NewsPaper newsPaper;
    private TopDamage topDamage;
    private TruePatriot truePatriot;
    private Medals medals;
    
    public static UserInfo make(JSONObject joUI) {
        return new UserInfo(joUI.getInt("id"), joUI.getString("name"), joUI.getString("birth"), joUI.getString("avatar"),
                joUI.getBoolean("online"), joUI.getString("ban"), joUI.getBoolean("alive"), joUI.getInt("level"), joUI.getInt("experience"),
                joUI.getInt("division"), joUI.containsKey("elite_citizen"), joUI.getInt("national_rank"),
                joUI.getString("about"), Military.make(joUI.getJSONObject("military")), CitizenShip.make(joUI.getJSONObject("citizenship")), Residence.make(joUI.getJSONObject("residence")),
                Party.make(joUI.getJSONObject("party")), NewsPaper.make(joUI.getJSONObject("newspaper")), TopDamage.make(joUI.getJSONObject("top_damage")),
                TruePatriot.make(joUI.getJSONObject("true_patriot")), Medals.make(joUI.getJSONObject("medals")));
    }
    
    private UserInfo(int id, String name, String birth, String avatar, boolean online, String ban, boolean alive, int level, int experience, int division, boolean elite_citizen, int national_rank, String about, Military military, CitizenShip citizenShip, Residence residence, Party party, NewsPaper newsPaper, TopDamage topDamage, TruePatriot truePatriot, Medals medals) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.avatar = avatar;
        this.online = online;
        this.ban = ban;
        this.alive = alive;
        this.level = level;
        this.experience = experience;
        this.division = division;
        this.elite_citizen = elite_citizen;
        this.national_rank = national_rank;
        this.about = about;
        this.military = military;
        this.citizenShip = citizenShip;
        this.residence = residence;
        this.party = party;
        this.newsPaper = newsPaper;
        this.topDamage = topDamage;
        this.truePatriot = truePatriot;
        this.medals = medals;
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
    
    public String getBirth() {
        return birth;
    }
    
    public void setBirth(String birth) {
        this.birth = birth;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public boolean isOnline() {
        return online;
    }
    
    public void setOnline(boolean online) {
        this.online = online;
    }
    
    public String getBan() {
        return ban;
    }
    
    public void setBan(String ban) {
        this.ban = ban;
    }
    
    public boolean isAlive() {
        return alive;
    }
    
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public int getExperience() {
        return experience;
    }
    
    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    public int getDivision() {
        return division;
    }
    
    public void setDivision(int division) {
        this.division = division;
    }
    
    public boolean isElite_citizen() {
        return elite_citizen;
    }
    
    public void setElite_citizen(boolean elite_citizen) {
        this.elite_citizen = elite_citizen;
    }
    
    public int getNational_rank() {
        return national_rank;
    }
    
    public void setNational_rank(int national_rank) {
        this.national_rank = national_rank;
    }
    
    public String getAbout() {
        return about;
    }
    
    public void setAbout(String about) {
        this.about = about;
    }
    
    public Military getMilitary() {
        return military;
    }
    
    public void setMilitary(Military military) {
        this.military = military;
    }
    
    public CitizenShip getCitizenShip() {
        return citizenShip;
    }
    
    public void setCitizenShip(CitizenShip citizenShip) {
        this.citizenShip = citizenShip;
    }
    
    public Residence getResidence() {
        return residence;
    }
    
    public void setResidence(Residence residence) {
        this.residence = residence;
    }
    
    public Party getParty() {
        return party;
    }
    
    public void setParty(Party party) {
        this.party = party;
    }
    
    public NewsPaper getNewsPaper() {
        return newsPaper;
    }
    
    public void setNewsPaper(NewsPaper newsPaper) {
        this.newsPaper = newsPaper;
    }
    
    public TopDamage getTopDamage() {
        return topDamage;
    }
    
    public void setTopDamage(TopDamage topDamage) {
        this.topDamage = topDamage;
    }
    
    public TruePatriot getTruePatriot() {
        return truePatriot;
    }
    
    public void setTruePatriot(TruePatriot truePatriot) {
        this.truePatriot = truePatriot;
    }
    
    public Medals getMedals() {
        return medals;
    }
    
    public void setMedals(Medals medals) {
        this.medals = medals;
    }
    
}
