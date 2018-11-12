package com.androiddesdecero.toolbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 12/11/18.
 */

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.CursoViewHolder> implements Filterable {

    private List<Curso> cursos;
    private List<Curso> listaCursosCompleta;

    public CursoAdapter(List<Curso> cursos){
        this.cursos = cursos;
        listaCursosCompleta = new ArrayList<>(cursos);
    }

    @Override
    public CursoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CursoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_curso, parent, false));
    }

    @Override
    public void onBindViewHolder(CursoViewHolder holder, int position) {
        Curso curso = cursos.get(position);
        holder.tvCurso.setText(curso.getNombreCurso());
        holder.tvProfesor.setText(curso.getProfesor());
    }

    @Override
    public int getItemCount() {
        return cursos.size();
    }

    @Override
    public Filter getFilter() {
        return listaCursosFiltrada;
    }

    private Filter listaCursosFiltrada = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Curso> listaFiltradadeCursos = new ArrayList<>();
            if(charSequence == null || charSequence.length() == 0){
                listaFiltradadeCursos.addAll(listaCursosCompleta);
            }else {
                String filterPatter = charSequence.toString().toLowerCase().trim();
                for(Curso curso:listaCursosCompleta){
                    if(curso.getNombreCurso().toLowerCase().contains(filterPatter)){
                        listaFiltradadeCursos.add(curso);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = listaFiltradadeCursos;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            cursos.clear();
            cursos.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };


    public class CursoViewHolder extends RecyclerView.ViewHolder{
        private TextView tvProfesor;
        private TextView tvCurso;

        public CursoViewHolder(View itemView){
            super(itemView);
            tvProfesor = itemView.findViewById(R.id.tvProfesor);
            tvCurso = itemView.findViewById(R.id.tvCurso);
        }
    }
}
