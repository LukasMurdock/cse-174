#!/bin/bash



IMPORTS="import java.util.*;\\n\\n"
MAIN_CLASS_START="public class Runner {\\n"
MAINSTART="public static void main(String[] args) {\\n"

# foo="Hello"
# foo=" World"
# echo "${foo}"

# Get text from clipboard, filter line numbers, and set to input.txt file
# System.out.println("World");
[[ "$(pbpaste)" =~ "^[0-9]" ]]\
&& pbpaste | sed 's/^ *[0-9]*.//g' > data/input.txt\
|| pbpaste > data/input.txt

# [[ "$(cat data/input.txt)" =~ "public " ]]\
# && echo -e "$IMPORTS$MAIN_CLASS_START$(cat data/input.txt)\\n}"\
# || echo -e "$IMPORTS$MAIN_CLASS_START$MAINSTART$(cat data/input.txt)\\n}\\n}"

[[ "$(cat data/input.txt)" =~ "public " ]]\
&& echo -e "$IMPORTS$MAIN_CLASS_START$(cat data/input.txt)\\n}" > data/Runner.java && java data/Runner.java > data/output.txt\
|| echo -e "$IMPORTS$MAIN_CLASS_START$MAINSTART$(cat data/input.txt)\\n}\\n}" > data/Runner.java && java data/Runner.java > data/output.txt


echo "$(cat data/output.txt)"