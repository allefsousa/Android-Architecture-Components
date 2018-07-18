package br.com.developers.allefsousa.architecturecomponents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdicionarClienteActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    @BindView(R.id.inpCpf)
    TextInputEditText cpf;
    @BindView(R.id.inpSobre)
    TextInputEditText sobre;
    @BindView(R.id.inpNome)
    TextInputEditText nome;
    @BindView(R.id.btnsalvar)
    Button buttonsalve;
    Cliente cc;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adicionar_cliente);
        ButterKnife.bind(this);
        buttonsalve.setOnClickListener((View v) -> {
            Intent replyIntent = new Intent();

            if (TextUtils.isEmpty(nome.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                Cliente cliente = new Cliente();
                cliente.setNome(nome.getText().toString());
                cliente.setCpf(cpf.getText().toString());
                cliente.setSobrenome(sobre.getText().toString());
                String cc;
                replyIntent.putExtra(EXTRA_REPLY, cliente);
                setResult(RESULT_OK, replyIntent);
            }

            finish();
        });
    }
}
