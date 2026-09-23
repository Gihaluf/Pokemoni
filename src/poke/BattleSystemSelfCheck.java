package poke;

public class BattleSystemSelfCheck {

    public static void runChecks() {
        testTurnOrderBySpeed();
        testStatusEffectApplication();
        testWinCondition();
    }

    private static void testTurnOrderBySpeed() {
        Pokemons fast = new ElektriskaisP("Electric", "Fast", 50, 10, 100);
        Pokemons slow = new UdensP("Water", "Slow", 50, 10, 10);
        BattleSystem battle = new BattleSystem(fast, slow);
        BattleSystem.TurnResult result = battle.performTurn(false);
        if (!result.log.contains("Fast used")) {
            throw new IllegalStateException("Turn order check failed");
        }
    }

    private static void testStatusEffectApplication() {
        Pokemons water = new UdensP("Water", "WaterMon", 60, 12, 40);
        Pokemons electric = new ElektriskaisP("Electric", "EleMon", 60, 12, 50);
        BattleSystem battle = new BattleSystem(electric, water);
        BattleSystem.TurnResult result = battle.performTurn(true);
        if (result.log == null || result.log.isEmpty()) {
            throw new IllegalStateException("Battle log should not be empty");
        }
    }

    private static void testWinCondition() {
        Pokemons strong = new ElektriskaisP("Electric", "Strong", 80, 80, 90);
        Pokemons weak = new UdensP("Water", "Weak", 10, 1, 20);
        BattleSystem battle = new BattleSystem(strong, weak);
        BattleSystem.TurnResult result = battle.performTurn(true);
        if (!result.finished) {
            throw new IllegalStateException("Win/loss resolution check failed");
        }
    }
}
