# 2D Adventure Browser Wrapper

This folder contains the browser wrapper for running the Java Swing game with CheerpJ.

## Build the browser JAR

From the project root:

```bash
bash scripts/build-web-jar.sh
```

This creates:

- `web/2d-game.jar`

The build script compiles with `--release 17` for CheerpJ compatibility.

## Run locally

From this `web` folder:

```bash
cd web
python3 -m http.server 8080
```

Open:

- `http://127.0.0.1:8080`

## Deploy

For static hosting, deploy this folder as output:

- If repo root is `2D-Gaming-Java`: output directory is `2D-Game/web`
- If project root is `2D-Game`: output directory is `web`

Do not add SPA catch-all rewrites like `/* /index.html 200`, because CheerpJ needs direct byte-range access to `2d-game.jar`.

### Cloudflare Pages limitation

Cloudflare Pages currently does not return `206` for range requests; it always returns `200`.
CheerpJ requires range request support for JAR access, so plain Cloudflare Pages is not compatible with this setup.

Use one of these alternatives:

- Netlify/Vercel/GitHub Pages (if range requests return `206` for your jar)
- Cloudflare Workers + R2/object storage where range requests are properly handled

## Verify production endpoint

After deploy, run:

```bash
curl -I https://<your-site>.pages.dev/2d-game.jar
curl -I -H "Range: bytes=0-0" https://<your-site>.pages.dev/2d-game.jar
```

Expected:

- `HTTP/2 200` on the first request
- `HTTP/2 206` on the range request
- `Accept-Ranges: bytes` present

If the range request is not `206`, Cloudflare is not serving the jar correctly for CheerpJ.

## Controls

- `W` = move up
- `A` = move left
- `S` = move down
- `D` = move right
