/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APAKruskal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

 

public class APAKruskal {
    
   
    public static void main(String[] args) {
        long start, fim;
        Kruskal k = null;
         int s[][] = new int[2][3];
        double  tempHeap, tempCount;
        
        String route = "C:\\Users\\Larissa\\Documents\\NetBeansProjects\\APAKruskal\\instances\\n1500A.txt"; 
        
        for(int i = 0, j; i < 1; i++) {
            for (j = 0; j < 5; j++) {
                
                
                start = System.currentTimeMillis();
                k = new Kruskal(route, false);
                fim = System.currentTimeMillis();
                s[1][i] += (fim - start);
                
                start = System.currentTimeMillis();
                k = new Kruskal(route, true);
                fim = System.currentTimeMillis();
                s[0][i] += (fim - start);
            }
            tempCount = (double) s[0][i] ;
            tempHeap = (double) s[1][i] ;
            System.out.println("HeapSort =" + tempHeap +  " - " + "CountingSort =" +tempCount);
           
        }
    }

    
}
