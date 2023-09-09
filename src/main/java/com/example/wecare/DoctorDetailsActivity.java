package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
            {"Doctor Name : Rohit Kumar", "Hospital Address : Ningdi", "Exp : 15yrs", "Mobile No: 78787878787878", "900"},
            {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 8989898989898", "300"},
            {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chindhwada", "Exp : 10yrs", "Mobile No: 56565656565656565", "500"},
            {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:779898989898", "800"},
    };
    private String[][] doctor_details2 = {
            {"Doctor Name : Rajiv Tandon", "Hospital Address : Dhamtari", "Exp : 4yrs", "Mobile No: 98956624666", "1000"},
            {"Doctor Name : Dev Shukla", "Hospital Address : Raigarh", "Exp : 1yrs", "Mobile No: 787555557878", "1200"},
            {"Doctor Name : Aditya Saxena", "Hospital Address : Raipur", "Exp : 7yrs", "Mobile No: 56598987787323", "1300"},
            {"Doctor Name : Vedanshu Diliwara", "Hospital Address : Bastar", "Exp : 5yrs", "Mobile No: 444444444455454565", "1500"},
            {"Doctor Name : Ajit Rai", "Hospital Address : Lucknow", "Exp : 3yrs", "Mobile No: 5126235489562", "1600"},
    };
    private String[][] doctor_details3 = {
            {"Doctor Name : Raju Sharma", "Hospital Address : Turturiya", "Exp : 6yrs", "Mobile No: 9898989898", "6800"},
            {"Doctor Name : Virat Kashyap", "Hospital Address : Jashpur", "Exp : 1yrs", "Mobile No: 7878787575878", "9300"},
            {"Doctor Name : Kumar Dandi", "Hospital Address : Sonbhadra", "Exp : 12yrs", "Mobile No: 8989842569898", "5300"},
            {"Doctor Name : Abhijit Deshmukh", "Hospital Address : Raichur", "Exp : 1yrs", "Mobile No: 565122265656565", "2500"},
            {"Doctor Name : Sholka Mehta", "Hospital Address : Katraj", "Exp : 3yrs", "Mobile No: 77946234668", "1800"},
    };
    private String[][] doctor_details4 = {
            {"Doctor Name : Ritesh Thakur", "Hospital Address : Chandigarh", "Exp : 3yrs", "Mobile No: 98834698", "6020"},
            {"Doctor Name : Jai Sahu", "Hospital Address : Mumbai", "Exp : 1yrs", "Mobile No: 78787345678", "9070"},
            {"Doctor Name : Ram Raghuvanshi", "Hospital Address : Ayodhya", "Exp : 7yrs", "Mobile No: 83456989898", "3010"},
            {"Doctor Name : Bajran Kumar", "Hospital Address : Raipur", "Exp : 4yrs", "Mobile No: 5654565656565", "5004"},
            {"Doctor Name : Ashok Puniya", "Hospital Address : Jharkandh", "Exp : 17yrs", "Mobile No: 7345669898", "8040"},
    };
    private String[][] doctor_details5 = {
            {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No: 9898989898", "600"},
            {"Doctor Name : Rohit Kumar", "Hospital Address : Ningdi", "Exp : 15yrs", "Mobile No: 78787878787878", "900"},
            {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 8989898989898", "300"},
            {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chindhwada", "Exp : 10yrs", "Mobile No: 56565656565656565", "500"},
            {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 779898989898", "800"},
    };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonCartCheckout);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0) {
            doctor_details = doctor_details1;
        }
        else if(title.compareTo("Dietitian")==0) {
            doctor_details = doctor_details2;
        }
        else if(title.compareTo("Dentist")==0) {
            doctor_details = doctor_details3;
        }
        else if(title.compareTo("Surgeon")==0) {
            doctor_details = doctor_details4;
        }
        else  {
            doctor_details = doctor_details5;
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0; i<doctor_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );

        ListView lst = findViewById(R.id.listViewCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });


    }
}