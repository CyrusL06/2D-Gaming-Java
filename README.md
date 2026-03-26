# 2D Gaming Java

A **2D adventure game project built in Java Swing**, with two browser-oriented delivery paths included in the repository that took me months to figure out: 

- a **desktop Java version** powered by Swing
- a **static browser build** inside `web/`
- a **Webswing-based browser deployment** inside `webswing/`

This project is a solid starter template for learning how **tile maps, sprite animation, keyboard input, and a game loop** work together in a simple 2D game.

---

## Overview

The core game is written in Java and opens a Swing window titled **2D Adventure**. The game renders a tiled map, loads player sprites from resource folders, and updates movement through a continuous game loop.

At its current stage, the project focuses on the fundamentals:

- tile-based world rendering
- keyboard movement with **W / A / S / D**
- player sprite animation by direction
- map loading from a text file
- alternative browser deployment options

This makes the repository especially useful for:

- students learning Java game development
- beginners who want to understand how 2D engines are structured
- developers experimenting with turning a desktop game into a browser-playable experience

---

## Main Features

### Desktop Java Game
- Built with **Java Swing** and `JPanel` rendering
- Uses a dedicated **game thread** for updating and repainting the scene
- Draws a **16 x 12 tile viewport**
- Uses scaled **16x16 tiles** enlarged for retro-style visuals
- Loads world data from `worldmap.txt`

### Player System
- Player inherits from a shared `Entity` class
- Supports directional movement:
  - up
  - down
  - left
  - right
- Uses sprite swapping to simulate walking animation
- Keeps animation logic simple and beginner-readable

### Tile System
- Loads tile images into a tile manager
- Reads tile IDs from a map text file
- Draws the world tile-by-tile on screen
- Clean separation between **map data**, **tile assets**, and **rendering logic**

### Browser Delivery Options
- `web/` contains a **static HTML/CSS/JS browser version**
- `webswing/` contains a **Webswing setup** to stream the Swing app in the browser
- Build scripts are included for packaging the project into runnable JAR files

---

## Tech Stack

- **Java**
- **Java Swing / AWT**
- **HTML / CSS / JavaScript** (browser build)
- **Webswing** (browser streaming for Swing)
- **Shell scripts** for packaging and launch helpers

---

## Project Structure

```text
2D-Gaming-Java/
└── 2D-Game/
    ├── res/
    │   ├── maps/
    │   ├── player/
    │   ├── player2/
    │   └── tiles/
    ├── scripts/
    │   ├── build-web-jar.sh
    │   ├── build-webswing-jar.sh
    │   └── run-webswing-local.sh
    ├── src/
    │   ├── entity/
    │   │   ├── Entity.java
    │   │   └── Player.java
    │   ├── main/
    │   │   ├── GamePanel.java
    │   │   ├── KeyHandler.java
    │   │   └── Main.java
    │   └── tile/
    │       ├── Tile.java
    │       └── TileManager.java
    ├── web/
    │   ├── index.html
    │   ├── README.md
    │   ├── maps/
    │   ├── player/
    │   ├── player2/
    │   └── tiles/
    └── webswing/
        ├── README.md
        └── webswing.config
```

---

## How the Java Version Works

### 1. Application startup
`Main.java` creates the game window, attaches the `GamePanel`, and starts the game thread.

### 2. Game panel setup
`GamePanel.java` defines:
- tile size
- screen dimensions
- FPS target
- the tile manager
- the player object
- the repaint/update loop

### 3. Input handling
`KeyHandler.java` listens for keyboard input and toggles movement booleans when the player presses or releases **W, A, S, or D**.

### 4. Player updates
`Player.java` reads the input flags, updates position, changes facing direction, and alternates between sprite frames while moving.

### 5. Tile rendering
`TileManager.java` loads tile images and parses the map file. During drawing, it places each tile in the correct screen position.

### 6. Frame rendering
`paintComponent()` draws the map first, then the player on top.

---

## Simple Architecture Diagram

