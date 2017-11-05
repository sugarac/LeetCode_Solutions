package LowFrequency;

public class ImplementTrie {
    /**
     * First, create TrieNode class with two member variables.
     * a TrieNode array to represent child nodes and a boolean variable to represent if current char is the end of a word.
     * For insert, traverse each char in the word, check if the character is a child node of the current TrieNode.
     * If not, create a new TrieNode to store current char.
     * For search, traverse each character in the word, check if the char is a child node of the current TrieNode.
     * If not, return false. After checking each char in the word, check if current TrieNode was marked as a word.
     */
    class TrieNode {
        public TrieNode[] children;
        public boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) { //可以不减冗余,因为易懂
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
