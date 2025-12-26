package refactored;

/**
 * Decorator Pattern - Concrete Component
 * Basic media player without any decorators
 */
public class BasicMediaPlayer implements MediaPlayer {
    private MediaSource source;
    
    public BasicMediaPlayer(MediaSource source) {
        this.source = source;
    }
    
    @Override
    public void play() {
        source.play();
    }
    
    @Override
    public String getDescription() {
        return "Basic player for " + source.getSourceInfo();
    }
}

