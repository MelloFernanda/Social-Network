import java.util.ArrayList;
import java.util.List;

public class SocialNetTest {
    public static void main(String[] args) {

        SocialNetwork rede = new SocialNetwork ();

        rede.addUser (new User ("u1","Vicent Vega") );
        rede.addUser (new User ("u2","Mia Wallace") );
        rede.addUser (new User ( "u3","Jules Winnfield") );
        rede.addUser (new User ( "u4","Marsellus Wallace") );

// adiciona uma amizade, dado dois user ids
        rede.addFriendly ("u1", "u2");
        rede.addFriendly ("u1", "u3");
        rede.addFriendly ("u2", "u4");

// adiciona um pos relacionado a um usuário
        rede.addPost ("u1", new Post ("p1", "Tomando cafe"));
        rede.addPost ("u2",new Post ("p2", "amizade é tudo de bom ") );
        rede.addPost ("u2", new Post ("p3", "passeando com meu cachorro"));
        rede.addPost ("u1", new Post ("p4", "Nao tomei cafe hj"));

// um usuario (u3) adicionado um comentario ao post p3 do usuario u2
        rede.addComment ("u3", "u1", "p1", new Comment ("c1",
                "Com pão de queijo ? tudo di bão") );
        rede.addComment ("u3", "u1", "p1", new Comment ("c2",
                "De manha cedinho eh melhor ainda") );
// um usuario u4, curtiu o post p2, do usuario u2
        rede.liked ("u4", "u2", "p2");

// imprime todos os post, por usuario, e os comentarios de cada post
        rede.printUpdates();
    }

}
