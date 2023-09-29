package states;

import context.Player;

public abstract class State {

    //Receives a player for managing the actions according to the state
    Player player;

    //Constructor
    State(Player player) {
        this.player = player;
    }

    //Defines what methods the states must implement and all of them show their action on the UI
    public abstract String onStop();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();

}
