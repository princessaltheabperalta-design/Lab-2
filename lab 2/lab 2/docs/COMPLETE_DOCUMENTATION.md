# Laboratory 2: Structural Design Patterns
## Complete Documentation - All Deliverables

**Modular Media Streaming Suite**  
Complete documentation package for Laboratory 2 submission.

---

# 1. Architecture Overview

## Modular Media Streaming Suite

The Modular Media Streaming Suite is a refactored media player application that demonstrates the effective use of structural design patterns to transform a monolithic legacy codebase into a flexible, extensible system.

### Key Components

1. **Media Sources** - Handles different input types (local files, HLS streams, remote APIs)
2. **Feature Plugins** - Modular enhancements (subtitles, equalizer, watermarking)
3. **Playlist Management** - Composite structure for organizing media items
4. **Rendering Engine** - Bridge pattern for hardware/software rendering
5. **Caching System** - Proxy pattern for remote stream caching

### Design Principles

- **Separation of Concerns**: Each pattern addresses a specific architectural concern
- **Open/Closed Principle**: System is open for extension, closed for modification
- **Single Responsibility**: Each class has one reason to change
- **Composition over Inheritance**: Favoring object composition for flexibility

### Benefits of Refactoring

- **Extensibility**: New media sources and features can be added without modifying existing code
- **Maintainability**: Clear separation makes debugging and updates easier
- **Testability**: Individual components can be tested in isolation
- **Reusability**: Components can be reused in different configurations
- **Flexibility**: Runtime behavior changes are possible through pattern composition

---

# 2. UML Class Diagrams

## Adapter Pattern - Media Sources

```
┌─────────────────┐
│   MediaSource   │
├─────────────────┤
│ + play()        │
│ + getSourceInfo()│
└─────────────────┘
         ▲
         │
    ┌────┴────┐
    │         │
┌───▼───┐ ┌───▼───┐ ┌─────────┐
│Local  │ │ HLS   │ │ Remote  │
│File   │ │Stream │ │ API     │
│Source │ │Source │ │ Source  │
└───────┘ └───────┘ └─────────┘
```

## Decorator Pattern - Feature Plugins

```
┌─────────────────┐
│   MediaPlayer   │
├─────────────────┤
│ + play()        │
│ + getDescription()│
└─────────────────┘
         ▲
         │
    ┌────┴────┐
    │         │
┌───▼───┐ ┌───▼─────────────┐
│Basic  │ │ MediaPlayer     │
│Player │ │ Decorator       │
└───────┘ ├─────────────────┤
          │ # player        │
          └─────────────────┘
                   ▲
                   │
        ┌──────────┼──────────┐
        │          │          │
┌───────▼───┐ ┌────▼───┐ ┌────▼────┐
│Subtitle   │ │Equalizer│ │Watermark│
│Decorator  │ │Decorator│ │Decorator│
└───────────┘ └─────────┘ └─────────┘
```

## Composite Pattern - Playlists

```
┌─────────────────┐
│  PlaylistItem   │
├─────────────────┤
│ + play()        │
│ + getName()     │
└─────────────────┘
         ▲
         │
    ┌────┴────┐
    │         │
┌───▼───┐ ┌───▼────┐
│Media  │ │Playlist│
│Item   │ │        │
├───────┤ ├────────┤
│-player│ │-items  │
│-name  │ │+addItem()│
└───────┘ │+removeItem()│
          └────────┘
```

## Bridge Pattern - Rendering

```
┌─────────────────┐
│ RenderingEngine │
├─────────────────┤
│ + render()      │
└─────────────────┘
         ▲
         │
    ┌────┴────┐
    │         │
┌───▼───┐ ┌───▼────┐
│Hardware│ │Software│
│Engine  │ │Engine  │
└───────┘ └────────┘
         ▲
         │
┌────────▼────────┐
│  MediaRenderer  │
├─────────────────┤
│ # engine        │
│ + renderMedia() │
└─────────────────┘
         ▲
         │
    ┌────┴────┐
    │         │
┌───▼───┐ ┌───▼────┐
│Video  │ │Audio   │
│Renderer│ │Renderer│
└───────┘ └────────┘
```

## Proxy Pattern - Caching

```
┌─────────────────┐
│   MediaStream   │
├─────────────────┤
│ + stream()      │
│ + getContent()  │
└─────────────────┘
         ▲
         │
    ┌────┴────┐
    │         │
┌───▼───┐ ┌───▼─────────────┐
│Real   │ │ CachedMediaStream│
│Stream │ │                 │
├───────┤ ├─────────────────┤
│-content│ │ -realStream    │
└───────┘ │ -isCached      │
          └─────────────────┘
```

---

# 3. Sequence Diagrams

