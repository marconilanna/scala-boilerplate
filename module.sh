#!/bin/sh
set -euo pipefail

dirs=(src test)

for module in "$@"; do
  for dir in ${dirs[@]}; do
    d="$module/$dir/resources"
    f=$d/.keep

    mkdir -p $d &&
    touch $f &&
    git add -f $f
  done
done
