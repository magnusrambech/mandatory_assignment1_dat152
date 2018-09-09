package Controllers;

import DAO.CartDAO;

import java.util.HashMap;

public class CartDAOController {
    CartDAO cartDAO;
    public CartDAOController(){
        cartDAO = new CartDAO();
    }

    public HashMap<Integer,Integer> getCart(){
        return cartDAO.getCart();
    }
    public void addToCart(int pNo){
        cartDAO.addToCart(pNo);
    }
    public void emptyCart(){
        cartDAO.emptyCart();
    }
}
