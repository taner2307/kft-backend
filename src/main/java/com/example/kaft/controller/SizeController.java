package com.example.kaft.controller;

import com.example.kaft.enums.Gender;
import com.example.kaft.model.SizeTable;
import com.example.kaft.model.ProductSize;
import com.example.kaft.service.ISizeService;
import com.example.kaft.service.IProductSizeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kaft")
@AllArgsConstructor
public class SizeController {

    private final IProductSizeService productSizeService;
    private final ISizeService sizeService;

    @GetMapping("/sizeList/gender/{gender}")
    public List<SizeTable> sizeTableList(@PathVariable("gender")Gender gender) {
        return sizeService.sizeTableList(gender);
    }

    @PostMapping("/")
    public ProductSize calculateSize(@RequestBody ProductSize productSize) {
        return productSizeService.calculateProductSize(productSize);
    }
}
