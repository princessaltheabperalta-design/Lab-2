package refactored;

/**
 * Main application demonstrating all structural design patterns
 * Laboratory 2: Structural Design Patterns
 */
public class ModularMediaStreamingSuite {
    
    public static void main(String[] args) {
        System.out.println("=== Modular Media Streaming Suite Demo ===\n");
        
        // Demo Adapter Pattern
        System.out.println("1. ADAPTER PATTERN - Multiple Media Sources");
        MediaSource localFile = new LocalFileSource("movie.mp4");
        MediaSource hlsStream = new HLSStreamSource("https://example.com/stream.m3u8");
        MediaSource remoteAPI = new RemoteAPISource("api://media-service/video/123");
        
        localFile.play();
        hlsStream.play();
        remoteAPI.play();
        System.out.println();
        
        // Demo Decorator Pattern
        System.out.println("2. DECORATOR PATTERN - Feature Plugins");
        MediaPlayer basicPlayer = new BasicMediaPlayer(localFile);
        MediaPlayer enhancedPlayer = new WatermarkDecorator(
            new EqualizerDecorator(
                new SubtitleDecorator(basicPlayer)
            )
        );
        
        System.out.println("Player: " + enhancedPlayer.getDescription());
        enhancedPlayer.play();
        System.out.println();
        
        // Demo Composite Pattern
        System.out.println("3. COMPOSITE PATTERN - Playlists");
        Playlist mainPlaylist = new Playlist("My Favorites");
        
        MediaPlayer player1 = new BasicMediaPlayer(localFile);
        MediaPlayer player2 = new SubtitleDecorator(new BasicMediaPlayer(hlsStream));
        
        mainPlaylist.addItem(new MediaItem(player1, "Local Movie"));
        mainPlaylist.addItem(new MediaItem(player2, "Streaming Show"));
        
        // Nested playlist
        Playlist subPlaylist = new Playlist("Music Videos");
        MediaPlayer musicPlayer = new EqualizerDecorator(new BasicMediaPlayer(remoteAPI));
        subPlaylist.addItem(new MediaItem(musicPlayer, "Music Video"));
        mainPlaylist.addItem(subPlaylist);
        
        System.out.println("Main playlist has " + mainPlaylist.getItemCount() + " items");
        mainPlaylist.play();
        System.out.println();
        
        // Demo Bridge Pattern
        System.out.println("4. BRIDGE PATTERN - Rendering Strategies");
        RenderingEngine hardwareEngine = new HardwareRenderingEngine();
        RenderingEngine softwareEngine = new SoftwareRenderingEngine();
        
        MediaRenderer videoRenderer = new VideoRenderer(hardwareEngine);
        MediaRenderer audioRenderer = new AudioRenderer(softwareEngine);
        
        videoRenderer.renderMedia("High-res video content");
        audioRenderer.renderMedia("Stereo audio track");
        
        // Runtime switching
        System.out.println("Switching video to software rendering...");
        videoRenderer.setRenderingEngine(softwareEngine);
        videoRenderer.renderMedia("High-res video content");
        System.out.println();
        
        // Demo Proxy Pattern
        System.out.println("5. PROXY PATTERN - Remote Caching");
        MediaStream cachedStream = new CachedMediaStream("popular-movie.mp4");
        
        System.out.println("First access:");
        cachedStream.stream();
        
        System.out.println("Second access:");
        cachedStream.stream();
        System.out.println();
        
        System.out.println("=== Demo Complete ===");
    }
}
