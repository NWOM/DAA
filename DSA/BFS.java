import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BFS {
    //rm*wa*
    static class Edge{
        int src;
        int nbr;
        public Edge(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    static class Pair{
        int vertex;
        String psf;
        public Pair(int vertex,String psf){
            this.vertex=vertex;
            this.psf=psf;
        }
    }

    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        int vertices=sc.nextInt();
        ArrayList<Edge>[] graph=new ArrayList[vertices];
        for(int i=0;i<vertices;i++){
            graph[i]=new ArrayList<>();
        }
        int edges=sc.nextInt();
        for(int i=0;i<edges;i++){
            String parts[]=sc.nextLine().split(" ");
            int v1=Integer.parseInt(parts[0]);
            int v2=Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }
        int src=sc.nextInt();
        ArrayDeque<Pair> queue=new ArrayDeque<>();
        queue.add(new Pair(src,src+ ""));
        boolean visited[]=new boolean[vertices];
        while(queue.size()>0){
            //r m* w a*
            Pair rem=queue.removeFirst();
            if(visited[rem.vertex]){
                continue;
            }
            visited[rem.vertex]=true;
            System.out.println(rem.vertex+ "@" +rem.psf);
            for(Edge e:graph[rem.vertex]){
                if(!visited[e.nbr]){
                    queue.add(new Pair(e.nbr,rem.psf+e.nbr));
                }
            }
        }
    }

}
