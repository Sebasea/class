package co.edu.unisabana.siga.controller;

import co.edu.unisabana.siga.bd.Estudiante;
import co.edu.unisabana.siga.bd.EstudianteRepository;
import co.edu.unisabana.siga.controller.dto.RespuestaDTO;
import co.edu.unisabana.siga.logica.EstudianteLogica;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudianteController {

  private EstudianteLogica logica;

  public EstudianteController(EstudianteLogica logica) {
    this.logica = logica;
  }


  @PostMapping(path = "/estudiante/agregar")
  public RespuestaDTO guardarEstudiante(@RequestBody Estudiante estudiante) {
    try {
      logica.guardarEstudiante(estudiante);
      return new RespuestaDTO("Estudiante guardado correctamente");
    } catch (IllegalArgumentException e) {
      return new RespuestaDTO("Estudiante con nombre prohibido");
    }
  }

}
