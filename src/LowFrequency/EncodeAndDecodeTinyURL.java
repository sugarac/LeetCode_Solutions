package LowFrequency;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
    /**
     * Medium (F,G,U)
     */

    /**
     * HashMap O(L);O(L)
     */
    Map<Integer, String> map = new HashMap<>();
    String host = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        return host + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.valueOf(shortUrl.replace(host, "")));
    }
}
