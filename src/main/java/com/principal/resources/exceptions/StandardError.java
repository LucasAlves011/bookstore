package com.principal.resources.exceptions;

import java.time.LocalDateTime;

public class StandardError {

    private LocalDateTime dataHora;
    private Integer status;
    private String message;

    public StandardError(LocalDateTime data, Integer status, String message) {
        this.dataHora = data;
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StandardError() {
        super();
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
