package DZ1and2;

public abstract class BaseHero implements Interface{
    protected int health;
    protected double damage;
    protected int speed;
    protected int money;
    protected int mana;
    protected String name;
    protected double armor;
    protected int intelligence;
    protected String className;
    protected int level = 1;

    public BaseHero(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.money = money;
        this.mana = mana;
        this.name = name;
        this.armor = armor;
        this.intelligence = intelligence;
    }
    public int getHealth(){
        return this.health;
    }
    public double getDamage(){
        return this.damage;
    }
    public int getSpeed(){
        return this.speed;
    }
    public int getMoney(){
        return this.money;
    }
    public int getMana(){
        return this.mana;
    }
    public String getName(){
        return this.name;
    }
    public double getArmor(){
        return this.armor;
    }
    public int getIntelligence(){
        return this.intelligence;
    }
    public int getLevel(){
        return this.level;
    }
    public String toString(){
        return this.getName();
    }
    public void hit(BaseHero b){
        b.health = (int)(b.health - (100 - b.armor)/100 * this.damage);
    }
    public void regeneration(){
        this.health += 300;
        this.mana += 100;
    }
    protected String getInfo1(String className) {
        String str = String.format("%s %s %d уровня\nТекущее здоровье - %d ", className, this.name, this.level, this.health);
        return str;
    }
    public void step(){
        this.level += 1;
    }
}
class Peasant extends BaseHero{

    public Peasant(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence){
        super(health, damage, speed, money, mana, name, armor, intelligence);
    }
    public String getInfo(){
        return super.getInfo1("Крестьянин");
    }
    public void armoring(int cost){
        if (this.mana >= cost){
        this.armor = Math.min( Math.round(cost/50) + this.armor, 99);
        this.mana -= cost;
        }
    }
}
class Bandit extends BaseHero{
    public Bandit(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence){
        super(health, damage, speed, money, mana, name, armor, intelligence);
    }
    public String getInfo(){
        return super.getInfo1("Грабитель");
    }
    public void steal(BaseHero b){
        if (this.mana >= 160)
        this.money = this.money + Math.round(3 * b.money /10);
        b.money = Math.round(b.money - Math.round(3 * b.money /10));
    }

}
class Sniper extends BaseHero{
    public Sniper(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence){
        super(health, damage, speed, money, mana, name, armor, intelligence);
    }
    public String getInfo(){
        return super.getInfo1("Снайпер");
    }
    public void shot(BaseHero b){
        if (this.mana >= 30){
        b.health = (int) (b.health - this.damage);
        this.mana -= 30;
        }
    }

}
class Wizard extends BaseHero{
    public Wizard(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence){
        super(health, damage, speed, money, mana, name, armor, intelligence);
    }
    public String getInfo(){
        return super.getInfo1("Колдун");
    }
    public void heal(BaseHero b, int cost){
        if (cost <=  this.mana){
            b.health = b.health + cost * 2;
            this.mana = this.mana - cost;
        }
    }
    public void speedBuff(BaseHero b, int cost){
        if (cost <=  this.mana){
            b.speed = b.speed + cost;
            this.mana = this.mana - cost;
        }
    }
    public void spell(BaseHero b, int cost){
        if (this.mana >= cost){
            b.health = (int) (b.health - (cost*3/2)*(100 - b.armor)/100);
            this.mana -= cost;
        }

    }

}
class Spearman extends BaseHero{
    public Spearman(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence){
        super(health, damage, speed, money, mana, name, armor, intelligence);
    }
    public String getInfo(){
        return super.getInfo1("Копейщик");
    }
    public void attack(BaseHero b){
        if (this.mana >= 90){
            b.armor = Math.max(0, b.armor - 8);
            this.hit(b);
            this.mana -= 90;
        }    
    }
}
class Crossbowman extends BaseHero{
    public Crossbowman(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence){
        super(health, damage, speed, money, mana, name, armor, intelligence);
    }
    public String getInfo(){
        return super.getInfo1("Арбалетчик");
    }
    public void shot(BaseHero b){
        if (this.mana >= 50){
            this.damage *= 3;
            this.hit(b);
            this.damage /= 3;
            this.mana -= 50;
        }
    }
}
class Monk extends BaseHero{
    public Monk(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence){
        super(health, damage, speed, money, mana, name, armor, intelligence);
    }
    public String getInfo(){
        return super.getInfo1("Монах");
    }
    public void meditation(){
        this.health += 680;
        this.mana += 260;
    }
}