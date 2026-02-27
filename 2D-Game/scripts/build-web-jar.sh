#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
BUILD_DIR="$ROOT_DIR/.build/web-jar"

rm -rf "$BUILD_DIR"
mkdir -p "$BUILD_DIR" "$ROOT_DIR/web"

javac -d "$BUILD_DIR" $(find "$ROOT_DIR/src" -name "*.java")

if [ -d "$ROOT_DIR/res" ]; then
  cp -R "$ROOT_DIR/res/"* "$BUILD_DIR"/
fi

jar cfe "$ROOT_DIR/web/2d-game.jar" main.Main -C "$BUILD_DIR" .

echo "Built: $ROOT_DIR/web/2d-game.jar"
