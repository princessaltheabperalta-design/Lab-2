/**
 * Main application launcher for Laboratory 2: Structural Design Patterns
 * Modular Media Streaming Suite - Interactive GUI Demo
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Laboratory 2: Structural Design Patterns ===");
        System.out.println("Modular Media Streaming Suite - Interactive Demo");
        System.out.println("Launching GUI application...\n");
        
        // Launch the interactive GUI demo
        gui.MediaPlayerGUI.main(args);
        
        // Keep console open for additional info
        System.out.println("GUI launched successfully!");
        System.out.println("Use the interactive interface to demonstrate:");
        System.out.println("- Composite Pattern (Playlist assembly)");
        System.out.println("- Decorator Pattern (Feature toggling)");
        System.out.println("- Bridge Pattern (Renderer switching)");
        System.out.println("- Proxy Pattern (Caching demo)");
        System.out.println("- Adapter Pattern (Multiple sources)");
    }
}
