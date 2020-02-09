#!/bin/bash
file_to_edit="$FILE_TO_EDIT"
uuid="$UUID"
echo -n "$uuid" > $file_to_edit
git config --global user.email "toto-africa@email.com"
git config --global user.name "Toto Africa"
git add $file_to_edit
git commit -m "Edited '$file_to_edit' with uuid '$uuid'"
git push
