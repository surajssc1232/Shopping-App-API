package org.assigenment.shoppingappbackend.Repo;

import org.assigenment.shoppingappbackend.Model.Userss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Userss, Long> {


}