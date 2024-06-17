package org.assigenment.shoppingappbackend.Repo;

import org.assigenment.shoppingappbackend.Model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<product, Long> {

}