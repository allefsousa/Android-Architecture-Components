package br.com.developers.allefsousa.architecturecomponents;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * Created by allef on 15/07/2018.
 */

public class ClienteViewModel extends ViewModel {
    private ClienteRepository clienteRepository;
    private LiveData<List<Cliente>> listLiveData;

    public ClienteViewModel(Application application) {
        clienteRepository = new ClienteRepository(application);
        listLiveData = clienteRepository.getLiveData();
    }


    public void postCliente(Cliente cliente) {
        clienteRepository.insertCliente(cliente);
    }



    public LiveData<List<Cliente>> getAll() {
        return listLiveData;
    }
}
