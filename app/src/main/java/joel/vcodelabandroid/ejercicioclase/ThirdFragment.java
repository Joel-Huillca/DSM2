package joel.vcodelabandroid.ejercicioclase;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import joel.vcodelabandroid.ejercicioclase.databinding.FragmentFirstBinding;
import joel.vcodelabandroid.ejercicioclase.databinding.FragmentSecondBinding;
import joel.vcodelabandroid.ejercicioclase.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;

    private EditText txt_num1,  txt_num2, resp_cal;

    private Spinner sp_operations;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);

        txt_num1 = (EditText)  binding.txtNum1;
        txt_num2 = (EditText)  binding.txtNum2;
        resp_cal = (EditText)  binding.respCal;
        sp_operations = (Spinner) binding.spiOptions;

        String [] operrations =
                {
                    "Sumar", "Restar", "Multiplicar", "Dividir"
                };
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this.getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, operrations);

        sp_operations.setAdapter(adapter);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThird1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_FirstFragment);
            }
        });

        binding.btnCalc.setOnClickListener((View v) -> {
            String seleected = sp_operations.getSelectedItem().toString();

            switch (seleected){
                case "Sumar": {
                    suma();
                    break;
                }
                case "Restar": {
                    resta();
                    break;
                }
                case "Multiplicar": {
                    multiplicacion();
                    break;
                }
                case "Dividir": {
                    division();
                    break;
                } default:{
                    showMesaggeEmty();
                }
            }
        });
    }

    public void showMesaggeEmty(){
        Toast.makeText(this.getContext(), "No se seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
    }

    public String suma(){
        double valor1 = Integer.parseInt(txt_num1.getText().toString());
        double valor2 = Integer.parseInt(txt_num2.getText().toString());
        double suma = valor1 + valor2;
        String respuesta = String.valueOf(suma);
        resp_cal.setText(respuesta);
        return respuesta;
    }

    public String resta(){
        double valor1 = Integer.parseInt(txt_num1.getText().toString());
        double valor2 = Integer.parseInt(txt_num2.getText().toString());
        double resta = valor1 - valor2;
        String respuesta = String.valueOf(resta);
        resp_cal.setText(respuesta);
        return respuesta;
    }


    public String multiplicacion(){
        double valor1 = Integer.parseInt(txt_num1.getText().toString());
        double valor2 = Integer.parseInt(txt_num2.getText().toString());
        double multiplicacion = valor1 * valor2;
        String respuesta = String.valueOf(multiplicacion);
        resp_cal.setText(respuesta);
        return respuesta;
    }


    public String division(){
        double valor1 = Integer.parseInt(txt_num1.getText().toString());
        double valor2 = Integer.parseInt(txt_num2.getText().toString());
        String respuesta = "";
        if (valor2 != 0){
            double division = valor1 / valor2;
            respuesta = String.valueOf(division);
            resp_cal.setText(respuesta);
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