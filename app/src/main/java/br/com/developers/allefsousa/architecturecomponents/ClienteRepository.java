package br.com.developers.allefsousa.architecturecomponents;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by allef on 15/07/2018.
 */

public class ClienteRepository {
    // injetando as interfaces
    private DaoCliente daoCliente;

    private LiveData<List<Cliente>> liveData;

    public ClienteRepository(Application application) {
        ClienteRoomDatabase roomDatabase = ClienteRoomDatabase.getDatabase(application);
        daoCliente = roomDatabase.daoCliente();
        liveData = daoCliente.getAll();

    }
    public void insertCliente(Cliente cliente){
        new insertAsyncTask(daoCliente).execute(cliente);

    }

    private static class insertAsyncTask extends AsyncTask<Cliente, Void, Void> {

        private DaoCliente mAsyncTaskDao;

        insertAsyncTask(DaoCliente dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Cliente... pcliente) {
            mAsyncTaskDao.postCliente(pcliente[0]);
            return null;
        }
    }
}
