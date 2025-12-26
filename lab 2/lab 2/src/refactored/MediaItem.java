package refactored;

/**
 * Composite Pattern - Leaf
 * Represents an individual media item in a playlist
 */
public class MediaItem implements PlaylistItem {
    private MediaPlayer player;
    private String name;
    
    public MediaItem(MediaPlayer player, String name) {
        this.player = player;
        this.name = name;
    }
    
    @Override
    public void play() {
        System.out.println("Playing: " + name);
        player.play();
    }
    
    @Override
    public String getName() {
        return name;
    }
}

