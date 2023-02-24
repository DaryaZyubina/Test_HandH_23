public class Damage {
    private final int low_damage, high_damage;       //M..N

    public Damage(int low_damage, int high_damage) {
        if (low_damage < 0){
            throw new IllegalArgumentException("В нашей системе существо не может нанести самому себе урон. Пожалуйста, введите положительные целые числа (или равное 0) для урона.");
        }
        if (high_damage < 0){
            throw new IllegalArgumentException("В нашей системе существо не может нанести самому себе урон. Пожалуйста, введите положительные целые числа (или равное 0) для урона.");
        }
        if (low_damage > high_damage){
            throw new IllegalArgumentException("Нижняя граница урона не может быть выше верхней границы урона. Пожалуйста, повторите попытку ввода.");
        }

        this.low_damage = low_damage;
        this.high_damage = high_damage;
    }

    public static int attack_modifier(int attackers_attack, int protectors_protection){
        int modif = attackers_attack - protectors_protection + 1;   //"Рассчитываем Модификатор атаки. Он равен разности Атаки атакующего и Защиты защищающегося плюс 1"
        System.out.println("Модификатор атаки = " + modif);
        return modif;
    }

    public static boolean is_success(int att_modifier){
        int min = 1, max = 6;                   //минимальное и максимальное значение кубика
        int N = (Math.max(att_modifier, 1));    //если модификатор меньше 1, то делаем бросок хотя бы 1 раз
        for (int i = 0; i < N; i++){
            if (random(min, max) >= 5) { //делаем бросок и проверяем равно ли его значение 5 или 6
                System.out.println("Удар был успешным!");
                return true;
            }
        }

        System.out.println("Удар был не успешным!");
        return false;
    }

    public static void attacking(Damage damage_attacker, Health health_protector){
        //выбираем произвольный урон
        int attack = random(damage_attacker.low_damage, damage_attacker.high_damage);
        System.out.println("Урон атаки = " + attack);

        health_protector.health = health_protector.health - attack; //наносим урон по здоровью
        Health.check_health(health_protector);  //проверяем здоровье
    }

    public static int random(int min, int max){
        return (int)((Math.random() * ( max - min )) + min);
    }
}
