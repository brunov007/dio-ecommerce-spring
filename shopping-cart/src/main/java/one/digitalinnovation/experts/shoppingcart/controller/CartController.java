package one.digitalinnovation.experts.shoppingcart.controller;

import one.digitalinnovation.experts.shoppingcart.model.Cart;
import one.digitalinnovation.experts.shoppingcart.model.Item;
import one.digitalinnovation.experts.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable Integer id, @RequestBody Item item){
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if(savedCart.equals(Optional.empty())){
            cart = new Cart();
        }else{
            cart = savedCart.get();
        }

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable Integer id){
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void clear(@PathVariable Integer id){
        cartRepository.deleteById(id);
    }
}
