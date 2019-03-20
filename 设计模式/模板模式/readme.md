# 模板模式

模板模式：定义一个操作中的算法框架，而将一些步骤延迟到子类中。使得子类可以不改变算法的结构即可重新定义该算法的某写特定步骤。


# 例子
一个技能释放的流程
1.计算技能cd
2.技能消耗
3.选择技能目标
4.计算技能伤害
5.扣除技能伤害
游戏中然后存在两种技能，一个扣血的技能，给技能目标扣血，一种加血的技能给释放技能的玩家加血;


首先定义出模板类，描述技能释放的框架
```java
/**
 * 处理技能效果
 * @author wujiazhen
 * @date 2019/3/20
 */
public abstract class AbstractSkillEffect {
    /**
     * 一个技能释放的主要流程
     * 1.计算技能cd
     * 2.技能消耗
     * 3.选择技能目标
     * 4.计算技能伤害
     * 5.扣除技能伤害
     * @param skill
     */
    public void cast(Skill skill){
        if(!cd(skill)){
            return;
        }
        consumer(skill);
        Player player=selectTarget(skill);
        int hurt =countHurt(skill);
        hurt(player,hurt);
    }

    protected abstract void hurt(Player player, int hurt);

    protected  int countHurt(Skill skill){
        return skill.hurt;
    };

    protected abstract Player selectTarget(Skill skill);

    protected  void consumer(Skill skill){
        System.out.println("消耗mp");
    };

    protected  boolean cd(Skill skill){
        return true;
    }

}
```
子类中重新定义技能释放的伤害和选择目标步骤，实现给技能目标扣血的效果
```java
/**
 * 减血技能
 * @author wujiazhen
 * @date 2019/3/20
 */
public  class HarmfulSkillEffect extends AbstractSkillEffect{

    /**
     * 扣血
     * @param player
     * @param hurt
     */
    protected void hurt(Player player, int hurt) {
        player.decreHp(hurt);
    }

    /**
     * 给对方扣血
     * @param skill
     * @return
     */
    protected Player selectTarget(Skill skill) {
        return skill.getTarget();
    }
}

```

详细看代码

