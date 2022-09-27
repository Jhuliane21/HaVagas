package com.example.havagas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.havagas.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {
    private static final Object VALOR_ET_DINAMICO = "";
    private ActivityMainBinding amb;
    private Pessoa pessoa;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());
        amb.salvarBt.setOnClickListener(view -> {
            pessoa = new Pessoa(
                    amb.nomeEt.getText().toString(),
                    amb.emailEt.getText().toString(),
                    amb.telefoneEt.getText().toString(),
                    amb.femininoRb.isChecked() ? "feminino" : "masculino",
                    amb.dataNascimentoEt.getText().toString(),
                    amb.formacaoSp.getSelectedItem().toString(),
                    amb.interessesEt.getText().toString()
            );
            Toast.makeText(this, pessoa.toString(), Toast.LENGTH_SHORT).show();
        });
        amb.limparBt.setOnClickListener(view -> {
            amb.nomeEt.setText("");
            amb.telefoneEt.setText("");
            amb.emailEt.setText("");
            amb.dataNascimentoEt.setText("");
            amb.formacaoSp.setSelection(0);
            amb.femininoRb.setChecked(true);
            amb.masculinoRb.setChecked(false);
            amb.interessesEt.setText("");
            amb.anoConclusao.setText("");
            pessoa = null;
        });
        amb.formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {//View pai, a view clicada, posição clicada e o tamanho
                if (i == 0 || i == 1) {
                    amb.anoFormacao.setVisibility(View.VISIBLE);
                } else {
                    amb.anoFormacao.setVisibility(View.GONE);
                }
                if (i == 2 || i == 3) {
                    amb.anoConclusao.setVisibility(View.VISIBLE);
                    amb.instituicao.setVisibility(View.VISIBLE);
                } else {
                    amb.anoConclusao.setVisibility(View.GONE);
                    amb.instituicao.setVisibility(View.GONE);

                }
                if (i == 4 || i == 5) {
                    amb.tituloMonografia.setVisibility(View.VISIBLE);
                    amb.orientador.setVisibility(View.VISIBLE);
                } else {
                    amb.tituloMonografia.setVisibility(View.GONE);
                    amb.orientador.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        if (amb.informarCelular.isActivated()) {
            amb.celularEt.setVisibility(View.GONE);
        }

        }



    }


