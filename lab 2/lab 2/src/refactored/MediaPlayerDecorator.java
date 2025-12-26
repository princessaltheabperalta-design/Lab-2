package refactored;

/**
 * Decorator Pattern - Base Decorator
 * Abstract decorator that wraps a MediaPlayer
 */
public abstract class MediaPlayerDecorator implements MediaPlayer {
    protected MediaPlayer player;
    
    public MediaPlayerDecorator(MediaPlayer player) {
        this.player = player;
    }
    
    @Override
    public void play() {
        player.play();
    }
    
    @Override
    public String getDescription() {
        return player.getDescription();
    }
}

