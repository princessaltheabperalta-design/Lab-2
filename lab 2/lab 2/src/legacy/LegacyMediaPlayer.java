package legacy;

/**
 * LEGACY CODE - Intentionally messy monolithic media player
 * This represents the "before" state that needs refactoring
 */
public class LegacyMediaPlayer {
    
    // Monolithic class handling everything
    private String currentSource;
    private String sourceType; // "local", "hls", "remote"
    private boolean hasSubtitles;
    private boolean hasEqualizer;
    private boolean hasWatermark;
    private String renderingMode; // "hardware", "software"
    private boolean useCache;
    
    public LegacyMediaPlayer() {
        this.currentSource = "";
        this.sourceType = "local";
        this.hasSubtitles = false;
        this.hasEqualizer = false;
        this.hasWatermark = false;
        this.renderingMode = "software";
        this.useCache = false;
    }
    
    // Duplicated adaptation code for different sources
    public void playLocalFile(String filename) {
        System.out.println("Playing local file: " + filename);
        this.currentSource = filename;
        this.sourceType = "local";
        
        // Duplicated rendering logic
        if (this.renderingMode.equals("hardware")) {
            System.out.println("Using hardware rendering for local file");
        } else {
            System.out.println("Using software rendering for local file");
        }
        
        // Duplicated feature application
        if (this.hasSubtitles) {
            System.out.println("Applying subtitles to local file");
        }
        if (this.hasEqualizer) {
            System.out.println("Applying equalizer to local file");
        }
        if (this.hasWatermark) {
            System.out.println("Applying watermark to local file");
        }
    }
    
    public void playHLSStream(String url) {
        System.out.println("Playing HLS stream: " + url);
        this.currentSource = url;
        this.sourceType = "hls";
        
        // Duplicated rendering logic
        if (this.renderingMode.equals("hardware")) {
            System.out.println("Using hardware rendering for HLS stream");
        } else {
            System.out.println("Using software rendering for HLS stream");
        }
        
        // Duplicated feature application
        if (this.hasSubtitles) {
            System.out.println("Applying subtitles to HLS stream");
        }
        if (this.hasEqualizer) {
            System.out.println("Applying equalizer to HLS stream");
        }
        if (this.hasWatermark) {
            System.out.println("Applying watermark to HLS stream");
        }
    }
    
    public void playRemoteAPI(String apiUrl) {
        System.out.println("Playing remote API: " + apiUrl);
        this.currentSource = apiUrl;
        this.sourceType = "remote";
        
        // Duplicated rendering logic
        if (this.renderingMode.equals("hardware")) {
            System.out.println("Using hardware rendering for remote API");
        } else {
            System.out.println("Using software rendering for remote API");
        }
        
        // Duplicated feature application
        if (this.hasSubtitles) {
            System.out.println("Applying subtitles to remote API");
        }
        if (this.hasEqualizer) {
            System.out.println("Applying equalizer to remote API");
        }
        if (this.hasWatermark) {
            System.out.println("Applying watermark to remote API");
        }
    }
    
    // Monolithic playlist handling
    public void playPlaylist(String[] files) {
        System.out.println("Playing playlist with " + files.length + " files");
        for (String file : files) {
            if (file.startsWith("http")) {
                playHLSStream(file);
            } else if (file.startsWith("api://")) {
                playRemoteAPI(file);
            } else {
                playLocalFile(file);
            }
        }
    }
    
    // Feature toggles - tightly coupled
    public void enableSubtitles() {
        this.hasSubtitles = true;
        System.out.println("Subtitles enabled");
    }
    
    public void enableEqualizer() {
        this.hasEqualizer = true;
        System.out.println("Equalizer enabled");
    }
    
    public void enableWatermark() {
        this.hasWatermark = true;
        System.out.println("Watermark enabled");
    }
    
    public void setRenderingMode(String mode) {
        this.renderingMode = mode;
        System.out.println("Rendering mode set to: " + mode);
    }
    
    public void enableCaching() {
        this.useCache = true;
        System.out.println("Caching enabled");
    }
    
    // No plugin mechanism - everything hardcoded
    public void showStatus() {
        System.out.println("=== Legacy Player Status ===");
        System.out.println("Source: " + currentSource);
        System.out.println("Type: " + sourceType);
        System.out.println("Subtitles: " + hasSubtitles);
        System.out.println("Equalizer: " + hasEqualizer);
        System.out.println("Watermark: " + hasWatermark);
        System.out.println("Rendering: " + renderingMode);
        System.out.println("Cache: " + useCache);
    }
}
