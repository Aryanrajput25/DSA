class Solution {
    int n, k;
    Node[] tree;

    static class Node {
        int product;
        int[] count;

        Node(int k) {
            count = new int[k];
        }
    }

    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node res = new Node(k);
        res.product = (a.product * b.product) % k;

        for (int i = 0; i < k; i++) {
            res.count[i] += a.count[i];
        }

        for (int i = 0; i < k; i++) {
            int r = (a.product * i) % k;
            res.count[r] += b.count[i];
        }

        return res;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            tree[node] = new Node(k);
            tree[node].product = nums[l] % k;
            tree[node].count[tree[node].product] = 1;
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            tree[node] = new Node(k);
            tree[node].product = value % k;
            tree[node].count[tree[node].product] = 1;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(int node, int l, int r, int start) {
        if (r < start) return null;

        if (l >= start) return tree[node];

        int mid = l + (r - l) / 2;

        Node left = query(node * 2, l, mid, start);
        Node right = query(node * 2 + 1, mid + 1, r, start);

        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start);

            result[i] = res.count[x];
        }

        return result;
    }
}