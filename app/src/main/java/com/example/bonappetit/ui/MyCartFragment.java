package com.example.bonappetit.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bonappetit.R;
import com.example.bonappetit.activities.DetailedDailyMealActivity;
import com.example.bonappetit.adapters.CartAdapter;
import com.example.bonappetit.models.CartModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {

    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    String uid = currentUser.getUid();
    Button button;
    public MyCartFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        button=view.findViewById(R.id.button);
        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();

        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);

        //cart total amount
        final int[] total_amount = {0};

        db.collection("cart").whereEqualTo("uid",uid)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                list.add(new CartModel(Integer.parseInt(document.getData().get("image").toString()), document.getData().get("name").toString(), document.getData().get("price").toString()));
                                String price = document.getData().get("price").toString();
                                int pricenum = Integer.parseInt(price.substring(0, price.length() - 2));
                                total_amount[0] += pricenum;
                            }
                            cartAdapter.notifyDataSetChanged();
                            ((TextView) view.findViewById(R.id.dol_txt)).setText(total_amount[0] + " /-");//it will collect value form network
                        }
                    }
                });
        button.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "Order Successful!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

}