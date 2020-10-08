import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int t = 1; t <= T; t++) {
            //Insert your code here.
            int N = in.nextInt();
            int K = in.nextInt();
            Trie trie = new Trie();
            for(int i = 0; i < N; i++) {
                trie.insert(in.next().toString());
            }
            System.out.println("Case #" + t + ": " + trie.count(K));
        }
    }

    private static class Node {
        int cnt;
        Node[] children;

        public Node() {
            cnt = 0;
            children = new Node[26];
        }
    }

    private static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String s) {
            insert(s, root, 0);
        }

        private void insert(String s, Node node, int index) {
            if(index == s.length())
                return;
            char c = s.charAt(index);
            if(node.children[c-'A'] == null)
                node.children[c-'A'] = new Node();
            node.children[c-'A'].cnt++;
            insert(s, node.children[c-'A'], index+1);
        }

        public int count(int K) {
            return count(root, K);
        }

        private int count(Node root, int K) {
            int ans = root.cnt / K;
            for(int i = 0; i < 26; i++) {
                if(root.children[i] != null)
                    ans += count(root.children[i], K);
            }
            return ans;
        }
    }
} 