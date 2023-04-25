package com.lutzzdias.carlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddCar extends AppCompatActivity {
    TextInputLayout carNameLayout;
    TextInputLayout carModelLayout;
    TextInputLayout carYearLayout;
    TextInputLayout carMileageLayout;
    TextInputLayout carPriceLayout;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        carNameLayout = findViewById(R.id.input_layout_name);
        carModelLayout = findViewById(R.id.input_layout_model);
        carYearLayout = findViewById(R.id.input_layout_year);
        carMileageLayout = findViewById(R.id.input_layout_mileage);
        carPriceLayout = findViewById(R.id.input_layout_price);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(
                view -> {
                    String carName = carNameLayout.getEditText().getText().toString();
                    String carModel = carModelLayout.getEditText().getText().toString();
                    Integer carYear = Integer.parseInt(carYearLayout.getEditText().getText().toString());
                    Integer carMileage = Integer.parseInt(carMileageLayout.getEditText().getText().toString());
                    Double carPrice = Double.parseDouble(carPriceLayout.getEditText().getText().toString());

                    Car car = new Car(carName, carModel, carYear, carMileage, carPrice);
                    Intent intent = new Intent();
                    intent.putExtra("car", car);
                    setResult(RESULT_OK, intent);
                    finish();
                }
        );

    }
}