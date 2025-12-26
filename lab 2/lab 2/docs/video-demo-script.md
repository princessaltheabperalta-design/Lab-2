# Video Demo Script - Laboratory 2: Structural Design Patterns

## Pre-Recording Setup (2 minutes)
1. **Screen Setup**: 
   - Set screen resolution to 1920x1080
   - Close unnecessary applications
   - Prepare UML diagrams in separate windows/tabs

2. **Application Launch**:
   ```bash
   javac -d bin src/App.java src/gui/*.java src/legacy/*.java src/refactored/*.java
   java -cp bin App
   ```

## Recording Script (12 minutes total)

### 1. Architectural Explanation (60-90 seconds)
**Screen**: Show UML diagrams from docs/uml-class-diagrams.md

**Script**:
"Welcome to my Laboratory 2 demonstration of structural design patterns. I've refactored a legacy media player into a modular streaming suite using five key patterns.

First, let's look at the architecture. The Adapter pattern provides a unified interface for different media sources - local files, HLS streams, and remote APIs. The Decorator pattern enables dynamic feature composition - we can stack subtitles, equalizer, and watermark features at runtime.

The Composite pattern handles hierarchical playlists, allowing nested structures. The Bridge pattern separates rendering abstraction from implementation, enabling runtime switching between hardware and software rendering. Finally, the Proxy pattern provides transparent caching of remote streams.

Now let's see this in action with the interactive demo."

### 2. Live Code Walkthrough (4-6 minutes)
**Screen**: Show source code files

**Script**:
"Let me walk through the key classes. In the refactored package, we have the MediaSource interface that all adapters implement. Here's LocalFileSource, HLSStreamSource, and RemoteAPISource - each adapting different media types to a common interface.

The Decorator pattern is implemented through MediaPlayerDecorator base class. Notice how SubtitleDecorator, EqualizerDecorator, and WatermarkDecorator wrap existing players and add functionality without modifying them.

The Composite pattern uses PlaylistItem interface implemented by both MediaItem and Playlist, allowing recursive composition. The Bridge pattern separates MediaRenderer from RenderingEngine implementations.

Finally, the Proxy pattern with CachedMediaStream controlling access to RealMediaStream for transparent caching."

### 3. Live Interactive Demo (4-5 minutes)
**Screen**: Show GUI application

**Script**:
"Now for the live demo. First, let's assemble a playlist using the Composite pattern. I'll add a local file, an HLS stream, and a remote API source. Notice how the playlist grows dynamically.

Next, let's toggle decorators. I'll enable subtitles, equalizer, and watermark. The Decorator pattern allows us to combine these features dynamically.

Now let's switch renderers using the Bridge pattern. I'll switch from software to hardware rendering, demonstrating runtime strategy changes.

Finally, let's demonstrate the Proxy pattern with caching. I'll enable caching and show how the first access loads from remote while the second serves from cache."

**Actions to perform**:
1. Add 3 items to playlist (different sources)
2. Toggle all decorators on/off
3. Switch renderer multiple times
4. Enable caching and run stream demo twice
5. Run full demo to show all patterns together

### 4. Reflection on Trade-offs (60-90 seconds)
**Screen**: Show both legacy and refactored code side-by-side

**Script**:
"Let's reflect on the trade-offs. The refactored system is much more flexible and maintainable, but comes with increased complexity. We have more classes and interfaces, which might seem like over-engineering for a simple media player.

However, the benefits outweigh the costs: we can add new media sources without changing existing code, features can be combined dynamically, and the system is highly testable. The patterns provide clear separation of concerns and follow SOLID principles.

What I'd improve: I'd add configuration management for decorator combinations, implement a plugin system for loading decorators dynamically, and add more sophisticated caching strategies with TTL and size limits. I'd also consider adding a factory pattern for creating media sources and decorators."

## Post-Recording Checklist
- [ ] Verify all patterns were demonstrated
- [ ] Check audio quality
- [ ] Ensure screen recording captured all interactions
- [ ] Test video playback

## Technical Notes
- GUI uses Java Swing with modern dark theme
- All interactions are logged to output area
- Demo scenarios are clearly labeled
- Reset functionality allows multiple demo runs
- Full demo button shows all patterns together

## Backup Plan
If GUI doesn't work, fall back to command-line demo:
```bash
java -cp bin refactored.ModularMediaStreamingSuite
```
