 
package Solucao;

 
import java.util.LinkedList;
 
import java.util.List;

/**
 *
 * @author Larissa
 */
public class Algoritmos {
    private String name;
    private int dimension;
 
   
    private int custo;
    private boolean countingSort;

    public Algoritmos(String name, int dimension, int custo, boolean countingSort, int num, List<Dis> floresta, Aresta[] vertices, Dis[] dis, Set[] set) {
        this.name = name;
        this.dimension = dimension;
        this.custo = custo;
        this.countingSort = countingSort;
        this.num = num;
        this.floresta = floresta;
        this.vertices = vertices;
        this.dis = dis;
        this.set = set;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Dis> getFloresta() {
        return floresta;
    }

    public void setFloresta(List<Dis> floresta) {
        this.floresta = floresta;
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

    public void setDis(Dis[] dis) {
        this.dis = dis;
    }

    public Set[] getSet() {
        return set;
    }

    public void setSet(Set[] set) {
        this.set = set;
    }

    public int getMinDist() {
        return minDist;
    }

    public void setMinDist(int minDist) {
        this.minDist = minDist;
    }

    public int getMaxDist() {
        return maxDist;
    }

    public void setMaxDist(int maxDist) {
        this.maxDist = maxDist;
    }
    private int num; private List<Dis> floresta;
    private Aresta[] vertices;
    private Dis[] dis;
    private Set[] set;
      int minDist = Integer.MAX_VALUE, maxDist = 0;
    
    public void Solucao() {
      
        for(int i = 0, backIndex = 0; i < dimension; i++) {  
            for(int j = i + 1; j < dimension; j++, backIndex++) {
                dis[backIndex] = new Dis(vertices[i], vertices[j]);
                if(countingSort) {
                    if(dis[backIndex].valor < minDist) {
                        minDist = dis[backIndex].valor;
                    } else if(dis[backIndex].valor > maxDist) {
                        maxDist = dis[backIndex].valor;
                    }
                }
            }
        }
      
        if(countingSort) {
            countingSort(minDist, maxDist);
        } else {
            heapSort();
        }
        int i = 0, a, b;
        Dis e;
        floresta = new LinkedList<>();
        custo = 0;
        
        while(floresta.size() < dimension - 1) {
            e = dis[i];
            a = findSet(e.a.indice);   
            b = findSet(e.b.indice);  
            if(a != b) {  
                floresta.add(e);
                custo += e.valor;
                uniao(a, b);
            }
            i++;
        }
    }
     private void heapSort() {
        for(int i = num >> 1; i >= 0; i--) {
            HeapMax(i, num);
        }
        Dis aux;
        for(int i = num - 1; i > 0; i--) {
            aux = dis[i];
            dis[i] = dis[0];
            dis[0] = aux;
            HeapMax(0, i - 1);
        }
    }
  

    private void countingSort(int dismax, int dismin) {
        int[] count = new int[dismax - dismin + 1];
        for(int i = 0; i < num; i++) {
            count[dis[i].valor - dismin]++;
        }
        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        Dis[] out = new Dis[num];
        for(int i = num - 1; i >= 0; i--) {
            out[count[dis[i].valor - dismin] - 1] = dis[i];
            count[dis[i].valor - dismin]--;
        }
        dis = out;
    }

   
    private void HeapMax(int indice, int tam) {
        int left = (indice << 1) + 1, right = (indice << 1) + 2, largest = indice;
        if(left < tam && dis[left].valor > dis[indice].valor) {
            largest = left;
        }
        if(right < tam && dis[right].valor > dis[largest].valor) {
            largest = right;
        }
        if(largest != indice) {
            Dis aux = dis[indice];
            dis[indice] = dis[largest];
            dis[largest] = aux;
            HeapMax(largest, tam);
        }
    }
    
      

    private void uniao(int a, int b) {
        int raiza = findSet(a), raizb = findSet(b);
        if(set[raiza].peso < set[raizb].peso) {
            set[raiza].pai = raizb;
        } else if(set[raiza].peso > set[raizb].peso) {
            set[raizb].pai = raiza;
        } else {
            set[raizb].pai = raiza;
            set[raiza].peso++;
        }
    }
  private int findSet(int indice) {
        if(set[indice].pai != indice) {
            set[indice].pai = findSet(set[indice].pai);
        }
        return set[indice].pai;
    }
}

