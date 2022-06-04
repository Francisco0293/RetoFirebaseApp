package mx.edu.itm.link.retofirebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference

        myRef.child("movies").child("movie_id_1").setValue(Movie("RoboCop",1987,"tt4154796","movie","https://m.media-amazon.com/images/I/51eMgInMe5L._AC_.jpg","US","Ciencia_ficción"))
        myRef.child("movies").child("movie_id_2").setValue(Movie("Back to the Future",1985,"tt5128214","movie","https://m.media-amazon.com/images/I/71BPuv+iRbL._AC_SY741_.jpg","US","Aventura,Ciencia_ficción"))
        myRef.child("movies").child("movie_id_3").setValue(Movie("Señor Chocolate",2016,"tt5831474","movie","https://nuevaerafilms.com/wp-content/uploads/2016/11/287-Sr-Chocolate-Poster-21x30-300dpi-2.jpg","France","Biografía,Drama"))
        myRef.child("movies").child("movie_id_4").setValue(Movie("Wallace & Gromit: The Curse of the Were-Rabbit",2005,"tt7382548","movie","https://static.wikia.nocookie.net/cine/images/1/13/Wallace_%26_Gromit_US_Poster.jpg/revision/latest?cb=20210224212422","UK","Animación,Comedia,Aventura"))

        myRef.child("movies").child("movie_id_4").get().addOnSuccessListener { response ->
            //TODO value
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener {
            Log.e("firebaseResponse","Error getting data", it)
        }
    }
}