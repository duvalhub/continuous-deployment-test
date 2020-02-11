#!/bin/bash
git fetch
version=$(git branch -a | grep release | awk -F"release/" '{print $2}')
echo "release/$version"