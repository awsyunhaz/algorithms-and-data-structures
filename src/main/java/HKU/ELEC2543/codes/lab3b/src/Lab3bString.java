import java.util.Scanner;

public class Lab3bString {

  public static boolean sameString(String s1, String s2) {
    s1 = s1.trim();
    s2 = s2.trim();
    return s1.equals(s2);
  }

  public static boolean sameStringIgnoreSpace(String s1, String s2) {
	s1 = s1.replace(s1, "");
	s2 = s2.replace(s2, "");
	return s1.equalsIgnoreCase(s2);
  }

  public static int countPattern(String s, String pattern) {
	int sum = 0, n;

	s = s.toLowerCase();
	pattern = pattern.toLowerCase();

	do {
		n = s.indexOf(pattern);
		if (n >= 0)
			sum++;
		if (n == s.lastIndexOf(pattern))
			break;
		else
			s = s.substring(n + pattern.length(), s.length());
	}while (n >= 0);
	
    return sum;
  }

  public static String remove(String s, String pattern) {
	  
	s = s.replace(pattern, "");
    return s; 
  }

  // truncate s starting from the last occurance of pattern
  public static String truncate(String s, String pattern) {
	  
	  int n = s.lastIndexOf(pattern);
	  if (n >= 0)
		  s = s.substring(0,n);
    return s;
  }
}
