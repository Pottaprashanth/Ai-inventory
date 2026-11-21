package com.inventory.smartinventory.serviceimpl;

import com.inventory.smartinventory.entity.Supplier;
import com.inventory.smartinventory.repository.SupplierRepository;
import com.inventory.smartinventory.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
	private final SupplierRepository repo;

	public SupplierServiceImpl(SupplierRepository r) {
		repo = r;
	}

	public Supplier addSupplier(Supplier s) {
		return repo.save(s);
	}

	public List<Supplier> getAllSuppliers() {
		return repo.findAll();
	}

	public Supplier getSupplierById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
	}

	public Supplier updateSupplier(Long id, Supplier s) {
		Supplier old = getSupplierById(id);
		old.setName(s.getName());
		old.setEmail(s.getEmail());
		old.setPhone(s.getPhone());
		old.setAddress(s.getAddress());
		return repo.save(old);
	}

	public void deleteSupplier(Long id) {
		repo.delete(getSupplierById(id));
	}
}
