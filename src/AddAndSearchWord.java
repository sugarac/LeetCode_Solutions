public class AddAndSearchWord {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    /**
     * Medium (F)
     * follow up:
     * 1.如何优化
     * 在原本的trieNode class中加入一个length的int，记录每个单词的长度，如果匹配单词的长度大于了记录的，就false了
     * 问题是如果记录的是一个较短的单词呢，只是匹配单词的前面一部分？还是得遍历完整个字符串。
     * 2.给定一个字典，查询字符串，要支持类似于“book”, "book...", "..boo.."，这种查询
     * 建立tire tree，然后递归查询，follow up是，如果模糊查询只有"...book"和“book...”这两种模式怎么处理，
     * 回答，只要建立顺序tire树，反序tire树，就可以了。
     */
    private TrieNode root;

    // initialize your data structure here.
    public AddAndSearchWord() { // change WordDictionary to AddAndSearchWord
        root = new TrieNode();
    }

    /**
     * Iterative O(n);O(1)
     */
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null) {
            return;
        }

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isWord = true;
    }

    /**
     * Recursive O(n);O(n)
     */
    // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        return match(word, 0, root);
    }

    private boolean match(String word, int start, TrieNode node) {
        if (start == word.length()) {
            return node.isWord;
        }

        if (word.charAt(start) != '.') {
            return node.children[word.charAt(start) - 'a'] != null
                    && match(word, start + 1, node.children[word.charAt(start) - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(word, start + 1, node.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
