package com.consultorahz.main.Controller;

import com.consultorahz.main.Entity.ProfessorsEntity;
import com.consultorahz.main.Service.IProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Professors")
public class ProfessorsController {
    @Autowired
    @Qualifier("ProfessorsService")
    private IProfessorsService iProfessorsService;

    @GetMapping(value="/professors")
    public ResponseEntity<List<ProfessorsEntity>> getProfessors(){
        return new ResponseEntity(this.iProfessorsService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping(value="/professors", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessorsEntity> saveProffesor(@RequestBody ProfessorsEntity professorsEntity){
        return new ResponseEntity(this.iProfessorsService.guardar(professorsEntity), HttpStatus.OK);
    }

    @GetMapping(value="/professors/{idProfessor}")
    public ResponseEntity<ProfessorsEntity> getProffesorById(@PathVariable(name="idProfessor") Long tbProfessorsId){
        return new ResponseEntity(this.iProfessorsService.buscarPorId(tbProfessorsId), HttpStatus.OK);

    }

    @PutMapping(value="/professors/{idProfessor}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessorsEntity> updateProffesorById(@RequestBody ProfessorsEntity professorsEntity){
        System.out.println(professorsEntity);
        return new ResponseEntity(this.iProfessorsService.guardar(professorsEntity), HttpStatus.OK);

    }

    @DeleteMapping(value="/professors/{idProfessor}")
    public ResponseEntity<Long> deleteProffesorById(@PathVariable(name="idProfessor") Long tbProfessorsId){
        this.iProfessorsService.eliminarPorId(tbProfessorsId);
        return new ResponseEntity(tbProfessorsId,HttpStatus.OK);
    }


}
