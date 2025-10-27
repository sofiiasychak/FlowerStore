package flower.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flower.store.businessmodel.Flower;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flowers") 
public class FlowerController {

    @GetMapping 
    public List<Flower> getFlowers() {
        
        Flower rose = new Flower(15.5, 40.0);
        
        return List.of(rose, 
                       new Flower(20.0, 55.0));
    }
    
   
}