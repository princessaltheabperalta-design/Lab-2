package refactored;

/**
 * Adapter Pattern - Concrete Adapter
 * Adapts HLS streaming protocol to MediaSource interface
 */
public class HLSStreamSource implements MediaSource {
    private String url;
    
    public HLSStreamSource(String url) {
        this.url = url;
    }
    
    @Override
    public void play() {
        System.out.println("Playing HLS stream: " + url);
    }
    
    @Override
    public String getSourceInfo() {
        return "HLS stream: " + url;
    }
}

