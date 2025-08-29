/*class TrieNode {
    Map<char, TrieNode> children;
    boolean isEnd;
    int popularity;
}

class Trie {
    TrieNode root;

    void insert(String word, int popularity) { ... }

    List<String> search(String prefix, int topN) {
        // Traverse prefix
        // Collect words using DFS
        // Sort by popularity
        return result;
    }
}

main() {
    Trie trie = new Trie();
    trie.insert("pizza hut", 100);
    trie.insert("pizza point", 80);
    trie.insert("pita bread", 60);

    print(trie.search("pi", 3)); // pizza hut, pizza point, pita bread
    trie.insert("pineapple cafe", 70);
    print(trie.search("pi", 3)); // includes pineapple cafe
}
*/