package com.example.android.forsale.livedata.common;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.forsale.models.CategoryData;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class DataOrException extends LiveData<List<CategoryData>> {

    private MutableLiveData<List<DocumentSnapshot>> mListOfDocument;

    public DataOrException(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {

    }
}
