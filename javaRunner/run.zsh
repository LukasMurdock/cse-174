IMPORTS="import java.util.*;\\n\\n"
MAIN_CLASS_START="public class Runner {\\n"
MAINSTART="public static void main(String[] args) {\\n"

[[ "$(pbpaste)" =~ "^[0-9]" ]]\
&& pbpaste | sed 's/^ *[0-9]*.//g' > input.txt\
|| pbpaste > input.txt

# pbpaste | sed 's/^ *[0-9]*.//g' > input.txt

[[ "$(cat input.txt)" =~ "public " ]]\
&& echo "$IMPORTS$MAIN_CLASS_START$(cat input.txt)\\n}" > Runner.java && java Runner.java > output.txt && osascript -e "display notification \"$(cat output.txt)\" with title \"Mail Password Required\""\
|| echo "$IMPORTS$MAIN_CLASS_START$MAINSTART$(cat input.txt)\\n}\\n}" > Runner.java && java Runner.java > output.txt && osascript -e "display notification \"$(cat output.txt)\" with title \"Mail Password Required\""\