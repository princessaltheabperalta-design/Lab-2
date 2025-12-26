package refactored;

/**
 * Composite Pattern - Component Interface
 * Common interface for both individual items and playlists
 */
public interface PlaylistItem {
    void play();
    String getName();
}

