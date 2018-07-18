package br.com.developers.allefsousa.architecturecomponents;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allef on 15/07/2018.
 */

public class AdapterCleinte extends RecyclerView.Adapter<AdapterCleinte.WordViewHolder>{

    private final LayoutInflater mInflater;
    private List<Cliente> clientesList;


    public AdapterCleinte(Context context) {
        mInflater =LayoutInflater.from(context);
        clientesList = new ArrayList<>();
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_main, parent, false);
        return new WordViewHolder(itemView);
    }



    @Override
    public int getItemCount() {

        return clientesList != null ? clientesList.size() : 0;
    }
    void setClientes(List<Cliente> clie) {
        clientesList = clie;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Cliente cliente = clientesList.get(position);
        holder.nome.setText("Nome: "+cliente.getNome());
        holder.Sobrenome.setText("Sobrenome: "+cliente.getSobrenome());
        holder.cpf.setText("Cpf: "+cliente.getCpf());
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        private  TextView nome;
        private  TextView Sobrenome;
        private  TextView cpf;
         WordViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.tvnome);
            Sobrenome = itemView.findViewById(R.id.tvsobre);
            cpf = itemView.findViewById(R.id.tvcpf);
         }
    }
}
