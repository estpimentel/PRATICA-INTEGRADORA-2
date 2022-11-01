package br.com.dh.crudSimples.model;
// AQUI ENTRAM TODOS OS CAMPOS QUE PRECISO PARA MINHA ENTIDADE
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private int id;
    private String nome;
    private String idade;
}
