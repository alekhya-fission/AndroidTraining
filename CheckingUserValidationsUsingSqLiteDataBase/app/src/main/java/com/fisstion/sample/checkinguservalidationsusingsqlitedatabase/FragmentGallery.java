package com.fisstion.sample.checkinguservalidationsusingsqlitedatabase;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by alekhya on 6/6/16.
 */
public class FragmentGallery extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    GridView mGridView;
    SimpleCursorAdapter mAdapter;
    public FragmentGallery() {

    }

    public static FragmentGallery newInstance() {
        FragmentGallery fragment = new FragmentGallery();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View galleryView = inflater.inflate(R.layout.fragment_gallery, container, false);
        mGridView = (GridView) galleryView.findViewById(R.id.gridview);
        mAdapter = new SimpleCursorAdapter(
                getActivity(),
                R.layout.imageitem,
                null,
                new String[]{"_data", "_id"},
                new int[]{R.id.img},
                0
        );
        mGridView.setAdapter(mAdapter);
        /** Loader to get images from the SD Card */
        getLoaderManager().initLoader(0, null, this);

        /** Defining item click listener for the grid view */

        return galleryView;
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri uri = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
        return new CursorLoader(getActivity(),uri,null,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {
        mAdapter.swapCursor(arg1);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
