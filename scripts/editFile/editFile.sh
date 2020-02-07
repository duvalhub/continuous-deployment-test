#!/bin/bash
file_to_edit="src/App.js"
place_holder="#####"
uuid=$(uuidgen)
sed -i -E "s/$place_holder(.+)$place_holder/$place_holder$uuid$place_holder/" $file_to_edit
git config --global user.email "toto-africa@email.com"
git config --global user.name "Toto Africa"
git add $file_to_edit
git commit -m "Commit on toto"
git push