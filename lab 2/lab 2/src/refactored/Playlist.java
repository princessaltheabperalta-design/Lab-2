package refactored;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite Pattern - Composite
 * Represents a playlist that can contain other items or playlists
 */
public class Playlist implements PlaylistItem {
    private String name;
    private List<PlaylistItem> items;
    
    public Playlist(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }
    
    public void addItem(PlaylistItem item) {
        items.add(item);
    }
    
    public void removeItem(PlaylistItem item) {
        items.remove(item);
    }
    
    @Override
    public void play() {
        System.out.println("Playing playlist: " + name);
        for (PlaylistItem item : items) {
            item.play();
        }
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    public int getItemCount() {
        return items.size();
    }
}

