# 2D Retro Game (Java) — Work in Progress

A Java-based 2D retro game project focused on learning and building core game-engine fundamentals: a **nanosecond-timed game loop**, **background threading**, and **smooth rendering**.  
🚧 **This project is actively being developed** — features, structure, and performance improvements are still in progress.

---

## Status

**Current stage:** In development (WIP)  
- Core loop + timing: ✅ implemented  
- Rendering pipeline (buffered rendering / flicker reduction): ✅ in progress / improving  
- Game systems (movement, collisions, entities): ✅ partially implemented  
- Menus, levels, audio, polishing: 🚧 planned

> Expect frequent changes as I refine the loop accuracy, architecture, and gameplay systems.

---

## Why I’m Building This

This project is a hands-on way to learn:
- Real-time game loops and frame pacing
- Threading (running updates on a dedicated game thread)
- Rendering fundamentals (buffering, draw calls, consistent FPS)
- Clean architecture for entities, input, and game state
  
---

## Key Features (Implemented / In Progress)

- **Nanosecond-timed game loop** using `System.nanoTime()` to regulate FPS and maintain consistent timing  
- **Dedicated game thread** to keep UI responsive while updating game state  
- **Update + Render separation** (`update()` for logic, `repaint()/render()` for drawing)  
- **Buffered rendering / double buffering** to reduce flicker and improve visual smoothness *(still tuning)*  
- **Debug timing output** (FPS / timing logs) to validate loop performance *(still refining)*

---

## Tech Stack

- **Java**
- Concepts: Threads, Game Loop Timing, Buffered Rendering, OOP, Input Handling

---

## Project Structure 

