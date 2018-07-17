package br.com.developers.allefsousa.architecturecomponents;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

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
                            ClienteRoomDatabase.class,"cliente_table").addCallback(sCallback)
                            .build();
                }
            }
        }

        return instance;
    }
    private static RoomDatabase.Callback sCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(instance).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final DaoCliente dao;

        PopulateDbAsync(ClienteRoomDatabase db) {
            dao = db.daoCliente();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            dao.deleteAll();

            Cliente word1 = new Cliente("Next");
            dao.postCliente(word1);

            Cliente word = new Cliente("Movileeeee");
            dao.postCliente(word);

            return null;
        }
    }

}
