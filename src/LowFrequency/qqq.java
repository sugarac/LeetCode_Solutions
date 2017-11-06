package LowFrequency;

import java.util.*;

public class qqq {
    int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges,
                               int targetUser, int minLikeThreshold) {
        Set<Integer> follow = new HashSet<Integer>();
        for (int i = 0; i < followGraph_edges.length; i++) {
            if (followGraph_edges[i][0] == targetUser) {
                follow.add(followGraph_edges[i][1]);
            }
        }

        Map<Integer, Integer> like = new HashMap<>();
        for (int i = 0; i < likeGraph_edges.length; i++) {
            if (follow.contains(likeGraph_edges[i][0])) {
                if (!like.containsKey(likeGraph_edges[i][1])) {
                    like.put(likeGraph_edges[i][1], 1);
                } else {
                    like.put(likeGraph_edges[i][1], like.get(likeGraph_edges[i][1]) + 1);
                }
            }
        }

        Iterator it = like.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
            if (entry.getValue() < minLikeThreshold) {
                it.remove();
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(like.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        int[] res = new int[list.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            res[i] = entry.getKey();
            i++;
        }
        return res;
    }
}
