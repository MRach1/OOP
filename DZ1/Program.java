package DZ1;

public class Program {
    public static void main(String[] args) {
        Wizard Wz = new Wizard(2500, 50, 200, 270, 900, "Иван", 10, 180);
        Peasant Ps = new Peasant(5700, 260, 240, 165, 500, "Степан", 40, 45);
        Monk Mn = new Monk(5000, 250, 320, 120, 800, "Кирилл", 35, 220);
        Sniper Sn = new Sniper(2600, 200, 220, 690, 400, "Антон", 12, 130);
        Spearman Sp = new Spearman(4200, 200, 270, 320, 420, "Андрей", 15, 140);
        Crossbowman Cr = new Crossbowman(3400, 190, 260, 280, 400, "Александр", 16, 96);
        Bandit Bn = new Bandit(3700, 230, 360, 200, 400, "Владимир", 20, 75);

        Ps.hit(Wz);
        System.out.println(Wz.getHealth());
        Wz.heal(Wz, 100);
        Wz.spell(Ps, 200);
        System.out.println(Wz.getHealth());
        System.out.println(Ps.getHealth());
    }
}

