package br.com.criandoapi.projetoApitesteback.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoapi.projetoApitesteback.model.Usuario;
import br.com.criandoapi.projetoApitesteback.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

	
	private UsuarioService usuarioService;
	
	
	private UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>>  listaUsuarios() {	
		return ResponseEntity.status(200).body(usuarioService.listarUsuario());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario ) {
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {
		usuarioService.deletarUsuario(id);
		return ResponseEntity.status(204).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> validarSenha(@Valid @RequestBody Usuario usuario){
		Boolean valid = usuarioService.validarSenha(usuario);
		if(!valid) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.status(200).build();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> hadleValidationException(MethodArgumentNotValidException excecao){
		Map<String, String> erros = new HashMap<>();
		
		excecao.getBindingResult().getAllErrors().forEach((error) -> {
			String fildName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			erros.put(fildName, errorMessage);
		});
		return erros;
	}
	
}
