#!/bin/sh
set -euo pipefail

dirs=(src test)

for dir in ${dirs[@]}; do
  d="$1/$dir/resources"
  f=$d/.keep

  mkdir -p $d &&
  touch $f &&
  git add -f $f
done
