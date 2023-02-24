public class Creature {
    private final int attack, protection;   //атака и защита, должны быть равны в диапозоне 1..20
    private final String name;              //имя существа
    Health health_creature;                 //здоровье
    Damage damage_creature;                 //урон


    public Creature(int attack, int protection, String name, int health, int low_damage, int high_damage) {
        if (attack < 1 || attack > 20){
            throw new IllegalArgumentException("Атакой может быть целое число от 1 до 20. Пожалуйста, повторите попытку ввода.");
        }
        if (protection < 1 || protection > 20){
            throw new IllegalArgumentException("Защитой может быть целое число от 1 до 20. Пожалуйста, повторите попытку ввода.");
        }
        if (name == null)
            throw new NullPointerException("Пожалуйста, введите имя персонажа чтобы мы смогли их различать :)");

        this.attack = attack;
        this.protection = protection;
        this.name = name;

        this.health_creature = new Health(health);
        this.damage_creature = new Damage(low_damage, high_damage);

    }

    public static void attacking_full_scenario(Creature attacker, Creature protector){
        System.out.println("Битва между " + attacker.name + " (нападающим) и " + protector.name + " (жертвой) началась!");

        int attack_modif = Damage.attack_modifier(attacker.attack, protector.protection);   //высчитваем модификатор аттаки
        if (Damage.is_success(attack_modif)) {                                              //удар оказался успешным
            Damage.attacking(attacker.damage_creature, protector.health_creature);          //наносим удар
            if (!protector.health_creature.is_alive)                                        //проверяем статус здоровья жертвы
                System.out.println("\nСущество " + protector.name + " повержено существом " + attacker.name + "! Да возрадуемся (или опечалимся)...");
        }
    }
}