## Core Flow 1: Play Media with Decorator Stack

This sequence diagram demonstrates the Decorator pattern in action, showing how multiple decorators are stacked to add features dynamically.

```
Client -> BasicMediaPlayer: new BasicMediaPlayer(source)
Client -> SubtitleDecorator: new SubtitleDecorator(player)
Client -> EqualizerDecorator: new EqualizerDecorator(subtitlePlayer)
Client -> WatermarkDecorator: new WatermarkDecorator(equalizerPlayer)

Client -> WatermarkDecorator: play()
WatermarkDecorator -> EqualizerDecorator: play()
EqualizerDecorator -> SubtitleDecorator: play()
SubtitleDecorator -> BasicMediaPlayer: play()
BasicMediaPlayer -> MediaSource: play()
MediaSource -> Console: "Playing media..."

BasicMediaPlayer -> Console: "Media played"
SubtitleDecorator -> Console: "Applying subtitles..."
EqualizerDecorator -> Console: "Applying audio equalizer..."
WatermarkDecorator -> Console: "Applying watermark..."
```

## Core Flow 2: Composite Playlist Playback

This sequence diagram demonstrates the Composite pattern, showing how playlists and individual media items are treated uniformly, and how nested playlists work.

```
Client -> Playlist: new Playlist("Main Playlist")
Client -> MediaItem: new MediaItem(player1, "Movie 1")
Client -> MediaItem: new MediaItem(player2, "Movie 2")
Client -> Playlist: addItem(mediaItem1)
Client -> Playlist: addItem(mediaItem2)

Client -> SubPlaylist: new Playlist("Music Videos")
Client -> MediaItem: new MediaItem(musicPlayer, "Music Video")
Client -> SubPlaylist: addItem(musicItem)
Client -> Playlist: addItem(subPlaylist)

Client -> Playlist: play()
Playlist -> Console: "Playing playlist: Main Playlist"

Playlist -> MediaItem: play()
MediaItem -> MediaPlayer: play()
MediaPlayer -> Console: "Playing: Movie 1"

Playlist -> MediaItem: play()
MediaItem -> MediaPlayer: play()
MediaPlayer -> Console: "Playing: Movie 2"

Playlist -> SubPlaylist: play()
SubPlaylist -> Console: "Playing playlist: Music Videos"
SubPlaylist -> MediaItem: play()
MediaItem -> MediaPlayer: play()
MediaPlayer -> Console: "Playing: Music Video"
```

## Core Flow 3: Bridge Pattern - Runtime Rendering Switch

This sequence diagram demonstrates the Bridge pattern, showing how rendering engines can be switched at runtime.

```
Client -> HardwareEngine: new HardwareRenderingEngine()
Client -> SoftwareEngine: new SoftwareRenderingEngine()
Client -> VideoRenderer: new VideoRenderer(hardwareEngine)

Client -> VideoRenderer: renderMedia("video.mp4")
VideoRenderer -> HardwareEngine: render("Video: video.mp4")
HardwareEngine -> Console: "Hardware rendering: Video: video.mp4"

Client -> VideoRenderer: setRenderingEngine(softwareEngine)
VideoRenderer -> VideoRenderer: engine = softwareEngine

Client -> VideoRenderer: renderMedia("video.mp4")
VideoRenderer -> SoftwareEngine: render("Video: video.mp4")
SoftwareEngine -> Console: "Software rendering: Video: video.mp4"
```

## Core Flow 4: Proxy Pattern - Caching Behavior

This sequence diagram demonstrates the Proxy pattern, showing how caching works transparently.

```
Client -> CachedStream: new CachedMediaStream("movie.mp4")

Client -> CachedStream: stream()
CachedStream -> CachedStream: check isCached (false)
CachedStream -> Console: "Cache miss - loading from remote"
CachedStream -> RealStream: new RealMediaStream("movie.mp4")
RealStream -> Console: "Loading media stream: movie.mp4"
CachedStream -> CachedStream: isCached = true
CachedStream -> RealStream: stream()
RealStream -> Console: "Streaming: movie.mp4"

Client -> CachedStream: stream()
CachedStream -> CachedStream: check isCached (true)
CachedStream -> Console: "Cache hit - serving from cache"
CachedStream -> RealStream: stream()
RealStream -> Console: "Streaming: movie.mp4"
```

---

# 4. Design Rationale

## Structural Design Patterns Implementation

This document explains the rationale behind using specific structural design patterns in the Modular Media Streaming Suite refactoring.

### 1. Adapter Pattern - Media Source Integration

**Problem**: The legacy code had duplicated adaptation logic for different media sources (local files, HLS streams, remote APIs), leading to code duplication and tight coupling.

