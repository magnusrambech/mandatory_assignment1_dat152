package Entities;

import Controllers.DescriptionDAOController;
import Controllers.ProductsDAOController;

import java.util.HashMap;

public class Cart {

      private HashMap<Integer, Integer> cart;


      public Cart() {
            this.cart = new HashMap<>();
      }

      public void addToCart(Integer pNo){
            if(cart.containsKey(pNo)){
                  cart.put(pNo, cart.get(pNo) + 1);
            } else {
                  cart.put(pNo, 1);
            }
      }

      public void clear() {
            cart.clear();
      }

      public HashMap<Integer, Integer> getCart () {
            return this.cart;
      }
}

