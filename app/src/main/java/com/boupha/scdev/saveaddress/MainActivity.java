package com.boupha.scdev.saveaddress;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends TabActivity {
    List<GGD> model = new ArrayList<>();
    ArrayAdapter<GGD> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner listView = (Spinner)findViewById(R.id.listView);
        adapter = new ArrayAdapter<GGD>(getApplicationContext(),android.R.layout.simple_list_item_1,model);
        listView.setAdapter(adapter);

        Button button = (Button)findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText)findViewById(R.id.edite);
                GGD d = new GGD();
                d.setName(name.getText().toString());
                adapter.add(d);
            }

        });
//------------------------------------------------------------------
        TabHost.TabSpec spec = getTabHost().newTabSpec("tag1");
        spec.setContent(R.id.editpage);
        spec.setIndicator("Save Name");

        getTabHost().addTab(spec);

        spec = getTabHost().newTabSpec("tag2");
        spec.setIndicator("List Name");
        spec.setContent(R.id.showpage);

        getTabHost().addTab(spec);

        getTabHost().setCurrentTab(0);
    }
}
