import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1650 {

    public Node lowestCommonAncestor(Node p, Node q) {

        Set<Node> pParents = new HashSet<>();
        while (p != null){
            pParents.add(p);
            p = p.parent;
        }

        while (q != null){
            if(pParents.contains(q))
                return q;
            q = q.parent;
        }

        return null;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }


}

