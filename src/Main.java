public class Main {
    public static void main(String[] args) {
        //класс Creature - класс Существа
        //класс Health - здоровье существа
        //класс Damage - урон существа

        Creature player = new Creature(1, 1, "Игрок", 1, 1, 6);
        Creature monster = new Creature(1, 1, "Монстр", 1, 1, 6);

        //Пускай Монстр и Игрок будут нападать друг на друга по череди пока один из них не погибнет
        //Более подробное описание что просиходит написано у каждой функции
        while (true) {
            if (player.health_creature.is_alive && monster.health_creature.is_alive)
                Creature.attacking_full_scenario(monster, player);  //Монстр нападает на Игрока
            else break;
            if (player.health_creature.is_alive && monster.health_creature.is_alive)
                Creature.attacking_full_scenario(player, monster);  //Игрок нападает на Монстра
            else break;
            System.out.println("\n");
        }
    }
}
