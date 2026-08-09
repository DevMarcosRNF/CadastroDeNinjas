package br.com.marcosrnf.cadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a tela de boas vindas! ";
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criado com sucesso. Nome: " + ninja.getNome());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> buscarTodosNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarNinjaPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado nos nossos registros!");
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarNinja(@RequestBody NinjaDTO ninja, @PathVariable Long id){
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjaPorId(id);
        if(ninjaEncontrado != null){
            NinjaDTO ninjaEditado = ninjaService.editarNinja(ninja, id);
            return ResponseEntity.ok(ninjaEditado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID " + id + " não encontrado!");
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de ID " + id + " não encontrado");
        }
    }
}
