public class Health {
    int health;                     //здоровье, диапозон равен 0..N
    boolean is_alive;               //статус существа: жив или нет, при первоначальном создании существа равно "жив"
    private int count_heal;         //кол-во исцелений (0..3), при первоначальном создании существа равно 0
    private final int max_health;   //максимально возможное значение здоровья, равно певроначальному здоровью

    public Health(int health) {
        if (health < 1){
            throw new IllegalArgumentException("Изначальное значение здоровья должно быть больше 0. Пожалуйста, повторите попытку ввода.");
        }

        this.health = health;
        this.max_health = health;
        this.is_alive = true;   //первоначально все существа живые
        this.count_heal = 0;    //первоначально ни одно существо не исцелялось
    }

    public static void check_health(Health health){
        if (health.health <= 0){            //существо поверженно атакой
            if (health.count_heal < 3) {   //существо воскрешалось меньше 3 раз -> можно еще раз
                health.health = (int)(0.5 * health.max_health + 0.5);   //округляем в большую сторону чтобы битва отсавалась легендарной!
                health.count_heal++;        //счетчик возрождений увеличиваем
            }
            else                        //существо повержено навсегда
                health.is_alive = false;
        }
    }
}

