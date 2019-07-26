package br.com.rodrigo.cursomc.repository;

import br.com.rodrigo.cursomc.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
