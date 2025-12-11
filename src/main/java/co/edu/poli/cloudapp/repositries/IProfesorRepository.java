package co.edu.poli.cloudapp.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.cloudapp.entities.Profesor;

public interface IProfesorRepository extends JpaRepository<Profesor, Long> {

}
