package com.consultorahz.main.Repository;

import com.consultorahz.main.Entity.TbProfessorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbProfessorsRepository extends JpaRepository<TbProfessorsEntity, Long> {
}
