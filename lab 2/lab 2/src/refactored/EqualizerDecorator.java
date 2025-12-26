package refactored;

/**
 * Decorator Pattern - Concrete Decorator
 * Adds audio equalizer functionality
 */
public class EqualizerDecorator extends MediaPlayerDecorator {
    public EqualizerDecorator(MediaPlayer player) {
        super(player);
    }
    
    @Override
    public void play() {
        player.play();
        System.out.println("Applying audio equalizer...");
    }
    
    @Override
    public String getDescription() {
        return player.getDescription() + " with equalizer";
    }
}

