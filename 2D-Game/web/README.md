# 2D Adventure Web Test (Canvas)

This folder now runs a browser version using HTML5 Canvas and JavaScript.
No Java runtime, CheerpJ, or Webswing is required for this test page.

## Local run

From project root:

```bash
cd web
python3 -m http.server 8080
```

Open:

- `http://127.0.0.1:8080`

## Controls

- `W` = up
- `A` = left
- `S` = down
- `D` = right

## Deploy

Deploy the `web` folder as static files.

- If repo root is `2D-Gaming-Java`: output directory `2D-Game/web`
- If project root is `2D-Game`: output directory `web`
