# Video Presentation Guide - Laboratory 2

## File Organization for Clean Video Walkthrough

### 📁 Project Structure Overview

```
lab 2/
├── src/
│   ├── legacy/                    ⭐ START HERE - Show "Before"
│   │   └── LegacyMediaPlayer.java
│   │
│   └── refactored/                ⭐ MAIN FOCUS - Show "After"
│       ├── ModularMediaStreamingSuite.java  (Main demo)
│       │
│       ├── [ADAPTER PATTERN]       Pattern 1
│       │   ├── MediaSource.java
│       │   ├── LocalFileSource.java
│       │   ├── HLSStreamSource.java
│       │   └── RemoteAPISource.java
│       │
│       ├── [DECORATOR PATTERN]     Pattern 2
│       │   ├── MediaPlayer.java
│       │   ├── BasicMediaPlayer.java
│       │   ├── MediaPlayerDecorator.java
│       │   ├── SubtitleDecorator.java
│       │   ├── EqualizerDecorator.java
│       │   └── WatermarkDecorator.java
│       │
│       ├── [COMPOSITE PATTERN]     Pattern 3
│       │   ├── PlaylistItem.java
│       │   ├── MediaItem.java
│       │   └── Playlist.java
│       │
│       ├── [BRIDGE PATTERN]        Pattern 4
│       │   ├── RenderingEngine.java
│       │   ├── HardwareRenderingEngine.java
│       │   ├── SoftwareRenderingEngine.java
│       │   ├── MediaRenderer.java
│       │   ├── VideoRenderer.java
│       │   └── AudioRenderer.java
│       │
│       └── [PROXY PATTERN]         Pattern 5
│           ├── MediaStream.java
│           ├── RealMediaStream.java
│           └── CachedMediaStream.java
│
├── docs/                           ⭐ DOCUMENTATION
│   ├── architecture-overview.md
│   ├── uml-class-diagrams.md
│   ├── sequence-diagrams.md
│   └── design-rationale.md
│
└── index.html                      ⭐ WEB DEMO (Optional)
```

## 🎬 Recommended Video Presentation Flow

### Part 1: Introduction (1 minute)
1. Show project structure
2. Explain the problem: Legacy monolithic code needs refactoring
3. Mention 5 structural patterns will be used

### Part 2: Legacy Code Analysis (1-2 minutes)
**File to open**: `src/legacy/LegacyMediaPlayer.java`
- Show code duplication
- Point out tight coupling
- Highlight lack of extensibility

### Part 3: Pattern Walkthrough (6-8 minutes)

#### Pattern 1: Adapter (1 minute)
**Files to show**:
1. `MediaSource.java` - Interface
2. `LocalFileSource.java` - Adapter example
3. `HLSStreamSource.java` - Another adapter
4. `RemoteAPISource.java` - Third adapter

**Key points**: Unified interface, eliminates duplication

#### Pattern 2: Decorator (1.5 minutes)
**Files to show**:
1. `MediaPlayer.java` - Component interface
2. `BasicMediaPlayer.java` - Concrete component
3. `MediaPlayerDecorator.java` - Base decorator
4. `SubtitleDecorator.java` - Example decorator
5. Show how decorators can be stacked

**Key points**: Dynamic feature composition, runtime flexibility

#### Pattern 3: Composite (1 minute)
**Files to show**:
1. `PlaylistItem.java` - Component interface
2. `MediaItem.java` - Leaf
3. `Playlist.java` - Composite

**Key points**: Uniform treatment, recursive structure

#### Pattern 4: Bridge (1.5 minutes)
**Files to show**:
1. `RenderingEngine.java` - Implementation interface
2. `HardwareRenderingEngine.java` - Implementation
3. `SoftwareRenderingEngine.java` - Implementation
4. `MediaRenderer.java` - Abstraction
5. `VideoRenderer.java` - Refined abstraction

**Key points**: Separation of concerns, runtime switching

#### Pattern 5: Proxy (1 minute)
**Files to show**:
1. `MediaStream.java` - Subject interface
2. `RealMediaStream.java` - Real subject
3. `CachedMediaStream.java` - Proxy

**Key points**: Transparent caching, lazy loading

### Part 4: Integration Demo (1-2 minutes)
**File to open**: `src/refactored/ModularMediaStreamingSuite.java`
- Show main() method
- Run the demo
- Show all patterns working together

### Part 5: Documentation (1 minute)
**Files to show**:
1. `docs/uml-class-diagrams.md` - Visual structure
2. `docs/sequence-diagrams.md` - Interaction flows
3. `docs/design-rationale.md` - Pattern explanations

## 🎯 Quick Navigation Tips

### For Code Walkthrough:
- Use VS Code file explorer
- Group files by pattern mentally
- Use "Go to File" (Ctrl+P) to quickly jump

### For Documentation:
- Keep docs/ folder open in sidebar
- Switch between code and docs tabs

### For Demo:
- Have terminal ready to compile/run
- Keep output visible

## 📝 Files NOT Needed for Web Presentation

The following are Java-specific and not used by the web app:
- `src/java-demo/` - Java GUI application (kept separate)
- `bin/` - Compiled classes (can be regenerated)

The web app (`index.html`) is standalone and doesn't use Java classes.

