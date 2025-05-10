package org.example.ecommerceproject.repository;

import org.example.ecommerceproject.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Phone getPhoneByModelName(String modelName);
}
