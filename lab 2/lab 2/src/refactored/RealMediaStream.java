package refactored;

/**
 * Proxy Pattern - Real Subject
 * Actual media stream implementation
 */
public class RealMediaStream implements MediaStream {
    private String content;
    
    public RealMediaStream(String content) {
        this.content = content;
        System.out.println("Loading media stream: " + content);
    }
    
    @Override
    public void stream() {
        System.out.println("Streaming: " + content);
    }
    
    @Override
    public String getContent() {
        return content;
    }
}

