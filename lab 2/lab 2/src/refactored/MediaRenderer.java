package refactored;

/**
 * Bridge Pattern - Abstraction
 * Abstract class that uses a RenderingEngine implementation
 */
public abstract class MediaRenderer {
    protected RenderingEngine engine;
    
    public MediaRenderer(RenderingEngine engine) {
        this.engine = engine;
    }
    
    public abstract void renderMedia(String mediaContent);
    
    public void setRenderingEngine(RenderingEngine engine) {
        this.engine = engine;
    }
}

