import java.util.*;
public class Graph
{
    class Pair{
        int node;
        int weight;
        Pair(int n,int w){
            node=n;
            weight=w;
        }
        @Override
        public String toString(){
            return "("+node+","+weight+")";
        }
    }
    int adjMatrix[][];
    List<List<Pair>>  adjListWithWeight;
    List<List<Integer>> adjList;
    Graph(int nodes){
        adjMatrix=new int[nodes][nodes];//4*4
        adjList=new ArrayList<>();
        adjListWithWeight=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }
    public void addEdgesInList(int edges[][],boolean isDirected){
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            if(isDirected){
                adjList.get(u).add(v);
            }
            else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }
    public void addEdgesInMatrix(int edges[][],boolean isDirected){
        //-> [[0,2],[0,1],[2,0]]
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            //directed
            if(isDirected) {
                adjMatrix[u][v] = 1;
            }
            //undirected
            else {
                adjMatrix[u][v] = 1;
                adjMatrix[u][v] = 1;
            }
        }
    }
    public void printMatrix(){
        for(int i=0;i< adjMatrix.length;i++){
            System.out.print("row"+i+"->");
            for(int j=0;j<adjMatrix[i].length;j++){
                System.out.print(adjMatrix[i][j]+",");
            }
            System.out.println();
        }
    }
    public void printList(){
        for(int i=0;i<adjList.size();i++){
            System.out.println(i+"->");
            System.out.print("[");
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j));
                if(j!=adjList.get(i).size()-1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
    public void addEdgesWithWeight(int[][] edges,boolean isDirected){
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(isDirected){
                adjMatrix[u][v]=w;
            }else{
                adjMatrix[u][v]=w;
                adjMatrix[v][u]=w;
            }
        }
    }
    public void findDegreeInUndirected(int edges[][],int nodes){
        int degree[]=new int[nodes];
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            degree[u]++;
            degree[v]++;
        }
    }
    
    public void addEdgesWithWeightInList(int[][] edges,boolean isDirected){
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(isDirected){
                Pair pair=new Pair(v,w);
                adjListWithWeight.get(u).add(pair);
            }else{
                Pair pair=new Pair(v,w);
                Pair pair1=new Pair(u,w);
                adjListWithWeight.get(u).add(pair);
                adjListWithWeight.get(v).add(pair1);
            }
        }
    }
    public static void main(String[] args){
        int edges[][]={{0,2},{0,1},{2,0}};
        int nodes=4;
        Graph graph=new Graph(nodes);
        graph.addEdgesInMatrix(edges,false);
        graph.printMatrix();
        System.out.println("Weighted \n");
        int edgesweight[][]={{0,2,10},{0,1,30},{1,3,30}};
        graph.addEdgesWithWeight(edgesweight,false);
        graph.printMatrix();
    }
}