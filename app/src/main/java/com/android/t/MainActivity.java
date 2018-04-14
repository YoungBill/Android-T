package com.android.t;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mSearchEt;
    private ListView mResultList;
    private HistoryAdapter mHistoryAdapter;
    private SuggestionAdapter mSuggestionAdapter;
    private ResultAdapter mResultAdapter;
    private List<HistoryItem> mHistoryList;
    private List<SuggestionItem> mSuggestionItemList;
    private List<Object> mObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchEt = findViewById(R.id.searchEt);
        mResultList = findViewById(R.id.resultList);

        mHistoryList = new ArrayList<>();
        HistoryItem historyItem = new HistoryItem(0, "www", "百度一下");
        mHistoryList.add(historyItem);
        HistoryItem historyItem1 = new HistoryItem(1, "www", "谷歌一下");
        mHistoryList.add(historyItem1);
        HistoryItem historyItem2 = new HistoryItem(2, "www", "雅虎一下");
        mHistoryList.add(historyItem2);
        HistoryItem historyItem3 = new HistoryItem(3, "www", "哈哈");
        mHistoryList.add(historyItem3);
        HistoryItem historyItem4 = new HistoryItem(4, "www", "555");
        mHistoryList.add(historyItem4);
        HistoryItem historyItem5 = new HistoryItem(5, "www", "666");
        mHistoryList.add(historyItem5);

        mSuggestionItemList = new ArrayList<>();
        SuggestionItem suggestionItem = new SuggestionItem("g");
        mSuggestionItemList.add(suggestionItem);
        SuggestionItem suggestionItem1 = new SuggestionItem("gh");
        mSuggestionItemList.add(suggestionItem1);
        SuggestionItem suggestionItem2 = new SuggestionItem("ghi");
        mSuggestionItemList.add(suggestionItem2);
        SuggestionItem suggestionItem3 = new SuggestionItem("ghij");
        mSuggestionItemList.add(suggestionItem3);
        SuggestionItem suggestionItem4 = new SuggestionItem("ghijk");
        mSuggestionItemList.add(suggestionItem4);
        SuggestionItem suggestionItem5 = new SuggestionItem("gggggg");
        mSuggestionItemList.add(suggestionItem5);

//        mHistoryAdapter = new HistoryAdapter(MainActivity.this, mHistoryList);
//        mResultList.setAdapter(mHistoryAdapter);

        mObjectList = new ArrayList<>();
        mObjectList.addAll(mHistoryList);
        mResultAdapter = new ResultAdapter(MainActivity.this, mObjectList);
        mResultList.setAdapter(mResultAdapter);

        mSearchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//                if (TextUtils.isEmpty(s)) {
//                    mResultList.setAdapter(mHistoryAdapter);
//                    mHistoryAdapter.notifyDataSetChanged();
//                } else {
//                    if (mSuggestionAdapter == null) {
//                        mSuggestionAdapter = new SuggestionAdapter(MainActivity.this, mSuggestionItemList);
//                    }
//                    mResultList.setAdapter(mSuggestionAdapter);
//                    mSuggestionAdapter.notifyDataSetChanged();
//                }
                if (TextUtils.isEmpty(s)) {
                    mObjectList.clear();
                    mResultAdapter.notifyDataSetChanged();
                    mObjectList.addAll(mHistoryList);
                    mResultAdapter.notifyDataSetChanged();
                } else {
                    mObjectList.clear();
                    mResultAdapter.notifyDataSetChanged();
                    mObjectList.addAll(mSuggestionItemList);
                    mResultAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
