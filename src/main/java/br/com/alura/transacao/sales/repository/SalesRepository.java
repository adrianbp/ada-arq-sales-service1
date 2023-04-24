package br.com.alura.transacao.sales.repository;

import br.com.alura.transacao.sales.model.entity.Banca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<Banca, Long> {
}
