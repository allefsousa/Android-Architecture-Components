package br.com.developers.allefsousa.architecturecomponents;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by allef on 15/07/2018.
 * Criando a instancia do banco de dados
 * todas as tabelas criadas seram adicionada aqui
 */
@Database(entities = {Cliente.class}, version = 1, exportSchema = false)
public abstract class ClienteRoomDatabase extends RoomDatabase {

    private static ClienteRoomDatabase instance;

    // metodo abstrato
    public abstract DaoCliente daoCliente();

    static ClienteRoomDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (ClienteRoomDatabase.class) {
                if (instance == null) {
                    // Criar o banco de dados
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ClienteRoomDatabase.class,"cliente_table").build();
                }
            }
        }

        return instance;
    }

}
