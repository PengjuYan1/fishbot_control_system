#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR=$(cd "$(dirname "$0")/.." && pwd)
BUILD_DIR="$ROOT_DIR/build"
CONFIG_PATH="${1:-$ROOT_DIR/config/app.example.yaml}"

cmake -S "$ROOT_DIR" -B "$BUILD_DIR"
cmake --build "$BUILD_DIR"
exec "$BUILD_DIR/fishbot_app" "$CONFIG_PATH"
