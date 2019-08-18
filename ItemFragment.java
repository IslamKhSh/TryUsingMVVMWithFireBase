package com.example.android.forsale.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.android.forsale.R;
import com.example.android.forsale.adapters.ItemsAdapters;
import com.example.android.forsale.databinding.ItemFragmentBinding;
import com.example.android.forsale.models.ItemData;
import com.example.android.forsale.ui.viewmodel.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment {

    private ItemViewModel mViewModel;
    private ItemsAdapters itemsAdapter;
    private List<ItemData> mItemsList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // get category name from Arguments
        assert getArguments() != null;
        String categoryName = ItemFragmentArgs.fromBundle(getArguments()).getCATEGORYPATH();

        // Inflate view and obtain an instance of the binding class.
        ItemFragmentBinding itemFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.item_fragment, container, false);

        // Specify the current activity as the lifecycle owner.
        itemFragmentBinding.setLifecycleOwner(this);

        itemsAdapter = new ItemsAdapters(mItemsList);
        itemFragmentBinding.itemsRecyclerView.setHasFixedSize(true);

        itemFragmentBinding.itemsRecyclerView.setAdapter(itemsAdapter);
      //  itemFragmentBinding.setAdapter(itemsAdapter);

        // Assign the component to a property in the binding class.
        itemFragmentBinding.setItemViewModel(mViewModel);

        mViewModel.getCategoryData(categoryName).observe(this, itemDataList -> itemsAdapter.submitList(itemDataList));
        return itemFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Obtain the ViewModel component.
        mViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
    }
}
