package com.pessoas.pessoaservice.pessoa;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CriaPessoaDto {
  private String apelido;
  private String nome;
  private LocalDate nascimento;
  private String[] stack;
}
