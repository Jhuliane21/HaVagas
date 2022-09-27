package com.example.havagas

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.havagas.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private var amb: ActivityMainBinding? = null
    private var pessoa: Pessoa? = null

    private companion object{//tudo que está aqui dentro vai ser estatico
        const val VALOR_NOME_ET = ""
        const val VALOR_EMAIL_ET = ""
        const val VALOR_TELEFONE_ET = ""
        const val VALOR_NASCIMENTO_ET = ""
        const val VALOR_INTERESSES_ET = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb!!.root)
        amb!!.salvarBt.setOnClickListener { view ->
            pessoa = Pessoa(
                amb!!.nomeEt.text.toString(),
                amb!!.emailEt.text.toString(),
                amb!!.telefoneEt.text.toString(),
                if (amb!!.femininoRb.isChecked) "feminino" else "masculino",
                amb!!.dataNascimentoEt.text.toString(),
                amb!!.formacaoSp.selectedItem.toString(),
                amb!!.interessesEt.text.toString()
            )
            Toast.makeText(this, pessoa.toString(), Toast.LENGTH_SHORT).show()
        }
        amb!!.limparBt.setOnClickListener { view ->
            amb!!.nomeEt.setText("")
            amb!!.telefoneEt.setText("")
            amb!!.emailEt.setText("")
            amb!!.dataNascimentoEt.setText("")
            amb!!.formacaoSp.setSelection(0)
            amb!!.femininoRb.isChecked = true
            amb!!.masculinoRb.isChecked = false
            amb!!.interessesEt.text = ""
            amb!!.anoConclusao.setText("")
            pessoa = null
        }
        amb!!.formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                i: Int,
                l: Long
            ) { //View pai, a view clicada, posição clicada e o tamanho
                if (i == 0 || i == 1) {
                    amb!!.anoFormacao.visibility = View.VISIBLE
                } else {
                    amb!!.anoFormacao.visibility = View.GONE
                }
                if (i == 2 || i == 3) {
                    amb!!.anoConclusao.visibility = View.VISIBLE
                    amb!!.instituicao.visibility = View.VISIBLE
                } else {
                    amb!!.anoConclusao.visibility = View.GONE
                    amb!!.instituicao.visibility = View.GONE
                }
                if (i == 4 || i == 5) {
                    amb!!.tituloMonografia.visibility = View.VISIBLE
                    amb!!.orientador.visibility = View.VISIBLE
                } else {
                    amb!!.tituloMonografia.visibility = View.GONE
                    amb!!.orientador.visibility = View.GONE
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
        if (amb!!.informarCelular.isActivated) {
            amb!!.celularEt.visibility = View.GONE
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VALOR_NOME_ET, amb!!.nomeEt.text.toString())
        outState.putString(VALOR_EMAIL_ET, amb!!.emailEt.text.toString())
        outState.putString(VALOR_TELEFONE_ET, amb!!.telefoneEt.text.toString())
        outState.putString(VALOR_NASCIMENTO_ET, amb!!.dataNascimentoEt.text.toString())
        outState.putString(VALOR_INTERESSES_ET, amb!!.interessesEt.text.toString())


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val nomeSalvo: String = savedInstanceState.getString(VALOR_NOME_ET, "")
        val emailSalvo: String = savedInstanceState.getString(VALOR_EMAIL_ET, "")
        val telefoneSalvo: String = savedInstanceState.getString(VALOR_TELEFONE_ET, "")
        val dataSalvo: String = savedInstanceState.getString(VALOR_NASCIMENTO_ET, "")
        val interessesSalvo: String = savedInstanceState.getString(VALOR_INTERESSES_ET, "")

        amb!!.nomeEt.setText(nomeSalvo)
        amb!!.emailEt.setText(emailSalvo)
        amb!!.telefoneEt.setText(telefoneSalvo)
        amb!!.dataNascimentoEt.setText(dataSalvo)
        amb!!.interessesEt.setText(interessesSalvo)


    }




}