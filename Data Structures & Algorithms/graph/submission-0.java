class Graph {
    private HashMap<Integer, HashSet<Integer>> adjList;
    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        // if src doesnt exist add it in the hashmap
            // include that vertices edges;
        if(!(adjList.containsKey(src))) adjList.put(src, new HashSet<>());
        // if dst doesnt exist add it in the hashmap
            // include that vertices edges;
        if(!(adjList.containsKey(dst))) adjList.put(dst, new HashSet<>());

        // one confirmed at the dst into the src's arraylist
        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        // if src doesnt exist return false;
        if(!(adjList.containsKey(src))) return false;
        // if dst doesnt exist return false;
        if(!(adjList.containsKey(dst))) return false;
        // else .remove() it then return true
        adjList.get(src).remove(dst);
        return true;
    }

    private boolean dfs(int node, int target, HashSet<Integer> visited)
    {
        // see if the node has already been visited
        if(visited.contains(node)) return false;
        // have base case to see if node is target
        if(node == target) return true;
        // add the node into visit set
        visited.add(node);
        // while loop to do both options
        for(int edge : adjList.get(node)) {
            if(dfs(edge, target, visited)) return true;
        }
        
        return false;
    }
    public boolean hasPath(int src, int dst) {
        HashSet<Integer> visited = new HashSet<>();
        return dfs(src, dst, visited);

    }
}
