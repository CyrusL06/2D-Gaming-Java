#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
BUILD_DIR="$ROOT_DIR/.build/webswing-jar"
OUTPUT_DIR="$ROOT_DIR/webswing/apps"
OUTPUT_JAR="$OUTPUT_DIR/2d-game.jar"

rm -rf "$BUILD_DIR"
mkdir -p "$BUILD_DIR" "$OUTPUT_DIR"

javac --release 17 -d "$BUILD_DIR" $(find "$ROOT_DIR/src" -name "*.java")

if [ -d "$ROOT_DIR/res" ]; then
  cp -R "$ROOT_DIR/res/"* "$BUILD_DIR"/
fi

jar cfe "$OUTPUT_JAR" main.Main -C "$BUILD_DIR" .

echo "Built: $OUTPUT_JAR"
