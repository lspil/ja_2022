package main;

public class Exemplu4 {

    public static void main(String[] args) {
        String s1 = """
                HELLO
                WORLD
                !
                """;

        String s3 = "SELECT * FROM Clients c, Products p" +
                " WHERE c.client_id = p.client_id" +
                " ORDER BY p.value";

        String s2 = """
                SELECT * FROM Clients c, Products p
                WHERE c.client_id = p.client_id
                ORDER BY p.value
                """;


    }
}
