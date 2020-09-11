package Leetcode.Design;

import java.util.HashMap;

public class EncodeandDecodeTinyURL_535 {
    // use random encoding
    HashMap<String, String> tiny2url = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int rand = ((int) Math.random()) * (26+26+10);
                if (rand < 26) {
                    sb.append((char) ('a' + rand));
                } else if (rand < 52) {
                    sb.append((char) ('A' + rand - 26));
                } else {
                    sb.append((char) ('0' + rand - 52));
                }
            }
            String encoded = sb.toString();
            if (!tiny2url.containsKey(encoded)) {
                tiny2url.put(encoded,longUrl);
                return encoded;
            }
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tiny2url.get(shortUrl);
    }

    // use string hashcode
//    HashMap<String, String> tiny2url = new HashMap<>();
//
//    // Encodes a URL to a shortened URL.
//    public String encode(String longUrl) {
//        String encoded = Integer.toString(longUrl.hashCode());
//        tiny2url.put(encoded, longUrl);
//        return encoded;
//    }
//
//    // Decodes a shortened URL to its original URL.
//    public String decode(String shortUrl) {
//        return tiny2url.get(shortUrl);
//    }
}
