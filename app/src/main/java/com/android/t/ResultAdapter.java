package com.android.t;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chentao on 2018/4/14.
 */

public class ResultAdapter extends SearchAdapter<Object> {

    //itemA类的type标志
    private static final int TYPE_HISTORY = 0;
    //itemB类的type标志
    private static final int TYPE_SUGGESTION = 1;

    public ResultAdapter(Context context, List<Object> datas) {
        super(context, datas);
    }


    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position) instanceof HistoryItem)
            return TYPE_HISTORY;
        else
            return TYPE_SUGGESTION;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HistoryViewHolder historyViewHolder = null;
        SuggestionViewHolder suggestionViewHolder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_HISTORY:
                    historyViewHolder = new HistoryViewHolder();
                    convertView = mInflater.inflate(R.layout.item_search_history, null);
                    historyViewHolder.title = convertView.findViewById(R.id.title);
                    convertView.setTag(historyViewHolder);
                    break;
                case TYPE_SUGGESTION:
                    suggestionViewHolder = new SuggestionViewHolder();
                    convertView = mInflater.inflate(R.layout.item_search_suggestion, null);
                    suggestionViewHolder.title = convertView.findViewById(R.id.title);
                    convertView.setTag(suggestionViewHolder);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_HISTORY:
                    historyViewHolder = (HistoryViewHolder) convertView.getTag();
                    break;
                case TYPE_SUGGESTION:
                    suggestionViewHolder = (SuggestionViewHolder) convertView.getTag();
                    break;
            }
        }
        Object o = getItem(position);
        //根据不同的type设置数据
        switch (type) {
            case TYPE_HISTORY:
                HistoryItem historyItem = (HistoryItem) o;
                historyViewHolder.title.setText(historyItem.getTitle());
                break;

            case TYPE_SUGGESTION:
                SuggestionItem suggestionItem = (SuggestionItem) o;
                suggestionViewHolder.title.setText(suggestionItem.getTitle());
                break;
        }
        return convertView;
    }

    static class HistoryViewHolder {
        TextView title;
    }

    static class SuggestionViewHolder {
        TextView title;
    }
}
