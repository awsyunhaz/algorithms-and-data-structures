awk '{
    for (i=1; i<=NF; i++) {
        if (NR==1) {
            s[i] = $i
        } else {
            s[i] = s[i] " " $i
        }
    }
}
END { for (i=1; i<=NF; i++) {
        print s[i]
    }
}' file.txt

#AWK is line-based: the main code block (the code block without prefix) processes one line of input at a time.
#The code block with an "END" prefix is only executed after the last line is read; similarly, a code block with a "BEGIN" prefix will be executed before any line reads.
