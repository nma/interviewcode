/* 

class Node(object):
    def __init__(self, id, parent_id):
        self.id = id
        self.parent_id = parent_id
        
nodes = [Node(1, 0), Node(2, 1), Node(3, 1), Node(4, 0), Node(5, 3)]


Print them like a hierarchy
1
 2
  6
   7
    8
     9
 3
  5
4
*/

import java.util.*

class PrettyPrint {
    
    class Node {
        public int val;
        public Node[] children;
    }
    
    static pprint(Node node, int depth) {
        for( Node child : tree.children) {
            print_spaces(depth);
            System.out.println(node.val);
            pprint(child, depth+1);
        }
    }
    
    public static void main( String args[]) {
        // Construct Node objects
        input_nodes = [Node(1, 0), Node(2, 1), Node(3, 1), Node(4, 0), Node(5, 3)]
        
    }
}
