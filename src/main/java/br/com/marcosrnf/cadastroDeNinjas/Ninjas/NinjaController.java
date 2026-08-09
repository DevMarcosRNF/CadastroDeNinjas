package br.com.marcosrnf.cadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Rota de boas vindas", description = "Rota de boas vindas da aplicação")
    public String boasVindas(){
        return "Essa é a tela de boas vindas! ";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um ninja", description = "Cria um ninja com os dados que foram enviados no corpo da requisição e salva no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao Criar o ninja")
    })
    public ResponseEntity<String> criarNinja(
            @Parameter(description = "Dados do ninja que serão enviados no corpo da requisição")
            @RequestBody NinjaDTO ninja){
        ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criado com sucesso. Nome: " + ninja.getNome());
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista ninjas", description = "Lista todos os ninjas cadastrados no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conseguiu listar todos os ninjas"),
            @ApiResponse(responseCode = "404", description = "Aconteceu algum erro, não conseguiu listar os ninjas")
    })
    public ResponseEntity<List<NinjaDTO>> buscarTodosNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja pelo ID", description = "Busca um ninja de acordo com o ID passado no PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "404", description = "Não conseguiu obter os dados do ninja")
    })
    public ResponseEntity<?> buscarNinjaPorId(
            @Parameter(description = "ID que será passado no PathVariable")
            @PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado nos nossos registros!");
        }
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Edita um ninja", description = "Edita um ninja de acordo com o ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja editado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado. Não é possível editar.")
    })
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
    @Operation(summary = "Deleta um ninja",description = "Deleta um ninja de acordo com o ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinja(
            @Parameter(description = "ID que será passado no PathVariable")
            @PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de ID " + id + " não encontrado");
        }
    }
}
