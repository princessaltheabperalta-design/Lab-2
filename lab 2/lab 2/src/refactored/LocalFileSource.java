package refactored;

/**
 * Adapter Pattern - Concrete Adapter
 * Adapts local file system to MediaSource interface
 */
public class LocalFileSource implements MediaSource {
    private String filename;
    
    public LocalFileSource(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void play() {
        System.out.println("Playing local file: " + filename);
    }
    
    @Override
    public String getSourceInfo() {
        return "Local file: " + filename;
    }
}

