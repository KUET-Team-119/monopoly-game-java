package domain.component.command;

import domain.player.Player;

public class DepositEffectCommand implements EffectCommand {
    private final Player player;
    private final int amount;

    public DepositEffectCommand(Player player, int amount) {
        this.player = player;
        this.amount = amount;
    }

    @Override
    public void execute() {
        player.getCashManager().addCash(amount);
        System.out.println(player.getId() + "가 " + amount + "만큼 입금했습니다.");
    }
}
