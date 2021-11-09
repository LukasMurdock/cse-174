java Main.java > output.txt
osascript -e 'display notification "Lorem ipsum dolor sit amet" with title "Title"'


IMPORTS="import java.util.*;\\n\\n"
MAIN_CLASS_START="public class main {\\n"
MAINSTART="public class main {\\npublic static void main(String[] args) {\\n"
MAINEND="}}"

# cat output.txt
# $(echo cat output.txt)

# 
# public//private --> class or method

# echo 1 | sed '\%1%s21232'

'1. public static void main(String[] args) {
2.      int[] nums = {1, 2, 3, 4, 10, -20};
3.      run(nums);
4.      System.out.println(nums[3]);
5. }
6. public static void run(int[] values) {
7.      values[values.length / 2] = values[4] - values[1];
8. }'
pbpaste | sed 's/^ *[0-9]+.//g'
echo '1. public static void main(String[] args) {
2.      int[] nums = {1, 2, 3, 4, 10, -20};
3.      run(nums);
4.      System.out.println(nums[3]);
5. }
6. public static void run(int[] values) {
7.      values[values.length / 2] = values[4] - values[1];
8. }' | sed 's/^ *[0-9].//g'

pbpaste | sed 's/^ *[0-9].//g' 
pbpaste | sed 's/^ *[0-9].//g' > input.txt

[[ "hello main(" =~ "main\(" ]] &&  echo "contains main method" || "no main method"
[[ "public hello main(" =~ "^public" ]] && echo "contains public method" || "no public"

# contains public 
[[ "public hello main(" =~ "public " ]]

# contains main(
[[ "hello main(" =~ "main\(" ]]) 

cat output.txt

[[ "public hello main(" =~ "^public" ]]
    && [[ "hello main(" =~ "main\(" ]] 
        && echo "contains main method"
        || echo "contains method"
    || echo "no method"

cat main.java | sed 's/insert/insert\n$(input.txt)/g' > input.txt
cat main.java | sed 's/insert/insert\n$(input.txt)/g' | echo

cat main.java | gsed "s/insert/\"$(cat input.txt)\"/g"

cat main.java | gsed 's/insert/pinsert/g'



cat main.java | sed "s/insert/\"$(cat input.txt)\"/g" > input.txt
cat input.txt | sed "s/\\[/\\\[/g,"
cat main.java | gsed "s/insert/\"$(cat input.txt)\"/g"
cat main.java | sed -e 's/[]\/$*.^[]/\\&/g' | sed "s/insert/\"$(cat input.txt)\"/g"
[[ "public hello main(" =~ "^public" ]] && [[ "hello main(" =~ "main\(" ]] && echo "contains main method" || echo "contains method" || echo "no method"

[[ "public hello main(" =~ "^public" ]] && echo "contains public method" || echo "no public"


[[ "$(cat input.txt)" =~ "public " ]] && echo "contains public method" || echo "no public"



if not x%str1:main\(=%==x%str1% echo It contains main


osascript -e "display notification \"$(cat output.txt)\" with title \"Title\""

echo ""