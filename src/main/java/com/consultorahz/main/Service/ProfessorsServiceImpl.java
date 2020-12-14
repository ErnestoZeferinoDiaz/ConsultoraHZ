package com.consultorahz.main.Service;

import com.consultorahz.main.Entity.ProfessorsEntity;
import com.consultorahz.main.Repository.ProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service(value = "ProfessorsService")
public class ProfessorsServiceImpl implements IProfessorsService {

    @Autowired
    private ProfessorsRepository professorsRepository;

    @Override
    @Transactional(readOnly=true)
    public List<ProfessorsEntity> buscarTodos() {
        return this.professorsRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public ProfessorsEntity buscarPorId(Long id) {
        return this.professorsRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ProfessorsEntity guardar(ProfessorsEntity pe) {
        ProfessorsEntity tmp = this.professorsRepository.save(pe);
        return tmp;
    }



    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        this.professorsRepository.deleteById(id);
    }
}
