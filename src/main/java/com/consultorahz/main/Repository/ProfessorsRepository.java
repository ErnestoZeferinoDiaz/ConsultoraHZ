package com.consultorahz.main.Repository;

import com.consultorahz.main.Entity.ProfessorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorsRepository extends JpaRepository<ProfessorsEntity, Long> {
}
