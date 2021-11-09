#! /bin/zsh
IMPORTS="import java.util.*;\\n\\n"
MAIN_CLASS_START="public class Runner {\\n"
MAINSTART="public static void main(String[] args) {\\n"

pbpaste | sed 's/^ *[0-9]*.//g' > input.txt

# Determine if input contains main or replace or method
[[ "$(cat input.txt)" =~ "public " ]] &&\
echo "$IMPORTS$MAIN_CLASS_START$(cat input.txt)\\n}" > Runner.java && java Runner.java > output.txt && osascript -e "display notification \"$(cat output.txt)\" with title \"Runner\""\
|| echo "$IMPORTS$MAIN_CLASS_START$MAINSTART$(cat input.txt)\\n}\\n}" > Runner.java && java Runner.java > output.txt && osascript -e "display notification \"$(cat output.txt)\" with title \"Runner\""\