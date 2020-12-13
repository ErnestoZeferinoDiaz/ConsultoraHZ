package com.consultorahz.main.Service;

import com.consultorahz.main.Entity.TbProfessorsEntity;
import java.util.List;

public interface ITbProfessorsService {
    public List<TbProfessorsEntity> buscarTodos();
    public TbProfessorsEntity buscarPorId(Long id);
    public TbProfessorsEntity guardar(TbProfessorsEntity pe);
    public void eliminarPorId(Long id);
}
