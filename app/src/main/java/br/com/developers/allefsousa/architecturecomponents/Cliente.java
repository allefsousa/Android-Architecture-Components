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
public class Cliente  {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String nome;

    public Cliente(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }
}

