package template;

/**
 * @author wujiazhen
 * @date 2019/3/20
 */
public class Skill {

    public int hurt;
    public Player player;
    public Player target;

    public Skill(int hurt, Player target) {
        this.hurt = hurt;
        this.target = target;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }
}
