package joel.vcodelabandroid.ejercicioclase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import joel.vcodelabandroid.ejercicioclase.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private EditText txt_number1, txt_number2;

    private RadioButton radio_suma,  radio_resta, radio_multiplicaion, radio_dividir;

    private RadioGroup radio_group;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        /****** Instaciar componentes ******/

        //Binding: Es la variable que nos permite acceder a nuestra puerta visual
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        txt_number1=(EditText) binding.txtNumber1;
        txt_number2=(EditText) binding.txtNumber2;



        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}