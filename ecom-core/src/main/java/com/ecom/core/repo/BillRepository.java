package com.ecom.core.repo;

import com.ecom.core.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bills, String> {

}
