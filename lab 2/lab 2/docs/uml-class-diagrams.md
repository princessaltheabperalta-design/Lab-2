# UML Class Diagrams

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
