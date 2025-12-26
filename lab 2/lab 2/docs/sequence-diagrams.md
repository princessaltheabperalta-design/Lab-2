# Sequence Diagrams

## Core Flow 1: Play Media with Decorator Stack

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
