package br.com.cadastrodeusuarios.projeto.service;

import br.com.cadastrodeusuarios.projeto.model.Usuario;
import br.com.cadastrodeusuarios.projeto.repository.IUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;

@Service
public class UsuarioService {

    private final ResourceUrlProvider resourceUrlProvider;
    private IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository, ResourceUrlProvider resourceUrlProvider){
        this.repository = repository;
        this.resourceUrlProvider = resourceUrlProvider;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listaUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario){
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }

    public Usuario editarUsuario(Usuario usuario){
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }

    public Boolean excluirUsuario(Integer id){
        repository.deleteById(id);
        return true;
    }


    public Boolean validarSenha(Usuario usuario) {

        String senha = repository.getById(usuario.getId()).getSenha();
        boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }

}
