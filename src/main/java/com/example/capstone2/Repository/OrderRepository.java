package com.example.capstone2.Repository;

import com.example.capstone2.Model.Orderr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orderr,Integer> {
   Orderr findOrderrByOrderID(Integer id);

    @Query("select '*' from Orderr o where o.ticketID = ?1")
    Orderr findOrderrByTicketID(Integer id);

}