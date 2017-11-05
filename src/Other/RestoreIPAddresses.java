package Other;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    /**
     * DFS O(3^4)
     * Use a string to generate each result, a index to record the start of each part of IP and a counter to
     * record how many parts have been generated.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, "", s, 0, 0);
        return res;
    }

    private void dfs(List<String> res, String ip, String s, int start, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4 && start == s.length()) {
            res.add(ip);
        }

        for (int i = 1; i < 4; i++) {
            if (start + i > s.length()) {
                break;
            }

            String temp = s.substring(start, start + i);
            if (temp.startsWith("0") && temp.length() > 1 || i == 3 && Integer.valueOf(temp) > 255) {
                continue;
            }
            dfs(res, ip + temp + (count == 3 ? "" : "."), s, start + i, count + 1); //wrong: count++
        }
    }
}
