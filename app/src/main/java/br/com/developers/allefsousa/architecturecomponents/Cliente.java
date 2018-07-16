package br.com.developers.allefsousa.architecturecomponents;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by allef on 15/07/2018.
 * Modelo da tabela no banco de dados
 *configuração da tabela
 *
 */


@Entity(tableName = "cliente_table")
public class Cliente {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String nome;

    private String sobrenome;

    @ColumnInfo(name = "documento")
    @NonNull
    private String cpf;


    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @NonNull
    public String getCpf() {
        return cpf;
    }

    public void setCpf(@NonNull String cpf) {
        this.cpf = cpf;
    }
}

