/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solucao;

/**
 *
 * @author Larissa
 */
public class Dis {
     int valor;
      Aresta a;
        Aresta b;
        
        public Dis(){
            
        }

        public Dis(Aresta a, Aresta b) {
            this.a = a;
            this.b = b;

            valor = (int) Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
        }

     
}
