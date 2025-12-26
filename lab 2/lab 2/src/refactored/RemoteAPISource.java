package refactored;

/**
 * Adapter Pattern - Concrete Adapter
 * Adapts remote API endpoints to MediaSource interface
 */
public class RemoteAPISource implements MediaSource {
    private String apiUrl;
    
    public RemoteAPISource(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    
    @Override
    public void play() {
        System.out.println("Playing remote API: " + apiUrl);
    }
    
    @Override
    public String getSourceInfo() {
        return "Remote API: " + apiUrl;
    }
}

