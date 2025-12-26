package refactored;

/**
 * Proxy Pattern - Proxy
 * Provides transparent caching for remote media streams
 */
public class CachedMediaStream implements MediaStream {
    private RealMediaStream realStream;
    private String content;
    private boolean isCached = false;
    
    public CachedMediaStream(String content) {
        this.content = content;
    }
    
    @Override
    public void stream() {
        if (!isCached) {
            System.out.println("Cache miss - loading from remote");
            realStream = new RealMediaStream(content);
            isCached = true;
        } else {
            System.out.println("Cache hit - serving from cache");
        }
        realStream.stream();
    }
    
    @Override
    public String getContent() {
        return content;
    }
}

