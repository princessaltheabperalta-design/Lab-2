# Laboratory 2: Structural Design Patterns
## Modular Media Streaming Suite

This project demonstrates the refactoring of a legacy media player using structural design patterns to create a flexible, extensible media streaming system.

### Project Structure

```
├── index.html                             # 🌐 Web application (standalone HTML/JS)
├── src/
│   ├── legacy/
│   │   └── LegacyMediaPlayer.java         # ⚠️ Legacy monolithic code (before)
│   │
│   ├── refactored/                        # ✅ Refactored code (after)
│   │   ├── ModularMediaStreamingSuite.java # Main demo application
│   │   │
│   │   ├── [ADAPTER PATTERN]
│   │   │   ├── MediaSource.java
│   │   │   ├── LocalFileSource.java
│   │   │   ├── HLSStreamSource.java
│   │   │   └── RemoteAPISource.java
│   │   │
│   │   ├── [DECORATOR PATTERN]
│   │   │   ├── MediaPlayer.java
│   │   │   ├── BasicMediaPlayer.java
│   │   │   ├── MediaPlayerDecorator.java
│   │   │   ├── SubtitleDecorator.java
│   │   │   ├── EqualizerDecorator.java
│   │   │   └── WatermarkDecorator.java
│   │   │
│   │   ├── [COMPOSITE PATTERN]
│   │   │   ├── PlaylistItem.java
│   │   │   ├── MediaItem.java
│   │   │   └── Playlist.java
│   │   │
│   │   ├── [BRIDGE PATTERN]
│   │   │   ├── RenderingEngine.java
│   │   │   ├── HardwareRenderingEngine.java
│   │   │   ├── SoftwareRenderingEngine.java
│   │   │   ├── MediaRenderer.java
│   │   │   ├── VideoRenderer.java
│   │   │   └── AudioRenderer.java
│   │   │
│   │   └── [PROXY PATTERN]
│   │       ├── MediaStream.java
│   │       ├── RealMediaStream.java
│   │       └── CachedMediaStream.java
│   │
│   └── java-demo/                         # Java GUI application (optional)
│       ├── App.java
│       └── gui/MediaPlayerGUI.java
│
├── docs/
│   ├── architecture-overview.md           # System architecture overview
│   ├── uml-class-diagrams.md             # UML class diagrams
│   ├── sequence-diagrams.md               # Sequence diagrams for core flows
│   └── design-rationale.md               # Design pattern rationale (700 words)
│
├── FILE_INDEX.md                          # Quick file reference
├── VIDEO_PRESENTATION_GUIDE.md            # Video presentation guide
└── README.md                              # This file
```

### Design Patterns Implemented

1. **Adapter Pattern** - Unified interface for multiple media sources (local files, HLS streams, remote APIs)
2. **Decorator Pattern** - Dynamic feature plugins (subtitles, equalizer, watermarking)
3. **Composite Pattern** - Hierarchical playlist management with nested playlists
4. **Bridge Pattern** - Runtime switching between hardware and software rendering
5. **Proxy Pattern** - Transparent caching of remote media streams

### Features

- **Multiple Media Sources**: Support for local files, HLS streams, and remote API content
- **Dynamic Feature Plugins**: Runtime composition of features using decorators
- **Composite Playlists**: Nested playlist structures with uniform treatment
- **Flexible Rendering**: Runtime switching between hardware and software rendering
- **Intelligent Caching**: Transparent caching of remote content

### How to Run

#### 🌐 Web Application (Recommended for Video Recording)

**Quick Start**:
1. **Open the web application**:
   - Navigate to your project folder
   - Double-click `index.html` to open in your browser
   - Or use a local server: `python -m http.server 8000` then visit `http://localhost:8000`

2. **Start demonstrating**:
   - Upload real files by dragging and dropping
   - Use demo scenario buttons for guided demonstrations
   - All interactions are logged in real-time

**Features**:
- 📁 **Real file upload/download** - Drag and drop your own files
- 🎨 **Interactive decorators** - Toggle features and see them applied
- 🌉 **Runtime rendering switch** - Switch between hardware/software
- 🔄 **Live caching demo** - See cache hits and misses
- 📋 **Playlist management** - Build playlists with different source types

#### 💻 Java Applications (Alternative)

**Command Line Demo** (Recommended):
```bash
javac -d bin src/legacy/*.java src/refactored/*.java
java -cp bin refactored.ModularMediaStreamingSuite
```

**Java GUI Version** (Optional):
```bash
javac -d bin src/java-demo/App.java src/java-demo/gui/*.java src/legacy/*.java src/refactored/*.java
java -cp bin java-demo.App
```

### Expected Output

The application will demonstrate:
- Legacy code execution showing monolithic design issues
- Refactored code execution showing clean pattern-based architecture
- All five structural design patterns in action
- Comparison between legacy and refactored approaches

### Key Improvements

**Legacy Issues Addressed**:
- ❌ Code duplication across media source handlers
- ❌ Tightly coupled feature toggles
- ❌ No plugin mechanism
- ❌ Monolithic playlist handling
- ❌ Scattered rendering logic
- ❌ No caching mechanism

**Refactored Solutions**:
- ✅ Unified media source interface (Adapter)
- ✅ Dynamic feature composition (Decorator)
- ✅ Hierarchical playlist structure (Composite)
- ✅ Flexible rendering strategies (Bridge)
- ✅ Transparent caching (Proxy)

### Video Demo Features

The interactive GUI is specifically designed for video demonstration:

- **🎥 Live Interactions**: Click buttons to demonstrate each pattern
- **📊 Real-time Output**: See pattern behavior in the output area
- **🎨 Modern UI**: Dark theme with color-coded sections
- **🔄 Reset Functionality**: Run multiple demos in one session
- **📋 Demo Scenarios**: Pre-built scenarios for each pattern

### Documentation

See the `docs/` folder for detailed documentation:
- **Architecture Overview**: High-level system design
- **UML Diagrams**: Visual representation of class relationships
- **Sequence Diagrams**: Core flow interactions
- **Design Rationale**: Detailed explanation of pattern choices
- **Video Demo Script**: Complete script for 12-minute video recording

### Learning Objectives

This project demonstrates:
- How structural patterns solve real architectural problems
- The transformation from legacy to modern design
- Pattern composition and interaction
- Clean code principles and SOLID design
- Documentation of design decisions

### Requirements Met

✅ **Multiple media sources** - Adapter pattern provides unified interface  
✅ **Feature plugins** - Decorator pattern enables dynamic composition  
✅ **Composite playlists** - Composite pattern supports nested structures  
✅ **Runtime rendering switching** - Bridge pattern allows strategy changes  
✅ **Remote caching** - Proxy pattern provides transparent caching  
✅ **Documentation** - Complete docs folder with all required deliverables  
✅ **Git repository** - Source code with meaningful structure  
✅ **Clear README** - Comprehensive project documentation  

### Author

Laboratory 2 - Structural Design Patterns  
Software Engineering Course