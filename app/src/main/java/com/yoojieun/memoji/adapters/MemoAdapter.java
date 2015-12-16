package com.yoojieun.memoji.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.yoojieun.memoji.R;
import com.yoojieun.memoji.models.Memo;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by yoojieun on 2015. 12. 16..
 */
public class MemoAdapter extends RealmBaseAdapter<Memo> implements ListAdapter {

    public MemoAdapter(Context context, int resId,
                     RealmResults<Memo> realmResults,
                     boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cell_memo_list,
                    parent, false);
        }

        Memo item = realmResults.get(position);

        TextView tvSubject = (TextView) convertView.findViewById(R.id.title_row_memo);
        tvSubject.setText(item.getTitle());

        return convertView;
    }

    public RealmResults<Memo> getRealmResults() {
        return realmResults;
    }
}
