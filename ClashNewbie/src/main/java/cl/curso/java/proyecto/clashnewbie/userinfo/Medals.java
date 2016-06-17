package cl.curso.java.proyecto.clashnewbie.userinfo;

import net.sf.json.JSONObject;

/**
 *
 * @author Carlos Soza C <carlos.soza at profondos.com>
 */
public class Medals {

    private int battle_hero;
    private int campaign_hero;
    private int congress_member;
    private int country_president;
    private int freedom_fighter;
    private int hard_worker;
    private int media_mogul;
    private int mercenary;
    private int resistance_hero;
    private int society_builder;
    private int super_soldier;
    private int top_fighter;
    private int true_patriot;

    public static Medals make(JSONObject joM) {
        return new Medals(joM.getInt("battle_hero"), joM.getInt("campaign_hero"), joM.getInt("congress_member"), joM.getInt("country_president"),
                joM.getInt("freedom_fighter"), joM.getInt("hard_worker"), joM.getInt("media_mogul"), joM.getInt("mercenary"),
                joM.getInt("resistance_hero"), joM.getInt("society_builder"), joM.getInt("super_soldier"), joM.getInt("top_fighter"), joM.getInt("true_patriot"));
    }

    private Medals(int battle_hero, int campaign_hero, int congress_member, int country_president, int freedom_fighter, int hard_worker, int media_mogul, int mercenary, int resistance_hero, int society_builder, int super_soldier, int top_fighter, int true_patriot) {
        this.battle_hero = battle_hero;
        this.campaign_hero = campaign_hero;
        this.congress_member = congress_member;
        this.country_president = country_president;
        this.freedom_fighter = freedom_fighter;
        this.hard_worker = hard_worker;
        this.media_mogul = media_mogul;
        this.mercenary = mercenary;
        this.resistance_hero = resistance_hero;
        this.society_builder = society_builder;
        this.super_soldier = super_soldier;
        this.top_fighter = top_fighter;
        this.true_patriot = true_patriot;
    }

    public int getBattle_hero() {
        return battle_hero;
    }

    public void setBattle_hero(int battle_hero) {
        this.battle_hero = battle_hero;
    }

    public int getCampaign_hero() {
        return campaign_hero;
    }

    public void setCampaign_hero(int campaign_hero) {
        this.campaign_hero = campaign_hero;
    }

    public int getCongress_member() {
        return congress_member;
    }

    public void setCongress_member(int congress_member) {
        this.congress_member = congress_member;
    }

    public int getCountry_president() {
        return country_president;
    }

    public void setCountry_president(int country_president) {
        this.country_president = country_president;
    }

    public int getFreedom_fighter() {
        return freedom_fighter;
    }

    public void setFreedom_fighter(int freedom_fighter) {
        this.freedom_fighter = freedom_fighter;
    }

    public int getHard_worker() {
        return hard_worker;
    }

    public void setHard_worker(int hard_worker) {
        this.hard_worker = hard_worker;
    }

    public int getMedia_mogul() {
        return media_mogul;
    }

    public void setMedia_mogul(int media_mogul) {
        this.media_mogul = media_mogul;
    }

    public int getMercenary() {
        return mercenary;
    }

    public void setMercenary(int mercenary) {
        this.mercenary = mercenary;
    }

    public int getResistance_hero() {
        return resistance_hero;
    }

    public void setResistance_hero(int resistance_hero) {
        this.resistance_hero = resistance_hero;
    }

    public int getSociety_builder() {
        return society_builder;
    }

    public void setSociety_builder(int society_builder) {
        this.society_builder = society_builder;
    }

    public int getSuper_soldier() {
        return super_soldier;
    }

    public void setSuper_soldier(int super_soldier) {
        this.super_soldier = super_soldier;
    }

    public int getTop_fighter() {
        return top_fighter;
    }

    public void setTop_fighter(int top_fighter) {
        this.top_fighter = top_fighter;
    }

    public int getTrue_patriot() {
        return true_patriot;
    }

    public void setTrue_patriot(int true_patriot) {
        this.true_patriot = true_patriot;
    }

}
