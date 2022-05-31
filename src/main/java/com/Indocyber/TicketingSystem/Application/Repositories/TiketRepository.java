package com.Indocyber.TicketingSystem.Application.Repositories;

import com.Indocyber.TicketingSystem.Application.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TiketRepository extends JpaRepository<Ticket,String> {
@Query(value = """
        SELECT * FROM Ticket WHERE datepart(year,RequestDate) = :tahun
        """,nativeQuery = true)
List<Ticket> tiketByyear(@Param("tahun") Integer tahun);

@Query(value = """
        SELECT * FROM Ticket WHERE Status = :status
        """,nativeQuery = true)
    List<Ticket> tiketByStatus (@Param("status")String status);


    @Query(value = """
        SELECT * FROM Ticket WHERE Urgency = :urgency
        """,nativeQuery = true )
    List<Ticket> tiketByUrgency (@Param("urgency")String urgency);

    @Query(value = """
        SELECT top 1 TiketID FROM Ticket WHERE datepart(year,RequestDate) = :tahun 
        order by TiketID desc
        """,nativeQuery = true)
    String tiketidByyear(@Param("tahun") Integer tahun);


}

