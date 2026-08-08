package br.com.marcosrnf.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public String criarMissao(@RequestBody String missao){
        return "Missão criada: " + missao;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public String listarMissaoPorId(@PathVariable Long id){
        return "Listando missao do ID: " + id;
    }

    @PutMapping("/editar/{id}")
    public String editarMissao(@RequestBody String body, @PathVariable Long id){
        return "Editando missão de ID: " + id + "( " + body + " )";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id){
        return "Deletando missão de ID: " + id;
    }
}
