package com.bookstore.controller.user;

import com.bookstore.model.dto.CartItemDto;
import com.bookstore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class CartApi {

    @Autowired
    private ICartService cartService;

    @PostMapping("/cart/{bookId}")
    public ResponseEntity<?> addTocart(@PathVariable("bookId") String bookId, @RequestBody CartItemDto cartItemDto) {
        CartItemDto cartItem = cartService.save(Long.valueOf(bookId), cartItemDto);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @DeleteMapping("/cart/{cartItemId}")
    public ResponseEntity<?> deleteCartItem(@PathVariable("cartItemId") String cartItemId) {
        String message = cartService.deleteCartItem(Long.valueOf(cartItemId));
        return ResponseEntity.ok(message);
    }

    @GetMapping("/cart/cartItems/{status}")
    public ResponseEntity<?> getListCartItem(@PathVariable("status") String status) {
        List<CartItemDto> results = cartService.getListCartItem(Integer.valueOf(status));
        return ResponseEntity.ok(results);
    }

    @GetMapping("/cart/count")
    public Long countCartItem() {
        Long count = cartService.countCartItem();
        return count;
    }
}
