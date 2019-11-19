package com.tiber.helloworldatelier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class Week4RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week4_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyCustomAdapter(getList()));
    }

    private List<Person> getList(){
        List<Person> names = new ArrayList<>();
        names.add(new Person("Cosmin", "Andrei"));
        names.add(new Person("Andreea", "Popescu"));
        names.add(new Person("Catalin", "Antonescu"));
        names.add(new Person("Ionela", "Visinescu"));
        names.add(new Person("Petru", "Andries"));
        names.add(new Person("Alin","Alin"));
        names.add(new Person("Alina", "Alin"));
        names.add(new Person("Lucia","Alin"));
        names.add(new Person("Dorin", "Alin"));
        names.add(new Person("Daniel","Alin"));
        names.add(new Person("George","Alin"));
        return names;
    }

    /*1. Add (app)build.gradle dependency - implementation "androidx.RecyclerView..."
      2. Add RecyclerView item in XML layout file
      3. Create RecyclerView item XML layout file
      4. Create RecyclerView object in activity and instantiate it with findViewById()
      5. Create private static class MyCustomAdapter extends RecyclerView.Adapter and implement methods
      6. Create private static class MyCustomViewHolder extends RecyclerView.ViewHolder and create constructor matching super
      7. In MyCustomViewHolder create objects for every item in the recyclerView item XML layout and find them by id's
      8. In MyCustomAdapter getItemCount() - return list.size()
    */

    private static class MyCustomAdapter extends RecyclerView.Adapter<MyCustomViewHolder>{

        final List<Person> items;

        MyCustomAdapter(List<Person> items){
            this.items = items;
        }

        @NonNull
        @Override
        public MyCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            View view  = LayoutInflater.from(context)
                    .inflate(R.layout.recycler_view_item,
                            parent,
                            false);
            return new MyCustomViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull MyCustomViewHolder holder, int position) {
            Person item  = items.get(position);

            holder.text_firstName.setText(item.getFirstName());
            holder.text_lastName.setText(item.getLastName());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

    }

    private static class MyCustomViewHolder extends RecyclerView.ViewHolder{

        TextView text_firstName, text_lastName;
        public MyCustomViewHolder(@NonNull View itemView) {
            super(itemView);
            text_firstName = itemView.findViewById(R.id.text_first_name);
            text_lastName = itemView.findViewById(R.id.text_last_name);
        }
    }
}
