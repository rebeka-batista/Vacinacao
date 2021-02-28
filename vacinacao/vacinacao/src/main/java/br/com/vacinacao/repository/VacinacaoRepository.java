package br.com.vacinacao.repository;

import br.com.vacinacao.entity.VacinacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinacaoRepository extends JpaRepository<VacinacaoEntity, Integer> {
}