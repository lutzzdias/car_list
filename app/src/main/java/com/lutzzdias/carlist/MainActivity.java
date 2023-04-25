package com.lutzzdias.carlist;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView uiList;
    FloatingActionButton addCarFAB;
    ArrayList<Car> carList;

    CarAdapter carAdapter;

    ActivityResultLauncher<Intent> addCarActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // Here, no request code
                        Intent data = result.getData();
                        Car car = (Car) data.getSerializableExtra("car");
                        carList.add(car);
                        carAdapter.notifyDataSetChanged();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiList = findViewById(R.id.car_list);
        addCarFAB = findViewById(R.id.add_car_fab);
        carList = new ArrayList<>();

        carList.add(new Car("Corolla", "XEI", 2022, 25000, 149999.99));
        carList.add(new Car("Uno", "1.0 Escada", 2003, 100800, 325000.00));

        carAdapter = new CarAdapter(this, carList);
        uiList.setAdapter(carAdapter);

        Intent intent = new Intent(this, AddCar.class);
        addCarFAB.setOnClickListener(view -> {
            addCarActivityLauncher.launch(intent);
        });
    }
}