package com.quynhlm.dev.lab5_chuabai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_lab5_bai1 extends AppCompatActivity {

    public static String KEY_USER_NAME = "user_name";
    public static String KEY_DIA_CHI = "dia_chi";
    public static String KEY_TITLE = "title";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai1);

        Spinner spinner = findViewById(R.id.spiner_title);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        EditText edt_name = findViewById(R.id.edtUserName);
        EditText edt_dia_Chi = findViewById(R.id.edtDiaChi);

        ArrayList<School> list = new ArrayList<>();
        list.add(new School("Fpoly Hà Nội", R.drawable.hanoi));
        list.add(new School("Fpoly Hồ Chí Minh", R.drawable.ho_chi_minh));
        list.add(new School("Fpoly Đà nẵng", R.drawable.danang));
        list.add(new School("Fpoly Tây Nguyên", R.drawable.tay_nguyen));

        SinhVienModel thong_tin_sinh_vien = (SinhVienModel) getIntent().getSerializableExtra(Activity_lab5_bai2.KEY_SV_MODEL);

        SchoolAdapter co_so_adapter = new SchoolAdapter(this, list);
        spinner.setAdapter(co_so_adapter);

        if (thong_tin_sinh_vien != null) { // sua sinh vien
            edt_name.setText(thong_tin_sinh_vien.getName());
            edt_dia_Chi.setText(thong_tin_sinh_vien.getDiaChi());

            int position = list.indexOf(thong_tin_sinh_vien.getTitle());
            spinner.setSelection(position);
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = edt_name.getText().toString();
                String dia_Chi = edt_dia_Chi.getText().toString();


                if(user_name.trim().isEmpty() && dia_Chi.trim().isEmpty()){
                    Toast.makeText(Activity_lab5_bai1.this, "Chua nhap thong tin !", Toast.LENGTH_SHORT).show();
                }else{
                    School thong_tin_co_so = (School) spinner.getSelectedItem();
                    String title = thong_tin_co_so.getName();
                    Intent intent = new Intent(Activity_lab5_bai1.this,Activity_lab5_bai2.class);
                    intent.putExtra(KEY_USER_NAME,user_name);
                    intent.putExtra(KEY_DIA_CHI,dia_Chi);
                    intent.putExtra(KEY_TITLE,title);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}