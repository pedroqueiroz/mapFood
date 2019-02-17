package br.com.codenation.mapfood.resource;

import br.com.codenation.mapfood.document.Product;
import br.com.codenation.mapfood.repository.ProductsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api (value = "Product", description = "Manipulating Product")
@RestController
@RequestMapping (value = "/product")
public class ProductsResource {

    @Autowired
    private ProductsRepository productsRepository;

    @ApiOperation(value = "Find all the products")
    @GetMapping (value = "/findAll", produces = "application/json")
    public ResponseEntity<?> findAllProducts () {
        List<Product> productsList = new ArrayList<>();
        try {
            productsList = productsRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List>(productsList, HttpStatus.OK);
    }

    @ApiOperation(value = "Find all the products by restaurant")
    @GetMapping (value = "/productsByRestaurant/{restaurantId}", produces = "application/json")
    public ResponseEntity<?> findProductsByRestaurant (@PathVariable(value = "restaurantId") String restaurantId) {
        return null;
    }


}