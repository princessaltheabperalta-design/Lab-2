package refactored;

/**
 * Adapter Pattern - Target Interface
 * Unified interface for all media sources
 */
public interface MediaSource {
    void play();
    String getSourceInfo();
}

