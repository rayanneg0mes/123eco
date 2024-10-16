package br.com.projeto._123eco.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto._123eco.model.entity.Usuario;
import br.com.projeto._123eco.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		List<Usuario> usuario = usuarioRepository.findAll();
		return usuario;
	}

	public Usuario findById(long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow();
		return usuario;
	}

	public Usuario findByEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		return usuario;

	}

	@Transactional
	public Usuario create(Usuario usuario) {
		
		Usuario _usuario = usuarioRepository.findByEmail(usuario.getEmail());

		if (_usuario == null) {
			String senha = Base64.getEncoder()
					.encodeToString("12345678".getBytes());
			
			usuario.setSenha(senha);
			usuario.setDataCadastro(LocalDateTime.now());
			usuario.setStatusUsuario("ATIVO");
			
			return usuarioRepository.save(usuario);
		}
		return null;
		
	}
	
	@Transactional
	public Usuario signin(String email, String senha) {

		Usuario usuario = usuarioRepository.findByEmail(email);

		if (usuario != null) {
			if (!usuario.getStatusUsuario().equals("INATIVO")) {
				byte[] decodePass = Base64.getDecoder().decode(usuario.getSenha());
				if (new String(decodePass).equals(senha)) {
					return usuario;
				}
			}
		}
		return null;
	}

	@Transactional
	public Usuario inativar(long id) {
		Optional<Usuario> _usuario = usuarioRepository.findById(id);

		if (_usuario.isPresent()) {
			Usuario usuarioAtualizada = _usuario.get();
			usuarioAtualizada.setStatusUsuario("INATIVO");

			return usuarioRepository.save(usuarioAtualizada);
		}
		return null;
	}

	@Transactional
	public Usuario reativar(long id) {
		Optional<Usuario> _usuario = usuarioRepository.findById(id);

		if (_usuario.isPresent()) {
			Usuario usuarioAtualizado = _usuario.get();
			usuarioAtualizado.setStatusUsuario("ATIVO");
			usuarioAtualizado.setDataCadastro(LocalDateTime.now());
			String senha = Base64.getEncoder().encodeToString("12345678".getBytes());
			usuarioAtualizado.setSenha(senha);

			return usuarioRepository.save(usuarioAtualizado);
		}
		return null;
	}

	@Transactional
	public Usuario alterarSenha(long id, Usuario usuario) {
		Optional<Usuario> _usuario = usuarioRepository.findById(id);

		if (_usuario.isPresent()) {
			Usuario usuarioAtualizada = _usuario.get();

			String senha = Base64.getEncoder().encodeToString(usuario.getSenha().getBytes());
			usuarioAtualizada.setSenha(senha);

			return usuarioRepository.save(usuarioAtualizada);
		}
		return null;
	}
}
