/**
 * @author wujiazhen
 * @Date 2019/3/20
 */
public class Player {

    public Player(String name, int level, int vip) {
        this.name = name;
        this.level = level;
        this.vip = vip;
    }

    private String name;
    private int level;
    private int vip;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }
}
