
import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.a12_sqlite.AgregarContacto
import com.example.a12_sqlite.EmailActivity
import com.example.a12_sqlite.R


class ListAdapter(val context: Activity,
                  val ids: Array<String?>,
                  val Nombres: Array<String?>,
                  val Apellidos: Array<String?>,
                  val eMails: Array<String?>,
                  val Celulares: Array<String?>): ArrayAdapter<String?>(context,
    R.layout.activity_complex_list, ids){
    private lateinit var db: DBAdapter


    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView: View = inflater.inflate(R.layout.multidata, null, true)

        val txtId = rowView.findViewById<View>(R.id.txtid) as TextView
        val txtNombre = rowView.findViewById<View>(R.id.txtNombre) as TextView
        val txtAppellidos = rowView.findViewById<View>(R.id.txtApellidos) as TextView
        val txtEmail = rowView.findViewById<View>(R.id.txtEmail) as TextView
        val txtCelular = rowView.findViewById<View>(R.id.txtCelular) as TextView
        val btnEditar = rowView.findViewById<View>(R.id.btnEditar) as Button
        val btnBorrar = rowView.findViewById<View>(R.id.btnBorrar) as Button


        txtId.text = ids[position]
        txtNombre.text = Nombres[position]
        txtAppellidos.text = Apellidos[position]
        txtEmail.text = eMails[position]
        txtCelular.text = Celulares[position]

        txtCelular.setOnClickListener {
            call(Celulares[position]!!)
        }

        txtEmail.setOnClickListener {
            email(eMails[position]!!)
        }

        btnEditar.setOnClickListener {
            btnEditar.setOnClickListener {
                val contactIdStr = ids[position]
                if (!contactIdStr.isNullOrEmpty()) {
                    val contactId = contactIdStr.toLong()
                    editarContacto(contactId)
                } else {
                    showToast("No se pudo editar el contacto")
                }
            }

        }

        btnBorrar.setOnClickListener {
            showToast("Apretaste el botón")
        }



        return rowView
    }

    fun call(celular: String){
        context.startActivity(Intent(ACTION_CALL, Uri.parse("tel:$celular")))
    }

    fun email(email: String){
        val laotra = Intent(context, EmailActivity::class.java)
        laotra.putExtra("emailDestino", email)
        context.startActivity(laotra)
    }

    fun editarContacto(contactId: Long) {
        val nombre = "Nombre del contacto"
        val apellidos = "Apellidos del contacto"
        val correo = "correo@ejemplo.com"
        val celular = "1234567890"

        val intent = Intent(context, AgregarContacto::class.java)
        intent.putExtra("contactId", contactId)
        intent.putExtra("nombre", nombre)
        intent.putExtra("apellidos", apellidos)
        intent.putExtra("correo", correo)
        intent.putExtra("celular", celular)

        context.startActivity(intent)
    }


    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}