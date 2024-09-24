package br.com.aula.text;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
// Atributos
public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoNome;
    private TextInputEditText campoPeso;
    private TextInputEditText campoAltura;
    private TextView resultado1;
    private TextView resultado2;
    private RadioGroup radioGroupSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Componentes com seus IDs
        campoNome = findViewById(R.id.textInputNome);
        campoPeso = findViewById(R.id.textInputPeso);
        campoAltura = findViewById(R.id.textInputAltura);
        resultado1 = findViewById(R.id.textResultado1);
        resultado2 = findViewById(R.id.textResultado2);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
    }

    // Método de calculo IMC:
    public void calculaImc(View view) {
        String nome = campoNome.getText().toString();
        String peso = campoPeso.getText().toString();
        String altura = campoAltura.getText().toString();


        // Tratativa para que os campos sejam preenchidos (semelhante ao required do HTML
        if (peso.isEmpty() || altura.isEmpty() || nome.isEmpty()) {
            resultado1.setText("Preencha todos os campos!");
            return;
        }

        try {
            Double numPeso = Double.parseDouble(peso);
            Double numAltura = Double.parseDouble(altura);
            Double numImc = numPeso / (numAltura * numAltura);

            // Formatar o IMC em duas casas decimais
            DecimalFormat df = new DecimalFormat("##.##");
            String imc = df.format(numImc);

            resultado1.setText("IMC: " + imc);

            // Bloco para verificar qual botão Radio  está selecionado
            int selectedId = radioGroupSexo.getCheckedRadioButtonId();
            String sexo;

            if (selectedId == R.id.radioMasculino) {
                sexo = "Masculino";
            } else if (selectedId == R.id.radioFeminino) {
                sexo = "Feminino";
            } else {
                resultado1.setText("Selecione o sexo.");
                return;
            }

            // Condicional para classificar o IMC de acordo com o sexo (já que há variações)
            String classificacao;
            if (sexo.equals("Masculino")) {
                if (numImc < 18.5) {
                    classificacao = "Abaixo do peso";
                } else if (numImc < 24.9) {
                    classificacao = "Peso normal";
                } else if (numImc < 29.9) {
                    classificacao = "Sobrepeso";
                } else if (numImc < 34.9){
                    classificacao = "Obesidade";
                } else if (numImc < 39.9) {
                    classificacao = "Obesidade II";
                }else{

                    classificacao = "Obesidade III";

                }
            } else {
                if (numImc < 18.5) {
                    classificacao = "Abaixo do peso";
                } else if (numImc < 23.9) {
                    classificacao = "Peso normal";
                } else if (numImc < 28.9) {
                    classificacao = "Sobrepeso";
                } else if (numImc < 33.9) {
                    classificacao = "Obesidade";
                } else if (numImc < 38.9) {
                    classificacao = "Obesidade II";
                }
                else {
                    classificacao = "Obesidade III";
                }
            }

            resultado2.setText("Classificação: " + classificacao);

        } catch (NumberFormatException e) {
            resultado1.setText("Valores inválidos!");
        }
    }

    // Método para fazer a  limpeza dos dados:
    public void limpaDados(View view) {
        campoNome.setText("");
        campoPeso.setText("");
        campoAltura.setText("");
        resultado1.setText("");
        resultado2.setText("");
        radioGroupSexo.clearCheck();
    }
}
