package com.consultorahz.main.Service;

import com.consultorahz.main.Entity.ProfessorsEntity;
import java.util.List;

public interface IProfessorsService {
    public List<ProfessorsEntity> buscarTodos();
    public ProfessorsEntity buscarPorId(Long id);
    public ProfessorsEntity guardar(ProfessorsEntity pe);
    public void eliminarPorId(Long id);
}
