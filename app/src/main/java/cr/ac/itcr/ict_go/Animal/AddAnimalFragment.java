package cr.ac.itcr.ict_go.Animal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cr.ac.itcr.ict_go.DBManager.DBDataSource;
import cr.ac.itcr.ict_go.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddAnimalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddAnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddAnimalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddAnimalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddAnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddAnimalFragment newInstance(String param1, String param2) {
        AddAnimalFragment fragment = new AddAnimalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private DBDataSource dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSource = new DBDataSource(getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_add_animal, container, false);
        final TextView txtNameAnimal = (TextView) inflatedView.findViewById(R.id.txtNameAnimal);
        final TextView txtScientificName = (TextView) inflatedView.findViewById(R.id.txtScientificName);
        final TextView txtDescription = (TextView) inflatedView.findViewById(R.id.txtDescription);
        final TextView txtNameImg = (TextView) inflatedView.findViewById(R.id.txtNameImg);

        Button registerButton = (Button) inflatedView.findViewById(R.id.btnAddAnimal);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNameAnimal.getText().toString() != "" && txtScientificName.getText().toString() != "" && txtDescription.getText().toString() != "") {
                    dataSource.insertRecord("Animals", txtNameAnimal.getText().toString(), txtScientificName.getText().toString(), txtDescription.getText().toString(), txtNameImg.getText().toString());
                    Toast t = Toast.makeText(getActivity().getApplicationContext(), "The animal has been added", Toast.LENGTH_SHORT);
                    t.show();
                } else {
                    Toast t = Toast.makeText(getActivity().getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });
        return inflatedView;
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
