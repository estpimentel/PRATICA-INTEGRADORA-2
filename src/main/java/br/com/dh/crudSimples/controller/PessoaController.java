package br.com.dh.crudSimples.controller;

import br.com.dh.crudSimples.dto.PessoaDTO;
import br.com.dh.crudSimples.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas") // localhost:8080/pessoas
public class PessoaController {
    List<Pessoa> pessoas = new ArrayList<>(); // LISTANDO TODAS AS PESSOAS

    // CONSTRUTOR
    public PessoaController() {
        pessoas.add(new Pessoa(1, "Bruna", "30"));
        pessoas.add(new Pessoa(2, "Jonatas 2", "22"));
        pessoas.add(new Pessoa(3, "Hugo 3", "32"));
    }

    // BUSCANDO PESSOA PELO ID
    @GetMapping("/{id}") // localhost:8080/pessoas/1
    public ResponseEntity<PessoaDTO> getPessoa(@PathVariable int id) {
        Optional<Pessoa> pessoa = pessoas.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if(pessoa.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa.get());
        return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
    }

    // CRIANDO NOVA PESSOA
    @PostMapping
    public ResponseEntity<Pessoa> novaPessoa(@RequestBody Pessoa pessoa) {
        pessoa.setId(pessoas.size() + 1);
        pessoas.add(pessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    // DELETANDO PESSOA PELO ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<Pessoa> pessoa = pessoas.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        if(pessoa.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pessoas.remove(pessoa.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // LISTANDO TODAS AS PESSOAS
    @GetMapping("/all")
    public ResponseEntity<List<Pessoa>> getAll() {
        // return new ResponseEntity<>(pessoas, HttpStatus.OK); -> outro jeito de fazer
        return ResponseEntity.ok(pessoas);
    }
}
