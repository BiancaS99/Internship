package com.example.sdesign;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ScafeFragment extends Fragment {

    private ScafeViewModel mViewModel;
    private TextView sColor,sTip,sLungime;
    private Button sSimulare;
    public static Spinner sColorChoice,sPlacaChoice;
    private EditText sLungimePerete;



    public  ScafeFragment ()  {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.scafe_fragment, container, false);
        sColor=view.findViewById(R.id.s_color);
        sColorChoice=view.findViewById(R.id.s_color_choice);
        String[] optCulori={"","Alb","Verde","Mov","Albastru","Portocaliu"};
        ArrayAdapter<String> adaptorCulori=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,optCulori);
        sColorChoice.setAdapter(adaptorCulori);
//        if (sColorChoice.getSelectedItem() == "Alb") {
//            sColorChoice.setBackgroundColor(Color.BLUE);
//        }else if(sColorChoice.getSelectedItem()=="Verde"){
//            sColorChoice.setBackgroundColor(Color.GREEN);
        //trebuie facut cu un for ca sa schimbi cuoarea backgroundului in functie de ce culoare am ales
//        }
//        for(int i=0;i<adaptorCulori.getCount();i++){
//            if(sColorChoice.getSelectedItem(i)=="Alb"){
//                sColorChoice.setBackgroundColor(Color.WHITE);
//            }
//            if(adaptorCulori.getItem(i)=="Verde"){
//                sColorChoice.setBackgroundColor(Color.GREEN);
//            }
//        }
        if (sColorChoice.getSelectedItem() == "Alb")
            sColorChoice.setBackgroundColor(Color.WHITE);
        if (sColorChoice.getSelectedItem() == "Verde")
            sColorChoice.setBackgroundColor(Color.GREEN);
        if (sColorChoice.getSelectedItem() == "Mov")
            sColorChoice.setBackgroundColor(Color.MAGENTA);
        if (sColorChoice.getSelectedItem() == "Albastru")
            sColorChoice.setBackgroundColor(Color.BLUE);
        if (sColorChoice.getSelectedItem() == "Portocaliu")
            sColorChoice.setBackgroundColor(Color.YELLOW);

        sTip=view.findViewById(R.id.s_tip);
        sLungime=view.findViewById(R.id.s_lung_perete);
        sSimulare=view.findViewById(R.id.s_simulare);

        sPlacaChoice=view.findViewById(R.id.s_tip_choice);
        String[] optPlaca={"12.5","13.5","Aqua","Placa de foc","Acustica"};
        ArrayAdapter<String> adaptorPlaca=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,optPlaca);
        sPlacaChoice.setAdapter(adaptorPlaca);
        //sLungimePerete=view.findViewById(R.id.s_lung_perete);
        sSimulare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentmain=new Intent(getActivity(),MainActivity.class);
                startActivity(intentmain);
            }
        });
        return view;




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ScafeViewModel.class);
        // TODO: Use the ViewModel

    }

}
