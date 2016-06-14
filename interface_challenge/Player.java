package interface_challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subhransumishra on 6/2/16.
 */


public class Player implements ISample{
    private String name;

    public Player(String name, int hitPoint, int strength) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.strength = strength;
        this.weapon = "sword";
    }

    private int hitPoint;
    private int strength;
    private String weapon;

    public String getName() {
        return name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getStrength() {
        return strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoint=" + hitPoint +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, ""+this.hitPoint);
        values.add(2, ""+this.strength);
        values.add(3, weapon);
        return values;
    }

    @Override
    public void read(List<String> Savedvalue) {
        if(Savedvalue != null && Savedvalue.size() > 0){
            this.name = Savedvalue.get(0);
            this.hitPoint = Integer.parseInt(Savedvalue.get(1));
            this.strength = Integer.parseInt(Savedvalue.get(2));
            this.weapon = Savedvalue.get(3);
        }


    }

}
