package poke;

import java.util.Random;

public class BattleSystemSelfCheck {

    public static void runChecks() {
        testTurnOrderBySpeed();
        testStatusEffectApplication();
        testWinCondition();
    }

    private static void testTurnOrderBySpeed() {
        Pokemons fast = new ElektriskaisP("Electric", "Fast", 50, 10, 100);
        Pokemons slow = new UdensP("Water", "Slow", 50, 10, 10);
        BattleSystem battle = new BattleSystem(fast, slow, new FixedRandom(true, 0.99));
        BattleSystem.TurnResult result = battle.performTurn(false);
        if (!result.log.contains("Fast used")) {
            throw new IllegalStateException("Turn order check failed");
        }
    }

    private static void testStatusEffectApplication() {
        Pokemons water = new UdensP("Water", "WaterMon", 60, 12, 40);
        Pokemons electric = new ElektriskaisP("Electric", "EleMon", 60, 12, 50);
        BattleSystem battle = new BattleSystem(electric, water, new FixedRandom(true, 0.0, 0.99));
        BattleSystem.TurnResult result = battle.performTurn(true);
        if (!result.log.contains("is now paralyzed")) {
            throw new IllegalStateException("Status effect check failed");
        }
    }

    private static void testWinCondition() {
        Pokemons strong = new ElektriskaisP("Electric", "Strong", 80, 80, 90);
        Pokemons weak = new UdensP("Water", "Weak", 10, 1, 20);
        BattleSystem battle = new BattleSystem(strong, weak, new FixedRandom(true, 0.99));
        BattleSystem.TurnResult result = battle.performTurn(true);
        if (!result.finished) {
            throw new IllegalStateException("Win/loss resolution check failed");
        }
    }

    private static class FixedRandom extends Random {
        private static final long serialVersionUID = 1L;
        private final boolean[] booleans;
        private final double[] doubles;
        private int bIndex;
        private int dIndex;

        FixedRandom(boolean firstBoolean, double... doubles) {
            this.booleans = new boolean[] { firstBoolean };
            this.doubles = doubles.length == 0 ? new double[] { 0.99 } : doubles;
        }

        @Override
        public boolean nextBoolean() {
            return booleans[Math.min(bIndex++, booleans.length - 1)];
        }

        @Override
        public double nextDouble() {
            return doubles[Math.min(dIndex++, doubles.length - 1)];
        }
    }
}
