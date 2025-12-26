# Quick Start Guide

## For Video Presentation

### 1. Open Files in Order

**Start with Legacy:**
- `src/legacy/LegacyMediaPlayer.java`

**Then Show Patterns:**
- Adapter: `MediaSource.java`, `LocalFileSource.java`, `HLSStreamSource.java`, `RemoteAPISource.java`
- Decorator: `MediaPlayer.java`, `BasicMediaPlayer.java`, `MediaPlayerDecorator.java`, `SubtitleDecorator.java`, `EqualizerDecorator.java`, `WatermarkDecorator.java`
- Composite: `PlaylistItem.java`, `MediaItem.java`, `Playlist.java`
- Bridge: `RenderingEngine.java`, `HardwareRenderingEngine.java`, `SoftwareRenderingEngine.java`, `MediaRenderer.java`, `VideoRenderer.java`, `AudioRenderer.java`
- Proxy: `MediaStream.java`, `RealMediaStream.java`, `CachedMediaStream.java`

**End with Demo:**
- `src/refactored/ModularMediaStreamingSuite.java`

### 2. Compile and Run

```bash
# Compile
javac -d bin src/legacy/*.java src/refactored/*.java

# Run
java -cp bin refactored.ModularMediaStreamingSuite
```

### 3. Documentation

Open `docs/` folder:
- `uml-class-diagrams.md` - Show visual structure
- `sequence-diagrams.md` - Show interactions
- `design-rationale.md` - Explain patterns

## File Organization

- **Web App**: `index.html` (standalone, doesn't use Java)
- **Java Code**: `src/refactored/` (23 files organized by pattern)
- **Legacy Code**: `src/legacy/` (1 file for comparison)
- **Java GUI**: `src/java-demo/` (optional, separate)

## Total Files for Presentation

- Legacy: 1 file
- Refactored: 23 files
- Documentation: 4 files
- **Total: 28 essential files**

