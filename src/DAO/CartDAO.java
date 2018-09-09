package DAO;

import Entities.Cart;

import java.util.HashMap;

public class CartDAO {

    Cart cart;
    public CartDAO(){
        this.cart = new Cart();
    }

    public void addToCart(int pNo){
        cart.addToCart(pNo);
    }
    public HashMap<Integer, Integer> getCart(){
        return cart.getCart();
    }
    public void emptyCart(){
        cart.clear();
    }

}
