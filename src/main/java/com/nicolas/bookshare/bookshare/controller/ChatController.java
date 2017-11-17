package com.nicolas.bookshare.bookshare.controller;

import com.nicolas.bookshare.bookshare.model.Mensagem;
import com.nicolas.bookshare.bookshare.model.response.MensagemResponse;
import com.nicolas.bookshare.bookshare.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class ChatController {
    private MensagemRepository mensagemRepository;

    @Autowired
    public ChatController(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    @PostMapping("/enviar-mensagem")
    public MensagemResponse enviarMensagem(@RequestBody Mensagem mensagem) {
        mensagem.setSendDate(new Date());
        MensagemResponse response = new MensagemResponse();
        try {
            mensagemRepository.save(mensagem);
            response.setSucesso(true);
            response.setMensagem(mensagem);
            return response;
        } catch (Exception e) {
            response.setSucesso(false);
            return response;
        }
    }

    @GetMapping("/get-mensagens")
    public List<Mensagem> getMensagens(@RequestParam("sender") String sender, @RequestParam("receiver") String receiver) {
        ArrayList<Mensagem> mensagens = new ArrayList<>();
        try {
            mensagens.addAll(mensagemRepository.findBySenderAndReceiver(sender, receiver));
            mensagens.addAll(mensagemRepository.findBySenderAndReceiver(receiver, sender));
            mensagens.sort(Comparator.comparing(Mensagem::getSendDate));
            return mensagens;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @GetMapping("/get-destinatarios")
    public List<String> getDestinatarios(@RequestParam("sender") String sender) {
        try {
            List<Mensagem> mensagens = mensagemRepository.findMensagemDistinctBySender(sender);
            List<String> destinatarios = new ArrayList<>();
            for (Mensagem mensagem : mensagens) {
                if(!destinatarios.contains(mensagem.getReceiver())) {
                    destinatarios.add(mensagem.getReceiver());
                }
            }
            return destinatarios;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
