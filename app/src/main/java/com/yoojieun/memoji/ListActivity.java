package com.yoojieun.memoji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.yoojieun.memoji.adapters.MemoAdapter;
import com.yoojieun.memoji.models.Memo;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by yoojieun on 2015. 12. 4..
 */
public class ListActivity extends Activity{

    private ListView memoList;
    private Button newMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list);

        memoList = (ListView)findViewById(R.id.memolist);
        newMemo = (Button)findViewById(R.id.newmemo);

        Realm realm = Realm.getInstance(this);
        RealmResults<Memo> memos = realm.where(Memo.class)
                                 .findAll();

        MemoAdapter adapter = new MemoAdapter(this,R.layout.cell_memo_list,memos,true);
        memoList.setAdapter(adapter);

        newMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
