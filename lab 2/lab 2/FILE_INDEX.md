# Quick File Index - Video Presentation

## 🎯 Essential Files for Presentation

### 1. Legacy Code (Before Refactoring)
- `src/legacy/LegacyMediaPlayer.java` - Monolithic legacy code

### 2. Refactored Code by Pattern

#### 🔌 ADAPTER PATTERN (4 files)
- `src/refactored/MediaSource.java` - Interface
- `src/refactored/LocalFileSource.java`
- `src/refactored/HLSStreamSource.java`
- `src/refactored/RemoteAPISource.java`

#### 🎨 DECORATOR PATTERN (6 files)
- `src/refactored/MediaPlayer.java` - Interface
- `src/refactored/BasicMediaPlayer.java` - Component
- `src/refactored/MediaPlayerDecorator.java` - Base decorator
- `src/refactored/SubtitleDecorator.java`
- `src/refactored/EqualizerDecorator.java`
- `src/refactored/WatermarkDecorator.java`

#### 📁 COMPOSITE PATTERN (3 files)
- `src/refactored/PlaylistItem.java` - Interface
- `src/refactored/MediaItem.java` - Leaf
- `src/refactored/Playlist.java` - Composite

#### 🌉 BRIDGE PATTERN (6 files)
- `src/refactored/RenderingEngine.java` - Interface
- `src/refactored/HardwareRenderingEngine.java`
- `src/refactored/SoftwareRenderingEngine.java`
- `src/refactored/MediaRenderer.java` - Abstraction
- `src/refactored/VideoRenderer.java`
- `src/refactored/AudioRenderer.java`

#### 🔄 PROXY PATTERN (3 files)
- `src/refactored/MediaStream.java` - Interface
- `src/refactored/RealMediaStream.java`
- `src/refactored/CachedMediaStream.java`

### 3. Main Demo
- `src/refactored/ModularMediaStreamingSuite.java` - Shows all patterns together

### 4. Documentation
- `docs/architecture-overview.md`
- `docs/uml-class-diagrams.md`
- `docs/sequence-diagrams.md`
- `docs/design-rationale.md`

### 5. Web Application
- `index.html` - Standalone web demo (doesn't use Java classes)

---

## 📦 Total File Count
- **Legacy**: 1 file
- **Refactored**: 23 files (22 classes + 1 main)
- **Documentation**: 4 files
- **Total for presentation**: 28 files

---

## 🚫 Files NOT Needed for Web/Video
- `src/java-demo/` - Java GUI (separate demo)
- `bin/` - Compiled classes (regenerated on compile)
- `test.html` - Removed (test file)

