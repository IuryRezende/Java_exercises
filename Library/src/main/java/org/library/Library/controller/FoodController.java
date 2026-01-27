package org.library.Library.controller;

import org.library.Library.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //identifica que é uma classe para controle
@RequestMapping("/food") //ao acessar este endpoint irá acionar essa classe
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService){
        this.foodService = foodServi ce;
    }

    @Get
}
