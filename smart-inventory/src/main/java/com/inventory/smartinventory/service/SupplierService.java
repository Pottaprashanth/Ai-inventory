package com.inventory.smartinventory.service;

import com.inventory.smartinventory.entity.Supplier;
import java.util.List;

public interface SupplierService {
	Supplier addSupplier(Supplier s);

	List<Supplier> getAllSuppliers();

	Supplier getSupplierById(Long id);

	Supplier updateSupplier(Long id, Supplier s);

	void deleteSupplier(Long id);
}
