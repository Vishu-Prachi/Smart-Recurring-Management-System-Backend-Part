package com.cs.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.demo.Entity.Rdpassbook;

public interface Passbookrepo extends JpaRepository<Rdpassbook, Integer> {

    @Query(value = "SELECT SUM(rdamt) FROM rdpassbook", nativeQuery = true)
    Long getTotalAmt();

    @Query(value = "SELECT * FROM rdpassbook WHERE rid = :rid", nativeQuery = true)
    List<Rdpassbook> getAllByRid(int rid);

    // Join query (returns Object[])
    @Query(value = "SELECT u.name, u.acno, p.rdamt, p.ddate " +
            "FROM rduser u INNER JOIN rdpassbook p ON u.rid = p.rid",
            nativeQuery = true)
    List<Object[]> getUserPassbookDetails();

    @Query(value = "SELECT u.name, u.acno, p.rdamt, p.ddate " +
            "FROM rduser u INNER JOIN rdpassbook p ON u.rid = p.rid " +
            "WHERE p.rid = :rid",
            nativeQuery = true)
    List<Object[]> getUserPassbookDetailsById(int rid);
}