package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String [][] packages =
            {
                    {"Uprise-D3 1000IU Capsule", "", "", "", "50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
                    {"Vitamin B Complex Capsules", "", "", "", "448"},
                    {"Inlife Vitamin E Wheat Germ Oil Capsule", "", "", "","539"},
                    {"Dolo 650 Tablet", "", "", "", "30"},
                    {"Crocin 650 Advance Tablet","", "", "", "50"},
                    {"Strepsils Medicated Lozenges for Sore Throat", "", "", "", "40"},
                    {"Tata 1mg Calcium + Vitamin D3", "", "", "", "30"},
                    {"Feronia -XT Tablet", "", "", "", "130"},
};
    private String[] package_details = {
        "Building and keeping the bones & teeth strong\n" +
                "Reducing Fatigue/stress and muscular pains\n" +
                "Boosting immunity and increasing resistance against infection",
        "Chromium is an essential trace mineral that plays an important role in helping insulin regulate blood glucose.",
        "Provides relief from vitamin B deficiencies\n" +
                "Helps in formation of red blood cells\n" +
                "Maintains healthy nervous system",
        "It promotes health as well as skin benefit.\n" +
                "It helps reduce skin blemish and pigmentation.\n" +
                "It act as safeguard the skin from the harsh UVA and UVB sun rays.",
        "Dolo 650 Tablet helps relieve pain and fever by blocking the release of certain chemical messengers responsible for fever and pain.",
        "Helps relieve fever and bring down a high temperature\n"+
                "Suitable for people with a heart condition or high blood pressure",
        "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n" +
                "Provides a warm and comforting feeling during sore throat",
        "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis \n" +
                "Promotes mobility and flexibility of joints",
        "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"
    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
        startActivity (new Intent (BuyMedicineActivity. this, CartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity (new Intent( BuyMedicineActivity. this, HomeActivity.class));
            }
        });

        lst= findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
//startActivity (new Intent (BuyMedicine Activity. this, CartBuyMedicine Activity.class))
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity (new Intent(  BuyMedicineActivity. this, HomeActivity.class));
            }
        });

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
//startActivity (new Intent (BuyMedicine Activity. this, CartBuyMedicine Activity.class))
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivity (new Intent( BuyMedicineActivity. this, BuyMedicineDetailsActivity.class));
            }
        });
    }
}