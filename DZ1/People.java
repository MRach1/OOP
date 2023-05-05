package DZ1;

public abstract class People{
    protected int health;
    protected double damage;
    protected int speed;
    protected int money;
    protected int mana;
    protected String name;
    protected double armor;
    protected int intelligence;

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
    public String toString(){
        return this.getName();
    }
    public void hit(People b){
        b.health = (int)(b.health - (100 - b.armor)/100 * this.damage);

    }
    public void regeneration(){
        this.health += 300;
        this.mana += 100;
    }
}
class Peasant extends People{

    public Peasant(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.money = money;
        this.mana = mana;
        this.name = name;
        this.armor = armor;
        this.intelligence = intelligence;
    }
    public void armoring(int cost){
        if (this.mana >= cost){
        this.armor = Math.min( Math.round(cost/50) + this.armor, 99);
        this.mana -= cost;
        }
    }
}
class Bandit extends People{
    public Bandit(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.money = money;
        this.mana = mana;
        this.name = name;
        this.armor = armor;
        this.intelligence = intelligence;
    }
    public void steal(People b){
        if (this.mana >= 160)
        this.money = this.money + Math.round(3 * b.money /10);
        b.money = Math.round(b.money - Math.round(3 * b.money /10));
    }

}
class Sniper extends People{
    public Sniper(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.money = money;
        this.mana = mana;
        this.name = name;
        this.armor = armor;
        this.intelligence = intelligence;
    }
    public void shot(People b){
        if (this.mana >= 30){
        b.health = (int) (b.health - this.damage);
        this.mana -= 30;
        }
    }

}
class Wizard extends People{
    public Wizard(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.money = money;
        this.mana = mana;
        this.name = name;
        this.armor = armor;
        this.intelligence = intelligence;
    }
    public void heal(People b, int cost){
        if (cost <=  this.mana){
            b.health = b.health + cost * 2;
            this.mana = this.mana - cost;
        }
    }
    public void speedBuff(People b, int cost){
        if (cost <=  this.mana){
            b.speed = b.speed + cost;
            this.mana = this.mana - cost;
        }
    }
    public void spell(People b, int cost){
        if (this.mana >= cost){
            b.health = (int) (b.health - (cost*3/2)*(100 - b.armor)/100);
            this.mana -= cost;
        }

    }

}
class Spearman extends People{
    public Spearman(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.money = money;
        this.mana = mana;
        this.name = name;
        this.armor = armor;
        this.intelligence = intelligence;
    }
    public void attack(People b){
        if (this.mana >= 90){
            b.armor = Math.max(0, b.armor - 8);
            this.hit(b);
            this.mana -= 90;
        }    
    }
}
class Crossbowman extends People{
    public Crossbowman(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.money = money;
        this.mana = mana;
        this.name = name;
        this.armor = armor;
        this.intelligence = intelligence;
    }
    public void shot(People b){
        if (this.mana >= 50){
            this.damage *= 3;
            this.hit(b);
            this.damage /= 3;
            this.mana -= 50;
        }
    }
}
class Monk extends People{
    public Monk(int health, int damage, int speed, int money, int mana, String name, int armor, int intelligence) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.money = money;
        this.mana = mana;
        this.name = name;
        this.armor = armor;
        this.intelligence = intelligence;
    }
    public void meditation(){
        this.health += 680;
        this.mana += 260;
    }

}