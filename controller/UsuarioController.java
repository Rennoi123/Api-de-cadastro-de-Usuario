package expertostech.tutorial.rest.api.controller;

import expertostech.tutorial.rest.api.model.UsuarioModel;
import expertostech.tutorial.rest.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    //Este método serve para retornar todos os valores do Banco de Dados.
    @GetMapping("/todos")
    public Iterable<UsuarioModel> RetornarTodos() {
        Iterable<UsuarioModel> usermodel = repository.findAll();
        return usermodel;
    }

    @GetMapping(path = "/consulta/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {  //@PathVariable esta definindo que o "código" no getmapping é o mesmo que sera digitado
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());

        // pegou o repositorio e usou o findbyID ( metodo para consulta por ID
        // chama o metodo map e se por um acaso o metodo retornou algo, ele traz um "ok" e monta o corpo da requisção com o registro (record)
        //  caso ele não de certo, o orElse retorna um build
    }

    // RequestBody diz que os dados do usuario serão enviados no corpo da requisisão
    @PostMapping("/salvar")
    public UsuarioModel salvar(@RequestBody UsuarioModel usermodel) {
        return repository.save(usermodel);
    }

    @PutMapping(path = "/altera/{codigo}")

    public ResponseEntity<UsuarioModel> update(@PathVariable long codigo, @RequestBody UsuarioModel usermodel) {
        if (!UsuarioRepository.existsById(codigo)) {
            return ResponseEntity.notFound().build();
        }
        usermodel.setCodigo((int) codigo);
        usermodel = repository.save(usermodel);

        return ResponseEntity.ok(usermodel);

    }

    @DeleteMapping("/delete/{codigo}")
    public void delete(@PathVariable long codigo) {

        if (!UsuarioRepository.existsById(codigo)) {
            UsuarioRepository.deleteById(codigo);
        }
    }
    @DeleteMapping ("/delete/todos/")
    public void deleteALL() {
        UsuarioRepository.deleteALL();
    }

    }
