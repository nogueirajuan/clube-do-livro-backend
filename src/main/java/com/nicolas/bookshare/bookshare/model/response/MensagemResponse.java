package com.nicolas.bookshare.bookshare.model.response;

import com.nicolas.bookshare.bookshare.model.Mensagem;
import lombok.Data;

@Data
public class MensagemResponse {
    private boolean sucesso;
    private Mensagem mensagem;
}
