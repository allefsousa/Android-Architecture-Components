package br.com.developers.allefsousa.architecturecomponents;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by allef on 15/07/2018.
 * Modelo da tabela no banco de dados
 *configuração da tabela
 *
 */


@Entity(tableName = "cliente_table")
public class Cliente implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String nome;
    private String sobrenome;
    private String cpf;

    public Cliente(@NonNull String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public Cliente() {

    }


    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }
}

