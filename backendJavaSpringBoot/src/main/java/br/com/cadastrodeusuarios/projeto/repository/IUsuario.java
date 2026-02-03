package br.com.cadastrodeusuarios.projeto.repository;

import br.com.cadastrodeusuarios.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);
}
