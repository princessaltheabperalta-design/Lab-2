package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Interactive GUI Demo for Modular Media Streaming Suite
 * Perfect for video demonstration with live interactions
 */
public class MediaPlayerGUI extends JFrame {
    
    // UI Components
    private JTextArea outputArea;
    private JPanel controlPanel;
    private JPanel playlistPanel;
    private JPanel decoratorPanel;
    private JPanel rendererPanel;
    private JPanel cachePanel;
    
    // Demo state
    private List<String> playlistItems;
    private boolean subtitlesEnabled = false;
    private boolean equalizerEnabled = false;
    private boolean watermarkEnabled = false;
    private String currentRenderer = "Software";
    private boolean cacheEnabled = false;
    
    public MediaPlayerGUI() {
        initializeGUI();
        setupEventHandlers();
        playlistItems = new ArrayList<>();
    }
    
    private void initializeGUI() {
        setTitle("Modular Media Streaming Suite - Interactive Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create main panels
        createOutputPanel();
        createControlPanel();
        
        // Add panels to frame
        add(outputArea, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        
        // Styling
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(45, 45, 45));
        
        // Initial welcome message
        appendOutput("🎬 Welcome to the Modular Media Streaming Suite Demo!\n");
        appendOutput("This interactive demo showcases structural design patterns.\n\n");
        appendOutput("📋 DEMO SCENARIOS:\n");
        appendOutput("1. Assemble a playlist with different media sources\n");
        appendOutput("2. Toggle decorators (subtitles, equalizer, watermark)\n");
        appendOutput("3. Switch between hardware/software rendering\n");
        appendOutput("4. Demonstrate remote cached streaming\n\n");
        appendOutput("Click the buttons below to interact with the system!\n");
        appendOutput("=" + "=".repeat(60) + "\n\n");
    }
    
    private void createOutputPanel() {
        outputArea = new JTextArea(20, 60);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        outputArea.setBackground(new Color(30, 30, 30));
        outputArea.setForeground(new Color(200, 200, 200));
        outputArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(100, 100, 100)),
            "Demo Output", 0, 0, new Font("Arial", Font.BOLD, 14), Color.WHITE));
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void createControlPanel() {
        controlPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        controlPanel.setBackground(new Color(60, 60, 60));
        controlPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        // Playlist Panel
        playlistPanel = createPlaylistPanel();
        controlPanel.add(playlistPanel);
        
        // Decorator Panel
        decoratorPanel = createDecoratorPanel();
        controlPanel.add(decoratorPanel);
        
        // Renderer Panel
        rendererPanel = createRendererPanel();
        controlPanel.add(rendererPanel);
        
        // Cache Panel
        cachePanel = createCachePanel();
        controlPanel.add(cachePanel);
        
        // Demo Panel
        JPanel demoPanel = createDemoPanel();
        controlPanel.add(demoPanel);
        
        // Clear Panel
        JPanel clearPanel = createClearPanel();
        controlPanel.add(clearPanel);
    }
    
    private JPanel createPlaylistPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 150, 255)),
            "🎵 COMPOSITE PATTERN - Playlist", 0, 0, 
            new Font("Arial", Font.BOLD, 12), new Color(0, 150, 255)));
        panel.setBackground(new Color(70, 70, 70));
        
        JButton addLocal = createStyledButton("Add Local File", new Color(0, 150, 0));
        JButton addStream = createStyledButton("Add HLS Stream", new Color(255, 150, 0));
        JButton addAPI = createStyledButton("Add Remote API", new Color(255, 0, 150));
        JButton playPlaylist = createStyledButton("▶️ Play Playlist", new Color(0, 200, 0));
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        buttonPanel.setBackground(new Color(70, 70, 70));
        buttonPanel.add(addLocal);
        buttonPanel.add(addStream);
        buttonPanel.add(addAPI);
        buttonPanel.add(playPlaylist);
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        // Event handlers
        addLocal.addActionListener(_ -> addToPlaylist("Local File", "movie.mp4"));
        addStream.addActionListener(_ -> addToPlaylist("HLS Stream", "https://example.com/stream.m3u8"));
        addAPI.addActionListener(_ -> addToPlaylist("Remote API", "api://media-service/video/123"));
        playPlaylist.addActionListener(_ -> playPlaylist());
        
        return panel;
    }
    
    private JPanel createDecoratorPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(255, 150, 0)),
            "🎨 DECORATOR PATTERN - Features", 0, 0, 
            new Font("Arial", Font.BOLD, 12), new Color(255, 150, 0)));
        panel.setBackground(new Color(70, 70, 70));
        
        JCheckBox subtitles = new JCheckBox("📝 Subtitles");
        JCheckBox equalizer = new JCheckBox("🎛️ Equalizer");
        JCheckBox watermark = new JCheckBox("🏷️ Watermark");
        
        subtitles.setBackground(new Color(70, 70, 70));
        equalizer.setBackground(new Color(70, 70, 70));
        watermark.setBackground(new Color(70, 70, 70));
        subtitles.setForeground(Color.WHITE);
        equalizer.setForeground(Color.WHITE);
        watermark.setForeground(Color.WHITE);
        
        JPanel checkboxPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        checkboxPanel.setBackground(new Color(70, 70, 70));
        checkboxPanel.add(subtitles);
        checkboxPanel.add(equalizer);
        checkboxPanel.add(watermark);
        
        panel.add(checkboxPanel, BorderLayout.CENTER);
        
        // Event handlers
        subtitles.addActionListener(_ -> {
            subtitlesEnabled = subtitles.isSelected();
            updateDecoratorStatus();
        });
        equalizer.addActionListener(_ -> {
            equalizerEnabled = equalizer.isSelected();
            updateDecoratorStatus();
        });
        watermark.addActionListener(_ -> {
            watermarkEnabled = watermark.isSelected();
            updateDecoratorStatus();
        });
        
        return panel;
    }
    
    private JPanel createRendererPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(150, 0, 255)),
            "🌉 BRIDGE PATTERN - Rendering", 0, 0, 
            new Font("Arial", Font.BOLD, 12), new Color(150, 0, 255)));
        panel.setBackground(new Color(70, 70, 70));
        
        JButton hardwareBtn = createStyledButton("🖥️ Hardware", new Color(0, 150, 255));
        JButton softwareBtn = createStyledButton("💻 Software", new Color(255, 150, 0));
        JButton switchBtn = createStyledButton("🔄 Switch", new Color(255, 0, 150));
        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        buttonPanel.setBackground(new Color(70, 70, 70));
        buttonPanel.add(hardwareBtn);
        buttonPanel.add(softwareBtn);
        buttonPanel.add(switchBtn);
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        // Event handlers
        hardwareBtn.addActionListener(_ -> setRenderer("Hardware"));
        softwareBtn.addActionListener(_ -> setRenderer("Software"));
        switchBtn.addActionListener(_ -> switchRenderer());
        
        return panel;
    }
    
    private JPanel createCachePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(255, 0, 150)),
            "🔄 PROXY PATTERN - Caching", 0, 0, 
            new Font("Arial", Font.BOLD, 12), new Color(255, 0, 150)));
        panel.setBackground(new Color(70, 70, 70));
        
        JButton enableCache = createStyledButton("✅ Enable Cache", new Color(0, 200, 0));
        JButton disableCache = createStyledButton("❌ Disable Cache", new Color(200, 0, 0));
        JButton streamDemo = createStyledButton("📡 Stream Demo", new Color(0, 150, 255));
        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        buttonPanel.setBackground(new Color(70, 70, 70));
        buttonPanel.add(enableCache);
        buttonPanel.add(disableCache);
        buttonPanel.add(streamDemo);
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        // Event handlers
        enableCache.addActionListener(_ -> enableCaching());
        disableCache.addActionListener(_ -> disableCaching());
        streamDemo.addActionListener(_ -> demonstrateCaching());
        
        return panel;
    }
    
    private JPanel createDemoPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 200, 0)),
            "🎬 DEMO SCENARIOS", 0, 0, 
            new Font("Arial", Font.BOLD, 12), new Color(0, 200, 0)));
        panel.setBackground(new Color(70, 70, 70));
        
        JButton fullDemo = createStyledButton("🎥 Full Demo", new Color(0, 200, 0));
        JButton adapterDemo = createStyledButton("🔌 Adapter Demo", new Color(255, 200, 0));
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonPanel.setBackground(new Color(70, 70, 70));
        buttonPanel.add(fullDemo);
        buttonPanel.add(adapterDemo);
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        // Event handlers
        fullDemo.addActionListener(_ -> runFullDemo());
        adapterDemo.addActionListener(_ -> runAdapterDemo());
        
        return panel;
    }
    
    private JPanel createClearPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            "🧹 UTILITIES", 0, 0, 
            new Font("Arial", Font.BOLD, 12), new Color(200, 200, 200)));
        panel.setBackground(new Color(70, 70, 70));
        
        JButton clearBtn = createStyledButton("🗑️ Clear Output", new Color(200, 100, 100));
        JButton resetBtn = createStyledButton("🔄 Reset All", new Color(100, 100, 200));
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonPanel.setBackground(new Color(70, 70, 70));
        buttonPanel.add(clearBtn);
        buttonPanel.add(resetBtn);
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        // Event handlers
        clearBtn.addActionListener(_ -> clearOutput());
        resetBtn.addActionListener(_ -> resetAll());
        
        return panel;
    }
    
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 11));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEtchedBorder());
        return button;
    }
    
    private void setupEventHandlers() {
        // Additional setup if needed
    }
    
    // Event handler methods
    private void addToPlaylist(String type, String source) {
        String item = type + ": " + source;
        playlistItems.add(item);
        appendOutput("✅ Added to playlist: " + item + "\n");
        appendOutput("📋 Playlist now has " + playlistItems.size() + " items\n\n");
    }
    
    private void playPlaylist() {
        if (playlistItems.isEmpty()) {
            appendOutput("⚠️ Playlist is empty! Add some items first.\n\n");
            return;
        }
        
        appendOutput("🎵 COMPOSITE PATTERN DEMO - Playing Playlist:\n");
        appendOutput("=" + "=".repeat(40) + "\n");
        
        for (int i = 0; i < playlistItems.size(); i++) {
            String item = playlistItems.get(i);
            appendOutput("Playing item " + (i + 1) + ": " + item + "\n");
            
            // Simulate playing with decorators
            if (subtitlesEnabled) appendOutput("  📝 Applying subtitles...\n");
            if (equalizerEnabled) appendOutput("  🎛️ Applying equalizer...\n");
            if (watermarkEnabled) appendOutput("  🏷️ Applying watermark...\n");
            
            appendOutput("  🎬 " + item + " completed\n\n");
        }
        
        appendOutput("✅ Playlist playback completed!\n");
        appendOutput("=" + "=".repeat(40) + "\n\n");
    }
    
    private void updateDecoratorStatus() {
        appendOutput("🎨 DECORATOR PATTERN - Feature Status Updated:\n");
        appendOutput("📝 Subtitles: " + (subtitlesEnabled ? "✅ Enabled" : "❌ Disabled") + "\n");
        appendOutput("🎛️ Equalizer: " + (equalizerEnabled ? "✅ Enabled" : "❌ Disabled") + "\n");
        appendOutput("🏷️ Watermark: " + (watermarkEnabled ? "✅ Enabled" : "❌ Disabled") + "\n\n");
    }
    
    private void setRenderer(String renderer) {
        currentRenderer = renderer;
        appendOutput("🌉 BRIDGE PATTERN - Renderer Set:\n");
        appendOutput("Current renderer: " + currentRenderer + "\n");
        appendOutput("Rendering engine switched to " + currentRenderer.toLowerCase() + " mode\n\n");
    }
    
    private void switchRenderer() {
        currentRenderer = currentRenderer.equals("Hardware") ? "Software" : "Hardware";
        appendOutput("🔄 BRIDGE PATTERN - Runtime Switch:\n");
        appendOutput("Switching from " + 
            (currentRenderer.equals("Hardware") ? "Software" : "Hardware") + 
            " to " + currentRenderer + " rendering\n");
        appendOutput("✅ Renderer switched successfully!\n\n");
    }
    
    private void enableCaching() {
        cacheEnabled = true;
        appendOutput("🔄 PROXY PATTERN - Caching Enabled:\n");
        appendOutput("✅ Remote content will now be cached for faster access\n\n");
    }
    
    private void disableCaching() {
        cacheEnabled = false;
        appendOutput("🔄 PROXY PATTERN - Caching Disabled:\n");
        appendOutput("❌ Remote content will be fetched fresh each time\n\n");
    }
    
    private void demonstrateCaching() {
        appendOutput("📡 PROXY PATTERN - Caching Demo:\n");
        appendOutput("=" + "=".repeat(30) + "\n");
        
        if (cacheEnabled) {
            appendOutput("First access (Cache Miss):\n");
            appendOutput("  🔄 Loading from remote server...\n");
            appendOutput("  📥 Caching content locally...\n");
            appendOutput("  ✅ Content loaded and cached\n\n");
            
            appendOutput("Second access (Cache Hit):\n");
            appendOutput("  ⚡ Serving from cache...\n");
            appendOutput("  🚀 Instant access - no network delay!\n\n");
        } else {
            appendOutput("Caching disabled - fetching fresh content:\n");
            appendOutput("  🔄 Loading from remote server...\n");
            appendOutput("  ⏱️ Network delay experienced\n\n");
        }
        
        appendOutput("=" + "=".repeat(30) + "\n\n");
    }
    
    private void runFullDemo() {
        clearOutput();
        appendOutput("🎥 FULL DEMO - All Patterns in Action:\n");
        appendOutput("=" + "=".repeat(50) + "\n\n");
        
        // Adapter Pattern Demo
        appendOutput("1️⃣ ADAPTER PATTERN - Multiple Media Sources:\n");
        appendOutput("🔌 LocalFileSource: movie.mp4\n");
        appendOutput("🔌 HLSStreamSource: https://example.com/stream.m3u8\n");
        appendOutput("🔌 RemoteAPISource: api://media-service/video/123\n");
        appendOutput("✅ All sources use unified MediaSource interface\n\n");
        
        // Decorator Pattern Demo
        appendOutput("2️⃣ DECORATOR PATTERN - Feature Stacking:\n");
        appendOutput("🎨 Basic Player → Subtitle Decorator → Equalizer Decorator → Watermark Decorator\n");
        appendOutput("✅ Features can be combined dynamically at runtime\n\n");
        
        // Composite Pattern Demo
        appendOutput("3️⃣ COMPOSITE PATTERN - Hierarchical Playlists:\n");
        appendOutput("📁 Main Playlist\n");
        appendOutput("  ├── 🎬 Movie Item\n");
        appendOutput("  ├── 📺 Show Item\n");
        appendOutput("  └── 📁 Music Sub-Playlist\n");
        appendOutput("      └── 🎵 Music Video Item\n");
        appendOutput("✅ Uniform treatment of items and collections\n\n");
        
        // Bridge Pattern Demo
        appendOutput("4️⃣ BRIDGE PATTERN - Rendering Strategies:\n");
        appendOutput("🌉 MediaRenderer abstraction ↔ RenderingEngine implementation\n");
        appendOutput("🖥️ Hardware Rendering Engine\n");
        appendOutput("💻 Software Rendering Engine\n");
        appendOutput("✅ Runtime switching between implementations\n\n");
        
        // Proxy Pattern Demo
        appendOutput("5️⃣ PROXY PATTERN - Transparent Caching:\n");
        appendOutput("🔄 CachedMediaStream proxy ↔ RealMediaStream subject\n");
        appendOutput("⚡ Cache hits provide instant access\n");
        appendOutput("🌐 Cache misses trigger remote loading\n");
        appendOutput("✅ Transparent caching without client changes\n\n");
        
        appendOutput("🎉 All structural patterns working together!\n");
        appendOutput("=" + "=".repeat(50) + "\n\n");
    }
    
    private void runAdapterDemo() {
        appendOutput("🔌 ADAPTER PATTERN - Detailed Demo:\n");
        appendOutput("=" + "=".repeat(35) + "\n");
        appendOutput("Problem: Different media sources have different interfaces\n");
        appendOutput("Solution: Adapter pattern provides unified interface\n\n");
        
        appendOutput("📁 LocalFileSource implements MediaSource:\n");
        appendOutput("  - play(): 'Playing local file: movie.mp4'\n");
        appendOutput("  - getSourceInfo(): 'Local file: movie.mp4'\n\n");
        
        appendOutput("🌐 HLSStreamSource implements MediaSource:\n");
        appendOutput("  - play(): 'Playing HLS stream: https://...'\n");
        appendOutput("  - getSourceInfo(): 'HLS stream: https://...'\n\n");
        
        appendOutput("🔗 RemoteAPISource implements MediaSource:\n");
        appendOutput("  - play(): 'Playing remote API: api://...'\n");
        appendOutput("  - getSourceInfo(): 'Remote API: api://...'\n\n");
        
        appendOutput("✅ Client code can treat all sources uniformly!\n");
        appendOutput("=" + "=".repeat(35) + "\n\n");
    }
    
    private void clearOutput() {
        outputArea.setText("");
    }
    
    private void resetAll() {
        playlistItems.clear();
        subtitlesEnabled = false;
        equalizerEnabled = false;
        watermarkEnabled = false;
        currentRenderer = "Software";
        cacheEnabled = false;
        
        clearOutput();
        appendOutput("🔄 All settings reset to defaults\n");
        appendOutput("Ready for new demo session!\n\n");
    }
    
    private void appendOutput(String text) {
        outputArea.append(text);
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MediaPlayerGUI().setVisible(true);
        });
    }
}
