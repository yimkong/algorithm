package problems;

import java.util.*;

/**
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 *
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 *
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 *
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上。
 * 示例 2：
 *
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 *  
 *
 * 提示：
 *
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * graph[i] 按严格递增顺序排列。
 * 图中可能包含自环。
 * 图中边的数目在范围 [1, 4 * 104] 内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem802 {
    //深度搜索+三色标记法 0:未访问 1:已访问 2:安全
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(safe(graph,color,i)) res.add(i);
        }
        return res;
    }

    boolean safe(int[][] graph,int[] color, int i){
        if(color[i] > 0) return color[i] == 2;
        color[i] = 1;
        for(int y : graph[i]){
            if(!safe(graph, color, y)) return false;
        }
        color[i] = 2;
        return true;
    }

    //拓扑排序
    public List<Integer> eventualSafeNodes1(int[][] graph) {
        List<List<Integer>> rg = new ArrayList<>(graph.length);//入度数据
        for (int i = 0; i < graph.length; i++) {
            rg.add(new ArrayList<>());
        }
        int[] inDeg = new int[graph.length];
        Queue<Integer> safeIndex = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            //记录安全节点的入度
            for (int j : graph[i]) {
                rg.get(j).add(i);
            }
            inDeg[i] = graph[i].length;
            if(inDeg[i] == 0){
                safeIndex.add(i);
            }
        }
        Integer safe = null;
        List<Integer> res = new ArrayList<>();
        while ((safe = safeIndex.poll()) != null) {
            List<Integer> integers = rg.get(safe);
            //出度减一
            for (Integer y : integers) {
                if(--inDeg[y] == 0){
                    safeIndex.offer(y);
                }
            }
        }
        for (int i = 0; i < inDeg.length; i++) {
            if(inDeg[i] == 0) res.add(i);
        }
        return res;
    }
}
