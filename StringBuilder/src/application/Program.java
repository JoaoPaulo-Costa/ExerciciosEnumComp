package application;

import entities.Comentario;
import entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

        Comentario c1 = new Comentario("Boa viagem viadu!");
        Comentario c2 = new Comentario("Que locurage brother");

        Post p1 = new Post(sdf.parse("21/06/2021 15:27:09"), "Viajando pro Canadá", "Vou visitar esse lugar incrivel", 12);

        p1.addComentario(c1);
        p1.addComentario(c2);

        Comentario c3 = new Comentario("Boa noite!");
        Comentario c4 = new Comentario("May the Force be with you");

        Post p2 = new Post(sdf.parse("21/06/2021 18:29:54"), "Chegamos no Canadá", "Eu acho que esse país é bem mais legal do que o Brasil pqp.", 69);

        p2.addComentario(c3);
        p2.addComentario(c4);

        System.out.println(p1);

        System.out.println(p2);

    }
}
