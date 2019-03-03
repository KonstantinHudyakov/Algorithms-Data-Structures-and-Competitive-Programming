package stack;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {

    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraphRecursive(node, new ArrayList<>());
    }

    public UndirectedGraphNode cloneGraphRecursive(UndirectedGraphNode node, List<UndirectedGraphNode> elems) {
        if(node == null)
            return null;
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        elems.add(clone);
        for(UndirectedGraphNode elem : node.neighbors) {
            UndirectedGraphNode copyNode = findElem(elems, elem);
            if(copyNode != null)
                clone.neighbors.add(copyNode);
            else
                clone.neighbors.add(cloneGraphRecursive(elem, elems));
        }
        return clone;
    }

    public UndirectedGraphNode findElem(List<UndirectedGraphNode> elems, UndirectedGraphNode target) {
        for(UndirectedGraphNode elem : elems) {
            if(elem.label == target.label)
                return elem;
        }
        return null;
    }

//    public UndirectedGraphNode findInGraph(UndirectedGraphNode node, UndirectedGraphNode target) {
//        if(node == null)
//            return null;
//        if(node.label == target.label)
//            return node;
//        for(UndirectedGraphNode elem : node.neighbors) {
//            UndirectedGraphNode res = null;
//            if(node.label != elem.label)
//                res = findInGraph(elem, target);
//            if(res != null)
//                return res;
//        }
//        return null;
//    }
}
