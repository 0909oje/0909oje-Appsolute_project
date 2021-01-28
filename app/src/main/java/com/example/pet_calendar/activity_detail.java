package com.example.pet_calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class activity_detail extends AppCompatActivity {

//  back 클릭 시 메인화면
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);

        Button back_main = (Button) findViewById(R.id.activity_detail_back);
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        Button back_detail = (Button) findViewById(R.id.activity_detail_back_detail);
        back_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//edit 클릭 시 +버튼, save 버튼 보이기, back 버튼 보이기, 텍스트, 사진 수정 가능
        //edit, back 사라지기
        Button edit = (Button) findViewById(R.id.activity_detail_edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button add1 = (Button) findViewById(R.id.activity_detail_picture_add);
                Button add2 = (Button) findViewById(R.id.activity_detail_profile_add);
                Button save = (Button) findViewById(R.id.activity_detail_save);
                Button edit = (Button) findViewById(R.id.activity_detail_edit);
                Button back_detail = (Button) findViewById(R.id.activity_detail_back_detail);
                Button back_main = (Button) findViewById(R.id.activity_detail_back);
                add1.setVisibility(v.VISIBLE);
                add2.setVisibility(v.VISIBLE);
                save.setVisibility(v.VISIBLE);
                back_detail.setVisibility(v.VISIBLE);
                edit.setVisibility(v.INVISIBLE);
                back_main.setVisibility(v.INVISIBLE);
            }
        });
    }

//    날짜 선택하기
    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);

        Toast.makeText(this,"Date: "+dateMessage,Toast.LENGTH_SHORT).show();
    }
}