/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamongo501;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.text.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author yazmi
 */
public class Conexion {
    
    public static void main(String[] args) {
       

      ConnectionString connectionString = new ConnectionString("mongodb+srv://yazmin:123456a0@yazmin.2hdnbyt.mongodb.net/?retryWrites=true&w=majority");
MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .build();
MongoClient mongoClient = (MongoClient) MongoClients.create(settings);
MongoDatabase database = mongoClient.getDatabase("mongo_BTS");

   
        MongoCollection col = database.getCollection("integrantes");
        Document doc;
        doc = new Documnt("_id", "1").append("nombre", "suga");
        col.find();
        col.insertOne(doc);
        col.deleteOne((Bson) doc);
        col.updateOne(bson, bson1);
}
      public static void insertarUsuario(DB db, String coleccion, String nombre, String pais) {
        DBCollection colec = db.getCollection(coleccion);
        
      
        BasicDBObject documento = new BasicDBObject();
        documento.put("nombre", nombre);
        documento.put("pais", pais);
        
        colec.insert(documento);
        
    }
    
    public static void mostrarColeccion(DB db, String coleccion) {
        DBCollection colec = db.getCollection(coleccion);
     
        DBCursor cursor = colec.find();
        
        while(cursor.hasNext()) {
             System.out.println(cursor.next());
            
        }
    }
    
    public static void buscarPorNombre(DB db, String coleccion, String nombre) {
        DBCollection colect = db.getCollection(coleccion);
        
       
        BasicDBObject consulta = new BasicDBObject();
        consulta.put("nombre", nombre);
        
    
        DBCursor cursor = colect.find(consulta);
        while(cursor.hasNext()) {
            System.out.println("-- " + cursor.next().get("nombre") + " - " + cursor.curr().get("nombre art"));
        }
    }
    
  
    public static void actualizarDocumento(DB db, String coleccion, String nombre) {
        DBCollection colec = db.getCollection(coleccion);
        
        
        BasicDBObject actualizarColor = new BasicDBObject();
        actualizarColor.append("$set", new BasicDBObject().append("colorFavorito", "negro"));
        
      
        BasicDBObject buscarPorNombre = new BasicDBObject();
        buscarPorNombre.append("nombre", nombre);
        
     
        colec.updateMulti(buscarPorNombre, actualizarColor);
    }
    
    public static void borrarDocumento(DB db, String coleccion, String nombre) {
        DBCollection colec = db.getCollection(coleccion);
        
        colec.remove(new BasicDBObject().append("color", nombre));
    }

    private static class Documnt {

        public Documnt(String _id, String string) {
        }
    }
}
 