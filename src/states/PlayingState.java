package states;

import context.Player;

public class PlayingState extends State{

    PlayingState(Player player) {
        super(player);
    }

    //Change state to StoppedState, restart the tracks and stop playing
    @Override
    public String onStop() {
        player.changeState(new StoppedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    //Change state to ReadyState
    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Paused...";
    }

    //Play the next track and keep the state
    @Override
    public String onNext() {
        return player.nextTrack();
    }

    //Play the previous track and keep the state
    @Override
    public String onPrevious() {
        return player.previousTrack();
    }

}
