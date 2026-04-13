#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
BUILD_DIR="${ROOT_DIR}/build"
PACKAGE_DIR="${ROOT_DIR}/dist/fishbot_control_system"

cmake -S "${ROOT_DIR}" -B "${BUILD_DIR}"
cmake --build "${BUILD_DIR}"

rm -rf "${PACKAGE_DIR}"
mkdir -p "${PACKAGE_DIR}/bin" "${PACKAGE_DIR}/config" "${PACKAGE_DIR}/docs"

cp "${BUILD_DIR}/fishbot_app" "${PACKAGE_DIR}/bin/"
cp "${ROOT_DIR}/config/app.example.yaml" "${PACKAGE_DIR}/config/"
cp "${ROOT_DIR}/README.md" "${PACKAGE_DIR}/docs/"
cp "${ROOT_DIR}/docs/architecture/runtime-flows.md" "${PACKAGE_DIR}/docs/"

echo "Packaged to ${PACKAGE_DIR}"
