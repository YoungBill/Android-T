package com.android.t;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chentao on 2018/4/14.
 */

public class SuggestionAdapter extends SearchAdapter<SuggestionItem> {

    public SuggestionAdapter(Context context, List<SuggestionItem> datas) {
        super(context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_search_suggestion, null);
            holder.title = convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(mDatas.get(position).getTitle());
        return convertView;
    }


    static class ViewHolder {
        TextView title;
    }
}
