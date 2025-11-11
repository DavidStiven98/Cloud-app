package co.edu.poli.cloudapp.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.cloudapp.entities.Estudiante;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {

}
