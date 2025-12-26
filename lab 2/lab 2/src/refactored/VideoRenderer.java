package refactored;

/**
 * Bridge Pattern - Refined Abstraction
 * Video-specific renderer using a rendering engine
 */
public class VideoRenderer extends MediaRenderer {
    public VideoRenderer(RenderingEngine engine) {
        super(engine);
    }
    
    @Override
    public void renderMedia(String mediaContent) {
        engine.render("Video: " + mediaContent);
    }
}

