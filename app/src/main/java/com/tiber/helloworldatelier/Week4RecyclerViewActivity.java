package com.tiber.helloworldatelier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        MyCustomAdapter adapter = new MyCustomAdapter(getList());
        recyclerView.setAdapter(adapter);
        adapter.addPerson(new Person("Vasile", "Vasile"));
    }

    private List<Person> getList() {
        List<Person> names = new ArrayList<>();
        names.add(new Person("Cosmin", "Andrei"));
        names.add(new Person("Andreea", "Popescu"));
        names.add(new Person("Catalin", "Antonescu"));
        names.add(new Person("Ionela", "Visinescu"));
        names.add(new Person("Petru", "Andries"));
        names.add(new Person("Alin", "Alin"));
        names.add(new Person("Alina", "Alin"));
        names.add(new Person("Lucia", "Alin"));
        names.add(new Person("Dorin", "Alin"));
        names.add(new Person("Daniel", "Alin"));
        names.add(new Person("George", "Alin"));
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

    /*
     * 1. Adaugam dependenta Gradle pentru RecyclerView
     * 2. Adaugam RecyclerView in XML aferent activitatii
     * 3. Cream XML layout pentru item din RecyclerView
     * 4. In JAVA, generam lista de obiecte pe care vrem sa o folosim
     * 5. Cream un obiect recyclerView, il asignam widget-ului
     * 6. cream 2 private static class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>
     *    si CustomViewHolder extends RecyclerView.ViewHolder
     * 7. In CustomViewHolder generam constructorul si atributele ce urmeaza sa fie initializate din RV
     * 8. In CustomAdapter implementam metodele @Override onCreateVH onBindVH si getItemCount
     *    pe care le folosim dupa cum urmeaza:
     *  a. onCreateViewHolder() - returnam un nou CustomViewHolder(view) dand ca parametru metoda
     *          LayoutInflater.from(parent.getContext()).inflate(R.layout.res_name, parent, false));
     *  b. onBindViewHolder()  - atribuim valorile tuturor elementelor din holder / setam evenimentele
     *          pentru fiecare item(holder) in parte
     *  c. getItemCount() returneaza lungimea listei de obiecte pe care le afisam
     *  d. (OPTIONAL) cream un constructor parametrizat, care primeste ca parametru
     *          lista de obiecte ce urmeaza a fi afisata
     *
     * 9. in onCreate()/onResume()/etc initializam un RecyclerView.LayoutManager layoutManager =
     *                                                  new LinearLayoutManager(this);
     * 10. setam LayoutManager-ul pe obiectul recyclerView;
     * 11. cream un nou obiect CustomAdapter adapter = new CustomAdapter(list);
     * */
    private static class MyCustomAdapter extends RecyclerView.Adapter<MyCustomViewHolder> {

        final List<Person> items;

        MyCustomAdapter(List<Person> items) {
            this.items = items;
        }

        public void addPerson(Person person) {
            items.add(person);
            notifyDataSetChanged();

            notifyItemChanged(items.size() - 1);
        }

        @NonNull
        @Override
        public MyCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyCustomViewHolder(LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.recycler_view_item,
                            parent, false));

        }

        @Override
        public void onBindViewHolder(@NonNull MyCustomViewHolder holder, final int position) {
            final Person item = items.get(position);

            holder.text_firstName.setText(item.getFirstName());
            holder.text_lastName.setText(item.getLastName());
            holder.recyclerViewItemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    items.add(item);
                    notifyDataSetChanged();
                    Toast.makeText(
                            v.getContext(),
                            "Item " + (position + 1) + " added again",
                            Toast.LENGTH_SHORT).show();
                }
            });
            holder.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    items.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(
                            v.getContext(),
                            "Item " + (position + 1) + " removed",
                            Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return items.size();
        }

    }

    private static class MyCustomViewHolder extends RecyclerView.ViewHolder {

        TextView text_firstName, text_lastName;
        Button remove;
        View recyclerViewItemLayout;

        public MyCustomViewHolder(@NonNull View itemView) {
            super(itemView);
            text_firstName = itemView.findViewById(R.id.text_first_name);
            text_lastName = itemView.findViewById(R.id.text_last_name);
            remove = itemView.findViewById(R.id.btn_remove_item);
            recyclerViewItemLayout = itemView.findViewById(R.id.recycler_view_item_layout);
        }
    }
}
