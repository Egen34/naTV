package com.example.naTV.controller.defaults;

import com.example.naTV.configurations.Swagger2Config;
import com.example.naTV.models.request.DiscountRequest;
import com.example.naTV.models.response.GetChannalRespnonse;
import com.example.naTV.models.request.PriceRequest;
import com.example.naTV.service.Interface.ChannelService;
import com.example.naTV.service.Interface.DiscountService;
import com.example.naTV.service.Interface.PriceService;
import com.example.naTV.utils.Language;
import com.example.naTV.utils.RBundle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channel")
@Api(tags = Swagger2Config.CHANNELS)

public class ChannelContr {
    private DiscountService discountService;
    private PriceService priceService;
    private ChannelService service;

    @Autowired
    public ChannelContr(DiscountService discountService, PriceService priceService, ChannelService service) {
        this.discountService = discountService;
        this.priceService = priceService;
        this.service = service;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestParam String name, @RequestParam int orderNum,@RequestParam MultipartFile photo,@RequestParam Double price, @RequestParam Language language) {
        RBundle.SINGILTON.setLanguage(language);
        return ResponseEntity.ok(service.save(name, orderNum, photo,price));

    }


    @GetMapping("/getChannels")
    List<GetChannalRespnonse> getChannels(@RequestParam int page, @RequestParam int size) {
        return service.getChannels(PageRequest.of(page,size));
    }

    @GetMapping("/delete")
    int delete(@RequestParam Long id) {
        return service.deleteById(id);
    }
    @PutMapping("/discount/save")
    ResponseEntity<?> saveDiscount(@RequestBody DiscountRequest request){
        return ResponseEntity.ok(discountService.save(request));
    }
    @PutMapping("/price/save")
    ResponseEntity<?>savePrice(@RequestBody PriceRequest request){
        return ResponseEntity.ok(priceService.save(request));
    }
}
