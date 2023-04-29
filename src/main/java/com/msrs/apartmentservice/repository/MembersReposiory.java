package com.msrs.apartmentservice.repository;

import com.msrs.apartmentservice.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersReposiory extends JpaRepository<Member, Integer> {
}
