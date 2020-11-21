package com.example.e_commerceadmin.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerceadmin.R;
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
                break;
            case R.id.nav_qlkh:
                Toast.makeText(this, "Quản Lý Khách Hàng", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_dsd:
                Toast.makeText(this, "Danh Sách Đen", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_dmk:
                Toast.makeText(this, "Đổi Mật Khẩu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_dangxuat:
                Toast.makeText(this, "Đăng Xuất", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}