package cr.ac.itcr.ict_go;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cr.ac.itcr.ict_go.Animal.ManageAnimalActivity;
import cr.ac.itcr.ict_go.DBManager.DBDataSource;
import cr.ac.itcr.ict_go.Entity.Animal;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListAnimalsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListAnimalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListAnimalsFragment extends Fragment {

    Adapter adapter;
    DBDataSource dataSource;


    public ArrayList<Animal> getAllAnimals(){
        Cursor cursor = dataSource.getAllRecords("Animals");
        ArrayList<Animal> animals = new ArrayList<>();

        while(cursor.moveToNext()){
            Animal animal = new Animal();
            animal.setId(Integer.parseInt(cursor.getString(0)));
            animal.setName(cursor.getString(1));
            animal.setScientificName(cursor.getString(2));
            animal.setDescription(cursor.getString(3));
            animal.setIdImg(cursor.getString(4));
            animals.add(animal);
            String id = cursor.getString(0);
            Log.d("Animal id", id);

            String body = cursor.getString(1);
            Log.d("Animal nombre", body);

            body = cursor.getString(2);
            Log.d("Animal nombre cientific", body);

            body = cursor.getString(3);
            Log.d("Animal descripcion", body);

            body = cursor.getString(4);
            Log.d("Animal imagen", body);
        }
        return animals;
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ListAnimalsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListAnimalsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListAnimalsFragment newInstance(String param1, String param2) {
        ListAnimalsFragment fragment = new ListAnimalsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSource = new DBDataSource(getActivity().getApplicationContext());

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list_animals, container, false);
        Toast t = Toast.makeText(getActivity().getApplicationContext(), "Tap an item to manage it", Toast.LENGTH_SHORT);
        t.show();
        final ListView lista = (ListView) view.findViewById(R.id.lvAnimals );
        adapter = new Adapter(getActivity().getApplicationContext(),getAllAnimals());
        lista.setAdapter(adapter);

        lista.setClickable(true);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Log.d("item", String.valueOf(position));
                Object o = lista.getItemAtPosition(position);
                Animal a = (Animal)o;
                Intent i = new Intent(getActivity().getApplicationContext(),ManageAnimalActivity.class);

                i.putExtra("object", a);
                startActivity(i);
                Log.d("Animal id>", String.valueOf(a.getId()));


                Log.d("Animal nombre>", a.getName());


                Log.d("Animal nombre cientific", a.getScientificName());


                Log.d("Animal descripcion>", a.getDescription());


                Log.d("Animal imagen>", a.getIdImg());

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        dataSource = new DBDataSource(getActivity().getApplicationContext());

        final ListView lista = (ListView) getActivity().findViewById(R.id.lvAnimals );
        adapter = new Adapter(getActivity().getApplicationContext(),getAllAnimals());
        lista.setAdapter(adapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
