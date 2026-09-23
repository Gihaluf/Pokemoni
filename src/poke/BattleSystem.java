package poke;

import java.util.Random;

public class BattleSystem {

    public enum StatusEffect {
        NONE,
        PARALYZED,
        SOAKED
    }

    public static class Skill {
        public final String name;
        public final int powerBonus;
        public final StatusEffect inflict;
        public final double chance;

        public Skill(String name, int powerBonus, StatusEffect inflict, double chance) {
            this.name = name;
            this.powerBonus = powerBonus;
            this.inflict = inflict;
            this.chance = chance;
        }
    }

    public static class TurnResult {
        public final String log;
        public final boolean finished;
        public final boolean playerWon;

        public TurnResult(String log, boolean finished, boolean playerWon) {
            this.log = log;
            this.finished = finished;
            this.playerWon = playerWon;
        }
    }

    private static class Battler {
        private final Pokemons base;
        private int hp;
        private StatusEffect status = StatusEffect.NONE;

        Battler(Pokemons base) {
            this.base = base;
            this.hp = base.getHP();
        }

        int speed() {
            int baseSpeed = base.getSPD();
            if (status == StatusEffect.PARALYZED) {
                return Math.max(1, baseSpeed - 15);
            }
            return baseSpeed;
        }
    }

    private final Battler player;
    private final Battler enemy;
    private final Random random;

    public BattleSystem(Pokemons playerPokemon, Pokemons enemyPokemon) {
        this(playerPokemon, enemyPokemon, new Random());
    }

    public BattleSystem(Pokemons playerPokemon, Pokemons enemyPokemon, Random random) {
        this.player = new Battler(playerPokemon);
        this.enemy = new Battler(enemyPokemon);
        this.random = random;
    }

    public Skill getBasicSkill(Pokemons pokemon) {
        if (pokemon instanceof UdensP) {
            return new Skill("Bubble Beam", 4, StatusEffect.SOAKED, 0.35);
        }
        return new Skill("Quick Spark", 3, StatusEffect.NONE, 0.0);
    }

    public Skill getSpecialSkill(Pokemons pokemon) {
        if (pokemon instanceof UdensP) {
            return new Skill("Hydro Pump", 10, StatusEffect.NONE, 0.0);
        }
        return new Skill("Thunder Shock", 8, StatusEffect.PARALYZED, 0.35);
    }

    public TurnResult performTurn(boolean useSpecial) {
        Skill playerSkill = useSpecial ? getSpecialSkill(player.base) : getBasicSkill(player.base);
        Skill enemySkill = random.nextBoolean() ? getBasicSkill(enemy.base) : getSpecialSkill(enemy.base);

        StringBuilder log = new StringBuilder();

        boolean playerFirst = player.speed() >= enemy.speed();
        if (playerFirst) {
            attack(player, enemy, playerSkill, log);
            if (enemy.hp > 0) {
                attack(enemy, player, enemySkill, log);
            }
        } else {
            attack(enemy, player, enemySkill, log);
            if (player.hp > 0) {
                attack(player, enemy, playerSkill, log);
            }
        }

        if (player.hp <= 0 || enemy.hp <= 0) {
            if (player.hp <= 0 && enemy.hp <= 0) {
                log.append("\nBoth Pokémon fainted. It's a draw!");
                return new TurnResult(log.toString(), true, false);
            }
            boolean playerWon = enemy.hp <= 0 && player.hp > 0;
            if (playerWon) {
                log.append("\nYou won the battle!");
            } else {
                log.append("\nYou lost the battle.");
            }
            return new TurnResult(log.toString(), true, playerWon);
        }

        log.append("\n").append(player.base.getVards()).append(" HP: ").append(player.hp)
           .append(" | ").append(enemy.base.getVards()).append(" HP: ").append(enemy.hp);
        return new TurnResult(log.toString(), false, false);
    }

    private void attack(Battler attacker, Battler defender, Skill skill, StringBuilder log) {
        if (attacker.status == StatusEffect.PARALYZED && random.nextDouble() < 0.35) {
            log.append("\n").append(attacker.base.getVards()).append(" is paralyzed and cannot move!");
            return;
        }

        int damage = attacker.base.getATK() + skill.powerBonus;
        if (attacker.base instanceof ElektriskaisP && defender.status == StatusEffect.SOAKED) {
            damage += 5;
        }

        defender.hp = Math.max(0, defender.hp - damage);
        log.append("\n").append(attacker.base.getVards())
           .append(" used ").append(skill.name)
           .append(" and dealt ").append(damage)
           .append(" damage to ").append(defender.base.getVards()).append(".");

        if (skill.inflict != StatusEffect.NONE
                && defender.status == StatusEffect.NONE
                && random.nextDouble() < skill.chance
                && defender.hp > 0) {
            defender.status = skill.inflict;
            log.append(" ").append(defender.base.getVards())
               .append(" is now ").append(skill.inflict.name().toLowerCase()).append(".");
        }
    }

    public int getPlayerHp() {
        return player.hp;
    }

    public int getEnemyHp() {
        return enemy.hp;
    }
}
