package org.assigenment.shoppingappbackend.Service;

import org.assigenment.shoppingappbackend.Model.Inventory;
import org.assigenment.shoppingappbackend.Model.Order;
import org.assigenment.shoppingappbackend.Repo.InventryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShoppingService {

    @Autowired
    InventryRepo inventryRepo;
    public List<Inventory> getInventory() {
        return inventryRepo.findAll();
    }





}
