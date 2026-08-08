package br.com.marcosrnf.cadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a tela de boas vindas! ";
    }

    @PostMapping("/criar")
    public String criarNinja(@RequestBody String ninja){
        return "Ninja criado com sucesso!" + ninja;
    }

    @GetMapping("/buscar-todos")
    public String buscarTodosOsNinjas(){
        return "Buscando todos os ninjas...";
    }

    @GetMapping("/buscar-por-id/{id}")
    public String buscarNinjaPorId(@PathVariable Long id){
        return "Buscando o ninja de ID " + id + "!";
    }

    @PutMapping("/editar/{id}")
    public String editarNinja(@RequestBody String ninja, @PathVariable Long id){
        return "Editando o ninja " + ninja + " de ID" + id;
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id){
        return "Esse método será VOID futuramente. deletando ninja de ID " + id;
    }
}
