# Read from the file words.txt and output the word frequency list to stdout.
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{print $2, $1}'

awk '{for (i=1; i<=NF; i++) {++D[$i];} }\
END {for (i in D) {print i, D[i]} }\
' words.txt | sort -nr -k 2

#sort -n means "compare according to string numerical value".
#sort -r means "reverse the result of comparisons".
#sort -k 2 means "sort by the second word"
