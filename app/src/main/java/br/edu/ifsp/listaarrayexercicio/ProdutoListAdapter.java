package br.edu.ifsp.listaarrayexercicio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import model.Produto;

/**
 * Created by Filipe on 2015-09-04.
 */
public class ProdutoListAdapter extends BaseAdapter {

    private Context context;
    private List<Produto> lista;

    public ProdutoListAdapter(Context applicationContext, List<Produto> listaProduto) {
        this.context = applicationContext;
        this.lista = listaProduto;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Produto p = lista.get(i);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewInflate = inflater.inflate(R.layout.produtos, null);

        TextView nome = (TextView) viewInflate.findViewById(R.id.txtNomeProd);
        nome.setText(p.getNome());

        TextView valor = (TextView) viewInflate.findViewById(R.id.txtValorProd);
        valor.setText(String.valueOf(p.getValor()));

        return viewInflate;

    }
}
