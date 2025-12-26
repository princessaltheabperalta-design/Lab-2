package refactored;

/**
 * Decorator Pattern - Concrete Decorator
 * Adds subtitle rendering functionality
 */
public class SubtitleDecorator extends MediaPlayerDecorator {
    public SubtitleDecorator(MediaPlayer player) {
        super(player);
    }
    
    @Override
    public void play() {
        player.play();
        System.out.println("Applying subtitles...");
    }
    
    @Override
    public String getDescription() {
        return player.getDescription() + " with subtitles";
    }
}

