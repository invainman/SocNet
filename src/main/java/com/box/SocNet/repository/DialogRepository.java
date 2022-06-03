package com.box.SocNet.repository;

import com.box.SocNet.model.Dialog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DialogRepository extends JpaRepository<Dialog, Long> {

    @Query("select d from Dialog d where d.firstProfileId=:id or d.secondProfileId=:id")
    List<Dialog> findAllByProfileId(Long id);
}
