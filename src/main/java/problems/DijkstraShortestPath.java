package problems;

import java.util.*;

public class DijkstraShortestPath {

    /**
     * Dijkstra 算法算最短路径
     *
     * @param startNode 开始的节点
     * @return 距离开始的节点最近的节点
     */
    public static MyNode shortestPath(MyNode startNode) {
        //已访问列表
        List<MyNode> visited = new ArrayList<>();
        //未访问列表
        List<MyNode> unvisited = new ArrayList<>();
        //初始化unvisited列表的数据
        unvisited.add(startNode);
        Set<MyNode> toAddSet = new HashSet<>(startNode.getAdjacentNodes().keySet());
        boolean empty = toAddSet.isEmpty();
        while (!empty) {
            unvisited.addAll(toAddSet);
            HashSet<MyNode> hashSet = new HashSet<>();
            for (MyNode node : toAddSet) {
                hashSet.addAll(node.getAdjacentNodes().keySet());
            }
            toAddSet.addAll(hashSet);
            //防止死循环
            toAddSet.removeAll(unvisited);
            empty = toAddSet.isEmpty();
        }
        Map<Character, MyNode> table = new HashMap<>();
        startNode.setD(0);
        //初始化table
        unvisited.forEach(x -> table.put(x.getName(), x));
        MyNode pre = startNode;
        while (pre != null) {
            Map.Entry<MyNode, Integer> minEntry = null;//每一次访问节点到关联的最短距离的下一个节点记录
            for (Map.Entry<MyNode, Integer> entry : pre.getAdjacentNodes().entrySet()) {
                char name = entry.getKey().getName();
                MyNode recordNode = table.get(name);
                if (visited.contains(recordNode)) {
                    continue;
                }
                Integer curDistance = entry.getValue();
                //该节点到上一个节点的距离比记录的小，更新table里的recordNode
                if (curDistance < recordNode.getD()) {
                    recordNode.setD(curDistance);
                    recordNode.setPi(pre);
                }
                if (minEntry == null) {
                    minEntry = entry;
                    continue;
                }
                if (recordNode.getD() < minEntry.getValue()) {
                    minEntry = entry;
                }
            }
            unvisited.remove(pre);
            visited.add(pre);
            if (minEntry == null) {
                break;
            }
            pre = minEntry.getKey();
        }
        //最后遍历一遍得到距离startNode最近的节点
        MyNode minNode = null;
        table.remove(startNode.getName());
        for (Map.Entry<Character, MyNode> entry : table.entrySet()) {
            if (minNode == null) {
                minNode = entry.getValue();
            } else {
                if (entry.getValue().getD() < minNode.getD()) {
                    minNode = entry.getValue();
                }
            }
        }
        return minNode;
    }
}

class MyNode {
    char name;//对应的节点
    int d;//当前记录最短距离
    MyNode pi;//最短距离的上一个节点
    Map<MyNode, Integer> adjacentNodes = new HashMap<>();//相连的其他节点以及对应的距离

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

    public Map<MyNode, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<MyNode, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void addDestination(MyNode nodeB, int i) {
        adjacentNodes.put(nodeB, i);
    }
}