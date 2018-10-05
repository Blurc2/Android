package com.example.ri1.ejerciciojorge;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserIn.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserIn extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public UserIn() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserIn.
     */
    // TODO: Rename and change types and number of parameters
    public static UserIn newInstance(String param1, String param2) {
        UserIn fragment = new UserIn();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    UsuariosSQLiteHelper usdbh =
            new UsuariosSQLiteHelper(getActivity(), "DBUsuarios", null, 1);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_user_in, container, false);
        Button ins=(Button)rootview.findViewById(R.id.Insertar);
        final EditText id=(EditText)rootview.findViewById(R.id.ID);
        final EditText nombre=(EditText)rootview.findViewById(R.id.Nombre);;
        final EditText edad=(EditText)rootview.findViewById(R.id.Edad);;
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SQLiteDatabase db = usdbh.getWritableDatabase();

                //Si hemos abierto correctamente la base de datos
                if(db != null)
                {
                    Person p = new Person(nombre.getText().toString(), edad.getText().toString()+" años", R.drawable.common_google_signin_btn_icon_light_normal, Integer.parseInt(id.getText().toString()));
                    //long rowID = db.insert("Personas", null, clienteMapperContentValues(p));
                    //Cerramos la base de datos
                    db.close();
                    Toast.makeText(getActivity(),p.toString(),Toast.LENGTH_SHORT).show();
                    //Recycler.adapter.agregar(new Person(nombre.getText().toString(), edad.getText().toString()+" años", R.drawable.common_google_signin_btn_icon_light_normal, Integer.parseInt(id.getText().toString())));
                    //Recycler.adapter.notifyDataSetChanged();
                }
            }
        });
        // Inflate the layout for this fragment
        return rootview;
    }

    private ContentValues clienteMapperContentValues(Person cliente) {
        ContentValues cv = new ContentValues();
        cv.put("id", cliente.ID);
        cv.put("nombre", cliente.name);
        cv.put("edad", cliente.age);
        return cv;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
