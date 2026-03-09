#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WS_CONFIG="$ROOT_DIR/webswing/webswing.config"

if [ -z "${WEBSWING_HOME:-}" ]; then
  echo "WEBSWING_HOME is not set."
  echo "Example: WEBSWING_HOME=$HOME/webswing-25.2 bash scripts/run-webswing-local.sh"
  exit 1
fi

LAUNCHER_JAR="$WEBSWING_HOME/server/webswing-jetty-launcher.jar"
JETTY_PROPS="$WEBSWING_HOME/jetty.properties"
ADMIN_PROPS="$WEBSWING_HOME/admin/webswing-admin.properties"
ADMIN_WAR="$WEBSWING_HOME/admin/webswing-admin-server.war"

if [ ! -f "$LAUNCHER_JAR" ]; then
  echo "Missing launcher jar: $LAUNCHER_JAR"
  exit 1
fi

if [ ! -f "$WS_CONFIG" ]; then
  echo "Missing config file: $WS_CONFIG"
  exit 1
fi

echo "Starting Webswing with config: $WS_CONFIG"
echo "App URL: http://127.0.0.1:8080/2d-game"

java \
  -jar "$LAUNCHER_JAR" \
  -j "$JETTY_PROPS" \
  -serveradmin \
  -pfa "$ADMIN_PROPS" \
  -adminctx /admin \
  -aw "$ADMIN_WAR" \
  -c "$WS_CONFIG"
