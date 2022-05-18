package sg.edu.rp.c346.id20041194.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNum;
    EditText etPax;
    DatePicker dp;
    TimePicker tp;
    Button btnComfirm;
    Button btnReset;
    TextView tvDisplay1;
    TextView tvDisplay2;
    TextView tvDisplay3;
    TextView tvDisplay4;
    TextView tvDisplay5;
    RadioGroup rbGroup;
    RadioButton rbSmoke;
    RadioButton rbNoSmoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etNum = findViewById(R.id.etNum);
        etPax = findViewById(R.id.etPax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnComfirm = findViewById(R.id.btnComfirm);
        btnReset = findViewById(R.id.btnReset);
        tvDisplay1 = findViewById(R.id.tvDisplay1);
        tvDisplay2 = findViewById(R.id.tvDisplay2);
        tvDisplay3 = findViewById(R.id.tvDisplay3);
        tvDisplay4 = findViewById(R.id.tvDisplay4);
        tvDisplay5 = findViewById(R.id.tvDisplay5);
        rbGroup = findViewById(R.id.rbGroup);
        rbSmoke = findViewById(R.id.rbSmoke);
        rbNoSmoke = findViewById(R.id.rbNoSmoke);
        tp.setCurrentHour(7);
        tp.setCurrentMinute(30);
        dp.updateDate(2020, 05,01);

        btnComfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(etName.getText()) || TextUtils.isEmpty(etNum.getText()) || TextUtils.isEmpty(etPax.getText())
                || !rbSmoke.isChecked() && !rbNoSmoke.isChecked()){
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_LONG).show();
                    if (TextUtils.isEmpty(etName.getText())) {
                        etName.setError( "Name is required!" );
                    }
                    if (TextUtils.isEmpty(etNum.getText())) {
                        etNum.setError( "Phone number is required!" );
                    }
                    if (TextUtils.isEmpty(etPax.getText())) {
                        etPax.setError( "No. of Pax is required!" );
                    }
                    if (!rbSmoke.isChecked() && !rbNoSmoke.isChecked()) {
                        rbSmoke.setError( "Area is required!" );
                    }

                }
                else {


                int min = tp.getCurrentMinute();
                int hr = tp.getCurrentHour();
                tvDisplay1.setText("Time: " + hr + ":" + min);
                int day = dp.getDayOfMonth();
                int mnth = dp.getMonth();
                int year = dp.getYear();
                tvDisplay2.setText("Date: " + day + "/" + (mnth+1) + "/" + year);
                tvDisplay3.setText("Your name: " + etName.getText());
                if (rbSmoke.isChecked()) {
                    tvDisplay4.setText("Smoking area: Yes");
                }
                else if (rbNoSmoke.isChecked()) {
                    tvDisplay4.setText("Smoking area: No");
                }
                tvDisplay5.setText("Phone Number: "+etNum.getText() + "   Pax: " + etPax.getText());
                }
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            rbGroup.clearCheck();
            etName.setText(null);
            etNum.setText(null);
            etPax.setText(null);
            tp.setCurrentHour(7);
            tp.setCurrentMinute(30);
            dp.updateDate(2020, 05,01);
            tvDisplay1.setText(null);
            tvDisplay2.setText(null);
            tvDisplay3.setText(null);
            tvDisplay4.setText(null);
            tvDisplay5.setText(null);
            etName.setError(null);
            etNum.setError(null);
            etPax.setError(null);
            rbSmoke.setError(null);

            }
        });

    }
}