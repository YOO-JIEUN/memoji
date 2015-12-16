package com.yoojieun.memoji;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.yoojieun.memoji.adapters.MemoAdapter;

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

        MemoAdapter adapter = new MemoAdapter(this,);
    }
}
