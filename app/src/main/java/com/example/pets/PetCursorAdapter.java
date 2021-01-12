package com.example.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.pets.data.PetContract;

public class PetCursorAdapter extends CursorAdapter {
    /**
     * Constructs a new {@link PetCursorAdapter}.
     */
    public PetCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0 /* flags */);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView nameView = view.findViewById(R.id.name);
        TextView summaryView = view.findViewById(R.id.summary);

        // Extract properties from cursor
        String name = cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME));
        String breed = cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED));

        // Populate fields with extracted properties
        nameView.setText(name);
        summaryView.setText(breed);
    }
}
