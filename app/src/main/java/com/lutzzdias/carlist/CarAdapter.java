package com.lutzzdias.carlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CarAdapter extends ArrayAdapter<Car> {
    public CarAdapter(Context context, ArrayList<Car> carList){
        super(context, 0, carList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView ==  null){
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.car_list_item,
                    parent, false);
        }

        Car car = getItem(position);

        TextView carName = currentItemView.findViewById(R.id.car_name);
        carName.setText(car.getName());

        TextView carModel = currentItemView.findViewById(R.id.car_model);
        carModel.setText(car.getModel());

        TextView carYear = currentItemView.findViewById(R.id.car_year);
        carYear.setText(String.format(Locale.US, "%d", car.getYear()));

        TextView carMileage = currentItemView.findViewById(R.id.car_mileage);
        carMileage.setText(String.format("%s km", NumberFormat.getNumberInstance(Locale.US).format(car.getMileage())));

        TextView carPrice = currentItemView.findViewById(R.id.car_price);
        carPrice.setText(String.format(Locale.US, "R$%,.2f", car.getPrice()));


        return currentItemView;
    }
}
