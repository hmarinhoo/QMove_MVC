package main.java.br.com.fiap.QMove_MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.qmove.model.Setor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SetorRepository extends JpaRepository<Setor, Long>, JpaSpecificationExecutor<Setor> {
}
    
