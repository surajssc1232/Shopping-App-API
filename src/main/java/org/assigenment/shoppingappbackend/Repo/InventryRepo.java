package org.assigenment.shoppingappbackend.Repo;

import org.assigenment.shoppingappbackend.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventryRepo extends JpaRepository<Inventory, Integer>{

}
