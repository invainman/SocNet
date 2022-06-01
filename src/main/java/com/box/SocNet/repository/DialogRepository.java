package com.box.SocNet.repository;

import com.box.SocNet.model.Dialog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialogRepository extends JpaRepository<Dialog, Long> {

    Dialog getByProfileId (Long profileId);

    Dialog getByIdTo (Long idTo);
}
