package com.example.ang.listdemo;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private List<LibraryItems> myItems = new ArrayList<LibraryItems>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateList();
        populateListView();

    }


    //need to find a way to grab these items from the database
    private void populateList()
    {
        myItems.add(new LibraryItems("Title1", "Author1", 01, "Type1"));
        myItems.add(new LibraryItems("Title2", "Author2", 02, "Type2"));
        myItems.add(new LibraryItems("Title3", "Author3", 03, "Type3"));
    }

    private void populateListView(){
        ArrayAdapter<LibraryItems> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.itemsListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<LibraryItems>{
        public MyListAdapter(){
            super(MainActivity.this, R.layout.item_layout, myItems);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //make sure we have a view to work with
            View itemView = convertView;
            if (itemView ==null) {
                itemView = getLayoutInflater().inflate(R.layout.item_layout, parent, false);
            }

            //Find the item to work with
            LibraryItems currentLibraryItem = myItems.get(position);

            //fill the view

            //if you want an icon image:
            // ImageView imageview = (ImageView) itemView.findViewById(R.id.item_icon);
            // imageview.setImageResource(currentLibraryItem.getIconID());

            //Name
            TextView nameText = (TextView) itemView.findViewById(R.id.item_name);
            nameText.setText(currentLibraryItem.getItem_name());

            //Artist/Author
            TextView artistText = (TextView) itemView.findViewById(R.id.item_artist);
            artistText.setText(currentLibraryItem.getAuthor_name());

            //Type
            TextView typeText = (TextView) itemView.findViewById(R.id.item_type2);
            typeText.setText(currentLibraryItem.getType());

            return itemView;
        }

    }
    //when an item is clicked...what do you want it to do?
    private void registerClickCallBack(){
        ListView list = (ListView) findViewById(R.id.itemsListView);
    }

}
//Considerations:
//style - match main design
//database - tie-in to database for list of items
//what to do on click?
