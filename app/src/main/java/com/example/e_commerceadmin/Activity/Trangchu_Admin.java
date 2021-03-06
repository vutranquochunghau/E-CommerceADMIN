package com.example.e_commerceadmin.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerceadmin.QLDonHang;
import com.example.e_commerceadmin.QLKhachHang;
import com.example.e_commerceadmin.R;
import com.example.e_commerceadmin.SuaThongTin;
import com.example.e_commerceadmin.them;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Trangchu_Admin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FloatingActionButton floatingButton;
    ListView lv_category, lv_product;


    TextView txtDisplay;
    String titleCate[] = {"Điện Thoại", "Túi Xách", "Áo Nam", "Áo Nữ", "Quần Nam", "Quần Nữ"};
    int Image[] = {R.drawable.phone_image, R.drawable.tuixach_image, R.drawable.aonam_image, R.drawable.aonu_image, R.drawable.quannam, R.drawable.quannu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.e_commerceadmin.R.layout.activity_trangchu__admin);
        floatingButton = findViewById(R.id.floatingButton);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_menu);
        floatingButton = findViewById(R.id.floatingButton);
        lv_category = findViewById(R.id.lv_category);
        lv_product = findViewById(R.id.lv_product);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


//============================================NavigationViewMenu============================================
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        //============================================FloatingActionButton============================================
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Thêm sản phẩm", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                Intent intent= new Intent(Trangchu_Admin.this, them.class);
                startActivity(intent);
            }
        });

        //============================================Model===Category============================================
        MyAdapter myAdapter = new MyAdapter(this, titleCate, Image);
        lv_category.setAdapter(myAdapter);
        
        lv_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    Toast.makeText(Trangchu_Admin.this, "Dien Thoai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //    ListView Category===============================================================================================
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rtitleCate[];
        int rImage[];

        MyAdapter(Context context, String titleCate[], int Image[]) {
            super(context, R.layout.model_lv_category);
            this.context = context;
            this.rtitleCate = titleCate;
            this.rImage = Image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View modelCate = layoutInflater.inflate(R.layout.model_lv_category, parent, false);
            ImageView images = modelCate.findViewById(R.id.lv_cate_image);
            TextView title = modelCate.findViewById(R.id.lv_cate_title);

            images.setImageResource(rImage[position]);
            title.setText(rtitleCate[position]);


            return modelCate;

        }
    }

    //============================================NavigationViewMenu==ChooseItem==========================================
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_qldh:
                Toast.makeText(this, "Quản Lý Đơn Hàng", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Trangchu_Admin.this, QLDonHang.class);
                startActivity(intent);
                break;
            case R.id.nav_qlkh:
                Toast.makeText(this, "Quản Lý Khách Hàng", Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(Trangchu_Admin.this, QLKhachHang.class);
                startActivity(intent1);
                break;
            case R.id.nav_dsd:
                Toast.makeText(this, "Danh Sách Đen", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_dmk:
                displayAlertDialog();
                break;
            case R.id.nav_dangxuat:
                Toast.makeText(this, "Đăng Xuất", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public void displayAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.customdialog, null);
        final EditText etUsername = (EditText) alertLayout.findViewById(R.id.mkc);
        final EditText etPassword = (EditText) alertLayout.findViewById(R.id.mkm);
        final EditText cbShowPassword = (EditText) alertLayout.findViewById(R.id.nmkm);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("ĐỔI MẬT KHẨU");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // code for matching password
                String user = etUsername.getText().toString();
                String pass = etPassword.getText().toString();
                Toast.makeText(getBaseContext(),  user  + pass, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
