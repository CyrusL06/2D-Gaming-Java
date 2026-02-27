# 2D Adventure Browser Wrapper

This folder contains the browser wrapper for running the Java Swing game with CheerpJ.

## Build the browser JAR

From the project root:

```bash
bash scripts/build-web-jar.sh
```

This creates:

- `web/2d-game.jar`

## Run locally

From this `web` folder:

```bash
cd web
python3 -m http.server 8080
```

Open:

- `http://127.0.0.1:8080`

## Deploy

For Cloudflare Pages, deploy this folder as static output:

- Output directory: `web`

## Controls

- `W` = move up
- `A` = move left
- `S` = move down
- `D` = move right
