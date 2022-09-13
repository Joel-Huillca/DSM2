package joel.vcodelabandroid.ejercicioclase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import joel.vcodelabandroid.ejercicioclase.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private EditText txt_number1, txt_number2, txt_respuesta;

    private RadioButton radio_suma,  radio_resta, radio_multiplicaion, radio_dividir;

    private RadioGroup radio_group;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        /****** Instanciar componentes ******/

        //Binding: Es la variable que nos permite acceder a nuestra puerta visual
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        txt_number1 = (EditText) binding.txtNumber1;
        txt_number2 = (EditText) binding.txtNumber2;
        txt_respuesta = (EditText) binding.txtRespuesta;
        radio_suma = (RadioButton) binding.radioSuma;
        radio_resta = (RadioButton) binding.radioRestar;
        radio_multiplicaion = (RadioButton) binding.radioMultiplicar;
        radio_dividir = (RadioButton) binding.radioDividir;
        radio_group = (RadioGroup) binding.radioGroup;

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Forma 1 de como llamar  a tu boton: new View.OnClickListener()
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        //Forma 2 de como llamar  a tu boton: (View v)-> {}
        //La "v" es solo una variable o  una instancia
        binding.buttonCalculate.setOnClickListener((View v)-> {
            if (radio_suma.isChecked()){
                suma();
            }else if (radio_resta.isChecked()){
                resta();
            }else if (radio_multiplicaion.isChecked()){
                multiplicacion();
            }else if (radio_dividir.isChecked()){
                division();
            }else {
                showMessage();
            }
        });
    }


    public void showMessage(){
        Toast.makeText(this.getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
    }

    public String suma(){
        /**
         * getText = Obtengo un valor del usuario
         * toString = Lo trasnformo a un String
         * */
        double valor1 = Integer.parseInt(txt_number1.getText().toString());
        double valor2 = Integer.parseInt(txt_number2.getText().toString());
        double suma = valor1 + valor2;
        String respuesta = String.valueOf(suma);
        txt_respuesta.setText(respuesta);
        return respuesta;
    }

    public String resta(){
        /**
         * getText = Obtengo un valor del usuario
         * toString = Lo trasnformo a un String
         * */
        double valor1 = Integer.parseInt(txt_number1.getText().toString());
        double valor2 = Integer.parseInt(txt_number2.getText().toString());
        double resta = valor1 - valor2;
        String respuesta = String.valueOf(resta);
        txt_respuesta.setText(respuesta);
        return respuesta;
    }


    public String multiplicacion(){
        /**
         * getText = Obtengo un valor del usuario
         * toString = Lo trasnformo a un String
         * */
        double valor1 = Integer.parseInt(txt_number1.getText().toString());
        double valor2 = Integer.parseInt(txt_number2.getText().toString());
        double multiplicacion = valor1 * valor2;
        String respuesta = String.valueOf(multiplicacion);
        txt_respuesta.setText(respuesta);
        return respuesta;
    }


    public String division(){
        /**
         * getText = Obtengo un valor del usuario
         * toString = Lo trasnformo a un String
         * */
        double valor1 = Integer.parseInt(txt_number1.getText().toString());
        double valor2 = Integer.parseInt(txt_number2.getText().toString());
        String respuesta = "";
        if (valor2 != 0){
            double division = valor1 / valor2;
            respuesta = String.valueOf(division);
            txt_respuesta.setText(respuesta);
        }else {
            Toast.makeText(this.getContext(), "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
        }
        return respuesta;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}