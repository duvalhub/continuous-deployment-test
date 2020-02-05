#!/bin/bash
echo "allo" > toto
git config --global user.email "toto-africa@email.com"
git config --global user.name "Toto Africa"
git add toto
git commit -m "Commit on toto"
git push