
package Entities;

import java.util.HashMap;

public class Cart {

      private HashMap<Integer, Integer> cart;
      

      public Cart() {
            this.cart = new HashMap<>();
      }

      public void addToCart(Integer pNo, Integer quantity){
            if(cart.containsKey(pNo)){
                  cart.put(pNo, cart.get(pNo) + quantity);
            } else {
                  cart.put(pNo, quantity);
            }
      }

      public void clear() {
            cart.clear();
      }

      public HashMap<Integer, Integer> getCart () {
            return this.cart;
      }
}