**Solution**: Implemented the Adapter pattern with a common `MediaSource` interface that all source types implement.

**Why Adapter**: 
- Eliminates code duplication by providing a unified interface
- Allows adding new media source types without modifying existing code
- Follows the Open/Closed Principle - open for extension, closed for modification
- Makes the system more testable by allowing mock implementations

**Implementation**: `LocalFileSource`, `HLSStreamSource`, and `RemoteAPISource` all implement the `MediaSource` interface, providing consistent `play()` and `getSourceInfo()` methods.

### 2. Decorator Pattern - Feature Plugins

**Problem**: The legacy system had hardcoded feature toggles (subtitles, equalizer, watermark) that were tightly coupled to the main player class, making it impossible to add new features dynamically.

**Solution**: Implemented the Decorator pattern to create a flexible plugin system where features can be stacked dynamically.

**Why Decorator**:
- Enables runtime composition of features without modifying existing classes
- Allows unlimited combinations of features (subtitles + equalizer + watermark)
- Follows the Single Responsibility Principle - each decorator handles one feature
- Provides a clean way to add new features as separate classes
- Maintains the same interface while adding functionality

**Implementation**: `MediaPlayerDecorator` base class with concrete decorators (`SubtitleDecorator`, `EqualizerDecorator`, `WatermarkDecorator`) that wrap existing players and add functionality.

### 3. Composite Pattern - Playlist Management

**Problem**: The legacy code treated playlists as simple arrays, making it impossible to create nested playlists or treat individual items and playlists uniformly.

**Solution**: Implemented the Composite pattern to create a tree structure where both individual media items and playlists can be treated uniformly.

**Why Composite**:
- Enables recursive composition of playlists (playlists containing other playlists)
- Provides uniform treatment of individual items and collections
- Simplifies client code by using the same interface for both leaves and composites
- Makes it easy to add operations like "play all" or "get total duration"
- Supports complex hierarchical structures naturally

**Implementation**: `PlaylistItem` interface implemented by both `MediaItem` (leaf) and `Playlist` (composite), allowing recursive composition.

### 4. Bridge Pattern - Rendering Strategy

**Problem**: The legacy code had rendering logic scattered throughout different source handlers, making it difficult to switch between hardware and software rendering or add new rendering strategies.

**Solution**: Implemented the Bridge pattern to separate the abstraction (media rendering) from its implementation (hardware vs software engines).

**Why Bridge**:
- Enables runtime switching between different rendering implementations
- Separates concerns - media rendering logic is independent of specific engine implementation
- Makes it easy to add new rendering engines without changing existing code
- Allows different media types (video, audio) to use different rendering strategies
- Follows the Dependency Inversion Principle - depends on abstractions, not concretions

**Implementation**: `RenderingEngine` interface with `HardwareRenderingEngine` and `SoftwareRenderingEngine` implementations, used by `MediaRenderer` abstractions like `VideoRenderer` and `AudioRenderer`.

### 5. Proxy Pattern - Remote Caching

**Problem**: The legacy system had no caching mechanism, leading to repeated expensive operations for remote content.

**Solution**: Implemented the Proxy pattern to provide transparent caching of remote media streams.

**Why Proxy**:
- Provides transparent caching without changing client code
- Controls access to expensive remote operations
- Enables lazy loading - content is only fetched when needed
- Can add additional functionality (logging, access control) without modifying the real subject
- Follows the Single Responsibility Principle - separates caching concerns from media streaming

**Implementation**: `CachedMediaStream` acts as a proxy for `RealMediaStream`, intercepting calls and serving cached content when available.

### Overall Benefits

The combination of these patterns creates a highly flexible, maintainable, and extensible system that addresses all the requirements:

- **Multiple media sources**: Adapter pattern provides unified interface
- **Feature plugins**: Decorator pattern enables dynamic feature composition
- **Composite playlists**: Composite pattern supports nested playlist structures
- **Runtime rendering switching**: Bridge pattern allows dynamic strategy changes
- **Remote caching**: Proxy pattern provides transparent caching

This refactoring transforms a monolithic, tightly-coupled legacy system into a modular, loosely-coupled architecture that follows SOLID principles and design patterns best practices.

---

## Document Summary

**Word Count**: ~1,200 words total
- Architecture Overview: ~200 words
- Design Rationale: 700 words (under 800 limit)

**Deliverables Included**:
- ✅ Architecture overview (short)
- ✅ UML class diagram(s) for all 5 patterns
- ✅ Sequence diagram for at least two core flows (play media, apply decorator stack)
- ✅ Design rationale: which patterns used where and why (700 words, max 800)

**Date**: Laboratory 2 Submission  
**Project**: Modular Media Streaming Suite  
**Course**: Structural Design Patterns

