package problems;

import java.util.*;

public class DijkstraShortestPath {

    /**
     * Dijkstra 算法算最短路径
     *
     * @param startMyNode 开始的节点
     * @return 距离开始的节点最近的节点
     */
    public static MyNode shortestPath(MyNode startMyNode) { //已访问列表
        List<MyNode> visited = new ArrayList<>();
        //未访问列表
        List<MyNode> unvisited = new ArrayList<>();
        //初始化unvisited列表的数据
        unvisited.add(startMyNode);
        Set<MyNode> toAddSet = new HashSet<>(startMyNode.getAdjacentMyNodes().keySet());
        boolean empty = toAddSet.isEmpty();
        while (!empty) {
            unvisited.addAll(toAddSet);
            HashSet<MyNode> hashSet = new HashSet<>();
            for (MyNode MyNode : toAddSet) {
                hashSet.addAll(MyNode.getAdjacentMyNodes().keySet());
            }
            toAddSet.addAll(hashSet);
            //防止死循环
            toAddSet.removeAll(unvisited);
            empty = toAddSet.isEmpty();
        }
        Map<Character, MyNode> table = new HashMap<>();
        startMyNode.setD(0);
        //初始化table 里面存的是每一次访问节点时，每个节点距离开始节点最近的距离长度，初始时为 Integer.MAX_VALUE
        unvisited.forEach(x -> table.put(x.getName(), x));
        //访问节点
        MyNode pre = startMyNode;
        while (true) {
            MyNode minMyNode = null;//当前pre节点的所有关联节点中，距离开始节点最近的节点entry
            unvisited.remove(pre);
            visited.add(pre);
            for (Map.Entry<MyNode, Integer> entry : pre.getAdjacentMyNodes().entrySet()) {
                char name = entry.getKey().getName();
                MyNode recordMyNode = table.get(name);
                if (visited.contains(recordMyNode)) {
                    continue;
                }
                Integer curDistance = entry.getValue();
                //该关联节点加上上一个节点的距离，如果比记录的小，则更新table里的recordMyNode 并记录最短距离的有效上一个节点为当前Pre访问节点
                if (curDistance + pre.getD() < recordMyNode.getD()) {
                    recordMyNode.setD(curDistance + pre.getD());
                    recordMyNode.setPi(pre);
                }
                if (minMyNode == null) {
                    minMyNode = recordMyNode;
                    continue;
                }
                if (recordMyNode.getD() < minMyNode.getD()) {
                    minMyNode = recordMyNode;
                }
            }
            if (minMyNode == null) {
                break;
            }
            pre = minMyNode;
        }
        //最后遍历一遍得到距离startMyNode最近的节点
        MyNode minMyNode = null;
        for (Map.Entry<Character, MyNode> entry : table.entrySet()) {
            MyNode MyNode = entry.getValue();
            if (MyNode == startMyNode) {
                continue;
            }
            if (minMyNode == null) {
                minMyNode = MyNode;
            } else {
                if (MyNode.getD() < minMyNode.getD()) {
                    minMyNode = entry.getValue();
                }
            }
        }
        return minMyNode;
    }
}

class MyNode {
    char name;//对应的节点
    int d;//当前记录最短距离
    MyNode pi;//最短距离的上一个节点
    Map<MyNode, Integer> adjacentMyNodes = new HashMap<>();//相连的其他节点以及对应的距离

    public MyNode(char name) {
        this.name = name;
        d = Integer.MAX_VALUE;
        pi = null;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public MyNode getPi() {
        return pi;
    }

    public void setPi(MyNode pi) {
        this.pi = pi;
    }

    public Map<MyNode, Integer> getAdjacentMyNodes() {
        return adjacentMyNodes;
    }

    public void setAdjacentMyNodes(Map<MyNode, Integer> adjacentMyNodes) {
        this.adjacentMyNodes = adjacentMyNodes;
    }

    public void addDestination(MyNode MyNodeB, int i) {
        adjacentMyNodes.put(MyNodeB, i);
    }
}