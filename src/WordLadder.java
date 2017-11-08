import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    /**
     * Solution1: two-end BFS O(n*L^2); O(nL)
     * Choose to use HashSet instead of Queue since we need to use “contains” operation.
     * Change input word list from List to Set because the “contains” operation of Set takes O(size of key) time.
     * Use a HashSet to start BFS from begin word and another HashSet to start BFS from end word.
     * Every time choose the HashSet with smaller size as the begin set to start BFS for saving time and space.
     * During BFS, use a temp Set to store the next level of BFS.
     * For each word in begin set, every time change one char to generate a new word, check if it exists in end set.
     * If exist, return current length plus one, otherwise check if it exists in the dict, if exist, add it to temp set
     * and remove it from dict.
     * <p>
     * The time complexicity is 26 * O(n), not exponential, n is the length of wordList(only the word in the dict will
     * do a 26-loop, and each word only do it once). The reason that this approach is fast because after each bfs,
     * it always choose the set that has the smaller size, which means it always try to waste less computation
     * to meet the goal(the set that has the maximum size won't need to generate new words). if you delete the code
     * "if (beginSet.size() > endSet.size()) ", just simply switch the role of begin and end each time, it will take 80+ms again.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }

        int len = 1;
        Set<String> dict = new HashSet<>(wordList), beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) { //O(n)
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) { //O(L)
                    for (char c = 'a'; c <= 'z'; c++) { //26
                        char old = chars[i];
                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        if (endSet.contains(newWord)) { //O(L)
                            return len + 1;
                        }
                        if (dict.contains(newWord)) {
                            temp.add(newWord);
                            dict.remove(newWord);
                        }
                        chars[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}
