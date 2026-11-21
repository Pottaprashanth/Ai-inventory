
package com.inventory.smartinventory.controller;

import com.inventory.smartinventory.entity.Supplier;
import com.inventory.smartinventory.service.SupplierService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")

public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService s) {
        this.service = s;
    }

    @PostMapping
    public Supplier add(@Valid @RequestBody Supplier s) {
        return service.addSupplier(s);
    }

    @GetMapping
    public List<Supplier> all() {
        return service.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier one(@PathVariable Long id) {
        return service.getSupplierById(id);
    }

    @PutMapping("/{id}")
    public Supplier update(
            @PathVariable Long id,
            @Valid @RequestBody Supplier s) {
        return service.updateSupplier(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSupplier(id);
    }
}
