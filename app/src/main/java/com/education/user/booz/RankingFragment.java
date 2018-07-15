package com.education.user.booz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment {

    View myfragment;
    RecyclerView listcategory;
    RecyclerView.LayoutManager layoutManager;
    public static RankingFragment newinstance(){

        RankingFragment rankingFragment=new RankingFragment();
        return rankingFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      myfragment= inflater.inflate(R.layout.fragment_ranking, container, false);
      return myfragment;
    }

}
