package com.example.examen.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.Modelos.Opcion;
import com.example.examen.R;

import java.util.List;

public class AdapterOpciones extends RecyclerView.Adapter<AdapterOpciones.ViewHolder> implements View.OnClickListener {

    //LISTA
    private List<Opcion> Lista;
    //ONCLICK
    private View.OnClickListener listener;

    public AdapterOpciones(List<Opcion> lista) {
        Lista = lista;
    }


    @NonNull
    @Override
    public AdapterOpciones.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.disenorv, null, false);
        //ONCLICK
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterOpciones.ViewHolder holder, int position) {
        Opcion opc = Lista.get(position);
        holder.bind(opc);
    }

    @Override
    public int getItemCount() {
        return Lista.size();
    }

    //MÉTODO ONCLICK
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Nombre;
        //Opcion Accion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre=itemView.findViewById(R.id.txt1);
        }

        public void bind(Opcion opc) {
            Nombre.setText(opc.getNombre());
        }
    }
}
