package states;

import context.Player;

public class StoppedState extends State{

    StoppedState(Player player) {
        super(player);
        //When state is StoppedState, the player isn't playing
        player.setPlaying(false);
    }

    //If player is playing a track, stops playing and change state to ReadyState
    //Else, is locked and keep the state
    @Override
    public String onStop() {
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return "Stop playing";
        } else {
            return "Locked...";
        }
    }

    //Change state to ReadyState
    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready";
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
