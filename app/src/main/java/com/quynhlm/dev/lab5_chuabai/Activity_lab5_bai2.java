package com.quynhlm.dev.lab5_chuabai;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class Activity_lab5_bai2 extends AppCompatActivity {

    ListView list_view_item;
    ArrayList<SinhVienModel> list;

    Button btnThemMoi;

    String sua_name;
    String sua_dia_chi;
    String sua_title;
    Sinh_Vien_Adapter sinh_vien_adapter;

    Toolbar toolbar;


    ActivityResultLauncher<Intent> nhan_du_lieu = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        String title = intent.getStringExtra(Activity_lab5_bai1.KEY_TITLE);
                        String name = intent.getStringExtra(Activity_lab5_bai1.KEY_USER_NAME);
                        String diaChi = intent.getStringExtra(Activity_lab5_bai1.KEY_DIA_CHI);
                        list.add(new SinhVienModel(title, name, diaChi));
                        fill();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai2);
        list_view_item = findViewById(R.id.list_view_item);
        btnThemMoi = findViewById(R.id.btnthemmoi);
        toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Quynh");


        Intent intent = this.getIntent();
        String user_name = intent.getStringExtra(Activity_lab5_bai1.KEY_USER_NAME);
        String dia_chi = intent.getStringExtra(Activity_lab5_bai1.KEY_DIA_CHI);
        String title = intent.getStringExtra(Activity_lab5_bai1.KEY_TITLE);
        list = new ArrayList<>();
        list.add(new SinhVienModel("Fpoly ha noi","Quynh","Vnh Phuc"));
        list.add(new SinhVienModel("Fpoly ha noi","Quynh","Vnh Phuc"));
        list.add(new SinhVienModel("Fpoly ha noi","Quynh","Vnh Phuc"));
        list.add(new SinhVienModel("Fpoly ha noi","Quynh","Vnh Phuc"));
        sinh_vien_adapter = new Sinh_Vien_Adapter(this, list);
        list_view_item.setAdapter(sinh_vien_adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        if(item.getItemId() == R.id.menu_search){

        }
        if(item.getItemId() == R.id.menu_addsudent){
            Intent i = new Intent(Activity_lab5_bai2.this, Activity_lab5_bai1.class);
            nhan_du_lieu.launch(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public void fill() {
        Sinh_Vien_Adapter adapter = new Sinh_Vien_Adapter(Activity_lab5_bai2.this, list);
        list_view_item.setAdapter(adapter);
    }

    public void deleteSv(int position) {
        list.remove(position);
        fill();
    }

    public static final String KEY_SV_MODEL = "sv_model";


    ActivityResultLauncher<Intent> sua_du_lieu = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        String title = intent.getStringExtra(Activity_lab5_bai1.KEY_TITLE);
                        String name = intent.getStringExtra(Activity_lab5_bai1.KEY_USER_NAME);
                        String diaChi = intent.getStringExtra(Activity_lab5_bai1.KEY_DIA_CHI);

                        sv_model.setTitle(title);
                        sv_model.setName(name);
                        sv_model.setDiaChi(diaChi);

                        fill();
                    }
                }
            }
    );

    public SinhVienModel sv_model;

    public class Sinh_Vien_Adapter extends BaseAdapter {

        private Context ctx;
        private ArrayList<SinhVienModel> list;


        public Sinh_Vien_Adapter(Context ctx, ArrayList<SinhVienModel> list) {
            this.ctx = ctx;
            this.list = list;
        }

        public Context getCtx() {
            return ctx;
        }

        public void setCtx(Context ctx) {
            this.ctx = ctx;
        }

        public ArrayList<SinhVienModel> getList() {
            return list;
        }

        public void setList(ArrayList<SinhVienModel> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_list_view, parent, false);

            SinhVienModel thongTin = list.get(position);
            TextView txt_title = convertView.findViewById(R.id.txttitle);
            TextView txtusername = convertView.findViewById(R.id.txt_username);
            TextView txtDiaChi = convertView.findViewById(R.id.txt_diachi);
            Button btnDelete = convertView.findViewById(R.id.btnDelete);
            Button btnUpdate = convertView.findViewById(R.id.btnUpdate);

            if (thongTin != null) {
                txt_title.setText(thongTin.getTitle());
                txtusername.setText(thongTin.getName());
                txtDiaChi.setText(thongTin.getDiaChi());
            }
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteSv(position);
                }
            });
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateSv(position);
                }
            });
            return convertView;
        }
    }


    public void updateSv(int position) {
        Intent intent = new Intent(Activity_lab5_bai2.this, Activity_lab5_bai1.class);
        sv_model = list.get(position);
        intent.putExtra(KEY_SV_MODEL, sv_model);

        sua_du_lieu.launch(intent);
    }
}