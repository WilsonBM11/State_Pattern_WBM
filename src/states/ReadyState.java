package states;

import context.Player;

public class ReadyState extends State{

    public ReadyState(Player player) {
        super(player);
    }

    //Stop the player and change the state to StoppedState
    @Override
    public String onStop() {
        player.changeState(new StoppedState(player));
        return "Locked...";
    }

    //Play the track and change the state to PlayingState
    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
    }

    //OnNext is locked and keep the state
    @Override
    public String onNext() {
        return "Locked...";
    }

    //OnPrevious is locked and keep the state
    @Override
    public String onPrevious() {
        return "Locked...";
    }
}
