package APAKruskal;

import Solucao.Dis;
import Solucao.Set;
import Solucao.Aresta;
 import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Kruskal {
    private String name;
     private Set[] sets;
    private List<Dis> floresta;
    private int custo;
    private boolean countingSort;
    private int dimension;
    private int num;
    private Aresta[] vertices;
    private Dis[] dis;

    public Set[] getSets() {
        return sets;
    }

    public void setSets(Set[] sets) {
        this.sets = sets;
    }

    public List<Dis> getFloresta() {
        return floresta;
    }

    public void setFloresta(List<Dis> floresta) {
        this.floresta = floresta;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public boolean isCountingSort() {
        return countingSort;
    }

    public void setCountingSort(boolean countingSort) {
        this.countingSort = countingSort;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Aresta[] getVertices() {
        return vertices;
    }

    public void setVertices(Aresta[] vertices) {
        this.vertices = vertices;
    }

    public Dis[] getDis() {
        return dis;
    }
    
  

    public int getCost() {
        return custo;
    }

    public String getName() {
        return name;
    }

    public void setDis(Dis[] dis) {
        this.dis = dis;
    }
      public List<Dis> getForest() {
        return floresta;
    }

    public Kruskal(String name, Set[] sets, List<Dis> floresta, int custo, boolean countingSort, int num, Aresta[] vertices, Dis[] dis) {
        this.name = name;
        this.sets = sets;
        this.floresta = floresta;
        this.custo = custo;
        this.countingSort = countingSort;
        this.num = num;
        this.vertices = vertices;
        this.dis = dis;
    }
  
    public Kruskal(String file, boolean countingSort) {
        this.countingSort = countingSort;

        File(file);
        
    }

   
    private void File(String path) {
        try {
            File inputFile = new File(path);
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String line;
            String[] split;
            int count = 0;
            while((line = in.readLine()) != null) {
                split = line.trim().split(" +");
                switch (split[0]) {
                    case "NAME:":
                        name = split[1];
                        break;
                    case "DIMENSION:":
                        dimension = Integer.parseInt(split[1]);
                        num = ((dimension * (dimension - 1)) >> 1); // (n(n-1))/2
                        vertices = new Aresta[dimension];
                        sets = new Set[dimension];
                        dis = new Dis[num];
                        break;
                    case "DISPLAY_DATA_SECTION":
                    case "EOF":
                        continue;
                    default:
                        vertices[count] = new Aresta(count, Double.parseDouble(split[1]), Double.parseDouble(split[2]));
                        sets[count] = new Set(count, 0);
                        count++;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
    }

    


}
