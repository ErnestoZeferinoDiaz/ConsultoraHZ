package com.consultorahz.main.Controller;

import com.consultorahz.main.Entity.TbProfessorsEntity;
import com.consultorahz.main.Service.ITbProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TbProfessors")
public class TbProfessorsController {
    @Autowired
    @Qualifier("TbProfessorsService")
    private ITbProfessorsService iTbProfessorsService;

    @GetMapping(value="/professors")
    public ResponseEntity<List<TbProfessorsEntity>> getProfessors(){
        return new ResponseEntity(this.iTbProfessorsService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping(value="/professors", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TbProfessorsEntity> saveProffesor(@RequestBody TbProfessorsEntity tbProfessorsEntity){
        return new ResponseEntity(this.iTbProfessorsService.guardar(tbProfessorsEntity), HttpStatus.OK);
    }

    @GetMapping(value="/professors/{idProfessor}")
    public ResponseEntity<TbProfessorsEntity> getProffesorById(@PathVariable(name="idProfessor") Long tbProfessorsId){
        return new ResponseEntity(this.iTbProfessorsService.buscarPorId(tbProfessorsId), HttpStatus.OK);

    }

    @PutMapping(value="/professors/{idProfessor}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TbProfessorsEntity> updateProffesorById(@RequestBody TbProfessorsEntity tbProfessorsEntity){
        System.out.println(tbProfessorsEntity);
        return new ResponseEntity(this.iTbProfessorsService.guardar(tbProfessorsEntity), HttpStatus.OK);

    }

    @DeleteMapping(value="/professors/{idProfessor}")
    public ResponseEntity<Long> deleteProffesorById(@PathVariable(name="idProfessor") Long tbProfessorsId){
        this.iTbProfessorsService.eliminarPorId(tbProfessorsId);
        return new ResponseEntity(tbProfessorsId,HttpStatus.OK);
    }


}
