# Web Application Setup Guide

## Quick Start (Recommended)

### Method 1: Direct File Opening
1. **Open the web application**:
   - Navigate to your project folder
   - Double-click `index.html` to open in your default browser
   - Or right-click → "Open with" → Choose your preferred browser

2. **Start demonstrating**:
   - Upload files by dragging and dropping or clicking the upload area
   - Use the demo scenario buttons for guided demonstrations
   - All interactions are logged in the output area

### Method 2: Local Server (For Advanced Features)

#### Using Python (if installed):
```bash
# Navigate to project directory
cd "C:\Users\Inxomnia\OneDrive\Documents\Sir Clint Integ\lab 2\lab 2"

# Start local server
python -m http.server 8000

# Open browser to: http://localhost:8000
```

#### Using Node.js (if installed):
```bash
# Install a simple server
npm install -g http-server

# Start server
http-server -p 8000

# Open browser to: http://localhost:8000
```

#### Using VS Code Live Server Extension:
1. Install "Live Server" extension in VS Code
2. Right-click on `index.html`
3. Select "Open with Live Server"

## Features Available

### 🎥 Perfect for Video Recording
- **Real file upload/download** - Drag and drop files
- **Interactive pattern demos** - Click buttons to see patterns in action
- **Live output logging** - All actions are logged in real-time
- **Pre-built scenarios** - Ready-to-use demo sequences

### 📁 File Management (Adapter Pattern)
- Upload local files (MP4, MP3, AVI, MOV, WAV)
- Add HLS streams via URL
- Add remote API endpoints
- Download playlist as JSON

### 🎨 Feature Controls (Decorator Pattern)
- Toggle subtitles, equalizer, watermark
- See real-time decorator application
- Dynamic feature composition

### 🌉 Rendering Engine (Bridge Pattern)
- Switch between hardware/software rendering
- Runtime strategy changes
- Visual feedback for switches

### 🔄 Caching System (Proxy Pattern)
- Enable/disable caching
- Cache hit/miss demonstrations
- Transparent caching behavior

### 📋 Playlist Management (Composite Pattern)
- Add multiple media sources
- Hierarchical playlist structure
- Play individual items or entire playlist

## Demo Scenarios for Video Recording

### 1. Full Pattern Demo (2-3 minutes)
Click "Full Pattern Demo" button to see all 5 patterns explained sequentially.

### 2. Individual Pattern Demos (1-2 minutes each)
- **Composite Pattern**: Add files and play playlist
- **Decorator Pattern**: Toggle features and see them applied
- **Bridge Pattern**: Switch rendering engines
- **Proxy Pattern**: Enable caching and see behavior
- **Adapter Pattern**: Add different source types

### 3. Live Interaction Demo (4-5 minutes)
- Upload real files from your computer
- Build a playlist with different source types
- Toggle decorators while playing
- Switch rendering engines
- Demonstrate caching with remote content

## Browser Compatibility
- ✅ Chrome (recommended)
- ✅ Firefox
- ✅ Edge
- ✅ Safari
- ✅ Mobile browsers

## Troubleshooting

### Files not uploading?
- Make sure you're using a modern browser
- Try the local server method for better file handling
- Check browser console for errors (F12)

### Demo not working?
- Refresh the page
- Clear browser cache
- Try a different browser

### Need more features?
- The web app is designed for demonstration purposes
- For production use, consider adding a backend server
- Current implementation focuses on pattern demonstration

## Video Recording Tips

1. **Screen Resolution**: Use 1920x1080 for best quality
2. **Browser Zoom**: Set to 100% for optimal UI
3. **Demo Flow**: 
   - Start with architectural overview (use UML diagrams)
   - Show code walkthrough (open source files)
   - Use web app for live interactions
   - End with reflection on trade-offs
4. **Audio**: Ensure microphone is working for narration
5. **Backup**: Have the command-line Java version ready as backup
