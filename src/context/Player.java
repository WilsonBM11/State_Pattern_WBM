package context;

import states.ReadyState;
import states.State;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private State state;
    private boolean playing = false;
    private List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        //Initialize with ReadyState with this context
        this.state = new ReadyState(this);
        //Initialize with playing true
        setPlaying(true);
        playlist = List.of(new String[]{
                "Don't Stop Me Now - Queen",
                "Without Me - Eminem",
                "I'm Still Standing - Elton John",
                "Tears In Heaven - Eric Clapton",
                "When I Was Your Man - Bruno Mars"
        });
    }

    //Method for changing the state, it is used by the states
    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String startPlayback() {
        return "Playing: " + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    //When the player stops, the current track is 0 => "Track 1"
    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }

}
