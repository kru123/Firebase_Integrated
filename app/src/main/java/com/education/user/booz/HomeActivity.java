package com.education.user.booz;


import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.navigation);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                    Fragment selectedfragment=null;


                    switch (id){

                        case R.id.action_catergory :
                            selectedfragment=CategoryFragment.newinstance();
                            break;

                        case R.id.action_ranking :
                            selectedfragment=RankingFragment.newinstance();
                            break;

                    }
                    FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout6,selectedfragment);
                    fragmentTransaction.commit();
                    return true;
                }

            });
        setDefaultTransaction();
    }

    public void setDefaultTransaction(){


        FragmentTransaction fragmentTransactiont = getSupportFragmentManager().beginTransaction();
        fragmentTransactiont.replace(R.id.framelayout6, CategoryFragment.newinstance() );
        fragmentTransactiont.commit();

    }
}
