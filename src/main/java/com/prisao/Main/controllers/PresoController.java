package com.prisao.Main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prisao.Main.entities.PresoEntity;
import com.prisao.Main.services.PresoService;

@RestController
@RequestMapping("/preso")
public class PresoController {

	    @Autowired
	    private PresoService presoService;

	    @PostMapping("salvar")
	    public PresoEntity savepreso(@RequestBody PresoEntity presoEntity){
	        return presoService.savepreso(presoEntity);
	    }

	    @GetMapping("findbyid/{id}")
	    public ResponseEntity<PresoEntity> findById(@PathVariable Long id){
	       try {
	    	   return ResponseEntity.ok(presoService.findById(id));
	       }catch (Exception e) {
	    	   System.err.println(e.getCause());
	    	   return ResponseEntity.badRequest().build();
	       }
	    }
	    //e
	    @GetMapping("/findAll")
	    public ResponseEntity<List<PresoEntity>> findAll(){
	       try {
	    	   return ResponseEntity.ok(presoService.findAll());
	       }catch (Exception e) {
	    	   return ResponseEntity.badRequest().build();
	       }
	    }
	    //Deletar1
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<List<PresoEntity>> deleteById(@PathVariable Long id) {
	       try {
	           presoService.deletePresoById(id);
	       
	           List<PresoEntity> presos = presoService.findAll();
	           return ResponseEntity.ok(presos);
	       } catch (Exception e) {
	           System.err.println(e.getCause());
	           return ResponseEntity.badRequest().build();
	       }
	    }
	    
	    @PutMapping("/update/{id}")
	    public ResponseEntity<PresoEntity> updatePreso(@PathVariable Long id, @RequestBody PresoEntity updatePreso) {
	        try {
	            PresoEntity updateEntity = presoService.updatePreso(id, updatePreso);
	            return ResponseEntity.ok(updateEntity);
	        } catch (Exception e) {
	            System.err.println(e.getCause());
	            return ResponseEntity.badRequest().build();
	        }
	    }
	
}
