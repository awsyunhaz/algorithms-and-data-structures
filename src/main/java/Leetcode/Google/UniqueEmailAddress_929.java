package Leetcode.Google;

import java.util.HashSet;

public class UniqueEmailAddress_929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String str: emails){
            String[] names = str.split("@");
            String localname = names[0].split("\\+")[0].replace(".","");
            String domainname = names[1];
            set.add(localname + "@" + domainname);
        }
        return set.size();
    }
}
