package anoop.myprojects.gec_sfi.bus;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import anoop.myprojects.gec_sfi.CPY_to_clg;
import anoop.myprojects.gec_sfi.Clg_to_CPY;
import anoop.myprojects.gec_sfi.R;

public class Bus5 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerbus1;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus5);

        ImageView back;

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bus5.super.onBackPressed();
            }
        });





        spinnerbus1 = (Spinner) findViewById(R.id.spinnerbus5);
        spinnerbus1.setOnItemSelectedListener(Bus5.this);

        List<String> categories = new ArrayList<String>();
        categories.add("Towards College");
        categories.add("Towards Cherpulassery");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerbus1.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position){

            case 0 :
                fragmentTransaction=getSupportFragmentManager().beginTransaction();

                CPY_to_clg ldf = new CPY_to_clg();

                fragmentTransaction.replace(R.id.main_container_bus5,ldf);
                fragmentTransaction.commit();
                break;

            case 1 :
                fragmentTransaction=getSupportFragmentManager().beginTransaction();

                Clg_to_CPY ldf1 = new Clg_to_CPY();

                fragmentTransaction.replace(R.id.main_container_bus5,ldf1);
                fragmentTransaction.commit();

                break;


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        fragmentTransaction=getSupportFragmentManager().beginTransaction();

        CPY_to_clg ldf = new CPY_to_clg();

        fragmentTransaction.add(R.id.main_container_bus5,ldf);
        fragmentTransaction.commit();

    }
}
