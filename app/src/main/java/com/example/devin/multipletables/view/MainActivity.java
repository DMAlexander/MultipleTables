package com.example.devin.multipletables.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.devin.multipletables.R;
import com.example.devin.multipletables.database.DatabaseHelper;
import com.example.devin.multipletables.database.model.Tag;
import com.example.devin.multipletables.database.model.Todo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(getApplicationContext());

        //Creating tags
        Tag tag1 = new Tag("Shooping");
        Tag tag2 = new Tag("Important");
        Tag tag3 = new Tag("Watchlist");
        Tag tag4 = new Tag("Androidhive");

        //Inserting tags in db
        long tag1_id = db.createTag(tag1);
        long tag2_id = db.createTag(tag2);
        long tag3_id = db.createTag(tag3);
        long tag4_id = db.createTag(tag4);

        Log.d("Tag Count", "Tag count: " + db.getAllTags().size());

        //Creating ToDos:
        Todo todo1 = new Todo("iPhone 55", 0);
        Todo todo2 = new Todo("Galaxy Note 11", 0);
        Todo todo3 = new Todo("Whiteboard", 0);
        Todo todo4 = new Todo("Riddick", 0);
        Todo todo5 = new Todo("Prisoners", 0);
        Todo todo6 = new Todo("The Croods", 0);
        Todo todo7 = new Todo("Insidious chapter2", 0);
        Todo todo8 = new Todo("don't forget to call mom", 0);
        Todo todo9 = new Todo("collect money from John", 0);
        Todo todo10 = new Todo("Post new article", 0);
        Todo todo11 = new Todo("take database backup", 0);

        long todo1_id = db.createToDo(todo1, new long[] { tag1_id });
        long todo2_id = db.createToDo(todo1, new long[] { tag1_id });
        long todo3_id = db.createToDo(todo1, new long[] { tag1_id });

        long todo4_id = db.createToDo(todo1, new long[] { tag3_id });
        long todo5_id = db.createToDo(todo1, new long[] { tag3_id });
        long todo6_id = db.createToDo(todo1, new long[] { tag3_id });
        long todo7_id = db.createToDo(todo1, new long[] { tag3_id });

        long todo8_id = db.createToDo(todo1, new long[] { tag2_id });
        long todo9_id = db.createToDo(todo1, new long[] { tag2_id });

        long todo10_id = db.createToDo(todo1, new long[] { tag4_id });
        long todo11_id = db.createToDo(todo1, new long[] { tag4_id });

        Log.e("Todo Count", "Todo Count: " + db.getToDoCount());

        db.createTodoTag(todo10_id, tag2_id);
        //Getting all tag names
        Log.d("Get Tags", "Getting All Tags");

        List<Tag> allTags = db.getAllTags();
        for (Tag tag : allTags) {
            Log.d("Tag name", tag.getTagName());
        }

        //Getting all Todos
        Log.d("Get Todos", "Getting all ToDos");

        List<Todo> allToDos = db.getAllToDos();
        for (Todo todo : allToDos) {
            Log.d("ToDo", todo.getNote());
        }

        //Getting todos under "watchlist" tag name
        Log.d("ToDo", "Get todos under single tag name");

        List<Todo> tagsWatchList = db.getAllToDosByTag(tag3.getTagName());
        for (Todo todo : tagsWatchList) {
            Log.d("ToDo Watchlist", todo.getNote());
        }
        //Deleting a todo
        Log.d("Delete ToDo", "Deleting a Todo");
        Log.d("Tag Count", "Tag Count Before Deleting: " + db.getToDoCount());

        db.deleteToDo(todo8_id);

        Log.d("Tag Count", "Tag Count After Deleting : " + db.getToDoCount());

        //Deleting all Todos under "shopping" tag
        Log.d("Tag Count",
                "Tag Count before Deleting 'shopping' Todos: "
                        + db.getToDoCount());

        db.deleteTag(tag1, true);

        Log.d("Tag Count",
                "Tag Count After Deleting 'Shopping' Todos: "
                        + db.getToDoCount());

        //updating tag name
        tag3.setTagName("Movies to watch");
        db.updateTag(tag3);

        //Don't forget to close database connection
        db.closeDB();

    }
}
