# 2D Adventure Browser Build (Static Canvas)

This browser build is static HTML/CSS/JS and does not require Java runtime in the browser.
It loads:

- `maps/worldmap.txt`
- `tiles/*.png` (tile IDs in the map)
- `player2/*.png` (player animation sprites)

## Local Test (Required HTTP)

Run from project root:

```bash
cd web
python3 -m http.server 8080
```

Open:

- `http://127.0.0.1:8080`

Do not open `index.html` directly using `file://` because map loading uses `fetch`.

## Controls

- `W` = up
- `A` = left
- `S` = down
- `D` = right

## Cloudflare Pages (Manual Direct Upload)

1. Zip the contents of `web/` (or select all files inside `web/`).
2. In Cloudflare Pages, open your project and click `Create deployment`.
3. Choose `Direct Upload`.
4. Upload the `web/` contents as the site root.
5. Wait for deploy to finish and open the provided URL.

After redeploy, hard refresh (`Ctrl+Shift+R` on Windows/Linux, `Cmd+Shift+R` on macOS) or test in an incognito window.

## Notes

- Map file format is space-separated tile IDs per row.
- Unknown tile IDs fall back to tile `0` to prevent runtime crashes.
