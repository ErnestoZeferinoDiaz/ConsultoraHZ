package com.consultorahz.main.Service;

import com.consultorahz.main.Entity.TbProfessorsEntity;
import com.consultorahz.main.Repository.TbProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service(value = "TbProfessorsService")
public class TbProfessorsServiceImpl implements ITbProfessorsService{

    @Autowired
    private TbProfessorsRepository tbProfessorsRepository;

    @Override
    @Transactional(readOnly=true)
    public List<TbProfessorsEntity> buscarTodos() {
        return this.tbProfessorsRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public TbProfessorsEntity buscarPorId(Long id) {
        return this.tbProfessorsRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public TbProfessorsEntity guardar(TbProfessorsEntity pe) {
        TbProfessorsEntity tmp = this.tbProfessorsRepository.save(pe);
        return tmp;
    }



    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        this.tbProfessorsRepository.deleteById(id);
    }
}
