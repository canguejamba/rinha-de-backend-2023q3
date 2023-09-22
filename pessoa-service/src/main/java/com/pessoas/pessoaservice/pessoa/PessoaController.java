package com.pessoas.pessoaservice.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = PessoaController.BASE_URL)
public class PessoaController {
  public static final String BASE_URL = "/v1/pessoas";

  @PostMapping("")
  public ResponseEntity<Pessoa> criaPessoas(@Valid @RequestBody CriaPessoaDto criaPessoaDto) {
    Pessoa pessoa = new Pessoa(criaPessoaDto);
    return ResponseEntity.ok().body(pessoa);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pessoa> buscaPessoas(@PathVariable String id) {
    CriaPessoaDto criaPessoaDto = new CriaPessoaDto();
    Pessoa pessoa = new Pessoa(criaPessoaDto);
    return ResponseEntity.ok().body(pessoa);
  }

  @GetMapping("/query")
  public ResponseEntity<List<Pessoa>> termoBuscaPessoas(@Valid @RequestParam(value = "termoBusca") String termoBusca) {
    CriaPessoaDto criaPessoaDto = new CriaPessoaDto();
    Pessoa pessoa = new Pessoa(criaPessoaDto);
    List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
    listaPessoas.add(0, pessoa);
    return ResponseEntity.ok().body(listaPessoas);
  }

  private static final String template = "Hola numero, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/contagem-pessoas")
  public ResponseEntity<String> contagemPessoas() {
    return ResponseEntity.ok().body(String.format(template, counter.incrementAndGet()));
  }
}