```text
┌─────────────┐
│   Main.java │
└──────┬──────┘
       │ creates window + starts game
       ▼
┌──────────────────┐
│   GamePanel.java │
│ game loop + draw │
└──────┬─────┬─────┘
       │     │
       │     ├──────────────────────┐
       │                            │
       ▼                            ▼
┌───────────────┐           ┌────────────────┐
│ KeyHandler    │           │ TileManager    │
│ keyboard input│           │ map + tiles    │
└──────┬────────┘           └──────┬─────────┘
       │                           │
       ▼                           ▼
┌───────────────┐           ┌────────────────┐
│ Player        │           │ worldmap.txt   │
│ movement +    │           │ tile data      │
│ sprite anim   │           └────────────────┘
└──────┬────────┘
       │
       ▼
┌────────────────┐
│ Render to      │
│ Swing window   │
└────────────────┘
```

---

## Controls

### Desktop / Java Version
- `W` = move up
- `A` = move left
- `S` = move down
- `D` = move right

### Browser Build
The browser version keeps the same **WASD** controls and also includes mobile-friendly on-screen controls in its HTML interface.

---

## Getting Started

## Option 1: Run in an IDE
This is the easiest path for most beginners.

### Requirements
- JDK **17+** recommended
- IntelliJ IDEA, Eclipse, or another Java IDE

### Steps
1. Clone or download the repository.
2. Open the `2D-Game` folder in your IDE.
3. Make sure the `res/` folder is available on the runtime classpath.
4. Run:

```java
main.Main
```

---

## Option 2: Run the Static Browser Build
The repository includes a browser version inside `2D-Game/web/`.

### Local preview
From inside the `web` folder, run:

```bash
python3 -m http.server 8080
```

Then open:

```text
http://127.0.0.1:8080
```

> Do not open the file directly with `file://`, because the map is loaded with `fetch()`.

---

## Option 3: Build a JAR for Browser Streaming with Webswing

### Build the JAR
```bash
bash scripts/build-webswing-jar.sh
```

### Start Webswing locally
```bash
WEBSWING_HOME="$HOME/webswing-25.2" bash scripts/run-webswing-local.sh
```

### Open in browser
- App: `http://127.0.0.1:8080/2d-game`
- Admin: `http://127.0.0.1:8080/admin`

---

## Build Scripts Included

### `scripts/build-web-jar.sh`
Compiles the Java source, copies resource files, and packages a JAR into the `web/` folder.

### `scripts/build-webswing-jar.sh`
Builds a JAR for the Webswing deployment path and outputs it into `webswing/apps/`.

### `scripts/run-webswing-local.sh`
Launches a local Webswing server using the repository’s configuration.

---

## Current Scope

This project is currently centered on **core 2D movement and rendering fundamentals** rather than a full gameplay system.

What is already present:
- game window setup
- update/render loop
- tile drawing
- sprite-based movement animation
- map file loading
- browser build support

What would be natural next improvements:
- collision detection
- world scrolling / camera system
- NPCs or enemies
- interaction system
- combat
- UI / HUD
- sound effects and music
- larger world support beyond the current fixed viewport logic

---

## Why This Project Is Good for Learning

This repository is valuable because it shows the beginner game-dev pipeline clearly:

1. **Read input**
2. **Update the player**
3. **Draw the map**
4. **Draw the player**
5. **Repeat many times per second**

That loop is the heart of many 2D games.

---

## Suggested Improvements for the Next Version

- Add collision checks using the existing tile/entity structure
- Separate update logic from rendering even further for cleaner scaling
- Add a camera so the player can move through a larger world
- Support more tile types and map sections
- Add animation states such as idle, attack, or interact
- Introduce game states such as menu, pause, and play

---

## Acknowledgment

This project is a strong foundation for learning **Java 2D game architecture** in a practical way. It keeps the code approachable while still introducing the real building blocks used in game development.

If you are continuing this project, the next big step is turning it from a movement demo into a fuller game system with collision, interaction, and world progression.
