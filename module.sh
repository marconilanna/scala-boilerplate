#!/bin/sh
set -euo pipefail

dirs=(src/resources test)

for dir in ${dirs[@]}; do
  d="$1/$dir"
  f=$d/.keep

  mkdir -p $d &&
  touch $f &&
  git add -f $f
done
