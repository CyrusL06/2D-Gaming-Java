# Webswing Setup for 2D Adventure

This setup runs the existing Swing game in a browser through a Webswing server.

## What this changes

- No gameplay code rewrite is required.
- The app runs on a server process and streams to browser clients.
- This is not static hosting like Cloudflare Pages.

## Prerequisites

- JDK 17+ for building/running the game jar.
- Webswing distribution downloaded and extracted locally.

Reference:

- https://www.webswing.org/docs/25.2/quickstart

## 1) Build the game jar for Webswing

From project root:

```bash
bash scripts/build-webswing-jar.sh
```

Output:

- `webswing/apps/2d-game.jar`

## 2) Start Webswing with this project config

Set `WEBSWING_HOME` to your extracted Webswing folder:

```bash
WEBSWING_HOME="$HOME/webswing-25.2" bash scripts/run-webswing-local.sh
```

## 3) Open the app

- Game URL: `http://127.0.0.1:8080/2d-game`
- Admin URL: `http://127.0.0.1:8080/admin`

## Notes for deployment

- For public hosting, deploy Webswing on a VM/container (not static pages hosting).
- Keep `webswing/apps/2d-game.jar` updated by rerunning `scripts/build-webswing-jar.sh`.
