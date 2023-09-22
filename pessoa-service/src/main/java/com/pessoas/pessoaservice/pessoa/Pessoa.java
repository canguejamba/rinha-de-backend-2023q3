package com.pessoas.pessoaservice.pessoa;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
  private UUID id;
  private String apelido;
  private String nome;
  private LocalDate nascimento;
  private String[] stack;

  public Pessoa(CriaPessoaDto dadosPessoa) {
    super();
    this.id = geraUuid();
    this.apelido = dadosPessoa.getApelido();
    this.nome = dadosPessoa.getNome();
    this.nascimento = dadosPessoa.getNascimento();
    this.stack = dadosPessoa.getStack();
  }

  private UUID geraUuid() {
    UUID novoUuid = UUID.randomUUID();
    System.out.println("UUID: " + novoUuid);
    return novoUuid;
  }

}
