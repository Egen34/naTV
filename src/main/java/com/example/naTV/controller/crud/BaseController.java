package com.example.naTV.controller.crud;

import com.example.naTV.service.Interface.BaseService;
import com.example.naTV.utils.Language;
import com.example.naTV.utils.RBundle;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController <D> {
    private BaseService<D> service;

    public BaseController(BaseService<D> service) {
        this.service = service;
    }
    @ApiOperation(value = "сохранения")
    @PostMapping("/save")
    public ResponseEntity<D> save(@RequestBody D d, Language language) {
        RBundle.SINGILTON.setLanguage(language);
        return ResponseEntity.ok(service.save(d));
    }
    @ApiOperation(value = "найти по {Id}")
    @GetMapping("/findById")
    public ResponseEntity<D> findById(Long id, Language language) {
        RBundle.SINGILTON.setLanguage(language);
        return ResponseEntity.ok(service.findById(id));
    }
    @ApiOperation(value = "получить все данные")
    @GetMapping("/findAll")
    public ResponseEntity<List<D>> findAll(int page,int pageSize, Language language) {
        RBundle.SINGILTON.setLanguage(language);
        return ResponseEntity.ok(service.findAll(PageRequest.of(page,pageSize)));
    }
    @ApiOperation(value = "удалить по {Id}")
    @DeleteMapping("/deleteById")
    public ResponseEntity<Integer> deleteById(Long id, Language language) {
        RBundle.SINGILTON.setLanguage(language);
        return ResponseEntity.ok(service.deleteById(id));
    }
}
