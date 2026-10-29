class Solution {
    private List<Integer>[] graph;
    private int[][] up;
    private int[] depth, tin, tout, parent, size;
    private int[] baseMask;
    private char[] chars;
    private int[] fenwick;
    private int timer, LOG, n;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        parent = new int[n];
        size = new int[n];
        baseMask = new int[n];
        chars = s.toCharArray();
        fenwick = new int[n + 2];

        buildTree();

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (c - 'a');
                int delta = oldMask ^ newMask;

                if (delta != 0) {
                    rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v);

                int maskU = pathPrefixMask(u);
                int maskV = pathPrefixMask(v);
                int ancestorMask =
                        1 << (chars[ancestor] - 'a');

                int pathMask = maskU ^ maskV ^ ancestorMask;
                answer.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return answer;
    }

    private void buildTree() {
        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0;
        int count = 0;

        stack[top++] = 0;
        parent[0] = 0;
        baseMask[0] = 1 << (chars[0] - 'a');

        while (top > 0) {
            int u = stack[--top];

            tin[u] = timer++;
            order[count++] = u;
            size[u] = 1;

            for (int v : graph[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                up[0][v] = u;

                for (int j = 1; j < LOG; j++) {
                    up[j][v] = up[j - 1][up[j - 1][v]];
                }

                baseMask[v] =
                        baseMask[u] ^ (1 << (chars[v] - 'a'));

                stack[top++] = v;
            }
        }

        for (int i = count - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }

        for (int u = 0; u < n; u++) {
            tout[u] = tin[u] + size[u] - 1;
        }
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    private int pathPrefixMask(int u) {
        return baseMask[u] ^ queryFenwick(tin[u] + 1);
    }

    private void rangeXor(int left, int right, int delta) {
        updateFenwick(left + 1, delta);
        updateFenwick(right + 2, delta);
    }

    private void updateFenwick(int index, int delta) {
        while (index <= n) {
            fenwick[index] ^= delta;
            index += index & -index;
        }
    }

    private int queryFenwick(int index) {
        int result = 0;

        while (index > 0) {
            result ^= fenwick[index];
            index -= index & -index;
        }

        return result;
    }
}