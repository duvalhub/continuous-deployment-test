#!/bin/bash
file_to_edit="$FILE_TO_EDIT"
uuid="$UUID"
echo "$uuid" > $file_to_edit
#sed -i -E "s/$place_holder(.+)$place_holder/$place_holder$uuid$place_holder/" $file_to_edit
git config --global user.email "toto-africa@email.com"
git config --global user.name "Toto Africa"
git add $file_to_edit
git commit -m "Edited '$file_to_edit' with uuid '$uuid' between place holder '$place_holder'"
git push
