package com.education.user.booz;


import android.icu.util.ULocale;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.education.user.booz.Interface.Onclickinterface;
import com.education.user.booz.ViewHolder.CategoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


   View myfragment;
   RecyclerView listCategory;
   RecyclerView.LayoutManager layoutManager;
  FirebaseRecyclerAdapter <Category,CategoryViewHolder> adapter;
   FirebaseDatabase database;
   DatabaseReference categories;


   public static CategoryFragment newinstance(){

       CategoryFragment categoryFragment=new CategoryFragment();
       return categoryFragment;
   }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database=FirebaseDatabase.getInstance();
        categories=database.getReference("Category");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myfragment= inflater.inflate(R.layout.fragment_category, container, false);
        listCategory=(RecyclerView)myfragment.findViewById(R.id.listcategory);
        listCategory.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listCategory.setLayoutManager(layoutManager);

     loadcategories();
     return myfragment;
    }
        public void loadcategories(){

          adapter=new FirebaseRecyclerAdapter <Category, CategoryViewHolder>(
                  Category.class,
                  R.layout.category_layout,
                  CategoryViewHolder.class,
                  categories
          ) {
              @Override
              protected void populateViewHolder(CategoryViewHolder viewHolder, final Category model, int position) {

                  viewHolder.category_name.setText(model.getName());
                  Picasso.with(getActivity())
                          .load(model.getImage())
                          .into(viewHolder.category_image);

                  viewHolder.setItemClickListener(new Onclickinterface() {
                      @Override
                      public void onClick(View view, int position, boolean isLongClicked) {
                          Toast.makeText(getActivity(),String.format("%s|%s",adapter.getRef(position).getKey(),model.getName()),Toast.LENGTH_SHORT).show();
                      }
                  });
                  adapter.notifyDataSetChanged();
                  listCategory.setAdapter(adapter);
              }
          };

        }
}
