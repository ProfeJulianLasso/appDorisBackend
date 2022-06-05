package org.sofka.appdorisbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class IndexController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Response response = new Response();

    @GetMapping(path = "/usuarios")
    public ResponseEntity<Response> index() {
        response.message = "Hola Mundo desde un API - Get All";

        // Esto se hace en el servicio ---
        response.data = usuarioRepository.findAll();
        // -------------------------------

        response.status = HttpStatus.OK.value();
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/usuario")
    public ResponseEntity<Response> index(@RequestBody Usuario usuario) {
        response.message = "Hola Mundo desde un API - New User";

        // Esto se hace en el servicio ---
        Usuario newUser = usuarioRepository.save(usuario);
        // -------------------------------

        response.data = newUser;
        response.status = HttpStatus.CREATED.value();
        return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }
}
