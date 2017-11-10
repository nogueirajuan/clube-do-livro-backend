package com.nicolas.bookshare.bookshare.repository;

import com.nicolas.bookshare.bookshare.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    List<Mensagem> findBySenderAndReceiver(String sender, String receiver);
    List<Mensagem> findMensagemDistinctBySender(String sender);
}
