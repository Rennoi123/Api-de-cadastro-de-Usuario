package expertostech.tutorial.rest.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "usuario")
public  class UsuarioModel {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer codigo;
    public String nome;
    public String login;
    public String senha;
}
