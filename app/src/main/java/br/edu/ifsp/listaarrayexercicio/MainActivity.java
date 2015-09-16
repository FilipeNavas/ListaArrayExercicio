package br.edu.ifsp.listaarrayexercicio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Produto;

public class MainActivity extends AppCompatActivity {

    //Cliente
    EditText edtNome;
    EditText edtCpf;
    EditText edtEmail;
    EditText edtTelefone;

    //Produto
    EditText edtIdProduto;
    EditText edtNomeProduto;
    EditText edtValorProduto;

    //Cria uma lista de pedidos
    List<Produto> listaProduto;

    //ListView
    ListView lvProdutos;

    //Variavel do Total
    Double total = 0.0;

    //Elemento texto do total
    TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cliente
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtCpf = (EditText) findViewById(R.id.edtCpf);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);

        //Produto
        //edtIdProduto = (EditText) findViewById(R.id.edtIdProduto);
        edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        edtValorProduto = (EditText) findViewById(R.id.edtValorProduto);

        //Instancia um ArrayList
        listaProduto = new ArrayList<Produto>();

        lvProdutos = (ListView) findViewById(R.id.listViewProdutosPedido);

        txtTotal = (TextView) findViewById(R.id.txtTotal);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Cliente
    public void cadastrarCliente(View v){

        try{

            String nome = edtNome.getText().toString();
            String cpf = edtCpf.getText().toString();
            String email = edtEmail.getText().toString();
            String telefone = edtTelefone.getText().toString();

            Cliente cliente = new Cliente();

            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);

            Toast.makeText(this,cliente.getNome(),Toast.LENGTH_LONG).show();;

        }catch(Error e){
            Toast.makeText(this,"Houve um erro. " + e.getMessage(),Toast.LENGTH_LONG).show();;
        }

    }

    //Produto
    public void cadastrarProduto(View v){

        try{

            //int id = Integer.parseInt(edtIdProduto.getText().toString());
            String nome = edtNomeProduto.getText().toString();
            Double valor = Double.parseDouble(edtValorProduto.getText().toString());

            Produto produto = new Produto();

            //produto.setId(id);
            produto.setNome(nome);
            produto.setValor(valor);

            //Adiciona o Produto na Lista
            listaProduto.add(produto);

            //Adiciona o valor ao total
            total = total + valor;

            //Chama o metodo que atualiza o ListView
            atualizarLista();

            Toast.makeText(this,produto.getNome(),Toast.LENGTH_LONG).show();;

        }catch(Error e){
            Toast.makeText(this,"Houve um erro. " + e.getMessage(),Toast.LENGTH_LONG).show();;
        }

    }

    //Metodo que atualiza a lista
    //Ele instancia um ListAdapter passando o contexto da aplicacao e a lista.
    //Depois ele joga no ListView o Adapter
    private void atualizarLista() {
        ProdutoListAdapter pla = new ProdutoListAdapter(getApplicationContext(), listaProduto);
        lvProdutos.setAdapter(pla);

        //Joga o valor no TextView
        txtTotal.setText(String.valueOf(total));


    }

    private AdapterView.OnItemClickListener selecionarProduto = new AdapterView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long id) {
            Produto produto = listaProduto.get(pos);
            preecherDados(produto);

        }

        private void preecherDados(Produto produto) {
            edtNomeProduto.setText(produto.getNome());
            edtValorProduto.setText(String.valueOf(produto.getValor()));
        }

    };
}
