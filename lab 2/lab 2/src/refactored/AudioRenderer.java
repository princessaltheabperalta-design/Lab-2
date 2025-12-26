package refactored;

/**
 * Bridge Pattern - Refined Abstraction
 * Audio-specific renderer using a rendering engine
 */
public class AudioRenderer extends MediaRenderer {
    public AudioRenderer(RenderingEngine engine) {
        super(engine);
    }
    
    @Override
    public void renderMedia(String mediaContent) {
        engine.render("Audio: " + mediaContent);
    }
}

