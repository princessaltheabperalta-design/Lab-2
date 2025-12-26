package refactored;

/**
 * Decorator Pattern - Concrete Decorator
 * Adds watermark overlay functionality
 */
public class WatermarkDecorator extends MediaPlayerDecorator {
    public WatermarkDecorator(MediaPlayer player) {
        super(player);
    }
    
    @Override
    public void play() {
        player.play();
        System.out.println("Applying watermark...");
    }
    
    @Override
    public String getDescription() {
        return player.getDescription() + " with watermark";
    }
}

