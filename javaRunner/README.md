# Java Runner

Reads Mac `pbpaste` to file, determines if it has "public" or "main(" in it to pipe it into a executable java file, that runs and the output is saved to a file and a Mac notification appears on-screen.

## Command line
```console
sh run.zsh
```

## Mac Automator Quick Action
Run shell script:
```shell
IMPORTS="import java.util.*;\\n\\n"
MAIN_CLASS_START="public class Runner {\\n"
MAINSTART="public static void main(String[] args) {\\n"

pbpaste | sed 's/^ *[0-9]*.//g' > input.txt

[[ "$(cat input.txt)" =~ "public " ]] &&\
echo "$IMPORTS$MAIN_CLASS_START$(cat input.txt)\\n}" > Runner.java && java Runner.java > output.txt && osascript -e "display notification \"$(cat output.txt)\" with title \"Runner\""\
|| echo "$IMPORTS$MAIN_CLASS_START$MAINSTART$(cat input.txt)\\n}\\n}" > Runner.java && java Runner.java > output.txt && osascript -e "display notification \"$(cat output.txt)\" with title \"Runner\""\
```

1. In Settings > Keyboard > Services: Scroll down and click `none` to add a keybinding.
2. In Settings > Security & Privacy > Accessibility: Add Automator